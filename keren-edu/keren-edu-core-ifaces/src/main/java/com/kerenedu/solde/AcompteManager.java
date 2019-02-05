
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 16:18:27 WAT 2018
 * 
 */
public interface AcompteManager
    extends GenericManager<Acompte, Long>
{

    public final static String SERVICE_NAME = "AcompteManager";
    public Acompte confirme(Acompte entity);
	
  	public Acompte paye(Acompte entity,PeriodePaie periode);

  	
  	public Acompte annule(Acompte entity);
  	
  	public boolean disponible(Acompte entity, PeriodePaie periode);
}
