
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.KerenExecption;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.ReponseFournisseurManagerLocal;
import com.teratech.achat.core.ifaces.operations.ReponseFournisseurManagerRemote;
import com.teratech.achat.dao.ifaces.operations.ReponseFournisseurDAOLocal;
import com.teratech.achat.model.comptabilite.Taxe;
import com.teratech.achat.model.operations.LigneReponseDP;
import com.teratech.achat.model.operations.ReponseFournisseur;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ReponseFournisseurManager")
public class ReponseFournisseurManagerImpl
    extends AbstractGenericManager<ReponseFournisseur, Long>
    implements ReponseFournisseurManagerLocal, ReponseFournisseurManagerRemote
{

    @EJB(name = "ReponseFournisseurDAO")
    protected ReponseFournisseurDAOLocal dao;

    public ReponseFournisseurManagerImpl() {
    }

    @Override
    public GenericDAO<ReponseFournisseur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReponseFournisseur> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ReponseFournisseur> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<ReponseFournisseur> results = new ArrayList<ReponseFournisseur>();
        for(ReponseFournisseur data:datas){
            results.add(new ReponseFournisseur(data));
        }
        return  results;//To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public List<ReponseFournisseur> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReponseFournisseur find(String propertyName, Long entityID) {
        ReponseFournisseur entity = super.find(propertyName, entityID); 
        ReponseFournisseur data = new ReponseFournisseur(entity);
        for(LigneReponseDP ligne:entity.getLignes()){
            LigneReponseDP lign = new LigneReponseDP(ligne);
            for(Taxe taxe : ligne.getTaxes()){
                lign.getTaxes().add(new Taxe(taxe));
            }//end for(Taxe taxe : ligne.getTaxes()){
            data.getLignes().add(lign);
        }//end for(LigneReponseDP ligne:entity.getLignes()){
        
        return data;
    }

    @Override
    public ReponseFournisseur delete(Long id) {
        ReponseFournisseur data= super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new ReponseFournisseur(data);
    }

    @Override
    public void processBeforeUpdate(ReponseFournisseur entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Reference est obligatoire");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Le champ Fournisseur est obligatoire");
        }else if(entity.getDreponse()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir les Articles concernés ");
        }
        double totalht = 0.0;
        double taxes = 0.0;
        double totalttc = 0.0;
        for(LigneReponseDP ligne:entity.getLignes()){
            double remise = ligne.getRemise()!=null ? ligne.getRemise():0.0;
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite()*(1-remise/100));
            totalht+=ligne.getTotalht();
            if(ligne.getTaxes()!=null){
                for(Taxe taxe:ligne.getTaxes()){
                    taxes += ligne.getTotalht()*taxe.getMontant()/100;
                }//end for(Taxe taxe:ligne.getTaxes()){
            }//end if(ligne.getTaxes()!=null){
        }//end for(LigneReponseDP ligne:entity.getLignes()){
        totalttc = totalht+taxes;
        entity.setTaxes(taxes);entity.setTotalht(totalht);entity.setTotalttc(totalttc);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(ReponseFournisseur entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Reference est obligatoire");
        }else if(entity.getFournisseur()==null){
            throw new KerenExecption("Le champ Fournisseur est obligatoire");
        }else if(entity.getDreponse()==null){
            throw new KerenExecption("Le champ Date est obligatoire");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir les Articles concernés ");
        }
        double totalht = 0.0;
        double taxes = 0.0;
        double totalttc = 0.0;
        for(LigneReponseDP ligne:entity.getLignes()){
            ligne.setId(-1L);
            double remise = ligne.getRemise()!=null ? ligne.getRemise():0.0;
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite()*(1-remise/100));
            totalht+=ligne.getTotalht();
            if(ligne.getTaxes()!=null){
                for(Taxe taxe:ligne.getTaxes()){
                    taxes += ligne.getTotalht()*taxe.getMontant()/100;
                }//end for(Taxe taxe:ligne.getTaxes()){
            }//end if(ligne.getTaxes()!=null){
        }//end for(LigneReponseDP ligne:entity.getLignes()){
        totalttc = totalht+taxes;
        entity.setTaxes(taxes);entity.setTotalht(totalht);entity.setTotalttc(totalttc);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
}
