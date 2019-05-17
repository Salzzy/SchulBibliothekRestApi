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
@Table(name="Buchexemplar")
public class BookCopy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="Auflage")
    private Integer edition;
    
    @Column(name="Buch_id")
    private Integer fk_bookID;

    @Column(name="Standort_id")
    private Integer fk_locationID;

    @JsonManagedReference
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Buch_id", referencedColumnName="id", insertable = false, updatable = false)
	private Book book;

	@JsonManagedReference
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Standort_id", referencedColumnName="id", insertable = false, updatable = false)
	private Location location;


	public BookCopy(Integer id, Integer edition, Integer fk_bookID, Integer fk_locationID, Book book, Location location) {
		this.id = id;
		this.edition = edition;
		this.fk_bookID = fk_bookID;
		this.fk_locationID = fk_locationID;
		this.book = book;
		this.location = location;
	}

	public BookCopy(Integer edition, Integer fk_bookID, Integer fk_locationID, Book book, Location location) {
		this.id = id;
		this.edition = edition;
		this.fk_bookID = fk_bookID;
		this.fk_locationID = fk_locationID;
		this.book = book;
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

	public Integer getFk_bookID() {
		return this.fk_bookID;
	}

	public void setFk_bookID(Integer fk_bookID) {
		this.fk_bookID = fk_bookID;
	}

	public Integer getFk_locationID() {
		return this.fk_locationID;
	}

	public void setFk_locationID(Integer fk_locationID) {
		this.fk_locationID = fk_locationID;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}