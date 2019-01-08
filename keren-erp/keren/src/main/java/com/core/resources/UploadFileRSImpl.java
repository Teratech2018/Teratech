/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.resources;

import com.google.gson.Gson;
import com.kerem.core.CommonTools;
import com.kerem.core.FileHelper;
import java.io.File;
import java.io.IOException;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author Commercial_2
 */
@Path("/resource")
public class UploadFileRSImpl  implements UploadFileRS{

     @Override
    public Response downloadImageFileFree(@Context HttpHeaders headers ,String filename) {
        //To change body of generated methods, choose Tools | Templates.
        try {
            Gson gson = new Gson();
            String _module = null;
             FileHelper.setCurrentModule(null);
            if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
                _module = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);               
            }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
            if(_module!=null && !_module.isEmpty()){
                FileHelper.setCurrentModule(_module);
            }//end if(_module!=null && !_module.isEmpty()){
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
    public Response downloadTextFile(@Context HttpHeaders headers ,String filename) {
       //To change body of generated methods, choose Tools | Templates.
         try{   Gson gson = new Gson();
                String _module = null;
                 FileHelper.setCurrentModule(null);
                if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
                    _module = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
//                    FileHelper.setCurrentModule(_module);
                }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
                if(_module!=null && !_module.isEmpty()){
                    FileHelper.setCurrentModule(_module);
                }//end if(_module!=null && !_module.isEmpty()){
                FileHelper.setCurrentModule(_module);
                String resourceDir = FileHelper.getStaticDirectory()+File.separator+filename;
                File file = new File(resourceDir);
                if(file.exists()){
                    return CommonTools.getText(file,file.getName());
                }else{
                    return Response.noContent().build();
                }//end if(file.exists())
        }catch(Exception ex){
            throw new WebApplicationException(ex, Response.serverError().build());
        }
    }

    @Override
    public String getTextFileContaint(@Context HttpHeaders headers ,String filename) {
        //To change body of generated methods, choose Tools | Templates.
         try{
                Gson gson = new Gson();
                String _module = null;
                 FileHelper.setCurrentModule(null);
                if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
                    _module = gson.fromJson(headers.getRequestHeader("modulename").get(0), String.class);
                    FileHelper.setCurrentModule(null);
                }//end if(headers.getRequestHeader("modulename")!=null && !headers.getRequestHeader("modulename").isEmpty()){
                if(_module!=null && !_module.isEmpty()){
                    FileHelper.setCurrentModule(_module);
                }//end if(_module!=null && !_module.isEmpty()){
                FileHelper.setCurrentModule(_module);
                String resourceDir = FileHelper.getStaticDirectory()+File.separator+filename;
                File file = new File(resourceDir);
                if(file.exists()){
                    return CommonTools.getTextStream(file,file.getName());
                }else{
                    return null;
                }//end if(file.exists())
        }catch(Exception ex){
            throw new WebApplicationException(ex, Response.serverError().build());
        }
    }
    
}
