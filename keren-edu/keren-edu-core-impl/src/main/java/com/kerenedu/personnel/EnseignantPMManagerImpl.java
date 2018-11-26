
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.allerte.ViewHelperTrtglobal;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "EnseignantPMManager")
public class EnseignantPMManagerImpl
    extends AbstractGenericManager<EnseignantPM, Long>
    implements EnseignantPMManagerLocal, EnseignantPMManagerRemote
{

    @EJB(name = "EnseignantPMDAO")
    protected EnseignantPMDAOLocal dao;
    

    @EJB(name=" AnneScolaireDAO")
    protected AnneScolaireDAOLocal daoanne;


    public EnseignantPMManagerImpl() {
    }

    @Override
    public GenericDAO<EnseignantPM, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    public List<EnseignantPM> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult)
    {
      RestrictionsContainer container = RestrictionsContainer.newInstance();
      container.addEq("discriminant", "EPM");
      predicats.addAll(container.getPredicats());
      List<EnseignantPM> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
      List<EnseignantPM> result = new ArrayList();
      for (EnseignantPM elev : datas) {
        result.add(new EnseignantPM(elev));
      }
      return result;
    }
    

    public EnseignantPM find(String propertyName, Long entityID)
    {
      EnseignantPM annee = (EnseignantPM)super.find(propertyName, entityID);
      EnseignantPM inscrip = new EnseignantPM(annee);
      


      return inscrip;
    }
    

    public List<EnseignantPM> findAll()
    {
      List<EnseignantPM> datas = super.findAll();
      List<EnseignantPM> result = new ArrayList();
      for (EnseignantPM elev : datas) {
        result.add(new EnseignantPM(elev));
      }
      return result;
    }
    


    public EnseignantPM delete(Long id)
    {
      EnseignantPM annee = (EnseignantPM)super.delete(id);
      return new EnseignantPM(annee);
    }
    
    public void processAfterSave(EnseignantPM entity)
    {
      RestrictionsContainer container = RestrictionsContainer.newInstance();
      container.addEq("connected", Boolean.valueOf(true));
      List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
      
      entity.setMatricule(ViewHelperTrtglobal.getMatricule(entity, (AnneScolaire)annee.get(0)));
      super.processAfterSave(entity);
    }
  

}
