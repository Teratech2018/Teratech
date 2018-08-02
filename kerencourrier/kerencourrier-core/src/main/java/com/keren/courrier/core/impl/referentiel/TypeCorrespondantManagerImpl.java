
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.TypeCorrespondantManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.TypeCorrespondantManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.TypeCorrespondantDAOLocal;
import com.keren.courrier.model.referentiel.TypeCorrespondant;

@TransactionAttribute
@Stateless(mappedName = "TypeCorrespondantManager")
public class TypeCorrespondantManagerImpl
    extends AbstractGenericManager<TypeCorrespondant, Long>
    implements TypeCorrespondantManagerLocal, TypeCorrespondantManagerRemote
{

    @EJB(name = "TypeCorrespondantDAO")
    protected TypeCorrespondantDAOLocal dao;

    public TypeCorrespondantManagerImpl() {
    }

    @Override
    public GenericDAO<TypeCorrespondant, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
