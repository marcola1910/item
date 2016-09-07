package org.exnihilo.Item.util.cytoscapeDTO;

public class layout {

	private String name; 
	private boolean directed;     
	private String roots; 
	private int padding;
	
	public layout() {
		// TODO Auto-generated constructor stub
	}

	public layout(String name, boolean directed, String roots, int padding) {
		this.name = name;
		this.directed = directed;
		this.roots = roots;
		this.padding = padding;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public String getRoots() {
		return roots;
	}

	public void setRoots(String roots) {
		this.roots = roots;
	}

	public int getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

}
