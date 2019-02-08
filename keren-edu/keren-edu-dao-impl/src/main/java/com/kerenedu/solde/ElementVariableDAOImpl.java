
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;

@Stateless(mappedName = "ElementVariableDAO")
public class ElementVariableDAOImpl
    extends AbstractGenericDAO<ElementVariable, Long>
    implements ElementVariableDAOLocal, ElementVariableDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ElementVariableDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ElementVariable> getManagedEntityClass() {
        return (ElementVariable.class);
    }

    

	public  List<ElementVariable> getelementVaraiable(long id) {
		  try{
			  List<ElementVariable> list = new ArrayList<ElementVariable>();
			  String query = "SELECT * FROM e_eltvar e WHERE e.elvap_id ="+id;
			 TypedQuery<ElementVariable> queryexe =  em.createQuery(query, ElementVariable.class);
			  list=  (List<ElementVariable>) queryexe.getResultList();
	            return list;
	        }catch(Exception ex){
	            return null;
	        }
	}
	
	
	

	public  void delete(long id) {
		  try{
			  List<ElementVariable> list = new ArrayList<ElementVariable>();
			  String query = "DELETE  FROM e_eltvar   WHERE elvap_id ="+id;
			  em.createNativeQuery(query).executeUpdate();
	        }catch(Exception ex){
	        }
	}
	
	
}
