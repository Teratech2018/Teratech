/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatim.common.annotations.Exclude;
import com.megatim.common.annotations.Include;
import com.megatim.common.annotations.IncludeObject;
import com.megatim.common.annotations.Predicate;
import com.megatim.common.annotationsprocessor.ValidateAndFillBeans;
import com.megatim.common.export.EnumJavaType;
import com.megatim.common.jaxb.entities.Fileline;
import com.megatim.common.jaxb.entities.Linecolumn;
import com.megatim.common.jaxb.entities.Temporalfile;
import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Commercial_2
 */
public class EbayHelper {
    
//    public static final String CONSOLE_FILE = "com/"
    
    public static final String TRANSFERT_REPO ="transfert";
    
    public static final String PP_REPO="physiques";
    
    public static final String PM_REPO="morales";
    
    public static final String OF_REPO = "operations";
    
    /**
     * 
     * @param items
     * @param nodes
     * @return 
     */
    public static Temporalfile buildFormItem(List<EbayItem> items , List<NodeObject> nodes) throws IllegalArgumentException, IllegalAccessException{
        
        Temporalfile temporal = new Temporalfile();
        
        if(items==null || items.isEmpty()) return temporal;
        
        List<String> fieldsName = new ArrayList<String>();
        
        //Construction des fields
        for(NodeObject key : nodes){
            fieldsName.add(key.getName());
        }
        
        int index = 0 ;
        
        for(EbayItem item : items){
            
           temporal.getFileline().add(buildLineFromItem(item, fieldsName, index));
           
           index = index + 1;
        }
        
        return temporal ;
    }
    
    /**
     * 
     * @param item
     * @param names
     * @return 
     */
    private static Fileline buildLineFromItem(EbayItem item ,List<String> names ,int index ) throws IllegalArgumentException, IllegalAccessException{
        
        Fileline line = new Fileline();
        
        //Liste des champs
        Field[] fields = item.getClass().getDeclaredFields();
        
        for(Field field : fields){
            
            field.setAccessible(true);
            
            if(names.contains(field.getName())){
//                System.out.println("EbayHelper.buildLineFromItem(item, names, index)   ::::::::::::::::::::::::::::::::::::::::::::::::::::: "+field.getName()+" :::::: "+field.get(item));
                Linecolumn column = new Linecolumn();
                
                column.setColumn(names.indexOf(field.getName()));
                
                column.setRow(index);
                
                column.setName(field.getName());
                
                column.setType(EnumJavaType.STRING.ordinal());
                
                column.setValue(String.valueOf(field.get(item)));
                
                line.getLinecolumn().add(column);
            }
        }
        
        return line ;
    }
    
    /**
     * Liste des predicats
     * @param clazz
     * @return 
     */
    public static List<NodeObject> getNodeObjects(Class<?> clazz){
        
        List<NodeObject> nodes = new ArrayList<NodeObject>();
        
        //Recuperation des champs
        Field[] fields = ValidateAndFillBeans.getObjectDeclaredFields(clazz);
        
        //Traitement des champ
        for(Field field : fields){
            
            field.setAccessible(true);
            
            if(field.isAnnotationPresent(Predicate.class)){
                
                Predicate annot = field.getAnnotation(Predicate.class);
                
                NodeObject node = new NodeObject();
                
                node.setClazz(annot.type());
                
                node.setEntry(annot.entry());
                
                node.setLabel(annot.label());
                
                node.setLength(annot.length());
                
                node.setName(field.getName());
                
                node.setNullable(annot.nullable());
                
                node.setOptional(annot.optional());
                
                node.setParentClazz(clazz);
                
                node.setPattern(annot.pattern());
                
                node.setUnique(annot.unique());
                
                node.setValue(null);
                
                if(field.isAnnotationPresent(Include.class)){                  
                  
                    Include include = field.getAnnotation(Include.class);

                    IncludeObject includeObject = new IncludeObject();

                    includeObject.setClasses(include.classes());

                    includeObject.setChamps(include.champs());

                    includeObject.setConnector(include.connector());

                    includeObject.setType(include.type());

                    includeObject.setValeur(include.value());

                    node.setInclude(includeObject);
               }
                
               if(field.isAnnotationPresent(Exclude.class)){                  
                  
                    Exclude include = field.getAnnotation(Exclude.class);

                    IncludeObject includeObject = new IncludeObject();

                    includeObject.setClasses(include.classes());

                    includeObject.setChamps(include.champs());

                    includeObject.setConnector(include.connector());

                    includeObject.setType(include.type());

                    includeObject.setValeur(include.value());

                    node.setExclude(includeObject);
               }
//                System.out.println(EbayHelper.class.getSimpleName()+".getNodeObjects(Class<?> clazz) =====================  "+field.getName()+"  !!!!!!!!!! "+field.isAnnotationPresent(Predicate.class)+" :::::::::::: "+" ************ "+field.isAnnotationPresent(Exclude.class)+" ::: "+clazz+" ***** "+node);
            
               nodes.add(node);
            }
            
        }
        
        return nodes ;
    }
    
