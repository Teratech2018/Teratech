
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.personnel.Professeur;

@Stateless(mappedName = "AcompteDAO")
public class AcompteDAOImpl
    extends AbstractGenericDAO<Acompte, Long>
    implements AcompteDAOLocal, AcompteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AcompteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Acompte> getManagedEntityClass() {
        return (Acompte.class);
    }

	@Override
	public double getMontantAcompte(Professeur employe, PeriodePaie periode) {
		 double valuer ;
		  String query ="select sum(montant)  from e_acompte where effet>='"+periode.getDdebut()+"' "
		  			+ "	and effet<='"+periode.getDfin()+"' and empl_id="+employe.getId()+"";
		  System.out.println("AcompteDAOImpl.getMontantAcompte() querry "+query);
		  Double value = (Double) em.createNativeQuery(query).getSingleResult();
		  System.out.println("AcompteDAOImpl.getMontantAcompte() value "+value);
		  if(value==null){
			  valuer=(double)0;
		  }
		  else{
			  valuer=value ;
		  }
		return valuer;
	}

}
