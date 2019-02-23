
package com.kerenedu.notes;

import java.util.List;

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
			  	value="solde";
				 String query ="update e_bulletin set ownermodule ='"+value+"' ";
				  va = em.createNativeQuery(query).executeUpdate();
	
	        }catch(Exception ex){

	        }
		return va;
	}

	 @Override
	   	public long updateforce2(EdtBulletin prepa) {
	   		 long va = 0  ;
	   		  try{
	   			  String value="scolarite";
	   				 String query2 ="update e_bul set ownermodule ='"+value+"' where CLS_ID= '"+prepa.getClasse().getId()+"' "
	   				 		+ "and examen_id='"+prepa.getSeq().getId()+"'  ";
	   				 System.out.println("NoteDetailDAOImpl.updateforce2() query2 is "+query2);
	   				 va=em.createNativeQuery(query2).executeUpdate();
	   	
	   	        }catch(Exception ex){

	   	        }
	   		return va;
	   	}
	 
	 @Override
	   	public long deleteforce2(List<Bulletin> datas) {
	   		 long va = 0  ;
	   		  try{
	   			  
	   			for(Bulletin bull : datas){
	   				String query2 ="delete from e_bul  where ID= '"+bull.getId()+"'";
	   				String query ="delete from e_bul_lgn  where LGN_BUL_ID='"+bull.getId()+"' ";
	   				em.createNativeQuery(query).executeUpdate();
	   				em.createNativeQuery(query2).executeUpdate();
	   			}
	   				 
	   	
	   	        }catch(Exception ex){

	   	        }
	   		return va;
	   	}


}
