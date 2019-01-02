package id.ststech.javabasic.bombermanapp;

import id.ststech.javabasic.usingbitwise.BomberMan;

public class BomberMan2 extends BomberMan {

	private String name;

	public BomberMan2(String name) {
		super();
		this.setName(name);
		
		this.setBomb(1);
		this.setBoot(1);
		this.setFire(1);
		this.setCanKick(false);
		this.setCanThrow(false);
		this.setPoisoned(false);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if ( name == null ) this.name = "";
		this.name = name.toLowerCase().trim();
	}
	
	
	
}
