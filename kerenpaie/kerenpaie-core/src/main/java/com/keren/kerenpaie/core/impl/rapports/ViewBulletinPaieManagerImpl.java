
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
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.BulletinPaie;
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
        List<ViewBulletinPaie> datas = new ArrayList<ViewBulletinPaie>();
        if(critere!=null){
        	  if(critere.getPorte()==null|| critere.getPorte().equals("0")){
        		  
        		  if(critere.getPeriode()!=null){
                      container.addEq("periode.id", critere.getPeriode().getId());
                  }
        		 datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
              }else{ 
            	  List<BulletinPaie> bulletinselect= critere.getConcernes();
            	  System.out.println("ViewBulletinPaieManagerImpl.getCriteres() nombre employes"+bulletinselect.size());
            	  datas = new ArrayList<ViewBulletinPaie>();
            	  List<ViewBulletinPaie> datasresult= new ArrayList<ViewBulletinPaie>();
            	  for(BulletinPaie bulletin :bulletinselect){
            		  datasresult= new ArrayList<ViewBulletinPaie>();
            		  container.addEq("bulletin.code", bulletin.getCode());
            		  datasresult = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
            		  datas.addAll(datasresult);
            	  }
              }
        }
        List<ViewBulletinPaie>  result = new ArrayList<ViewBulletinPaie>();
        for(ViewBulletinPaie ecrit:datas){            
        	ViewBulletinPaie ecriture = new ViewBulletinPaie(ecrit);
            result.add(ecriture);
        }
        return result;
    }

}
