
package com.keren.kerenpaie.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.comptabilite.SectionAnalytiqueDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.SectionAnalytiqueDAORemote;
import com.keren.kerenpaie.model.comptabilite.SectionAnalytique;

@Stateless(mappedName = "SectionAnalytiqueDAO")
public class SectionAnalytiqueDAOImpl
    extends AbstractGenericDAO<SectionAnalytique, Long>
    implements SectionAnalytiqueDAOLocal, SectionAnalytiqueDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public SectionAnalytiqueDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SectionAnalytique> getManagedEntityClass() {
        return (SectionAnalytique.class);
    }

}
