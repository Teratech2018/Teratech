/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.allerte;

import java.io.Serializable;
import java.util.Date;

import com.core.base.BaseElement;


public class Event extends BaseElement implements Serializable,Comparable<Event>{
    
    private String title ;

    private String description;
    

    private Date start;
    
    private Date end;
    
    //@Temporal(TemporalType.TIME)
    private String duree ;
    
    private boolean recurrent = false ;
    
    private short confidentialite =0;
    
    private short disponibilite =0;
    
    private String lieu ;
    
    private boolean allDay = false;
    

    private Long rappel ;
    
    private boolean notify = true ;
    
    private Long[] participantsId ;
    
    private Long ownerId; 
    
    /**
     * 
     */
    public Event() {
    }

    /**
     * 
     * @param title
     * @param description
     * @param start
     * @param end
     * @param duree
     * @param lieu
     * @param allDay 
     */
    public Event(String title, String description, Date start, Date end, String duree, String lieu, boolean allDay) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.duree = duree;
        this.lieu = lieu;
        this.allDay = allDay;
    }
    
     public Event(Event event) {
        this.id = event.id;
        this.title = event.title;
        this.description = event.description;
        this.start = event.start;
        this.end = event.end;
        this.duree = event.duree;
        this.recurrent=event.recurrent;
        this.confidentialite = event.confidentialite;
        this.disponibilite=event.disponibilite;
        this.lieu = event.lieu;
        this.allDay = event.allDay;
        this.rappel=event.rappel;
        this.notify = event.notify;
        this.ownerId = new Long(event.ownerId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public boolean isRecurrent() {
        return recurrent;
    }

    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }

    public short getConfidentialite() {
        return confidentialite;
    }

    public void setConfidentialite(short confidentialite) {
        this.confidentialite = confidentialite;
    }

   
    
    

    public short getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(short disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

   
    public boolean isNotify() {
        return notify;
    }

    public Long getRappel() {
		return rappel;
	}

	public void setRappel(Long rappel) {
		this.rappel = rappel;
	}


	public Long[] getParticipantsId() {
		return participantsId;
	}

	public void setParticipantsId(Long[] participantsId) {
		this.participantsId = participantsId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setNotify(boolean notify) {
        this.notify = notify;
    }

   
    
    @Override
    public int compareTo(Event o) {
        //To change body of generated methods, choose Tools | Templates.
        return title.compareTo(o.title);
    }
    
}
