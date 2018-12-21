
package com.megatimgroup.views.referentiels;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.referentiels.Division;


/**
 * Modele de tableau DivisionModel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DivisionModel
    extends AbstractTableBaseListModel<Division>
{

    protected MessagesBundle bundle;

    public DivisionModel() {
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
                return (MessagesBundle.getMessage("ebay.code").toUpperCase());
            case  1 :
                return (MessagesBundle.getMessage("ebay.designation").toUpperCase());
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
    public Object getColoumnValue(Division data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getCode());
            case  1 :
                return (data.getDesignation());
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
        return  2;
    }

}
