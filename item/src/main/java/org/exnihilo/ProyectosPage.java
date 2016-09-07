/**
 * 
 */
package org.exnihilo;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.ProyectoDTO;

/**
 * @author marcmarinho
 *
 */
public class ProyectosPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3688230422487049480L;
	private List<ProyectoDTO> _proyectoslist = new ArrayList<ProyectoDTO>();

	/**
	 * @param parameters
	 */
	public ProyectosPage(PageParameters parameters) {
		super(parameters);

		_proyectoslist = ServiceLocator.getInstance().getProyectoService()
				.getAllProyects();

		this.popTypes();

		add(new ProyectosDataFields("pryctDataFields"));

		add(new Label("loggedUser", this.getSession().getAttribute("username")));

	}

	public void popTypes() {
		ListDataProvider<ProyectoDTO> listDataProvider = new ListDataProvider<ProyectoDTO>(
				this._proyectoslist);

		@SuppressWarnings("serial")
		DataView<ProyectoDTO> dataView = new DataView<ProyectoDTO>("rows",
				listDataProvider) {
			@Override
			protected void populateItem(Item<ProyectoDTO> item) {
				ProyectoDTO type = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getOid()));
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getNombre()));
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getEquipo().getNombre()));

				repeatingView
						.add(new Link<ProyectoDTO>("Edit", item.getModel()) {
							@Override
							public void onClick() {
								// llamada al metodo que llena el form
								ProyectosForm prtFrom = (ProyectosForm) this
										.getParent().getParent().getParent()
										.getParent().get("pryctDataFields")
										.get("pyctForm");
								prtFrom.bindForm((ProyectoDTO) this
										.getDefaultModelObject());
							}
						});

				repeatingView.add(new Link<ProyectoDTO>("Delete", item
						.getModel()) {
					@Override
					public void onClick() {
						// llamada al delete usr service
						try {
							ServiceLocator
									.getInstance()
									.getProyectoService()
									.deleteProyecto(
											((ProyectoDTO) this
													.getDefaultModelObject())
													.getOid());
						} catch (Exception e) {
							
							e.printStackTrace();
						}

						setResponsePage(ProyectosPage.class);
					}
				});

				item.add(repeatingView);
			}
		};
		add(dataView);
	}

}
