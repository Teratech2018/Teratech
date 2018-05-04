/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.scheduler;

import com.keren.smsgateway.model.Service;

/**
 *
 * @author BEKO
 */
public abstract class ASchedulerTask implements Runnable{
    
    String name;

    Service service;

    volatile boolean enabled;

    public ASchedulerTask(String myName, Service myService)
    {
            setName(myName);
            setService(myService);
            disable();
    }

    public String getName()
    {
            return this.name;
    }

    public void setName(String myName)
    {
            this.name = myName;
    }

    Service getService()
    {
            return service;
    }

    void setService(Service service)
    {
            this.service = service;
    }

    public boolean isEnabled()
    {
            return this.enabled;
    }

    public void enable()
    {
            this.enabled = true;
    }

    public void disable()
    {
            this.enabled = false;
    }

    public void run()
    {
            if (isEnabled())
            {
                    getService().getLogger().logDebug("Running task: " + getName(), null, null);
                    process();
            }
            else getService().getLogger().logDebug("Task is disabled: " + getName(), null, null);
    }

    public abstract void process();
}
