
package com.kerenedu.core.ifaces.report;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.ViewBulletin;
import com.kerenedu.school.Eleve;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 15:02:24 CET 2018
 * 
 */
public interface ViewBulletinManager
    extends GenericManager<ViewBulletin, Long>
{

    public final static String SERVICE_NAME = "ViewBulletinManager";
    
    public List<ViewBulletin> getCriteres(ViewBulletin critere);

}
