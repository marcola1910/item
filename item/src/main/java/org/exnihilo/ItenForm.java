/**
 * 
 */
package org.exnihilo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.exnihilo.Item.model.exceptions.ItemConcurrentModificationException;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.HistorialDTO;
import org.exnihilo.Item.util.ItemDTO;
import org.exnihilo.Item.util.ItemTypeDTO;
import org.exnihilo.Item.util.MiembroEquipoDTO;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.ProyectoDTO;

/**
 * @author marcmarinho
 *
 */
@SuppressWarnings("rawtypes")
public class ItenForm extends Form {
	/**
	 *  cada campo de entrada de datos deben ser declarados aqui
	 */
	private static final long serialVersionUID = -7117159936937877841L;
	private ItemDTO _itemdto;
	private List<NodoDTO> estadoList = new ArrayList<NodoDTO>();
	
	public List<NodoDTO> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<NodoDTO> estadoList) {
		this.estadoList = estadoList;
	}

	private List<MiembroEquipoDTO> asignadoList = new ArrayList<MiembroEquipoDTO>();
	final DropDownChoice<NodoDTO> drpEstado;
	
	
	public Label getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Label estadoActual) {
		this.estadoActual = estadoActual;
	}

	private DropDownChoice<MiembroEquipoDTO> drpMiembros;
	private Label estadoActual;
	private RepeatingView listreg;
	
	@SuppressWarnings("unchecked")
	public ItenForm( String id ){
		super(id);

		_itemdto = new ItemDTO();
		add(new Label("Fecha")); 
		add(new RequiredTextField("Titulo"));
		add(new Label("Oid"));
		add(new Label("Version"));
		
		estadoActual = new Label("EstadoActual");
		
		add(estadoActual);
		
		add(new TextArea("Descripcion"));
		
		// Set up the visible fields of the Type
		ChoiceRenderer itemTypeRender = new ChoiceRenderer("Titulo", "oid");
		
		// Brings a DTO of ItemType object
		List<ItemTypeDTO> itemTypeList = ServiceLocator.getInstance()
				.getItemTypeService().getAllItensType();
		
		// 
		DropDownChoice<ItemTypeDTO> drpType = new DropDownChoice<ItemTypeDTO>("ItemType", itemTypeList, itemTypeRender)   {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean wantOnSelectionChangedNotifications() {
                return false;
            }
		};
		
		drpType.setRequired(true);
		
		// Ajax behavior q carga los estados del workflow
		drpType.add( new AjaxFormComponentUpdatingBehavior("onchange") {
			 
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void onUpdate(AjaxRequestTarget target) {
            	
            	estadoList = null;
            	
            	estadoList = ServiceLocator.getInstance()
        				.getWorkflowService().getWorkFlowNodes( 
        						((ItemDTO) getDefaultModelObject()).getItemType().getWorkflow().getOid() );
            	
            	//Si se trata de una alta, solo permite el primer estado del flow
            	if( ((ItemDTO) getDefaultModelObject()).getOid() == null )
            		drpEstado.setModelObject(estadoList.get(0));
            	
            	drpEstado.setChoices(estadoList);
            	drpEstado.setEnabled(false);
                target.add(drpEstado); 
                
            	
            	} 
            });
		
		// Set up the itemtype list
		add(drpType );
		
		// Set up the visible fields of the Estado
		ChoiceRenderer estadoRender = new ChoiceRenderer("Name", "oid");

		// Brings a DTO of ItemType object
		this.estadoList = ServiceLocator.getInstance()
				.getEstadosService()
				.getAllEstados();

		drpEstado = new DropDownChoice<NodoDTO>("Estado", estadoList, estadoRender)   {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean wantOnSelectionChangedNotifications() {
                return false;
            }
			
		};
		drpEstado.setOutputMarkupId(true);
		drpEstado.setRequired(true);
		
		// Set up the Estado list
		add( drpEstado);
		
		// Set up the visible fields of the Proyecto
		ChoiceRenderer proyectoRender = new ChoiceRenderer("Nombre", "oid");

		// Brings a DTO of Project object
		List<ProyectoDTO> proyectoList = ServiceLocator.getInstance()
				.getProyectoService()
				.getAllProyects();

		// Set up the Proyecto list
		final DropDownChoice<ProyectoDTO> prjDrpBx = new DropDownChoice<ProyectoDTO>("Proyecto", proyectoList, proyectoRender) ;
			
		prjDrpBx.add( 
				new AjaxFormComponentUpdatingBehavior("onchange") {
					 
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
		            protected void onUpdate(AjaxRequestTarget target) {
		            	
		            	//popula los miembros
		            	asignadoList = ServiceLocator.getInstance().getEquipoService().getAllMiembros(((ItemDTO) getDefaultModelObject()).getProyecto().getEquipo().getOid()) ; 
		            	drpMiembros.setChoices(asignadoList);
			            	if (target != null) {
		                        target.add(drpMiembros); 
		                    }
		            	
		            	} 
		            });
				
		prjDrpBx.setRequired(true);	
		add( prjDrpBx);	
		
		// Set up the visible fields of the Asignado
		ChoiceRenderer asignadoRender = new ChoiceRenderer("Nombre", "oid");

		// Brings a DTO of Asignado object
		this.asignadoList = ServiceLocator.getInstance().getEquipoService().getAllMiembros(null);
		
		drpMiembros = new DropDownChoice<MiembroEquipoDTO>("Asignado", asignadoList, asignadoRender)   {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean wantOnSelectionChangedNotifications() {
                return false;
            }
			
		};
		drpMiembros.setOutputMarkupId(true);
		drpMiembros.setRequired(true);
		
		// Set up the Asignado list
		add( drpMiembros );	
		
		
		listreg = new RepeatingView("Historiallst");
		
		add(listreg); 
		
		add(new FeedbackPanel("mfeed"));
		
		
		
		this.bindForm(_itemdto);
		
	}

	public void bindForm(ItemDTO _item){
		
		Iterator<HistorialDTO> lsthist = _item.getHistorial().iterator();
		listreg.clearOriginalDestination();
		listreg.removeAll();
		while(lsthist.hasNext())
		{
			HistorialDTO _hist = lsthist.next();
			listreg.add(new Label(listreg.newChildId(), _hist.getFecha().toString() + " :: " + _hist.getRegistro() ));
			
		}
		setDefaultModel(new CompoundPropertyModel<ItemDTO>(_item));
		
		
	}
	
	protected final void onSubmit() {
		
		if ( ((ItemDTO) this.getDefaultModelObject()).getOid() == null ){
			((ItemDTO) getDefaultModelObject()).setUsuario(((UserSession) this.getSession()).getUsuario());
			_itemdto = ServiceLocator.getInstance().getItemService()
					.addItem((ItemDTO) this.getDefaultModelObject());
			
			bindForm(_itemdto);
			setResponsePage(ItenPage.class);
			
		} else
			try {
				_itemdto = ServiceLocator.getInstance().getItemService()
						.changeItem((ItemDTO) this.getDefaultModelObject());
				
				bindForm(_itemdto);
				setResponsePage(ItenPage.class);
				
			} catch (ItemConcurrentModificationException e) {
				e.printStackTrace();
				PageParameters params = new PageParameters();
			    params.add("error", "El Item ha sido tomado por otro proceso, por favor intente nuevamente.");
				
				this.setResponsePage(ErrorPage.class ,params);
				
			}

		
	}
	
}
