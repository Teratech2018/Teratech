
package com.megatimgroup.views.operations;

import java.util.Date;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.reporting.BordereauBP;


/**
 * Modele de tableau ChampModel
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class BalanceModel
    extends AbstractTableBaseListModel<BordereauBP>
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected MessagesBundle bundle;

    public BalanceModel() {
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
                return (MessagesBundle.getMessage("ebay.filename"));
            case  1 :
                return (MessagesBundle.getMessage("ebay.date.debut"));
            case  2 :
                return (MessagesBundle.getMessage("ebay.date.fin"));
            case  3 :
                return (MessagesBundle.getMessage("ebay.nbre.op"));
            case  4 :
                return (MessagesBundle.getMessage("ebay.nbre.pm"));
            case  5 :
                return (MessagesBundle.getMessage("ebay.nbre.pp"));
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
    public Object getColoumnValue(BordereauBP data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getFileName());
            case  1 :
                return (data.getDateDebut());
            case  2 :
                return (data.getDateFin());
            case  3 :
                return (data.getNombreOF());
            case  4 :
                return (data.getNombrePM());
            case  5 :
                return (data.getNombrePP());
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
                return (String.class);
            case  1 :
                return (Date.class);
            case  2 :
                return (Date.class);
            default:
                return (long.class);
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
        return  6;
    }

}
