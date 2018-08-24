/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Commercial_2
 */
public interface UploadFileRS {    
   
    @GET
    @Path("static/{filename}")
    @Produces("image/png")
    public Response downloadImageFileFree(@PathParam("filename") String filename);
    
    @GET
    @Path("text/{filename}")
    @Produces("text/plain")
    public Response downloadTextFile(@PathParam("filename") String filename);
    
    @GET
    @Path("textstream/{filename}")
    @Produces("text/plain")
    public String getTextFileContaint(@PathParam("filename") String filename);
    
}
