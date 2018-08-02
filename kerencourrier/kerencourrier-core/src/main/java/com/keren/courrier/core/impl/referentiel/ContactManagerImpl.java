
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.ContactManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.ContactManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.ContactDAOLocal;
import com.keren.courrier.model.referentiel.Contact;

@TransactionAttribute
@Stateless(mappedName = "ContactManager")
public class ContactManagerImpl
    extends AbstractGenericManager<Contact, Long>
    implements ContactManagerLocal, ContactManagerRemote
{

    @EJB(name = "ContactDAO")
    protected ContactDAOLocal dao;

    public ContactManagerImpl() {
    }

    @Override
    public GenericDAO<Contact, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
