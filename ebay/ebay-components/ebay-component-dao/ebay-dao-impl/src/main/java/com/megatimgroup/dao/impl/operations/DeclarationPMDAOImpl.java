
package com.megatimgroup.dao.impl.operations;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.operations.DeclarationPMDAO;
import com.megatimgroup.model.operations.DeclarationPM;


/**
 * Classe d'implementation de la DAO

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class DeclarationPMDAOImpl
    extends AbstractGenericDAO<DeclarationPM, String>
    implements DeclarationPMDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public DeclarationPMDAOImpl() {
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * Methode permettant de retourner la classe de l'entite
     * 
     */
    @Override
    public Class<DeclarationPM> getManagedEntityClass() {
        return (DeclarationPM.class);
    }



}
