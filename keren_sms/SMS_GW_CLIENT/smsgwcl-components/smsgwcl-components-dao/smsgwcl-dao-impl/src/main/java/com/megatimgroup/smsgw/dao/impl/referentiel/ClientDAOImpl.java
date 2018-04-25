
package com.megatimgroup.smsgw.dao.impl.referentiel;

import javax.persistence.EntityManager;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatim.common.annotations.PersistenceManager;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ClientDAO;
import com.megatimgroup.smsgw.model.referentiel.Client;


/**
 * Classe d'implementation de la DAO
 * @since Mon Oct 23 15:06:47 WAT 2017
 * 
 */
public class ClientDAOImpl
    extends AbstractGenericDAO<Client, Long>
    implements ClientDAO
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @PersistenceManager(unitName = "gepac")
    protected EntityManager em;

    public ClientDAOImpl() {
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
    public Class<Client> getManagedEntityClass() {
        return (Client.class);
    }

}
