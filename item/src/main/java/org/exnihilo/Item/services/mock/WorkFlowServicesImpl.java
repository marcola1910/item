package org.exnihilo.Item.services.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.bi.ItemSysRepositoryBI;
import org.exnihilo.Item.services.bi.WorkflowServicesBI;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.LinkDTO;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;
import org.exnihilo.Item.util.cytoscapeDTO.data;
import org.exnihilo.Item.util.cytoscapeDTO.datanode;
import org.exnihilo.Item.util.cytoscapeDTO.dataedge;
import org.exnihilo.Item.util.cytoscapeDTO.elements;
import org.exnihilo.Item.util.cytoscapeDTO.layout;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

@Service
public class WorkFlowServicesImpl extends BaseServiceImpl implements
		WorkflowServicesBI {

	public WorkFlowServicesImpl() {
		// TODO Auto-generated constructor stub
	}

	public WorkFlowServicesImpl(ItemSysRepositoryBI itemSysrepository) {
		super.set_itemSysRepository(itemSysrepository);
	}

	@Transactional
	@Override
	public WorkFlowDTO addWorkFlow(WorkFlowDTO workflow) {

		// Toma el root object
		ItemSys itemSys = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys();

		// el workflow va colgado directamente desde el root

		WorkFlow _workflow = new WorkFlow();

		_workflow.setName(workflow.getName());
		_workflow.setOid(IDGenerator.getId());
		itemSys.addWorkflow(_workflow);

		// retorna el dto con el oid para uso en el cliente
		workflow.setOid(_workflow.getOid());

		return workflow;
	}

	@Override
	public void addNodo(NodoDTO nodo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLink(LinkDTO link) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNodo(NodoDTO nodo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLink(LinkDTO link) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteWorkFlow(WorkFlowDTO workflow) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<WorkFlowDTO> getWorkflow(WorkFlowDTO workflow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<WorkFlowDTO> getWorkflowbyId(String wrkId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public List<WorkFlowDTO> getAllWorkflows() {

		List<WorkFlowDTO> _result = new ArrayList<WorkFlowDTO>();
		Iterator<WorkFlow> iterWorkFlow = RepositoryLocator.getInstance()
				.getItemSysRepository().findItemSys().getWorkflows().iterator();
		WorkFlow _workflow = new WorkFlow();

		while (iterWorkFlow.hasNext()) {
			_workflow = iterWorkFlow.next();

			_result.add(DTOFactory.getInstance().createWorkflowDTO(
					_workflow.getOid(), _workflow.getName()));
		}

		return _result;
	}

	@Transactional
	public List<NodoDTO> getWorkFlowNodes(String workflowId) {

		List<NodoDTO> _result = new ArrayList<NodoDTO>();

		Iterator<Nodo> listNodos = ((WorkFlow) RepositoryLocator.getInstance()
				.getWorkFlowRepository().findWorkflowbyid(null, workflowId))
				.getNodos().iterator();
		// barre los estados de cada workflow
		while (listNodos.hasNext()) {

			Nodo _nodo = listNodos.next();
			NodoDTO _nododto = DTOFactory.getInstance().createNodoDTO(
					_nodo.getOid(), _nodo.getName(), new ArrayList<NodoDTO>());
			Iterator<Nodo> lstprox = _nodo.getProxEstado().iterator();

			// crea un dto para los proximos estados
			while (lstprox.hasNext()) {
				Nodo _proxestado = lstprox.next();

				_nododto.getProxEstado().add(
						DTOFactory.getInstance().createNodoDTO(
								_proxestado.getOid(), _proxestado.getName(),
								new ArrayList<NodoDTO>()));
			}

			_result.add(_nododto);

		}
		return _result;
	}

	@Transactional
	@Override
	public WorkFlowDTO changeWorkflow(WorkFlowDTO defaultModelObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String getAllWorkflowNodesJson(String WorkflowID) {

		List<NodoDTO> nodos = this.getWorkFlowNodes(WorkflowID);
		final Collection node = new ArrayList();
		final Collection link = new ArrayList();
		final elements elements = new elements();
		String cyelements = null; 
		String cyCommands = null;
		String cyPathAlgo = null;
		String cyfirstnode = null;
		String cyResult = "";
		int i = 1;
		
		Gson gson =  new Gson();
		
		Iterator<NodoDTO> itNodos = nodos.iterator();
		while(itNodos.hasNext() ){
			NodoDTO _nodo = itNodos.next();
			
			if(i==1)
				cyfirstnode = _nodo.getOid();
			
			node.add( new data( new datanode( _nodo.getOid(), _nodo.getName() )) );
			i++;
			Iterator<NodoDTO> itNodosprox = _nodo.getProxEstado().iterator();
			while(itNodosprox.hasNext() ){
				NodoDTO _link = itNodosprox.next();
				link.add( new data ( new dataedge(_nodo.getOid().concat(
						_link.getOid())  , "1", _nodo.getOid(), _link.getOid()) ) );
				
			}
		}
		
		elements.setNodes(node);
		elements.setEdges(link);
		
		cyCommands = "<script>   $(function(){ var cy = cytoscape({   container: document.getElementById('cy'),      style: cytoscape.stylesheet()     .selector('node')       .css({         'content': 'data(name)'       })     .selector('edge')       .css({         'target-arrow-shape': 'triangle',         'width': 4,         'line-color': '#ddd',         'target-arrow-color': '#ddd'       })     .selector('.highlighted')       .css({         'background-color': '#61bffc',         'line-color': '#61bffc',         'target-arrow-color': '#61bffc',         'transition-property': 'background-color, line-color, target-arrow-color',         'transition-duration': '0.5s'       }),        ";
				
		cyelements =  "elements: " + gson.toJson(elements).toString(); 
		
		cyelements =   cyelements + ", layout: " + gson.toJson(new layout("breadthfirst",true,"#" + cyfirstnode,10) ) + "});";
		
		cyPathAlgo = "var bfs = cy.elements().bfs('#" + cyfirstnode + "', function(){}, true);  var i = 0; var highlightNextEle = function(){   bfs.path[i].addClass('highlighted');      if( i < bfs.path.length ){     i++;     setTimeout(highlightNextEle, 1000);   } }; highlightNextEle();  });  </script>";
		
		cyResult = cyCommands + cyelements + cyPathAlgo;
		
		return cyResult ;
	}

	
}
