
package com.keren.courrier.core.impl.others;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.others.CaSeqGeneratorManagerLocal;
import com.keren.courrier.core.ifaces.others.CaSeqGeneratorManagerRemote;
import com.keren.courrier.dao.ifaces.others.CaSeqGeneratorDAOLocal;
import com.keren.courrier.model.others.CaSeqGenerator;

@TransactionAttribute
@Stateless(mappedName = "CaSeqGeneratorManager")
public class CaSeqGeneratorManagerImpl
    extends AbstractGenericManager<CaSeqGenerator, Long>
    implements CaSeqGeneratorManagerLocal, CaSeqGeneratorManagerRemote
{

    @EJB(name = "CaSeqGeneratorDAO")
    protected CaSeqGeneratorDAOLocal dao;

    public CaSeqGeneratorManagerImpl() {
    }

    @Override
    public GenericDAO<CaSeqGenerator, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
