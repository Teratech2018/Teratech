
package com.megatimgroup.smsgw.views.principal;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import com.megatim.common.clients.ActionDetail;
import com.megatim.common.clients.ActionGroup;
import com.megatim.common.clients.OptionPanel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatim.common.utilities.PrincipalFrame;
import com.megatim.common.utilities.ResourcesBundle;
import com.megatim.security.ifaces.client.ClientInterfaceSecurity;
import com.megatim.security.principal.UserPrincipal;
import javax.swing.ImageIcon;


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
    private JMenuItem modeleppActionitem;
    private JMenuItem importppActionitem;
    private JMenuItem declarationppActionitem;
    private JMenu morale;
    private JMenuItem modelepmActionitem;
    private JMenuItem importpmActionitem;
    private JMenuItem declarationpmActionitem;
    private JMenu financier;
    private JMenuItem modeledfActionitem;
    private JMenuItem importdfActionitem;
    private JMenuItem declarationfinanciereActionitem;
    private JMenuItem balanceActionitem;
    private JMenu etats;

    /**
     * Constructeur par defaut
     * 
     */
    public PrincipalScreen() {
         super() ; 
        bundle = ResourceBundle.getBundle("messages");
        MessagesBundle.setBundle(bundle);
        resourcesbundle = ResourceBundle.getBundle("resources");
        ResourcesBundle.setBundle(resourcesbundle);
         this.setTitle(MessagesBundle.getMessage("SMS-GW")) ; 
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
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
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
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Pays");
        element.setActionIndex(2);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("villeAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Villes");
        element.setActionIndex(3);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("statusresidenceAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Statut Residence");
        element.setActionIndex(4);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("nationaliteAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Nationalites");
        element.setActionIndex(5);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("precisionAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Precision date de naissance");
        element.setActionIndex(6);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("qualiteAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Qualites");
        element.setActionIndex(7);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("titreAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Titres");
        element.setActionIndex(8);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("motifAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Code Motif");
        element.setActionIndex(9);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("sensAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Sens Operations");
        element.setActionIndex(10);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("typeAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Type Operations");
        element.setActionIndex(11);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("natureclienteleAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Nature Clientele");
        element.setActionIndex(12);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("naturejuridiqueAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Nature Juridique");
        element.setActionIndex(13);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("deviseAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Devises");
        element.setActionIndex(14);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("sectionAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Sections");
        element.setActionIndex(15);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("divisionAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Divisions");
        element.setActionIndex(16);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("groupeAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Groupes");
        element.setActionIndex(17);
        element.setSeparator(false);
        group.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("classeAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
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
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
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
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Modeles");
        element.setActionIndex(19);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("importppAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Importes");
        element.setActionIndex(20);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("declarationppAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
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
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Modeles");
        element.setActionIndex(22);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("importpmAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Importes");
        element.setActionIndex(23);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("declarationpmAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
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
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Modeles");
        element.setActionIndex(25);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("importdfAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
        element.setActionLabel("Importes");
        element.setActionIndex(26);
        element.setSeparator(false);
        elementgroup.getActions().add(element);
        element = new ActionDetail();
        element.setActionName("declarationfinanciereAction");
        element.setViewClass("com.megatimgroup.smsgw.model.referentiel.Client");
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
        operation = new JMenu();
        operation.setText( MessagesBundle.getMessage("Operations"));
        menubar.add(operation );
        ((Map)componentsList.get("listeMenus")).put("operation", operation);
        physique = new JMenu();
        physique.setText( MessagesBundle.getMessage("Donnees Personnes Physique"));
        operation.add(physique );
        ((Map)componentsList.get("listeMenus")).put("physique", physique);
        modeleppActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("modeleppAction", modeleppActionitem);
        modeleppActionitem.setText( MessagesBundle.getMessage("Modeles"));
        physique.add( modeleppActionitem);
        modeleppActionitem.setMnemonic('P');
        modeleppActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        modeleppActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {modeleppActionAction(); } });
        importppActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("importppAction", importppActionitem);
        importppActionitem.setText( MessagesBundle.getMessage("Importes"));
        physique.add( importppActionitem);
        importppActionitem.setMnemonic('P');
        importppActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        importppActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {importppActionAction(); } });
        declarationppActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("declarationppAction", declarationppActionitem);
        declarationppActionitem.setText( MessagesBundle.getMessage("Persones Physiques"));
        physique.add( declarationppActionitem);
        declarationppActionitem.setMnemonic('V');
        declarationppActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        declarationppActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {declarationppActionAction(); } });
        morale = new JMenu();
        morale.setText( MessagesBundle.getMessage("Donnees Personnes Morale"));
        operation.add(morale );
        ((Map)componentsList.get("listeMenus")).put("morale", morale);
        modelepmActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("modelepmAction", modelepmActionitem);
        modelepmActionitem.setText( MessagesBundle.getMessage("Modeles"));
        morale.add( modelepmActionitem);
        modelepmActionitem.setMnemonic('P');
        modelepmActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        modelepmActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {modelepmActionAction(); } });
        importpmActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("importpmAction", importpmActionitem);
        importpmActionitem.setText( MessagesBundle.getMessage("Importes"));
        morale.add( importpmActionitem);
        importpmActionitem.setMnemonic('P');
        importpmActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        importpmActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {importpmActionAction(); } });
        declarationpmActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("declarationpmAction", declarationpmActionitem);
        declarationpmActionitem.setText( MessagesBundle.getMessage("Persones Morales"));
        morale.add( declarationpmActionitem);
        declarationpmActionitem.setMnemonic('V');
        declarationpmActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        declarationpmActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {declarationpmActionAction(); } });
        financier = new JMenu();
        financier.setText( MessagesBundle.getMessage("Donnees Financieres"));
        operation.add(financier );
        ((Map)componentsList.get("listeMenus")).put("financier", financier);
        modeledfActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("modeledfAction", modeledfActionitem);
        modeledfActionitem.setText( MessagesBundle.getMessage("Modeles"));
        financier.add( modeledfActionitem);
        modeledfActionitem.setMnemonic('P');
        modeledfActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        modeledfActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {modeledfActionAction(); } });
        importdfActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("importdfAction", importdfActionitem);
        importdfActionitem.setText( MessagesBundle.getMessage("Importes"));
        financier.add( importdfActionitem);
        importdfActionitem.setMnemonic('P');
        importdfActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , KeyEvent.CTRL_MASK));
        importdfActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {importdfActionAction(); } });
        declarationfinanciereActionitem = new JMenuItem();
        ((Map)componentsList.get("listeMenuItems")).put("declarationfinanciereAction", declarationfinanciereActionitem);
        declarationfinanciereActionitem.setText( MessagesBundle.getMessage("Financieres"));
        financier.add( declarationfinanciereActionitem);
        declarationfinanciereActionitem.setMnemonic('V');
        declarationfinanciereActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        declarationfinanciereActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {declarationfinanciereActionAction(); } });
        balanceActionitem = new JMenuItem();
        balanceActionitem.setText( MessagesBundle.getMessage("Balances des Paiements"));
        operation.add( balanceActionitem);
        balanceActionitem.setMnemonic('V');
        balanceActionitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , KeyEvent.CTRL_MASK));
        balanceActionitem.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {balanceActionAction(); } });
        etats = new JMenu();
        etats.setText( MessagesBundle.getMessage("Editions"));
        menubar.add(etats );
        ((Map)componentsList.get("listeMenus")).put("etats", etats);
    }

    public void launchClientFrame(UserPrincipal currentUserConnected) {
        Start();
    }

    public void Start() {
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
        javax.swing.UIManager.setLookAndFeel(info.getClassName());
        break;
        }}
        }catch (Exception ex) {
        java.util.logging.Logger.getLogger(PrincipalScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        PrincipalScreen princial = new PrincipalScreen();
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //princial.setLocation(dim.width/2 - princial.getWidth()/2, dim.height/2 - princial.getHeight()/2);
        princial.setSize(dim.width - 20, dim.height - 30);
        princial.setVisible(true);
        }
        });
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
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void paysActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void villeActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void statusresidenceActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void nationaliteActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void precisionActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void qualiteActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void titreActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void motifActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void sensActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void typeActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void natureclienteleActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void naturejuridiqueActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void deviseActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void sectionActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void divisionActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void groupeActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void classeActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void modeleppActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void importppActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void declarationppActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void modelepmActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void importpmActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.model.referentiel.Client");
    }

    protected void declarationpmActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void modeledfActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void importdfActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void declarationfinanciereActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    protected void balanceActionAction() {
        showInsideDesktopPane("com.megatimgroup.smsgw.views.referentiel.ClientIFrame");
    }

    @Override
    public void buildToolBar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void launchClientFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void launchClientFrame(UserPrincipal currentUserConnected, Object exerciceBudgetaire) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void launchClientFrame(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public GenericManager getExerciceBudgetaireManager() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ImageIcon getIconWindow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean ifLoginByServer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getUrlServerForAuthentification() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
