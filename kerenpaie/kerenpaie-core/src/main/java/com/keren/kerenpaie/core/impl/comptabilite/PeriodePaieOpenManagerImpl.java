
package com.keren.kerenpaie.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieOpenManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieOpenManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieOpenDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieOpen;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieOpenManager")
public class PeriodePaieOpenManagerImpl
    extends AbstractGenericManager<PeriodePaieOpen, Long>
    implements PeriodePaieOpenManagerLocal, PeriodePaieOpenManagerRemote
{

    @EJB(name = "PeriodePaieOpenDAO")
    protected PeriodePaieOpenDAOLocal dao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;

    public PeriodePaieOpenManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaieOpen, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    

	@Override
	public PeriodePaieOpen save(PeriodePaieOpen entity) {
		// TODO Auto-generated method stub
		entity.getPeriode().setState("ouvert");
		periodedao.update(entity.getPeriode().getId(), entity.getPeriode());
		CacheMemory.setPeriode(entity.getPeriode());
		return entity;
	}

	@Override
	public PeriodePaieOpen update(Long id, PeriodePaieOpen entity) {
		// TODO Auto-generated method stub
		entity.getPeriode().setState("ouvert");
		periodedao.update(entity.getPeriode().getId(), entity.getPeriode());
		CacheMemory.setPeriode(entity.getPeriode());
		return super.update(id, entity);
	}
    
    

}
