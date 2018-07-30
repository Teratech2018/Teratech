
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.TypeCorrespondantDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.TypeCorrespondantDAORemote;
import com.keren.courrier.model.referentiel.TypeCorrespondant;

@Stateless(mappedName = "TypeCorrespondantDAO")
public class TypeCorrespondantDAOImpl
    extends AbstractGenericDAO<TypeCorrespondant, Long>
    implements TypeCorrespondantDAOLocal, TypeCorrespondantDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public TypeCorrespondantDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeCorrespondant> getManagedEntityClass() {
        return (TypeCorrespondant.class);
    }

}
