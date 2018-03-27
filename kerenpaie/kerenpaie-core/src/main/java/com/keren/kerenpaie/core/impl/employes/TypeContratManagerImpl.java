
package com.keren.kerenpaie.core.impl.employes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.employes.TypeContratManagerLocal;
import com.keren.kerenpaie.core.ifaces.employes.TypeContratManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.TypeContratDAOLocal;
import com.keren.kerenpaie.model.employes.TypeContrat;

@TransactionAttribute
@Stateless(mappedName = "TypeContratManager")
public class TypeContratManagerImpl
    extends AbstractGenericManager<TypeContrat, Long>
    implements TypeContratManagerLocal, TypeContratManagerRemote
{

    @EJB(name = "TypeContratDAO")
    protected TypeContratDAOLocal dao;

    public TypeContratManagerImpl() {
    }

    @Override
    public GenericDAO<TypeContrat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
