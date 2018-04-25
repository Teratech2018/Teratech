/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.smsgw.model.referentiel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="T_ORDER")
@XmlRootElement
public class Order implements Serializable , Comparable<Order> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    
    @Column(name="nom")
    private String name;
    
    private String street ;
    
    private String city;
    
    @Column(name="etat")
    private String state ;
    
    private String zip;
    
    private String country;
    
    private String giftwrap;
    
    @OneToMany(fetch= FetchType.LAZY , cascade= CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name="PRODUCT_ID")
    private List<Product> products = new ArrayList<Product>();

    /**
     * 
     */
    public Order() {
    }

    
    /**
     * 
     * @param name
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param country
     * @param giftwrap 
     */
    public Order(String name, String street, String city, String state, String zip, String country, String giftwrap) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.giftwrap = giftwrap;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGiftwrap() {
        return giftwrap;
    }

    public void setGiftwrap(String giftwrap) {
        this.giftwrap = giftwrap;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    
    
    public int compareTo(Order o) {
        return name.compareTo(o.name);
    }
    
}
