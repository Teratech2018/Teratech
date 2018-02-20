/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.jaxrs.search;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.model.search.EleveSearch;
import com.kerenedu.school.Eleve;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 *
 * @author Commercial_2
 */
public interface EleveSearchRS {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("meta")
    public MetaData getMetaData();
    
    /**
     * 
     */
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Path("somethings")
    public List<Eleve> getCriteres(EleveSearch eleveSearch);
    //List<EcritureComptable> somethings(EcritureSearch param);
    
    @PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(EleveSearch eleveSearch);
}
