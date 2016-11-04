/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globantWorkshop.models.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author leandromaro
 */
@Entity
@Table(name = "copies")
public class Copies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcopies;
    private String bookCondition;
    private Integer taken;

    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks")
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Book books;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "copies")
    private List<Rentals> rentalsList;

    public Copies() {
    }

    public Copies(Integer idcopies) {
        this.idcopies = idcopies;
    }

    public Integer getIdcopies() {
        return idcopies;
    }

    public void setIdcopies(Integer idcopies) {
        this.idcopies = idcopies;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    public Integer getTaken() {
        return taken;
    }

    public void setTaken(Integer taken) {
        this.taken = taken;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public List<Rentals> getRentalsList() {
        return rentalsList;
    }

    public void setRentalsList(List<Rentals> rentalsList) {
        this.rentalsList = rentalsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcopies != null ? idcopies.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Copies)) {
            return false;
        }
        Copies other = (Copies) object;
        if ((this.idcopies == null && other.idcopies != null) || (this.idcopies != null && !this.idcopies.equals(other.idcopies))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "globantWorkshop.models.entities.Copies[ idcopies=" + idcopies + " ]";
    }
    
}
