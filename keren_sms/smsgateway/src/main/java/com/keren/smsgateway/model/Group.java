/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *Groupe de contact
 * @author BEKO
 */
@Entity
@Table(name = "SMS_GROUP")
public class Group implements Serializable,Comparable<Group>{
    @Id
    @Column(name = "GR_NAME")
    private String groupName;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SMS_GR_CON",joinColumns = @JoinColumn(name = "GR_ID"),inverseJoinColumns = @JoinColumn(name = "CO_ID"))
    private List<Contact> contacts = new ArrayList<Contact>();

    /**
     * 
     */
    public Group() {
    }

    
    
    /**
     * 
     * @param groupName 
     */
    public Group(String groupName) {
        this.groupName = groupName;
    }   
   

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    
    
    /**
	 * Returns the group name.
	 * 
	 * @return The group name.
	 */
	public String getName()
	{
		return this.groupName;
	}

	/**
	 * Returns the numbers associated with the group.
	 * 
	 * @return The numbers associated with the group.
	 */
	public Collection<String> getNumbers()
	{
		Collection<String> datas = new ArrayList<String>();
                for(Contact c:contacts){
                    datas.add(c.getNumber());
                }
               return datas;
	}

	/**
	 * Adds a number to the group.
	 * 
	 * @param number
	 *            The number to add to the group.
	 */
	public void addNumber(String number)
	{
		
	}
        
        public void addNumber(Contact contact)
	{
            if(contact!=null){
                contacts.add(contact);
            }
	}

	/**
	 * Removes a number from the group.
	 * 
	 * @param number
	 *            The number to be removed from the group.
	 * @return True if the removal was a success. False if the number was not
	 *         found.
	 */
	public boolean removeNumber(Contact contact)
	{
		return this.contacts.remove(contact);
	}
        
        /**
         * 
         * @param number
         * @return 
         */
        public boolean removeNumber(String number)
	{
		Contact cont = null;
                for(Contact c:contacts){
                    if(c.getNumber().equalsIgnoreCase(number)){
                        cont = c;
                    }//end if(c.getNumber().equalsIgnoreCase(number)){
                }//end for(Contact c:contacts){
                return cont==null ?  false : contacts.remove(cont);
	}

	/**
	 * Removes all numbers from the group (clears the group).
	 */
	public void clear()
	{
		this.contacts.clear();
	}

    @Override
    public int compareTo(Group o) {
        //To change body of generated methods, choose Tools | Templates.
        return groupName.compareTo(o.groupName);
    }
    
}
