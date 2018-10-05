
package com.keren.courrier.dao.impl.archivage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.keren.courrier.dao.ifaces.archivage.BorderoLiasseDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.BorderoLiasseDAORemote;
import com.keren.courrier.model.archivage.BorderoLiasse;
import com.keren.courrier.model.archivage.LigneBorderoLiasse;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierAArchiver;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;

@Stateless(mappedName = "BorderoLiasseDAO")
public class BorderoLiasseDAOImpl
    extends AbstractGenericDAO<BorderoLiasse, Long>
    implements BorderoLiasseDAOLocal, BorderoLiasseDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public BorderoLiasseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BorderoLiasse> getManagedEntityClass() {
        return (BorderoLiasse.class);
    }
    @Override
    public BorderoLiasse checkBordero(StructureCompany source, StructureCompany cible) {
        //To change body of generated methods, choose Tools | Templates.
         RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("source", source);
        container.addEq("cible", cible);
        container.addEq("state", "etabli");
        List<BorderoLiasse> borderos = filter(container.getPredicats(), null, null, 0, -1);
        if(borderos!=null&&!borderos.isEmpty()){
            return borderos.get(0);
        }//end if(borderos!=null&&!borderos.isEmpty()){
        BorderoLiasse  bordero = new BorderoLiasse();
        bordero.setSource(source);
        bordero.setCible(cible);
        bordero.setCreation(new Date());
        bordero.setState("etabli");
        save(bordero);
        borderos = filter(container.getPredicats(), null, null, 0, -1);
        return borderos.get(0);//end if(borderos!=null&&!borderos.isEmpty()){
    }
    
   
    @Override
    public void setManager(EntityManager manager) {
        super.setManager(manager); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public void processBeforeDelete(BorderoLiasse entity) {
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processAfterUpdate(BorderoLiasse entity) {
        BorderoLiasse old = getEntityManager().find(BorderoLiasse.class, entity.getId());
        //Map 
        Map<Long,LigneBorderoLiasse> map = new HashMap<Long, LigneBorderoLiasse>();
        for(LigneBorderoLiasse ligne:old.getLignes()){
            map.put(ligne.getId(), ligne);
        }//end for(LigneBorderoCourrier ligne:old.getCourriers()){
       
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeUpdate(BorderoLiasse entity) {
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processAfterSave(BorderoLiasse entity) {
        for(LigneBorderoLiasse ligne:entity.getLignes()){
           
        }//end for(LigneBorderoCourrier ligne:entity.getCourriers()){        
        super.processAfterSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(BorderoLiasse entity) {       
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
}
