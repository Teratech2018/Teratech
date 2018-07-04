/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *The purpose of content all functions releate to file manipulation
 * @author BEKO
 */
public class FileHelper {
    
    /**
     * Convert CVS file to Java Map
     * @param fileName
     * @param separator
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    public static Map<Long,List<String>> cvsToJavaConverter(String fileName,String separator) throws FileNotFoundException, IOException{
        Map<Long,List<String>> result = new HashMap<>();
        String line="";
        FileReader reader = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(reader);
        long index = 0 ;
        while((line = buffer.readLine())!=null){
            //use sperator to have element
            String[] columns = line.split(separator);
            //Construction des columns
            List<String> colList = new ArrayList<String>();
            colList.addAll(Arrays.asList(columns));
            result.put(index, colList);
            index++;
        }//end while((line = buffer.readLine())!=null){
        return result;
    }
    
    /**
     * Convert Excel file to java Map object
     * @param filename
     * @return 
     * @throws java.io.IOException 
     * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException 
     */
    public static Map<Long,List<String>> excelToJavaConverter(String filename) throws IOException, InvalidFormatException{
        File excelfile = new File(filename);
        Map<Long,List<String>> result = new HashMap<>();
        //Creation of the workbook
        Workbook workBook = WorkbookFactory.create(excelfile);
        
        //Selection de la feuille N°:1
        Sheet sheet = workBook.getSheetAt(0);
        
        //Lecture des données du Fichier
        int index = 0 ;
        
        Row row = sheet.getRow(index);
        
        while(row!=null){
            
            List<String> ligne = excelrowToJavaList(row , index);
            
            result.put(Long.valueOf(index), ligne);
            
            index = index + 1 ;
            
            row = sheet.getRow(index);
        }
        return result ;
    }
    
    /**
     * Create a List of String from the excel row
     * @param row
     * @param index
     * @return 
     */
    private static List<String> excelrowToJavaList(Row row , int index){
        List<String> line = new ArrayList<>();
        int pos = 0 ;
        String value = getCellValue(row.getCell(pos));
        while(value!=null){
            line.add(value);
            pos++;
            value = getCellValue(row.createCell(pos));
        }//end while(value!=null){
        return line ;
    }
    
      /**
     * 
     * @param cell
     * @return 
     */
    private static String getCellValue(Cell cell){
        
        if(cell==null)
                   return null ;
        
        int cellType = cell.getCellType();
         
         switch(cellType){
             
             case Cell.CELL_TYPE_BLANK : 
                              return "";
             case Cell.CELL_TYPE_ERROR :
                     return null;
             case Cell.CELL_TYPE_FORMULA :
                     return "";
             case Cell.CELL_TYPE_BOOLEAN :
                     return ""+cell.getBooleanCellValue();
             case Cell.CELL_TYPE_NUMERIC :                     
                  return getStringRepresentation(cell.getNumericCellValue());
             default: return cell.getStringCellValue();
         }
    }
    
    /**
     * 
     * @param value
     * @return 
     */
     private static String getStringRepresentation(double value){
        Double dValue = new Double(value);
        Long lvalue = dValue.longValue();
        
        if(lvalue.doubleValue()==value){
            return lvalue.toString();
        }else{
            return dValue.toString();
        }
    }
    
}
