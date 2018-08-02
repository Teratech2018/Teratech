
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.base.ContactManagerLocal;
import com.teratech.gmao.core.ifaces.base.ContactManagerRemote;
import com.teratech.gmao.dao.ifaces.base.ContactDAOLocal;
import com.teratech.gmao.model.base.Contact;

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
