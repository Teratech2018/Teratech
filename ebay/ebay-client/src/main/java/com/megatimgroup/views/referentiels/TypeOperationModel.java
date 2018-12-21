
package com.megatimgroup.views.referentiels;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.referentiels.TypeOperation;


/**
 * Modele de tableau TypeOperationModel
 * @since Sat Apr 29 15:47:15 WAT 2017
 * 
 */
public class TypeOperationModel
    extends AbstractTableBaseListModel<TypeOperation>
{

    protected MessagesBundle bundle;

    public TypeOperationModel() {
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
                return (MessagesBundle.getMessage("typeoperation.code"));
            case  1 :
                return (MessagesBundle.getMessage("typeoperation.designation"));
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
    public Object getColoumnValue(TypeOperation data, int columnIndex) {
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
