
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BulletinDAO")
public class BulletinDAOImpl
    extends AbstractGenericDAO<Bulletin, Long>
    implements BulletinDAOLocal, BulletinDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BulletinDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Bulletin> getManagedEntityClass() {
        return (Bulletin.class);
    }

	@Override
	public long deleteRadBulletin(Bulletin entity) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public long updateforce(String value) {
		 long va = 0  ;
		  try{
			
				 String query ="update e_bulletin set ownermodule ='"+value+"' ";
				  va = em.createNativeQuery(query).executeUpdate();
	
	        }catch(Exception ex){

	        }
		return va;
	}



}
