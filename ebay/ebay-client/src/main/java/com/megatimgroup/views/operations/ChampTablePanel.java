
package com.megatimgroup.views.operations;

import javax.swing.JDialog;
import javax.swing.JFrame;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.services.IocContext;
import com.megatim.common.utilities.AbstractTablePanel;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.model.operations.Champ;

public class ChampTablePanel
    extends AbstractTablePanel<Champ>
{

    private IocContext context;

    public ChampTablePanel() {
        super() ; 
         context = new IocContext();
    }

    @Override
    public JDialog getEditDialog(Champ object, GenericManager manager, AbstractTableBaseListModel model, TypeOperation typeOperation, JFrame window)
        throws Exception
    {
        if ((object==null)) {
             object = new Champ();
        }
        com.megatimgroup.views.operations.ChampDialog  dialog = new com.megatimgroup.views.operations.ChampDialog(getApplicationFrame() , true , typeOperation) ;
         dialog.setCurrentObject(object);
         dialog.setManager(manager);
         dialog.setModel(model);
        return (dialog);
    }

    /**
     * /**  **<!---->/
     * 
     */
    @Override
    public GenericManager getManager()
        throws Exception
    {
        return (GenericManager)context.lookup("com.megatimgroup.core.impl.operations.ChampManagerImpl");
    }

    public JFrame getApplicationFrame() {
        return com.megatimgroup.views.principal.PrincipalScreen.FRAME ;
    }

}
