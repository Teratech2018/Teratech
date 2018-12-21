/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerem.commons;

import com.core.calendar.Event;
import com.core.discussions.Follower;
import com.core.discussions.SMessage;
import com.core.email.Email;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;

/**
 *Message Driven Bean Builder Helper
 * @author BEKO
 */
public class KerenCoreMDBHelper {
    
    /**
     * 
     * @param text
     * @param connectionFactory
     * @param destination
     * @throws JMSException 
     */
    public static void textMessageProducer(String text,ConnectionFactory connectionFactory,Destination destination) throws JMSException{
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
    public static void eventMessageProducer(Event event ,ConnectionFactory connectionFactory,Destination destination) throws JMSException{
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
     * @param follower
     * @param connectionFactory
     * @param destination 
     * @throws javax.jms.JMSException 
     */
    public static void followerMessageProducer(Follower follower ,ConnectionFactory connectionFactory,Destination destination) throws JMSException{
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
    public static void kmessageMessageProducer(SMessage msge ,ConnectionFactory connectionFactory,Destination destination) throws JMSException{
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
     * @param connectionFactory
     * @param destination 
     */
    public static void mailMessageProducer(Email mail  ,ConnectionFactory connectionFactory,Destination destination) throws JMSException{
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
}
