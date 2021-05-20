package co.edu.ufps.previodos.beans;

import java.io.Serializable;

public class Team implements Serializable {
	
	private Integer id;
	
	private String name;
	
	private String country;

	public Team() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
