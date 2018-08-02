
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.TraitementCourrierManagerLocal;
import com.keren.courrier.core.ifaces.courrier.TraitementCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierDepartDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.CourrierDepart;
import com.keren.courrier.model.courrier.CourrierInterne;
import com.keren.courrier.model.courrier.TraitementCourrier;

@TransactionAttribute
@Stateless(mappedName = "TraitementCourrierManager")
public class TraitementCourrierManagerImpl
    extends AbstractGenericManager<TraitementCourrier, Long>
    implements TraitementCourrierManagerLocal, TraitementCourrierManagerRemote
{

    @EJB(name = "TraitementCourrierDAO")
    protected TraitementCourrierDAOLocal dao;
        
    @EJB(name = "CourrierDAO")
    protected CourrierDAOLocal courrierdao;
    
    @EJB(name = "CourrierDepartDAO")
    protected CourrierDepartDAOLocal departdao;
    
    @EJB(name = "CourrierInterneDAO")
    protected CourrierInterneDAOLocal internedao;

    public TraitementCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<TraitementCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Courrier traiterCourrier(Courrier courrier) {
        //To change body of generated methods, choose Tools | Templates.
        //Creation du traitement
//        Date today = new Date();
//        Long key = today.getTime();
//        TraitementCourrier traitement = new TraitementCourrier(key, courrier.getService(), courrier);
//        dao.save(traitement);
//        //Creation des instance du courrier
//        traitement = dao.findByPrimaryKey("code", key);
//        //Cas du responsable
//        InstanceCourrier _instance = new InstanceCourrier(courrier.getService().getResponsable(), courrier.getSource(), traitement, "2");
//        instancedao.save(_instance);
//        //Cas des autres interveants
//        for(LigneDiffusion entity : courrier.getDiffusions()){
//             _instance = new InstanceCourrier(entity.getUser(), courrier.getSource(), traitement, "0");
//             if(entity.getRole()!=null&&entity.getRole().trim().equalsIgnoreCase("1")){
//                 _instance.setActivite("1");
//             }//end if(entity.getRole()!=null&&entity.getRole().trim().equalsIgnoreCase("1")){
//             instancedao.save(_instance);
//        }//end for(LigneDiffusion entity : courrier.getDiffusions()){
//        courrier.setState("valide");
//        courrier = courrierdao.update(courrier.getId(), courrier);
        return courrier;
    }

    @Override
    public CourrierDepart traiterCourrier(CourrierDepart courrier) {
        //To change body of generated methods, choose Tools | Templates.
         //Creation du traitement
//        Date today = new Date();
//        Long key = today.getTime();
//        TraitementCourrier traitement = new TraitementCourrier(key, courrier.getService(), courrier);
//        dao.save(traitement);
//        //Creation des instance du courrier
//        traitement = dao.findByPrimaryKey("code", key);
//        //Cas du responsable
//        InstanceCourrier _instance = new InstanceCourrier(courrier.getService().getResponsable(), courrier.getSource(), traitement, "2");
//        instancedao.save(_instance);
//        //Cas des autres interveants
//        for(LigneDiffusion entity : courrier.getDiffusions()){
//             _instance = new InstanceCourrier(entity.getUser(), courrier.getSource(), traitement, "0");
//             if(entity.getRole()!=null&&entity.getRole().trim().equalsIgnoreCase("1")){
//                 _instance.setActivite("1");
//             }//end if(entity.getRole()!=null&&entity.getRole().trim().equalsIgnoreCase("1")){
//             instancedao.save(_instance);
//        }//end for(LigneDiffusion entity : courrier.getDiffusions()){
//        courrier.setState("valide");
//        courrier = departdao.update(courrier.getId(), courrier);
        return courrier;
    }

    @Override
    public CourrierInterne traiterCourrier(CourrierInterne courrier) {
        //To change body of generated methods, choose Tools | Templates.
         //Creation du traitement
//        Date today = new Date();
//        Long key = today.getTime();
//        TraitementCourrier traitement = new TraitementCourrier(key, courrier.getService(), courrier);
//        dao.save(traitement);
//        //Creation des instance du courrier
//        traitement = dao.findByPrimaryKey("code", key);
//        //Cas du responsable
//        InstanceCourrier _instance = new InstanceCourrier(courrier.getService().getResponsable(), courrier.getSource(), traitement, "2");
//        instancedao.save(_instance);
//        //Cas des autres interveants
//        for(LigneDiffusion entity : courrier.getDiffusions()){
//             _instance = new InstanceCourrier(entity.getUser(), courrier.getSource(), traitement, "0");
//             if(entity.getRole()!=null&&entity.getRole().trim().equalsIgnoreCase("1")){
//                 _instance.setActivite("1");
//             }//end if(entity.getRole()!=null&&entity.getRole().trim().equalsIgnoreCase("1")){
//             instancedao.save(_instance);
//        }//end for(LigneDiffusion entity : courrier.getDiffusions()){
//        courrier.setState("valide");
//        courrier = internedao.update(courrier.getId(), courrier);
        return courrier;
    }
    
  
}
