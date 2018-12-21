package com.megatimgroup.views.helper;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.ebaytools.client.ValidateError;

/**
 * Modele de tableau EngagementRejeteTModel00000000000000
 *
 * @since Tue Sep 20 11:41:16 WAT 2016
 *
 */
public class ValidateErrorTModel
        extends AbstractTableBaseListModel<ValidateError> {

    protected MessagesBundle bundle;

    public ValidateErrorTModel() {
        super();
    }

    /**
     * Methode permettant de retourner le nom de la colonne
     *
     * @param columnIndex
     * @return java.lang.String
     */
    @Override
    public String getColumnName(int columnIndex) {
        switch ((columnIndex)) {
            case 0:
                return (MessagesBundle.getMessage("Ligne"));
            case 1:
                return (MessagesBundle.getMessage("Colonne"));
            case 2:
                return (MessagesBundle.getMessage("Champ"));
            case 3:
                return (MessagesBundle.getMessage("Valeur"));
            case 4:
                return (MessagesBundle.getMessage("Message"));
            default:
                return ("");
        }
    }

    /**
     * /** **<!---->/Methode permettant de retourner la valeur de la colonne
     *
     * @param data
     * @param columnIndex
     * @return void
     */
    @Override
    public Object getColoumnValue(ValidateError data, int columnIndex) {
        
        switch ((columnIndex)) {
            case 0:
                if(data==null) return -1;
                return (data.getColumn()!=null ? data.getColumn().getRow(): -1);
            case 1:
                if(data==null) return -1;
                return (data.getColumn()!=null ? data.getColumn().getColumn(): -1);
            case 2:
                if(data==null) return "UNKNOW";
                return (data.getNode()!=null ? data.getNode().getName() : "UNKNOWN");
            case 3:
                if(data==null) return "UNKNOW";
                return (data.getColumn()!=null ? data.getColumn().getValue().toString(): "UNKNOWN");
            case 4:
                if(data==null) return "UNKNOW";
                return (data.getErrorMessage());
            default:
                return ("");
        }
    }

    /**
     * Methode permettant de retourner la classe de la colonne
     *
     * @param columnIndex
     * @return java.lang.Class
     */
    @Override
    public Class getColumnClass(int columnIndex) {
        switch ((columnIndex)) {
            case 0:
                return (Integer.class);
            case 1:
                return (Integer.class);
            default:
                return (String.class);
        }
    }

    /**
     * Methode permettant de retourner le nombre de colonnes
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return 5;
    }

   

}
