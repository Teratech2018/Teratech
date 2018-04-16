
package com.keren.kerenpaie.core.impl.rapports;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.rapports.ViewBulletinPaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.rapports.ViewBulletinPaieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.rapports.ViewBulletinPaieDAOLocal;
import com.keren.kerenpaie.model.rapports.ViewBulletinPaie;

@TransactionAttribute
@Stateless(mappedName = "ViewBulletinPaieManager")
public class ViewBulletinPaieManagerImpl
    extends AbstractGenericManager<ViewBulletinPaie, Long>
    implements ViewBulletinPaieManagerLocal, ViewBulletinPaieManagerRemote
{

    @EJB(name = "ViewBulletinPaieDAO")
    protected ViewBulletinPaieDAOLocal dao;

    public ViewBulletinPaieManagerImpl() {
    }

    @Override
    public GenericDAO<ViewBulletinPaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<ViewBulletinPaie> getCriteres(ViewBulletinPaie critere) {
         //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        if(critere!=null){
   
            if(critere.getPeriode()!=null){
                container.addEq("periode.id", critere.getPeriode().getId());
            }
            
            if(critere.getMatricule()!=null){
                container.addEq("matricule", critere.getMatricule());
            }
            
//            if(critere.getClasse()!=null){
//                container.addEq("classe.libelle", critere.getClasse().getLibelle());
//            }
          
        }
        List<ViewBulletinPaie> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
        List<ViewBulletinPaie>  result = new ArrayList<ViewBulletinPaie>();
        for(ViewBulletinPaie ecrit:datas){            
        	ViewBulletinPaie ecriture = new ViewBulletinPaie(ecrit);
            result.add(ecriture);
        }
        return result;
    }

}
