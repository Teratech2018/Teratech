
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.TypeDemandeManagerLocal;
import com.keren.core.ifaces.structures.TypeDemandeManagerRemote;
import com.keren.dao.ifaces.structures.TypeDemandeDAOLocal;
import com.keren.model.structures.TypeDemande;

@TransactionAttribute
@Stateless(mappedName = "TypeDemandeManager")
public class TypeDemandeManagerImpl
    extends AbstractGenericManager<TypeDemande, Long>
    implements TypeDemandeManagerLocal, TypeDemandeManagerRemote
{

    @EJB(name = "TypeDemandeDAO")
    protected TypeDemandeDAOLocal dao;

    public TypeDemandeManagerImpl() {
    }

    @Override
    public GenericDAO<TypeDemande, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
