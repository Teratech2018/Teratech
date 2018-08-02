
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.ContactDAOLocal;
import com.teratech.gmao.dao.ifaces.base.ContactDAORemote;
import com.teratech.gmao.model.base.Contact;

@Stateless(mappedName = "ContactDAO")
public class ContactDAOImpl
    extends AbstractGenericDAO<Contact, Long>
    implements ContactDAOLocal, ContactDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public ContactDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Contact> getManagedEntityClass() {
        return (Contact.class);
    }

}
