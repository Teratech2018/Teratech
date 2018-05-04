/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "SMS_PHBO")
public class Contact implements Serializable,Comparable<Contact>{
   
    private String name;
    
    @Id
    private String number;

    private String memLoc;

    private int memIndex;

    /**
     * 
     * @param myName
     * @param myNumber
     * @param myMemLoc
     * @param myMemIndex 
     */
    public Contact(String myName, String myNumber, String myMemLoc, int myMemIndex)
    {
            this.name = myName;
            this.number = myNumber;
            this.memLoc = myMemLoc;
            this.memIndex = myMemIndex;
    }

	String getName()
	{
		return name;
	}

	void setName(String name)
	{
		this.name = name;
	}

	String getNumber()
	{
		return number;
	}

	void setNumber(String number)
	{
		this.number = number;
	}

	ContactLocation getLocation()
	{
		return convertLocationToType(this.memLoc);
	}

	String getMemLoc()
	{
		return memLoc;
	}

	void setMemLoc(String memLoc)
	{
		this.memLoc = memLoc;
	}

	int getMemIndex()
	{
		return memIndex;
	}

	void setMemIndex(int memIndex)
	{
		this.memIndex = memIndex;
	}

	public String toString()
	{
		return String.format("Name: %s, Phone: %s, Loc: %s [%s:%d]", getName(), getNumber(), getLocation(), getMemLoc(), getMemIndex());
	}

	public static String convertTypeToLocation(ContactLocation type)
	{
		switch (type)
		{
			case DIALLED_CALLS:
				return "DC";
			case MISSED_CALLS:
				return "MC";
			case PHONE_ENTRIES:
				return "ME";
			case SIM_ENTRIES:
				return "SM";
			case ALL_ENTRIES:
				return "MT";
			default:
				return "";
		}
	}

	public static ContactLocation convertLocationToType(String loc)
	{
		if (loc.equalsIgnoreCase("DC")) return ContactLocation.DIALLED_CALLS;
		else if (loc.equalsIgnoreCase("MC")) return ContactLocation.MISSED_CALLS;
		else if (loc.equalsIgnoreCase("ME")) return ContactLocation.PHONE_ENTRIES;
		else if (loc.equalsIgnoreCase("SM")) return ContactLocation.SIM_ENTRIES;
		else if (loc.equalsIgnoreCase("MT")) return ContactLocation.ALL_ENTRIES;
		else return ContactLocation.UNKNOWN_ENTRY;
	}
    
     @Override
    public int compareTo(Contact o) {
       //To change body of generated methods, choose Tools | Templates.
        return number.compareTo(o.number);
    }
    
    /*
	 * Contact locations
	 */
	public enum ContactLocation
	{
		/**
		 * Represents the dialled numbers.
		 */
		DIALLED_CALLS,

		/**
		 * Represents the missed inbound calls.
		 */
		MISSED_CALLS,

		/**
		 * Represents the normal phonebook entries stored in the phone's memory.
		 */
		PHONE_ENTRIES,

		/**
		 * Represents the normal phonebook entrues stored in the SIM card.
		 */
		SIM_ENTRIES,

		/**
		 * Represents the phonebook entries from both the phone's memory and SIM card.
		 */
		ALL_ENTRIES,

		/**
		 * Represents an unknown phonebook entry.
		 */
		UNKNOWN_ENTRY
	}
}
