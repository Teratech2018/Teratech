
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.FormateurDAOLocal;
import com.keren.dao.ifaces.formations.FormateurDAORemote;
import com.keren.model.formations.Formateur;

@Stateless(mappedName = "FormateurDAO")
public class FormateurDAOImpl
    extends AbstractGenericDAO<Formateur, Long>
    implements FormateurDAOLocal, FormateurDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FormateurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Formateur> getManagedEntityClass() {
        return (Formateur.class);
    }

}
