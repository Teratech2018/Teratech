
package com.core.templates;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 06 11:57:26 WAT 2018
 * 
 */
public interface TemplateManager
    extends GenericManager<Template, Long>
{

    public final static String SERVICE_NAME = "TemplateManager";

}
