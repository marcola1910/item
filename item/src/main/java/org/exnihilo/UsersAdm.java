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
import org.exnihilo.Item.util.UsuarioDTO;

public class UsersAdm extends BasePage { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 8318001093544940187L;
	private List<UsuarioDTO> _userslist;

	public UsersAdm(PageParameters parameters) {
		super(parameters);

		_userslist = ServiceLocator
				.getInstance()
				.getUserService()
				.getAllUsers(
						(UsuarioDTO) UserSession.getInstance().getUsuario());
		
		this.popUsers();
		
		add( new UserDataFields("usrDataFields") );
		
		add(new Label("loggedUser", UserSession.getInstance().getUsuario().getNombre() ));
		
	}
	
	protected void bindUsers(){
		_userslist = ServiceLocator
				.getInstance()
				.getUserService()
				.getAllUsers(
						(UsuarioDTO)  UserSession.getInstance().getUsuario());

		@SuppressWarnings("unused")
		ListDataProvider<UsuarioDTO> listDataProvider = new ListDataProvider<UsuarioDTO>(
				_userslist);
	}
	
	protected void popUsers() {

		_userslist = ServiceLocator
				.getInstance()
				.getUserService()
				.getAllUsers(
						(UsuarioDTO) UserSession.getInstance().getUsuario());

		ListDataProvider<UsuarioDTO> listDataProvider = new ListDataProvider<UsuarioDTO>(
				_userslist);
		
		@SuppressWarnings("serial")
		DataView<UsuarioDTO> dataView = new DataView<UsuarioDTO>("rows",
				listDataProvider) {
			@Override
			protected void populateItem(Item<UsuarioDTO> item) {
				UsuarioDTO person = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");
				repeatingView.add(new Label(repeatingView.newChildId(), person
						.getNombre()));
				repeatingView.add(new Label(repeatingView.newChildId(), person
						.getEmail()));
				repeatingView.add(new Label(repeatingView.newChildId(), person
						.getTelefono()));
				
				repeatingView.add( 
						new Link<UsuarioDTO>("Edit",item.getModel()){
					        @Override public void onClick(){
					          // llamada al metodo que llena el form
					        	UserAdmForm usrAdm = (UserAdmForm) this.getParent().getParent().getParent().getParent().get("usrDataFields").get("userForm");
					        	usrAdm.bindForm((UsuarioDTO) this.getDefaultModelObject());
					        }
					      }
					);
				
				repeatingView.add( 
						new Link<UsuarioDTO>("Delete",item.getModel()){
					        @Override public void onClick(){
					          // llamada al delete usr service
					        	try {
									ServiceLocator.getInstance().getUserService()
									.deleteUser( ((UsuarioDTO) this.getDefaultModelObject()).getOid() );
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					        	bindUsers();
					        	setResponsePage(UsersAdm.class);
					        }
					      }
					);
				
				item.add(repeatingView);
			}
		};
		add(dataView);
	}
}
