
package com.megatimgroup.views.archivage;

import java.util.Date;

import com.ibm.icu.math.BigDecimal;
import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.archivage.ArchiveOperation;


/**
 * Modele de tableau ChampModel
 * @since Sun Apr 30 13:05:42 WAT 2017
 * 
 */
public class ArchiveModel extends AbstractTableBaseListModel<ArchiveOperation>
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected MessagesBundle bundle;

    public ArchiveModel() {
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
                return (MessagesBundle.getMessage("ID OPERATION"));
            case  1 :
                return (MessagesBundle.getMessage("MOIS"));
            case  2 :
                return (MessagesBundle.getMessage("DATE OPERATION"));
            case  3 :
                return (MessagesBundle.getMessage("REFERENCE"));
            case  4 :
                return (MessagesBundle.getMessage("DESIGNATION"));
            case  5 :
                return (MessagesBundle.getMessage("PAYS TRANSACTION"));
            case  6 :
                return (MessagesBundle.getMessage("MONTANT"));
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
    public Object getColoumnValue(ArchiveOperation data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getIdOperation());
            case  1 :
                return (data.getlMois());
            case  2 :
                return (data.getdOper());
            case  3 :
                return (data.getcRef());
            case  4 :
                return (data.getlDes());
            case  5 :
                return (data.getcPays());
            case  6 :
            	return (data.getnMnt() != null ? new Double(data.getnMnt()) : null);
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
        case 6:
            return (Double.class);
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
        return  7;
    }

}
