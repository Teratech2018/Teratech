
package com.core.templates;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Dec 06 11:57:25 WAT 2018
 * 
 */
public interface TemplateDAO
    extends GenericDAO<Template, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TemplateDAO";

}
