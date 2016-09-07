package org.exnihilo;

import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.ItemDTO;

public class AsignedItens extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4217171795669816890L;
	private List<ItemDTO> lstItem;

	public AsignedItens(PageParameters parameters) {
		super(parameters);

		this.popItem();

		// add(new ItenDataFields("itmDataFields") );

		add(new Label("loggedUser", ((UserSession) this.getSession())
				.getUsuario().getNombre()));

	}

	public void popItem() {
		lstItem = ServiceLocator
				.getInstance()
				.getItemService()
				.getUsersItem(
						((UserSession) this.getSession()).getUsuario().getOid());

		ListDataProvider<ItemDTO> listDataProvider = new ListDataProvider<ItemDTO>(
				this.lstItem);

		@SuppressWarnings("serial")
		DataView<ItemDTO> dataView = new DataView<ItemDTO>("rows",
				listDataProvider) {
			@Override
			protected void populateItem(Item<ItemDTO> pitem) {
				ItemDTO mpitem = pitem.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");

				repeatingView.add(new Label(repeatingView.newChildId(), mpitem
						.getOid()));
				repeatingView.add(new Label(repeatingView.newChildId(), mpitem
						.getFecha()));
				repeatingView.add(new Label(repeatingView.newChildId(), mpitem
						.getTitulo()));
				repeatingView.add(new Label(repeatingView.newChildId(), mpitem
						.getProyecto().getNombre()));

				repeatingView.add(new AjaxLink<ItemDTO>("Edit", pitem
						.getModel()) {
					@Override
					public void onClick(AjaxRequestTarget target) {

						PageParameters param = new PageParameters();
						param.add("itemselected", ((ItemDTO) this.getModel()
								.getObject()).getOid());

						setResponsePage(ItenPage.class, param);

					}
				});

				repeatingView
						.add(new Link<ItemDTO>("Delete", pitem.getModel()) {
							@Override
							public void onClick() {
								try {
									ServiceLocator
											.getInstance()
											.getItemService()
											.deleteItem(
													((ItemDTO) this
															.getDefaultModelObject())
															.getOid());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								setResponsePage(ItenPage.class);
							}
						});

				pitem.add(repeatingView);

			}
		};
		add(dataView);
	}

}
