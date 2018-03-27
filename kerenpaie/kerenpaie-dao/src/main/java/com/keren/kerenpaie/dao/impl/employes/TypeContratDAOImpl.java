
package com.keren.kerenpaie.dao.impl.employes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.employes.TypeContratDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.TypeContratDAORemote;
import com.keren.kerenpaie.model.employes.TypeContrat;

@Stateless(mappedName = "TypeContratDAO")
public class TypeContratDAOImpl
    extends AbstractGenericDAO<TypeContrat, Long>
    implements TypeContratDAOLocal, TypeContratDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public TypeContratDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeContrat> getManagedEntityClass() {
        return (TypeContrat.class);
    }

}
