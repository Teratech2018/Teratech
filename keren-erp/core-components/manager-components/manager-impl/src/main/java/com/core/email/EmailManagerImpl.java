
package com.core.email;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import java.util.Date;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@TransactionAttribute
@Stateless(mappedName = "EmailManager")
public class EmailManagerImpl
    extends AbstractGenericManager<Email, Long>
    implements EmailManagerLocal, EmailManagerRemote
{

    @EJB(name = "EmailDAO")
    protected EmailDAOLocal dao;

   @Resource(name = "java:/Mail")
    private Session mailSeesion ;
    
    
    public EmailManagerImpl() {
    }

    @Override
    public GenericDAO<Email, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public void sendmail(Email mail) throws AddressException, MessagingException {
            //To change body of generated methods, choose Tools | Templates.
//            System.out.println(EmailManagerImpl.class.toString()+" ========================== "+mail+" ========== Session : "+mailSeesion);
            MimeMessage m = new MimeMessage(mailSeesion);
            InternetAddress[] to = new InternetAddress[]{
                new InternetAddress(mail.getCible())
            }; 
            
            m.setFrom(new InternetAddress(mail.getSource()));
            m.setRecipients(Message.RecipientType.TO, to);
            m.setSubject(mail.getSubject());
            m.setSentDate(new Date());
            m.setText(mail.getText(), "utf-8", "html");
            Transport.send(m);
    }

}
