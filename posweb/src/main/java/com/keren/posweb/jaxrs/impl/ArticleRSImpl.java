
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.posweb.core.ifaces.ArticleManagerRemote;
import com.keren.posweb.jaxrs.ifaces.ArticleRS;
import com.keren.posweb.model.Article;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Sep 04 17:34:18 GMT+01:00 2018
 * 
 */
@Path("/article")
public class ArticleRSImpl
    extends AbstractGenericService<Article, Long>
    implements ArticleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "ArticleManagerImpl", interf = ArticleManagerRemote.class)
    protected ArticleManagerRemote manager;

    public ArticleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Article, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new Article(), new HashMap<String, MetaData>(), new ArrayList<String>());
             MetaColumn workbtn = new MetaColumn("header", "work1", "Annotations", false, "link", null);
            workbtn.setValue("{'name':'courrier_trait_02_1',template:{'courrier':'object','quoteur':'object.destinataire','service':'object.destinataire.service'},'header':['courrier'],'label':'delai'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("fa fa-quora");
            meta.getHeader().add(workbtn);  
            workbtn = new MetaColumn("header", "work2", "Quotations", false, "link", null);
            workbtn.setValue("{'name':'courrier_trait_02_1',template:{'courrier':'object','quoteur':'object.destinataire','service':'object.destinataire.service'},'header':['courrier'],'label':'delai'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("fa fa-pencil");
            meta.getHeader().add(workbtn);  
            workbtn = new MetaColumn("header", "work3", "Classements", false, "link", null);
            workbtn.setValue("{'name':'courrier_trait_02_1',template:{'courrier':'object','quoteur':'object.destinataire','service':'object.destinataire.service'},'header':['courrier'],'label':'delai'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("fa fa-university");
            meta.getHeader().add(workbtn);  
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    protected void processBeforeUpdate(Article entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le Champ Reference Interne est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le Champ Intitulé est obligatoire");
        }
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Article entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le Champ Reference Interne est obligatoire");
        }else if(entity.getIntitule()==null||entity.getIntitule().trim().isEmpty()){
            throw new KerenExecption("Le Champ Intitulé est obligatoire");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
