
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.TypeDossierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.TypeDossierDAORemote;
import com.keren.courrier.model.referentiel.TypeDossier;

@Stateless(mappedName = "TypeDossierDAO")
public class TypeDossierDAOImpl
    extends AbstractGenericDAO<TypeDossier, Long>
    implements TypeDossierDAOLocal, TypeDossierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public TypeDossierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<TypeDossier> getManagedEntityClass() {
        return (TypeDossier.class);
    }

}
