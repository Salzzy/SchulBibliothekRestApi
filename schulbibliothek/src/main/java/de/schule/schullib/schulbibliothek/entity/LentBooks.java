package de.schule.schullib.schulbibliothek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lent_user_books")
public class LentBooks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="raumnr")
	private Integer raumnr;
	
	@Column(name="fach")
	private String fachbereich;
	
	@Column(name="regalnr")
	private Integer regalnr;
	
	@Column(name="fach", insertable = false, updatable = false)
	private String fach;
	
	@Column(name="auflage")
	private Integer auflage;
	
	@Column(name="datenträger")
	private String datentraeger;
	
	@Column(name="Titel")
	private String titel;
	
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="verantwortlicherID")
	private Integer userId;
	
	public LentBooks() {
		
	}

	public LentBooks(Integer id, Integer raumnr, String fachbereich, Integer regalnr, String fach, Integer auflage,
			String datentraeger, String titel, String isbn) {
		this.raumnr = raumnr;
		this.fachbereich = fachbereich;
		this.regalnr = regalnr;
		this.fach = fach;
		this.auflage = auflage;
		this.datentraeger = datentraeger;
		this.titel = titel;
		this.isbn = isbn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRaumnr() {
		return raumnr;
	}

	public void setRaumnr(Integer raumnr) {
		this.raumnr = raumnr;
	}

	public String getFachbereich() {
		return fachbereich;
	}

	public void setFachbereich(String fachbereich) {
		this.fachbereich = fachbereich;
	}

	public Integer getRegalnr() {
		return regalnr;
	}

	public void setRegalnr(Integer regalnr) {
		this.regalnr = regalnr;
	}

	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	public Integer getAuflage() {
		return auflage;
	}

	public void setAuflage(Integer auflage) {
		this.auflage = auflage;
	}

	public String getDatentraeger() {
		return datentraeger;
	}

	public void setDatentraeger(String datentraeger) {
		this.datentraeger = datentraeger;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
