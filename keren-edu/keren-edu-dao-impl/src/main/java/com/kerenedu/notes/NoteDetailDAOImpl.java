
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NoteDetailDAO")
public class NoteDetailDAOImpl
    extends AbstractGenericDAO<NoteDetail, Long>
    implements NoteDetailDAOLocal, NoteDetailDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NoteDetailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NoteDetail> getManagedEntityClass() {
        return (NoteDetail.class);
    }

    
    @Override
	public long updateforce(ImportNoteClasse entity) {
		 long va = 0  ;
		  try{
			 // String value="scolarite";
				 String query ="update e_notedlt e set e.matiere_id=( select matiere_id from e_note_mat m where m.id=e.el_note_id) where classe_id= '"+entity.getClasse().getId()+"'";
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
   				 String query2 ="update e_notedlt set ownermodule ='"+value+"' where classe_id= '"+prepa.getClasse().getId()+"'";
   				// System.out.println("NoteDetailDAOImpl.updateforce2() query2 is "+query2);
   				 va=em.createNativeQuery(query2).executeUpdate();
   	
   	        }catch(Exception ex){

   	        }
   		return va;
   	}
}
