package org.exnihilo.Item.services.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.Item;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.model.exceptions.EstadoUtilizado;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.EstadoServiceBI;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoServiceImpl extends BaseServiceImpl implements
		EstadoServiceBI {

	public EstadoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public EstadoServiceImpl(ItemSysRepositoryBI itemSysRep) {
		super.set_itemSysRepository(itemSysRep);
	}

	@Transactional
	@Override
	public NodoDTO addEstado(NodoDTO estado, WorkFlowDTO workflow) {

		// agrega el estado al repositorio configurado, puede ser Mock (en
		// memoria) o en la BBDD
		ItemSys itemSys = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys();

		WorkFlow mWorkflow = RepositoryLocator.getInstance()
				.getWorkFlowRepository()
				.findWorkflowbyid(itemSys, workflow.getOid());

		Nodo nodo = new Nodo();

		nodo.setName(estado.getName());
		nodo.setOid(IDGenerator.getId());

		mWorkflow.getNodos().add(nodo);

		estado.setOid(nodo.getOid());

		return estado;

	}

	@Transactional
	@Override
	public List<NodoDTO> addProxEstado(String Oid, String workflowid,
			List<NodoDTO> proxEstados) {

		RepositoryLocator.getInstance().getItemSysRepository().findItemSys();

		Nodo mNodo = RepositoryLocator.getInstance().getEstadoRepository()
				.getEstadobyId(Oid, workflowid);

		Iterator<NodoDTO> nodoit = proxEstados.iterator();

		mNodo.setProxEstado(new ArrayList<Nodo>());
		while (nodoit.hasNext()) {
			NodoDTO _nododto = nodoit.next();

			Nodo _nodo = RepositoryLocator.getInstance().getEstadoRepository()
					.getEstadobyId(_nododto.getOid(), workflowid);

			mNodo.getProxEstado().add(_nodo);
		}

		return proxEstados;

	}

	@Transactional
	@Override
	public NodoDTO changeEstado(NodoDTO estado) {

		RepositoryLocator.getInstance().getItemSysRepository().findItemSys();

		Nodo mNodo = RepositoryLocator.getInstance().getEstadoRepository()
				.getEstadobyId(estado.getOid(), estado.getWorkflow().getOid());

		mNodo.setVersion(estado.getVersion() + 1);
		mNodo.setName(estado.getName());

		estado.setVersion(mNodo.getVersion());

		return estado;
	}

	@Override
	public Collection<NodoDTO> getEstado(NodoDTO estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public NodoDTO getEstadoByID(String oid, String workflow) {

		Nodo mNodo = RepositoryLocator.getInstance().getEstadoRepository()
				.getEstadobyId(oid, workflow);

		NodoDTO _nododto = DTOFactory.getInstance().createNodoDTO(
				mNodo.getOid(), mNodo.getName(), new ArrayList<NodoDTO>());
		Iterator<Nodo> lstprox = mNodo.getProxEstado().iterator();

		// crea un dto para los proximos estados
		while (lstprox.hasNext()) {
			Nodo _proxestado = lstprox.next();

			_nododto.getProxEstado().add(
					DTOFactory.getInstance().createNodoDTO(
							_proxestado.getOid(), _proxestado.getName(),
							new ArrayList<NodoDTO>()));
		}

		return _nododto;
	}

	@Transactional
	@Override
	public void deleteEstado(String estadoID, String workflowId)
			throws Exception {

		// agrega el estado al repositorio configurado, puede ser Mock (en
		// memoria) o en la BBDD
		ItemSys itemSys = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys();

		Nodo mNodo = RepositoryLocator.getInstance().getEstadoRepository()
				.getEstadobyId(estadoID, workflowId);

		WorkFlow mWorkflow = RepositoryLocator.getInstance()
				.getWorkFlowRepository().findWorkflowbyid(itemSys, workflowId);

		// valida si no tiene ningun estado ya asociado
		List<Item> litem = RepositoryLocator.getInstance()
				.get_itensRepository().findItembyEstado(mNodo);

		if(litem.size() > 0){
			throw new EstadoUtilizado();
		}
			
		mWorkflow.getNodos().remove(mNodo);
		mNodo.getProxEstado().removeAll( mNodo.getProxEstado() );

		RepositoryLocator.getInstance().getEstadoRepository().delete(mNodo);

	}

	@Transactional
	@Override
	public void addProxEstado(WorkFlowDTO workflow, NodoDTO estado) {

		// Recupera o nodo existente
		Nodo mNodo = RepositoryLocator.getInstance().getEstadoRepository()
				.getEstadobyId(estado.getOid(), workflow.getOid());

		// Recupera o nodo existente para el prox
		Nodo mProxNodo = RepositoryLocator
				.getInstance()
				.getEstadoRepository()
				.getEstadobyId(estado.getProxEstado().get(0).getOid(),
						workflow.getOid());

		// agrega el prox estado al estado selecionado al workflow seleccionado
		mNodo.getProxEstado().add(mProxNodo);

	}

	@Transactional
	@Override
	public List<NodoDTO> getAllEstados() {

		List<NodoDTO> _result = new ArrayList<NodoDTO>();

		// busca todos los workflow
		Iterator<WorkFlow> listworkflow = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys().getWorkflows().iterator();

		// busca todos ciclo de workflows
		while (listworkflow.hasNext()) {
			WorkFlow _workflow = listworkflow.next();

			Iterator<Nodo> listNodos = ((WorkFlow) RepositoryLocator
					.getInstance().getWorkFlowRepository()
					.findWorkflowbyid(null, _workflow.getOid())).getNodos()
					.iterator();
			// barre los estados de cada workflow
			while (listNodos.hasNext()) {

				Nodo _nodo = listNodos.next();
				NodoDTO _nododto = DTOFactory.getInstance().createNodoDTO(
						_nodo.getOid(), _nodo.getName(),
						new ArrayList<NodoDTO>());
				Iterator<Nodo> lstprox = _nodo.getProxEstado().iterator();

				// atribuye el workflow que le corresponde
				_nododto.setWorkflow(DTOFactory.getInstance()
						.createWorkflowDTO(_workflow.getOid(),
								_workflow.getName()));

				// crea un dto para los proximos estados
				while (lstprox.hasNext()) {
					Nodo _proxestado = lstprox.next();

					_nododto.getProxEstado().add(
							DTOFactory.getInstance().createNodoDTO(
									_proxestado.getOid(),
									_proxestado.getName(),
									new ArrayList<NodoDTO>()));
				}

				_result.add(_nododto);

			}

		}

		return _result;
	}

}
