/**
 * 
 */
package org.exnihilo.Item.util.cytoscapeDTO;

import java.io.Serializable;

/**
 * @author marcmarinho
 *
 */
public class dataedge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7124048022275712857L;
	private String id ;
	private String weight; 
	private String source; 
	private String target;
	
	/**
	 * 
	 */
	public dataedge() {
		// TODO Auto-generated constructor stub
	}

	public dataedge(String id, String weight, String source, String target  ) {
		this.id = id;
		this.weight = weight;
		this.source = source;
		this.target = target;
	}
	
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
