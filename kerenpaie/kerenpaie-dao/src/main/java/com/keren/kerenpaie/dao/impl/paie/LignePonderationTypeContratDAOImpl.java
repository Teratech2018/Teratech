
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.LignePonderationTypeContratDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.LignePonderationTypeContratDAORemote;
import com.keren.kerenpaie.model.paie.LignePonderationTypeContrat;

@Stateless(mappedName = "LignePonderationTypeContratDAO")
public class LignePonderationTypeContratDAOImpl
    extends AbstractGenericDAO<LignePonderationTypeContrat, Long>
    implements LignePonderationTypeContratDAOLocal, LignePonderationTypeContratDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public LignePonderationTypeContratDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LignePonderationTypeContrat> getManagedEntityClass() {
        return (LignePonderationTypeContrat.class);
    }

}
