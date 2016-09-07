/**
 * 
 */
package org.exnihilo.Item.util.cytoscapeDTO;

import java.io.Serializable;

/**
 * @author marcmarinho
 *
 */
public class datanode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3083711183069972731L;
	private String id;
	private String name;
	
	/**
	 * 
	 */
	public datanode() {
		// TODO Auto-generated constructor stub
	}

	public datanode(String id, String name){
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
