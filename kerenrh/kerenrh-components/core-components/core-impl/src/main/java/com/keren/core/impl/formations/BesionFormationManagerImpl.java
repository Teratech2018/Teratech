
package com.keren.core.impl.formations;

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
import com.keren.core.ifaces.formations.BesionFormationManagerLocal;
import com.keren.core.ifaces.formations.BesionFormationManagerRemote;
import com.keren.dao.ifaces.formations.BesionFormationDAOLocal;
import com.keren.dao.ifaces.formations.DemandeFormationDAOLocal;
import com.keren.model.formations.BesionFormation;
import com.keren.model.formations.DemandeFormation;
import com.keren.model.formations.GenererBesionFormation;
import com.keren.model.formations.LigneBesionFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BesionFormationManager")
public class BesionFormationManagerImpl
    extends AbstractGenericManager<BesionFormation, Long>
    implements BesionFormationManagerLocal, BesionFormationManagerRemote
{

    @EJB(name = "BesionFormationDAO")
    protected BesionFormationDAOLocal dao;
    
    @EJB(name = "DemandeFormationDAO")
    protected DemandeFormationDAOLocal demandedao;
    

    public BesionFormationManagerImpl() {
    }

    @Override
    public GenericDAO<BesionFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BesionFormation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
            // TODO Auto-generated method stub
            List<BesionFormation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
            List<BesionFormation> results = new ArrayList<BesionFormation>();
            for(BesionFormation data:datas){
                    results.add(new BesionFormation(data));
            }
            return results;
    }

    @Override
    public BesionFormation find(String propertyName, Long entityID) {
            // TODO Auto-generated method stub
            BesionFormation data =  super.find(propertyName, entityID);
            BesionFormation result = new BesionFormation(data);
            for(LigneBesionFormation ligne:data.getLignes()){
                    result.getLignes().add(new LigneBesionFormation(ligne));
            }
            for(DemandeFormation dmde:data.getDemandes()){
                result.getDemandes().add(new DemandeFormation(dmde));
            }
            return result;
    }

    @Override
    public List<BesionFormation> findAll() {
            // TODO Auto-generated method stub		
            List<BesionFormation> datas = super.findAll();
            List<BesionFormation> results = new ArrayList<BesionFormation>();
            for(BesionFormation data:datas){
                    results.add(new BesionFormation(data));
            }
            return results;
    }

    @Override
    public void processAfterSave(BesionFormation entity) {
        
            // TODO Auto-generated method stub
            entity = dao.findByPrimaryKey("code", entity.getCode());
            
            //Traitement de la DF
            if(entity.getDemandes()!=null){
                
                for(DemandeFormation demande:entity.getDemandes()){

                    if(demande.getState().equalsIgnoreCase("valide")){
                            demande.setBesion(entity);
                            demande.setState("encours");
                            demandedao.update(demande.getId(), demande);
                    }//end if(demande.getState().equalsIgnoreCase("valide")){
                }//end for(DemandeFormation demande:entity.getDemandes()){
            }//end if(entity.getDemandes()!=null){
            super.processAfterSave(entity);
    }

    @Override
    public void processAfterUpdate(BesionFormation entity) {
        
        // TODO Auto-generated method stub

        //Traitement de la DF
        if(entity.getDemandes()!=null){

                for(DemandeFormation demande:entity.getDemandes()){

                        if(demande.getState().equalsIgnoreCase("valide")){
                                demande.setBesion(entity);
                                demande.setState("encours");
                                demandedao.update(demande.getId(), demande);
                        }//end if(demande.getState().equalsIgnoreCase("valide")){
                }//end for(DemandeFormation demande:entity.getDemandes()){
        }//end if(entity.getDemandes()!=null){
        super.processAfterUpdate(entity);
    }

    @Override
    public BesionFormation valide(BesionFormation entity) {
        
        // TODO Auto-generated method stub
        if(entity.getState().equalsIgnoreCase("etabli")){
            
            entity.setState("valide");
            entity = dao.update(entity.getId(), entity);

            //Traitement de la DF
            if(entity.getDemandes()!=null){

                    for(DemandeFormation demande:entity.getDemandes()){
                            demande.setBesion(entity);
                            demande.setState("traite");
                            demandedao.update(demande.getId(), demande);
                    }//end for(DemandeFormation demande:entity.getDemandes()){
            }//end if(entity.getDemandes()!=null){
        }
        
        BesionFormation result = new BesionFormation(entity);
        
        for(LigneBesionFormation ligne:entity.getLignes()){
                result.getLignes().add(new LigneBesionFormation(ligne));
        }
        return result;
    }

    @Override
    public BesionFormation genererBF(GenererBesionFormation entity) {
            // TODO Auto-generated method stub
            return null;
    }
    
    @Override
    public BesionFormation delete(Long id) {

        // TODO Auto-generated method stub    	
        BesionFormation data= super.delete(id);

        return new BesionFormation(data);
    }

}
