
package com.megatimgroup.views.principal;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.clients.ActionDetail;
import com.megatim.common.clients.ActionGroup;
import com.megatim.common.clients.OptionPanel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.PrincipalFrame;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.security.ifaces.client.ClientInterfaceSecurity;
import com.megatim.security.principal.UserPrincipal;
import com.megatimgroup.model.archivage.ArchiveOperation;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.model.reporting.BordereauBP;
import com.megatimgroup.views.archivage.ArchiveDialog;
import com.megatimgroup.views.helper.CurrentSessionInformations;
import com.megatimgroup.views.helper.ImportData;
import com.megatimgroup.views.helper.ManagerHelper;
import com.megatimgroup.views.helper.ServicesExecution;
import com.megatimgroup.views.operations.ConsoleDialog;
import com.megatimgroup.views.operations.ConsoleEditPanel;
import com.megatimgroup.views.operations.ReinitialisationDialog;
import com.megatimgroup.views.parametres.SocieteIFrame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;


/**
 * Classe representant la fenetre principale de la l'application
 * 
 */
public class PrincipalScreen
    extends PrincipalFrame
    implements ClientInterfaceSecurity
{
	

    private MessagesBundle var1;
    private ResourcesBundle var2;
    private ResourceBundle bundle;
    private ResourceBundle resourcesbundle;
    public List<ActionGroup> options;
    public Map componentsList;
    public OptionPanel optionsPanel;
    private KeyStroke keyStoke;
    private KeyEvent keyEvent;
    private JMenu fichier;
    private JMenuItem societeActionitem;
    private JMenu structure;
    private JMenu securite;
    private JMenuItem utilisateurActionitem;
    private JMenuItem paysActionitem;
    private JMenuItem villeActionitem;
    private JMenuItem statusresidenceActionitem;
    private JMenuItem nationaliteActionitem;
    private JMenuItem precisionActionitem;
    private JMenuItem qualiteActionitem;
    private JMenuItem titreActionitem;
    private JMenuItem motifActionitem;
    private JMenuItem sensActionitem;
    private JMenuItem typeActionitem;
    private JMenuItem natureclienteleActionitem;
    private JMenuItem naturejuridiqueActionitem;
    private JMenuItem deviseActionitem;
    private JMenuItem sectionActionitem;
    private JMenuItem divisionActionitem;
    private JMenuItem groupeActionitem;
    private JMenuItem classeActionitem;
    private JMenu operation;
    private JMenu physique;
    private JMenu periode;
    private JMenuItem archivageItem;
    private JMenuItem archivageConsulterItem;
    private JMenuItem modeleppActionitem;
    private JMenuItem importppActionitem;
    private JMenuItem declarationppActionitem;
    private JMenu morale;
    private JMenuItem declarationpmActionitem;
    private JMenu financier;
    private JMenuItem declarationfinanciereActionitem;
    private JMenu balanceActionitem;
    private JMenuItem balanceGenActionitem;
    private JMenuItem balanceConsulterActionitem;
    private JMenu etats;
	private static Societe societe= null;

    /**
     * Constructeur par defaut
     * 
     */
    public PrincipalScreen() {
         super() ; 
        bundle = ResourceBundle.getBundle("messages_fr_FR");
        MessagesBundle.setBundle(bundle);
        resourcesbundle = ResourceBundle.getBundle("resources");
        ResourcesBundle.setBundle(resourcesbundle);
         this.setTitle(MessagesBundle.getMessage("Balance des Paiements")) ; 
        options = new ArrayList<ActionGroup>();
        componentsList = new HashMap();
        initComponentsList();
        ActionGroup group;
        ActionDetail element;
        ActionGroup elementgroup;
        group = new ActionGroup();
        group.setName("fichier");
        group.setLabel("          Fichier          ");
        group.setIndependent(false);
        group.setVmenu(true);
        element = new ActionDetail();
        element.setActionName("societeAction");
        element.setViewClass("com.megatimgroup.model.parametres.Societe");
        element.setActionLabel("A propos de votre Societe");
        element.setActionIndex(1);
        element.setSeparator(false);
        group.getActions().add(element);
        options.add(group);
        group = new ActionGroup();
        group.setName("structure");
        group.setLabel("        Referentiels        ");
        group.setIndependent(false);
        group.setVmenu(true);
        element = new ActionDetail();
        element.setActionName("paysAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Pays");
        element.setActionLabel("Pays");
        element.setActionIndex(2);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("villeAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Ville");
        element.setActionLabel("Villes");
        element.setActionIndex(3);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("statusresidenceAction");
        element.setViewClass("com.megatimgroup.model.referentiels.StatusResidence");
        element.setActionLabel("Statut Residence");
        element.setActionIndex(4);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("nationaliteAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Nationalite");
        element.setActionLabel("Nationalites");
        element.setActionIndex(5);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("precisionAction");
        element.setViewClass("com.megatimgroup.model.referentiels.PrecisionDateNaissance");
        element.setActionLabel("Precision date de naissance");
        element.setActionIndex(6);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("qualiteAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Qualite");
        element.setActionLabel("Qualites");
        element.setActionIndex(7);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("titreAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Titre");
        element.setActionLabel("Titres");
        element.setActionIndex(8);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("motifAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Motif");
        element.setActionLabel("Code Motif");
        element.setActionIndex(9);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("sensAction");
        element.setViewClass("com.megatimgroup.model.referentiels.SensOperation");
        element.setActionLabel("Sens Operations");
        element.setActionIndex(10);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("typeAction");
        element.setViewClass("com.megatimgroup.model.referentiels.TypeOperation");
        element.setActionLabel("Type Operations");
        element.setActionIndex(11);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("natureclienteleAction");
        element.setViewClass("com.megatimgroup.model.referentiels.NatureClientele");
        element.setActionLabel("Nature Clientele");
        element.setActionIndex(12);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("naturejuridiqueAction");
        element.setViewClass("com.megatimgroup.model.referentiels.NatureJuridique");
        element.setActionLabel("Nature Juridique");
        element.setActionIndex(13);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("deviseAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Devise");
        element.setActionLabel("Devises");
        element.setActionIndex(14);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("sectionAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Section");
        element.setActionLabel("Sections");
        element.setActionIndex(15);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("divisionAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Division");
        element.setActionLabel("Divisions");
        element.setActionIndex(16);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("groupeAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Groupe");
        element.setActionLabel("Groupes");
        element.setActionIndex(17);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("classeAction");
        element.setViewClass("com.megatimgroup.model.referentiels.Classe");
        element.setActionLabel("Classes");
        element.setActionIndex(18);
        element.setSeparator(false);
        group.getActions().add(element);
        options.add(group);
        group = new ActionGroup();
        group.setName("operation");
        group.setLabel("         Operations         ");
        group.setIndependent(false);
        group.setVmenu(true);
        element = new ActionDetail();
        element.setActionName("balanceAction");
        element.setViewClass("com.megatimgroup.model.operations.DeclarationFinanciere");
        element.setActionLabel("Balances des Paiements");
        element.setActionIndex(28);
        element.setSeparator(false);
        group.getActions().add(element);
        elementgroup = new ActionGroup();
        elementgroup.setName("physique");
        elementgroup.setLabel(" Donnees Personnes Physique ");
        elementgroup.setIndependent(true);
        element = new ActionDetail();
        element.setActionName("modeleppAction");
        element.setViewClass("com.megatimgroup.model.operations.Modele");
        element.setActionLabel("Modeles");
        element.setActionIndex(19);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("importppAction");
        element.setViewClass("com.megatimgroup.model.operations.DeclarationPP");
        element.setActionLabel("Importes");
        element.setActionIndex(20);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("declarationppAction");
        element.setViewClass("com.megatimgroup.model.operations.DeclarationPP");
        element.setActionLabel("Persones Physiques");
        element.setActionIndex(21);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        group.getGroupes().add(elementgroup);
        elementgroup = new ActionGroup();
        elementgroup.setName("morale");
        elementgroup.setLabel("  Donnees Personnes Morale  ");
        elementgroup.setIndependent(true);
        element = new ActionDetail();
        element.setActionName("modelepmAction");
        element.setViewClass("com.megatimgroup.model.operations.Modele");
        element.setActionLabel("Modeles");
        element.setActionIndex(22);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("importpmAction");
        element.setViewClass("com.megatimgroup.model.operations.DeclarationPP");
        element.setActionLabel("Importes");
        element.setActionIndex(23);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("declarationpmAction");
        element.setViewClass("com.megatimgroup.model.operations.DeclarationPM");
        element.setActionLabel("Persones Morales");
        element.setActionIndex(24);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        group.getGroupes().add(elementgroup);
        elementgroup = new ActionGroup();
        elementgroup.setName("financier");
        elementgroup.setLabel("    Donnees Financieres    ");
        elementgroup.setIndependent(true);
        element = new ActionDetail();
        element.setActionName("modeledfAction");
        element.setViewClass("com.megatimgroup.model.operations.Modele");
        element.setActionLabel("Modeles");
        element.setActionIndex(25);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("importdfAction");
        element.setViewClass("com.megatimgroup.model.operations.DeclarationPP");
        element.setActionLabel("Importes");
        element.setActionIndex(26);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("declarationfinanciereAction");
        element.setViewClass("com.megatimgroup.model.operations.DeclarationFinanciere");
        element.setActionLabel("Financieres");
        element.setActionIndex(27);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        group.getGroupes().add(elementgroup);
        options.add(group);
        group = new ActionGroup();
        group.setName("etats");
        group.setLabel("          Editions          ");
        group.setIndependent(false);
        group.setVmenu(true);
        options.add(group);
        super.buildViewComponents();
    }

    /**
     * Methode permettant de construire les options du panel
     * 
     * @return
     *     javax.swing.JPanel
     */
    @Override
    public JPanel buildOptionPanel() {
        optionsPanel = new OptionPanel(options);
        return optionsPanel ; 
    }

    /**
     * Methode permettant de construire la barre des menus
     * 
     * @return
     *     void
     */
    @Override
    public void buildMenuBar() {
        fichier = new JMenu();
        fichier.setText( MessagesBundle.getMessage("Fichier"));
        menubar.add(fichier );
        ((Map)componentsList.get("listeMenus")).put("fichier", fichier);
        societeActionitem = new JMenuItem();
        societeActionitem.setText( MessagesBundle.getMessage("A propos de votre Societe"));
        fichier.add( societeActionitem);
        societeActionitem.setMnemonic('S');
        societeActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , KeyEvent.CTRL_MASK));
        societeActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {societeActionAction(); } });
        securite = new JMenu();
        securite.setText(MessagesBundle.getMessage("Parametres de securite"));
        fichier.add(securite);
        ((Map) componentsList.get("listeMenus")).put("securite", securite);
        utilisateurActionitem = new JMenuItem();
        ((Map) componentsList.get("listeMenuItems")).put("utilisateurAction", utilisateurActionitem);
        utilisateurActionitem.setText(MessagesBundle.getMessage("Gestion des Utilisateurs"));
        securite.add(utilisateurActionitem);
        utilisateurActionitem.setMnemonic('U');
        utilisateurActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
        utilisateurActionitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilisateurActionAction();
            }
        });
        structure = new JMenu();
        structure.setText( MessagesBundle.getMessage("Referentiels"));
        menubar.add(structure );
        ((Map)componentsList.get("listeMenus")).put("structure", structure);
        paysActionitem = new JMenuItem();
        paysActionitem.setText( MessagesBundle.getMessage("Pays"));
        structure.add( paysActionitem);
        paysActionitem.setMnemonic('C');
        paysActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , KeyEvent.CTRL_MASK));
        paysActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {paysActionAction(); } });
        villeActionitem = new JMenuItem();
        villeActionitem.setText( MessagesBundle.getMessage("Villes"));
        structure.add( villeActionitem);
        villeActionitem.setMnemonic('L');
        villeActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L , KeyEvent.CTRL_MASK));
        villeActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {villeActionAction(); } });
        structure.addSeparator();
        statusresidenceActionitem = new JMenuItem();
        statusresidenceActionitem.setText( MessagesBundle.getMessage("Statut Residence"));
        structure.add( statusresidenceActionitem);
        statusresidenceActionitem.setMnemonic('B');
        statusresidenceActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B , KeyEvent.CTRL_MASK));
        statusresidenceActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {statusresidenceActionAction(); } });
        nationaliteActionitem = new JMenuItem();
        nationaliteActionitem.setText( MessagesBundle.getMessage("Nationalites"));
        structure.add( nationaliteActionitem);
        nationaliteActionitem.setMnemonic('V');
        nationaliteActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        nationaliteActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {nationaliteActionAction(); } });
        precisionActionitem = new JMenuItem();
        precisionActionitem.setText( MessagesBundle.getMessage("Precision date de naissance"));
        structure.add( precisionActionitem);
        precisionActionitem.setMnemonic('V');
        precisionActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        precisionActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {precisionActionAction(); } });
        qualiteActionitem = new JMenuItem();
        qualiteActionitem.setText( MessagesBundle.getMessage("Qualites"));
        structure.add( qualiteActionitem);
        qualiteActionitem.setMnemonic('V');
        qualiteActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        qualiteActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {qualiteActionAction(); } });
        titreActionitem = new JMenuItem();
        titreActionitem.setText( MessagesBundle.getMessage("Titres"));
        structure.add( titreActionitem);
        titreActionitem.setMnemonic('V');
        titreActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        titreActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {titreActionAction(); } });
        structure.addSeparator();
        motifActionitem = new JMenuItem();
        motifActionitem.setText( MessagesBundle.getMessage("Code Motif"));
        structure.add( motifActionitem);
        motifActionitem.setMnemonic('V');
        motifActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        motifActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {motifActionAction(); } });
        sensActionitem = new JMenuItem();
        sensActionitem.setText( MessagesBundle.getMessage("Sens Operations"));
        structure.add( sensActionitem);
        sensActionitem.setMnemonic('V');
        sensActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        sensActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {sensActionAction(); } });
        typeActionitem = new JMenuItem();
        typeActionitem.setText( MessagesBundle.getMessage("Type Operations"));
        structure.add( typeActionitem);
        typeActionitem.setMnemonic('V');
        typeActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        typeActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {typeActionAction(); } });
        structure.addSeparator();
        natureclienteleActionitem = new JMenuItem();
        natureclienteleActionitem.setText( MessagesBundle.getMessage("Nature Clientele"));
        structure.add( natureclienteleActionitem);
        natureclienteleActionitem.setMnemonic('V');
        natureclienteleActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        natureclienteleActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {natureclienteleActionAction(); } });
        naturejuridiqueActionitem = new JMenuItem();
        naturejuridiqueActionitem.setText( MessagesBundle.getMessage("Nature Juridique"));
        structure.add( naturejuridiqueActionitem);
        naturejuridiqueActionitem.setMnemonic('V');
        naturejuridiqueActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        naturejuridiqueActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {naturejuridiqueActionAction(); } });
        deviseActionitem = new JMenuItem();
        deviseActionitem.setText( MessagesBundle.getMessage("Devises"));
        structure.add( deviseActionitem);
        deviseActionitem.setMnemonic('V');
        deviseActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        deviseActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {deviseActionAction(); } });
        structure.addSeparator();
        sectionActionitem = new JMenuItem();
        sectionActionitem.setText( MessagesBundle.getMessage("Sections"));
        structure.add( sectionActionitem);
        sectionActionitem.setMnemonic('V');
        sectionActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        sectionActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {sectionActionAction(); } });
        divisionActionitem = new JMenuItem();
        divisionActionitem.setText( MessagesBundle.getMessage("Divisions"));
        structure.add( divisionActionitem);
        divisionActionitem.setMnemonic('V');
        divisionActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        divisionActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {divisionActionAction(); } });
        groupeActionitem = new JMenuItem();
        groupeActionitem.setText( MessagesBundle.getMessage("Groupes"));
        structure.add( groupeActionitem);
        groupeActionitem.setMnemonic('V');
        groupeActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        groupeActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {groupeActionAction(); } });
        classeActionitem = new JMenuItem();
        classeActionitem.setText( MessagesBundle.getMessage("Classes"));
        structure.add( classeActionitem);
        classeActionitem.setMnemonic('V');
        classeActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        classeActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {classeActionAction(); } });
        structure.addSeparator();
        operation = new JMenu();
        operation.setText( MessagesBundle.getMessage("Operations"));
        menubar.add(operation );
        ((Map)componentsList.get("listeMenus")).put("operation", operation);
        periode = new JMenu();
        periode.setText( MessagesBundle.getMessage("Initialisation d'une période"));
        operation.add(periode );
        periode.setMnemonic('P');
        periode.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {periodeActionAction(); } });
        operation.addSeparator();
        
        morale = new JMenu();
        morale.setText( MessagesBundle.getMessage("Traitements des Données"));
        operation.add(morale );
        ((Map)componentsList.get("listeMenus")).put("morale", morale);
        
        modeleppActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("modeleppAction", modeleppActionitem);
        modeleppActionitem.setText( MessagesBundle.getMessage("Modeles"));
        morale.add( modeleppActionitem);
        modeleppActionitem.setMnemonic('P');
        modeleppActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        modeleppActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {modeleppActionAction(); } });
        morale.addSeparator();
        importppActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("importppAction", importppActionitem);
        importppActionitem.setText( MessagesBundle.getMessage("Importés les données"));
        morale.add( importppActionitem);
        importppActionitem.setMnemonic('P');
        importppActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        importppActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {importppActionAction(); } });
        operation.addSeparator();
        physique = new JMenu();
        physique.setText( MessagesBundle.getMessage("Consultations des Données"));
        operation.add(physique );
        ((Map)componentsList.get("listeMenus")).put("physique", physique);
        declarationppActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("declarationppAction", declarationppActionitem);
        declarationppActionitem.setText( MessagesBundle.getMessage("Persones Physiques"));
        physique.add( declarationppActionitem);
        declarationppActionitem.setMnemonic('V');
        declarationppActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        declarationppActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {declarationppActionAction(); } });
        physique.addSeparator();
        declarationpmActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("declarationpmAction", declarationpmActionitem);
        declarationpmActionitem.setText( MessagesBundle.getMessage("Persones Morales"));
        physique.add( declarationpmActionitem);
        declarationpmActionitem.setMnemonic('V');
        declarationpmActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        declarationpmActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {declarationpmActionAction(); } });
        physique.addSeparator();
        declarationfinanciereActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("declarationfinanciereAction", declarationfinanciereActionitem);
        declarationfinanciereActionitem.setText( MessagesBundle.getMessage("Financieres"));
        physique.add( declarationfinanciereActionitem);
        declarationfinanciereActionitem.setMnemonic('V');
        declarationfinanciereActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        declarationfinanciereActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {declarationfinanciereActionAction(); } });
        operation.addSeparator();
        balanceActionitem = new JMenu();
        balanceActionitem.setText( MessagesBundle.getMessage("Balance de Paiements"));
        operation.add(balanceActionitem );
        ((Map)componentsList.get("listeMenus")).put("balanceActionitem", balanceActionitem);
        balanceGenActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("balanceActionitem", balanceGenActionitem);
        balanceActionitem.add(balanceGenActionitem );
        balanceGenActionitem.setText( MessagesBundle.getMessage("Genération"));
        balanceActionitem.add( balanceGenActionitem);
        balanceGenActionitem.setMnemonic('P');
        balanceGenActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        balanceGenActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {balanceActionAction(); } });
        balanceActionitem.addSeparator();
        balanceConsulterActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("importppAction", balanceConsulterActionitem);
        balanceConsulterActionitem.setText( MessagesBundle.getMessage("Consultation"));
        balanceActionitem.add( balanceConsulterActionitem);
        balanceConsulterActionitem.setMnemonic('P');
        balanceConsulterActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        balanceConsulterActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {bordereauActionAction(); } });
        operation.addSeparator();
        periode = new JMenu();
        periode.setText( MessagesBundle.getMessage("Archive"));
        operation.add(periode );
        ((Map)componentsList.get("listeMenus")).put("periode", periode);
        archivageItem=new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("periode", archivageItem);
        periode.add(archivageItem );
        archivageItem.setText( MessagesBundle.getMessage("Archivage"));
        archivageItem.setMnemonic('P');
        archivageItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        archivageItem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {periodeActionAction(); } });
        periode.addSeparator();
        ((Map)componentsList.get("listeMenuItems")).put("periode", archivageConsulterItem);
        archivageConsulterItem= new JMenuItem();
        periode.add(archivageConsulterItem );
        archivageConsulterItem.setText( MessagesBundle.getMessage("Consultation"));
        archivageConsulterItem.setMnemonic('P');
        archivageConsulterItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        archivageConsulterItem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {ArchivageConsultAction(); } });

        etats = new JMenu();
        etats.setText( MessagesBundle.getMessage("Editions"));
      //  menubar.add(etats );
     //   ((Map)componentsList.get("listeMenus")).put("etats", etats);
    }

    public void launchClientFrame(UserPrincipal currentUserConnected) {
    	
        Start();
    }

    public void Start() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            /*	//javax.swing.UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
            	javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.luna.LunaLookAndFeel");
            	//javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.smart.SmartLookAndFeel");
            	//javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            	//javax.swing.UIManager.setLookAndFeel ("com.jtattoo.plaf.aero.AeroLookAndFeel");*/
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PrincipalScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrincipalScreen princial = new PrincipalScreen();
                java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                //princial.setLocation(dim.width/2 - princial.getWidth()/2, dim.height/2 - princial.getHeight()/2);
                princial.setSize(dim.width - 20, dim.height - 30);

                //On affiche la fenetre
                princial.setVisible(true);
                //Console des messages
                ConsoleDialog console = new ConsoleDialog();
                console.setLocationRelativeTo(princial);
                //Mise a jour Obj
                ServicesExecution.setConsole((ConsoleEditPanel)console.getMiddlePanel());
                console.setModal(true);
                console.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                console.setVisible(false);
                //Demarrage des Services
                ServicesExecution.start();
            }
        });
    }
    
    public void launchClientFrame(UserPrincipal currentUserConnected,
            Object exerciceBudgetaire) {

     
        // On positionne l'utilisateur en cours xx
      //  CurrentSessionInformations.setCurrentUser(currentUserConnected.getUserConnected());

        //On met à jour la societe
        CurrentSessionInformations.setCurrentSociete(getSociete());
                
        //On affiche la fenetre principale
        Start();     


    }
    /**
    *
    */
   private Societe getSociete() {
 	//Initialisation du manager
	   societe = new Societe();
       GenericManager manager = ManagerHelper.getManager2(societe.getClass());
       System.out.println("PrincipalScreen.getSociete() manager societe"+manager);
       List<Societe> liste= new ArrayList<Societe>();
       if(manager!=null){
    	  liste = manager.findAll();
       }

       if (!liste.isEmpty()) {

           try {
               societe = liste.get(0);

           } catch (Exception ex) {
               Logger.getLogger(SocieteIFrame.class.getName()).log(Level.SEVERE, null, ex);
           }

       } else {
           societe = new Societe();
       }
      return societe;
   }
   
    public void initComponentsList() {
        Map listeMenus = new HashMap();
        Map listeMenuItems = new HashMap();
        Map listeButons = new HashMap();
        componentsList.put("listeMenus", listeMenus);
        componentsList.put("listeMenuItems", listeMenuItems);
        componentsList.put("listeButons", listeButons);
    }

    /**
     * Methode permettant de lier chaque index a une action
     * 
     * @return
     *     void
     */
    @Override
    public void accept(int index) {
        switch (index) {
            case  1 :
                societeActionAction() ;
                break ;
            case  2 :
                paysActionAction() ;
                break ;
            case  3 :
                villeActionAction() ;
                break ;
            case  4 :
                statusresidenceActionAction() ;
                break ;
            case  5 :
                nationaliteActionAction() ;
                break ;
            case  6 :
                precisionActionAction() ;
                break ;
            case  7 :
                qualiteActionAction() ;
                break ;
            case  8 :
                titreActionAction() ;
                break ;
            case  9 :
                motifActionAction() ;
                break ;
            case  10 :
                sensActionAction() ;
                break ;
            case  11 :
                typeActionAction() ;
                break ;
            case  12 :
                natureclienteleActionAction() ;
                break ;
            case  13 :
                naturejuridiqueActionAction() ;
                break ;
            case  14 :
                deviseActionAction() ;
                break ;
            case  15 :
                sectionActionAction() ;
                break ;
            case  16 :
                divisionActionAction() ;
                break ;
            case  17 :
                groupeActionAction() ;
                break ;
            case  18 :
                classeActionAction() ;
                break ;
            case  28 :
                balanceActionAction() ;
                break ;
            case  19 :
                modeleppActionAction() ;
                break ;
            case  20 :
                importppActionAction() ;
                break ;
            case  21 :
                declarationppActionAction() ;
                break ;
            case  22 :
                modelepmActionAction() ;
                break ;
            case  23 :
                importpmActionAction() ;
                break ;
            case  24 :
                declarationpmActionAction() ;
                break ;
            case  25 :
                modeledfActionAction() ;
                break ;
            case  26 :
                importdfActionAction() ;
                break ;
            case  27 :
                declarationfinanciereActionAction() ;
                break ;
            default:
                return ;
        }
    }

    protected void societeActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.parametres.SocieteIFrame");
    }

    protected void paysActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.PaysIFrame");
    }

    protected void villeActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.VilleIFrame");
    }

    protected void statusresidenceActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.StatusResidenceIFrame");
    }

    protected void nationaliteActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.NationaliteIFrame");
    }

    protected void precisionActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.PrecisionDateNaissanceIFrame");
    }

    protected void qualiteActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.QualiteIFrame");
    }

    protected void titreActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.TitreIFrame");
    }

    protected void motifActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.MotifIFrame");
    }

    protected void sensActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.SensOperationIFrame");
    }

    protected void typeActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.TypeOperationIFrame");
    }

    protected void natureclienteleActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.NatureClienteleIFrame");
    }

    protected void naturejuridiqueActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.NatureJuridiqueIFrame");
    }

    protected void deviseActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.DeviseIFrame");
    }

    protected void sectionActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.SectionIFrame");
    }

    protected void divisionActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.DivisionIFrame");
    }

    protected void groupeActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.GroupeIFrame");
    }

    protected void classeActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.referentiels.ClasseIFrame");
    }
    
    protected void periodeActionAction() {
        showDialog(ArchiveDialog.class.getName(),ArchiveOperation.class);
    }
    protected void ArchivageConsultAction() {
        showInsideDesktopPane("com.megatimgroup.views.archivage.ArchiveIFrame");
    }  
    

    protected void modeleppActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.operations.ModeleIFrame");
    }

    protected void importppActionAction() {
        showDialog("com.megatimgroup.views.operations.ImportDialog",ImportData.class);
    }

    protected void declarationppActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.operations.DeclarationPPIFrame");
    }

    protected void modelepmActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.operations.ModeleIFrame");
    }

    protected void importpmActionAction() {
        showDialog("com.megatimgroup.views.operations.ImportDialog",ImportData.class);
    }

    protected void declarationpmActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.operations.DeclarationPMIFrame");
    }

    protected void modeledfActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.operations.ModeleIFrame");
    }

    protected void importdfActionAction() {
        showDialog("com.megatimgroup.views.operations.ImportDialog",ImportData.class);
    }

    protected void declarationfinanciereActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.operations.DeclarationFinanciereIFrame");
    }
    
    protected void bordereauActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.operations.BalanceIFrame");
    }

    protected void balanceActionAction() {
        showDialog("com.megatimgroup.views.operations.BalanceDialog",BordereauBP.class);
    }

    @Override
    public void buildToolBar() {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public  boolean statutToolbar(){
    	return false;
    };
    @Override
    public ImageIcon getIconeApplication() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/ebay/images/bank.png"));
        return icon;
    }
    @Override
    protected Image midlePanel() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/ebay/images/home.png"));
        return icon.getImage();
    }


    public void launchClientFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public GenericManager getExerciceBudgetaireManager() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    protected void utilisateurActionAction() {
        showInsideDesktopPane("com.megatimgroup.views.parametres.UtilisateurIFrame");
    }

}
