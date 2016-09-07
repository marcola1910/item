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
import org.exnihilo.Item.util.ItemTypeDTO;

public class ItenType extends BasePage {

	/**		
	 * 
	 */
	private static final long serialVersionUID = -6516987619031642074L;
	private List<ItemTypeDTO> _typeslist;

	public ItenType(PageParameters parameters) {
		super(parameters);

		_typeslist = ServiceLocator.getInstance().getItemTypeService()
				.getAllItensType();

		this.popTypes();

		add(new TypeDataFields("typDataFields"));

		add(new Label("loggedUser", this.getSession().getAttribute("username")));

	}

	public void popTypes() {
		ListDataProvider<ItemTypeDTO> listDataProvider = new ListDataProvider<ItemTypeDTO>(
				_typeslist);

		@SuppressWarnings("serial")
		DataView<ItemTypeDTO> dataView = new DataView<ItemTypeDTO>("rows",
				listDataProvider) {
			@Override
			protected void populateItem(Item<ItemTypeDTO> item) {
				ItemTypeDTO type = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getTitulo()));
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getDescripcion()));
				repeatingView.add(new Label(repeatingView.newChildId(), type
						.getWorkflow().getName()));

				repeatingView
						.add(new Link<ItemTypeDTO>("Edit", item.getModel()) {
							@Override
							public void onClick() {
								// llamada al metodo que llena el form
								TypeForm usrAdm = (TypeForm) this.getParent()
										.getParent().getParent().getParent()
										.get("typDataFields").get("typeForm");
								usrAdm.bindForm((ItemTypeDTO) this
										.getDefaultModelObject());
							}
						});

				repeatingView.add(new Link<ItemTypeDTO>("Delete", item
						.getModel()) {
					@Override
					public void onClick() {
						// llamada al delete usr service
						ServiceLocator
								.getInstance()
								.getItemTypeService()
								.deleteItemType(
										((ItemTypeDTO) this
												.getDefaultModelObject())
												.getOid());
						setResponsePage(ItenType.class);
					}
				});
				
				item.add(repeatingView);
			}
		};
		add(dataView);
	}
}