    /**
     * Liste des predicats
     * @param clazz
     * @return 
     */
    public static String getFields(Class<?> clazz){
        
       StringBuilder builder = new StringBuilder(); 
        //Recuperation des champs
        Field[] fields = ValidateAndFillBeans.getObjectDeclaredFields(clazz);
        
        int index = 0 ;
        
        //Traitement des champ
        for(Field field : fields){
            
            if(!field.isAnnotationPresent(Predicate.class)) continue;
            
            if(index==0){
                builder.append(field.getName());
            }else{
                builder.append(",").append(field.getName());
            }
            index = index+1 ;
        }
        
        return builder.toString() ;
    }
    
    /**
     * Conversion
     * @param datas
     * @return 
     */
    public static List<EbayItem> convertFormPP(List<DeclarationPP> datas){
        
        List<EbayItem> results = new ArrayList<EbayItem>();
        
        for(DeclarationPP decl : datas){
            results.add(buildItem(decl));
        }
        return results;
    }
    
    /**
     * Conversion
     * @param datas
     * @return 
     */
    public static List<EbayItem> convertFromPM(List<DeclarationPM> datas){
        
        List<EbayItem> results = new ArrayList<EbayItem>();
//        System.out.println(EbayHelper.class.getSimpleName()+".convertFromPM(List<DeclarationPM> datas)  ============================ "+datas+"::::: "+datas.size());
        for(DeclarationPM decl : datas){
            results.add(buildItem(decl));
        }
        return results;
    }
     /**
     * Conversion
     * @param datas
     * @return 
     */
    public static List<EbayItem> convertFromFI(List<DeclarationFinanciere> datas){
        
        List<EbayItem> results = new ArrayList<EbayItem>();
        
        for(DeclarationFinanciere decl : datas){
            results.add(buildItem(decl));
        }
        return results;
    }
    
     /**
     * 
     * @param date
     * @return 
     */
    public static  String annee(Date date){
        
        int year = date.getYear()+1900;
        
        char[] years = Integer.toString(year).toCharArray();
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(years[2]).append(years[3]);
        
        return builder.toString();
    }
    
    /**
     * 
     * @param dateDebut
     * @return 
     */

    public static Periode getPeriode(Date dateDebut) {
        
        int month = dateDebut.getMonth();
        
        switch(month){
            case 0 : return Periode.JANVIER;
            case 1 : return Periode.FEVRIER;
            case 2 : return Periode.MARS;
            case 3 : return Periode.AVRIL;
            case 4 : return Periode.MAI;
            case 5 : return Periode.JUIN;
            case 6 : return Periode.JUILLET;
            case 7 : return Periode.AOUT;
            case 9 : return Periode.SEPTEMBRE;
            case 10: return Periode.OCTOBRE;
            case 11: return Periode.NOVEMBRE;
            default: return Periode.DECEMBRE;
        }
        
    }    
    
