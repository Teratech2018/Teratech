
package com.keren.kerenpaie.core.impl.paie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.ElementSalaireManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.ElementSalaireManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.ElementSalaireDAOLocal;
import com.keren.kerenpaie.model.paie.ElementSalaire;

@TransactionAttribute
@Stateless(mappedName = "ElementSalaireManager")
public class ElementSalaireManagerImpl
    extends AbstractGenericManager<ElementSalaire, Long>
    implements ElementSalaireManagerLocal, ElementSalaireManagerRemote
{

    @EJB(name = "ElementSalaireDAO")
    protected ElementSalaireDAOLocal dao;

    public ElementSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<ElementSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
