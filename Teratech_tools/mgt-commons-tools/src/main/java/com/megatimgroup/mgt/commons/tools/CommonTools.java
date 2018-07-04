/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author BEKO
 */
public class CommonTools {
    
    /**
     * 
     * @param field
     * @param value 
     */
    private static void affect(Class<?> object ,Field field , String value) throws IllegalArgumentException, IllegalAccessException{
        field.setAccessible(true);
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
     * Construct an object base of the data Map
     *data.get(0): containt the name of field
     * @param manager
     * @param classname
     * @param data
     * @return
     * @throws ClassNotFoundException 
     * @throws java.lang.IllegalAccessException 
     */
    public static List mapToJavaObject(EntityManager manager , String classname , Map<Long,List<String>> data) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
         List result = new ArrayList();        
         List<String> fieldNames = data.get(0L);
         System.out.println(CommonTools.class.toString()+".mapToJavaObject(EntityManager manager , String classname , Map<Long,List<String>> data) ============= fieldnames : "+fieldNames);
         for(long key:data.keySet()){
           if(key>0){
               //Creation instance of Object
                Class<?> entityClass = Class.forName(classname);
                //Construction du map des champs de l'object
                Field[] fields = entityClass.getDeclaredFields();
                Map<String, Field> map = new HashMap<>();
                for(Field field : fields){
                    map.put(field.getName(), field);
                }//end for(Field field : fields){
              List<String> values = data.get(key);
              int index = 0;
              for(String fieldname:fieldNames){
                  String[] names = fieldname.split(".");
                  if(names.length==0){
                      Field field = map.get(fieldname);
                     if(field!=null){
                         affect(entityClass, field, values.get(index));
                     }//end if(field!=null){
                  }else{//Object 
                      Field field = map.get(names[0]);
                      if(field!=null){
                        Object value = getEntity(manager, names[0], names[1], values.get(index), field);
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
    
    /**
     * 
     * @param datas
     * @param fields
     * @return 
     * @throws java.lang.IllegalAccessException 
     */
    public static Map<Long,List<String>> objectToMapConverter(List<Class<?>> datas,List<String> fields) throws IllegalArgumentException, IllegalAccessException{
        Map<Long,List<String>> result = new HashMap<Long,List<String>>();
        result.put(0l, fields);
        long index = 0L ;
        for(Class<?> data :  datas){
            index ++ ;
            result.put(index, objectToListConverter(data.getClass() ,data, fields));
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
    private static List<String> objectToListConverter(Class<?> clazz , Class<?> data , List<String> fields) throws IllegalArgumentException, IllegalAccessException{
        List<String> result = new ArrayList<>();
        Field[] champs = clazz.getDeclaredFields();
        for(Field ele : champs){
            for(String field : fields){
                String[] fieldPart = field.split(".");
                if(fieldPart.length<=1 && ele.getName()==field){
                    result.add((String) ele.get(data));
                }else if(fieldPart.length>1 && fieldPart[0]==ele.getName()){
                    Object value = ele.get(data);
                    result.add((String) value);
                }//end if(fieldPart.length==1){
            }//end for(String field : fields){
        }//end for(Field ele : champs){            
        return result;
    }
    /**
     * 
     * @param manager
     * @param fieldname
     * @param code
     * @param value
     * @param field
     * @return 
     */
    public static  Object getEntity(EntityManager manager ,String fieldname,String code,String value, Field field){
        String query = "SELECT c FROM "+field.getType().toString()+" c WHERE c."+code+"="+value;
        Query requ = manager.createQuery(query);
        List datas = requ.getResultList();
        return (datas==null||datas.isEmpty()) ? null:datas.get(0);
    }
    
    
    /**
     * 
     * @param file
     * @param filename
     * @return
     * @throws FileNotFoundException 
     */
     public static Response getStream(File file,String filename) throws FileNotFoundException{
        String[] names = file.getName().split(".");
        FileInputStream fileInputStream = new FileInputStream(file);
        Response.ResponseBuilder responseBuilder = Response.ok((Object)fileInputStream);
//        responseBuilder.type("text/plain");
        responseBuilder.header("Content-Disposition", "attachment; filename="+filename);
        return responseBuilder.build();
    }
     
   public static String cvsString(String value){
       char[] array = value.toCharArray();
       StringBuilder sb = new StringBuilder();
       int end = array.length-1;
       for(int i=0;i<array.length;i++){           
           if(i==0 && array[i]=='"'){
               
           }else if(i==end && array[end]=='"'){
               
           } else {
               sb.append(array[i]);
           }//end if(i==0 && array[i]=='"'){
       }//end for(int i=0;i<array.length;i++){
       return sb.toString();
   }
}