    /**
     * 
     * @param data
     * @return 
     */
    public static EbayItem buildItem(DeclarationPP data){
        
          EbayItem item = new EbayItem();
          SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
         item.setAdresse_1(data.getAdresse_1());
         item.setAdresse_2(data.getAdresse_2());
         item.setAdresse_3(data.getAdresse_3());
         item.setBoitepostale(data.getBoitepostale());
         item.setClasse(null);
         item.setCodeStatistique(null);
         item.setCommentaire(null);
         item.setDateCreation(null);
         if(data.getDateNaissance()!=null){
//             System.out.println("EbayHelper.buildItem(data) :::::::::::::::::::::::::::::::::   "+item.getDateNaissance());
             item.setDateNaissance(formater.format(data.getDateNaissance()));
         }
         item.setDateOperation(null);
         item.setDesignation(null);
         item.setDevise(null);
         item.setDivision(null);
         item.setEmail(null);
         item.setFax(null);
         item.setGroupe(null);
         item.setLieuNaissance(data.getLieuNaissance());
         item.setMontant(null);
         item.setMotif(null);
         item.setNationalite(data.getNationalite()!=null ? data.getNationalite().getCode() : null);
         item.setNatureClientele(data.getNatureClientele()!=null ? data.getNatureClientele().getCode() : null);
         item.setNatureJuridique(null);
         item.setNom(data.getNom());
         item.setNomAbrege(null);
         item.setNomJeuneFille(data.getNomJeuneFille());
         item.setObjetSocial(null);
         item.setPays(null);
         item.setPrecisionDatenaissance(data.getPrecisionDatenaissance()!=null ? data.getPrecisionDatenaissance().getCode():null);
         item.setPrenom(data.getPrenom());
         item.setProfession(data.getProfession());
         item.setQualite(data.getQualite()!=null ? data.getQualite().getCode():null);
         item.setRaisonSocial(null);
         item.setReference(data.getReference());
         item.setRegistreCommerce(null);
         item.setSection(null);
         item.setSens(null);
         item.setSiegeSocial(null);
         item.setSigle(null);
         item.setStatusResidence(data.getStatusResidence()!=null ? data.getStatusResidence().getCode():null);
         item.setTelephone1(null);
         item.setTelephone2(null);
         item.setTelephone3(null);
         item.setTitre(data.getTitre()!=null ? data.getTitre().getCode():null);
         item.setType(null);
         item.setVille(data.getVille()!=null ? data.getVille().getCode():null);
         
         
          return item;
    }
    
    
    
