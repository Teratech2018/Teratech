/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.annotationsprocessor.ValidateAndFillBeans;
import com.megatim.common.jaxb.entities.Fileline;
import com.megatim.common.jaxb.entities.Linecolumn;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.security.model.Utilisateur;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.model.referentiels.Classe;
import com.megatimgroup.model.referentiels.Devise;
import com.megatimgroup.model.referentiels.Division;
import com.megatimgroup.model.referentiels.Groupe;
import com.megatimgroup.model.referentiels.Motif;
import com.megatimgroup.model.referentiels.Nationalite;
import com.megatimgroup.model.referentiels.NatureClientele;
import com.megatimgroup.model.referentiels.NatureJuridique;
import com.megatimgroup.model.referentiels.Pays;
import com.megatimgroup.model.referentiels.PrecisionDateNaissance;
import com.megatimgroup.model.referentiels.Qualite;
import com.megatimgroup.model.referentiels.Section;
import com.megatimgroup.model.referentiels.SensOperation;
import com.megatimgroup.model.referentiels.StatusResidence;
import com.megatimgroup.model.referentiels.Titre;
import com.megatimgroup.model.referentiels.TypeOperation;
import com.megatimgroup.model.referentiels.Ville;
import com.megatimgroup.views.operations.ImportEditPanel;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Commercial_2
 */
public class ConversionJob extends AbstractJobExecutor{

    
    private Temporalfile temporalFile ;
    
    private List<NodeObject> rules ;
    
    private Class<?> clazz ;
    
    private List results ;
    /**
     * 
     * @param nextJob 
     */
    public ConversionJob(AbstractJobExecutor nextJob) {
        super(nextJob);
        
         MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
        //bundle = MessagesBundle.getInstace("consolemessages");
        //Initialisation du Dispatcher validate.header
        initialieMessageDispatcher(MessagesBundle.getMessage("convert.header"));   
    }

    
    
    
    @Override
    public void process() {
        try {
                 //System.out.println(" :::::::::::::::::::::::::::::::::::::::::::::::   "+rules);
                //Message de demarrage
                publish(buildMessage(MessagesBundle.getMessage("convert.start"), MessageType.INITIAL));
                 //Conversio des données en
                 results = fillBean(clazz, rules, temporalFile);
                 //Message de demarrage
                 publish(buildMessage(MessagesBundle.getMessage("convert.end"), MessageType.DONE));
                
            
        } catch (Exception ex) {
            publish(buildMessage(MessagesBundle.getMessage("convert.error"), MessageType.IN_ERROR));
            Logger.getLogger(ConversionJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if(nextJob!=null){
             nextJob.setListener(listener);
            if(nextJob instanceof PullJob){
                ((PullJob)nextJob).setInputs(results);
            }
            //Execution
            nextJob.process();
        }
    }

    /**
     * 
     * @param temporalFile 
     */
    public void setTemporalFile(Temporalfile temporalFile) {
        this.temporalFile = temporalFile;
    }

    /**
     * 
     * @param rules 
     */
    public void setRules(List<NodeObject> rules) {
        this.rules = rules;
    }

    /**
     * 
     * @param clazz 
     */
    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
    
    
    
    
    /**
     *
     * @param clazz
     * @param rules
     * @param line
     * @return
     */
    public List fillBean(Class<?> clazz, List<NodeObject> rules, Temporalfile file) throws InstantiationException, IllegalAccessException {

        List datas = new ArrayList();

        for (Fileline line : file.getFileline()) {
          if(!isLineEmpty(line)){  
            Object result = fillBean(clazz, rules, line);
            datas.add(result);
          }
        }
        return datas;
    }

    /**
     *
     * @param clazz
     * @param rules
     * @param line
     * @return
     */
    private Object fillBean(Class<?> clazz, List<NodeObject> rules, Fileline line) throws InstantiationException, IllegalAccessException {

        HashMap<String, NodeObject> map = new HashMap<String, NodeObject>();

        
        //Construction du Map
        Map<String , Linecolumn> database = new HashMap<String, Linecolumn>();
        
        for(Linecolumn column : line.getLinecolumn()){
            database.put(column.getName(), column);
        }
        int index = 0;

        for (NodeObject node : rules) {
//             if(index<line.getLinecolumn().size()){
              Linecolumn col = database.get(node.getName());
              if(col!=null){
                    node.setValue(converter(node.getClazz(), col.getValue()));
//                    System.out.println("ImportDialog.beforeSave() :::::::::::::::::::::::::: " + node.getName() + " :::::=====================================" + col.getName() + " ::::: " + node.getValue() + " ::::: "+col.getValue() );
                    map.put(node.getName(), node);
              }
//            }
            index++;
        }

        Object cible = clazz.newInstance();

        Field[] fields = ValidateAndFillBeans.getObjectDeclaredFields(clazz);

        for (Field field : fields) {

            NodeObject node = map.get(field.getName());

            if (node == null) {
                continue;
            }
            field.setAccessible(true);
            //System.out.println("ImportDialog.beforeSave() :::::::::::::::::::::::::: " + node + " :::::=====================================" + node.getClazz() + " ::::: " + node.getValue() + " ::::: " + field.getName());

            if (!node.isEntry()) {
                field.set(cible, node.getValue());
            } else {
                field.set(cible, node.getValue());
            }
        }
        return cible;
    }
    
      /**
     * Convertir la valeur en object
     * @param clazz
     * @param value
     * @return 
     */
    public Object converter(Class<?> clazz , String value){
        
//        if(value==null||value.trim().isEmpty()) return null;
                
        if(clazz.equals(BigDecimal.class))
               return new BigDecimal(value);
        else if(clazz.equals(Date.class)){
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            try {
                  if(value!=null&&!value.trim().isEmpty()&&!value.trim().equalsIgnoreCase("null")){
                      return format.parse(value);
                  }else {
                      return null;
                  }
            } catch (ParseException ex) {
                Logger.getLogger(ConversionJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(clazz.equals(Ville.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(TypeOperation.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Titre.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(StatusResidence.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
            //return datas!=null&&!datas.isEmpty() ? datas.get(0) : null;
        }else if(clazz.equals(SensOperation.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Section.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Qualite.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(PrecisionDateNaissance.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Pays.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(NatureJuridique.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(NatureClientele.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Nationalite.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Motif.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Groupe.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Division.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Devise.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }else if(clazz.equals(Classe.class)){
            GenericManager manager = (GenericManager) ManagerHelper.getManager(clazz).keySet().toArray()[0];
            return manager.find("code", value);
        }
        return value;
    }
    
     /**
     * 
     * @param line
     * @return 
     */
    private boolean isLineEmpty(Fileline line){
        
        boolean result = true ;
        
        for(Linecolumn col : line.getLinecolumn()){
            result &= (col.getValue()==null||col.getValue().trim().isEmpty());
        }
        
        return result;
        
    }
    
    
    /**
     * 
     * @param container 
     */
    public void setContainer(ImportEditPanel container) {
        setListener(container);
//        messageDispacher.addObserver(container);
//        EbayMessageItem messageItem = new EbayMessageItem();
//        messageItem.setDateMessage(new Date());
//        messageItem.setMessage("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
//       
//        message.addMessage(messageItem);
        
    }
}
