/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.dao.ifaces.echange.ViewOFDAO;
import com.megatimgroup.ebaytools.client.AbstractJobExecutor;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.ebaytools.client.MessageType;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.ebaytools.ebs.ESBMessageKEY;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.operations.WesternItem;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.views.operations.ImportEditPanel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author Commercial_2
 */
public class LoadingEsbJob extends AbstractJobExecutor{

    
    private List<EbayItem> results ;
    
    private ImportData imputData ;    
       
//    private ImportEditPanel container ;
//    
//    private EbayMessage message ;
    
    
    /**
     * 
     * @param nextJob 
     */
    public LoadingEsbJob(AbstractJobExecutor nextJob) {
        
        super(nextJob);
        initialieMessageDispatcher();
        //Initialisation de la liste
        results = new ArrayList<EbayItem>();  
       
           
       
    }

    /**
     * 
     */
    public LoadingEsbJob() {
        
        initialieMessageDispatcher();
        //Initialisation de la liste
        results = new ArrayList<EbayItem>();  
    }

    
    
    /**
     * 
     */
    @Override
    public void process() {
        Temporalfile template =null;
        try {
            
            File file = (File) token.get(ESBMessageKEY.FILE_STREAM);            
            //Verifier que le fichier existe 
            if(file==null) return ;
            //Publication mesage demarrage 
             MessagesBundle.setBundle(ResourceBundle.getBundle("consolemessages"));
            //Initialisation du Dispatcher
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
            initialieMessageDispatcher(MessagesBundle.getMessage("loading.header"));      
            publish(buildMessage(MessagesBundle.getMessage("loading.start")+" : "+formatter.format(new Date()), MessageType.INITIAL));
            String inbound = (String) token.get(ESBMessageKEY.INBOUND);
            Societe societe = (Societe) token.get(ESBMessageKEY.SOCIETE);
//            System.out.println("LoadingJob.process()::::::::::::::::::::::::::::::::::::::::::::::::::::  "+file+":::::::::::::::"+inbound);
            if(inbound.trim().equalsIgnoreCase("TR")){
                //Liste des EbayItem issues de 
                 List<EbayItem> items = new ArrayList<EbayItem>();
                 List<WesternItem> datas = readData(file, WesternItem.getFields());
                 //Injection de la DAO
                 IocContext context = new IocContext();
                 ViewOFDAO dao = (ViewOFDAO) context.lookup("com.megatimgroup.dao.impl.echange.ViewOFDAOImpl");
                 
                //Conversion des WesternItem en EbayItem
                //Creation du referentiel des declarations des personnes physiques et opérations financieres
                 if(datas==null) return ;
                 for(WesternItem item : datas){
                     EbayItem data = item.getItem();
                     data.setReference(dao.getnextIdPP(societe.getpPassagerId()));
                     items.add(data);
                 }
                 //Construction du temporalfiel
                List<NodeObject> nodes = EbayHelper.getNodeObjects(WesternItem.class);
                //INitialisation de la liste eventuelle des erreurs
                Temporalfile temporalefile = EbayHelper.buildFormItem(items, nodes);                 
                //Validation des personnes physiques et des Operations financieres
                Validator validator = new Validator(nodes, temporalefile, true);
                Boolean result = validator.validate();
                if(result){
                    this.token.put(ESBMessageKEY.WESTERN_ITEMS, items);
                }else{
                    this.token.put(ESBMessageKEY.WESTERN_ITEMS, new ArrayList<EbayItem>());
//                   System.out.println(LoadingEsbJob.class.getSimpleName()+".process() ======================== "+validator.getErrors());
                   this.token.put(ESBMessageKEY.ERRORS_ITEMS, validator.getErrors());
                   //Ajout des errors
                   messageDispacher.setErrors(validator.getErrors());
                   publish(buildMessage(MessagesBundle.getMessage("loading.error"), MessageType.IN_ERROR));
                   //Quitter le traitement
                   return ;
                }
            }else if(inbound.trim().equalsIgnoreCase("PP")){
                List<EbayItem> datas = readDataItems(file,EbayHelper.getFields(DeclarationPP.class));
                this.token.put(ESBMessageKEY.PP_ITEMS, datas);
            }else if(inbound.trim().equalsIgnoreCase("PM")){
                List<EbayItem> datas = readDataItems(file,EbayHelper.getFields(DeclarationPM.class));
                this.token.put(ESBMessageKEY.PM_ITEMS, datas);
            }else if(inbound.trim().equalsIgnoreCase("OF")){
                List<EbayItem> datas = readDataItems(file,EbayHelper.getFields(DeclarationFinanciere.class));
                this.token.put(ESBMessageKEY.OF_ITEMS, datas);
            }
//            token.remove(ESBMessageKEY.FILE_STREAM);
            publish(buildMessage(MessagesBundle.getMessage("loading.end")+" : "+formatter.format(new Date()), MessageType.DONE));            
            
        } catch (Exception ex) {
            publish(buildMessage(MessagesBundle.getMessage("loading.error"), MessageType.IN_ERROR));
            ex.printStackTrace();
        }
        
       
        if(nextJob!=null){
            nextJob.setListener(listener);            
            nextJob.process();
        }
    }

//    private void print(Temporalfile file){
//        
//        for(Fileline line : file.getFileline()){
//            
//            for(Linecolumn column : line.getLinecolumn()){
//                 
//                System.out.println(column.getName()+" = "+column.get);
//            }
//        }
//    }
    /**
     * Renvoie la liste des tuples 
     * @return 
     */
    public List<EbayItem> getResults() {
        return Collections.unmodifiableList(results);
    }

