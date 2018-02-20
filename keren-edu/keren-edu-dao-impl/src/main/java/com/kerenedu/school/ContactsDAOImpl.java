
package com.kerenedu.school;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ContactsDAO")
public class ContactsDAOImpl
    extends AbstractGenericDAO<Contacts, Long>
    implements ContactsDAOLocal, ContactsDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ContactsDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Contacts> getManagedEntityClass() {
        return (Contacts.class);
    }

}
