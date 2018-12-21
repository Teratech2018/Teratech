
package com.megatimgroup.dao.impl.archivage;

import javax.persistence.EntityManager;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.dao.ifaces.archivage.ArchiveOperationDAO;
import com.megatimgroup.model.archivage.ArchiveOperation;


/**
 * Classe d'implementation de la DAO
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public class ArchiveOperationDAOImpl
    extends AbstractGenericDAO<ArchiveOperation, String>
    implements ArchiveOperationDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "ebay")
    protected EntityManager em;

    public ArchiveOperationDAOImpl() {
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
    public Class<ArchiveOperation> getManagedEntityClass() {
        return (ArchiveOperation.class);
    }

	

}
