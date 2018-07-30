
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.TypeCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.TypeCourrierDAORemote;
import com.keren.courrier.model.referentiel.TypeCourrier;

@Stateless(mappedName = "TypeCourrierDAO")
public class TypeCourrierDAOImpl
    extends AbstractGenericDAO<TypeCourrier, Long>
    implements TypeCourrierDAOLocal, TypeCourrierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public TypeCourrierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeCourrier> getManagedEntityClass() {
        return (TypeCourrier.class);
    }

}
