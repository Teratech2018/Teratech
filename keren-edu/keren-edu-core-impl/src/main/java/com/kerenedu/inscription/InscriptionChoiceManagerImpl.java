
package com.kerenedu.inscription;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "InscriptionChoiceManager")
public class InscriptionChoiceManagerImpl
    extends AbstractGenericManager<InscriptionChoice, Long>
    implements InscriptionChoiceManagerLocal, InscriptionChoiceManagerRemote
{

    @EJB(name = "InscriptionChoiceDAO")
    protected InscriptionChoiceDAOLocal dao;

    public InscriptionChoiceManagerImpl() {
    }

    @Override
    public GenericDAO<InscriptionChoice, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
