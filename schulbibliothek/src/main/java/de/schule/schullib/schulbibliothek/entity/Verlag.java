package de.schule.schullib.schulbibliothek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Verlag")
public class Verlag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="webseite")
	private String website;
	
	@Column(name="hotline")
	private String hotline;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;

	
	public Verlag() {
		
	}

	public Verlag(String website, String hotline, String email, String name) {
		this.website = website;
		this.hotline = hotline;
		this.email = email;
		this.name = name;
	}

	public Verlag(int id, String website, String hotline, String email, String name) {
		this.id = id;
		this.website = website;
		this.hotline = hotline;
		this.email = email;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
