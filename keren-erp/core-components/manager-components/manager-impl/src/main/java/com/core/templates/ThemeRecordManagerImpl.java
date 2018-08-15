
package com.core.templates;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.menus.MenuModule;
import java.util.List;

@TransactionAttribute
@Stateless(mappedName = "ThemeRecordManager")
public class ThemeRecordManagerImpl
    extends AbstractGenericManager<ThemeRecord, Long>
    implements ThemeRecordManagerLocal, ThemeRecordManagerRemote
{

    @EJB(name = "ThemeRecordDAO")
    protected ThemeRecordDAOLocal dao;

    public ThemeRecordManagerImpl() {
    }

    @Override
    public GenericDAO<ThemeRecord, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public ThemeRecord getApplicationTheme() {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        List<ThemeRecord> themes = dao.filter(container.getPredicats(), null, null, 0, -1);
        if(themes!=null&&!themes.isEmpty()){
            ThemeRecord result = new  ThemeRecord(themes.get(0));
            result.setModule(new MenuModule(themes.get(0).getModule()));
            return result;
        }
        return null;
    }

}
