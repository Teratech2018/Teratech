
package com.megatimgroup.views.operations;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.operations.DeclarationPM;


/**
 * Modele de tableau DeclarationPMModel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPMModel
    extends AbstractTableBaseListModel<DeclarationPM>
{

    protected MessagesBundle bundle;

    public DeclarationPMModel() {
        super() ; 
    }

    /**
     * Methode permettant de retourner le nom de la colonne
     * 
     * @param columnIndex
     * @return
     *     java.lang.String
     */
    @Override
    public String getColumnName(int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (MessagesBundle.getMessage("ebay.reference"));
            case  1 :
                return (MessagesBundle.getMessage("ebay.naturejuridique"));
            case  2 :
                return (MessagesBundle.getMessage("ebay.ville"));
            case  3 :
                return (MessagesBundle.getMessage("ebay.section"));
            default:
                return ("");
        }
    }

    /**
     * /**  **<!---->/Methode permettant de retourner la valeur de la colonne
     * 
     * @param data
     * @param columnIndex
     * @return
     *     void
     */
    @Override
    public Object getColoumnValue(DeclarationPM data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getReference());
            case  1 :
                return (data.getNatureJuridique());
            case  2 :
                return (data.getVille());
            case  3 :
                return (data.getSection());
            default:
                return ("");
        }
    }

    /**
     * Methode permettant de retourner la classe de la colonne
     * 
     * @param columnIndex
     * @return
     *     java.lang.Class
     */
    @Override
    public Class getColumnClass(int columnIndex) {
        switch ((columnIndex)) {
            case  1 :
                return (com.megatimgroup.model.referentiels.NatureJuridique.class);
            case  2 :
                return (com.megatimgroup.model.referentiels.Ville.class);
            case  3 :
                return (com.megatimgroup.model.referentiels.Section.class);
            default:
                return (String.class);
        }
    }

    /**
     * Methode permettant de retourner le nombre de colonnes
     * 
     * @return
     *     int
     */
    @Override
    public int getColumnCount() {
        return  4;
    }

}
