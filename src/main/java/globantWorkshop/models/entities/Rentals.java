/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globantWorkshop.models.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author leandromaro
 */
@Entity
@Table(name = "rentals")
public class Rentals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rentals")
    private Integer idRentals;

    private Date rentalDate;
    private Date returnDate;
    private Integer posible;
    
    @JoinColumn(name = "users_idusers")
    @ManyToOne(cascade = CascadeType.ALL)
    private User users;
    
    @JoinColumn(name = "copies_idcopies")
    @ManyToOne(cascade = CascadeType.ALL)

    private Copies copies;

    public Rentals() {
    }

    public Rentals(Integer idRentals) {
        this.idRentals = idRentals;
    }

    public Integer getIdRentals() {
        return idRentals;
    }

    public void setIdRentals(Integer idRentals) {
        this.idRentals = idRentals;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getPosible() {
        return posible;
    }

    public void setPosible(Integer posible) {
        this.posible = posible;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Copies getCopies() {
        return copies;
    }

    public void setCopies(Copies copies) {
        this.copies = copies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRentals != null ? idRentals.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rentals)) {
            return false;
        }
        Rentals other = (Rentals) object;
        if ((this.idRentals == null && other.idRentals != null) || (this.idRentals != null && !this.idRentals.equals(other.idRentals))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "globantWorkshop.models.entities.Rentals[ idRentals=" + idRentals + " ]";
    }
    
}
