
package com.kerenedu.inscription;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "InscriptionChoiceDAO")
public class InscriptionChoiceDAOImpl
    extends AbstractGenericDAO<InscriptionChoice, Long>
    implements InscriptionChoiceDAOLocal, InscriptionChoiceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public InscriptionChoiceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<InscriptionChoice> getManagedEntityClass() {
        return (InscriptionChoice.class);
    }

}
