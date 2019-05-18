package de.schule.schullib.schulbibliothek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="land")
public class Land {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LandID")
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	public Land() {
		
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
	
	
}

