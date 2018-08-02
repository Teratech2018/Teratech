
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.ClasseurCourrierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.ClasseurCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.ClasseurCourrierDAOLocal;
import com.keren.courrier.model.referentiel.ClasseurCourrier;
import com.keren.courrier.model.referentiel.CompartimentClasseur;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ClasseurCourrierManager")
public class ClasseurCourrierManagerImpl
    extends AbstractGenericManager<ClasseurCourrier, Long>
    implements ClasseurCourrierManagerLocal, ClasseurCourrierManagerRemote
{

    @EJB(name = "ClasseurCourrierDAO")
    protected ClasseurCourrierDAOLocal dao;

    public ClasseurCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<ClasseurCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<ClasseurCourrier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ClasseurCourrier> datas= super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ClasseurCourrier> results = new ArrayList<ClasseurCourrier>();
        for(ClasseurCourrier data:datas){
            results.add(new ClasseurCourrier(data));
        }
        return results;
    }

    @Override
    public List<ClasseurCourrier> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClasseurCourrier find(String propertyName, Long entityID) {
        ClasseurCourrier classeur =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ClasseurCourrier entity =  new ClasseurCourrier(classeur);
        for(CompartimentClasseur com:classeur.getCompartiments()){
            entity.getCompartiments().add(com);
        }
        return entity;
    }

    @Override
    public ClasseurCourrier delete(Long id) {
        ClasseurCourrier classeur = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new ClasseurCourrier(classeur);
    }
    
    

}
