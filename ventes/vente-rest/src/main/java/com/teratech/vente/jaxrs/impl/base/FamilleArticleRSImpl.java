
package com.teratech.vente.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.TreeNode;
import com.teratech.vente.core.ifaces.base.FamilleArticleManagerRemote;
import com.teratech.vente.jaxrs.ifaces.base.FamilleArticleRS;
import com.teratech.vente.jaxrs.impl.tools.FamilleArticleTNContainer;
import com.teratech.vente.model.base.FamilleArticle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 08:13:40 WAT 2019
 * 
 */
@Path("/famillearticle")
public class FamilleArticleRSImpl
    extends AbstractGenericService<FamilleArticle, Long>
    implements FamilleArticleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "FamilleArticleManagerImpl", interf = FamilleArticleManagerRemote.class)
    protected FamilleArticleManagerRemote manager;

    public FamilleArticleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FamilleArticle, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new FamilleArticle(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<TreeNode> treefilter(HttpHeaders headers, int firstResult, int maxResult) {
        List<FamilleArticle> familles = super.filter(headers, firstResult, maxResult);
        FamilleArticleTNContainer container = new FamilleArticleTNContainer();
        System.out.println(FamilleArticleRSImpl.class.toString()+" =======================================");
        return container.buildTree(familles); //To change body of generated methods, choose Tools | Templates.
    }
    

}