
package com.keren.kerenpaie.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieCloseManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.PeriodePaieCloseManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieCloseDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieClose;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieCloseManager")
public class PeriodePaieCloseManagerImpl
    extends AbstractGenericManager<PeriodePaieClose, Long>
    implements PeriodePaieCloseManagerLocal, PeriodePaieCloseManagerRemote
{

    @EJB(name = "PeriodePaieCloseDAO")
    protected PeriodePaieCloseDAOLocal dao;

    public PeriodePaieCloseManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaieClose, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
/*
    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal bulletinpaiedao;

    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal elementvariabledao;


    @Override
    public List<PeriodePaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {

        ////On applique les criteres
        ////RestrictionsContainer container = RestrictionsContainer.newInstance();
        ////container.addEq("state", "valide");
        ////predicats.addAll(container.getPredicats());

        //On initialise les les objets
        List<PeriodePaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<PeriodePaie> results = new ArrayList<PeriodePaie>();

        for(PeriodePaie data:datas){
            results.add(new PeriodePaie(data));
        }
        return results;
    }

    @Override
    public List<PeriodePaie> findAll() {
        //List<AffectationCandidat> datas = super.findByUniqueProperty("state", "valide", null);
        List<PeriodePaie> datas = super.findAll();
        List<PeriodePaie> results = new ArrayList<PeriodePaie>();

        for(PeriodePaie data:datas){
            results.add(new PeriodePaie(data));
        }
        return results;
    }

    @Override
    public PeriodePaie find(String propertyName, Long entityID) {
        PeriodePaie data = super.find(propertyName, entityID);
        PeriodePaie result = new PeriodePaie(data);

        for(BulletinPaie aas:data.getSalaires()){
            result.getSalaires().add(new BulletinPaie(aas));
        }

        for(ElementVariable aas:data.getVariables()){
            result.getVariables().add(new ElementVariable(aas));
        }


        return result;
    }

    @Override
    public Long count(List<Predicat> predicats) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "valide");
        predicats.addAll(container.getPredicats());
        
        return super.count(predicats);
    }

    @Override
    public PeriodePaie delete(Long id) {
        
        PeriodePaie data = super.find("id", id);
        PeriodePaie result = new PeriodePaie(data);
        
        try{
            
            //on supprime
            super.delete(id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            throw new KerenExecption("Une erreur est survenue : "+ex.getMessage());
        }
        
        return result;
    }

    @Override
    public void processAfterUpdate(PeriodePaie entity) {

         for(BulletinPaie aas:entity.getSalaires()){

            aas.setPeriodePaie(entity);

            if(aas.getId()>0){
                bulletinpaiedao.update(aas.getId(), aas);
            }else {
                bulletinpaiedao.save(aas);
            }
        }

         for(ElementVariable aas:entity.getVariables()){

            aas.setPeriodePaie(entity);

            if(aas.getId()>0){
                elementvariabledao.update(aas.getId(), aas);
            }else {
                elementvariabledao.save(aas);
            }
        }
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(PeriodePaie entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());


        for(BulletinPaie aas:entity.getSalaires()){
            aas.setPeriodePaie(entity);

            if(aas.getId()>0){
                bulletinpaiedao.update(aas.getId(), aas);
            }else {
                bulletinpaiedao.save(aas);
            }
        }

        for(ElementVariable aas:entity.getVariables()){
            aas.setPeriodePaie(entity);

            if(aas.getId()>0){
                elementvariabledao.update(aas.getId(), aas);
            }else {
                elementvariabledao.save(aas);
            }
        }
        super.processAfterSave(entity);
    }

    @Override
    public PeriodePaie valide(PeriodePaie entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }

        PeriodePaie data = dao.update(entity.getId(), entity);


        for(BulletinPaie aas:entity.getSalaires()){
            aas.setPeriodePaie(entity);

            if(aas.getId()>0){
                bulletinpaiedao.update(aas.getId(), aas);
            }else {
                bulletinpaiedao.save(aas);
            }
        }

        for(ElementVariable aas:entity.getVariables()){
            aas.setPeriodePaie(entity);

            if(aas.getId()>0){
                elementvariabledao.update(aas.getId(), aas);
            }else {
                elementvariabledao.save(aas);
            }
        }

        PeriodePaie result = new PeriodePaie(data);

        for(BulletinPaie aas:data.getSalaires()){
            result.getSalaires().add(new BulletinPaie(aas));
        }

        for(ElementVariable aas:data.getVariables()){
            result.getVariables().add(new ElementVariable(aas));
        }

        return result;
    }

    @Override
    public PeriodePaie annule(PeriodePaie entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        PeriodePaie data = dao.update(entity.getId(), entity);
        return new PeriodePaie(data);
    }

*/
