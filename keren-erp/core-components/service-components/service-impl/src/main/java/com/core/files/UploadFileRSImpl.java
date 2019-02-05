/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.files;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.application.ResourceRegistry;
import com.core.application.ResourceRegistryManagerRemote;
import com.core.base.BaseElement;
import com.core.discussions.Follower;
import com.core.discussions.FollowerManagerRemote;
import com.core.referentiels.PieceJointe;
import com.core.referentiels.PieceJointeManagerRemote;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.CommonTools;
import com.kerem.core.FileHelper;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.mgt.commons.command.MysqlBDWinExporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author Commercial_2
 */
@Path("/resource")
public class UploadFileRSImpl 
      extends AbstractGenericService<BaseElement, Long>   implements UploadFileRS{

      @Manager(application = "kerencore", name = "ResourceRegistryManagerImpl", interf = ResourceRegistryManagerRemote.class)
     protected ResourceRegistryManagerRemote registry;
      
     @Manager(application = "kerencore", name = "PieceJointeManagerImpl", interf = PieceJointeManagerRemote.class)
     protected PieceJointeManagerRemote pjmanager;
     
     @Manager(application = "kerencore", name = "FollowerManagerImpl", interf = FollowerManagerRemote.class)
     protected FollowerManagerRemote followermanager;

    public UploadFileRSImpl() {        
        super();
    }
    
    
    
    
    @Override
    public Response uploadFiletemporal(MultipartFormDataInput input, HttpHeaders headers) {
         //To change body of generated methods, choose Tools | Templates.
        Gson gson =new Gson();
        //Type predType = ;
        List<String> names = new ArrayList<String>();
        if(headers.getRequestHeader("names")!=null){
            names = gson.fromJson(headers.getRequestHeader("names").get(0),new TypeToken<List<String>>(){}.getType());
        }    
        String fileName = "";
//
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("resources");
//                System.out.println(UploadFileRSImpl.class.toString()+" ======================== "+inputParts);
                int index = 0 ;
		for (InputPart inputPart : inputParts) {
		 try {
                       MultivaluedMap<String, String> header = inputPart.getHeaders();
			fileName = getFileName(header);
                        //convert the uploaded file to inputstream
			InputStream inputStream = inputPart.getBody(InputStream.class,null);

			byte [] bytes = IOUtils.toByteArray(inputStream);

			if(names!=null&&names.size()>index){
                            //constructs upload file path
                            fileName = FileHelper.getTemporalDirectory()+File.separator+names.get(index);
//                            System.out.println(UploadFileRSImpl.class.toString()+" ========================  ===== "+fileName);                            
                            writeFile(bytes,fileName);                        
                        }			
			index++;
//			System.out.println("Done");
		  } catch (IOException e) {
			 Response.serverError().build();
		  }

		}

		return Response.status(200)
		    .entity("uploadFile is called, Uploaded file name : " + fileName).build();
    }
    
    @Override
    public Response uploadFile(MultipartFormDataInput input,HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        Gson gson =new Gson();
        //Type predType = ;
        List<String> names = new ArrayList<String>();
        List<Boolean> rules = new ArrayList<Boolean>();
        if(headers.getRequestHeader("criticity")!=null &&!headers.getRequestHeader("criticity").isEmpty()){
            rules = gson.fromJson(headers.getRequestHeader("criticity").get(0),new TypeToken<List<Boolean>>(){}.getType());
        }//end if(headers.getRequestHeader("names")!=null){
        if(headers.getRequestHeader("names")!=null && !headers.getRequestHeader("names").isEmpty()){
            names = gson.fromJson(headers.getRequestHeader("names").get(0),new TypeToken<List<String>>(){}.getType());
        }//end if(headers.getRequestHeader("names")!=null){
        String modulename = null ;
         if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String entityname = null ;
         if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
             entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         Long _instance = null;
         if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
             _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
//         System.out.println(UploadFileRSImpl.class.toString()+".uploadFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" ===== rules : = "+rules+" ===== _instance = "+_instance);
         FileHelper.setCurrentModule(modulename);
        String fileName = "";//
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("resources");
//                System.out.println(UploadFileRSImpl.class.toString()+" ======================== "+inputParts);
                int index = 0 ;
		for (InputPart inputPart : inputParts) {
		 try {
                       MultivaluedMap<String, String> header = inputPart.getHeaders();
			fileName = getFileName(header);
                        //convert the uploaded file to inputstream
			InputStream inputStream = inputPart.getBody(InputStream.class,null);

			byte [] bytes = IOUtils.toByteArray(inputStream);

			if(names!=null&&names.size()>index){
//                            System.out.println(UploadFileRSImpl.class.toString()+" ======================== "+bytes+" ===== "+names.get(index));
                            //Creation d'une entree dans le registre des resources
                            Date today = new Date();
                            String storename = Long.toString(today.getTime()+index);
                            ResourceRegistry resource = new ResourceRegistry(names.get(index), names.get(index), entityname, modulename,_instance);
                            resource.setCompareid(today.getTime());
                            //Renommer le fichier en storename
                            //constructs upload file path
                            fileName = FileHelper.getStaticDirectory()+File.separator+names.get(index);
                            if(!rules.isEmpty() && rules.get(index).equals(Boolean.TRUE)){
                                fileName = FileHelper.getStaticDirectory()+File.separator+storename;
                                resource.setStorename(storename);
                            }//end if(rules.get(index).equals(Boolean.TRUE)){                            
                            writeFile(bytes,fileName);    
                            //Mise a jour du resourceregisty
                            registry.save(resource);
                        }			
			index++;
//			System.out.println("Done");
		  } catch (IOException e) {
			 Response.serverError().build();
		  }

		}

		return Response.status(200)
		    .entity("uploadFile is called, Uploaded file name : " + fileName).build();
        
    }
    
    @Override
    public Response downloadImageFile(@Context HttpHeaders headers,String filename) {
         Gson gson = new Gson();
         String modulename = null ;
         if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String entityname = null ;
         if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
             entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         Long _instance = null;
         if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
             _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" === _instance : "+_instance);
         FileHelper.setCurrentModule(modulename);
        try {
            //Chargement du resourceregistry correspondant au fichier
//             System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile2(@Context HttpHeaders headers,String filename) ==== "+modulename+" ===== entity : ==== "+entityname+"===== entityid"+_instance+" ==== "+registry);
             ResourceRegistry resource = null;
            if(entityname!=null && _instance!=null){
                resource = registry.getRegistryEntry(filename, entityname, modulename,_instance);
            }//end if(registry!=null){
            //To change body of generated methods, choose Tools | Templates.
            File fichier = new File(FileHelper.getStaticDirectory()+File.separator+filename);
            if(resource!=null){
                fichier = new File(FileHelper.getStaticDirectory()+File.separator+resource.getStorename());
            }//end if(resource!=null){
//            System.out.println(UploadFileRSImpl.class.toString()+" ==== "+fichier.getAbsolutePath());
            if(!fichier.exists()||!fichier.isFile()){
                FileHelper.setCurrentModule(null);
                fichier = new File(FileHelper.getStaticDirectory()+File.separator+"avatar.png");
            }
            if(resource!=null){
                return CommonTools.getImage(fichier,resource.getSrcname());
            }else{
                return CommonTools.getImage(fichier);
            }//end if(resource!=null){
        } catch (IOException ex) {
             Response.serverError().build();
        }
        return Response.noContent().build();
    }
    @Override
    public Response downloadImageFile2(@Context HttpHeaders headers,String filename, String name) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
         String modulename = null ;
         if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String entityname = null ;
         if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
             entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
          Long _instance = null;
         if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
             _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" === _instance : "+_instance);
         FileHelper.setCurrentModule(modulename);
         try {
             //Chargement du registre des resource
             ResourceRegistry resource = registry.getRegistryEntry(filename, entityname, modulename,_instance);
//             System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile2(@Context HttpHeaders headers,String filename) ==== "+modulename+" ==== "+resource);
           //To change body of generated methods, choose Tools | Templates.
            File fichier = new File(FileHelper.getStaticDirectory()+File.separator+filename);
            if(resource!=null){
                fichier = new File(FileHelper.getStaticDirectory()+File.separator+resource.getStorename());
            }//end  if(resource!=null){
//            System.out.println(UploadFileRSImpl.class.toString()+" ==== "+fichier.getAbsolutePath());
            if(!fichier.exists()||!fichier.isFile()){
                FileHelper.setCurrentModule(null);
                fichier = new File(FileHelper.getStaticDirectory()+File.separator+"avatar.png");
            }
            return CommonTools.getImage(fichier,name);
        } catch (IOException ex) {
             Response.serverError().build();
        }
        return Response.noContent().build();
    }

    
    @Override
    public Response downloadPdfFile(@Context HttpHeaders headers,String filename,String name) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
         String modulename = null ;
         if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String entityname = null ;
         if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
             entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){         
          Long _instance = null;
         if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
             _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" === _instance : "+_instance);
         FileHelper.setCurrentModule(modulename);
        try{
               //Chargement du registre des resource
                ResourceRegistry resource = registry.getRegistryEntry(filename, entityname, modulename,_instance);
//                 System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile2(@Context HttpHeaders headers,String filename) ==== "+modulename+" ==== "+resource);
                String resourceDir = FileHelper.getStaticDirectory()+File.separator+filename;
                if(resource!=null){
                    resourceDir = FileHelper.getStaticDirectory()+File.separator+resource.getStorename();
                }//end if(resource!=null){
                File file = new File(resourceDir);
//                System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" === fichier : "+file.getAbsolutePath());
                if(file.exists()){
                    return CommonTools.getPdf(file,name);
                }else{
                    return Response.noContent().build();
                }//end if(file.exists())
        }catch(Exception ex){
            throw new WebApplicationException(ex, Response.serverError().build());
        }
    }

    @Override
    public Response downloadTextFile(@Context HttpHeaders headers,String filename,String name) {
       //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
         String modulename = null ;
         if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String entityname = null ;
         if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
             entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
          Long _instance = null;
         if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
             _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" === _instance : "+_instance);
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename);
         FileHelper.setCurrentModule(modulename);
         try{
                //Chargement du registre des resource
                ResourceRegistry resource = registry.getRegistryEntry(filename, entityname, modulename,_instance);
//                System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile2(@Context HttpHeaders headers,String filename) ==== "+modulename+" ==== "+resource);
                String resourceDir = FileHelper.getStaticDirectory()+File.separator+filename;
                if(resource!=null){
                    resourceDir = FileHelper.getStaticDirectory()+File.separator+resource.getStorename();
                }//end if(resource!=null){
                File file = new File(resourceDir);
                if(file.exists()){
                    return CommonTools.getText(file,name);
                }else{
                    return Response.noContent().build();
                }//end if(file.exists())
        }catch(Exception ex){
            throw new WebApplicationException(ex, Response.serverError().build());
        }
    }

    /**
     * 
     * @param headers
     * @param filename
     * @param name
     * @return 
     */
    @Override
    public Response downloadFile(@Context HttpHeaders headers,String filename, String name) {
        //To change body of generated methods, choose Tools | Templates.
            Gson gson = new Gson();
            String modulename = null ;
            if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
                modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
            }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
            String entityname = null ;
            if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
                entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
            }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             Long _instance = null;
            if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
                _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
            }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