    /**
     * 
     * @param data
     * @return 
     */
    public static EbayItem buildItem(DeclarationPM data){
        
          EbayItem item = new EbayItem();
          SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
         item.setAdresse_1(data.getAdresse_1());
         item.setAdresse_2(data.getAdresse_2());
         item.setAdresse_3(data.getAdresse_3());
         item.setBoitepostale(data.getBoitepostale());
         item.setClasse(data.getClasse()!=null ? data.getClasse().getCode():null);
         item.setCodeStatistique(data.getCodeStatistique());
         item.setCommentaire(null);
         if(data.getDateCreation()!=null){
             item.setDateCreation(formater.format(data.getDateCreation()));
         }
         item.setDateNaissance(null);
         item.setDateOperation(null);
         item.setDesignation(null);
         item.setDevise(null);
         item.setDivision(data.getDivision()!=null ? data.getDivision().getCode():null);
         item.setEmail(data.getEmail());
         item.setFax(data.getFax());
         item.setGroupe(data.getGroupe()!=null ? data.getGroupe().getCode():null);
         item.setLieuNaissance(null);
         item.setMontant(null);
         item.setMotif(null);
         item.setNationalite(null);
         item.setNatureClientele(data.getNatureClientele()!=null ? data.getNatureClientele().getCode() : null);
         item.setNatureJuridique(data.getNatureJuridique()!=null ? data.getNatureJuridique().getCode():null);
         item.setNom(null);
         item.setNomAbrege(data.getNomAbrege());
         item.setNomJeuneFille(null);
         item.setObjetSocial(data.getObjetSocial());
         item.setPays(null);
         item.setPrecisionDatenaissance(null);
         item.setPrenom(null);
         item.setProfession(null);
         item.setQualite(null);
         item.setRaisonSocial(data.getRaisonSocial());
         item.setReference(data.getReference());
         item.setRegistreCommerce(data.getRegistreCommerce());
         item.setSection(data.getSection()!=null ? data.getSection().getCode() : null);
         item.setSens(null);
         item.setSiegeSocial(data.getSiegeSocial());
         item.setSigle((data.getSigle()==null||data.getSigle().trim().isEmpty()) ? data.getRaisonSocial() : data.getSigle());
         item.setStatusResidence(data.getStatusResidence()!=null ? data.getStatusResidence().getCode():null);
         item.setTelephone1(data.getTelephone1());
         item.setTelephone2(data.getTelephone2());
         item.setTelephone3(data.getTelephone3());
         item.setTitre(null);
         item.setType(null);
         item.setVille(data.getVille()!=null ? data.getVille().getCode():null);
         
         
          return item;
    }
    
    
    /**
     * 
     * @param data
     * @return 
     */
    public static EbayItem buildItem(DeclarationFinanciere data){
        
          EbayItem item = new EbayItem();
          SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
         item.setAdresse_1(null);
         item.setAdresse_2(null);
         item.setAdresse_3(null);
         item.setBoitepostale(null);
         item.setClasse(null);
         item.setCodeStatistique(null);
         item.setCommentaire(data.getCommentaire());
         item.setDateCreation(null);
         item.setDateNaissance(null);
         if(data.getDateOperation()!=null){
             item.setDateOperation(formater.format(data.getDateOperation()));
         }
         item.setDesignation(data.getDesignation());
         item.setDevise(data.getDevise()!=null ? data.getDevise().getCode() : null);
         item.setDivision(null);
         item.setEmail(null);
         item.setFax(null);
         item.setGroupe(null);
         item.setLieuNaissance(null);
         NumberFormat numberFormat = NumberFormat.getInstance();
         
         item.setMontant(trim(numberFormat.format(data.getMontant())));
         item.setMotif(data.getMotif()!=null ? data.getMotif().getCode() : null);
         item.setNationalite(null);
         item.setNatureClientele(null);
         item.setNatureJuridique(null);
         item.setNom(null);
         item.setNomAbrege(null);
         item.setNomJeuneFille(null);
         item.setObjetSocial(null);
         item.setPays(data.getPays()!=null ? data.getPays().getCode():null);
         item.setPrecisionDatenaissance(null);
         item.setPrenom(null);
         item.setProfession(null);
         item.setQualite(null);
         item.setRaisonSocial(null);
         item.setReference(data.getReference());
         item.setRegistreCommerce(null);
         item.setSection(null);
         item.setSens(data.getSens()!=null ? data.getSens().getCode():null);
         item.setSiegeSocial(null);
         item.setSigle(null);
         item.setStatusResidence(null);
         item.setTelephone1(null);
         item.setTelephone2(null);
         item.setTelephone3(null);
         item.setTitre(null);
         item.setType(data.getType()!=null ? data.getType().getCode():null);
         item.setVille(null);
         item.setIdOperation(data.getIdOperation());
         item.setCommentaire(data.getDesignation()+"  "+data.getMotif().getDesignation());
          return item;
    }
    
    /**
     * 
     * @param value
     * @return 
     */
    public static String trim(String value){
        
        char[] values = value.toCharArray();
        
        StringBuilder buffer = new StringBuilder();
        
        for(char c: values){            
            
            String car = ""+c ;
            
            if(car.matches("[0-9]")){
                buffer.append(c);
            }
        }
        
        return buffer.toString();
    }
    
}
