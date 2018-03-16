
package com.basaccount.dao.impl.achats;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.basaccount.dao.ifaces.achats.NoteFraisDAOLocal;
import com.basaccount.dao.ifaces.achats.NoteFraisDAORemote;
import com.basaccount.model.achats.NoteFrais;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NoteFraisDAO")
public class NoteFraisDAOImpl
    extends AbstractGenericDAO<NoteFrais, Long>
    implements NoteFraisDAOLocal, NoteFraisDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NoteFraisDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NoteFrais> getManagedEntityClass() {
        return (NoteFrais.class);
    }

}
