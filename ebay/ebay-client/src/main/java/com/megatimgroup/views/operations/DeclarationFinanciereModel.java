
package com.megatimgroup.views.operations;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.operations.DeclarationFinanciere;


/**
 * Modele de tableau DeclarationFinanciereModel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationFinanciereModel
    extends AbstractTableBaseListModel<DeclarationFinanciere>
{

    protected MessagesBundle bundle;

    public DeclarationFinanciereModel() {
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
                return (MessagesBundle.getMessage("ebay.reference").toUpperCase());
            case  1 :
                return (MessagesBundle.getMessage("ebay.sens").toUpperCase());
            case  2 :
                return (MessagesBundle.getMessage("ebay.devise").toUpperCase());
            case  3 :
                return (MessagesBundle.getMessage("ebay.dateoperation").toUpperCase());
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
    public Object getColoumnValue(DeclarationFinanciere data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getReference());
            case  1 :
                return (data.getSens());
            case  2 :
                return (data.getDevise());
            case  3 :
                return (data.getDateOperation());
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
                return (com.megatimgroup.model.referentiels.SensOperation.class);
            case  2 :
                return (com.megatimgroup.model.referentiels.Devise.class);
            case  3 :
                return (java.util.Date.class);
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
