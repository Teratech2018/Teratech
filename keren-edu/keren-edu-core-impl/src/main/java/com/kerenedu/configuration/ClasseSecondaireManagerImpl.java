
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "ClasseSecondaireManager")
public class ClasseSecondaireManagerImpl
    extends AbstractGenericManager<ClasseSecondaire, Long>
    implements ClasseSecondaireManagerLocal, ClasseSecondaireManagerRemote
{

    @EJB(name = "ClasseSecondaireDAO")
    protected ClasseSecondaireDAOLocal dao;

    public ClasseSecondaireManagerImpl() {
    }

    @Override
    public GenericDAO<ClasseSecondaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
