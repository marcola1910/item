/**
 * 
 */
package org.exnihilo;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.SetModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.ItemDTO;
import org.exnihilo.Item.util.NodoDTO;

/**
 * @author marcmarinho
 *
 */
public class ItenPage extends BasePage {

	/**
	 * La pagina es responsable por contener el datafields que es un panel
	 * y popular los items invocando el datafield y el dataview
	 */
	private static final long serialVersionUID = -2841249629565590539L;
	private List<ItemDTO> lstItem;
	private ItemDTO itmdto;

	/**
	 * como parametros puede recibir el ID del modelo
	 * @param parameters
	 */
	public ItenPage(PageParameters parameters) {
		super(parameters);
		
		this.popItem();
		
		if(parameters.get("itemselected").toString() != null){
			itmdto = (ItemDTO) ServiceLocator.getInstance().getItemService().getItemByID( parameters.get("itemselected").toString() );
			
		}
		add(new ItenDataFields("itmDataFields")  );
		
		if(itmdto != null)
			this.get("itmDataFields").get("itenForm").setDefaultModelObject(itmdto);
		
		
		add(new Label("loggedUser", ((UserSession) this.getSession()).getUsuario().getNombre() ));

		
	}

	public void popItem() {
		lstItem = ServiceLocator.getInstance().getItemService().getAllItems();
		
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
								.getOid() ));
						repeatingView.add(new Label(repeatingView.newChildId(), mpitem
								.getFecha() ));
						repeatingView.add(new Label(repeatingView.newChildId(), mpitem
								.getTitulo() ));
						repeatingView.add(new Label(repeatingView.newChildId(), mpitem
								.getProyecto().getNombre() ));
						
						
						repeatingView.add( new AjaxLink<ItemDTO>("Edit", pitem.getModel() ){
								@Override
								public void onClick(AjaxRequestTarget target) {
									
									ItenForm frmitem = (ItenForm) this.getParent()
											.getParent().getParent().getParent()
											.get("itmDataFields").get("itenForm");
									
									List<NodoDTO> estadoList  = new ArrayList<NodoDTO>();
									
									frmitem.setEstadoList(estadoList); 
					            	
									estadoList = null; 
									
									((ItemDTO) getDefaultModelObject()).setUsuario(((UserSession) this.getSession()).getUsuario());
									
									NodoDTO estado = ServiceLocator.getInstance().getEstadosService()
											.getEstadoByID(((ItemDTO) getDefaultModelObject()).getEstado().getOid(), ((ItemDTO) getDefaultModelObject()).getItemType().getWorkflow().getOid() );
									
									estadoList = estado.getProxEstado();
									
									estadoList.add(estado);
									
									frmitem.getEstadoActual().setDefaultModel(new Model<String>(estado.getName()));
									
									frmitem.setEstadoList( estadoList );
									
									frmitem.drpEstado.setModelObject(estadoList.get(0));
					            	
									frmitem.drpEstado.setChoices(estadoList);
									frmitem.drpEstado.setEnabled(true);
									frmitem.bindForm((ItemDTO) this
											.getDefaultModelObject() );
									
					                target.add(frmitem.drpEstado); 
					                target.add(frmitem); 
					                
									
									
								}
						});
						
						repeatingView.add( new Link<ItemDTO>("Delete", pitem.getModel() ){
							@Override
							public void onClick(){
								try {
									ServiceLocator
									.getInstance()
									.getItemService()
									.deleteItem( 
												((ItemDTO) this
												.getDefaultModelObject())
												.getOid()  );
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