//            System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" === _instance : "+_instance);
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename);
           FileHelper.setCurrentModule(modulename);
            try{
                  //Chargement du registre des resource
                  ResourceRegistry resource = registry.getRegistryEntry(filename, entityname, modulename,_instance);
//                   System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile2(@Context HttpHeaders headers,String filename) ==== "+modulename+" ==== "+resource);
                  String resourceDir = FileHelper.getStaticDirectory()+File.separator+filename;
                  if(resource!=null){
                     resourceDir = FileHelper.getStaticDirectory()+File.separator+resource.getStorename();
                  }//end if(resource!=null){
                  File file = new File(resourceDir);
                  if(file.exists()){
                      return CommonTools.getStream(file,name);
                  }else{
                      return Response.noContent().build();
                  }//end if(file.exists())
          }catch(Exception ex){
              throw new WebApplicationException(ex, Response.serverError().build());
          }
    }
   
    /**
     * 
     * @param headers
     * @return 
     */
    @Override
    public Response exportdatabase(@Context HttpHeaders headers) {
        InputStream input = null;
        try {
            String confg_file = FileHelper.getConfigDirectory()+File.separator+"config.properties";
            //Load file properties
            Properties config = new Properties();
            input = new FileInputStream(confg_file);
            //load a properties file
            config.load(input);
//            System.out.println(UploadFileRSImpl.class.toString()+".exportdatabase() ======== config : "+config);
            String script_file = FileHelper.getConfigDirectory()+File.separator+config.getProperty("script");
            if(config.getProperty("system").equalsIgnoreCase("mysql")){
                MysqlBDWinExporter exporter = new MysqlBDWinExporter(config.getProperty("program"),script_file,""+FileHelper.getConfigDirectory(), config.getProperty("user")
                        ,config.getProperty("password"), config.getProperty("database"));
                boolean result = exporter.execute();
                if(result){
                    String temp_file = FileHelper.getTemporalDirectory()+File.separator+config.getProperty("filename");
                    File file = new File(temp_file);
                    if(file.exists()){
                       return CommonTools.getStream(file,config.getProperty("filename"));
                    }else{
                        return Response.noContent().build();
                    }//end if(file.exists())
                }else{
                    throw new WebApplicationException(Response.status(Response.Status.PRECONDITION_FAILED).entity("L'exportation a échouée").build());
                }//end if(result){
            }else{
                throw new WebApplicationException(Response.status(Response.Status.PRECONDITION_FAILED).entity("Not supported yet.").build());
            }//end if(config.getProperty("system").equalsIgnoreCase("mysql")){            
        } catch (Exception ex) {
            Logger.getLogger(UploadFileRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(ex, Response.serverError().build());
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(UploadFileRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
     /**
	 * header sample
	 * {
	 * 	Content-Type=[image/png],
	 * 	Content-Disposition=[form-data; name="file"; filename="filename.extension"]
	 * }
	 **/
	//get uploaded filename, is there a easy way in RESTEasy?
	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

	//save to somewhere
        /**
         * 
         * @param content
         * @param filename
         * @throws IOException 
         */
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}

        /**
         * 
         * @param content
         * @param filename
         * @throws IOException 
         */
        private void writeFile(InputStream content, String filename) throws IOException {
                int read = 0;
                byte[] bytes = new byte[1024];
		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		while((read=content.read(bytes))!=-1){
                    fop.write(bytes, 0, read);
                }
		fop.flush();
		fop.close();

	}

    @Override
    public void deleteFile(@Context HttpHeaders headers,String filename) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
         String modulename = null ;
         if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String entityname = null ;
         if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
            entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
          Long _instance = null;
         if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
             _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename+" === _instance : "+_instance);
//         System.out.println(UploadFileRSImpl.class.toString()+".downloadImageFile(@Context HttpHeaders headers,String filename) ==== "+modulename);
         FileHelper.setCurrentModule(modulename);
         //Chargement du registre des resource
         ResourceRegistry resource = registry.getRegistryEntry(filename, entityname, modulename,_instance);
         File fichier = new File(FileHelper.getStaticDirectory()+File.separator+filename);
         if(resource!=null){
             fichier = new File(FileHelper.getStaticDirectory()+File.separator+resource.getStorename());
             registry.delete(resource.getId());
         }//end if(resource!=null){
//            System.out.println(UploadFileRSImpl.class.toString()+" ==== "+fichier.getAbsolutePath());
        if(fichier.exists()&&fichier.isFile()){
            fichier.delete();            
        }//end if(fichier.exists()&&fichier.isFile()){
    }

    @Override
    public void deleteTempFile(@Context HttpHeaders headers,String filename) {
        //To change body of generated methods, choose Tools | Templates.
        File fichier = new File(FileHelper.getTemporalDirectory()+File.separator+filename);
//            System.out.println(UploadFileRSImpl.class.toString()+" ==== "+fichier.getAbsolutePath());
        if(fichier.exists()&&fichier.isFile()){
            fichier.delete();
        }
    }    

    @Override
    public Response downloadImageFileFree(@Context HttpHeaders headers,String filename) {
        //To change body of generated methods, choose Tools | Templates.
        try {
            //To change body of generated methods, choose Tools | Templates.
            File fichier = new File(FileHelper.getStaticDirectory()+File.separator+filename);
//            System.out.println(UploadFileRSImpl.class.toString()+" ==== "+fichier.getAbsolutePath());
            if(!fichier.exists()||!fichier.isFile()){
                fichier = new File(FileHelper.getStaticDirectory()+File.separator+"avatar.png");
            }
            return CommonTools.getImage(fichier);
        } catch (IOException ex) {
             Response.serverError().build();
        }
        return Response.noContent().build();
    }

    @Override
    public GenericManager<BaseElement, Long> getManager() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String nothing(HttpHeaders headers) {
         //To change body of generated methods, choose Tools | Templates.
        return "Just for usage";
    }

    @Override
    public Boolean cleanFiles(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
         List<Long> _instances = new ArrayList<Long>();
         String modulename = null ;
         if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
             modulename = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String entityname = null ;
         if(headers.getRequestHeader("entity")!=null && !headers.getRequestHeader("entity").isEmpty()){
            entityname = gson.fromJson(headers.getRequestHeader("entity").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
          Long _instance = null;
         if(headers.getRequestHeader("entityid")!=null && !headers.getRequestHeader("entityid").isEmpty()){
             _instance = gson.fromJson(headers.getRequestHeader("entityid").get(0), Long.class);
             _instances.add(_instance);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         if(headers.getRequestHeader("entityids")!=null && !headers.getRequestHeader("entityids").isEmpty()){
             List<Long> ids = gson.fromJson(headers.getRequestHeader("entityids").get(0), new TypeToken<List<Long>>(){}.getType());
             if(ids!=null && !ids.isEmpty()){
                 _instances.addAll(ids);
             }
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         String serial = null;
         if(headers.getRequestHeader("entityserial")!=null && !headers.getRequestHeader("entityserial").isEmpty()){
             serial = gson.fromJson(headers.getRequestHeader("entityserial").get(0), String.class);
         }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
         //Chargement de tous les ficiers de cette instances
         RestrictionsContainer container = RestrictionsContainer.newInstance();
         container.addEq("entity", entityname);
         container.addEq("_instance", _instance);
         if(modulename!=null){
            container.addEq("modele", modulename);
         }//end if(modele!=null){
         List<ResourceRegistry> resources = registry.filter(container.getPredicats(), null, null, 0, -1);
         for(ResourceRegistry resource : resources){
             StringBuilder builder = new StringBuilder(FileHelper.getStaticDirectory().getPath());
             builder.append(File.separator).append(resource.getStorename());
             File fichier = new File(builder.toString());
             if(fichier.isFile() && fichier.exists()){
                 try {
                     FileHelper.deleteFile(fichier);
                 } catch (IOException ex) {
                     Logger.getLogger(UploadFileRSImpl.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }//end if(fichier.isFile() && fichier.exists()){
             registry.delete(resource.getId());
         }//end  for(ResourceRegistry resource : resources){
         //Suppression des pieces jointe
         if(serial!=null){
             container = RestrictionsContainer.newInstance();
             container.addEq("entityserial", serial);
             container.addEq("entityid", _instance);
             List<PieceJointe> pieces = pjmanager.filter(container.getPredicats(), null, null, 0, -1);
             for(PieceJointe pj:pieces){
                 pjmanager.delete(pj.getId());
             }//end for(PieceJointe pj:pieces){
             //Suppression des follwer generées
             List<Follower> followers = followermanager.filter(container.getPredicats(), null, null, 0, -1);
             for(Follower follower:followers){
                 followermanager.delete(follower.getId());
             }
         }//end  if(serial!=null){
         
         
         return true;
    }

    
}
