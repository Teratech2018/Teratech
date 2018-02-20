
package com.kerenedu.notes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "MatiereNoteManager")
public class MatiereNoteManagerImpl
    extends AbstractGenericManager<MatiereNote, Long>
    implements MatiereNoteManagerLocal, MatiereNoteManagerRemote
{

    @EJB(name = "MatiereNoteDAO")
    protected MatiereNoteDAOLocal dao;

    public MatiereNoteManagerImpl() {
    }

    @Override
    public GenericDAO<MatiereNote, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
