
package com.basaccount.jaxrs.impl.ventes;

import javax.ws.rs.Path;
import com.basaccount.core.ifaces.ventes.FactureVenteManagerRemote;
import com.basaccount.jaxrs.ifaces.ventes.FactureVenteRS;
import com.basaccount.model.ventes.FactureVente;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Jan 15 20:58:54 WAT 2019
 * 
 */
@Path("/facturevente")
public class FactureVenteRSImpl
    extends AbstractGenericService<FactureVente, Long>
    implements FactureVenteRS
{

    public static String FOOTER="<tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total HT</td><td class='text-right'>this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100</td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Escompte</td><td class='text-right'>this.quantite;*;this.puht;*;object.escompte;/;100</td></tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Taxes</td><td  class='text-right'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};/;100</td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Total TTC</td><td  class='text-right'  style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100</td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total Acomptes</td><td class='text-right'   style='font-weight: bold;'>{\"op\":\"sum\",\"source\":\"object\",\"data\":\"acomptes\",\"field\":\"montant\"}</td></tr><tr style='border:none;'><td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Net à payer</td><td class='text-right'    style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;-;object.escompte;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100;-;{\"op\":\"sum\",\"source\":\"object\",\"data\":\"acomptes\",\"field\":\"montant\"}</td></tr>";
    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "baseaccount", name = "FactureVenteManagerImpl", interf = FactureVenteManagerRemote.class)
    protected FactureVenteManagerRemote manager;

    public FactureVenteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FactureVente, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("baseaccount");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new FactureVente(), new HashMap<String, MetaData>(), new ArrayList<String>());
            for(MetaColumn col:meta.getColumns()){
                if(col.getFieldName().equalsIgnoreCase("emplacement")){
                    col.setHide(true);
                }
            }//end for(MetaColumn col:meta.getColumns())
            for(MetaGroup group:meta.getGroups()){
                if(group.getGroupName().trim().equalsIgnoreCase("group1")){
//                    System.out.println(FactureRSImpl.class.toString()+"  =============================== "+group.getMetaArray()+" ====== "+group.getMetaArray().isCustomfooter()+" ==== "+group.getMetaArray().getFooterScript());
                     group.getMetaArray().get(0).setFooterScript(FOOTER);
                }//end if(group.getGroupName().trim().equalsIgnoreCase("group1"))
            }//end for(MetaGroup group:meta.getGroups())
        } catch (InstantiationException ex) {
            Logger.getLogger(FactureVenteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FactureVenteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
