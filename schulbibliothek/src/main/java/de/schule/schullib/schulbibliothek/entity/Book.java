package de.schule.schullib.schulbibliothek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Buch")
public class Book {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="EigentuemerID")
	private Integer eigentuemer;
	
	@Column(name="Datenträger")
	private String datentraeger;
	
	@Column(name="titel")
	private String title;
	
	@Column(name="Genre")
	private String genre;
	
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="Verlagbestellnr")
	private Integer verlagBestellNr;
	
	@Column(name="Autorid")
	private Integer autorId;
	
	@Column(name="Verlagid")
	private Integer verlagId;

	public Book() {
		
	}
	
	public Book(Integer eigentuemer, String datentraeger, String title, String genre, String isbn, Integer verlagBestellNr, Integer autorId,
			Integer verlagId) {
		super();
		this.eigentuemer = eigentuemer;
		this.datentraeger = datentraeger;
		this.title = title;
		this.isbn = isbn;
		this.verlagBestellNr = verlagBestellNr;
		this.autorId = autorId;
		this.verlagId = verlagId;
		this.genre = genre;
	}

	public Book(Integer id, Integer eigentuemer, String datentraeger, String title, String genre, String isbn, Integer verlagBestellNr,
			Integer autorId, Integer verlagId) {
		super();
		this.id = id;
		this.eigentuemer = eigentuemer;
		this.datentraeger = datentraeger;
		this.title = title;
		this.isbn = isbn;
		this.verlagBestellNr = verlagBestellNr;
		this.autorId = autorId;
		this.verlagId = verlagId;
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEigentuemer() {
		return eigentuemer;
	}

	public void setEigentuemer(Integer eigentuemer) {
		this.eigentuemer = eigentuemer;
	}

	public String getDatentraeger() {
		return datentraeger;
	}

	public void setDatentraeger(String datentraeger) {
		this.datentraeger = datentraeger;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getVerlagBestellNr() {
		return verlagBestellNr;
	}

	public void setVerlagBestellNr(Integer verlagBestellNr) {
		this.verlagBestellNr = verlagBestellNr;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Integer getVerlagId() {
		return verlagId;
	}

	public void setVerlagId(Integer verlagId) {
		this.verlagId = verlagId;
	}
	
	
	
	

}