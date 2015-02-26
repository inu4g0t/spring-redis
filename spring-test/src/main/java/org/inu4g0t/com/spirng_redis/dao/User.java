package org.inu4g0t.com.spirng_redis.dao;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String ID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String selfIntro(){
		return "My name is " + name + " and my id is " + ID;
	}
	
}
