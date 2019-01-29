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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Commercial_2
 */
public interface UploadFileRS {    
   
    @GET
    @Path("static/{filename}")
    @Produces("image/png")
    public Response downloadImageFileFree(@Context HttpHeaders headers ,@PathParam("filename") String filename);
    
    /**
     *
     * @param headers
     * @param module
     * @param filename
     * @return
     */
    @GET
    @Path("module/{modulename}/{filename}")
    @Produces("image/png")
    public Response downloadImageFileFreeForModule(@Context HttpHeaders headers,@PathParam("modulename") String module ,@PathParam("filename") String filename);
    
     @GET
    @Path("entity/{entityname}/{modulename}/{filename}")
    @Produces("image/png")
    public Response downloadImageFileFreeForModule(@Context HttpHeaders headers,@PathParam("entityname") String entity ,@PathParam("modulename") String module ,@PathParam("filename") String filename);
    
    @GET
    @Path("text/{filename}")
    @Produces("text/plain")
    public Response downloadTextFile(@Context HttpHeaders headers ,@PathParam("filename") String filename);
    
    @GET
    @Path("textstream/{filename}")
    @Produces("text/plain")
    public String getTextFileContaint(@Context HttpHeaders headers ,@PathParam("filename") String filename);
    
    @GET
    @Path("stream/{filename}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(@Context HttpHeaders headers ,@PathParam("filename") String filename);
    
    @GET
    @Path("json/{filename}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response downloadJsonFile(@Context HttpHeaders headers ,@PathParam("filename") String filename);
    
    @GET
    @Path("translate")
    @Produces({MediaType.APPLICATION_JSON})
    public Response translate(@Context HttpHeaders headers ,@QueryParam("lang") String lang);
}
