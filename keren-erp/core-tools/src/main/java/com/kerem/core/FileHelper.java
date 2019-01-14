/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerem.core;

import com.core.application.Manifest;
import com.core.menus.MenuModule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.genarated.CalendarRecord;
import com.kerem.genarated.DashboardRecord;
import com.kerem.genarated.FormRecord;
import com.kerem.genarated.Kabanentry;
import com.kerem.genarated.Keren;
import com.kerem.genarated.Search;
import com.kerem.genarated.TreeRecord;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Commercial_2
 */
public class FileHelper {
    public static String ADDONS_PATH = "addons";
    public static String MANIFEST_FILE ="manifest.json";
    public static String DEPLOY_DIR = "standalone"+File.separator+"deployments";
    public static String TEMP_REPORT_DIR = "standalone"+File.separator+"data"+File.separator+"keren"+File.separator+"resources"+File.separator+"templates";
    public static String TEMP_STATIC_DIR = "standalone"+File.separator+"data"+File.separator+"keren"+File.separator+"resources"+File.separator+"static";
    public static String TEMP_CONFIG_DIR = "standalone"+File.separator+"data"+File.separator+"keren"+File.separator+"resources"+File.separator+"config";
    public static String TEMP_DIR = "standalone"+File.separator+"tmp"+File.separator+"keren";
    private static String CURRENT_MODULE = null;
    
    /**
     * Current module 
     * @param module 
     */
    public static void setCurrentModule(String module){
         FileHelper.CURRENT_MODULE = module;
    }
    /**
     * Retourn le chemin courant
     * @return 
     */
    public static File getCurrentDirectory(){
        String fileName = (String) System.getProperties().get("user.dir") ;
        return new File(fileName);
    }
    
    /**
     * Deplacement de fichiers et laisse une copie du fichier
     * @param from
     * @param to 
     * @throws java.io.IOException 
     */
    public static void moveFile(File from , File to) throws IOException{
        Files.move(Paths.get(from.toURI()), Paths.get(to.toURI()),StandardCopyOption.REPLACE_EXISTING);
    }
    
    /**
     * 
     * @param from
     * @param to
     * @throws IOException 
     */
    public static void copyFile(File from , File to) throws IOException{
       Files.copy(Paths.get(from.toURI()), Paths.get(to.toURI()), StandardCopyOption.REPLACE_EXISTING);
    }
    
    /**
     * Delete file or repository
     * @param repo 
     * @throws java.io.IOException 
     */
    public static void deleteFile(File repo) throws IOException{        
         if(repo.isDirectory()){
             for(File file : repo.listFiles()){
                 deleteFile(file);
             }//end for(File file : repo.listFiles()){
              Files.deleteIfExists(Paths.get(repo.toURI()));
         }else{
            Files.deleteIfExists(Paths.get(repo.toURI()));
         }//end if(repo.isFile()){
    }
    /**
     * Retourne le repertoires contenant Ã¹
     * les modules
     * @return 
     */
    public static File getAddonsDirectory(){
        File binDirectory = FileHelper.getCurrentDirectory();        
        return new File(binDirectory.getParent()+File.separator+ADDONS_PATH);
    }
    
    /**
     * Chemin du repertoire des etats
     * @return 
     */
    public static File getReportsDirectory(){
         File binDirectory = FileHelper.getCurrentDirectory();
         StringBuilder builder = new StringBuilder();
         builder.append(binDirectory.getParent())
                     .append(File.separator)
                     .append(TEMP_REPORT_DIR);
         if(CURRENT_MODULE==null){
             return new File(builder.toString());
         }else{        
             builder.append(File.separator)
                     .append(CURRENT_MODULE);
             File file = new File(builder.toString());
             if(!file.exists()){
                 file.mkdir();                 
             }//end if(!file.exists()){
             return file ;
         }//end if(CURRENT_MODULE==null){
    }
    
    /**
     * Chemin du repertoire des etats
     * @return 
     */
    public static File getStaticDirectory(){
         File binDirectory = FileHelper.getCurrentDirectory(); 
         StringBuilder builder = new StringBuilder();
             builder.append(binDirectory.getParent())
                     .append(File.separator)
                     .append(TEMP_STATIC_DIR);
         if(CURRENT_MODULE==null){
             return new File(builder.toString());
         }else{             
             builder.append(File.separator)
                     .append(CURRENT_MODULE);
             File file = new File(builder.toString());
             if(!file.exists()){
                 file.mkdir();                 
             }//end if(!file.exists()){
             return file ;
         }//end if(CURRENT_MODULE==null){        
    }
    
