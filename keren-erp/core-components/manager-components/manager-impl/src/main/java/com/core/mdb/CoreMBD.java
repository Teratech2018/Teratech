/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.mdb;

import com.core.calendar.Event;
import com.core.calendar.EventDAOLocal;
import com.core.discussions.Follower;
import com.core.discussions.FollowerDAOLocal;
import com.core.discussions.SMessage;
import com.core.discussions.SMessageDAOLocal;
import com.core.email.Email;
import com.core.email.EmailDAOLocal;
import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *Topc MDB for communicating with the core 
 * @author BEKO
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/kerencore/coremdb"),
    @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Topic"),
     @ActivationConfigProperty(propertyName = "acknowledgeMode",propertyValue = "Auto-acknowledge")
},
 mappedName = "java:/kerencore/coremdb")
public class CoreMBD implements  MessageListener{

    @EJB(name = "SMessageDAO")
    protected SMessageDAOLocal smessagedao;
    
    @EJB(name = "EventDAO")
    protected EventDAOLocal eventdao;
    
    @EJB(name = "EmailDAO")
    protected EmailDAOLocal maildao;
    
     @EJB(name = "FollowerDAO")
    protected FollowerDAOLocal followerdao;
    
    @Override
    public void onMessage(Message rcvMessage) {
        TextMessage msg = null;
        ObjectMessage objMessage = null;
        try {
            if (rcvMessage instanceof ObjectMessage) {
                objMessage = (ObjectMessage) rcvMessage;
                if(objMessage.getObject() instanceof Email){
                    Email email = (Email) objMessage.getObject();
                    maildao.save(email);
                }else if(objMessage.getObject() instanceof SMessage){
                    SMessage message = (SMessage) objMessage.getObject();
                    smessagedao.send(message);
                }else if(objMessage.getObject() instanceof Event){
                    Event event = (Event) objMessage.getObject();
                    eventdao.save(event);
                }else if(objMessage.getObject() instanceof Follower){
                    Follower follower = (Follower) objMessage.getObject();
                    if(follower.getEntityid()>0 && follower.getEntityserial()!=null&&!follower.getEntityserial().trim().isEmpty()){
                         for(SMessage msge:follower.getMessages()){
                            msge.setSender(follower.getSender());
                            if(follower.isNoteinterne()){
                                msge.setReciever(follower.getSender());
                                msge.setDate(new Date());
                            }else{
                                if(msge.getId()<0){
                                    msge.setCanaux(follower.getCanaux());
                                    msge.setRecievers(follower.getAbonnes());
                                     msge.setDate(new Date());
                                    smessagedao.send(msge);
                                }//end if(msge.getId()<0)
                            }//end if(msge.getSender()!=null&&msge.getReciever()!=null&&msge.getSender().equals(msge.getReciever())){
                        }//end for(SMessage msge:follower.getMessages()){
                    }//end if(follower.getEntityid()>0 && follower.getEntityserial()!=null&&!follower.getEntityserial().trim().isEmpty()){
                    followerdao.save(follower);
                }//end if(objMessage.getObject() instanceof Email){
            }//end if (rcvMessage instanceof TextMessage) {
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
    
}
