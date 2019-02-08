
package com.kerenedu.personnel;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.solde.DemandePret;
import com.kerenedu.solde.EltSalaireLigne;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 30 12:13:16 CET 2018
 * 
 */
public interface ProfesseurManager
    extends GenericManager<Professeur, Long>
{

    public final static String SERVICE_NAME = "ProfesseurManager";
    
    public List<Professeur> findprofclasse(Long id );
    
    public List<EltSalaireLigne> getLigneSalaire(Long id);
    
	public Professeur activer(Professeur entity);

  	
  	public Professeur desactiver(Professeur entity);

}
