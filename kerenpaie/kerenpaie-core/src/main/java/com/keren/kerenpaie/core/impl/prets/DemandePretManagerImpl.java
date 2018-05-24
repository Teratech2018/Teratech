
package com.keren.kerenpaie.core.impl.prets;

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
import com.kerem.commons.DateHelper;
import com.keren.kerenpaie.core.ifaces.prets.DemandePretManagerLocal;
import com.keren.kerenpaie.core.ifaces.prets.DemandePretManagerRemote;
import com.keren.kerenpaie.dao.ifaces.prets.DemandePretDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.RemboursementPretDAOLocal;
import com.keren.kerenpaie.model.prets.DemandePret;
import com.keren.kerenpaie.model.prets.RemboursementAvance;
import com.keren.kerenpaie.model.prets.RemboursementPret;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandePretManager")
public class DemandePretManagerImpl
    extends AbstractGenericManager<DemandePret, Long>
    implements DemandePretManagerLocal, DemandePretManagerRemote
{

    @EJB(name = "DemandePretDAO")
    protected DemandePretDAOLocal dao;
    
    @EJB(name = "RemboursementPretDAO")
    protected RemboursementPretDAOLocal remdao;

    public DemandePretManagerImpl() {
    }

    @Override
    public GenericDAO<DemandePret, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public DemandePret delete(Long id) {

        // TODO Auto-generated method stub
        DemandePret  data = super.delete(id);
        return new DemandePret(data);
    }

    @Override
    public List<DemandePret> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {

        // TODO Auto-generated method stub
        List<DemandePret> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<DemandePret> result = new ArrayList<DemandePret>();

        for(DemandePret data:datas){
                result.add(new DemandePret(data));
        }

        return result;
    }

    @Override
    public DemandePret find(String propertyName, Long entityID) {
            // TODO Auto-generated method stub
            DemandePret data = super.find(propertyName, entityID);
            DemandePret result = new DemandePret(data);
            for(RemboursementPret pret:data.getRemboursements()){
                    result.getRemboursements().add(new RemboursementPret(pret));
            }
            return result;
    }

    @Override
    public List<DemandePret> findAll() {

        // TODO Auto-generated method stub
        List<DemandePret> datas = super.findAll();
        List<DemandePret> result = new ArrayList<DemandePret>();

        for(DemandePret data:datas){
                result.add(new DemandePret(data));
        }

        return result;
    }

    @Override
    public DemandePret generereglements(DemandePret entity) {
        
        // TODO Auto-generated method stub
        int duree = entity.getDuree();
        
        if(entity.getTypepret() == null){
            System.out.println(" ====== >>> TESSS 01");
        }
        
        if(entity.getTypepret().getGelee() == null){
            System.out.println(" ====== >>> TESSS 02");
        }
        
        if(entity.getTypepret().getGelee()){
            duree = entity.getTypepret().getDuree();
        }

        Long traite = (long) (entity.getMontantpro()/duree);
        Double total = 0.0;
        List<RemboursementPret> remboursements = new ArrayList<RemboursementPret>();

        for(int i=0;i<duree;i++){

            RemboursementPret rem = new RemboursementPret();
            rem.setDemande(entity);rem.setActif(true);
            rem.setPret(entity.getTypepret());
            rem.setSociete(entity.getEmploye().getStructure());
            rem.setDate(DateHelper.nextMonth(entity.getDrembour(), i));

            if(i==entity.getDuree()){
                    rem.setMontant(entity.getMontantpro()-total);
            }else{
                    rem.setMontant((double)traite);
                    total +=traite;
            }//end if(i==entity.getDuree())

            remdao.save(rem);
        }//end for(int i=1;i<entity.getDuree();i++){

        //Chargement de l'entity
        return find("id", entity.getId());
        
    }

    @Override
    public DemandePret confirme(DemandePret entity) {

        // TODO Auto-generated method stub
        entity.setState("confirme");
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public DemandePret annule(DemandePret entity) {

        // TODO Auto-generated method stub
        entity.setState("annule");
        dao.update(entity.getId(), entity);
        return entity;
    }

}
