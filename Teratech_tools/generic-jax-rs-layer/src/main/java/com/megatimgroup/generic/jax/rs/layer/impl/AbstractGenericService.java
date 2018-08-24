/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;


import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.megatim.common.annotations.OrderType;
import com.megatimgroup.generic.jax.rs.layer.annot.AnnotationsProcessor;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.megatimgroup.mgt.commons.tools.CommonTools;
import com.megatimgroup.mgt.commons.tools.FileHelper;
import com.megatimgroup.mgt.commons.tools.RulesContainer;
import com.megatimgroup.mgt.commons.tools.ValidatorError;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.naming.NamingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Commercial_2
 * @param <T>
 * @param <PK>
 */
public  abstract class AbstractGenericService< T , PK extends Serializable> implements GenericService<T , PK>{

    /**
     * Constructeur par defaut
     */
    public AbstractGenericService() {
        
        AnnotationsProcessor processor = new AnnotationsProcessor();
        try {
            processor.process(this);
        } catch (NamingException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Nom du fichier JNDI a utiliser pour 
     * localiser les Manager distant
     * @return 
     */
    public String jndiPropertiesFile(){
         return null ;
    }
    
    /**
     * Mise a jour du referentiel bancaire
     * @param entity
     * @return 
     */
    @Override
    public T save(@Context HttpHeaders headers , T entity) {
        //To change body of generated methods, choose Tools | Templates.
        //Verifier que les conditions son OK
        processBeforeSave(entity);
        //Execution du service adapter
        T resultat =  getManager().save(entity);
        //Execution de la post condition
        processAfterSave(entity);
        //Retour du resultat
        return resultat;
    }

    /**
     * Mise a jour en masse des donnÃ©es
     * @param headers
     * @param entities 
     */
    @Override
    public void save(@Context HttpHeaders headers , List<T> entities) {
        //To change body of generated methods, choose Tools | Templates.
        processBeforeSave(entities);
        getManager().save(entities);
        processAfterSave(entities);
    }

    /**
     * 
     * @param id
     * @param entity
     * @return 
     */
    @Override
    public T update(@Context HttpHeaders headers , PK id, T entity) {
       //To change body of generated methods, choose Tools | Templates.
//        String userid = headers.getRequestHeader("userid").get(0);
        processBeforeUpdate(entity);
        T result = getManager().update(id, entity);
        processAfterUpdate(entity);
        return result ;
    }

    /**
     * 
     * @param entities 
     */
    @Override
    public void update(@Context HttpHeaders headers , Map<PK, T> entities) {
        //To change body of generated methods, choose Tools | Templates.
        processBeforeUpdate(entities);
        getManager().update(entities);
        processAfterUpdate(entities);
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public T delete(@Context HttpHeaders headers , PK id) {
        //To change body of generated methods, choose Tools | Templates.
        processBeforeDelete(id);
        T result = getManager().delete(id);
        processAfterDelete(id);
        return result;
        
    }

    @Override
    public  void deleteAll(@Context HttpHeaders headers){
        Gson gson =new Gson();
//         System.out.print(headers.getRequestHeader("ids"));
         List ids = gson.fromJson(headers.getRequestHeader("ids").get(0),new TypeToken<List<Long>>(){}.getType());
         if(ids!=null){
             for(Object id : ids){
                 delete(headers,(PK) id);
             }
         }
    }

    @Override
    public Map<Long,Map<String,List<ValidatorError>>> importData(@Context HttpHeaders headers , ImportData entity){
        try {    
            String filename = getTemporalDirectory()+File.separator+entity.getFichier();
            File file = new File(filename);
             Class<?> data = Class.forName(entity.getClassName());
             Map<Long,Map<String,List<ValidatorError>>> errorsmap = new HashMap<>();
            if(file.exists()){
                Map<Long , List<String>> datas = new HashMap<Long , List<String>>();
                if(entity.getFormat().equalsIgnoreCase("cvs")){
                    datas = FileHelper.cvsToJavaConverter(filename, entity.getSeparator());
                }else {
                    datas = FileHelper.excelToJavaConverter(filename,entity.getFields().size());
                }//end if(entity.getFormat().equalsIgnoreCase("cvs")){
//                System.out.println(AbstractGenericService.class.toString()+".importData(ImportData entity) : "+entity+" ==== \n contenu fichier :"+datas+"====== import File : "+filename+" === data Type :"+data);
               //Construction of RulesContainer
                RulesContainer container = RulesContainer.newInstance();
                for(ImportLigne ligne:entity.getFields()){
                    if(!ligne.getNullable()){
                        container.addNotNullRule(ligne.getCode(), null);
                    }//endif(!ligne.getNullable()){
                    if(ligne.getUnique()){
                        container.addUniqueRule(entity.getClassName(), ligne.getCode(), null, getManager().getDao().getEntityManager());
                    }//end if(ligne.getUnique()){
                    if(ligne.getPattern()!=null && !ligne.getPattern().isEmpty()){
                        container.addPatternRule(ligne.getCode(), ligne.getPattern(), null);
                    }//end if(ligne.getPattern()!=null && !ligne.getPattern().isEmpty()){
                    if(ligne.getMin()>0){
                        container.addMinRule(ligne.getCode(), ligne.getMin(), null);
                    }//end if(ligne.getMin()>0){
                    if(ligne.getMax()>0){
                        container.addMaxRule(ligne.getCode(), ligne.getMax(), null);
                    }//end if(ligne.getMin()>0){
                    if(ligne.getLength()>0){
                        container.addLengthRule(ligne.getCode(), (short) ligne.getLength(), null);
                    }//end if(ligne.getMin()>0){
                }//end for(ImportLigne ligne:entity.getFields()){
                //Validation des donnees
                errorsmap = container.execute(datas);
                if(errorsmap.isEmpty()){//Vlidation OK
                    List entities = mapToJavaObject(entity.getClassName(), datas);
                    if(entities!=null && !entities.isEmpty()){                        
                            getManager().save(entities);                       
                    }//end if(entities!=null && !entities.isEmpty()){
                }//end if(errorsmap.isEmpty()){                
            }//end if(file.exists())        
            return errorsmap;
        } catch (ClassNotFoundException | IOException | InvalidFormatException | IllegalArgumentException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.status(Response.Status.PRECONDITION_FAILED).entity(ex.getMessage()).build());
        }
    }    

    /**
     * validate import data
     * @param entity
     * @return 
     */
    @Override
    public  Map<Long, Map<String, List<ValidatorError>>> validateImportData(@Context HttpHeaders headers , ImportData entity){
            try {    
            String filename = getTemporalDirectory()+File.separator+entity.getFichier();
            File file = new File(filename);
             Class<?> data = Class.forName(entity.getClassName());
             Map<Long,Map<String,List<ValidatorError>>> errorsmap = new HashMap<>();
            if(file.exists()){
                Map<Long , List<String>> datas = new HashMap<Long , List<String>>();
                if(entity.getFormat().equalsIgnoreCase("cvs")){
                    datas = FileHelper.cvsToJavaConverter(filename, entity.getSeparator());
                }else {
                    datas = FileHelper.excelToJavaConverter(filename,entity.getFields().size());
                }//end if(entity.getFormat().equalsIgnoreCase("cvs")){
//                System.out.println(AbstractGenericService.class.toString()+".importData(ImportData entity) : "+entity+" ==== \n contenu fichier :"+datas+"====== import File : "+filename+" === data Type :"+data);
               //Construction of RulesContainer
                RulesContainer container = RulesContainer.newInstance();
                for(ImportLigne ligne:entity.getFields()){
                    if(!ligne.getNullable()){
                        container.addNotNullRule(ligne.getCode(), null);
                    }//endif(!ligne.getNullable()){
                    if(ligne.getUnique()){
                        container.addUniqueRule(entity.getClassName(), ligne.getCode(), null, getManager().getDao().getEntityManager());
                    }//end if(ligne.getUnique()){
                    if(ligne.getPattern()!=null && !ligne.getPattern().isEmpty()){
                        container.addPatternRule(ligne.getCode(), ligne.getPattern(), null);
                    }//end if(ligne.getPattern()!=null && !ligne.getPattern().isEmpty()){
                    if(ligne.getMin()>0){
                        container.addMinRule(ligne.getCode(), ligne.getMin(), null);
                    }//end if(ligne.getMin()>0){
                    if(ligne.getMax()>0){
                        container.addMaxRule(ligne.getCode(), ligne.getMax(), null);
                    }//end if(ligne.getMin()>0){
                    if(ligne.getLength()>0){
                        container.addLengthRule(ligne.getCode(), (short) ligne.getLength(), null);
                    }//end if(ligne.getMin()>0){
                }//end for(ImportLigne ligne:entity.getFields()){
                //Validation des donnees
                errorsmap = container.execute(datas);                            
            }//end if(file.exists())        
            return errorsmap;
        } catch (ClassNotFoundException | IOException | InvalidFormatException ex) {
            Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.status(Response.Status.PRECONDITION_FAILED).entity(ex.getMessage()).build());
        }
    }

    
    /**
     * 
     * @param object
     * @param field
     * @param value
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
     protected  void affect(T object ,Field field , String value) throws IllegalArgumentException, IllegalAccessException{
        field.setAccessible(true);
//        System.out.println(AbstractGenericService.class.toString()+".affect(T object ,Field field , String value) ==== field : "+field.getName()+" === value : "+value);
        if(field.getType().equals(Boolean.class)){
                field.setBoolean(object, true);
        }else if(field.getType().equals(String.class)){
                field.set(object, value);
        }else if(field.getType().equals(Integer.class)){
                field.setInt(object, Integer.valueOf(value));
        }else if(field.getType().equals(Short.class)){
                field.setShort(object, Short.valueOf(value));
        }else if(field.getType().equals(Float.class)){
                field.setFloat(object, Float.valueOf(value));
        }else if(field.getType().equals(Double.class)){
                field.setDouble(object, Double.valueOf(value));
        }else if(field.getType().equals(Long.class)){
                field.setLong(object, Long.valueOf(value));
        }else if(field.getType().equals(BigDecimal.class)){
                field.set(object, new BigDecimal(value));
        }
    }
     
     /**
      * Get instance of T
      * @return
      * @throws InstantiationException
      * @throws IllegalAccessException 
      */
     protected T getInstance() throws InstantiationException, IllegalAccessException{
         ParameterizedType superClass  = (ParameterizedType) getClass().getGenericSuperclass();
         Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
         return type.newInstance();
     } 
     
     /**
      * 
      * @param classname
      * @param data
      * @return
      * @throws ClassNotFoundException
      * @throws IllegalArgumentException
      * @throws IllegalAccessException 
      */
      protected  List<T> mapToJavaObject(String classname , Map<Long,List<String>> data) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException{
         List result = new ArrayList();        
         List<String> fieldNames = data.get(0L);
         for(long key:data.keySet()){
           if(key>0){
               //Creation instance of Object
                T entityClass = getInstance();
                //Construction du map des champs de l'object
                Field[] fields = entityClass.getClass().getDeclaredFields();
                Map<String, Field> map = new HashMap<String, Field>();
                for(Field field : fields){
                    map.put(field.getName(), field);
                }//end for(Field field : fields){
              List<String> values = data.get(key);
              int index = 0;
              for(String fieldname:fieldNames){
                  fieldname = CommonTools.cvsString(fieldname);
                  String[] names = fieldname.split(".");
                  if(names.length==0){
                      Field field = map.get(fieldname);
//                     System.out.println(AbstractGenericService.class.toString()+".mapToJavaObject(EntityManager manager , String classname , Map<Long,List<String>> data) ============= fieldnames : "+map+" === fieldname : "+fieldname+" === map.get() : "+map.get(fieldname));
                     if(field!=null){
                         affect(entityClass, field, values.get(index));
                     }//end if(field!=null){
                  }else{//Object 
                      Field field = map.get(names[0]);
                      if(field!=null){                         
                        Object value = CommonTools.getEntity(getManager().getDao().getEntityManager(), names[0], names[1], values.get(index), field);
                        field.setAccessible(true);
                        field.set(entityClass, value);
                      }//end if(field!=null){
                  }//end if(names.length==1){
                  index++;
              }//end for(String fieldname:fieldNames){
              result.add(entityClass);
           }//end if(key>0){  
         }//end for(long key:data.keySet()){         
         return result;
    }
    
    @Override
    public  Response exportData(@Context HttpHeaders headers ,ImportData entity){
        try {
            List<String> champs = getFields(entity);
            List datas = new ArrayList<>();
            if(entity.getDatas().isEmpty()){
                datas = filter(headers, 0, -1);
            }else{
                for(Long id : entity.getDatas()){
                    datas.add(getManager().find("id", (PK) id));
                } //end for(Long id : entity.getDatas()){
            }//end if(entity.getDatas().isEmpty()){
            //Convert data to Map
            Map<Long,List<String>> map = new HashMap<>();
            map = objectToMapConverter(datas, champs);            
            //Conversion en fichier excel ou cvs
            Date today = new Date();
            String filename = getTemporalDirectory()+File.separator+entity.getFichier().toLowerCase()+today.getTime();
            if(entity.getFormat().equalsIgnoreCase("cvs")){
                filename+=".cvs";
            }else{
                filename+=".xlsx";
            }//end if(entity.getFormat().equalsIgnoreCase("cvs")){
            File file = null;
            if(entity.getFormat().equalsIgnoreCase("cvs")){
                file = FileHelper.mapToCVSConverter(map, ',', '"', filename);
            }else{
                file = FileHelper.mapToExcelConverter(map, filename);
            }//end if(entity.getFormat().equalsIgnoreCase("cvs")){
           return CommonTools.getStream(file,file.getName());
        } catch (Exception ex) {
            Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(ex.getMessage()).build();
        }
        
    }
    
    /**
     * 
     * @param datas
     * @param fields
     * @return 
     * @throws java.lang.IllegalAccessException 
     */
    public  Map<Long,List<String>> objectToMapConverter(List<T> datas,List<String> fields) throws IllegalArgumentException, IllegalAccessException{
        Map<Long,List<String>> result = new HashMap<Long,List<String>>();
        result.put(0l, fields);
        long index = 0L ;
        for(T data :  datas){
            index ++ ;
            result.put(index, objectToListConverter(data, fields));
        }//end for(Class<?> data :  datas)
        return result;
    }
    
   /**
    * 
    * @param clazz
    * @param data
    * @param fields
    * @return
    * @throws IllegalArgumentException
    * @throws IllegalAccessException 
    */
    protected  List<String> objectToListConverter(T data , List<String> fields) throws IllegalArgumentException, IllegalAccessException{
        List<String> result = new ArrayList<>();
        Field[] champs = data.getClass().getDeclaredFields();
        for(Field ele : champs){
            ele.setAccessible(true);
            for(String field : fields){
                String[] fieldPart = field.split(".");
//                System.out.println(AbstractGenericService.class.toString()+".objectToListConverter(T data , List<String> fields) ========== field : "+field+" === "+fieldPart.length);
                String key = field ;
                if(fieldPart.length>0){
                    key = fieldPart[0];
                }//end if(fieldPart.length>0){
                if(ele.getName().trim().equalsIgnoreCase(key)){
                     Object value = ele.get(data);
                    result.add(""+value);
//                    System.out.println(AbstractGenericService.class.toString()+".objectToListConverter(T data , List<String> fields) ========== field : "+result);
                }//end if(fieldPart.length==1){
            }//end for(String field : fields){
        }//end for(Field ele : champs){      
        
                
        return result;
    }
    protected List<String> getFields(ImportData entity){
        List<String> fields = new ArrayList<>();
        if(entity.getTypeexport().equalsIgnoreCase("0")){
            for(ImportLigne ligne : entity.getFields()){
                if(ligne.getSelected()==Boolean.TRUE){
                    fields.add(ligne.getCode());
                }//end if(ligne.getSelected()==Boolean.TRUE){
            }//end for(ImportLigne ligne : entity.getFields()){
        }else{
            for(ImportLigne ligne : entity.getFields()){
                fields.add(ligne.getCode());               
            }//end for(ImportLigne ligne : entity.getFields()){
        }//end if(entity.getTypeexport().equalsIgnoreCase("0")){
        return fields ;
    }
    
    
    public static File getTemporalDirectory(){
         File binDirectory = new File(System.getProperty("user.dir"));   
         String TEMP_DIR = "standalone"+File.separator+"tmp"+File.separator+"keren";
         File file = new File(binDirectory.getParent()+File.separator+TEMP_DIR);
         if(!file.exists()){
             file.mkdir();
         }//end if(!file.exists())
         return file;
    }

    @Override
    public T find(@Context HttpHeaders headers , String propertyName, PK id) {
        //To change body of generated methods, choose Tools | Templates.
//        System.out.println(AbstractGenericService.class.toString()+" === propertyName : "+propertyName+" ==============  ID : "+id);   
        return getManager().find(propertyName, id);
    }

    @Override
    public boolean unique(@Context HttpHeaders headers , String propertyName, String value){
//        System.out.println(AbstractGenericService.class.getCanonicalName()+" ====  === property : "+propertyName+" === value:"+value);       
        if(value==null){
            return true;
        }//end if(value==null){
        List result = findByUniqueProperty(headers,propertyName,value);
        return (result==null||result.isEmpty());
    }

    @Override
    public List<FilterPredicat> uniqueProperties(@Context HttpHeaders headers){
        List<FilterPredicat> results = new ArrayList<FilterPredicat>();
        Gson gson =new Gson();
        //Type predType = ;
        List contraints = gson.fromJson(headers.getRequestHeader("properties").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("properties").get(0));            
        if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat contraint = (FilterPredicat) obj;
                if(!unique(headers,contraint.getFieldName(), contraint.getValue())){
                    results.add(contraint);
                }//end if(!unique(contraint.getFieldName(), contraint.getValue()))
            }//end for(Object obj : contraints){
        }//end if(contraints!=null&&!contraints.isEmpty())
        return results;
    }    
    
    

    @Override
    public List<T> findAll(@Context HttpHeaders headers) {
         //To change body of generated methods, choose Tools | Templates.
        return getManager().findAll();
    }

    //@Override
    public List<T> findByUniqueProperty(String propertyName, Object propertyValue, Set<String> properties) {
        //To change body of generated methods, choose Tools | Templates.
        return getManager().findByUniqueProperty(propertyName, propertyValue, properties);
    }

    @Override
    public  List<T> findByUniqueProperty(@Context HttpHeaders headers , String propertyName, short propertyValue){
        //To change body of generated methods, choose Tools | Templates.
        HashSet<String> properties = new HashSet<String>();
        return getManager().findByUniqueProperty(propertyName, propertyValue, properties);
    }

    @Override
    public List<T> findByUniqueProperty(@Context HttpHeaders headers , String propertyName, int propertyValue){
        HashSet<String> properties = new HashSet<String>();
        return getManager().findByUniqueProperty(propertyName, propertyValue, properties);
    }

    @Override
    public List<T> findByUniqueProperty(@Context HttpHeaders headers , String propertyName, String propertyValue){
        //To change body of generated methods, choose Tools | Templates.
        HashSet<String> properties = new HashSet<String>();
        return getManager().findByUniqueProperty(propertyName, propertyValue, properties);
    }

    @Override
    public List<T> findByUniqueProperty(@Context HttpHeaders headers , String propertyName, long propertyValue){
        //To change body of generated methods, choose Tools | Templates.
        HashSet<String> properties = new HashSet<String>();
        return getManager().findByUniqueProperty(propertyName, propertyValue, properties);
    }
    
    

    /**
     * 
     * @param headers
     * @param firstResult
     * @param maxResult
     * @return 
     */
    @Override
    public List<T> filter(@Context HttpHeaders headers ,int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.        
        Gson gson =new Gson();
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        } //end if(headers.getRequestHeader("predicats")!=null){     
        String searchText = null;
        if(headers.getRequestHeader("search_text")!=null){
            searchText = gson.fromJson(headers.getRequestHeader("search_text").get(0),String.class);
        } //end if(headers.getRequestHeader("predicats")!=null){     
