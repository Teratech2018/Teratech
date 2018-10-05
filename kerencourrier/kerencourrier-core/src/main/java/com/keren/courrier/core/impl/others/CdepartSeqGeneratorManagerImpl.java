
package com.keren.courrier.core.impl.others;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.others.CdepartSeqGeneratorManagerLocal;
import com.keren.courrier.core.ifaces.others.CdepartSeqGeneratorManagerRemote;
import com.keren.courrier.dao.ifaces.others.CdepartSeqGeneratorDAOLocal;
import com.keren.courrier.model.others.CdepartSeqGenerator;

@TransactionAttribute
@Stateless(mappedName = "CdepartSeqGeneratorManager")
public class CdepartSeqGeneratorManagerImpl
    extends AbstractGenericManager<CdepartSeqGenerator, Long>
    implements CdepartSeqGeneratorManagerLocal, CdepartSeqGeneratorManagerRemote
{

    @EJB(name = "CdepartSeqGeneratorDAO")
    protected CdepartSeqGeneratorDAOLocal dao;

    public CdepartSeqGeneratorManagerImpl() {
    }

    @Override
    public GenericDAO<CdepartSeqGenerator, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
