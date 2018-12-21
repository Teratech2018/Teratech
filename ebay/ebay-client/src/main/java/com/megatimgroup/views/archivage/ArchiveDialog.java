
package com.megatimgroup.views.archivage;

import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.clients.AbstractEditTemplateDialog;
import com.megatim.common.clients.Messages;
import com.megatim.common.clients.Notification;
import com.megatim.common.clients.NotificationType;
import com.megatim.common.clients.Succes;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.PrincipalFrame;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.common.utilities.TypeOperation;
import com.megatimgroup.ebaytools.client.EbayUtilities;
import com.megatimgroup.model.archivage.ArchiveOperation;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.parametres.Mois;
import com.megatimgroup.views.helper.DateGeneration;
import com.megatimgroup.views.helper.ManagerHelper;


/**
 * Boite de dialogue d'edition ChampDialog
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ArchiveDialog
    extends AbstractEditTemplateDialog<ArchiveOperation, String>
{

    private MessagesBundle bundle;
    private ResourcesBundle resourcesbundle;
    private static Date dateDebut;
    private static Date dateFin;    
    private static String lMois ="";
    private static List<ArchiveOperation> currentlistArchiveOperation = new ArrayList<ArchiveOperation>();
    private static List<DeclarationPP> currentlistpp = new ArrayList<DeclarationPP>();
    private static List<DeclarationPM> currentlistpm = new ArrayList<DeclarationPM>();
    private static List<DeclarationFinanciere> currentlistof = new ArrayList<DeclarationFinanciere>();

    
    /**
     * Constructeur par defaut
     * 
     */
    public ArchiveDialog() {
        super();
        setSize(550, 410);
        this.setResizable(false);
        this.btsave.setText("Archiver");
    }

    /**
     * Constructeur avec parametres
     * 
     * @param parent
     */
    public ArchiveDialog(Frame parent) {
         super(parent);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param title
     * @param parent
     */
    public ArchiveDialog(Frame parent, String title) {
         super(parent , title);
        interne = false ;
    }

    /**
     * Constructeur  avec parametres
     * 
     * @param typeOperation
     * @param parent
     * @param modal
     */
    public ArchiveDialog(JFrame parent, Boolean modal, TypeOperation typeOperation) {
         super(parent , modal ,typeOperation );
        interne = false ;
        
    }

    /**
     * Methode permettant de retourner la cle primaire
     * 
     * @param object
     * @return
     *     java.lang.Long
     */
    @Override
    public String getPrimaryKey(ArchiveOperation object) {
        return object.getIdOperation().toString() ;
    }

    /**
     * Methode permettant de retourner nom de l'action
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getActionName() {
         return null ; 
    }

    /**
     * Methode permettant de retourner les parametres pour le reporting
     * 
     * @return
     *     java.util.Map
     */
    @Override
    public Map getReportParameters() {
         return null ; 
    }

    /**
     * Methode permettant de retourner le nom du fichier Jasper
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getJasperFileName() {
         return null ; 
    }

    /**
     * Methode permettant de retourner le titre de la fenetre
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowTitle() {
        return (MessagesBundle.getMessage("Archive.edit").toUpperCase());
    }

    /**
     * Methode permettant de retourner l'icone de la fenetre
     * 
     * @return
     *     javax.swing.ImageIcon
     */
    @Override
    public ImageIcon getImage() {
        try{
        ImageIcon icon = null;
        icon = new ImageIcon(getClass().getResource(ResourcesBundle.getResource("champ.edit.image")));
        return icon;
        }catch(Exception ex){;}
        return null;
    }

    /**
     * Methode permettant de retourner le panel des champs
     * 
     * @return
     *     javax.swing.JPanel
     */
    @Override
    public JPanel getFiledsPanel() {
        if ((middlePanel==null)) {
            middlePanel = new ArchiveEditPanel() ;
          //  ((ArchiveEditPanel)middlePanel).setContainer(this);
        }
        return (middlePanel);
    }

    /**
     * Methode permettant de retourner l'instance de la fenetre principale
     * 
     * @return
     *     javax.swing.JFrame
     */
    @Override
    public JFrame getApplicationFrame() {
        return com.megatimgroup.views.principal.PrincipalScreen.FRAME ;
    }

    /**
     * Methode permettant de retourner nom complet de la classe
     * 
     * @return
     *     java.lang.String
     */
    @Override
    public String getWindowClassName() {
         return "com.megatimgroup.views.operations.ChampIFrame" ;
    }

    @Override
    protected boolean beforeSave() {
        try {
        	this.setIntervalleDateGeneration();        	// set date debut and date fin
        	
            //Reinitialisation
        	 GenericManager manager = ManagerHelper.getManager2(DeclarationFinanciere.class);
             //Chargement de la liste des données de la période
        	 RestrictionsContainer containner = RestrictionsContainer.newInstance() ;
 	    	 containner.addGe("dateOperation",dateDebut);
 	    	 containner.addLe("dateOperation",dateFin); 
             List<DeclarationFinanciere> datas = manager.filter(containner.getPredicats(), null, null, 0, -1);
             if(datas==null||datas.size()==0){
            	 Messages.Messages(PrincipalFrame.principalScreen, true, NotificationType.ERROR, "Aucunes données Trouvées", "Aucunes données Trouvées", "");
                 return interne ;
             }
             DeclarationPM pm = new DeclarationPM();
        	 DeclarationPP pp = new DeclarationPP();
             // charger le statut des opération trouvé
             for(DeclarationFinanciere op :datas){
            	 currentObject= new ArchiveOperation();
            	  pm = new DeclarationPM();
            	  pp = new DeclarationPP();
            	 
            	//TODO
            	 
            	
            	 // rechercher l'agent economique
            	 RestrictionsContainer container = RestrictionsContainer.newInstance();
                 container.addEq("reference", op.getReference());
                 List<DeclarationPM> resultatsPM = ManagerHelper.getManager2(DeclarationPM.class).filter(container.getPredicats(), null, null, 0, -1);
                 
       
                 if(resultatsPM==null||resultatsPM.size()==0){
                     System.out.println("ArchiveDialog.beforeSave() valeur "+resultatsPM.size());
                 List<DeclarationPP> resultatsPP = ManagerHelper.getManager2(DeclarationPP.class).filter(container.getPredicats(), null, null, 0, -1);
                 pp=resultatsPP.get(0);
                 currentlistpp.add(pp);
                 
                 }else{
                     System.out.println("ArchiveDialog.beforeSave() valeur2589653 "+resultatsPM.size());
                	 pm=resultatsPM.get(0);
                	 currentlistpm.add(pm);
                 }
                 currentlistof.add(op);
                 	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             		currentObject.setDateDebut(formatter.format(dateDebut));
         			currentObject.setDateFin(formatter.format(dateFin));
         			currentObject.setlMois(lMois);
         			currentObject.setPP(pp);
         			currentObject.setPM(pm);
         			currentObject.setOF(op);
         			currentlistArchiveOperation.add(currentObject);
         		}

 	    	 
 	    	
             
            return super.beforeSave();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ArchiveDialog.class.getName()).log(Level.SEVERE, null, ex);
             return !super.beforeSave();
        }  
    }
    
    

    @Override
    public void save() {
        try {
            
            collecteCurrentObjectData();
            beforeSave(); 
            	for(ArchiveOperation arch : currentlistArchiveOperation){
            	ManagerHelper.getManager2(ArchiveOperation.class).save(arch);
            	}
            afterSave();
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArchiveDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
        	Notification.getNotificationDialog(getApplicationFrame(), true, NotificationType.ERROR, "Erreur pendant  le traitement\nVeuillez consulter les détails", ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public boolean afterSave() {
        try {
            //Reinitialisation
        	 GenericManager manager = ManagerHelper.getManager2(DeclarationFinanciere.class);
             //Chargement de la liste des données de la période
        	 RestrictionsContainer containner = RestrictionsContainer.newInstance() ;
 	    	 containner.addGe("dateOperation",dateDebut);
 	    	 containner.addLe("dateOperation",dateFin); 
             List<DeclarationFinanciere> datas = manager.filter(containner.getPredicats(), null, null, 0, -1);
                       // charger le statut des opération trouvé

        	 DeclarationPM pm = new DeclarationPM();
        	 DeclarationPP pp = new DeclarationPP();
             for(DeclarationFinanciere op :datas){
            	//TODO
            	 pm = new DeclarationPM();
            	  pp = new DeclarationPP();
            	 // rechercher l'agent economique
            	 RestrictionsContainer container = RestrictionsContainer.newInstance();
                 container.addEq("reference", op.getReference());
                 List<DeclarationPM> resultatsPM = ManagerHelper.getManager2(DeclarationPM.class).filter(container.getPredicats(), null, null, 0, -1);
                 if(resultatsPM==null||resultatsPM.size()==0){
                 List<DeclarationPP> resultatsPP = ManagerHelper.getManager2(DeclarationPP.class).filter(container.getPredicats(), null, null, 0, -1);
                 pp=resultatsPP.get(0);
                 manager.delete(op.getId());
                 ManagerHelper.getManager2(DeclarationPP.class).delete(pp.getReference());
                 }else{
                	 pm=resultatsPM.get(0);
                	 manager.delete(op.getId());
                	 ManagerHelper.getManager2(DeclarationPM.class).delete(pm.getReference());
                 }
              
                 this.dispose();
                 Succes.getSuccessDialog(PrincipalFrame.principalScreen, true, NotificationType.SUCCES, MessagesBundle.getMessage("ebay.archive.ok"));
                 this.dispose();
             }
             
            return super.afterSave();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ArchiveDialog.class.getName()).log(Level.SEVERE, null, ex);
             return !super.afterSave();
        }  catch (Exception ex) {
        	ex.printStackTrace();
        	Notification.getNotificationDialog(getApplicationFrame(), true, NotificationType.ERROR, "Erreur pendant  le traitement\nVeuillez consulter les détails", ex.getMessage());
        	return !super.afterSave();
        }
		
    }
    

    /**
     * 
     * @param errors 
     */
//    public static void setErrors(List<ValidateError> errors) {
//        BalanceDialog.errors = errors;
//    }
    
    @Override
    public ImageIcon getIconePage() {
        ImageIcon icon = EbayUtilities.getIcone();
        return icon;
    }
    
    private void setIntervalleDateGeneration(){
    	 ArchiveEditPanel pan = (ArchiveEditPanel) middlePanel;
    	 if(pan.getMoisGeneration().getSelectedItem()!=null){    		 
    		 Mois m = (Mois) pan.getMoisGeneration().getSelectedItem();

             Calendar cal = Calendar.getInstance();
             cal.setTime(new Date());
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             dateDebut =DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateDebut");
             dateFin=DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateFin");
             lMois=m.getVal();
//             pan.getDebut().setDate(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateDebut"));
//             pan.getFin().setDate(DateGeneration.getDate(m.getValue(),cal.get(Calendar.YEAR)).get("DateFin"));
    		 
    	 }
    }
  

}
