package de.schule.schullib.schulbibliothek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="adresse")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AdresseID")
	private Integer id;
	
	@Column(name="Strasse")
	private String street;
	
	@Column(name="PLZ")
	private String plz;
	
	@Column(name="Stadt")
	private String city;
	
	@JsonManagedReference
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="LandID", referencedColumnName="LandID", insertable = false, updatable = false)
	private Land land;

	public Address() {
		
	}
	
	public Address(String street, String plz, String city, Land land) {
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.land = land;
	}

	public Address(Integer id, String street, String plz, String city, Land land) {
		this.id = id;
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.land = land;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}
	

}
