package org.exnihilo;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.link.Link;
public class MenuPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1891538907938382130L;

	@SuppressWarnings({ "serial", "rawtypes"})
	public MenuPanel(String id) {
		super(id);
		
		add(new Link("linkMenuHome"){ 
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}});
	
		add(new Link("linkMenuUsuarios"){ 
			@Override
			public void onClick() {
				setResponsePage(UsersAdm.class);
			}});
		this.get("linkMenuUsuarios").setVisible(false);
		
		add(new Link("linkMenuAsigned"){ 
			@Override
			public void onClick() {
				setResponsePage(AsignedItens.class);
			}});
		this.get("linkMenuAsigned").setVisible(false);
			
		add(new Link("linkMenuItenType"){ 
			@Override
			public void onClick() {
				setResponsePage(ItenType.class);
			}});
		this.get("linkMenuItenType").setVisible(false);

		add(new Link("linkMenuIten"){ 
			@Override
			public void onClick() {
				setResponsePage(ItenPage.class);
			}});	
		this.get("linkMenuIten").setVisible(false);

		add(new Link("linkMenuEstados"){ 
			@Override
			public void onClick() {
				setResponsePage(EstadosPage.class);
			}});	
		this.get("linkMenuEstados").setVisible(false);

		add(new Link("linkMenuWorkflow"){ 
			@Override
			public void onClick() {
				setResponsePage(WorkflowPage.class);
			}});
		this.get("linkMenuWorkflow").setVisible(false);

		add(new Link("linkProyectos"){ 
			@Override
			public void onClick() {
				setResponsePage(ProyectosPage.class);
			}});
		this.get("linkProyectos").setVisible(false);
		
		
	}

}
