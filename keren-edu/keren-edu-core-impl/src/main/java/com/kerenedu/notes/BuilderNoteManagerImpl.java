
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "BuilderNoteManager")
public class BuilderNoteManagerImpl
    extends AbstractGenericManager<BuilderNote, Long>
    implements BuilderNoteManagerLocal, BuilderNoteManagerRemote
{

    @EJB(name = "BuilderNoteDAO")
    protected BuilderNoteDAOLocal dao;

    public BuilderNoteManagerImpl() {
    }

    @Override
    public GenericDAO<BuilderNote, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
