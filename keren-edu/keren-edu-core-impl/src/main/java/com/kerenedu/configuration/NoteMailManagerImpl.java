
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "NoteMailManager")
public class NoteMailManagerImpl
    extends AbstractGenericManager<NoteMail, Long>
    implements NoteMailManagerLocal, NoteMailManagerRemote
{

    @EJB(name = "NoteMailDAO")
    protected NoteMailDAOLocal dao;

    public NoteMailManagerImpl() {
    }

    @Override
    public GenericDAO<NoteMail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<NoteMail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<NoteMail> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<NoteMail> result = new ArrayList<NoteMail>();
   		for(NoteMail elev:datas){
   			result.add(new NoteMail(elev));
   		}
   		return result;
   	}

   	@Override
   	public NoteMail find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		NoteMail elev = super.find(propertyName, entityID);
   		NoteMail inscrip = new NoteMail(elev);
   		for(Eleve serv: elev.getEleveList()){
   			inscrip.getEleveList().add(new Eleve(serv));
   		}
   		return inscrip;
   	}

   	@Override
   	public List<NoteMail> findAll() {
   		// TODO Auto-generated method stub
   		List<NoteMail> datas = super.findAll();
   		List<NoteMail> result = new ArrayList<NoteMail>();
   		for(NoteMail elev:datas){
   			result.add(new NoteMail(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public NoteMail delete(Long id) {
   		// TODO Auto-generated method stub
   		NoteMail elev = super.delete(id);
   		return new NoteMail(elev);
   	}

   	@Override
   	public void processBeforeSave(NoteMail entity) {
   		
   		// 1-recupérer les coordonners du serveur d'envoi
   		
   		//2-recuperer le message et envoyé au destinataire chosi
   		
   		//3- call service Mail and send Message to destinataire
       
   		super.processBeforeSave(entity);
   	}

   	@Override
   	public void processBeforeUpdate(NoteMail entity) {
   	    // verifier si l'étudiant a déjà été inscit 
         /*  NoteMail inscit = dao.getNoteMailEtudiantByAnnee(entity.getEleve(), entity.getAnneScolaire());
           if(inscit!=null){
               RuntimeException excep = new RuntimeException("Eléve déjà Inscrit !!!");
               throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
           }*/
   		super.processBeforeUpdate(entity);
   	}
}
