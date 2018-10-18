
package com.kerenedu.personnel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ProfesseurcloneManager")
public class ProfesseurcloneManagerImpl
    extends AbstractGenericManager<Professeurclone, Long>
    implements ProfesseurcloneManagerLocal, ProfesseurcloneManagerRemote
{

    @EJB(name = "ProfesseurcloneDAO")
    protected ProfesseurcloneDAOLocal dao;

    public ProfesseurcloneManagerImpl() {
    }

    @Override
    public GenericDAO<Professeurclone, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
