
package com.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ConfigItemManager")
public class ConfigItemManagerImpl
    extends AbstractGenericManager<ConfigItem, Long>
    implements ConfigItemManagerLocal, ConfigItemManagerRemote
{

    @EJB(name = "ConfigItemDAO")
    protected ConfigItemDAOLocal dao;

    public ConfigItemManagerImpl() {
    }

    @Override
    public GenericDAO<ConfigItem, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        return Long.valueOf(""+getConfigItems().size()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConfigItem> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        return getConfigItems();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConfigItem> findAll() {
        return getConfigItems();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfigItem find(String propertyName, Long entityID) {
        List<ConfigItem> items = getConfigItems();
//        System.out.println(ConfigItemManagerImpl.class+".find(String propertyName, Long entityID) ======================== entityID = "+entityID+" === datas : "+items);
        int index = Integer.valueOf(""+entityID);
        if(index<=0){
           index = 0;
        }//end if(index<=0){
        return items.get(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfigItem delete(Long id) {
        //To change body of generated methods, choose Tools | Templates.
        Properties prop = FileHelper.getConfigurations();
        int index = Integer.valueOf(""+id);
        List<ConfigItem> items = getConfigItems();
        ConfigItem item = null;
        for(ConfigItem ite:items){
            if(ite.getId()==id){
                item = ite;
            }//end if(ite.getCode().trim().equalsIgnoreCase(item.getCode().trim())){
        }
        if(item!=null && !item.isDesabledelete()){
            prop.remove(item.getCode());
        }//end if(item!=null){
        FileHelper.updateConfigurations(prop);
        return item;
    }

    @Override
    public ConfigItem update(Long id, ConfigItem entity) {
        Properties prop = FileHelper.getConfigurations();
        prop.setProperty(entity.getCode(), entity.getValue());
        FileHelper.updateConfigurations(prop);
        return entity; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfigItem save(ConfigItem entity) {
        Properties prop = FileHelper.getConfigurations();
        List<ConfigItem> items = getConfigItems();
        if(entity.getCode()==null || entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Le champ Code est obligatoire");
        }else if(entity.getValue()==null||entity.getValue().trim().isEmpty()){
            throw new KerenExecption("Le champ Value est obligatoire");
        }else if(prop.containsKey(entity.getCode())){
            throw new KerenExecption("La clé "+entity.getCode()+" est déjà utilisée");
        }
        prop.setProperty(entity.getCode(), entity.getValue());
        FileHelper.updateConfigurations(prop);
        entity.setId(items.size()+1L);
        return entity; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    private List<ConfigItem> getConfigItems(){
        List<ConfigItem> items = new ArrayList<ConfigItem>();
        Properties prop = FileHelper.getConfigurations();
        long index = 0 ;
        for(Object key : prop.keySet()){
            index++;
            String cle = (String) key;
            ConfigItem item =new ConfigItem(cle, prop.getProperty(cle));
            item.setCompareid(index);
            item.setId(index);
            items.add(item);
        }//end for(Object key : prop.keySet()){
        return items ;
    }
    
    /**
     * 
     * @param items
     * @return 
     */
    private Properties fromConfigItems(List<ConfigItem> items){
        Properties prop = FileHelper.getConfigurations();
        for(ConfigItem item : items){
            prop.setProperty(item.getCode(), item.getValue());
        }//nd for(ConfigItem item : items){
        return prop;
    }
}
