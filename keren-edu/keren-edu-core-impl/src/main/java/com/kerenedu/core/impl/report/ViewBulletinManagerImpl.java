
package com.kerenedu.core.impl.report;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.core.ifaces.report.ViewBulletinManagerLocal;
import com.kerenedu.core.ifaces.report.ViewBulletinManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewBulletinDAOLocal;
import com.kerenedu.model.report.ViewBulletin;
import com.kerenedu.model.search.EleveSearch;
import com.kerenedu.school.Eleve;

@TransactionAttribute
@Stateless(mappedName = "ViewBulletinManager")
public class ViewBulletinManagerImpl
    extends AbstractGenericManager<ViewBulletin, Long>
    implements ViewBulletinManagerLocal, ViewBulletinManagerRemote
{

    @EJB(name = "ViewBulletinDAO")
    protected ViewBulletinDAOLocal dao;

    public ViewBulletinManagerImpl() {
    }

    @Override
    public GenericDAO<ViewBulletin, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<ViewBulletin> getCriteres(ViewBulletin critere) {
         //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        if(critere!=null){
   
            if(critere.getMatricule()!=null){
                container.addEq("inscription.eleve.matricule", critere.getMatricule());
            }
          
        }
        List<ViewBulletin> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
        List<ViewBulletin>  result = new ArrayList<ViewBulletin>();
        for(ViewBulletin ecrit:datas){            
        	ViewBulletin ecriture = new ViewBulletin(ecrit);
            result.add(ecriture);
        }
        return result;
    }

}
