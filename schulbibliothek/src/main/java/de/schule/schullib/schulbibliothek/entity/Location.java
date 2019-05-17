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
@Table(name="Standort")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="fach")
    private String fach;
	
	@Column(name="regalnr")
    private Integer regalnr;
	
	@Column(name="fachbereich")
    private String fachbereich;
	
	@Column(name="raumnr")
    private String raumnr;
	
	@Column(name="verantwortlicherID")
    private Integer fk_verantwortlicherID;

    @JsonManagedReference
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="verantwortlicherID", referencedColumnName="BenutzerID", insertable = false, updatable = false)
	private User user;

    public Location(Integer id, String fach, Integer regalnr, String fachbereich, String raumnr, Integer fk_verantwortlicherID) {
        this.id = id;
        this.fach = fach;
        this.regalnr = regalnr;
        this.fachbereich = fachbereich;
        this.raumnr = raumnr;
        this.fk_verantwortlicherID = fk_verantwortlicherID;
    }

    public Location(String fach, Integer regalnr, String fachbereich, String raumnr, Integer fk_verantwortlicherID) {
        this.id = id;
        this.fach = fach;
        this.regalnr = regalnr;
        this.fachbereich = fachbereich;
        this.raumnr = raumnr;
        this.fk_verantwortlicherID = fk_verantwortlicherID;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFach() {
        return this.fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public Integer getRegalnr() {
        return this.regalnr;
    }

    public void setRegalnr(Integer regalnr) {
        this.regalnr = regalnr;
    }

    public String getFachbereich() {
        return this.fachbereich;
    }

    public void setFachbereich(String fachbereich) {
        this.fachbereich = fachbereich;
    }

    public String getRaumnr() {
        return this.raumnr;
    }

    public void setRaumnr(String raumnr) {
        this.raumnr = raumnr;
    }

    public Integer getFk_verantwortlicherID() {
        return this.fk_verantwortlicherID;
    }

    public void setFk_verantwortlicherID(Integer fk_verantwortlicherID) {
        this.fk_verantwortlicherID = fk_verantwortlicherID;
    }
    
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
