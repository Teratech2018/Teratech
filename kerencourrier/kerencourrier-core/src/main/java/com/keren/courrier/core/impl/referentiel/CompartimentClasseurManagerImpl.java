
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.CompartimentClasseurManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.CompartimentClasseurManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.CompartimentClasseurDAOLocal;
import com.keren.courrier.model.referentiel.CompartimentClasseur;

@TransactionAttribute
@Stateless(mappedName = "CompartimentClasseurManager")
public class CompartimentClasseurManagerImpl
    extends AbstractGenericManager<CompartimentClasseur, Long>
    implements CompartimentClasseurManagerLocal, CompartimentClasseurManagerRemote
{

    @EJB(name = "CompartimentClasseurDAO")
    protected CompartimentClasseurDAOLocal dao;

    public CompartimentClasseurManagerImpl() {
    }

    @Override
    public GenericDAO<CompartimentClasseur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
