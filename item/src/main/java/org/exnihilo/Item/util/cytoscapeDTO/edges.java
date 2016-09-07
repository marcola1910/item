package org.exnihilo.Item.util.cytoscapeDTO;

import java.util.ArrayList;
import java.util.Collection;

public class edges {
	
	private Collection<datanode> data = new ArrayList<datanode>(); 

	public edges() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public Collection getData() {
		return data;
	}

	@SuppressWarnings("unchecked")
	public void setData(@SuppressWarnings("rawtypes") Collection data) {
		this.data = data;
	}

}
