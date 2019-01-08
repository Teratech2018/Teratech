
package com.teratech.vente.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.vente.dao.ifaces.comptabilite.ExerciceComptableDAOLocal;
import com.teratech.vente.dao.ifaces.comptabilite.ExerciceComptableDAORemote;
import com.teratech.vente.model.comptabilite.ExerciceComptable;

@Stateless(mappedName = "ExerciceComptableDAO")
public class ExerciceComptableDAOImpl
    extends AbstractGenericDAO<ExerciceComptable, Long>
    implements ExerciceComptableDAOLocal, ExerciceComptableDAORemote
{

    @PersistenceContext(unitName = "teratechvente")
    protected EntityManager em;

    public ExerciceComptableDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ExerciceComptable> getManagedEntityClass() {
        return (ExerciceComptable.class);
    }

}
