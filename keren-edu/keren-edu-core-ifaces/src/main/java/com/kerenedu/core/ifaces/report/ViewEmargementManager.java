
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewEmargement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 23 15:41:27 WAT 2018
 * 
 */
public interface ViewEmargementManager
    extends GenericManager<ViewEmargement, Long>
{

    public final static String SERVICE_NAME = "ViewEmargementManager";
    public List<ViewEmargement> getCriteres(ViewEmargement critere);

}
