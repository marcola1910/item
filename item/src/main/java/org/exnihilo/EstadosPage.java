package org.exnihilo;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.NodoDTO;

public class EstadosPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2180305705839806697L;
	List<NodoDTO> _typeslist;

	public EstadosPage(PageParameters parameters) {
		super(parameters);
		_typeslist = ServiceLocator.getInstance().getEstadosService()
				.getAllEstados();

		// Renderize all the fields inside the form
		add(new EstadosDataFields("estDataFields"));

		add(new Label("loggedUser", UserSession.getInstance().getUsuario().getNombre() ));

		// Call a repeater which lists all Nodes of States
		this.popEstados();
	}

	public void popEstados() {

		ListDataProvider<NodoDTO> listDataProvider = new ListDataProvider<NodoDTO>(
				_typeslist);

		@SuppressWarnings("serial")
		DataView<NodoDTO> dataView = new DataView<NodoDTO>("rows",
				listDataProvider) {
			@Override
			protected void populateItem(Item<NodoDTO> item) {
				NodoDTO type = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getOid()));
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getName()));
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getWorkflow().getName()));

				repeatingView.add( (new Link<NodoDTO>("editLink", item.getModel()) {
					@Override
					public void onClick() {

						// Calls the method which binds the form with the
						// selected State Node from the model
						EstadoForm estForm = (EstadoForm) this.getParent()
								.getParent().getParent().getParent()
								.get("estDataFields").get("estadoForm");
						estForm.clearForm();
						estForm.bindForm((NodoDTO) this.getDefaultModelObject());
					}
				} )  );

				repeatingView.add(new Link<NodoDTO>("deleteLink", item.getModel()) {
					@Override
					public void onClick() {
						// llamada al delete usr service
						try {
							ServiceLocator
									.getInstance()
									.getEstadosService()
									.deleteEstado(
											((NodoDTO) this.getDefaultModelObject())
													.getOid(), ((NodoDTO) this.getDefaultModelObject())
													.getWorkflow().getOid() );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						setResponsePage(EstadosPage.class);
					}
				});

				item.add(repeatingView);
			}
		};
		add(dataView);
	}
}
