/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.smsgw.model.referentiel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="T_PROORD")
@XmlRootElement
public class ProductOrder implements Serializable, Comparable<ProductOrder> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    
    @ManyToOne
    @JoinColumn(name="PROD_ID")
    private Product product;
    
    private long count ;
    
    private double total ;

    
    public ProductOrder() {
    }

    /**
     * 
     * @param product
     * @param count
     * @param total 
     */
    public ProductOrder(Product product, long count, double total) {
        this.product = product;
        this.count = count;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.product != null ? this.product.hashCode() : 0);
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
        final ProductOrder other = (ProductOrder) obj;
        if (this.product != other.product && (this.product == null || !this.product.equals(other.product))) {
            return false;
        }
        return true;
    }
    
    
    
    public int compareTo(ProductOrder o) {
        return product.compareTo(o.product);
    }
    
    
}
