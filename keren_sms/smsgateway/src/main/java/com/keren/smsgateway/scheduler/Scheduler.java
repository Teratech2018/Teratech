/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.scheduler;

import com.keren.smsgateway.helper.Logger;
import com.keren.smsgateway.model.Service;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author BEKO
 */
public class Scheduler {
      ScheduledThreadPoolExecutor executor;

	Service srv;

	Logger logger;

	public Scheduler(Service myService, Logger myLogger, int pool)
	{
		this.executor = new ScheduledThreadPoolExecutor(pool);
		this.srv = myService;
		this.logger = myLogger;
	}

	Service getService()
	{
		return this.srv;
	}

	Logger getLogger()
	{
		return this.logger;
	}

	ScheduledThreadPoolExecutor getExecutor()
	{
		return this.executor;
	}

	public boolean executeOnce(ASchedulerTask myTask)
	{
		getExecutor().execute(myTask);
		return true;
	}

	public boolean executeOnceAfter(ASchedulerTask myTask, int myDelay, TimeUnit myTimeUnit)
	{
		getExecutor().schedule(myTask, myDelay, myTimeUnit);
		return true;
	}

	public boolean scheduleAtFixedRate(ASchedulerTask myTask, long myInitialDelay, long myPeriod, TimeUnit myTimeUnit)
	{
		getExecutor().scheduleAtFixedRate(myTask, myInitialDelay, myPeriod, myTimeUnit);
		return true;
	}

	public boolean scheduleWithFixedDelay(ASchedulerTask myTask, long myInitialDelay, long myPeriod, TimeUnit myTimeUnit)
	{
		getExecutor().scheduleWithFixedDelay(myTask, myInitialDelay, myPeriod, myTimeUnit);
		return true;
	}

	public boolean remove(ASchedulerTask myTask)
	{
		myTask.disable();
		return getExecutor().remove(myTask);
	}

	public void shutdown()
	{
		getExecutor().shutdown();
	}
}
