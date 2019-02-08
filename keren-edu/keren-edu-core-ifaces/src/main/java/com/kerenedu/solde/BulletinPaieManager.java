
package com.kerenedu.solde;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.EdtMasseSalModal;
import com.kerenedu.model.report.EdtPeriodeModal;
import com.kerenedu.model.report.ViewPeriodeModal;
import com.kerenedu.model.report.ViewRetenueModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 15:46:58 WAT 2018
 * 
 */
public interface BulletinPaieManager
    extends GenericManager<BulletinPaie, Long>
{

    public final static String SERVICE_NAME = "BulletinPaieManager";
    //public List<BulletinPaie> getCriteres(BPaie critere);
    
    public List<BulletinPaie> getCriteres(BulletinPaie critere);
    
    public List<BulletinPaie> getCriteres(EdtPeriodeModal critere);
    
    public List<BulletinPaie> getCriteres(ViewPeriodeModal critere);
    
    public void validerSalaire(TraitSalaire entity);
	public List<BulletinPaie> getCriteres(EdtMasseSalModal critere);
	
	public List<BulletinPaie> getCriteres(ViewRetenueModal critere, String value);
}
