
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.GradeManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.GradeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.GradeDAOLocal;
import com.keren.kerenpaie.model.structures.Grade;

@TransactionAttribute
@Stateless(mappedName = "GradeManager")
public class GradeManagerImpl
    extends AbstractGenericManager<Grade, Long>
    implements GradeManagerLocal, GradeManagerRemote
{

    @EJB(name = "GradeDAO")
    protected GradeDAOLocal dao;

    public GradeManagerImpl() {
    }

    @Override
    public GenericDAO<Grade, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
