
package com.megatimgroup.views.operations;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.operations.Champ;


/**
 * Modele de tableau ChampModel
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ChampModel
    extends AbstractTableBaseListModel<Champ>
{

    protected MessagesBundle bundle;

    public ChampModel() {
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
                return (MessagesBundle.getMessage("champ.id"));
            case  1 :
                return (MessagesBundle.getMessage("champ.fieldname"));
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
    public Object getColoumnValue(Champ data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getId());
            case  1 :
                return (data.getFieldName());
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
            case  0 :
                return (long.class);
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
