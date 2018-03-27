
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.NiveauEtudeManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.NiveauEtudeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.NiveauEtudeDAOLocal;
import com.keren.kerenpaie.model.structures.NiveauEtude;

@TransactionAttribute
@Stateless(mappedName = "NiveauEtudeManager")
public class NiveauEtudeManagerImpl
    extends AbstractGenericManager<NiveauEtude, Long>
    implements NiveauEtudeManagerLocal, NiveauEtudeManagerRemote
{

    @EJB(name = "NiveauEtudeDAO")
    protected NiveauEtudeDAOLocal dao;

    public NiveauEtudeManagerImpl() {
    }

    @Override
    public GenericDAO<NiveauEtude, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
