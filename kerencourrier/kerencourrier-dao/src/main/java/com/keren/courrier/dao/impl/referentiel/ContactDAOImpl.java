
package com.keren.courrier.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.referentiel.ContactDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.ContactDAORemote;
import com.keren.courrier.model.referentiel.Contact;

@Stateless(mappedName = "ContactDAO")
public class ContactDAOImpl
    extends AbstractGenericDAO<Contact, Long>
    implements ContactDAOLocal, ContactDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
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