    public static File getConfigDirectory(){
         File binDirectory = FileHelper.getCurrentDirectory();        
         return new File(binDirectory.getParent()+File.separator+TEMP_CONFIG_DIR);
    }
    
    public static File getTemporalDirectory(){
         File binDirectory = FileHelper.getCurrentDirectory();     
         File file = new File(binDirectory.getParent()+File.separator+TEMP_DIR);
         if(!file.exists()){
             file.mkdir();
         }//end if(!file.exists())
         return file;
    }
    
    /**
     * 
     * @return 
     */
    public static File getDeployDirectory(){
        File binDirectory = FileHelper.getCurrentDirectory();        
        return new File(binDirectory.getParent()+File.separator+DEPLOY_DIR);
    }
    
    /**
     * Liste des Repertoires du repertoires des modules
     * @return 
     */
    public static List<File> getAddonsSubDirectories(){
        List<File> results = new ArrayList<File>();
        File[] directories =  FileHelper.getAddonsDirectory().listFiles();
        for(File fich : directories){
            if(fich.isDirectory()){
                results.add(fich);
            }
        }
        return results;
    }
    
    /**
     * 
     * @param directory
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    public static Manifest getManifestFromDirectory(File directory) throws FileNotFoundException, IOException{
        String ligne ;
        Gson gson = new Gson();
        if(directory==null || !directory.isDirectory()) return null;
       for(File fich : directory.listFiles()){
           if(fich.isFile()&&fich.getName().compareToIgnoreCase(MANIFEST_FILE)==0){
               BufferedReader reader = new BufferedReader(new FileReader(fich));
               StringBuilder builder = new StringBuilder();
               ligne = reader.readLine();
               while(ligne!=null){
                   builder.append(ligne);
                   ligne = reader.readLine();
               }
               Manifest manifest = gson.fromJson(builder.toString(), Manifest.class);
               manifest.setFilename(fich.getParentFile().getName());
               //System.out.println("FileHelper.public static Manifest getManifestFromDirectory(File directory) throws FileNotFoundException, IOException == \n"+manifest);               
               return manifest;
           }
       }
       return null;
    }
    
    /**
     * Retourn la listes des modules disponibles
     * dans le repertoires 
     * @return 
     * @throws java.io.IOException 
     */
    public static List<Manifest> getAvailableModules() throws IOException{
        List<File> modules = FileHelper.getAddonsSubDirectories();
        List<Manifest> manifests = new ArrayList<Manifest>();
        for(File rep : modules){
            manifests.add(getManifestFromDirectory(rep));
        }
        return manifests;
    }
    
     /**
     * Retourn Le manifest correspondant a un module
     * dans le repertoires 
     * @param mod
     * @return 
     * @throws java.io.IOException 
     */
    public static Manifest getManifest(MenuModule mod) throws IOException{
        List<File> modules = FileHelper.getAddonsSubDirectories();       
        for(File rep : modules){
            Manifest manif = getManifestFromDirectory(rep);
            manif.setFilename(rep.getName());
            if(manif.getFilename().trim().equalsIgnoreCase(mod.getName().trim())){
                return manif;
            }
        }
        return null;
    }
    
