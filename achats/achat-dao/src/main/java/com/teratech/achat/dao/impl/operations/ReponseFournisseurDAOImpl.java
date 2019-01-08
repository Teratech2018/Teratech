
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.ReponseFournisseurDAOLocal;
import com.teratech.achat.dao.ifaces.operations.ReponseFournisseurDAORemote;
import com.teratech.achat.model.operations.ReponseFournisseur;

@Stateless(mappedName = "ReponseFournisseurDAO")
public class ReponseFournisseurDAOImpl
    extends AbstractGenericDAO<ReponseFournisseur, Long>
    implements ReponseFournisseurDAOLocal, ReponseFournisseurDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public ReponseFournisseurDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ReponseFournisseur> getManagedEntityClass() {
        return (ReponseFournisseur.class);
    }

}
