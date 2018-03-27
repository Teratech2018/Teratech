
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.TypeDemandeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.TypeDemandeDAORemote;
import com.keren.kerenpaie.model.structures.TypeDemande;

@Stateless(mappedName = "TypeDemandeDAO")
public class TypeDemandeDAOImpl
    extends AbstractGenericDAO<TypeDemande, Long>
    implements TypeDemandeDAOLocal, TypeDemandeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public TypeDemandeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeDemande> getManagedEntityClass() {
        return (TypeDemande.class);
    }

}
