
package com.kerenedu.inscription;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.school.Eleve;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jan 09 20:37:11 WAT 2018
 * 
 */
public interface InscriptionDAO
    extends GenericDAO<Inscription, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "InscriptionDAO";
    
    public Inscription getInscriptionEtudiantByAnnee(Eleve eleve, AnneScolaire annee) ;
    
    public long deleteRadfiche(Inscription ins);
    public long deleteRadPaiement(FichePaiement fp) ;
	public long deleteRadReglement(Inscription ins);
	
	public long updateforce(String value);
	
	

	

}
