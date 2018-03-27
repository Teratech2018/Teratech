
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.ElementSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementSalaireDAORemote;
import com.keren.kerenpaie.model.paie.ElementSalaire;

@Stateless(mappedName = "ElementSalaireDAO")
public class ElementSalaireDAOImpl
    extends AbstractGenericDAO<ElementSalaire, Long>
    implements ElementSalaireDAOLocal, ElementSalaireDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public ElementSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ElementSalaire> getManagedEntityClass() {
        return (ElementSalaire.class);
    }

}
