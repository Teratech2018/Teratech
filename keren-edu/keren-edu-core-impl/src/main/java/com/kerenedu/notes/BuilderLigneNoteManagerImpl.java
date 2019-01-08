
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "BuilderLigneNoteManager")
public class BuilderLigneNoteManagerImpl
    extends AbstractGenericManager<BuilderLigneNote, Long>
    implements BuilderLigneNoteManagerLocal, BuilderLigneNoteManagerRemote
{

    @EJB(name = "BuilderLigneNoteDAO")
    protected BuilderLigneNoteDAOLocal dao;

    public BuilderLigneNoteManagerImpl() {
    }

    @Override
    public GenericDAO<BuilderLigneNote, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
