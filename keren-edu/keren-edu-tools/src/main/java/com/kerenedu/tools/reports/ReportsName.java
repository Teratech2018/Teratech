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
    BULLANN("ebulletin_annuel.jasper"),  
    FICHE_INSCRIPTION("eficheInscriptiontemplateimp.jasper"),  
    BILAN_SERVICE("elistingseleveservice.jasper"),
    BADGE("ebadge.jasper"),
    LISTE_INSCRIT("elistieeleveincrit.jasper"),
    COUPONS_INSOLVABLE("ecouponsinsolvable.jasper"),
    FICHE_NOTE("enotematiere.jasper"),
    FICHE_NOTE_TD("relevenoteclasse.jasper"),
    RELEVE_NOTE_ELEVE("relevenoteeleve.jasper"),
    FICHE_MOYENNE_TD("emoyennetd.jasper"),
    FICHE_MATIERE("ematiereclasse.jasper"),
    BULLETIN("ebulletin.jasper"),
    BULLETIN_PAIE("ebulletinpaie.jasper"),
    DOC_BANCAIRE("documentbancaire.jasper"),
    PEICE_CAISSE("piececaisse.jasper"),
    RETENUE_SAL("retenusalariale.jasper"),
    RETENUE_SAL_TD("retenusalarialetd.jasper"),
    SIT_HORAIRE("sithoraire.jasper"),
    ACOMPTE_TD("acomptetd.jasper"),
    AMICALE_TD("sitamicaletd.jasper"),
    LOYER_TD("sitloyertd.jasper"),
    CNPS_TD("sitcnpstd.jasper"),
    FICHE_PRESENCE("efichepresence.jasper"),
    MASSE_SAL("massesalarialedtl.jasper"),
    MASSE_SAL_GLOBAL("massesalariale.jasper"),
    FICHE_PRET("sfichepret.jasper"),
    FICHE_ACOMPTE("sficheacompte.jasper"),
    MATRICE_MOY("ematricemoyenne.jasper"),
    ATESTATION_TRAVAIL("eattestationtravail.jasper"),
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
