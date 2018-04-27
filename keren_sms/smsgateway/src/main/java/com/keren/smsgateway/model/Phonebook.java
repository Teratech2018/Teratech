/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import com.keren.smsgateway.model.Contact.ContactLocation;
import java.util.Collection;
import java.util.LinkedList;

/**
 *The Phonebook class represents the phonebook. All phonebook entries are kept
 * in the <b>contacts</b> collection. The class also provides some convinience /
 * filtering methods for retrieving the contacts.
 * @author BEKO
 */
public class Phonebook {
      private Collection<Contact> contacts;

	public Phonebook()
	{
		this.contacts = new LinkedList<Contact>();
	}

	/**
	 * Returns the contacts' collection with all (unfiltered) entries.
	 * @return The contacts' collection.
	 */
	public Collection<Contact> getContacts()
	{
		return this.contacts;
	}

	/**
	 * Filters the contacts by contact type and returns a collection of contacts matching the criteria.
	 * @param type The contact type.
	 * @return The contacts' collection matching the criteria. If no matching contact(s) is found, returns an empty collection. 
	 */
	public Collection<Contact> getContacts(ContactLocation type)
	{
		String loc;
		Collection<Contact> filteredContacts = new LinkedList<Contact>();
		loc = Contact.convertTypeToLocation(type);
		if (loc.length() > 0)
		{
			for (Contact c : getContacts())
			{
				if (c.getMemLoc().equalsIgnoreCase(loc)) filteredContacts.add(c);
			}
		}
		return filteredContacts;
	}
}
