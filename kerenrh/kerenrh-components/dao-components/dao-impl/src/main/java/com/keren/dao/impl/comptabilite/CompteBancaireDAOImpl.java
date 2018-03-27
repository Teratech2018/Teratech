
package com.keren.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.comptabilite.CompteBancaireDAOLocal;
import com.keren.dao.ifaces.comptabilite.CompteBancaireDAORemote;
import com.keren.model.comptabilite.CompteBancaire;

@Stateless(mappedName = "CompteBancaireDAO")
public class CompteBancaireDAOImpl
    extends AbstractGenericDAO<CompteBancaire, Long>
    implements CompteBancaireDAOLocal, CompteBancaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CompteBancaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CompteBancaire> getManagedEntityClass() {
        return (CompteBancaire.class);
    }

}
