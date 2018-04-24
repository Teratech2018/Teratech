
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.TypeCaisseManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.TypeCaisseManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.TypeCaisseDAOLocal;
import com.keren.kerenpaie.model.structures.TypeCaisse;

@TransactionAttribute
@Stateless(mappedName = "TypeCaisseManager")
public class TypeCaisseManagerImpl
    extends AbstractGenericManager<TypeCaisse, Long>
    implements TypeCaisseManagerLocal, TypeCaisseManagerRemote
{

    @EJB(name = "TypeCaisseDAO")
    protected TypeCaisseDAOLocal dao;

    public TypeCaisseManagerImpl() {
    }

    @Override
    public GenericDAO<TypeCaisse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
