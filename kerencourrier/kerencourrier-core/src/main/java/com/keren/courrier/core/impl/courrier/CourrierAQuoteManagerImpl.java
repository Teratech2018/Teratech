
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierAQuoteManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierAQuoteManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierAQuoteDAOLocal;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.CourrierAQuote;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.ServiceDiffusion;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.keren.courrier.model.traitement.QuotationActionGele;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierAQuoteManager")
public class CourrierAQuoteManagerImpl
    extends AbstractGenericManager<CourrierAQuote, Long>
    implements CourrierAQuoteManagerLocal, CourrierAQuoteManagerRemote
{

    @EJB(name = "CourrierAQuoteDAO")
    protected CourrierAQuoteDAOLocal dao;

    public CourrierAQuoteManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierAQuote, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
    @Override
    public List<CourrierAQuote> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierAQuote> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierAQuote> results = new ArrayList<CourrierAQuote>();        
        for(CourrierAQuote courrier:datas){
            CourrierAQuote data = new CourrierAQuote(courrier);
            results.add(data);              
        }//end for(CourrierAQuote courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierAQuote> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierAQuote> datas = super.findAll(); 
        List<CourrierAQuote> results = new ArrayList<CourrierAQuote>();        
        for(CourrierAQuote data:datas){
            results.add(new CourrierAQuote(data));
        }
        
        return results;
    }

    @Override
    public CourrierAQuote find(String propertyName, Long entityID) {        
        //initialisaiton
        CourrierAQuote data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierAQuote result = new CourrierAQuote(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        } 
//        for(QuotationActionGele quot:data.getQuotations()){
//            result.getQuotations().add(new QuotationActionGele(quot));
//        }
        return result;
    }

}
