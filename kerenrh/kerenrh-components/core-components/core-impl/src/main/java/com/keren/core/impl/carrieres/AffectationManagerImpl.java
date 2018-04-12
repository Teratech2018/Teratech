
package com.keren.core.impl.carrieres;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.carrieres.AffectationManagerLocal;
import com.keren.core.ifaces.carrieres.AffectationManagerRemote;
import com.keren.dao.ifaces.carrieres.AffectationDAOLocal;
import com.keren.model.carrieres.Affectation;

@TransactionAttribute
@Stateless(mappedName = "AffectationManager")
public class AffectationManagerImpl
    extends AbstractGenericManager<Affectation, Long>
    implements AffectationManagerLocal, AffectationManagerRemote
{

    @EJB(name = "AffectationDAO")
    protected AffectationDAOLocal dao;

    public AffectationManagerImpl() {
    }

    @Override
    public GenericDAO<Affectation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
