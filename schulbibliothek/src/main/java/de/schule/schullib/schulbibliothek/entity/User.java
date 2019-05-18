package de.schule.schullib.schulbibliothek.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Benutzer")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BenutzerID")
	private Integer id;
	
	@Column(name="Vorname")
	private String firstName;
	
	@Column(name="Nachname")
	private String lastName;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Klasse")
	private String klasse;
	
	@Column(name="Rolle")
	private Integer role;
	
	@Column(name="Password")
	private String password;
	
	@JsonManagedReference
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="AdresseID", referencedColumnName="AdresseID", insertable = false, updatable = false)
	private Address address;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="verantwortlicherID", referencedColumnName = "BenutzerID", insertable = false, updatable = false)
	private List<LentBooks> lentBooks;
	
	
	public User() {
		
	}
	
	/*
	 * Konstruktor ohne id, da durch AUTO_INCREMENT in der Datenbank
	 * 	die id's schon gesetzt werden
	 * 
	 */
	public User(String firstName, String lastName, String email, String klasse, Integer role, String password,
			Address address, List<LentBooks> lentBooks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.klasse = klasse;
		this.role = role;
		this.password = password;
		this.address = address;
		this.lentBooks = lentBooks;
	}

	


	public List<LentBooks> getLentBooks() {
		return lentBooks;
	}

	public void setLentBooks(List<LentBooks> lentBooks) {
		this.lentBooks = lentBooks;
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getFirstName(){
		return this.firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return this.lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getKlasse(){
		return this.klasse;
	}

	public void setKlass(String klasse){
		this.klasse = klasse;
	}

	public Integer getRole(){
		return this.role;
	}

	public void setRole(Integer role){
		this.role = role;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Address getAddress(){
		return this.address;
	}

	public void setAddress(Address address){
		this.address = address;
	}

}