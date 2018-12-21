
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierManagerLocal;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.LigneBorderoCourrierDAOLocal;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;

@TransactionAttribute
@Stateless(mappedName = "LigneBorderoCourrierManager")
public class LigneBorderoCourrierManagerImpl
    extends AbstractGenericManager<LigneBorderoCourrier, Long>
    implements LigneBorderoCourrierManagerLocal, LigneBorderoCourrierManagerRemote
{

    @EJB(name = "LigneBorderoCourrierDAO")
    protected LigneBorderoCourrierDAOLocal dao;

    public LigneBorderoCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<LigneBorderoCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public boolean originalAllReadyaffect(LigneBorderoCourrier ligne , StructureCompany service) {
        //To change body of generated methods, choose Tools | Templates.
        if(ligne.getCourrier().getBordero()==null){
            return false;
        }else if(ligne.getCourrier().getBordero().getCible().compareTo(service)!=0 && ligne.getNature().trim().equalsIgnoreCase("0")){
            return true;
        }
        return false;
    }

}
