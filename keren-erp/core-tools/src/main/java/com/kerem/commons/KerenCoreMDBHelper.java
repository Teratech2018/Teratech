/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerem.commons;

import com.core.application.ResourceRegistry;
import com.core.email.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *Message Driven Bean Builder Helper
 * @author BEKO
 */
public class KerenCoreMDBHelper {
    
    private static final String _CONNECTIONFACTORY = "java:/ConnectionFactory";
    
    private static final String _DESTINATION = "java:/kerencore/coremdb";
    /**
     * 
     * @param text
     * @param connectionFactory
     * @param destination
     * @throws JMSException 
     */
    public static void textMessageProducer(String text) throws JMSException, NamingException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
        Destination destination = (Destination) initialContext.lookup("java:/kerencore/coremdb");
        TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
      try{ 
        connection = (TopicConnection) connectionFactory.createConnection();
        session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage(text);
        producer.send(message);
        System.out.println(KerenCoreMDBHelper.class+" =========== Message was send to the topic");
      }finally{
         if(producer!=null){producer.close();}
         if(session!=null){session.close();}
         if(connection!=null){connection.close();}
      }
    }
    
    /**
     * 
     * @param event
     * @param connectionFactory
     * @param destination 
     * @throws javax.jms.JMSException 
     */
    public static void eventMessageProducer(Event event) throws JMSException, NamingException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
        Destination destination = (Destination) initialContext.lookup("java:/kerencore/coremdb");
         TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
        try{ 
          connection = (TopicConnection) connectionFactory.createConnection();
          session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
          producer = session.createProducer(destination);
          ObjectMessage message = session.createObjectMessage(event);
          producer.send(message);         
        }finally{
           if(producer!=null){producer.close();}
           if(session!=null){session.close();}
           if(connection!=null){connection.close();}
        }
    }
    
    /**
     * 
     * @param service
     * @throws JMSException
     * @throws NamingException 
     */
    public static void serviceMessageProducer(ServicesHelper.ServiceRegistry service) throws JMSException, NamingException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
        Destination destination = (Destination) initialContext.lookup("java:/kerencore/coremdb");
         TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
        try{ 
          connection = (TopicConnection) connectionFactory.createConnection();
          session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
          producer = session.createProducer(destination);
          ObjectMessage message = session.createObjectMessage(service);
          producer.send(message);         
        }finally{
           if(producer!=null){producer.close();}
           if(session!=null){session.close();}
           if(connection!=null){connection.close();}
        }
    }
    
    /**
     * 
     * @param follower
     * @param connectionFactory
     * @param destination 
     * @throws javax.jms.JMSException 
     */
    public static void followerMessageProducer(Follower follower) throws JMSException, NamingException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
        Destination destination = (Destination) initialContext.lookup("java:/kerencore/coremdb");
        TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
        try{ 
          connection = (TopicConnection) connectionFactory.createConnection();
          session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
          producer = session.createProducer(destination);
          ObjectMessage message = session.createObjectMessage(follower);
          producer.send(message);         
        }finally{
           if(producer!=null){producer.close();}
           if(session!=null){session.close();}
           if(connection!=null){connection.close();}
        }
    }
    
    /**
     * 
     * @param msge
     * @param connectionFactory
     * @param destination 
     * @throws javax.jms.JMSException 
     */
    public static void kmessageMessageProducer(SMessage msge) throws JMSException, NamingException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
        Destination destination = (Destination) initialContext.lookup("java:/kerencore/coremdb");
        TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
        try{ 
          connection = (TopicConnection) connectionFactory.createConnection();
          session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
          producer = session.createProducer(destination);
          ObjectMessage message = session.createObjectMessage(msge);
          producer.send(message);         
        }finally{
           if(producer!=null){producer.close();}
           if(session!=null){session.close();}
           if(connection!=null){connection.close();}
        }
    }
    
    /**
     * 
     * @param mail
     * @throws JMSException
     * @throws NamingException 
     */
    public static void mailMessageProducer(Email mail) throws JMSException, NamingException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
        Destination destination = (Destination) initialContext.lookup("java:/kerencore/coremdb");
        TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
        try{ 
          connection = (TopicConnection) connectionFactory.createConnection();
          session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
          producer = session.createProducer(destination);
          ObjectMessage message = session.createObjectMessage(mail);
          producer.send(message);         
        }finally{
           if(producer!=null){producer.close();}
           if(session!=null){session.close();}
           if(connection!=null){connection.close();}
        }
    }
    /**
     * 
     * @param from
     * @param to
     * @param date
     * @param subject
     * @param text
     * @param cc
     * @param joints
     * @throws JMSException
     * @throws NamingException 
     */
    public static void mailMessageProducer(String from , String to , Date date , String subject,String text,List<String> cc,List<String> joints) throws JMSException, NamingException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("java:/ConnectionFactory");
        Destination destination = (Destination) initialContext.lookup("java:/kerencore/coremdb");
        TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
        try{ 
          connection = (TopicConnection) connectionFactory.createConnection();
          session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
          producer = session.createProducer(destination);
          Email mail = new Email(subject, text, from, date, -1, null, null);
          mail.setCible(to);
          mail.setText(text);
          mail.setCopies(cc);
          mail.setPiecesjointes(joints);
          ObjectMessage message = session.createObjectMessage(mail);
          producer.send(message);         
        }finally{
           if(producer!=null){producer.close();}
           if(session!=null){session.close();}
           if(connection!=null){connection.close();}
        }
    }
    /**
     * Manipulation du registre des resources
     * srcname==null ==> suppression de la resource
     * sinon insertion ou mise a jour de la resource
     * @param srcname
     * @param storename
     * @param entity
     * @param modele 
     */
    public static void updateResourceRegistry(String srcname , String storename , String entity,String modele,long _instance) throws NamingException, JMSException{
        InitialContext initialContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup(_CONNECTIONFACTORY);
        Destination destination = (Destination) initialContext.lookup(_DESTINATION);
        TopicConnection connection =null;
        TopicSession session = null;
        MessageProducer producer = null;
        try{ 
          connection = (TopicConnection) connectionFactory.createConnection();
          session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
          producer = session.createProducer(destination);
          ResourceRegistry resource = new ResourceRegistry(srcname, storename, entity, modele,_instance);         
          ObjectMessage message = session.createObjectMessage(resource);
          producer.send(message);         
        }finally{
           if(producer!=null){producer.close();}
           if(session!=null){session.close();}
           if(connection!=null){connection.close();}
        }
    }
    
    
    
    /**
     * 
     */
    public static class Follower implements Serializable{
    
            protected Date date ;

             //Numero de serie de l'entite
            private String entityserial ;

            //Identifiant de l'entite
            private long entityid ;

            protected String body ;

            protected Long senderid ;

            protected List<Long> abonnes = new ArrayList<Long>();

            protected List<Long> canaux = new ArrayList<Long>();

            protected Boolean noteinterne =  false ;

            protected Boolean actif =  true ;

            protected List<SMessage> messages = new ArrayList<SMessage>();

            public Follower() {
            }

            /**
             * 
             * @param date
             * @param entityserial
             * @param entityid
             * @param body
             * @param senderid 
             */
            public Follower(Date date, String entityserial, long entityid, String body, Long senderid) {
                this.date = date;
                this.entityserial = entityserial;
                this.entityid = entityid;
                this.body = body;
                this.senderid = senderid;
            }

            public Date getDate() {
                return date;
            }

            public void setDate(Date date) {
                this.date = date;
            }

            public String getEntityserial() {
                return entityserial;
            }

            public void setEntityserial(String entityserial) {
                this.entityserial = entityserial;
            }

            public long getEntityid() {
                return entityid;
            }

            public void setEntityid(long entityid) {
                this.entityid = entityid;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public Long getSenderid() {
                return senderid;
            }

            public void setSenderid(Long senderid) {
                this.senderid = senderid;
            }

            public List<Long> getAbonnes() {
                return abonnes;
            }

            public void setAbonnes(List<Long> abonnes) {
                this.abonnes = abonnes;
            }

            public List<Long> getCanaux() {
                return canaux;
            }

            public void setCanaux(List<Long> canaux) {
                this.canaux = canaux;
            }

            public Boolean getNoteinterne() {
                return noteinterne;
            }

            public void setNoteinterne(Boolean noteinterne) {
                this.noteinterne = noteinterne;
            }

            public Boolean getActif() {
                return actif;
            }

            public void setActif(Boolean actif) {
                this.actif = actif;
            }

            public List<SMessage> getMessages() {
                return messages;
            }

            public void setMessages(List<SMessage> messages) {
                this.messages = messages;
            }

            
             
        
    }
    
    /**
     * 
     */
    public static class Event implements Serializable{
        
        private String title ;

        private String description;

        private Date start;

        private Date end;

        //@Temporal(TemporalType.TIME)
        private String duree ;

        private boolean recurrent ;

        private short confidentialite ;

        private short disponibilite ;

        private String lieu ;

        private boolean allDay ;

        private Long rappelid ;

        private boolean notify ;

        private List<Long> participants = new ArrayList<Long>();

        private Long ownerid; 

        public Event() {
            allDay = false;notify = true ;recurrent = false ;
            disponibilite =0;confidentialite =0;
        }

        /**
         * 
         * @param title
         * @param description
         * @param start
         * @param end
         * @param duree
         * @param recurrent
         * @param confidentialite
         * @param disponibilite
         * @param lieu
         * @param allDay
         * @param rappelid
         * @param notify
         * @param ownerid 
         */
        public Event(String title, String description, Date start, Date end, String duree, boolean recurrent, short confidentialite, short disponibilite, String lieu, boolean allDay, Long rappelid, boolean notify, Long ownerid) {
            this.title = title;
            this.description = description;
            this.start = start;
            this.end = end;
            this.duree = duree;
            this.recurrent = recurrent;
            this.confidentialite = confidentialite;
            this.disponibilite = disponibilite;
            this.lieu = lieu;
            this.allDay = allDay;
            this.rappelid = rappelid;
            this.notify = notify;
            this.ownerid = ownerid;
        }

        

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }

        public String getDuree() {
            return duree;
        }

        public void setDuree(String duree) {
            this.duree = duree;
        }

        public boolean isRecurrent() {
            return recurrent;
        }

        public void setRecurrent(boolean recurrent) {
            this.recurrent = recurrent;
        }

        public short getConfidentialite() {
            return confidentialite;
        }

        public void setConfidentialite(short confidentialite) {
            this.confidentialite = confidentialite;
        }

        public short getDisponibilite() {
            return disponibilite;
        }

        public void setDisponibilite(short disponibilite) {
            this.disponibilite = disponibilite;
        }

        public String getLieu() {
            return lieu;
        }

        public void setLieu(String lieu) {
            this.lieu = lieu;
        }

        public boolean isAllDay() {
            return allDay;
        }

        public void setAllDay(boolean allDay) {
            this.allDay = allDay;
        }

        public Long getRappelid() {
            return rappelid;
        }

        public void setRappelid(Long rappelid) {
            this.rappelid = rappelid;
        }

        public boolean isNotify() {
            return notify;
        }

        public void setNotify(boolean notify) {
            this.notify = notify;
        }

        public List<Long> getParticipants() {
            return participants;
        }

        public void setParticipants(List<Long> participants) {
            this.participants = participants;
        }

        public Long getOwnerid() {
            return ownerid;
        }

        public void setOwnerid(Long ownerid) {
            this.ownerid = ownerid;
        }
        
        
    }
    /**
     * 
     */
    public static class SMessage implements Serializable{       
        
        protected Date date ;   

        protected String body ;

        protected boolean status = false;

       protected List<PieceJointe> piecesjointe = new ArrayList<PieceJointe>();

       protected Long senderid ;

        protected Long canalid ;

        protected Long recieverid ;

        //Numero de serie de l'entite
        protected String entityserial ;

        //Identifiant de l'entite
        protected long entityid ;

        protected MessageOrientation typeMessage = MessageOrientation.INTERNE;
        
        private List<Long> recieversid = new ArrayList<Long>();
        
         private List<Long> canauxid = new ArrayList<Long>();

        public SMessage() {
        }

        public SMessage(Date date, String body, Long senderid, Long canalid, Long recieverid, String entityserial, long entityid) {
            this.date = date;
            this.body = body;
            this.senderid = senderid;
            this.canalid = canalid;
            this.recieverid = recieverid;
            this.entityserial = entityserial;
            this.entityid = entityid;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public List<PieceJointe> getPiecesjointe() {
            return piecesjointe;
        }

        public void setPiecesjointe(List<PieceJointe> piecesjointe) {
            this.piecesjointe = piecesjointe;
        }

        public Long getSenderid() {
            return senderid;
        }

        public void setSenderid(Long senderid) {
            this.senderid = senderid;
        }

        public Long getCanalid() {
            return canalid;
        }

        public void setCanalid(Long canalid) {
            this.canalid = canalid;
        }

        public Long getRecieverid() {
            return recieverid;
        }

        public void setRecieverid(Long recieverid) {
            this.recieverid = recieverid;
        }

        public String getEntityserial() {
            return entityserial;
        }

        public void setEntityserial(String entityserial) {
            this.entityserial = entityserial;
        }

        public long getEntityid() {
            return entityid;
        }

        public void setEntityid(long entityid) {
            this.entityid = entityid;
        }

        public MessageOrientation getTypeMessage() {
            return typeMessage;
        }

        public void setTypeMessage(MessageOrientation typeMessage) {
            this.typeMessage = typeMessage;
        }

        public List<Long> getRecieversid() {
            return recieversid;
        }

        public void setRecieversid(List<Long> recieversid) {
            this.recieversid = recieversid;
        }

        public List<Long> getCanauxid() {
            return canauxid;
        }

        public void setCanauxid(List<Long> canauxid) {
            this.canauxid = canauxid;
        }

         
         
    }
    
    public static class PieceJointe implements Serializable{
        private String filename ;
    
        private String attachename ;

        //Numero de serie de l'entite
        private String entityserial ;

        //Identifiant de l'entite
        private long entityid ;

        public PieceJointe() {
        }

        /**
         * 
         * @param filename
         * @param attachename
         * @param entityserial
         * @param entityid 
         */
        public PieceJointe(String filename, String attachename, String entityserial, long entityid) {
            this.filename = filename;
            this.attachename = attachename;
            this.entityserial = entityserial;
            this.entityid = entityid;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getAttachename() {
            return attachename;
        }

        public void setAttachename(String attachename) {
            this.attachename = attachename;
        }

        public String getEntityserial() {
            return entityserial;
        }

        public void setEntityserial(String entityserial) {
            this.entityserial = entityserial;
        }

        public long getEntityid() {
            return entityid;
        }

        public void setEntityid(long entityid) {
            this.entityid = entityid;
        }
        
        
        
        
    }
    
    public static enum MessageOrientation {

        ENVOI,
        RECEPTION,
        INTERNE
    }
   
}