//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("predicats")+" === "+firstResult+" === "+maxResult+" == "+contraints);   
        RestrictionsContainer container = RestrictionsContainer.newInstance();  
        if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                        container = addPredicate(container,filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())
        if(searchText!=null&&!searchText.trim().isEmpty()){
            container.addLike("searchkeys", searchText);
        }//end if(searchText!=null&&!searchText.trim().isEmpty()){
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }

    /**
     * 
     * @param container
     * @param filter
     * @return 
     */
    protected RestrictionsContainer addPredicate(RestrictionsContainer container , FilterPredicat filter){
//        System.out.println(AbstractGenericService.class.toString()+".addPredicate === "+" == "+filter);       
        if(filter.getTarget().trim().equalsIgnoreCase("boolean")){
            BooleanPredicatBuilder predicat = new BooleanPredicatBuilder(null);
            container = predicat.buildPredicate(container, filter);
        }else if(filter.getTarget().trim().equalsIgnoreCase("date")){
            DatePredicatBuilder predicat = new DatePredicatBuilder(null); 
            container = predicat.buildPredicate(container, filter);
        }else if(filter.getTarget().trim().equalsIgnoreCase("number")){
              NumberPredicatBuilder predicat = new NumberPredicatBuilder(null);
              container = predicat.buildPredicate(container, filter);
        }else {
           StringPredicatBuilder predicat = new StringPredicatBuilder(null);
           container = predicat.buildPredicate(container, filter);
        }//end if(filter.getTarget().trim().equalsIgnoreCase("boolean")){
        return container;
    }
    /**
     * 
     * @param predicats
     * @param orders
     * @param properties
     * @param hints
     * @param firstResult
     * @param maxResult
     * @return 
     */
    @Override
    public List<T> filter(@Context HttpHeaders headers , List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, Map<String, Object> hints, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        return getManager().filter(predicats, orders, properties, hints, firstResult, maxResult);
    }

    @Override
    public RSNumber count(@Context HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson =new Gson();
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        }//end if(headers.getRequestHeader("predicats")!=null){        
        RestrictionsContainer container = RestrictionsContainer.newInstance();  
         if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                      container = addPredicate(container, filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    public void clean() {
        //To change body of generated methods, choose Tools | Templates.
         getManager().clean();
    }

    @Override
    public void flush() {
       //To change body of generated methods, choose Tools | Templates.
        getManager().flush();
    }

    @Override
    public  MetaData getMetaData(@Context HttpHeaders headers){
        return new MetaData();
    }
    
    @SuppressWarnings("empty-statement")
    protected void processBeforeSave(T entity) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    
    protected void processAfterSave(T entity) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

   
    protected void processBeforeSave(List entities) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    protected void processAfterSave(List entities) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    
    protected void processBeforeUpdate(T entity) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    
    protected void processAfterUpdate(T entity) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    
    protected void processBeforeUpdate(Map entity) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    
    protected void processAfterUpdate(Map entity) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    
    protected void processBeforeDelete(Object entity) {
       ; //To change body of generated methods, choose Tools | Templates.
    }

    
    protected void processAfterDelete(Object entity) {
        ; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Return  PDF file
     * @param file
     * @return
     * @throws FileNotFoundException 
     */
    public Response getPdf(File file) throws FileNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(file);
        Response.ResponseBuilder responseBuilder = Response.ok((Object)fileInputStream);
        responseBuilder.type("application/pdf");
        responseBuilder.header("Content-Disposition", "filename="+file.getName()+".pdf");
        return responseBuilder.build();
    }
    
    /**
     * 
     * @param file
     * @return
     * @throws IOException 
     */
    public Response getImage(File file) throws IOException{
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();
        Response.ResponseBuilder responseBuilder = Response.ok(imageData);
        return responseBuilder.build();
    }
    
    /**
     * Build jasper PDF from 
     * @param reportFile:fichier template  .jasper
     * @param fileName:"fichier de sortie
     * @param parametres:"parametres fichiers jasper
     * @param data:données 
     * @throws JRException 
     */
    public void jasperPdfBuilder(File reportFile,String fileName,Map parametres,List data) throws JRException{
        JasperReport report = null;
        JasperPrint jasperPrint = null;
        //Chargement du rapport
        report = (JasperReport) JRLoader.loadObject(reportFile);
        jasperPrint = JasperFillManager.fillReport(report,parametres, new JRBeanCollectionDataSource(data,false));
        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
    }
    
    /**
     * 
     * @param temporalDir
     * @param template
     * @param parameters
     * @param datas
     * @return 
     */
    public Response buildReportFomTemplate(String temporalDir,String template , Map parameters, List datas) throws FileNotFoundException, JRException{
        Date date = new Date();
        String temporalfile = temporalDir+File.separator+String.valueOf(date.getTime())+".pdf";
        jasperPdfBuilder(new File(template), temporalfile, parameters, datas);
        //To change body of generated methods, choose Tools | Templates.
        File file = new File(temporalfile);        
        return getPdf(file);
    }
    
     abstract class AbstractPredicateBuilder{
        
        protected AbstractPredicateBuilder next ;

        /**
         * 
         * @param next 
         */
        public AbstractPredicateBuilder(AbstractPredicateBuilder next) {
            this.next = next;
        }
        
        
        /**
         * Build the predicate 
         * @param container
         * @param filter
         * @return 
         */
        public abstract RestrictionsContainer buildPredicate(RestrictionsContainer container,FilterPredicat filter);
        
        /**
         * 
         * @return 
         */
        public AbstractPredicateBuilder next(){return next;}
    }
    
    class BooleanPredicatBuilder extends AbstractPredicateBuilder{

        /**
         * 
         * @param next 
         */
        public BooleanPredicatBuilder(AbstractPredicateBuilder next) {
            super(next);
        }

        @Override
        public RestrictionsContainer buildPredicate(RestrictionsContainer container, FilterPredicat filter) {
            //To change body of generated methods, choose Tools | Templates.
            Boolean value = new Boolean(filter.getValue());
            if(filter.getType().equalsIgnoreCase("==")||filter.getType().equalsIgnoreCase("EQUAL")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addEq(filter.getFieldName(), value);
                }else{
                      container.addEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("!=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addNotEq(filter.getFieldName(), value);
                }else{
                      container.addNotEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }//end if(filter.getType().equalsIgnoreCase("==")){
            return container;
        }
        
    }
    
    class DatePredicatBuilder extends AbstractPredicateBuilder{

        /**
         * 
         * @param next 
         */
        public DatePredicatBuilder(AbstractPredicateBuilder next) {
            super(next);
        }

        @Override
        public RestrictionsContainer buildPredicate(RestrictionsContainer container, FilterPredicat filter) {
            //To change body of generated methods, choose Tools | Templates.
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            Date value;
            try {
                value = formater.parse(filter.getValue());
            } catch (ParseException ex) {
                value = new Date();
            }//end try {
            if(filter.getType().equalsIgnoreCase("==")||filter.getType().equalsIgnoreCase("EQUAL")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addEq(filter.getFieldName(), value);
                }else{
                      container.addEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("!=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addNotEq(filter.getFieldName(), value);
                }else{
                      container.addNotEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("<=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLe(filter.getFieldName(), value);
                }else{
                      container.addLe(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase(">=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addGe(filter.getFieldName(), value);
                }else{
                      container.addGe(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("<")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLt(filter.getFieldName(), value);
                }else{
                      container.addLt(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase(">")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addGt(filter.getFieldName(), value);
                }else{
                      container.addGt(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }//end if(filter.getType().equalsIgnoreCase("==")){
            return container;
        }
        
    }
    
    class NumberPredicatBuilder extends AbstractPredicateBuilder{

        /**
         * 
         * @param next 
         */
        public NumberPredicatBuilder(AbstractPredicateBuilder next) {
            super(next);
        }

        @Override
        public RestrictionsContainer buildPredicate(RestrictionsContainer container, FilterPredicat filter) {
            //To change body of generated methods, choose Tools | Templates.
            String value = filter.getValue();
            if(filter.getType().equalsIgnoreCase("==")||filter.getType().equalsIgnoreCase("EQUAL")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addEq(filter.getFieldName(), value);
                }else{
                      container.addEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("!=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addNotEq(filter.getFieldName(), value);
                }else{
                      container.addNotEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("<=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLe(filter.getFieldName(), value);
                }else{
                      container.addLe(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase(">=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addGe(filter.getFieldName(), value);
                }else{
                      container.addGe(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("<")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLt(filter.getFieldName(), value);
                }else{
                      container.addLt(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase(">")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addGt(filter.getFieldName(), value);
                }else{
                      container.addGt(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("LIKE")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLike(filter.getFieldName(), filter.getValue());
                }else{
                      container.addLike(filter.getFieldName()+"."+filter.getSearchfields()[0], filter.getValue());                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }//end if(filter.getType().equalsIgnoreCase("==")){
            return container;
        }
        
    }
    
     class StringPredicatBuilder extends AbstractPredicateBuilder{

        /**
         * 
         * @param next 
         */
        public StringPredicatBuilder(AbstractPredicateBuilder next) {
            super(next);
        }

        @Override
        public RestrictionsContainer buildPredicate(RestrictionsContainer container, FilterPredicat filter) {
            //To change body of generated methods, choose Tools | Templates.
            String value = filter.getValue();
            if(filter.getType().equalsIgnoreCase("==")||filter.getType().equalsIgnoreCase("EQUAL")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addEq(filter.getFieldName(), value);
                }else{
                      container.addEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("!=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addNotEq(filter.getFieldName(), value);
                }else{
                      container.addNotEq(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("<=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLe(filter.getFieldName(), value);
                }else{
                      container.addLe(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase(">=")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addGe(filter.getFieldName(), value);
                }else{
                      container.addGe(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("<")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLt(filter.getFieldName(), value);
                }else{
                      container.addLt(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase(">")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addGt(filter.getFieldName(), value);
                }else{
                      container.addGt(filter.getFieldName()+"."+filter.getSearchfields()[0], value);                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }else if(filter.getType().equalsIgnoreCase("LIKE")){
                if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
                    container.addLike(filter.getFieldName(), filter.getValue());
                }else{
                      container.addLike(filter.getFieldName()+"."+filter.getSearchfields()[0], filter.getValue());                       
                }//end if(filter.getSearchfields()==null||filter.getSearchfields().length<=0){
            }//end if(filter.getType().equalsIgnoreCase("==")){
            return container;
        }
        
    }
}
