
package com.megatimgroup.smsgw.views.referentiel;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.smsgw.model.referentiel.Client;


/**
 * Modele de tableau ClientModel
 * @since Thu Sep 07 15:22:23 WAT 2017
 * 
 */
public class ClientModel
    extends AbstractTableBaseListModel<Client>
{

    protected MessagesBundle bundle;

    public ClientModel() {
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
                return (MessagesBundle.getMessage("client.id"));
            case  1 :
                return (MessagesBundle.getMessage("client.nom"));
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
    public Object getColoumnValue(Client data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getId());
            case  1 :
                return (data.getNom());
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
