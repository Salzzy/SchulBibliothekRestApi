package de.schule.schullib.schulbibliothek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	private String class;
	
	@Column(name="Rolle")
	private Integer role;
	
	@Column(name="Password")
	private String password;

	@Column(name="AdresseID")
	private Integer fk_addressID;
	
	@JsonManagedReference
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="AdresseID", referencedColumnName="AdresseID", insertable = false, updatable = false)
	private Address address;

	public User() {
		
	}
	
	public User(Integer firstName, String lastName, String email, String class, Integer role, String password, Integer fk_addressID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.class = class;
		this.role = role;
		this.password = password;
		this.fk_addressID = fk_addressID;
	}

	public User(Integer id, Integer firstName, String lastName, String email, String class, Integer role, String password, Integer fk_addressID) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.class = class;
		this.role = role;
		this.password = password;
		this.fk_addressID = fk_addressID;
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
		this.lastname = lastName;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getClass(){
		return this.class;
	}

	public void setClass(String class){
		this.class = class;
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

	public Integer getAddressId(){
		return this.fk_addressID;
	}

	public void setAddressId(Integer addressID){
		this.fk_addressID = addressID;
	}

	public Address getAddress(){
		return this.address;
	}

	public void setAddress(Address address){
		this.address = address;
	}

}