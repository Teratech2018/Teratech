
package com.teratech.gmao.core.ifaces.curative;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.curative.Diagnostic;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 16:50:23 GMT+01:00 2018
 * 
 */
public interface DiagnosticManager
    extends GenericManager<Diagnostic, Long>
{

    public final static String SERVICE_NAME = "DiagnosticManager";

}
