
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "TraitNoteManager")
public class TraitNoteManagerImpl
    extends AbstractGenericManager<TraitNote, Long>
    implements TraitNoteManagerLocal, TraitNoteManagerRemote
{

    @EJB(name = "TraitNoteDAO")
    protected TraitNoteDAOLocal dao;

    public TraitNoteManagerImpl() {
    }

    @Override
    public GenericDAO<TraitNote, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
