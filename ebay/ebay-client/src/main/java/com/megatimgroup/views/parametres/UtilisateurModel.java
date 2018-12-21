
package com.megatimgroup.views.parametres;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.parametres.User;


/**
 * Modele de tableau UtilisateurModel

 * @since Sun Sep 18 21:53:38 CEST 2016
 * 
 */
public class UtilisateurModel
    extends AbstractTableBaseListModel<User>
{

    protected MessagesBundle bundle;

    public UtilisateurModel() {
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
//            case  0 :
//                return (MessagesBundle.getMessage("utilisateur.login").toUpperCase());
            case  0 :
                return (MessagesBundle.getMessage("utilisateur.nom").toUpperCase());
            case  1 :
                return (MessagesBundle.getMessage("utilisateur.prenom").toUpperCase());
//            case  3 :
//                return (MessagesBundle.getMessage("utilisateur.password").toUpperCase());
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
    public Object getColoumnValue(User data, int columnIndex) {
        switch ((columnIndex)) {
//            case  0 :
//                return (data.getLogin());
            case 0 :
                return (data.getNom());
            case  1 :
                return (data.getPrenom());
//            case  3 :
//                return (data.getPassword());

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
                return (String.class);
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
