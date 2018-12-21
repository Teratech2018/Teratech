
package com.megatimgroup.views.operations;

import com.megatim.common.clients.AbstractTableBaseListModel;
import com.megatim.common.utilities.MessagesBundle;
import com.megatimgroup.model.operations.DeclarationPP;


/**
 * Modele de tableau DeclarationPPModel
 * @since Sun Apr 30 15:49:47 WAT 2017
 * 
 */
public class DeclarationPPModel
    extends AbstractTableBaseListModel<DeclarationPP>
{

    protected MessagesBundle bundle;

    public DeclarationPPModel() {
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
                return (MessagesBundle.getMessage("ebay.qualite").toUpperCase());
            case  2 :
                return (MessagesBundle.getMessage("ebay.titre").toUpperCase());
            case  3 :
                return (MessagesBundle.getMessage("ebay.ville").toUpperCase());
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
    public Object getColoumnValue(DeclarationPP data, int columnIndex) {
        switch ((columnIndex)) {
            case  0 :
                return (data.getReference());
            case  1 :
                return (data.getQualite());
            case  2 :
                return (data.getTitre());
            case  3 :
                return (data.getVille());
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
                return (com.megatimgroup.model.referentiels.Qualite.class);
            case  2 :
                return (com.megatimgroup.model.referentiels.Titre.class);
            case  3 :
                return (com.megatimgroup.model.referentiels.Ville.class);
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