    /**
     * 
     * @param imputData 
     */
    public void setImputData(ImportData imputData) {
        this.imputData = imputData;
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
    
    /**
     * 
     * @param file
     * @param fields
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    private List<WesternItem> readData(File file ,String fields ) throws FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException{
        
        
        //Creation d'un 
        FileReader reader = new FileReader(file);
        //Creation d'un tempon de sortie
        BufferedReader buffer = new BufferedReader(reader);
        
        //Creation d'un line formatter
        LineFormatter formatter = new LineFormatter();
        
        String line = buffer.readLine();
        
        List<WesternItem> items = new ArrayList<WesternItem>();
        
       while(line!=null){
           
           String[] values = formatter.splitter(line, ';',',');
           
           if(values==null) continue; ;
           
//           System.out.println();
//           for(String value : values){
//               System.out.print(value+"  ::: ");
//           }
//           System.out.println(" ::: "+values.length);
             if(values!=null&&values.length==25){
                WesternItem item = convert(values, fields);

                items.add(item);
                //System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+item);
             }
//             System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+line);
                line = buffer.readLine();
       }
        //Cloture du tempon
        buffer.close();
        //Cloture du flux
        reader.close();
        
        return items;
    }
    
    /**
     * 
     * @param file
     * @param fields
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    private List<EbayItem> readDataItems(File file ,String fields ) throws FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException{
        
        
        //Creation d'un 
        FileReader reader = new FileReader(file);
        //Creation d'un tempon de sortie
        BufferedReader buffer = new BufferedReader(reader);
        
        //Creation d'un line formatter
        LineFormatter formatter = new LineFormatter();
        
        String line = buffer.readLine();
        
        List<EbayItem> items = new ArrayList<EbayItem>();
        int index = 1 ;
       while(line!=null){
           
           String[] values = formatter.splitter(line, ';',',');
           
           if(values==null) continue; ;
           
//           System.out.println(LoadingEsbJob.class.getSimpleName()+".process() ");
//           for(String value : values){
//               System.out.print(value+"  ::: ");
//           }
//           System.out.println(" ::: "+values.length);
             if(values!=null&&values.length>0){
                EbayItem item = convertItems(values, fields);
                if(item!=null){
                    items.add(item);
                }
//                System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+item);
             }
//            System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+items);
//                System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+line+" "+line.length()+" nbre fois = "+index);
                line = buffer.readLine();
                index++;
       }
//       System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+items);
        
        //Cloture du tempon
        buffer.close();
        //Cloture du flux
        reader.close();
             
        return items;
    }
    
    /**
     * 
     * @param values
     * @param fields
     * @return 
     */
    private WesternItem convert(String[] values , String fields) throws IllegalArgumentException, IllegalAccessException{
//        System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+fields);
        String[ ] fielsNames = fields.split(",");
        
        List<String> array = new ArrayList<String>();
        
        for(String fieldName : fielsNames){
            array.add(fieldName);
        }
        
        WesternItem item = new WesternItem();
        
        Field[] champs = WesternItem.class.getDeclaredFields();
        
        for(Field field : champs){
            
            field.setAccessible(true);
            
            int index = array.indexOf(field.getName());
            
            field.set(item, values[index]);
        }
        
        return item;
    }
    
    /**
     * 
     * @param values
     * @param fields
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    private EbayItem convertItems(String[] values , String fields) throws IllegalArgumentException, IllegalAccessException{
        
        String[ ] fielsNames = fields.split(",");
        
//        List<String> array = new ArrayList<String>();
//        
//        for(String fieldName : fielsNames){
//            array.add(fieldName);
//        }
//      
          
        if(fielsNames.length>values.length) return null ;
        
        EbayItem item = new EbayItem();
        
        Field[] champs = EbayItem.class.getDeclaredFields();        
      
        //Construction du Map
        Map<String , Field> map = new HashMap<String, Field>();
        //
        for(int i=0 ; i<champs.length;i++){
             map.put(champs[i].getName(), champs[i]);
        }
//          System.out.println(LoadingEsbJob.class.getSimpleName()+".readData(File file ,String fields , Class<?> itemClass) :::::::::::::::::::::::::  "+values+" ::::: "+values.length+" :: "+fields+" ::: "+fielsNames.length);
      
        int index = 0 ;
        
        for(String name : fielsNames){
            
            Field field = map.get(name);
            
            field.setAccessible(true);
            
            field.set(item, values[index]);
            
            index = index+1 ;
        }
        
        return item;
    }
    
}
