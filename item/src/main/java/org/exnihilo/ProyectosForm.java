/**
 * 
 */
package org.exnihilo;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.util.EquipoDTO;
import org.exnihilo.Item.util.ProyectoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;

/**
 * @author marcmarinho
 *
 */
@SuppressWarnings("rawtypes")
public class ProyectosForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 637704760794589576L;


	@SuppressWarnings("unused")
	private DropDownChoice<WorkFlowDTO> drpList;
	@SuppressWarnings("unused")
	private ProyectoDTO _proyectodto;
	
	@SuppressWarnings("unchecked")
	public ProyectosForm(String id) {
		super(id);
		
		ProyectoDTO mProy = new ProyectoDTO();
		List<EquipoDTO> equipolist = ServiceLocator.getInstance().getEquipoService().getAllEquipos();
		
		ChoiceRenderer typeRenderer = new ChoiceRenderer( "Nombre", "oid");
		
		add( new Label("Oid")  ); 
		add( new RequiredTextField("nombre"));
		
		DropDownChoice drpequipo = new DropDownChoice<EquipoDTO>("equipo", equipolist, typeRenderer)   {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1726034780351603615L;

			protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
			
		};
		
		drpequipo.setRequired(true);
		add( drpequipo);
		add(new FeedbackPanel("mfeed"));
		
		this.bindForm(mProy);
		
	}
	
	public void bindForm(ProyectoDTO proy ){
		setDefaultModel(new CompoundPropertyModel<ProyectoDTO>(proy));
	}
	
	protected final void onSubmit() {
		
		if ( ((ProyectoDTO) this.getDefaultModelObject()).getOid() == null )
			_proyectodto = ServiceLocator.getInstance().getProyectoService().addProyecto( (ProyectoDTO) this.getDefaultModelObject());
		else
			_proyectodto = ServiceLocator.getInstance().getProyectoService().changeProyecto( (ProyectoDTO) this.getDefaultModelObject() );
		
		setResponsePage(ProyectosPage.class);
		
	}

}
