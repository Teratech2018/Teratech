
package com.keren.courrier.dao.impl.others;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.others.CinterneSeqGeneratorDAOLocal;
import com.keren.courrier.dao.ifaces.others.CinterneSeqGeneratorDAORemote;
import com.keren.courrier.model.others.CinterneSeqGenerator;

@Stateless(mappedName = "CinterneSeqGeneratorDAO")
public class CinterneSeqGeneratorDAOImpl
    extends AbstractGenericDAO<CinterneSeqGenerator, Long>
    implements CinterneSeqGeneratorDAOLocal, CinterneSeqGeneratorDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public CinterneSeqGeneratorDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CinterneSeqGenerator> getManagedEntityClass() {
        return (CinterneSeqGenerator.class);
    }

}
