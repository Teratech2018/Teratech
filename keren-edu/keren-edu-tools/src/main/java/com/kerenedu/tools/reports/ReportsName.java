/**
 *
 */
package com.kerenedu.tools.reports;

/**
 * @author <a href="mailto:ntchuenna@yahoo.fr">nadège Tchuente</a>
 * 22 sept. 2016
 */
public enum ReportsName {

   
    CERTIFICAT_SCOLAIRE("ecertificatscolarite.jasper"),
    FACTURE("efacture.jasper"),
    ANNIVERSAIRE("eanniversaire.jasper"),
    LISTE_ELEVE("elisteeleve.jasper"),
    LISTAING_RETARD("elistingretard.jasper"),
    BILANFINANCIER("ebilanfinancier.jasper"),
    BILANFINANCIERCLASSE("ebilanfinancierclasse.jasper"),
    LINSTINGPAIEMENT("elistingpaiement.jasper"),
    LINSTINGRETARD("elistingretard.jasper"),
    BULLSEQUENTIEL("ebulletin_sequence.jasper"), 
    EMARGEMENT("eficheemarge.jasper"),  
    PLANNING_COURS("eemploitemps.jasper"),  
    BULLTRIM("ebulletin_trimestre.jasper"),  
    FICHE_INSCRIPTION("eficheInscription.jasper"),  
    BULLETIN("ebulletin.jasper");

    /**
     * Nom de l'etat sans extension
     */
    private final String name;

    /**
     * Constructeur parametre
     *
     * @param name Nom de l'état
     */
    private ReportsName(String name) {

        this.name = name;
    }

    /**
     * Methode d'obtention du nom du fichier de l'état (sans extension)
     *
     * @return Nom de l'etat
     */
    public String getName() {

        return name;
    }
}
