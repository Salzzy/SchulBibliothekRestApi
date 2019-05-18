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
@Table(name="Buchexemplar")
public class BookCopy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
	
	@Column(name="Buch_id")
	private Integer bookId;
	
	@Column(name="Auflage")
    private Integer edition;

    @Column(name="Standort_id")
    private Integer fk_locationID;
    
    @JsonManagedReference
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Standort_id", referencedColumnName="id", insertable = false, updatable = false)
    private Location location;

    public BookCopy() {
    	
    }
    
	public BookCopy(Integer id, Integer edition, Integer bookId, Integer fk_locationID, Location location) {
		this.id = id;
		this.edition = edition;
		this.bookId = bookId;
		this.fk_locationID = fk_locationID;
		this.location = location;
	}

	public BookCopy(Integer edition, Integer bookId, Integer fk_locationID, Location location) {
		this.edition = edition;
		this.bookId = bookId;
		this.fk_locationID = fk_locationID;
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEdition() {
		return this.edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Integer getbookId() {
		return this.bookId;
	}

	public void setbookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getFk_locationID() {
		return this.fk_locationID;
	}

	public void setFk_locationID(Integer fk_locationID) {
		this.fk_locationID = fk_locationID;
	}


	
}