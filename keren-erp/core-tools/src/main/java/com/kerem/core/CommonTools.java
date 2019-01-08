/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerem.core;

import com.core.menus.ActionItem;
import com.core.menus.MenuAction;
import com.core.menus.MenuGroupActions;
import com.core.templates.ThemeRecord;
import com.core.views.CalendarRecord;
import com.core.views.DashboardRecord;
import com.core.views.FormRecord;
import com.core.views.KabanRecord;
import com.core.views.ReportRecord;
import com.core.views.TreeRecord;
import com.core.website.WebSiteComponent;
import com.core.website.WebSiteModule;
import com.kerem.genarated.Action;
import com.kerem.genarated.Button;
import com.kerem.genarated.Field;
import com.kerem.genarated.Group;
import com.kerem.genarated.Menu;
import com.kerem.genarated.Menuitem;
import com.kerem.genarated.Template;
import com.kerem.genarated.Website;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaArray;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaGroup;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Commercial_2
 */
public class CommonTools {
    
    /**
     * 
     * @param item
     * @return 
     */
    public static MenuAction getMenuAction(Menuitem item){
        MenuAction action = new MenuAction();
        action.setName(item.getId());
        action.setLabel(item.getLabel());
        action.setEntityName(item.getEntityRef());
        action.setModel(item.getModelRef());        
        action.setLink(item.getLink());
        action.setReport(item.getReport());
        action.setHide(item.isHide());
        action.setModal(item.isModal());
        action.setIcon(item.getGyphycon());
        action.setViewMode(item.getViewType());
        action.setMethod(item.getMethodRef());
        List<ActionItem> actions = new ArrayList<ActionItem>();      
        //Creation des actions
        if(item.getAction()!=null){
            for(Action act:item.getAction()){
                ActionItem data = new ActionItem(act.getId(),act.getType(), act.getLabel(), act.getValue());
                data.setState(act.getStates());
                //Traitement des roles 
                String[] roles = act.getRoles().split(";");
                data.setRoles(Arrays.asList(roles));
                actions.add(data);
            }
        }
        action.setActions(actions);
        //this.treeView = treeView;
        return action;
    }
    
    /**
     * 
     * @param item
     * @return 
     */
    public static MenuGroupActions getMenuGroupActions(Menu item){
        MenuGroupActions menu = new MenuGroupActions();
        menu.setIcon(item.getGyphycon());
        menu.setName(item.getId());
        menu.setLabel(item.getLabel());
        //menu.getM = module;
        return menu;
    }
    
    /**
     * 
     * @param view
     * @return 
     * @throws javax.xml.bind.JAXBException 
     */
    public static FormRecord getFormView(com.kerem.genarated.FormRecord view) throws JAXBException{
        FormRecord record = new FormRecord();
        record.setCode(view.getId());
        record.setScript(FileHelper.transformJaxBToScript(view));
        String template = FileHelper.ngTemplateParse(view.getTemplate());
        record.setTemplate(template);
        record.setTitre(view.getLabel());
        return record;
    }
    
    /**
     * 
     * @param template
     * @return 
     */
    public static com.core.templates.Template getTemplate(Template template) throws JAXBException{
        com.core.templates.Template record = new com.core.templates.Template();
        record.setCode(template.getId());
        String temp = FileHelper.ngTemplateParse(template.getScript());
        record.setScript(temp);
        record.setName(template.getName());
        record.setType(template.getType());
        record.setIndex(template.isIndex());
        record.setModuleName(template.getModelRef());
        record.setEntityRef(template.getEntityRef());
        record.setMethodRef(template.getMethodRef());
        return record ;
    }
    
