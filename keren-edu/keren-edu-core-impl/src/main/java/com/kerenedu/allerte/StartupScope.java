/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.allerte;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.kerenedu.dashboard.ViewDashboardManagerLocal;

@Startup
@Singleton
public class StartupScope {

    
    @EJB(name = "ViewDashboardManager")
    protected ViewDashboardManagerLocal viewManager;
    
    public final long EVENTDURATION=1000000000;//10 seconds 
    
    public final long EMAILDURATION = 10000;
    
    public enum States {BEFORESTARTED, STARTED, PAUSED, SHUTTINGDOWN};
    private States state;
    
    @PostConstruct
    @SuppressWarnings("empty-statement")
    public void initialize() {
        state = States.BEFORESTARTED;
        // Perform intialization
        state = States.STARTED;
       //Demarrage du timer des evenement
        Date  today = new Date();
        //rafraichissement du dashboard
       // viewManager.scheduleEventManager(today, EVENTDURATION);
        
        
    }
    @PreDestroy
    public void terminate() {
        state = States.SHUTTINGDOWN;
        // Perform termination
//        System.out.println(StartupBean.class+"=============================================================================================Shut down in progress");
    }
    public States getState() {
        return state;
    }
    public void setState(States state) {
        this.state = state;
    }
}
