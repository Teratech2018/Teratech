
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.TypeCaisseDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.TypeCaisseDAORemote;
import com.keren.kerenpaie.model.structures.TypeCaisse;

@Stateless(mappedName = "TypeCaisseDAO")
public class TypeCaisseDAOImpl
    extends AbstractGenericDAO<TypeCaisse, Long>
    implements TypeCaisseDAOLocal, TypeCaisseDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public TypeCaisseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeCaisse> getManagedEntityClass() {
        return (TypeCaisse.class);
    }

}
