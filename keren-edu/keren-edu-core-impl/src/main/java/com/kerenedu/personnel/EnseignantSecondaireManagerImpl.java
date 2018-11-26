
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
@Stateless(mappedName = "EnseignantSecondaireManager")
public class EnseignantSecondaireManagerImpl
    extends AbstractGenericManager<EnseignantSecondaire, Long>
    implements EnseignantSecondaireManagerLocal, EnseignantSecondaireManagerRemote
{

    @EJB(name = "EnseignantSecondaireDAO")
    protected EnseignantSecondaireDAOLocal dao;
    

    @EJB(name=" AnneScolaireDAO")
    protected AnneScolaireDAOLocal daoanne;

    public EnseignantSecondaireManagerImpl() {
    }

    @Override
    public GenericDAO<EnseignantSecondaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    public List<EnseignantSecondaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult)
    {
      RestrictionsContainer container = RestrictionsContainer.newInstance();
      container.addEq("discriminant", "ES");
      predicats.addAll(container.getPredicats());
      List<EnseignantSecondaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
      List<EnseignantSecondaire> result = new ArrayList();
      for (EnseignantSecondaire elev : datas) {
        result.add(new EnseignantSecondaire(elev));
      }
      return result;
    }
    

    public EnseignantSecondaire find(String propertyName, Long entityID)
    {
      EnseignantSecondaire annee = (EnseignantSecondaire)super.find(propertyName, entityID);
      EnseignantSecondaire inscrip = new EnseignantSecondaire(annee);
      


      return inscrip;
    }
    

    public List<EnseignantSecondaire> findAll()
    {
      List<EnseignantSecondaire> datas = super.findAll();
      List<EnseignantSecondaire> result = new ArrayList<EnseignantSecondaire>();
      for (EnseignantSecondaire elev : datas) {
        result.add(new EnseignantSecondaire(elev));
      }
      return result;
    }
    


    public EnseignantSecondaire delete(Long id)
    {
      EnseignantSecondaire annee = (EnseignantSecondaire)super.delete(id);
      return new EnseignantSecondaire(annee);
    }
    
    public void processAfterSave(EnseignantSecondaire entity)
    {
      RestrictionsContainer container = RestrictionsContainer.newInstance();
      container.addEq("connected", Boolean.valueOf(true));
      List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
      
      entity.setMatricule(ViewHelperTrtglobal.getMatricule(entity, (AnneScolaire)annee.get(0)));
      super.processAfterSave(entity);
    }
  }


