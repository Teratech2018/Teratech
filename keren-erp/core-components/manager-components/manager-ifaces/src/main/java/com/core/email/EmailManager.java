
package com.core.email;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Thu May 03 15:12:05 GMT+01:00 2018
 * 
 */
public interface EmailManager
    extends GenericManager<Email, Long>
{

    public final static String SERVICE_NAME = "EmailManager";
    
    /**
     * Envoie directe du mail
     * @param mail 
     * @throws javax.mail.internet.AddressException 
     */
    public void sendmail(Email mail) throws AddressException,MessagingException;

}
