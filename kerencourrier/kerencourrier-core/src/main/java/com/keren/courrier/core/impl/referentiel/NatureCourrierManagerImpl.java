
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.NatureCourrierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.NatureCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.NatureCourrierDAOLocal;
import com.keren.courrier.model.referentiel.NatureCourrier;

@TransactionAttribute
@Stateless(mappedName = "NatureCourrierManager")
public class NatureCourrierManagerImpl
    extends AbstractGenericManager<NatureCourrier, Long>
    implements NatureCourrierManagerLocal, NatureCourrierManagerRemote
{

    @EJB(name = "NatureCourrierDAO")
    protected NatureCourrierDAOLocal dao;

    public NatureCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<NatureCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
