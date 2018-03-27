
package com.keren.kerenpaie.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.comptabilite.CompteAnalytiqueDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.CompteAnalytiqueDAORemote;
import com.keren.kerenpaie.model.comptabilite.CompteAnalytique;

@Stateless(mappedName = "CompteAnalytiqueDAO")
public class CompteAnalytiqueDAOImpl
    extends AbstractGenericDAO<CompteAnalytique, Long>
    implements CompteAnalytiqueDAOLocal, CompteAnalytiqueDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public CompteAnalytiqueDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CompteAnalytique> getManagedEntityClass() {
        return (CompteAnalytique.class);
    }

}
