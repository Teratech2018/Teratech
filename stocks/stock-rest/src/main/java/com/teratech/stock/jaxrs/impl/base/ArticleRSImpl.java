
package com.teratech.stock.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.base.ArticleManagerRemote;
import com.teratech.stock.jaxrs.ifaces.base.ArticleRS;
import com.teratech.stock.model.base.Article;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Mon Feb 19 16:55:37 GMT+01:00 2018
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
    @Manager(application = "teratechstock", name = "ArticleManagerImpl", interf = ArticleManagerRemote.class)
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
        return ("teratechstock");
    }

      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new Article(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
            MetaColumn workbtn = new MetaColumn("button", "work1", "Emplacements de stockage", false, "link", null);
            workbtn.setValue("{'name':'teratech_stock_str_3',template:{'article':'object'},'header':['article']}");
//            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }
    

}
