package org.exnihilo.Item.util.cytoscapeDTO;

import java.util.ArrayList;
import java.util.Collection;

public class elements {

	private Collection<nodes> nodes = new ArrayList<nodes>();
	private Collection<edges> edges = new ArrayList<edges>();
	
	public elements() {
		// TODO Auto-generated constructor stub
	}

	public Collection<nodes> getNodes() {
		return nodes;
	}

	public void setNodes(Collection<nodes> nodes) {
		this.nodes = nodes;
	}

	public Collection<edges> getEdges() {
		return edges;
	}

	public void setEdges(Collection<edges> edges) {
		this.edges = edges;
	}


}
