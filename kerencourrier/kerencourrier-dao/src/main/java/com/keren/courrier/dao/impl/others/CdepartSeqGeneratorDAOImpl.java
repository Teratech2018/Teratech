
package com.keren.courrier.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.others.CdepartSeqGeneratorDAOLocal;
import com.keren.courrier.dao.ifaces.others.CdepartSeqGeneratorDAORemote;
import com.keren.courrier.model.others.CdepartSeqGenerator;

@Stateless(mappedName = "CdepartSeqGeneratorDAO")
public class CdepartSeqGeneratorDAOImpl
    extends AbstractGenericDAO<CdepartSeqGenerator, Long>
    implements CdepartSeqGeneratorDAOLocal, CdepartSeqGeneratorDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CdepartSeqGeneratorDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CdepartSeqGenerator> getManagedEntityClass() {
        return (CdepartSeqGenerator.class);
    }

}
