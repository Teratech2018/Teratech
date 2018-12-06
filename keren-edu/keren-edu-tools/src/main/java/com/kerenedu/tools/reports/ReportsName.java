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
    RETARD_PAIELMENT("eretardpaiement.jasper"),
    LINSTINGPAIEMENT("elistingpaiement.jasper"),
    LINSTINGPAIEMENT_TYPE("elistingpaiementtype.jasper"),
    LINSTINGRETARD("elistingretard.jasper"),
    BULLSEQUENTIEL("ebulletin_sequence.jasper"), 
    BULLSEQUENTIEL_PRIMAIRE("ebulletin_sequence_primaire.jasper"), 
    EMARGEMENT("eficheemarge.jasper"),  
    PLANNING_COURS("eemploitemps.jasper"),  
    BULLTRIM("ebulletin_trimestre.jasper"),  
    FICHE_INSCRIPTION("eficheInscriptiontemplateimp.jasper"),  
    BILAN_SERVICE("elistingseleveservice.jasper"),
    BADGE("ebadge.jasper"),
    LISTE_INSCRIT("elistieeleveincrit.jasper"),
    COUPONS_INSOLVABLE("ecouponsinsolvable.jasper"),
    FICHE_NOTE("enotematiere.jasper"),
    FICHE_NOTE_TD("enotematieretd.jasper"),
    FICHE_MOYENNE_TD("emoyennetd.jasper"),
    FICHE_MATIERE("ematiereclasse.jasper"),
    BULLETIN("ebulletin.jasper"),
    BULLETIN_PAIE("ebulletinpaie.jasper"),
    VIREMENT("evirementsalairetd.jasper") ;

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