    /**
     * Construction de la vue dashbord
     * @param view
     * @param record
     * @return 
     * @throws javax.xml.bind.JAXBException 
     */
    public static DashboardRecord getDashboard(com.kerem.genarated.DashboardRecord view) throws JAXBException{
        DashboardRecord record = new DashboardRecord();
        record.setCode(view.getId());
        record.setScript(FileHelper.transformJaxBToScript(view));
        record.setTitre(view.getLabel());
        return record;
    }
    
    
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
    public static KabanRecord getKabanentry(com.kerem.genarated.Kabanentry view) throws JAXBException{
        KabanRecord record = new KabanRecord();
        record.setCode(view.getId());
        String template = FileHelper.ngTemplateParse(view.getTemplate());
        record.setScript(template);
//        record.setTitre(view.getLabel());
        return record;
    }
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
    public static ThemeRecord getTheme(com.kerem.genarated.Theme view) throws JAXBException{
        ThemeRecord record = new ThemeRecord();
//        record.setCode("appli_theme");
//        if(view.getPri)
//        record.setScript(view.getP);
        if(view.getPrincipal()!=null){
            String template = FileHelper.ngTemplateParse(view.getPrincipal().getTemplate());
            record.setScript(template);
        }//end if(view.getPrincipal()!=null){
        if(view.getDiscussiontemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getDiscussiontemplate().getTemplate());
            record.setDiscussion(template);
        }
        if(view.getFormtemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getFormtemplate().getTemplate());
            record.setForm(template);
        }
//        record.setScript(view.get);
        if(view.getTreetemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getTreetemplate().getTemplate());
            record.setTree(template);
//            record.setContainer(view.getContainertemplate().getTemplate());
        }
        if(view.getContainertemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getContainertemplate().getTemplate());
            record.setContainer(template);
        }
        if(view.getReporttemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getReporttemplate().getTemplate());
            record.setReport(template);
        }
        if(view.getDashboardtemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getDashboardtemplate().getTemplate());
            record.setDashbord(template);
        }
        if(view.getCalendartemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getCalendartemplate().getTemplate());
            record.setCalendar(template);
        }
        if(view.getImporttemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getImporttemplate().getTemplate());
            record.setImporter(template);
        }
        if(view.getExporttemplate()!=null){
            String template = FileHelper.ngTemplateParse(view.getExporttemplate().getTemplate());
            record.setExport(template);
        }
