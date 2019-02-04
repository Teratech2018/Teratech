
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewEtatPret;
import com.kerenedu.model.report.ViewPeriodeModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jan 24 15:14:55 WAT 2019
 * 
 */
public interface ViewEtatPretManager
    extends GenericManager<ViewEtatPret, Long>
{

    public final static String SERVICE_NAME = "ViewEtatPretManager";
    
	public List<ViewEtatPret> getCriteres(ViewPeriodeModal critere);

}
