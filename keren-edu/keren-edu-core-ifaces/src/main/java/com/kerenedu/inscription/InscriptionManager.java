
package com.kerenedu.inscription;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.search.EleveSearch;
import com.kerenedu.reglement.FichePaiement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
public interface InscriptionManager
    extends GenericManager<Inscription, Long>
{

    public final static String SERVICE_NAME = "InscriptionManager";
    
    public List<Inscription> getCriteres(EleveSearch critere);
    
    public Inscription changerClasse(ChangeClasse entity);
    
    public List<FichePaiement>getFicheEleve(Inscription entity);
    
    public List<Inscription> getCriteres(Inscription critere) ;

}
