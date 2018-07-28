
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.ClasseDAOLocal;
import com.teratech.gmao.dao.ifaces.base.ClasseDAORemote;
import com.teratech.gmao.model.base.Classe;

@Stateless(mappedName = "ClasseDAO")
public class ClasseDAOImpl
    extends AbstractGenericDAO<Classe, Long>
    implements ClasseDAOLocal, ClasseDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public ClasseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Classe> getManagedEntityClass() {
        return (Classe.class);
    }

}