     /**
     * Retourn Le manifest correspondant a un module
     * dans le repertoires 
     * @param moduleName
     * @param mod
     * @return 
     * @throws java.io.IOException 
     */
    public static Manifest getManifest(String moduleName) throws IOException{
        List<File> modules = FileHelper.getAddonsSubDirectories();       
        for(File rep : modules){
            Manifest manif = getManifestFromDirectory(rep);
            manif.setFilename(rep.getParentFile().getName());
            if(manif.getName().trim().equalsIgnoreCase(moduleName)){
                return manif;
            }
        }
        return null;
    }
    /**
     * Retourne un entite keren a partir d'un fichier xml decrivant la vue
     * @param file
     * @return 
     * @throws javax.xml.bind.JAXBException 
     */
    public static Keren getXmlToEntities(File file) throws JAXBException{
        if(file==null) return null;
        JAXBContext jc = JAXBContext.newInstance(Keren.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Keren data = (Keren) unmarshaller.unmarshal(file);
        //System.out.println(FileHelper.class.toString()+".Keren getXmlToEntities(File file) === "+file.exists()+" == "+data);
        return data;
    }
    
    
    
    /**
     * 
     * @param module
     * @return 
     * @throws java.io.IOException 
     * @throws javax.xml.bind.JAXBException 
     */
    public static List<Keren> getViews(MenuModule module) throws IOException, JAXBException{  
        List<Keren> datas = new ArrayList<Keren>();
        //Cas module null
        if(module==null) return datas;
        //Le module est non null
        Manifest manif = getManifest(module);
        if(manif.getViews()!=null){
            for(String view : manif.getViews()){
                String path = getAddonsDirectory().getPath()+File.separator+module.getName()+File.separator+view;
                File file =new File(path);
                if(file.exists()){
                    Keren data = getXmlToEntities(file);
                    datas.add(data);                     
                }//end if(file.exists()){               
            }//end for(String view : manif.getViews())
        }//end if(manif.getViews()!=null){     
        return datas;
    }
    
    /**
     * Traitement des fichieers pour le reporting
     * Deplacement de ces fichiers vers le reportoire de reportings
     * @param manifest
     * @param <error>
     * @throws IOException 
     */
    public static  void processReporting(Manifest manifest)  throws IOException{
         if(manifest==null) return ;        
         FileHelper.setCurrentModule(manifest.getFilename());
        //verification que le manifest reference un fichier
        for(String report : manifest.getReports()){
            String path = getAddonsDirectory().getPath()+File.separator+manifest.getFilename()+File.separator+report;
            File source = new File(path);
            if(source.exists()){
                StringBuilder builder = new StringBuilder();
                builder.append(getStaticDirectory().toString());
                createDirectory(builder.toString());
                builder.append(File.separator)
                        .append(source.getName());
                File cible = new File(builder.toString());
                copyFile(source, cible);
            }//end if(source.exists()){
        }//end for(String core : manifest.getCores()){
    }
    
    /**
     * Suppresion des fichier lie a un module
     * @param manifest 
     */
    public static void unProcessReporting(Manifest manifest) throws IOException{
         if(manifest==null) return ;        
         FileHelper.setCurrentModule(manifest.getFilename());
        //verification que le manifest reference un fichier
         StringBuilder builder = new StringBuilder();
         builder.append(getReportsDirectory().toString());
       File cible = new File(builder.toString());
        deleteFile(cible);
    }
    
    /**
     * 
     * @param manifest
     * @throws IOException 
     */
    public static void unProcessImages(Manifest manifest) throws IOException{
         if(manifest==null) return ;        
         FileHelper.setCurrentModule(manifest.getFilename());
        //verification que le manifest reference un fichier
         StringBuilder builder = new StringBuilder();
         builder.append(getStaticDirectory().toString());
       File cible = new File(builder.toString());
        deleteFile(cible);
    }
     
   /**
     * 
     * @param directory
     * @throws IOException 
     */
    private static void createDirectory(String directory) throws IOException{
        File fichier = new File(directory);
        if(!fichier.exists()){
            fichier.mkdir();
        }//end if(!fichier.exists()){
    }
    
    /**
     * Transfert des images dans le repertoires en question
     * @param manifest
     * @throws IOException 
     */
    public static void processImages(Manifest manifest)  throws IOException{
        if(manifest==null) return ;        
        FileHelper.setCurrentModule(manifest.getFilename());
        //verification que le manifest reference un fichier
        for(String image : manifest.getImages()){
            String path = getAddonsDirectory().getPath()+File.separator+manifest.getFilename()+File.separator+image;
            File source = new File(path);
            if(source.exists()){
                StringBuilder builder = new StringBuilder();
                builder.append(getStaticDirectory().toString());
                createDirectory(builder.toString());
                builder.append(File.separator)
                        .append(source.getName());
                File cible = new File(builder.toString());
                copyFile(source, cible);
            }//end if(source.exists()){
        }//end for(String core : manifest.getCores()){
    }
    
    /**
     * Traitement de l'icon du module
     * @param manifest 
     * @return  
     * @throws java.io.IOException 
     */
    public static String processIcon(Manifest manifest) throws IOException{
        if(manifest.getIcon()!=null && !manifest.getIcon().trim().isEmpty()){
            FileHelper.setCurrentModule(null);
            StringBuilder builder = new StringBuilder();
            builder.append(getAddonsDirectory().getPath())
                    .append(File.separator)
                    .append(manifest.getFilename())
                    .append(File.separator)
                    .append(manifest.getIcon());
            File source = new File(builder.toString());
            if(source.exists()){
                builder = new StringBuilder(getStaticDirectory().toString());
                builder.append(File.separator)
                        .append(source.getName());
                File cible = new File(builder.toString());
                copyFile(source, cible);
            }//end if(source.exists()){
            FileHelper.setCurrentModule(manifest.getFilename());
             return source.getName();
        }//end if(manifest.getIcon()!=null && !manifest.getIcon().trim().isEmpty()){
        return "avatar.png";
    }
    /**
     * 
     * @param manifest 
     * @throws java.io.IOException 
     */
    public static void processCore(Manifest manifest) throws IOException{
        if(manifest==null) return ;        
        //verification que le manifest reference un fichier
        for(String core : manifest.getCores()){
            String path = getAddonsDirectory().getPath()+File.separator+manifest.getFilename()+File.separator+core;
            File source = new File(path);
            if(source.exists()){
                File cible = new File(getDeployDirectory()+File.separator+core);
                moveFile(source, cible);
            }//end if(source.exists()){
        }//end for(String core : manifest.getCores()){
    }
    
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
    public static String transformJaxBToScript(FormRecord view) throws JAXBException{
        StringWriter writer = new StringWriter();
        String output = "";
        JAXBContext ctx = JAXBContext.newInstance(FormRecord.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(view,writer);
        output = writer.toString();
        return output;
    }
    
     public static String transformJaxBToScript(Kabanentry view) throws JAXBException{
        StringWriter writer = new StringWriter();
        String output = "";
        JAXBContext ctx = JAXBContext.newInstance(Kabanentry.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(view,writer);
        output = writer.toString();
        return output;
    }
    
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
     public static String transformJaxBToScript(DashboardRecord view) throws JAXBException{
        StringWriter writer = new StringWriter();
        String output = "";
        JAXBContext ctx = JAXBContext.newInstance(DashboardRecord.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(view,writer);
        output = writer.toString();
        return output;
    }

     /**
      * 
      * @param view
      * @return
      * @throws JAXBException 
      */
     public static String transformJaxBToScript(CalendarRecord view) throws JAXBException{
        StringWriter writer = new StringWriter();
        String output = "";
        JAXBContext ctx = JAXBContext.newInstance(CalendarRecord.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(view,writer);
        output = writer.toString();
        return output;
    }
    
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
    public static String transformJaxBToScript(Search view) throws JAXBException{
        StringWriter writer = new StringWriter();
        String output = "";
        JAXBContext ctx = JAXBContext.newInstance(Search.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(view,writer);
        output = writer.toString();
        return output;
    }
        
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
    public static String transformJaxBToScript(TreeRecord view) throws JAXBException{
        StringWriter writer = new StringWriter();
        String output = "";
        JAXBContext ctx = JAXBContext.newInstance(TreeRecord.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(view,writer);
        output = writer.toString();
        return output;
    }
    
    /**
     * 
     * @param script
     * @return 
     */
    public static TreeRecord transformScriptToTree(String script) throws JAXBException{
        StringBuilder builder = new StringBuilder();
        builder.append(ngTemplateParse(script));
        StringReader reader = new StringReader(builder.toString());
        JAXBContext ctx = JAXBContext.newInstance(TreeRecord.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        TreeRecord record = (TreeRecord) unmarshaller.unmarshal(reader);
        return record;
    }
    
    /**
     * 
     * @param script
     * @return
     * @throws JAXBException 
     */
     public static CalendarRecord transformScriptToCalendar(String script) throws JAXBException{
        StringBuilder builder = new StringBuilder();
        builder.append(ngTemplateParse(script));
        StringReader reader = new StringReader(builder.toString());
        JAXBContext ctx = JAXBContext.newInstance(CalendarRecord.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        CalendarRecord record = (CalendarRecord) unmarshaller.unmarshal(reader);
        return record;
    }
    
    /**
     * 
     * @param script
     * @return
     * @throws JAXBException 
     */
    public static FormRecord transformScriptToForm(String script) throws JAXBException{
        StringBuilder builder = new StringBuilder();
        builder.append(ngTemplateParse(script));
        StringReader reader = new StringReader(builder.toString());
        JAXBContext ctx = JAXBContext.newInstance(FormRecord.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        FormRecord record = (FormRecord) unmarshaller.unmarshal(reader);
        return record;
    }
    /**
     * 
     * @param script
     * @return
     * @throws JAXBException 
     */
    public static DashboardRecord transformScriptToDashboard(String script) throws JAXBException{
        StringBuilder builder = new StringBuilder();
        builder.append(ngTemplateParse(script));
        StringReader reader = new StringReader(builder.toString());
        JAXBContext ctx = JAXBContext.newInstance(DashboardRecord.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        DashboardRecord record = (DashboardRecord) unmarshaller.unmarshal(reader);
        return record;
    }
    
     /**
     * 
     * @param script
     * @return
     * @throws JAXBException 
     */
    public static Search transformScriptToSearch(String script) throws JAXBException{
        StringBuilder builder = new StringBuilder();
        builder.append(ngTemplateParse(script));
        StringReader reader = new StringReader(builder.toString());
        JAXBContext ctx = JAXBContext.newInstance(Search.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        Search record = (Search) unmarshaller.unmarshal(reader);
        return record;
    }
  
    /**
     * Treatment of ng-template directive
     * @param script
     * @return 
     */
    public static String ngTemplateParse(String script) throws JAXBException {
        if(script==null || script.trim().isEmpty()){
            return script;
        }//end if(script==null || script.trim().isEmpty()){
//       System.out.println(FileHelper.class.toString()+".ngTemplateParse ========================= "+script);
       try {            
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();  
            StringBuilder xmlbuilder = new StringBuilder();
            xmlbuilder.append(script);
            ByteArrayInputStream input = new ByteArrayInputStream(xmlbuilder.toString().getBytes("UTF-8"));
            Document doc = builder.parse(input);
            NodeList nodes_list = doc.getChildNodes();
            for(int i=0 ; i<nodes_list.getLength();i++){
                ngTemplateNodeParser(nodes_list.item(i), builder,doc);
            }//end for(int i=0 ; i<nodes_list.getLength();i++){
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString().substring(38);
        } catch (Exception ex) {
            throw   new JAXBException(ex);
        }
    }
   /**
    * 
    * @param node
    * @param builder
    * @return
    * @throws SAXException
    * @throws IOException 
    */
    private static void ngTemplateNodeParser(Node node , DocumentBuilder builder,Document document) throws SAXException, IOException{
        if(node.getNodeType()==Node.ELEMENT_NODE){
            Element element = (Element) node ;            
            if(element.getTagName().equalsIgnoreCase("ng-template")){
                String src = element.getAttribute("src");
                StringBuilder pathbuilder = new StringBuilder();
                pathbuilder.append(getAddonsDirectory())
                        .append(File.separator)
                        .append(src);
                File tmpfile = new File(pathbuilder.toString());
                if(tmpfile.exists()){
                    Document doc = builder.parse(tmpfile);
//                    System.out.println(FileHelper.class.toString()+".ngTemplateNodeParser ========================= "+tmpfile.getAbsolutePath()+" == nodes count : "+((Element)doc.getChildNodes().item(0)).getTagName());
                    NodeList node_list = doc.getChildNodes();
                    for(int i=0 ;i<node_list.getLength();i++){
                        ngTemplateNodeParser(node_list.item(i) ,builder,doc);
                    }//end for(int i=0 ;i<node_list.getLength();i++){
                    if(doc.getChildNodes().getLength()>0){
                        document.getDocumentElement().replaceChild(document.importNode(doc.getDocumentElement(),true),element);
                    }//end if(doc.getChildNodes().getLength()>0){
                }//end if(tmpfile.exists()){                
            }else{
                //Traitement des noeuds du node
                NodeList node_list = element.getChildNodes();
                for(int i=0 ;i<node_list.getLength();i++){
                    ngTemplateNodeParser(node_list.item(i) ,builder,document);
                }//end for(int i=0 ;i<node_list.getLength();i++){
            }//end if(element.getTagName().equalsIgnoreCase("ng-template")){
        }//end if(node.getNodeType()==Node.ELEMENT_NODE){
//        return node ;
    }
    /**
     * 
     * @param filename
     * @return 
     */
    public static Map<String , String> getFromJsonFile(String filename) throws FileNotFoundException, IOException{
        Gson gson = new Gson();
        Map<String , String> map = new HashMap<String , String>();
        BufferedReader sysreader = new BufferedReader(new FileReader(filename));
        StringBuilder builder = new StringBuilder();
        String ligne = null;
        do{
            ligne = sysreader.readLine();
            if(ligne!=null){
                builder.append(ligne);
            }//end if(ligne!=null){
        }while(ligne!=null);
        sysreader.close();
        if(!builder.toString().isEmpty()){
            Type mapType = new TypeToken<Map<String, String>>(){}.getType();  
             map = gson.fromJson(builder.toString(),mapType);
        }
        System.out.println(FileHelper.class.toString()+" ======================================================== "+builder.toString()+" ==== Map : "+map);
        return map;
    }
}
