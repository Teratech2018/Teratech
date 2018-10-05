
package com.keren.courrier.core.impl.others;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.others.CinterneSeqGeneratorManagerLocal;
import com.keren.courrier.core.ifaces.others.CinterneSeqGeneratorManagerRemote;
import com.keren.courrier.dao.ifaces.others.CinterneSeqGeneratorDAOLocal;
import com.keren.courrier.model.others.CinterneSeqGenerator;

@TransactionAttribute
@Stateless(mappedName = "CinterneSeqGeneratorManager")
public class CinterneSeqGeneratorManagerImpl
    extends AbstractGenericManager<CinterneSeqGenerator, Long>
    implements CinterneSeqGeneratorManagerLocal, CinterneSeqGeneratorManagerRemote
{

    @EJB(name = "CinterneSeqGeneratorDAO")
    protected CinterneSeqGeneratorDAOLocal dao;

    public CinterneSeqGeneratorManagerImpl() {
    }

    @Override
    public GenericDAO<CinterneSeqGenerator, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