//        record.setTitre("Theme Keren");
        return record;
    }
    
    /**
     *  
     * @param view
     * @return 
     * @throws javax.xml.parsers.ParserConfigurationException 
     * @throws org.xml.sax.SAXException 
     * @throws java.io.IOException 
     */
    public static ReportRecord getReportView(com.kerem.genarated.ReportRecord view) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException, JAXBException {
        ReportRecord record = new ReportRecord();
        record.setCode(view.getId());
        record.setTitre(view.getLabel());
        record.setExtern(view.isExtern());
        String template = FileHelper.ngTemplateParse(view.getTemplate());
        record.setScript(template);
        record.setFormat(view.getFormat());
        record.setOrientation(view.getOrientation());
        record.setUnit(view.getUnit());
        if(view.getSearch()!=null){
            record.setEntity(view.getSearch().getEntity());
            record.setModel(view.getSearch().getModule());
            record.setMethod(view.getSearch().getMethod());
            record.setSearch(FileHelper.transformJaxBToScript(view.getSearch()));
            record.setClazz(view.getSearch().getClazz());
            record.setIgnore(view.getSearch().isIgnore());
        }//end if(view.getSearch()!=null)          
//        System.out.println(CommonTools.class.toString()+" ========================================= "+view.getTemplate());
        return record;
    }
    
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
    public static CalendarRecord getFormView(com.kerem.genarated.CalendarRecord view) throws JAXBException{
        CalendarRecord record = new CalendarRecord();
        record.setTitlefield(view.getTitlefield());record.setStartfield(view.getStartfield());
        record.setEndfield(view.getEndfield());record.setAllday(view.isAllday());
        record.setCode(view.getId());
        record.setScript(FileHelper.transformJaxBToScript(view));
        record.setTitre(view.getLabel());
        return record;
    }
    
    /**
     * 
     * @param entity
     * @return 
     */
    public static WebSiteModule getWebSiteRecord(Website entity) throws JAXBException{
        WebSiteModule record = new WebSiteModule();
        record.setCode(entity.getId());
        record.setCategorie(entity.getCategorie());
        //traitement des templates
        for(Template temp:entity.getTemplate()){
            WebSiteComponent comp = new WebSiteComponent();
            comp.setCode(temp.getId());comp.setEntity(temp.getEntityRef());
            comp.setIndexPage(temp.isIndex());comp.setMethod(temp.getMethodRef());
            String template = FileHelper.ngTemplateParse(temp.getScript());
            comp.setScript(template);
            comp.setType(temp.getType());
            comp.setVar(temp.getVarRef());comp.setModele(temp.getModelRef());
            Date date = new Date();
            comp.setCompareid(date.getTime());comp.setCreateonfield(true);
            record.getWebcomponents().add(comp);
        }//end for(Template temp:entity.getTemplate()){       
        return record;
    }
    
    /**
     * 
     * @param view
     * @return
     * @throws JAXBException 
     */
    public static TreeRecord getFormView(com.kerem.genarated.TreeRecord view) throws JAXBException{
        TreeRecord record = new TreeRecord();
        record.setCode(view.getId());
        record.setScript(FileHelper.transformJaxBToScript(view));
        String template = FileHelper.ngTemplateParse(view.getTemplate());
        record.setTemplate(template);
        record.setTitre(view.getLabel());
        return record;
    }
    
    /**
     * 
     * @param metaData
     * @return 
     */
    private static Map<String , Object> metaDataMapBuilder(MetaData metaData){
        Map<String , Object> map = new HashMap<String , Object>();
        //Traitement des colonnes
        if(metaData.getColumns()!=null){
            for(MetaColumn col : metaData.getColumns()){
                map.put(col.getFieldName(), col);
            }
        }//end  if(metaData.getColumns()!=null)
        //Cas des groups
        if(metaData.getGroups()!=null){
            for(MetaGroup group:metaData.getGroups()){
                if(group.getColumns()!=null){
                    for(MetaColumn col : group.getColumns()){
                        map.put(col.getFieldName(), col);
                    }//end for(MetaColumn col : group.getColumns())
                }//end if(group.getColumns()!=null) 
                if(group.getMetaArray()!=null&&group.getMetaArray().size()>0){
                    for(MetaArray metaArray:group.getMetaArray()){
                        map.put(metaArray.getFieldName(), metaArray);
                    }//end for(MetaArray metaArray:group.getMetaArray())
                }
            }
        }//end if(metaData.getGroups()!=null){
        return map;
    }
    
   
    /**
     * 
     * @param entity
     * @param form
     * @param tree
     * @return 
     * @throws java.lang.InstantiationException 
     * @throws java.lang.IllegalAccessException 
     * @throws javax.xml.bind.JAXBException 
     */
    public static MetaData xmlViewParser( Class<?> entity , FormRecord form , TreeRecord tree) throws InstantiationException, IllegalAccessException, JAXBException{
        MetaData metadata = MetaDataUtil.getMetaData(entity.newInstance(), new HashMap<String, MetaData>(),new ArrayList<String>());
        
        if((form==null)&&(tree==null)){
            return metadata;
        }
        MetaData result = new MetaData();
        Map map = metaDataMapBuilder(metadata);
        //Traitement Form 
       if(form!=null&&form.getScript()!=null&&!form.getScript().trim().isEmpty()){
           result.setEntityName(metadata.getEntityName());
           result.setModuleName(metadata.getModuleName());
           result.setEditTitle(metadata.getEditTitle());
           result.setListTitle(metadata.getListTitle());
           result.setCreateonfield(metadata.isCreateonfield());
           result.setDesablecreate(metadata.isDesablecreate());
           result.setStates(metadata.getStates());
//           result.setCustomfooter(metadata.isCustomfooter());
           result.setFooterScript(metadata.getFooterScript());
           com.kerem.genarated.FormRecord record = FileHelper.transformScriptToForm(form.getScript());
           
           if(record.getLabel()!=null&&!record.getLabel().trim().isEmpty()){
               result.setEditTitle(record.getLabel());
           }//end if(record.getLabel()!=null&&!record.getLabel().trim().isEmpty())
           //Traitement des entetes du formulaire
           if(record.getHeader()!=null){
               //Traitements de buttons
               if(record.getHeader().getButton()!=null){
                   short seq = 1 ;
                   for(Button button : record.getHeader().getButton()){
                       MetaColumn column = new MetaColumn("button", button.getName(), button.getLabel(), false, button.getType(), null);
//                       column.setType("button");
//                       column.setSearch(false);
                       column.setPattern(button.getClazz());
//                       column.setTarget(button.getType());
//                       column.setFieldName(button.getName());
//                       column.setFieldLabel(button.getLabel());
                       column.setValue(button.getValue());
//                       column.setMetaData(null);
                       column.setSequence(seq);
                       String[] states = null;
                       if(button.getStates()!=null){
                           states = button.getStates().split(",");
                       }//end if(button.getStates()!=null){
                       column.setStates(states);
                       seq++;
//                       System.out.println(CommonTools.class.toString()+" ======================= "+button.getStates()+" === "+states);
                       result.getHeader().add(column);
                   }//end for(Button button : record.getHeader().getButton())
               }//end if(record.getHeader().getButton()!=null)
               if(record.getHeader().getField()!=null){
                    MetaColumn column = new MetaColumn("workflow", record.getHeader().getField().getName(), "State", false, record.getHeader().getField().getTarget(), null);
//                    column.setType();
//                    column.setTarget(record.getHeader().getField().getTarget());
//                    column.setSearch(false);
//                    column.setTarget(record.getHeader().getField().getTarget());
                    result.getHeader().add(column);
                    //column.setFieldName(button.getName());
                    //column.setFieldLabel(button.getLabel());
               }//end if(record.getHeader().getField()!=null)
           }//end if(record.getHeader()!=null)
           //Cas du body
           if(record.getSheet()!=null){
               if(record.getSheet().getField()!=null){
                   short sequence = 1;
                   for(Field field : record.getSheet().getField()){
                       if(field.getName()!=null&&!field.getName().trim().isEmpty()){
                           MetaColumn column = (MetaColumn) map.get(field.getName());
                           column.setSequence(sequence);
                           column.setSearch(false);
                           if(field.getTarget()!=null&&!field.getTarget().trim().isEmpty()){
                               column.setTarget(field.getTarget());
                           }
                           result.getColumns().add(column);
                           sequence ++ ;
                       }//end if(field.getName()!=null&&!field.getName().trim().isEmpty())
                   }//end for(Field field : record.getSheet().getField())
                   if(record.getSheet().getGroup()!=null){
                       for(Group group : record.getSheet().getGroup()){
                           short i = 1 ;
                           if(group.getName()!=null&&!group.getName().trim().isEmpty()){
                               MetaGroup groupe = new MetaGroup();
                               groupe.setGroupName(group.getName());
                               groupe.setGroupLabel(group.getLabel());
                               groupe.setSequence(i);
                               //Traitement des champs
                               for(Field field : group.getField()){
                                  Object data = (MetaColumn) map.get(field.getName());
                                  if(data instanceof MetaColumn){
                                        MetaColumn column = (MetaColumn) data ;
                                        column.setSequence(sequence);
                                        column.setSearch(false);
                                        if(field.getTarget()!=null&&!field.getTarget().trim().isEmpty()){
                                            column.setTarget(field.getTarget());
                                        }
                                        groupe.getColumns().add(column);
                                  }else if(data instanceof MetaArray){
                                      MetaArray column = (MetaArray) data;
                                      //column.setSequence(sequence);
                                      column.setSearch(false);
                                      if(field.getTarget()!=null&&!field.getTarget().trim().isEmpty()){
                                          column.setTarget(field.getTarget());
                                      }
                                      groupe.getMetaArray().add(column);
                                  }
                                    result.getGroups().add(groupe);
                                    sequence++;
                               }
                               i++;
                           }//end if(group.getName()!=null&&!group.getName().trim().isEmpty())
                       }
                   }//end if(record.getSheet().getGroup()!=null)
               }//end if(record.getSheet().getField()!=null)
           }//end if(record.getSheet()!=null)
       }else{
              result = metadata;
       }//end if(form!=null&&!form.trim().isEmpty())
        //Traitement des tree
       if(tree!=null&&tree.getScript()!=null&&!tree.getScript().trim().isEmpty()){
           com.kerem.genarated.TreeRecord record = FileHelper.transformScriptToTree(tree.getScript());
           if(record.getLabel()!=null&&!record.getLabel().trim().isEmpty()){
               result.setListTitle(record.getLabel());
           }
           short colsequence = 1 ;
           for(Field field : record.getField()){
              if(field.getName()!=null&&!field.getName().trim().isEmpty()){
                  Object data = map.get(field.getName());
                  if(data instanceof MetaColumn){
                      MetaColumn column = (MetaColumn) data ;
                      column.setColsequence(colsequence);
                      column.setSearch(true);
                  }
                  colsequence++;
              }
           }//end for(Field field : record.getField())
       }//end if(tree!=null&&!tree.trim().isEmpty())
       return result;
    }
    /**
     * Return  PDF file
     * @param file
     * @param filename
     * @return
     * @throws FileNotFoundException 
     */
    public static Response getPdf(File file,String filename) throws FileNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(file);
        Response.ResponseBuilder responseBuilder = Response.ok((Object)fileInputStream);
        responseBuilder.type("application/pdf");
        responseBuilder.header("Content-Disposition", "attachment; filename="+filename);
        return responseBuilder.build();
    }
    
    /**
     * Return  PDF file
     * @param file
     * @param filename
     * @return
     * @throws FileNotFoundException 
     */
    public static Response getText(File file,String filename) throws FileNotFoundException{
        String[] names = file.getName().split(".");
        FileInputStream fileInputStream = new FileInputStream(file);
        Response.ResponseBuilder responseBuilder = Response.ok((Object)fileInputStream);
        responseBuilder.type("text/plain");
        responseBuilder.header("Content-Disposition", "attachment; filename="+filename);
        return responseBuilder.build();
    }
    
    /**
     * 
     * @param file
     * @param filename
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getTextStream(File file,String filename) throws FileNotFoundException, IOException{
        String[] names = file.getName().split(".");
        BufferedReader reader  = new BufferedReader(new FileReader(file));
        StringBuffer buffer = new StringBuffer();
        String ligne = null;
        do{
            ligne = reader.readLine();
            if(ligne!=null){
                buffer.append(ligne);
            }//end if(ligne!=null){
        }while(ligne!=null);
        return buffer.toString().trim();
    }
    
    /**
     * 
     * @param filename
     * @return 
     */
    private static String getFileType(String filename){
        String[] part = filename.split(".");
        if(part.length>1){
            return part[part.length-1];            
        }//end if(part.length>1){
        return null;
    }
    
    private static String getMimeType(String type){
        if(type.equalsIgnoreCase("pdf"))
            return "application/pdf";
        else if(type.equalsIgnoreCase("png")||type.equalsIgnoreCase("jpeg"))
            return "image/png";
        else if(type.equalsIgnoreCase("doc")||type.equalsIgnoreCase("dot"))
            return "application/msword";
        else if(type.equalsIgnoreCase("docx")||type.equalsIgnoreCase("dotx"))
            return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        else if(type.equalsIgnoreCase("xls")||type.equalsIgnoreCase("xlt")||type.equalsIgnoreCase("xla"))
            return type = "application/vnd.ms-excel";
        else if(type.equalsIgnoreCase("xlsx")||type.equalsIgnoreCase("xltx"))
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        else if(type.equalsIgnoreCase("ppt")||type.equalsIgnoreCase("pot")||type.equalsIgnoreCase("pps")||type.equalsIgnoreCase("ppa"))
            return "application/vnd.ms-powerpoint";
        else if(type.equalsIgnoreCase("pptx"))
            return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        else if(type.equalsIgnoreCase("mdb"))
            return "application/vnd.ms-access";
        else if(type.equalsIgnoreCase("rar"))
            return "application/x-rar-compressed, application/octet-stream";
        else if(type.equalsIgnoreCase("odt"))
            return "application/vnd.oasis.opendocument.text";
        return null;
    }
    /**
     * 
     * @param file
     * @param filename
     * @return
     * @throws FileNotFoundException 
     */
     public static Response getStream(File file,String filename) throws FileNotFoundException{
       /* String extension =getFileType(file.getName());
        if(extension.equalsIgnoreCase("pdf")){
            return getPdf(file, filename);
        }else if(extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("sql")){
            return getText(file, filename);
        }else if(extension.equalsIgnoreCase("png")){
            try {
                return getImage(file, filename);
            } catch (IOException ex) {
               throw  new FileNotFoundException(ex.getMessage());
            }
        }else*/{
            String[] names = file.getName().split(".");
            FileInputStream fileInputStream = new FileInputStream(file);
            Response.ResponseBuilder responseBuilder = Response.ok((Object)fileInputStream);
//            String mimetype = getMimeType(extension);
//            if(mimetype!=null){
//                responseBuilder.type(mimetype);
//            }//end if(mimetype!=null){
            responseBuilder.header("Content-Disposition", "attachment; filename="+file.getName());
            return responseBuilder.build();
        }//end  if(extension.equalsIgnoreCase("pdf")){
    }
    /**
     * 
     * @param file
     * @param filename
     * @return
     * @throws IOException 
     */
    public static Response getImage(File file,String filename) throws IOException{
        String[] names = file.getName().split(".");
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();
        Response.ResponseBuilder responseBuilder = Response.ok(imageData);
        CacheControl cc = new CacheControl();
        cc.setNoCache(true);
        cc.setNoStore(true);
        responseBuilder.cacheControl(cc);
        responseBuilder.type("image/png");
        responseBuilder.header("Content-Disposition", "attachment; filename="+filename);
        return responseBuilder.build();
    }
    
    /**
     * 
     * @param file
     * @param filename
     * @return
     * @throws IOException 
     */
    public static Response getImage(File file) throws IOException{
        String[] names = file.getName().split(".");
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();
        Response.ResponseBuilder responseBuilder = Response.ok(imageData);
        CacheControl cc = new CacheControl();
        cc.setNoCache(true);
        cc.setNoStore(true);
        responseBuilder.cacheControl(cc);        
        return responseBuilder.build();
    }
    
    /**
     * 
     * @param data
     * @return 
     */
    public static java.lang.reflect.Field[] getClassFields(Class clazz){
        List<java.lang.reflect.Field> fields = new ArrayList<java.lang.reflect.Field>();        
        if(!clazz.getSuperclass().equals(Object.class)){
            java.lang.reflect.Field[] champs = getClassFields(clazz.getSuperclass());
            if(champs!=null&&champs.length>0){
                fields.addAll(Arrays.asList(champs));
            } //end for(Field field:champs){
        }//end if(!clazz.getSuperclass().equals(Object.class))
        java.lang.reflect.Field[] champs = clazz.getDeclaredFields();
        fields.addAll(Arrays.asList(champs)); //end for(Field field:champs){
        if(fields.size()>0){
            java.lang.reflect.Field[] result = new java.lang.reflect.Field[fields.size()];
            int i=0;
            for(java.lang.reflect.Field field:fields){
                result[i] = field;
                i++;
            }//end for(Field field:fields)
            return result;
        }//end if(fields.size()>0){
        return null;
    }
    
    
}
