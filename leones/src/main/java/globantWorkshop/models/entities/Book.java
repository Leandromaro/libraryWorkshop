/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globantWorkshop.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author leandromaro
 */
@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "idbooks", nullable = false)
    private Integer idbooks;

    private String name;
    private String author;
    private Integer isbn;

    public Book() {
    }

    public Book(String name, String author, Integer isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(Integer idbooks) {
        this.idbooks = idbooks;
    }

    public Integer getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(Integer idbooks) {
        this.idbooks = idbooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbooks != null ? idbooks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.idbooks == null && other.idbooks != null) || (this.idbooks != null && !this.idbooks.equals(other.idbooks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "globantWorkshop.models.entities.Books[ idbooks=" + idbooks + " ]";
    }
    
}
