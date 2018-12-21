
package com.megatimgroup.views.parametres;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.parametres.Societe;


/**
 * Modele de tableau SocieteModel
 * @since Sun Apr 30 15:21:37 WAT 2017
 * 
 */
public class SocieteModel
    extends AbstractTableBaseListModel<Societe>
{

    protected MessagesBundle bundle;

    public SocieteModel() {
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
                return (MessagesBundle.getMessage("societe.code"));
            case  1 :
                return (MessagesBundle.getMessage("societe.designation"));
            case  2 :
                return (MessagesBundle.getMessage("societe.raisonsocial"));
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
    public Object getColoumnValue(Societe data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getCode());
            case  1 :
                return (data.getDesignation());
            case  2 :
                return (data.getRaisonSocial());
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
        return  3;
    }

}
