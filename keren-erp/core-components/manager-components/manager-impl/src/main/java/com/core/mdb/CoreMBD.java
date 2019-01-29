/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.mdb;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.core.application.ResourceRegistry;
import com.core.application.ResourceRegistryDAOLocal;
import com.core.calendar.Event;
import com.core.calendar.EventDAOLocal;
import com.core.calendar.Rappel;
import com.core.calendar.RappelDAOLocal;
import com.core.discussions.Canal;
import com.core.discussions.CanalDAOLocal;
import com.core.discussions.Follower;
import com.core.discussions.FollowerDAOLocal;
import com.core.discussions.MessageOrientation;
import com.core.discussions.SMessage;
import com.core.discussions.SMessageDAOLocal;
import com.core.email.Email;
import com.core.email.EmailDAOLocal;
import com.core.referentiels.PieceJointe;
import com.core.securites.Utilisateur;
import com.core.securites.UtilisateurDAOLocal;
import com.kerem.commons.KerenCoreMDBHelper;
import com.kerem.core.FileHelper;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     
    @EJB(name = "ResourceRegistryDAO")
    protected ResourceRegistryDAOLocal resourcedao;
    
    @EJB(name = "UtilisateurDAO")
    protected UtilisateurDAOLocal userdao;
    
    @EJB(name = "RappelDAO")
    protected RappelDAOLocal rappeldao;
    
    @EJB(name = "CanalDAO")
    protected CanalDAOLocal canaldao;
    
    
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
                }else if(objMessage.getObject() instanceof KerenCoreMDBHelper.SMessage){
                    KerenCoreMDBHelper.SMessage entity = (KerenCoreMDBHelper.SMessage) objMessage.getObject();
                    SMessage message = convert(entity);
                    smessagedao.send(message);
                }else if(objMessage.getObject() instanceof KerenCoreMDBHelper.Event){
                    KerenCoreMDBHelper.Event entity = (KerenCoreMDBHelper.Event) objMessage.getObject();
                    Event event = convert(entity);
                    eventdao.save(event);
                }else if(objMessage.getObject() instanceof KerenCoreMDBHelper.Follower){
                    KerenCoreMDBHelper.Follower entity = (KerenCoreMDBHelper.Follower) objMessage.getObject();
                    Follower follower = convert(entity);
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
                }else if(objMessage.getObject() instanceof ResourceRegistry){
                     ResourceRegistry registre = (ResourceRegistry) objMessage.getObject();
                     //Verifier que la resource existe déjà
                     RestrictionsContainer container = RestrictionsContainer.newInstance();
                     container.addEq("srcname", registre.getSrcname());
                     container.addEq("ownerentity", registre.getOwnerentity());
                     container.addEq("_instance", registre.getInstance());
                     if(registre.getOwnermodele()!=null){
                         container.addEq("ownermodele", registre.getOwnermodele());
                     }//end if(registre.getOwnermodele()!=null){
                     List<ResourceRegistry> dbresources = resourcedao.filter(container.getPredicats(), null, null, 0, -1);
                     if(!dbresources.isEmpty()){
                         ResourceRegistry dbresource = dbresources.get(0);
                         registre.setId(dbresource.getId());registre.setCompareid(dbresource.getCompareid());
                         if(registre.getSrcname()==null){
                             resourcedao.delete(dbresource.getId());
                             //Suppression du fichier 
                             //Suppression de la resource 
                             FileHelper.setCurrentModule(null);
                             if(registre.getOwnermodele()!=null){
                                FileHelper.setCurrentModule(registre.getOwnermodele());
                             }//end if(registre.getOwnermodele()!=null){
                            StringBuilder _builder = new StringBuilder(FileHelper.getStaticDirectory().toString());
                            _builder.append(File.separator).append(dbresource.getStorename());
                            FileHelper.deleteFile(new File(_builder.toString()));
                         }else{
                            
                                    resourcedao.update(registre.getId(), registre);
                                    //Deplacement du nouveau fichier
                                    StringBuilder _tmpbuilder = new StringBuilder(FileHelper.getTemporalDirectory().toString());
                                    _tmpbuilder.append(File.separator).append(registre.getSrcname());
                                    FileHelper.setCurrentModule(null);
                                    if(registre.getOwnermodele()!=null){
                                        FileHelper.setCurrentModule(registre.getOwnermodele());
                                    }//end if(registre.getOwnermodele()!=null){
                                    StringBuilder _builder = new StringBuilder(FileHelper.getStaticDirectory().toString());
                                    _builder.append(File.separator).append(registre.getStorename());    
                                    File tmpFile = new File(_tmpbuilder.toString());
                                    if(tmpFile.exists()){
                                        tmpFile.renameTo(new File(_builder.toString()));
    //                                    FileHelper.moveFile(tmpFile, );
                                    }//end if(tmpFile.exists()){
                                    //Suppression si necessaire
                                    if(!dbresource.getSrcname().trim().equalsIgnoreCase(registre.getSrcname().trim())){
                                          //Suppression de la resource 
                                             _builder = new StringBuilder(FileHelper.getStaticDirectory().toString());
                                             _builder.append(File.separator).append(dbresource.getStorename());
                                            FileHelper.deleteFile(new File(_builder.toString()));
                                    }//end if(dbresource.getSrcname().trim().equalsIgnoreCase(registre.getSrcname().trim())){
                            
                         }//end if(registre.getSrcname()==null){                         
                     }else if(registre.getSrcname()!=null){
                         resourcedao.save(registre);
                        FileHelper.setCurrentModule(null);
                        //Deplacement du nouveau fichier
                        StringBuilder _tmpbuilder = new StringBuilder(FileHelper.getTemporalDirectory().toString());
                        _tmpbuilder.append(File.separator).append(registre.getSrcname());
                        if(registre.getOwnermodele()!=null){
                            FileHelper.setCurrentModule(registre.getOwnermodele());
                        }//end if(registre.getOwnermodele()!=null){
                        StringBuilder _builder = new StringBuilder(FileHelper.getStaticDirectory().toString());
                        _builder.append(File.separator).append(registre.getStorename());    
                        File tmpFile = new File(_tmpbuilder.toString());
//                        System.out.println(CoreMBD.class.toString()+".onMessage(Message rcvMessage) ============== temp : "+tmpFile.toString()+" ==== store : "+_builder.toString());                                    
                        if(tmpFile.exists()){
                            tmpFile.renameTo(new File(_builder.toString()));
//                            FileHelper.moveFile(tmpFile, new File(_builder.toString()));
                        }//end if(tmpFile.exists()){
                     }//end if(!dbresource.isEmpty()){
                }//end if(objMessage.getObject() instanceof Email){
            }//end if (rcvMessage instanceof TextMessage) {
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {
            Logger.getLogger(CoreMBD.class.getName()).log(Level.WARNING, null, ex);
        }
    }
   
    /**
     * 
     * @param entity
     * @return 
     */
    private Follower convert(KerenCoreMDBHelper.Follower entity){
       Follower follower = new Follower(entity.getDate(), entity.getEntityserial(), entity.getEntityid(), entity.getBody(),entity.getNoteinterne(), entity.getActif());
       if(entity.getSenderid()!=null && entity.getSenderid()>0){
           follower.setSender((Utilisateur) userdao.findByPrimaryKey("id", entity.getSenderid()));
       }//end if(entity.getSenderid()!=null && entity.getSenderid()>0){
       //Traitement des canaux
        if(entity.getCanaux()!=null && !entity.getCanaux().isEmpty()){
             for(Long id : entity.getCanaux()){
                if(id!=null && id>0){
                    follower.getCanaux().add(new Canal((Canal) canaldao.findByPrimaryKey("id", id)));
                }//end if(id!=null && id>0){
            }//end for(Long id : entity.getRecieversid()){
        }//end if(entity.getCanauxid()!=null && !entity.getCanauxid().isEmpty()){
        if(entity.getAbonnes()!=null && ! entity.getAbonnes().isEmpty()){
            for(Long id : entity.getAbonnes()){
                if(id!=null && id>0){
                    follower.getAbonnes().add(new Utilisateur((Utilisateur) userdao.findByPrimaryKey("id", id)));
                }//end if(id!=null && id>0){
            }//end for(Long id : entity.getRecieversid()){
        }//end if(entity.getRecieversid()!=null && ! entity.getRecieversid().isEmpty()){
        if(entity.getMessages()!=null && !entity.getMessages().isEmpty()){
            for(KerenCoreMDBHelper.SMessage messae : entity.getMessages()){
                follower.getMessages().add(convert(messae));
            }//end for(KerenCoreMDBHelper.SMessage messae : entity.getMessages()){
        }//end if(entity.getMessages()!=null && !entity.getMessages().isEmpty()){
       return follower;
    }
    
    /**
     * 
     * @param entity
     * @return 
     */
    private SMessage convert(KerenCoreMDBHelper.SMessage entity){
        SMessage msge = new SMessage(entity.getDate(), entity.getBody(), entity.isStatus(), entity.getEntityserial(), entity.getEntityid(), MessageOrientation.valueOf(entity.getTypeMessage().toString()));
        if(entity.getCanalid()!=null && entity.getCanalid()>0){
            msge.setCanal((Canal) canaldao.findByPrimaryKey("id", entity.getCanalid()));
        }//end if(entity.getCanalid()!=null && entity.getCanalid()>0){
        if(entity.getSenderid()!=null && entity.getSenderid()>0){
            msge.setSender((Utilisateur) userdao.findByPrimaryKey("id", entity.getSenderid()));
        }//end if(entity.getSenderid()!=null && entity.getSenderid()>0){
        if(entity.getRecieverid()!=null && entity.getRecieverid()>0){
            msge.setReciever((Utilisateur) userdao.findByPrimaryKey("id", entity.getRecieverid()));
        }//end if(entity.getRecieverid()!=null && entity.getRecieverid()>0){
        if(entity.getRecieversid()!=null && ! entity.getRecieversid().isEmpty()){
            for(Long id : entity.getRecieversid()){
                if(id!=null && id>0){
                    msge.getRecievers().add(new Utilisateur((Utilisateur) userdao.findByPrimaryKey("id", id)));
                }//end if(id!=null && id>0){
            }//end for(Long id : entity.getRecieversid()){
        }//end if(entity.getRecieversid()!=null && ! entity.getRecieversid().isEmpty()){
        if(entity.getCanauxid()!=null && !entity.getCanauxid().isEmpty()){
             for(Long id : entity.getCanauxid()){
                if(id!=null && id>0){
                    msge.getCanaux().add(new Canal((Canal) canaldao.findByPrimaryKey("id", id)));
                }//end if(id!=null && id>0){
            }//end for(Long id : entity.getRecieversid()){
        }//end if(entity.getCanauxid()!=null && !entity.getCanauxid().isEmpty()){
        //Traitement des pèices jointes
//        if(entity.getPiecesjointe()!=null && !entity.getPiecesjointe().isEmpty()){
            for(KerenCoreMDBHelper.PieceJointe pj : entity.getPiecesjointe()){
                msge.getPiecesjointe().add(new PieceJointe(pj.getFilename(), pj.getAttachename(), pj.getEntityserial(), pj.getEntityid()));
            }//end for(KerenCoreMDBHelper.PieceJointe pj : entity.getPiecesjointe()){
//        }//end if(entity.getPiecesjointe()!=null && !entity.getPiecesjointe().isEmpty()){
        return msge;
    }
     
    /**
     * 
     * @param entity
     * @return 
     */
    private Event convert(KerenCoreMDBHelper.Event entity){
        Event event = new Event(entity.getTitle(), entity.getDescription(), entity.getStart(), entity.getEnd(), entity.getDuree(), entity.getLieu());
        Date today = new Date(); event.setCompareid(today.getTime());
        event.setNotify(entity.isNotify());event.setConfidentialite(entity.getConfidentialite());
        event.setAllDay(entity.isAllDay());event.setDisponibilite(entity.getDisponibilite());
        if(entity.getRappelid()!=null && entity.getRappelid()>0){
            event.setRappel((Rappel) rappeldao.findByPrimaryKey("id", entity.getRappelid()));
        }//end if(entity.getRappelid()!=null && entity.getRappelid()>0){
        if(entity.getOwnerid()!=null && entity.getOwnerid()>0){
            event.setOwner((Utilisateur) userdao.findByPrimaryKey("id", entity.getOwnerid()));
        }//end if(entity.getOwnerid()!=null && entity.getOwnerid()>0){
        if(entity.getParticipants()!=null && !entity.getParticipants().isEmpty()){
            for(Long id : entity.getParticipants()){
                if(id!=null && id>0){
                    event.getParticipants().add(new Utilisateur((Utilisateur) userdao.findByPrimaryKey("id", id)));
                }//end if(id!=null && id>0){
            }//end for(Long id : entity.getParticipants()){
        }//end if(entity.getParticipants()!=null && !entity.getParticipants().isEmpty()){
        return event;
    }
}
