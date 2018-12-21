/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.ebaytools.client.AbstractJobExecutor;

/**
 *
 * @author Commercial_2
 */
public class DBJobLaoder extends AbstractJobExecutor{

    /**
     * 
     */
    public DBJobLaoder() {
        
        super();
    }

    
    /**
     * 
     * @param nextJob 
     */
    public DBJobLaoder(AbstractJobExecutor nextJob) {
        super(nextJob);
    }

    
    
    @Override
    public void process() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
