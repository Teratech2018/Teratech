
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.TypeDossierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.TypeDossierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.TypeDossierDAOLocal;
import com.keren.courrier.model.referentiel.TypeDossier;

@TransactionAttribute
@Stateless(mappedName = "TypeDossierManager")
public class TypeDossierManagerImpl
    extends AbstractGenericManager<TypeDossier, Long>
    implements TypeDossierManagerLocal, TypeDossierManagerRemote
{

    @EJB(name = "TypeDossierDAO")
    protected TypeDossierDAOLocal dao;

    public TypeDossierManagerImpl() {
    }

    @Override
    public GenericDAO<TypeDossier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
