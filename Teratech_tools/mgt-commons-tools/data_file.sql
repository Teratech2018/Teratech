-- MySQL dump 10.13  Distrib 5.1.56, for Win32 (ia32)
--
-- Host: localhost    Database: keren_db
-- ------------------------------------------------------
-- Server version	5.1.56-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `canal_grp`
--

LOCK TABLES `canal_grp` WRITE;
/*!40000 ALTER TABLE `canal_grp` DISABLE KEYS */;
/*!40000 ALTER TABLE `canal_grp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `canal_user`
--

LOCK TABLES `canal_user` WRITE;
/*!40000 ALTER TABLE `canal_user` DISABLE KEYS */;
INSERT INTO `canal_user` VALUES (1,2),(1,1);
/*!40000 ALTER TABLE `canal_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_abscence`
--

LOCK TABLES `e_abscence` WRITE;
/*!40000 ALTER TABLE `e_abscence` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_abscence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_abscence_e_eleve`
--

LOCK TABLES `e_abscence_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_abscence_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_abscence_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_annee`
--

LOCK TABLES `e_annee` WRITE;
/*!40000 ALTER TABLE `e_annee` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_annee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_app`
--

LOCK TABLES `e_app` WRITE;
/*!40000 ALTER TABLE `e_app` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_avance_prof`
--

LOCK TABLES `e_avance_prof` WRITE;
/*!40000 ALTER TABLE `e_avance_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_avance_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_bstage`
--

LOCK TABLES `e_bstage` WRITE;
/*!40000 ALTER TABLE `e_bstage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_bul`
--

LOCK TABLES `e_bul` WRITE;
/*!40000 ALTER TABLE `e_bul` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bul` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_bul_e_examen`
--

LOCK TABLES `e_bul_e_examen` WRITE;
/*!40000 ALTER TABLE `e_bul_e_examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bul_e_examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_caisse`
--

LOCK TABLES `e_caisse` WRITE;
/*!40000 ALTER TABLE `e_caisse` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_caisse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_classe`
--

LOCK TABLES `e_classe` WRITE;
/*!40000 ALTER TABLE `e_classe` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_cmail`
--

LOCK TABLES `e_cmail` WRITE;
/*!40000 ALTER TABLE `e_cmail` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_cmail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_coefmat`
--

LOCK TABLES `e_coefmat` WRITE;
/*!40000 ALTER TABLE `e_coefmat` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_coefmat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_coefmatdtl`
--

LOCK TABLES `e_coefmatdtl` WRITE;
/*!40000 ALTER TABLE `e_coefmatdtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_coefmatdtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_contacts`
--

LOCK TABLES `e_contacts` WRITE;
/*!40000 ALTER TABLE `e_contacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_diplome`
--

LOCK TABLES `e_diplome` WRITE;
/*!40000 ALTER TABLE `e_diplome` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_diplome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_dlieu`
--

LOCK TABLES `e_dlieu` WRITE;
/*!40000 ALTER TABLE `e_dlieu` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_dlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_dossier`
--

LOCK TABLES `e_dossier` WRITE;
/*!40000 ALTER TABLE `e_dossier` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_dossier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_ech_dlt`
--

LOCK TABLES `e_ech_dlt` WRITE;
/*!40000 ALTER TABLE `e_ech_dlt` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_ech_dlt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_echeance`
--

LOCK TABLES `e_echeance` WRITE;
/*!40000 ALTER TABLE `e_echeance` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_echeance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_eleve`
--

LOCK TABLES `e_eleve` WRITE;
/*!40000 ALTER TABLE `e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_emarge`
--

LOCK TABLES `e_emarge` WRITE;
/*!40000 ALTER TABLE `e_emarge` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_emarge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_emarge_dlt`
--

LOCK TABLES `e_emarge_dlt` WRITE;
/*!40000 ALTER TABLE `e_emarge_dlt` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_emarge_dlt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_etbl`
--

LOCK TABLES `e_etbl` WRITE;
/*!40000 ALTER TABLE `e_etbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_etbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_evastge`
--

LOCK TABLES `e_evastge` WRITE;
/*!40000 ALTER TABLE `e_evastge` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_evastge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_examen`
--

LOCK TABLES `e_examen` WRITE;
/*!40000 ALTER TABLE `e_examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_filiere`
--

LOCK TABLES `e_filiere` WRITE;
/*!40000 ALTER TABLE `e_filiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_filiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_fpaie`
--

LOCK TABLES `e_fpaie` WRITE;
/*!40000 ALTER TABLE `e_fpaie` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_fpaie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_fpaie_prof`
--

LOCK TABLES `e_fpaie_prof` WRITE;
/*!40000 ALTER TABLE `e_fpaie_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_fpaie_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_inscription`
--

LOCK TABLES `e_inscription` WRITE;
/*!40000 ALTER TABLE `e_inscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_inscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_jcours`
--

LOCK TABLES `e_jcours` WRITE;
/*!40000 ALTER TABLE `e_jcours` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_jcours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_lstage`
--

LOCK TABLES `e_lstage` WRITE;
/*!40000 ALTER TABLE `e_lstage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_lstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_mail`
--

LOCK TABLES `e_mail` WRITE;
/*!40000 ALTER TABLE `e_mail` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_mail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_mail_e_eleve`
--

LOCK TABLES `e_mail_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_mail_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_mail_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_matiere`
--

LOCK TABLES `e_matiere` WRITE;
/*!40000 ALTER TABLE `e_matiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_matierecoutprof`
--

LOCK TABLES `e_matierecoutprof` WRITE;
/*!40000 ALTER TABLE `e_matierecoutprof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_matierecoutprof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_module`
--

LOCK TABLES `e_module` WRITE;
/*!40000 ALTER TABLE `e_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_module_e_matiere`
--

LOCK TABLES `e_module_e_matiere` WRITE;
/*!40000 ALTER TABLE `e_module_e_matiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_module_e_matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_nat`
--

LOCK TABLES `e_nat` WRITE;
/*!40000 ALTER TABLE `e_nat` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_nat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_niv`
--

LOCK TABLES `e_niv` WRITE;
/*!40000 ALTER TABLE `e_niv` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_niv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_niv_cls`
--

LOCK TABLES `e_niv_cls` WRITE;
/*!40000 ALTER TABLE `e_niv_cls` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_niv_cls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_note`
--

LOCK TABLES `e_note` WRITE;
/*!40000 ALTER TABLE `e_note` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_note_mat`
--

LOCK TABLES `e_note_mat` WRITE;
/*!40000 ALTER TABLE `e_note_mat` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_note_mat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_notedlt`
--

LOCK TABLES `e_notedlt` WRITE;
/*!40000 ALTER TABLE `e_notedlt` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_notedlt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_paie`
--

LOCK TABLES `e_paie` WRITE;
/*!40000 ALTER TABLE `e_paie` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_paie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_paie_prof`
--

LOCK TABLES `e_paie_prof` WRITE;
/*!40000 ALTER TABLE `e_paie_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_paie_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_periode`
--

LOCK TABLES `e_periode` WRITE;
/*!40000 ALTER TABLE `e_periode` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_periode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_plcours`
--

LOCK TABLES `e_plcours` WRITE;
/*!40000 ALTER TABLE `e_plcours` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_plcours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_presence`
--

LOCK TABLES `e_presence` WRITE;
/*!40000 ALTER TABLE `e_presence` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_presence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_presence_e_eleve`
--

LOCK TABLES `e_presence_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_presence_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_presence_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_prime_prof`
--

LOCK TABLES `e_prime_prof` WRITE;
/*!40000 ALTER TABLE `e_prime_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_prime_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_prof`
--

LOCK TABLES `e_prof` WRITE;
/*!40000 ALTER TABLE `e_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_professeur`
--

LOCK TABLES `e_professeur` WRITE;
/*!40000 ALTER TABLE `e_professeur` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_professeur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_profmatens`
--

LOCK TABLES `e_profmatens` WRITE;
/*!40000 ALTER TABLE `e_profmatens` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_profmatens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_reduction`
--

LOCK TABLES `e_reduction` WRITE;
/*!40000 ALTER TABLE `e_reduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_reduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_reg_prof`
--

LOCK TABLES `e_reg_prof` WRITE;
/*!40000 ALTER TABLE `e_reg_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_reg_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_reglement`
--

LOCK TABLES `e_reglement` WRITE;
/*!40000 ALTER TABLE `e_reglement` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_reglement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_retenue_prof`
--

LOCK TABLES `e_retenue_prof` WRITE;
/*!40000 ALTER TABLE `e_retenue_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_retenue_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_service`
--

LOCK TABLES `e_service` WRITE;
/*!40000 ALTER TABLE `e_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_service_e_filiere`
--

LOCK TABLES `e_service_e_filiere` WRITE;
/*!40000 ALTER TABLE `e_service_e_filiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_service_e_filiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_sms`
--

LOCK TABLES `e_sms` WRITE;
/*!40000 ALTER TABLE `e_sms` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_sms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_sms_e_eleve`
--

LOCK TABLES `e_sms_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_sms_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_sms_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_sstage`
--

LOCK TABLES `e_sstage` WRITE;
/*!40000 ALTER TABLE `e_sstage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_sstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_sstgeel`
--

LOCK TABLES `e_sstgeel` WRITE;
/*!40000 ALTER TABLE `e_sstgeel` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_sstgeel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_stage`
--

LOCK TABLES `e_stage` WRITE;
/*!40000 ALTER TABLE `e_stage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_stage_e_inscription`
--

LOCK TABLES `e_stage_e_inscription` WRITE;
/*!40000 ALTER TABLE `e_stage_e_inscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_stage_e_inscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_status`
--

LOCK TABLES `e_status` WRITE;
/*!40000 ALTER TABLE `e_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_tabscence`
--

LOCK TABLES `e_tabscence` WRITE;
/*!40000 ALTER TABLE `e_tabscence` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_tabscence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_tachestge`
--

LOCK TABLES `e_tachestge` WRITE;
/*!40000 ALTER TABLE `e_tachestge` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_tachestge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_th_cours`
--

LOCK TABLES `e_th_cours` WRITE;
/*!40000 ALTER TABLE `e_th_cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_th_cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_unite_ens`
--

LOCK TABLES `e_unite_ens` WRITE;
/*!40000 ALTER TABLE `e_unite_ens` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_unite_ens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_visite`
--

LOCK TABLES `e_visite` WRITE;
/*!40000 ALTER TABLE `e_visite` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_visite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `e_zview_bul`
--

LOCK TABLES `e_zview_bul` WRITE;
/*!40000 ALTER TABLE `e_zview_bul` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_zview_bul` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `email_copies`
--

LOCK TABLES `email_copies` WRITE;
/*!40000 ALTER TABLE `email_copies` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `email_piecesjointes`
--

LOCK TABLES `email_piecesjointes` WRITE;
/*!40000 ALTER TABLE `email_piecesjointes` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_piecesjointes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `k_email`
--

LOCK TABLES `k_email` WRITE;
/*!40000 ALTER TABLE `k_email` DISABLE KEYS */;
/*!40000 ALTER TABLE `k_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `k_terme`
--

LOCK TABLES `k_terme` WRITE;
/*!40000 ALTER TABLE `k_terme` DISABLE KEYS */;
INSERT INTO `k_terme` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'IDENTIFIANT','KEY',1,0),(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Identifiant','Key',1,0),(3,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'IDENTIFIANT DU MENU','KEY MENU',1,0);
/*!40000 ALTER TABLE `k_terme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `liplafor_empl`
--

LOCK TABLES `liplafor_empl` WRITE;
/*!40000 ALTER TABLE `liplafor_empl` DISABLE KEYS */;
/*!40000 ALTER TABLE `liplafor_empl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `liplafor_form`
--

LOCK TABLES `liplafor_form` WRITE;
/*!40000 ALTER TABLE `liplafor_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `liplafor_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `m_action`
--

LOCK TABLES `m_action` WRITE;
/*!40000 ALTER TABLE `m_action` DISABLE KEYS */;
INSERT INTO `m_action` VALUES ('MENU_ACT',123,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Employe',0,'glyphicon glyphicon-user','Employé','',NULL,0,'kerenpaie','rh_paie_1',0,'tree,form',NULL,NULL,27,NULL,NULL,0),('MENU_ACT',124,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ContratTravail',0,'glyphicon glyphicon-file','Contrats de Travail','',NULL,0,'kerenpaie','rh_paie_1_1',0,'tree,form',NULL,NULL,27,NULL,NULL,0),('MENU_ACT',125,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'AvanceSalaire',0,'glyphicon glyphicon-hand-right','Avances de salaire','',NULL,0,'kerenpaie','rh_paie_avan_1',0,'tree,form',NULL,NULL,28,NULL,NULL,0),('MENU_ACT',126,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'RemboursementAvance',0,'glyphicon glyphicon-hand-left','Remboursements avances','',NULL,0,'kerenpaie','rh_paie_avan_2',0,'tree,form',NULL,NULL,28,NULL,NULL,0),('MENU_ACT',127,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DemandePret',0,'glyphicon glyphicon-hand-right','Demandes de Prêt','',NULL,0,'kerenpaie','rh_paie_pret_1',0,'tree,form',NULL,NULL,29,NULL,NULL,0),('MENU_ACT',128,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'RemboursementPret',0,'glyphicon glyphicon-hand-left','Remboursements de Prêts','',NULL,0,'kerenpaie','rh_paie_pret_2',0,'tree,form',NULL,NULL,29,NULL,NULL,0),('MENU_ACT',129,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CategoriePret',0,'glyphicon glyphicon-th','Catégorie de Prêt','',NULL,0,'kerenpaie','rh_paie_pret_3',0,'tree,form',NULL,NULL,29,NULL,NULL,0),('MENU_ACT',130,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Acompte',0,'glyphicon glyphicon-th','Acomptes de salaire','',NULL,0,'kerenpaie','rh_paie_acomp_1',0,'tree,form',NULL,NULL,30,NULL,NULL,0),('MENU_ACT',131,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Rappel',0,'glyphicon glyphicon-th','Rappels de salaire','',NULL,0,'kerenpaie','rh_paie_acomp_2',0,'tree,form',NULL,NULL,30,NULL,NULL,0),('MENU_ACT',132,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ElementSalaire',0,'glyphicon glyphicon-unchecked','Eléments Salaires','',NULL,0,'kerenpaie','rh_paie_2_1',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',133,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PeriodePaieOpen',0,'glyphicon glyphicon-th','Ouvrir une periode','',NULL,1,'kerenpaie','rh_paie_2',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',134,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PrepaSalaire',0,'glyphicon glyphicon-th','Préparation des salaires','rh_paie_5_2',NULL,1,'kerenpaie','rh_paie_4',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',135,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TraitSalaire',0,'glyphicon glyphicon-th','Traitement des salaires','rh_paie_5_2',NULL,1,'kerenpaie','rh_paie_5_1',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',136,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BulletinPaie',1,'glyphicon glyphicon-th','Salaires','',NULL,0,'kerenpaie','rh_paie_5_2',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',137,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ValiderSalaire',0,'glyphicon glyphicon-edit','Validation des salaires','',NULL,1,'kerenpaie','rh_paie_6',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',138,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ValiderSalaire',0,' glyphicon glyphicon-download-alt','Transfert Comptabilité','',NULL,1,'kerenpaie','rh_paie_6_1',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',139,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PeriodePaieClose',0,'icon icon-envelope','Fermer une periode','',NULL,1,'kerenpaie','rh_paie_3',0,'tree,form',NULL,NULL,31,NULL,NULL,0),('MENU_ACT',140,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Convension',0,'glyphicon glyphicon-th','Grille de salaire','',NULL,0,'kerenpaie','rh_paie_9',0,'tree,form',NULL,NULL,32,NULL,NULL,0),('MENU_ACT',141,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'IndiceSolde',0,'glyphicon glyphicon-th','Indices de solde','',NULL,0,'kerenpaie','rh_paie_9_1',0,'tree,form',NULL,NULL,32,NULL,NULL,0),('MENU_ACT',142,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ProfilPaie',0,'glyphicon glyphicon-th','Profils de paie','',NULL,0,'kerenpaie','rh_paie_10',0,'tree,form',NULL,NULL,32,NULL,NULL,0),('MENU_ACT',143,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Rubrique',0,'glyphicon glyphicon-th','Rubriques de paie','',NULL,0,'kerenpaie','rh_paie_11',0,'tree,form',NULL,NULL,32,NULL,NULL,0),('MENU_ACT',144,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Variable',0,'glyphicon glyphicon-th','Variables de paie','',NULL,0,'kerenpaie','rh_paie_12',0,'tree,form',NULL,NULL,32,NULL,NULL,0),('MENU_ACT',145,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ParametreAvance',0,'glyphicon glyphicon-cog',' Parametrages avancés','',NULL,0,'kerenpaie','rh_paie_13',0,'tree,form',NULL,NULL,32,NULL,NULL,0),('MENU_ACT',146,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Societe',0,'glyphicon glyphicon-book','Dossier de paie','',NULL,0,'kerenpaie','rh_paie_14',0,'tree,form',NULL,NULL,33,NULL,NULL,0),('MENU_ACT',147,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ExerciceComptable',0,'glyphicon glyphicon-calendar','Exercices','',NULL,0,'kerenpaie','rh_paie_15',0,'tree,form',NULL,NULL,33,NULL,NULL,0),('MENU_ACT',148,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PeriodePaie',0,'glyphicon glyphicon-calendar','Periodes ','',NULL,0,'kerenpaie','rh_paie_16',0,'tree,form',NULL,NULL,33,NULL,NULL,0),('MENU_ACT',149,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Trimestre',0,'glyphicon glyphicon-calendar','Trimestres','',NULL,0,'kerenpaie','rh_paie_17',0,'tree,form',NULL,NULL,33,NULL,NULL,0),('MENU_ACT',150,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BPaie',0,'glyphicon glyphicon-list-alt','Bulletin de Paie','',NULL,1,'kerenpaie','rh_paie_rapport_0',0,'tree,form',NULL,NULL,34,NULL,NULL,0),('MENU_ACT',151,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'LivrePaie',0,'glyphicon glyphicon-list-alt','Livre de Paie','',NULL,1,'kerenpaie','rh_paie_rapport_1',0,'tree,form',NULL,NULL,34,NULL,NULL,0),('MENU_ACT',152,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewBulletinPaie',0,'glyphicon glyphicon-book','Dipe ','',NULL,1,'kerenpaie','rh_paie_rapport_2',0,'tree,form',NULL,NULL,34,NULL,NULL,0),('MENU_ACT',153,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewDipePaie',0,'glyphicon glyphicon-qrcode','Generer le Dipe Magnetique','',NULL,1,'kerenpaie','rh_paie_rapport_3',0,'tree,form',NULL,NULL,34,NULL,NULL,0),('MENU_ACT',154,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewBulletinPaie',0,'glyphicon glyphicon-list-alt','Brouillard de paie','',NULL,1,'kerenpaie','rh_paie_rapport_4',0,'tree,form',NULL,NULL,34,NULL,NULL,0),('MENU_ACT',155,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewBulletinPaie',0,'glyphicon glyphicon-list-alt','Etat des cotisations','',NULL,1,'kerenpaie','rh_paie_rapport_5',0,'tree,form',NULL,NULL,34,NULL,NULL,0),('MENU_ACT',156,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Compte',0,'glyphicon glyphicon-th','Plan comptable','',NULL,0,'kerenpaie','rh_paie_18',0,'tree,form',NULL,NULL,35,NULL,NULL,0),('MENU_ACT',157,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CompteAnalytique',0,'glyphicon glyphicon-th','Plan Analytique','',NULL,0,'teratechachat','rh_paie_19',0,'tree,form',NULL,NULL,35,NULL,NULL,0),('MENU_ACT',158,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Taxe',0,'glyphicon glyphicon-th','Taxes','',NULL,0,'kerenpaie','rh_paie_20',0,'tree,form',NULL,NULL,35,NULL,NULL,0),('MENU_ACT',159,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Societe',0,' icon-home','Structure','',NULL,0,'kerenpaie','rh_paie_21',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',160,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Syndicat',0,'icon icon-group','Syndicat','',NULL,0,'kerenpaie','rh_paie_21_1',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',161,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TypeContrat',0,'glyphicon glyphicon-file','Type Contract','',NULL,0,'kerenpaie','rh_paie_22',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',162,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TypeCaisse',0,'glyphicon glyphicon-th','Type Caisse','',NULL,0,'kerenpaie','rh_paie_22_1',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',163,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Categorie',0,'glyphicon glyphicon-th','Catégorie','',NULL,0,'kerenpaie','rh_paie_23',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',164,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Echelon',0,'glyphicon glyphicon-th','Echélon','',NULL,0,'kerenpaie','rh_paie_24',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',165,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DepartementSoc',0,'glyphicon glyphicon-th','Structure entreprise','',NULL,0,'kerenpaie','rh_paie_25',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',166,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DConge',0,'glyphicon glyphicon-th','Organigramme','',NULL,0,'kerenpaie','rh_paie_26',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',167,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Departement',0,'glyphicon glyphicon-th','Département administatif','',NULL,0,'kerenpaie','rh_paie_27',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',168,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Poste',0,'glyphicon glyphicon-th','Postes','',NULL,0,'kerenpaie','rh_paie_28',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',169,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Fonction',0,'glyphicon glyphicon-th','Fonctions','',NULL,0,'kerenpaie','rh_paie_29',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',170,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NiveauEtude',0,'glyphicon glyphicon-th','niveau d\'etude','',NULL,0,'kerenpaie','rh_paie_30',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',171,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Specialite',0,'glyphicon glyphicon-th','Spécialités','',NULL,0,'kerenpaie','rh_paie_31',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',172,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Diplome',0,'glyphicon glyphicon-th','Diplômes','',NULL,0,'kerenpaie','rh_paie_32',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',173,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Region',0,'glyphicon glyphicon-th','Regions','',NULL,0,'kerenpaie','rh_paie_33',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',174,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DepartementSoc',0,'glyphicon glyphicon-th','Departement','',NULL,0,'kerenpaie','rh_paie_34',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',175,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Pays',0,'glyphicon glyphicon-th','Pays','',NULL,0,'kerenpaie','rh_paie_35',0,'tree,form',NULL,NULL,36,NULL,NULL,0),('MENU_ACT',176,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'AEAEA',0,'','ADD','','',NULL,'DSDS','AZER',0,'',NULL,NULL,NULL,NULL,NULL,0),('MENU_ACT',199,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ExprBesion',0,'glyphicon glyphicon-th','Demandes d\'achat','',NULL,0,'teratechachat','teratech_achat_bes_1',0,'tree,form',NULL,NULL,43,NULL,NULL,0),('MENU_ACT',200,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'AppelOffre',0,'glyphicon glyphicon-th','Appels d\'offres','',NULL,0,'teratechachat','teratech_achat_ope_1',0,'tree,form',NULL,NULL,44,NULL,NULL,0),('MENU_ACT',201,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DemandePrix',0,'glyphicon glyphicon-th','Demande de prix','',NULL,0,'teratechachat','teratech_achat_ope_2',0,'tree,form',NULL,NULL,44,NULL,NULL,0),('MENU_ACT',202,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BonCommande',0,'glyphicon glyphicon-th','Bon de commande','',NULL,0,'teratechachat','teratech_achat_ope_5',0,'tree,form',NULL,NULL,44,NULL,NULL,0),('MENU_ACT',203,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BonReception',0,'glyphicon glyphicon-th','Bon de reception','',NULL,0,'teratechachat','teratech_achat_ope_6',0,'tree,form',NULL,NULL,44,NULL,NULL,0),('MENU_ACT',204,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Facture',0,'glyphicon glyphicon-th','Sur facture brouillon','',NULL,0,'teratechachat','teratech_achat_fac_1',0,'tree,form',NULL,NULL,45,NULL,NULL,0),('MENU_ACT',205,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BonCommande',0,'glyphicon glyphicon-th','Sur ligne de commande','',NULL,0,'teratechachat','teratech_achat_fac_2',0,'tree,form',NULL,NULL,45,NULL,NULL,0),('MENU_ACT',206,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Article',0,'glyphicon glyphicon-th','Articles.','',NULL,0,'teratechachat','teratech_achat_str_1',0,'tree,form',NULL,NULL,46,NULL,NULL,0),('MENU_ACT',207,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'FamilleArticle',0,'glyphicon glyphicon-th','Familles. Articles','',NULL,0,'teratechachat','teratech_achat_str_2',0,'tree,form',NULL,NULL,46,NULL,NULL,0),('MENU_ACT',208,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Compte',0,'glyphicon glyphicon-th','Plan. comptable.','',NULL,0,'teratechachat','teratech_achat_com_1',0,'tree,form',NULL,NULL,47,NULL,NULL,0),('MENU_ACT',209,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Tier',0,'glyphicon glyphicon-th','Fournisseur.','',NULL,0,'teratechachat','teratech_achat_com_2',0,'tree,form',NULL,NULL,47,NULL,NULL,0),('MENU_ACT',210,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CompteAnalytique',0,'glyphicon glyphicon-th','Plan Analytique..','',NULL,0,'teratechachat','teratech_achat_com_3',0,'tree,form',NULL,NULL,47,NULL,NULL,0),('MENU_ACT',211,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'JournalComptable',0,'glyphicon glyphicon-th','Journal comptable.','',NULL,0,'teratechachat','teratech_achat_com_4',0,'tree,form',NULL,NULL,47,NULL,NULL,0),('MENU_ACT',212,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Taxe',0,'glyphicon glyphicon-th','Taxes..','',NULL,0,'teratechachat','teratech_achat_com_5',0,'tree,form',NULL,NULL,47,NULL,NULL,0),('MENU_ACT',213,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Entrepot',0,'glyphicon glyphicon-th','Entrepôts.','',NULL,0,'teratechachat','teratech_achat_conf_1',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',214,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Emplacement',0,'glyphicon glyphicon-th','Emplacements.','',NULL,0,'teratechachat','teratech_achat_conf_2',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',215,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'UniteGestion',0,'glyphicon glyphicon-th','Unité de gestion.','',NULL,0,'teratechachat','teratech_achat_conf_3',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',216,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'UniteAchat',0,'glyphicon glyphicon-th','Unité d\'achat.','',NULL,0,'teratechachat','teratech_achat_conf_4',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',217,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CategorieProduit',0,'glyphicon glyphicon-th','Catégorie de produit.','',NULL,0,'teratechachat','teratech_achat_conf_5',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',218,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Region',0,'glyphicon glyphicon-th','Régions ..','',NULL,0,'teratechachat','teratech_achat_conf_6',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',219,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Pays',0,'glyphicon glyphicon-th','Pays..','',NULL,0,'teratechachat','teratech_achat_conf_7',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',220,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Civilite',0,'glyphicon glyphicon-th','Civilité ..','',NULL,0,'teratechachat','teratech_achat_conf_8',0,'tree,form',NULL,NULL,48,NULL,NULL,0),('MENU_ACT',221,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Employe',0,'glyphicon glyphicon-th','Employé','',NULL,0,'kerenrh','rh_admin_1',0,'tree,form',NULL,NULL,49,NULL,NULL,0),('MENU_ACT',222,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DemandeConge',0,'glyphicon glyphicon-th','Demande de congé','',NULL,0,'kerenrh','rh_admin_2',0,'calendar,tree,form',NULL,NULL,50,NULL,NULL,0),('MENU_ACT',223,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DemandeCongeC',0,'glyphicon glyphicon-th','Validation demande de congé','',NULL,0,'kerenrh','rh_admin_3',0,'tree,form',NULL,NULL,50,NULL,NULL,0),('MENU_ACT',224,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'RepriseService',0,'glyphicon glyphicon-th','Reprise de service','',NULL,0,'kerenrh','rh_admin_4',0,'tree,form',NULL,NULL,50,NULL,NULL,0),('MENU_ACT',225,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'InterruptionConge',0,'glyphicon glyphicon-th','Interruption de congé','',NULL,0,'kerenrh','rh_admin_5',0,'tree,form',NULL,NULL,50,NULL,NULL,0),('MENU_ACT',226,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'FichePointage',0,'glyphicon glyphicon-th','Fiche de pointage','',NULL,0,'kerenrh','rh_admin_6_1',0,'tree,form',NULL,NULL,51,NULL,NULL,0),('MENU_ACT',227,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PointageJouranlier',0,'glyphicon glyphicon-th','Pointage journalier','',NULL,0,'kerenrh','rh_admin_6',0,'calendar,tree,form',NULL,NULL,51,NULL,NULL,0),('MENU_ACT',228,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Absence',0,'glyphicon glyphicon-th','Gérer les absences','',NULL,0,'kerenrh','rh_admin_7',0,'tree,form',NULL,NULL,51,NULL,NULL,0),('MENU_ACT',229,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Retard',0,'glyphicon glyphicon-th','Gérer les retards','',NULL,0,'kerenrh','rh_admin_8',0,'tree,form',NULL,NULL,51,NULL,NULL,0),('MENU_ACT',230,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DemandeExplication',0,'glyphicon glyphicon-th','Demande d\'explication','',NULL,0,'kerenrh','rh_admin_9',0,'tree,form',NULL,NULL,52,NULL,NULL,0),('MENU_ACT',231,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ReponseDE',0,'glyphicon glyphicon-th','Reponse à une DE','',NULL,0,'kerenrh','rh_admin_10',0,'tree,form',NULL,NULL,52,NULL,NULL,0),('MENU_ACT',232,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TraitementDE',0,'glyphicon glyphicon-th','Traiter une DE','',NULL,0,'kerenrh','rh_admin_11',0,'tree,form',NULL,NULL,52,NULL,NULL,0),('MENU_ACT',233,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ConvocationConseil',0,'glyphicon glyphicon-th','Convocation du conseil','',NULL,0,'kerenrh','rh_admin_12',0,'tree,form',NULL,NULL,52,NULL,NULL,0),('MENU_ACT',234,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ResolutionConseil',0,'glyphicon glyphicon-th','Résolution du conseil','',NULL,0,'kerenrh','rh_admin_13',0,'tree,form',NULL,NULL,52,NULL,NULL,0),('MENU_ACT',235,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Sanction',0,'glyphicon glyphicon-th','Sanctions','',NULL,0,'kerenrh','rh_admin_14',0,'tree,form',NULL,NULL,52,NULL,NULL,0),('MENU_ACT',236,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Avancement',0,'glyphicon glyphicon-th','Avancement ','',NULL,0,'kerenrh','rh_carriere_1',0,'tree,form',NULL,NULL,53,NULL,NULL,0),('MENU_ACT',237,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Reclassement',0,'glyphicon glyphicon-th','Reclassements','',NULL,0,'kerenrh','rh_carriere_2',0,'tree,form',NULL,NULL,53,NULL,NULL,0),('MENU_ACT',238,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Bonification',0,'glyphicon glyphicon-th','Bonification d\'échelon','',NULL,0,'kerenrh','rh_carriere_3',0,'tree,form',NULL,NULL,53,NULL,NULL,0),('MENU_ACT',239,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Retrogradation',0,'glyphicon glyphicon-th','Retrogration ','',NULL,0,'kerenrh','rh_carriere_4',0,'tree,form',NULL,NULL,53,NULL,NULL,0),('MENU_ACT',240,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Affectation',0,'glyphicon glyphicon-th','Affectations','',NULL,0,'kerenrh','rh_carriere_5',0,'tree,form',NULL,NULL,53,NULL,NULL,0),('MENU_ACT',241,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Cessation',0,'glyphicon glyphicon-th','Cessation de Travail','',NULL,0,'kerenrh','rh_carriere_6',0,'tree,form',NULL,NULL,53,NULL,NULL,0),('MENU_ACT',242,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Nomination',0,'glyphicon glyphicon-th','Nominations','',NULL,0,'kerenrh','rh_carriere_7',0,'tree,form',NULL,NULL,53,NULL,NULL,0),('MENU_ACT',243,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Mission',0,'glyphicon glyphicon-th','Missions','',NULL,0,'kerenrh','rh_mission_1',0,'tree,form',NULL,NULL,54,NULL,NULL,0),('MENU_ACT',244,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'OrdreMission',0,'glyphicon glyphicon-th','Ordre de Mission','',NULL,0,'kerenrh','rh_mission_2',0,'tree,form',NULL,NULL,54,NULL,NULL,0),('MENU_ACT',245,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ResultatMission',0,'glyphicon glyphicon-th','Résultat Mission','',NULL,0,'kerenrh','rh_mission_3',0,'tree,form',NULL,NULL,54,NULL,NULL,0),('MENU_ACT',246,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CategorieFrais',0,'glyphicon glyphicon-th','Type de dépenses','',NULL,0,'kerenrh','rh_mission_4',0,'tree,form',NULL,NULL,54,NULL,NULL,0),('MENU_ACT',247,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CategorieMission',0,'glyphicon glyphicon-th','Type de Missions','',NULL,0,'kerenrh','rh_mission_5',0,'tree,form',NULL,NULL,54,NULL,NULL,0),('MENU_ACT',248,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DemandeFormation',0,'glyphicon glyphicon-th','Demande de Formation','',NULL,0,'kerenrh','rh_formation_1',0,'tree,form',NULL,NULL,55,NULL,NULL,0),('MENU_ACT',249,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'GenererBesionFormation',0,'glyphicon glyphicon-th','Generer un BF','',NULL,1,'kerenrh','rh_formation_2',0,'tree,form',NULL,NULL,55,NULL,NULL,0),('MENU_ACT',250,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BesionFormation',0,'glyphicon glyphicon-th','Besion de Formation','',NULL,0,'kerenrh','rh_formation_3',0,'tree,form',NULL,NULL,55,NULL,NULL,0),('MENU_ACT',251,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PlanningFormation',0,'glyphicon glyphicon-th','Plannings','',NULL,0,'kerenrh','rh_formation_4',0,'tree,form',NULL,NULL,55,NULL,NULL,0),('MENU_ACT',252,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'LignePlanningFormation',0,'glyphicon glyphicon-th','Plans','',NULL,0,'kerenrh','rh_formation_5',0,'tree,form',NULL,NULL,55,NULL,NULL,0),('MENU_ACT',253,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Formation',0,'glyphicon glyphicon-th','Formations','',NULL,0,'kerenrh','rh_formation_6',0,'tree,form',NULL,NULL,55,NULL,NULL,0),('MENU_ACT',254,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SeanceFormation',0,'glyphicon glyphicon-th','Suivis Formation','',NULL,0,'kerenrh','rh_formation_7',0,'tree,form',NULL,NULL,55,NULL,NULL,0),('MENU_ACT',255,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Emploi',0,'glyphicon glyphicon-th','Emploi','',NULL,0,'kerenrh','rh_recrutement_1',0,'tree,form',NULL,NULL,56,NULL,NULL,0),('MENU_ACT',256,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BesionRecrutement',0,'glyphicon glyphicon-th','Expression du Besion','',NULL,0,'kerenrh','rh_recrutement_2',0,'tree,form',NULL,NULL,56,NULL,NULL,0),('MENU_ACT',257,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CandidatureSpontane',0,'glyphicon glyphicon-th','Candidatures ','',NULL,0,'kerenrh','rh_recrutement_3',0,'tree,form',NULL,NULL,56,NULL,NULL,0),('MENU_ACT',258,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'AffectationCandidat',0,'glyphicon glyphicon-th','Associer une candidature','',NULL,0,'kerenrh','rh_recrutement_4',0,'tree,form',NULL,NULL,56,NULL,NULL,0),('MENU_ACT',259,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Recrutement',0,'glyphicon glyphicon-th','Suivi du recrutement','',NULL,0,'kerenrh','rh_recrutement_5',0,'tree,form',NULL,NULL,56,NULL,NULL,0),('MENU_ACT',260,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ContratTravail',0,'glyphicon glyphicon-th','Contrats de Travail','',NULL,0,'kerenrh','rh_recrutement_6',0,'tree,form',NULL,NULL,56,NULL,NULL,0),('MENU_ACT',261,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'EtapeRecrutement',0,'glyphicon glyphicon-th','Etapes Recrutement','',NULL,0,'kerenrh','rh_recrutement_7',0,'tree,form',NULL,NULL,56,NULL,NULL,0),('MENU_ACT',262,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BesionStage',0,'glyphicon glyphicon-th','Besion en Stage','',NULL,0,'kerenrh','rh_stage_1',0,'tree,form',NULL,NULL,57,NULL,NULL,0),('MENU_ACT',263,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Stage',0,'glyphicon glyphicon-th','Stages','',NULL,0,'kerenrh','rh_stage_2',0,'tree,form',NULL,NULL,57,NULL,NULL,0),('MENU_ACT',264,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SuiviStage',0,'glyphicon glyphicon-th','Suivi de Stage','',NULL,0,'kerenrh','rh_stage_3',0,'tree,form',NULL,NULL,57,NULL,NULL,0),('MENU_ACT',265,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Societe',0,'glyphicon glyphicon-th','Structure','',NULL,0,'kerenrh','rh_admin_16_1',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',266,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TypeDemande',0,'glyphicon glyphicon-th','Type Demande','',NULL,0,'kerenrh','rh_admin_15',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',267,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TypeContrat',0,'glyphicon glyphicon-th','Type Contract','',NULL,0,'kerenrh','rh_admin_16',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',268,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Categorie',0,'glyphicon glyphicon-th','Catégorie','',NULL,0,'kerenrh','rh_admin_17',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',269,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Echelon',0,'glyphicon glyphicon-th','Echélon','',NULL,0,'kerenrh','rh_admin_18',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',270,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DepartementSoc',0,'glyphicon glyphicon-th','Structure entreprise','',NULL,0,'kerenrh','rh_admin_19',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',271,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'DConge',0,'glyphicon glyphicon-th','Organigramme','',NULL,0,'kerenrh','rh_admin_20',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',272,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Departement',0,'glyphicon glyphicon-th','Département Administrative','',NULL,0,'kerenrh','rh_admin_20_1',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',273,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Poste',0,'glyphicon glyphicon-th','Postes','',NULL,0,'kerenrh','rh_admin_21',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',274,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Fonction',0,'glyphicon glyphicon-th','Fonctions','',NULL,0,'kerenrh','rh_admin_22',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',275,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NiveauEtude',0,'glyphicon glyphicon-th','niveau d\'etude','',NULL,0,'kerenrh','rh_admin_23',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',276,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Specialite',0,'glyphicon glyphicon-th','Spécialités','',NULL,0,'kerenrh','rh_admin_24',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',277,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Diplome',0,'glyphicon glyphicon-th','Diplômes','',NULL,0,'kerenrh','rh_admin_25',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',278,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Region',0,'glyphicon glyphicon-th','Regions','',NULL,0,'kerenrh','rh_admin_26',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',279,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Departement',0,'glyphicon glyphicon-th','Departement','',NULL,0,'kerenrh','rh_admin_27',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',280,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Pays',0,'glyphicon glyphicon-th','Pays','',NULL,0,'kerenrh','rh_admin_28',0,'tree,form',NULL,NULL,58,NULL,NULL,0),('MENU_ACT',281,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ComptaDashboard',0,'glyphicon glyphicon-th','Tableau de bord','','solde',0,'baseaccount','base_account_dashboard_01',0,'dashboard',NULL,NULL,59,NULL,NULL,0),('MENU_ACT',282,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Facture',0,'glyphicon glyphicon-th','Factures fournisseurs','',NULL,0,'baseaccount','base_account_ach02',0,'tree,form',NULL,NULL,61,NULL,NULL,0),('MENU_ACT',283,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'FactureFournisseur',0,'glyphicon glyphicon-th','Avoirs fournisseurs','',NULL,0,'baseaccount','base_account_ach03',0,'tree,form',NULL,NULL,61,NULL,NULL,0),('MENU_ACT',284,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NoteFrais',0,'glyphicon glyphicon-th','Recus d\'achat','',NULL,0,'baseaccount','base_account_ach04',0,'tree,form',NULL,NULL,61,NULL,NULL,0),('MENU_ACT',285,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ReglementFournisseur',0,'glyphicon glyphicon-th','Paiements fournisseurs','',NULL,0,'baseaccount','base_account_ach05',0,'tree,form',NULL,NULL,61,NULL,NULL,0),('MENU_ACT',286,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PieceComptable',0,'glyphicon glyphicon-th','Pièces Comptable','',NULL,0,'baseaccount','base_account_10',0,'tree,form',NULL,NULL,62,NULL,NULL,0),('MENU_ACT',287,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PieceComptable',0,'glyphicon glyphicon-th','Ecritures à vérifier','',NULL,0,'baseaccount','base_account_10_1',0,'tree,form',NULL,NULL,62,NULL,NULL,0),('MENU_ACT',288,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'JournalSaisie',0,'glyphicon glyphicon-list-alt','Journaux de saisie','',NULL,0,'baseaccount','base_account_14',0,'tree,form',NULL,NULL,62,NULL,NULL,0),('MENU_ACT',289,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'EcritureAnalytique',0,'glyphicon glyphicon-list-alt','Interrogation analytique','',NULL,0,'baseaccount','base_account_15',0,'tree,form',NULL,NULL,62,NULL,NULL,0),('MENU_ACT',290,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'EcritureTier',0,'glyphicon glyphicon-list-alt','Interrogation tier','',NULL,0,'baseaccount','base_account_16',0,'tree,form',NULL,NULL,62,NULL,NULL,0),('MENU_ACT',291,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Compte',0,'glyphicon glyphicon-th','Plan Comptable','',NULL,0,'baseaccount','base_account_01',0,'tree,form',NULL,NULL,63,NULL,NULL,0),('ITEM_ACT',292,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0,NULL,'Action 1',NULL,NULL,0,NULL,'plc_01',0,'tree,form','action','{\'name\':\'update_pwd\'}',NULL,NULL,291,0),('ITEM_ACT',293,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0,NULL,'Action 2',NULL,NULL,0,NULL,'plc_02',0,'tree,form','object','{\'model\':\'email\',\'entity\':\'mail\',\'method\':\'sendmail\',\'template\':{\'object\':\'Modification de mot de passe\',\'source\':\'user.courriel\',\'cible\':\'object.courriel\',\'message\':\'Votre mot de passe est @object.password\'}}',NULL,NULL,291,0),('MENU_ACT',294,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CompteAnalytique',0,'glyphicon glyphicon-th-list','Plan Analytique','',NULL,0,'baseaccount','base_account_02',0,'tree,form',NULL,NULL,63,NULL,NULL,0),('MENU_ACT',295,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Taxe',0,'glyphicon glyphicon-minus','Taux Taxes','',NULL,0,'baseaccount','base_account_03',0,'tree,form',NULL,NULL,63,NULL,NULL,0),('MENU_ACT',296,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'JournalComptable',0,'glyphicon glyphicon-list-alt','Code Journaux','',NULL,0,'baseaccount','base_account_04',0,'tree,form',NULL,NULL,63,NULL,NULL,0),('MENU_ACT',297,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Tier',0,'glyphicon glyphicon-user','Plan tiers','',NULL,0,'baseaccount','base_account_06',0,'tree,form',NULL,NULL,64,NULL,NULL,0),('MENU_ACT',298,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Banque',0,'glyphicon glyphicon-user','Banques','',NULL,0,'baseaccount','base_account_07',0,'tree,form',NULL,NULL,65,NULL,NULL,0),('MENU_ACT',299,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ExerciceComptable',0,'glyphicon glyphicon-list-alt','Exercices Comptable','',NULL,0,'baseaccount','base_account_12',0,'tree,form',NULL,NULL,66,NULL,NULL,0),('MENU_ACT',300,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ClotureExerciceComptable',0,'glyphicon glyphicon-list-alt','Cloture Exercice','',NULL,1,'baseaccount','base_account_17',0,'tree,form',NULL,NULL,66,NULL,NULL,0),('MENU_ACT',301,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ClotureJournal',0,'glyphicon glyphicon-list-alt','Cloture des Journaux','',NULL,1,'baseaccount','base_account_18',0,'tree,form',NULL,NULL,66,NULL,NULL,0);
/*!40000 ALTER TABLE `m_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `m_agroup`
--

LOCK TABLES `m_agroup` WRITE;
/*!40000 ALTER TABLE `m_agroup` DISABLE KEYS */;
INSERT INTO `m_agroup` VALUES (27,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-user','Employés','rh_paie_employe',0,1,5,0),(28,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-modal-window','Avances et rembousements','rh_paie_avance',0,1,5,0),(29,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-link','Prêts et rembousements','rh_paie_pret',0,1,5,0),(30,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Acomptes et Rappels','rh_paie_acomp',0,1,5,0),(31,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-folder-open','Administration de la paie','rh_paie_salaire',0,1,5,0),(32,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-scale','Elements de salaire','rh_paie_element',0,1,5,0),(33,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'icon icon-shopping-cart',' Parametrage de la paie','rh_paie_param',0,1,5,0),(34,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-eye-open','Rapports','rh_paie_rapport',0,1,5,0),(35,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-retweet','Comptabilité','rh_paie_compta',0,1,5,0),(36,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'icon icon-wrench','Configurations','rh_paie_config',0,1,5,0),(43,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Expression des besions','teratech_achat_besion',0,1,1,0),(44,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Opérations d\'achat','teratech_achat_operation',0,1,1,0),(45,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Contrôle facturation','teratech_achat_facturation',0,1,1,0),(46,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Structures.','teratech_achat_structure',0,1,1,0),(47,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Comptabilité..','teratech_achat_comptabilite',0,1,1,0),(48,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Configuration.','teratech_achat_configuration',0,1,1,0),(49,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-user','Employés','rh_admin_employe',0,1,4,0),(50,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-th','gestion des congés','rh_admin_conge',0,1,4,0),(51,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-dashboard','Gestion des présences','rh_admin_presence',0,1,4,0),(52,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Gestion de la discipline','rh_admin_discipline',0,1,4,0),(53,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-warning-sign','Gestion des Carrières','rh_admin_carriere',0,1,4,0),(54,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-cog','Gestion des Missions','rh_admin_mission',0,1,4,0),(55,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-cog','Gestion de la formation','rh_admin_formation',0,1,4,0),(56,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-cog','Gestion des Recrutements','rh_admin_recrutement',0,1,4,0),(57,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-cog','Gestion des Stages','rh_admin_stages',0,1,4,0),(58,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-cog','Configurations','rh_admin_config',0,1,4,0),(59,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-scale','Tableaux de bord','base_account_dashboard',0,1,2,0),(60,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Ventes','base_account_ventes',0,1,2,0),(61,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Achats','base_account_achats',0,1,2,0),(62,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-pencil','Opérations','base_account_operations',0,1,2,0),(63,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-plus','Comptabilité','base_account_compta',0,1,2,0),(64,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-user','Plan Tiers','base_account_tiers',0,1,2,0),(65,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-bank','Banques','base_account_banques',0,1,2,0),(66,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'glyphicon glyphicon-bank','Fin Exercices','base_account_exercice',0,1,2,0);
/*!40000 ALTER TABLE `m_agroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `m_module`
--

LOCK TABLES `m_module` WRITE;
/*!40000 ALTER TABLE `m_module` DISABLE KEYS */;
INSERT INTO `m_module` VALUES (1,0,0,1,1,1,0,'Achats','APPLICATION',NULL,'APPLICATIONS','kerencore',0,NULL,1,1,1,'BKD','Accounting',NULL,1,NULL,1,'Achats','',NULL,'achats',10,'Application des Gestion des Achats(Appel d\'offre,Demande d\'achat,Commande ,Suivie des livraison)','1.0','http://www.keren.com',0),(2,0,0,0,1,1,0,'Comptabilite','APPLICATION',NULL,'APPLICATIONS','kerencore',0,NULL,1,1,1,'BKD','Accounting',NULL,1,NULL,1,'Comptabilite','',NULL,'base_account',10,'Mise en place du referentiel comptable','1.0','http://www.keren.com',0),(3,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'NTW','education',NULL,1,NULL,1,'Education','',NULL,'kereneducation',10,'Plateforme de gestion scoalaire','1.0','http://www.keren.com',0),(4,0,0,4,1,1,0,'Administration du personels','APPLICATION',NULL,'APPLICATIONS','kerencore',0,NULL,1,1,1,'BKD','Accounting',NULL,1,NULL,1,'Administration du personels','',NULL,'rhadmin',10,'Mise en place du referentiel des resources humaines','1.0','http://www.keren.com',0),(5,0,0,5,1,1,0,'Gestion de la paie','APPLICATION',NULL,'APPLICATIONS','kerencore',0,NULL,1,1,1,'BKD','Accounting',NULL,1,NULL,1,'Gestion de la paie','',NULL,'rhpaie',10,'Calcul de la paie','1.0','http://www.keren.com',0),(6,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'BKD','Accounting',NULL,1,NULL,1,'Stocks','',NULL,'stock',10,'Gestion du stock','1.0','http://www.keren.com',0);
/*!40000 ALTER TABLE `m_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_acom`
--

LOCK TABLES `t_acom` WRITE;
/*!40000 ALTER TABLE `t_acom` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_acom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_acomp`
--

LOCK TABLES `t_acomp` WRITE;
/*!40000 ALTER TABLE `t_acomp` DISABLE KEYS */;
INSERT INTO `t_acomp` VALUES (1,1,1,1,1,0,0,'0345Z - BEKONDO Kangue Dieunedort','Acompte de ',NULL,'Acomptes','kerenpaie',0,'-8106416349038340585','','2018-01-09',30000,'paye',1,1,32,0),(2,1,1,1528732012620,1,0,0,'0345Z - BEKONDO Kangue Dieunedort','Acompte de ',NULL,'Acomptes','kerenpaie',0,'-8106416349038340585','','2018-06-11',40000,'annule',NULL,1,32,0);
/*!40000 ALTER TABLE `t_acomp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_actmisrh`
--

LOCK TABLES `t_actmisrh` WRITE;
/*!40000 ALTER TABLE `t_actmisrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_actmisrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_aff_canrh`
--

LOCK TABLES `t_aff_canrh` WRITE;
/*!40000 ALTER TABLE `t_aff_canrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_aff_canrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_afferh`
--

LOCK TABLES `t_afferh` WRITE;
/*!40000 ALTER TABLE `t_afferh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_afferh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_apof`
--

LOCK TABLES `t_apof` WRITE;
/*!40000 ALTER TABLE `t_apof` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_apof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_art`
--

LOCK TABLES `t_art` WRITE;
/*!40000 ALTER TABLE `t_art` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_art` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_avancrh`
--

LOCK TABLES `t_avancrh` WRITE;
/*!40000 ALTER TABLE `t_avancrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_avancrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_avsap`
--

LOCK TABLES `t_avsap` WRITE;
/*!40000 ALTER TABLE `t_avsap` DISABLE KEYS */;
INSERT INTO `t_avsap` VALUES (1,1,1,1,1,0,0,'0345Z - BEKONDO Kangue Dieunedort','Avance du salaire',NULL,'Avances du salaire','kerenpaie',0,'2918162723049219538','','2018-01-10',4,200000,'confirme',1,4,0);
/*!40000 ALTER TABLE `t_avsap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_banque`
--

LOCK TABLES `t_banque` WRITE;
/*!40000 ALTER TABLE `t_banque` DISABLE KEYS */;
INSERT INTO `t_banque` VALUES (1,0,0,1528985739872,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'','1003','','','SGBC Cameroun',NULL,'',0);
/*!40000 ALTER TABLE `t_banque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_besformrh`
--

LOCK TABLES `t_besformrh` WRITE;
/*!40000 ALTER TABLE `t_besformrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_besformrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_besrecrh`
--

LOCK TABLES `t_besrecrh` WRITE;
/*!40000 ALTER TABLE `t_besrecrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_besrecrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_besstarh`
--

LOCK TABLES `t_besstarh` WRITE;
/*!40000 ALTER TABLE `t_besstarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_besstarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_bonifrh`
--

LOCK TABLES `t_bonifrh` WRITE;
/*!40000 ALTER TABLE `t_bonifrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_bonifrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_bupa`
--

LOCK TABLES `t_bupa` WRITE;
/*!40000 ALTER TABLE `t_bupa` DISABLE KEYS */;
INSERT INTO `t_bupa` VALUES (87,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BEKONDO Kangue Dieunedort',NULL,'etabli',1,2,0,0,0,0,21943,0,0,0,0,0,101943,0,0,360000,0,0,360000,360000,0,0,360000,0,0),(88,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BEKONDO Kangue Dieunedort',NULL,'etabli',1,3,0,0,0,0,21943,0,0,0,0,0,123886,0,0,720000,0,0,720000,360000,0,0,360000,0,0),(100,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'BEKONDO Kangue Dieunedort',NULL,'etabli',1,1,0,0,0,0,106434.3141,0,0,0,0,0,0,0,0,0,0,0,0,360000,0,0,360000,42774.42,0);
/*!40000 ALTER TABLE `t_bupa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_camodrh`
--

LOCK TABLES `t_camodrh` WRITE;
/*!40000 ALTER TABLE `t_camodrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_camodrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_canal`
--

LOCK TABLES `t_canal` WRITE;
/*!40000 ALTER TABLE `t_canal` DISABLE KEYS */;
INSERT INTO `t_canal` VALUES (1,0,0,1528704279386,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'COM','0','CANAL DE COM','','0',1,0);
/*!40000 ALTER TABLE `t_canal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_canalytique`
--

LOCK TABLES `t_canalytique` WRITE;
/*!40000 ALTER TABLE `t_canalytique` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_canalytique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cansporh`
--

LOCK TABLES `t_cansporh` WRITE;
/*!40000 ALTER TABLE `t_cansporh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cansporh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_capr`
--

LOCK TABLES `t_capr` WRITE;
/*!40000 ALTER TABLE `t_capr` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_capr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_caprp`
--

LOCK TABLES `t_caprp` WRITE;
/*!40000 ALTER TABLE `t_caprp` DISABLE KEYS */;
INSERT INTO `t_caprp` VALUES (1,0,0,1528733254846,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TYPE01',1,1,5,0);
/*!40000 ALTER TABLE `t_caprp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cat`
--

LOCK TABLES `t_cat` WRITE;
/*!40000 ALTER TABLE `t_cat` DISABLE KEYS */;
INSERT INTO `t_cat` VALUES (1,0,0,1,1,0,0,'10','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,10,'0',0),(2,0,0,2,1,0,0,'4','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,4,'2',0),(3,0,0,3,1,0,0,'5','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,5,'2',0),(4,0,0,4,1,0,0,'6','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,6,'2',0),(5,0,0,5,1,0,0,'7','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,7,'1',0),(6,0,0,6,1,0,0,'8','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,8,'1',0),(7,0,0,7,1,0,0,'9','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,9,'1',0),(8,0,0,8,1,0,0,'11','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,11,'0',0),(9,0,0,9,1,0,0,'12','Catégorie',NULL,'Catégories','kerenpaie',0,NULL,12,'0',0);
/*!40000 ALTER TABLE `t_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cat_ech`
--

LOCK TABLES `t_cat_ech` WRITE;
/*!40000 ALTER TABLE `t_cat_ech` DISABLE KEYS */;
INSERT INTO `t_cat_ech` VALUES (1,6),(1,5),(1,4),(1,3),(1,2),(1,1),(2,6),(2,5),(2,4),(2,3),(2,2),(2,1),(3,6),(3,5),(3,4),(3,3),(3,2),(3,1),(4,6),(4,5),(4,4),(4,3),(4,2),(4,1),(5,6),(5,5),(5,4),(5,3),(5,2),(5,1),(6,6),(6,5),(6,4),(6,3),(6,2),(6,1),(7,6),(7,5),(7,4),(7,3),(7,2),(7,1),(8,6),(8,5),(8,4),(8,3),(8,2),(8,1),(9,6),(9,5),(9,4),(9,3),(9,2),(9,1);
/*!40000 ALTER TABLE `t_cat_ech` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_catfrarh`
--

LOCK TABLES `t_catfrarh` WRITE;
/*!40000 ALTER TABLE `t_catfrarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_catfrarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_catmisrh`
--

LOCK TABLES `t_catmisrh` WRITE;
/*!40000 ALTER TABLE `t_catmisrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_catmisrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cbancaire`
--

LOCK TABLES `t_cbancaire` WRITE;
/*!40000 ALTER TABLE `t_cbancaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cbancaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cessarh`
--

LOCK TABLES `t_cessarh` WRITE;
/*!40000 ALTER TABLE `t_cessarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cessarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_civilite`
--

LOCK TABLES `t_civilite` WRITE;
/*!40000 ALTER TABLE `t_civilite` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_civilite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cocorh`
--

LOCK TABLES `t_cocorh` WRITE;
/*!40000 ALTER TABLE `t_cocorh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cocorh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_compte`
--

LOCK TABLES `t_compte` WRITE;
/*!40000 ALTER TABLE `t_compte` DISABLE KEYS */;
INSERT INTO `t_compte` VALUES (1,0,0,1,1,0,0,'11111 - Salaires personnels','Compte',NULL,'Plan Comptable','baseaccount',0,NULL,'11111','','Salaires personnels','','','','0',NULL,NULL,0),(2,0,0,1528192488719,1,0,0,'122234 - Nimporte quoi','Compte',NULL,'Plan Comptable','baseaccount',0,NULL,'122234','0','Nimporte quoi','1','','','0',1,NULL,0);
/*!40000 ALTER TABLE `t_compte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_comrubrp`
--

LOCK TABLES `t_comrubrp` WRITE;
/*!40000 ALTER TABLE `t_comrubrp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_comrubrp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_contact`
--

LOCK TABLES `t_contact` WRITE;
/*!40000 ALTER TABLE `t_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_conv`
--

LOCK TABLES `t_conv` WRITE;
/*!40000 ALTER TABLE `t_conv` DISABLE KEYS */;
INSERT INTO `t_conv` VALUES (1,1,1,1,1,0,0,'MGT_PAIE - Convension colleactive industrie extrative 2012','Convention collective',NULL,'Conventions collectives','kerenpaie',0,'270403082233442524','MGT_PAIE','2018-01-01','2020-12-31','Convension colleactive industrie extrative 2012','actif','2',1,0);
/*!40000 ALTER TABLE `t_conv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cotrp`
--

LOCK TABLES `t_cotrp` WRITE;
/*!40000 ALTER TABLE `t_cotrp` DISABLE KEYS */;
INSERT INTO `t_cotrp` VALUES (1,1,1,1,0,0,0,'BKD03Z','Contrat de Travail ',NULL,'Contrats de Travail ','kerenpaie',0,'4727779632422483905','BKD03Z','',NULL,'2018-01-01','2018-04-01','2018-03-31',0,NULL,'LIBREVILLE-GABON','YAOUNDE-CAMEROUN',0,'confirme',1,1,1,1,1,0);
/*!40000 ALTER TABLE `t_cotrp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_cpayment`
--

LOCK TABLES `t_cpayment` WRITE;
/*!40000 ALTER TABLE `t_cpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_de_csrh`
--

LOCK TABLES `t_de_csrh` WRITE;
/*!40000 ALTER TABLE `t_de_csrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_de_csrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_decorh`
--

LOCK TABLES `t_decorh` WRITE;
/*!40000 ALTER TABLE `t_decorh` DISABLE KEYS */;
INSERT INTO `t_decorh` VALUES (2,1,1,0,0,1,0,'0345Z - BEKONDO Kangue Dieunedort','DEMANDE DE CONGE',NULL,'DEMANDES DE CONGE','kerenrh',0,'7741105795796486143','2','2018-06-08',2,'2018-06-12',NULL,0,NULL,'valider',1,1,1,0);
/*!40000 ALTER TABLE `t_decorh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_deexrh`
--

LOCK TABLES `t_deexrh` WRITE;
/*!40000 ALTER TABLE `t_deexrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_deexrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_demforrh`
--

LOCK TABLES `t_demforrh` WRITE;
/*!40000 ALTER TABLE `t_demforrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_demforrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_dep`
--

LOCK TABLES `t_dep` WRITE;
/*!40000 ALTER TABLE `t_dep` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_deploirh`
--

LOCK TABLES `t_deploirh` WRITE;
/*!40000 ALTER TABLE `t_deploirh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_deploirh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_deprp`
--

LOCK TABLES `t_deprp` WRITE;
/*!40000 ALTER TABLE `t_deprp` DISABLE KEYS */;
INSERT INTO `t_deprp` VALUES (1,1,1,1528733251348,1,0,0,'0345Z - BEKONDO Kangue Dieunedort','Demande de Prêt',NULL,'Demandes de Prêts','kerenpaie',0,'5896264921413540741','','2018-06-11','2018-07-11',1,40000,40000,50000,'confirme',1,1,0);
/*!40000 ALTER TABLE `t_deprp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_depsoc`
--

LOCK TABLES `t_depsoc` WRITE;
/*!40000 ALTER TABLE `t_depsoc` DISABLE KEYS */;
INSERT INTO `t_depsoc` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'INFORMATIQUE','INFORMATIQUES ET TELECOMS','1',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `t_depsoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_detrecrh`
--

LOCK TABLES `t_detrecrh` WRITE;
/*!40000 ALTER TABLE `t_detrecrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_detrecrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_devise`
--

LOCK TABLES `t_devise` WRITE;
/*!40000 ALTER TABLE `t_devise` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_devise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_diplo`
--

LOCK TABLES `t_diplo` WRITE;
/*!40000 ALTER TABLE `t_diplo` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_diplo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_doac`
--

LOCK TABLES `t_doac` WRITE;
/*!40000 ALTER TABLE `t_doac` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_doac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_docba`
--

LOCK TABLES `t_docba` WRITE;
/*!40000 ALTER TABLE `t_docba` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_docba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_eche`
--

LOCK TABLES `t_eche` WRITE;
/*!40000 ALTER TABLE `t_eche` DISABLE KEYS */;
INSERT INTO `t_eche` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'E','',0),(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'A','',0),(3,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'B','',0),(4,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'C','',0),(5,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'D','',0),(6,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'F','',0);
/*!40000 ALTER TABLE `t_eche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_ecre`
--

LOCK TABLES `t_ecre` WRITE;
/*!40000 ALTER TABLE `t_ecre` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ecre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_ecrit_anal`
--

LOCK TABLES `t_ecrit_anal` WRITE;
/*!40000 ALTER TABLE `t_ecrit_anal` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ecrit_anal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_ecrit_tier`
--

LOCK TABLES `t_ecrit_tier` WRITE;
/*!40000 ALTER TABLE `t_ecrit_tier` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ecrit_tier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_ecriture`
--

LOCK TABLES `t_ecriture` WRITE;
/*!40000 ALTER TABLE `t_ecriture` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ecriture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_elsalp`
--

LOCK TABLES `t_elsalp` WRITE;
/*!40000 ALTER TABLE `t_elsalp` DISABLE KEYS */;
INSERT INTO `t_elsalp` VALUES (2,1,1,1528794239477,0,0,0,'56000 - MELANGUE Souka','Elément Variable',NULL,'Eléments Variables','kerenpaie',0,'8807082111156127699',NULL,1,1,1,'etabli','7',NULL,1,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(3,1,1,1529407519460,0,0,0,'0345Z - BEKONDO Kangue Dieunedort','Elément Variable',NULL,'Eléments Variables','kerenpaie',0,'8807082111156127699',NULL,NULL,NULL,NULL,'active','7',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(4,0,0,1530630586735,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'etabli','7',NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `t_elsalp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_elsalrub`
--

LOCK TABLES `t_elsalrub` WRITE;
/*!40000 ALTER TABLE `t_elsalrub` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_elsalrub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_elvap`
--

LOCK TABLES `t_elvap` WRITE;
/*!40000 ALTER TABLE `t_elvap` DISABLE KEYS */;
INSERT INTO `t_elvap` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `t_elvap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_empl`
--

LOCK TABLES `t_empl` WRITE;
/*!40000 ALTER TABLE `t_empl` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_empl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_employ`
--

LOCK TABLES `t_employ` WRITE;
/*!40000 ALTER TABLE `t_employ` DISABLE KEYS */;
INSERT INTO `t_employ` VALUES (1,1,1,1,1,0,0,'0345Z - BEKONDO Kangue Dieunedort','EMPLOYE',NULL,'Liste Des Employés','kerenpaie',0,'341452139435806032','','',NULL,NULL,NULL,NULL,0,'','12341111111','','CVBEKONDO KANGUE DIEUNEDORT2015.pdf',NULL,'123456',1,1,'','0',NULL,NULL,'1528187542622.png',NULL,'LIBREVILLE-GABON','','','YAOUNDE-CAMEROUN',1,'','0345Z',NULL,'',NULL,NULL,30,NULL,'BEKONDO Kangue Dieunedort','','',NULL,0,'0',NULL,NULL,'',1,7,1,NULL,NULL,1,1,NULL,1,1,NULL,1,1,1,0,0,0,0,0,0,0,NULL,0,NULL,1,NULL,NULL,0,0,0,NULL),(5,0,0,5,1,0,0,'56000 - MELANGUE Souka','EMPLOYE',NULL,'EMPLOYES','kerenrh',0,NULL,'','',NULL,NULL,NULL,NULL,0,'','','','',NULL,'',0,0,'','1',1,NULL,'1528187680080.png',0,'','','','',0,'','56000',NULL,'',NULL,NULL,NULL,NULL,'MELANGUE Souka','','',NULL,0,'0',NULL,NULL,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(7,1,1,1528184929555,1,0,0,'23098 - BEKONDO NANGUE JUDITH CELARIEE','EMPLOYE',NULL,'Liste Des Employés','kerenpaie',0,'341452139435806032','','',NULL,NULL,NULL,NULL,0,'','','','',NULL,'123456',NULL,NULL,'','1',NULL,NULL,'',0,'','','','',NULL,'','23098',NULL,'',NULL,NULL,NULL,NULL,'BEKONDO NANGUE JUDITH CELARIEE','','',NULL,0,'0',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(8,1,1,1528187771956,1,0,0,'QS345 - NANGE BEKONDO','EMPLOYE',NULL,'Liste Des Employés','kerenpaie',0,'341452139435806032','','',NULL,NULL,NULL,NULL,0,'','','','',NULL,'',NULL,NULL,'','1',NULL,NULL,'1528187776775.png',0,'','','','',NULL,'','QS345',NULL,'',NULL,NULL,NULL,NULL,'NANGE BEKONDO','','',NULL,0,'0',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(14,1,1,1528209559193,1,0,0,'QS345 - NANGE BEKONDO','EMPLOYE',NULL,'Liste Des Employés','kerenpaie',0,'341452139435806032','','',NULL,NULL,NULL,NULL,0,'','','','',NULL,'',NULL,NULL,'','0',NULL,NULL,'1528187776775.png',0,'','','','',NULL,'','QS345M',NULL,'',NULL,NULL,NULL,NULL,'KANGUE Bekondo Bayard','','',NULL,0,'0',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(15,0,0,1528209676066,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'','',NULL,NULL,NULL,NULL,NULL,'','','','',NULL,'',NULL,NULL,'','0',NULL,NULL,'',0,'','','','',NULL,'','0345ZD',NULL,'',NULL,NULL,NULL,NULL,'MAKOUBA Gertrude Laure','','',NULL,NULL,'1',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(16,1,1,1528272185966,1,0,0,'23098 - BEKONDO NANGUE JUDITH CELARIEE','EMPLOYE',NULL,'Liste Des Employés','kerenpaie',0,'341452139435806032','','',NULL,NULL,NULL,NULL,0,'','','','',NULL,'123456',NULL,NULL,'','0',NULL,NULL,'',0,'','','','',NULL,'','23098D',NULL,'',NULL,NULL,NULL,NULL,'DOH Kangue','','',NULL,0,'0',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(19,1,1,1528274781184,1,0,0,'23098D - DOH Kangue','EMPLOYE',NULL,'Liste Des Employés','kerenpaie',0,'341452139435806032','','',NULL,NULL,NULL,NULL,0,'','','','',NULL,'123456',NULL,NULL,'','1',NULL,NULL,'',0,'','','','',NULL,'','23098E',NULL,'',NULL,NULL,NULL,NULL,'MEYAPSEN KANGUE M A','','',NULL,0,'1',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `t_employ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_emplrh`
--

LOCK TABLES `t_emplrh` WRITE;
/*!40000 ALTER TABLE `t_emplrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_emplrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_emrup`
--

LOCK TABLES `t_emrup` WRITE;
/*!40000 ALTER TABLE `t_emrup` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_emrup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_entr`
--

LOCK TABLES `t_entr` WRITE;
/*!40000 ALTER TABLE `t_entr` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_entr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_escale`
--

LOCK TABLES `t_escale` WRITE;
/*!40000 ALTER TABLE `t_escale` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_escale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_etablrh`
--

LOCK TABLES `t_etablrh` WRITE;
/*!40000 ALTER TABLE `t_etablrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_etablrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_etaprh`
--

LOCK TABLES `t_etaprh` WRITE;
/*!40000 ALTER TABLE `t_etaprh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_etaprh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_evastarh`
--

LOCK TABLES `t_evastarh` WRITE;
/*!40000 ALTER TABLE `t_evastarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_evastarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_event`
--

LOCK TABLES `t_event` WRITE;
/*!40000 ALTER TABLE `t_event` DISABLE KEYS */;
INSERT INTO `t_event` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,'AZERT',0,'01:00','2018-06-25 17:20:00',NULL,0,0,'2018-06-25 16:20:00','AZERT',1,1,0),(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,'AZERTY',0,'01:30','2018-06-26 14:00:00',NULL,0,0,'2018-06-26 12:30:00','Anniversaire',1,2,0);
/*!40000 ALTER TABLE `t_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_exbe`
--

LOCK TABLES `t_exbe` WRITE;
/*!40000 ALTER TABLE `t_exbe` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_exbe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_exercmble`
--

LOCK TABLES `t_exercmble` WRITE;
/*!40000 ALTER TABLE `t_exercmble` DISABLE KEYS */;
INSERT INTO `t_exercmble` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,'EXO2018','2018-01-01','2018-12-31',0,1,0);
/*!40000 ALTER TABLE `t_exercmble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_expcanrh`
--

LOCK TABLES `t_expcanrh` WRITE;
/*!40000 ALTER TABLE `t_expcanrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_expcanrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_faar`
--

LOCK TABLES `t_faar` WRITE;
/*!40000 ALTER TABLE `t_faar` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_faar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_fam`
--

LOCK TABLES `t_fam` WRITE;
/*!40000 ALTER TABLE `t_fam` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_fiin`
--

LOCK TABLES `t_fiin` WRITE;
/*!40000 ALTER TABLE `t_fiin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fiin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_fiporh`
--

LOCK TABLES `t_fiporh` WRITE;
/*!40000 ALTER TABLE `t_fiporh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fiporh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_foca`
--

LOCK TABLES `t_foca` WRITE;
/*!40000 ALTER TABLE `t_foca` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_foca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_focapr`
--

LOCK TABLES `t_focapr` WRITE;
/*!40000 ALTER TABLE `t_focapr` DISABLE KEYS */;
INSERT INTO `t_focapr` VALUES (1,0,0,0,1,0,0,'','Forfait',NULL,NULL,'kerenpaie',0,NULL,'0',23000,1,NULL,2,0);
/*!40000 ALTER TABLE `t_focapr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_fol_aban`
--

LOCK TABLES `t_fol_aban` WRITE;
/*!40000 ALTER TABLE `t_fol_aban` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fol_aban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_fol_can`
--

LOCK TABLES `t_fol_can` WRITE;
/*!40000 ALTER TABLE `t_fol_can` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fol_can` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_follow`
--

LOCK TABLES `t_follow` WRITE;
/*!40000 ALTER TABLE `t_follow` DISABLE KEYS */;
INSERT INTO `t_follow` VALUES (1,0,0,-1,1,0,0,'','',NULL,'','kerencore',0,NULL,1,'',NULL,1,'341452139435806032',0,NULL,0);
/*!40000 ALTER TABLE `t_follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_fonc`
--

LOCK TABLES `t_fonc` WRITE;
/*!40000 ALTER TABLE `t_fonc` DISABLE KEYS */;
INSERT INTO `t_fonc` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'ING','','Ingenieur en informatique','2',0);
/*!40000 ALTER TABLE `t_fonc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_forcanrh`
--

LOCK TABLES `t_forcanrh` WRITE;
/*!40000 ALTER TABLE `t_forcanrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_forcanrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_formarh`
--

LOCK TABLES `t_formarh` WRITE;
/*!40000 ALTER TABLE `t_formarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_formarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_formrh`
--

LOCK TABLES `t_formrh` WRITE;
/*!40000 ALTER TABLE `t_formrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_formrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_fosp`
--

LOCK TABLES `t_fosp` WRITE;
/*!40000 ALTER TABLE `t_fosp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fosp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_framisrh`
--

LOCK TABLES `t_framisrh` WRITE;
/*!40000 ALTER TABLE `t_framisrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_framisrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_goupd`
--

LOCK TABLES `t_goupd` WRITE;
/*!40000 ALTER TABLE `t_goupd` DISABLE KEYS */;
INSERT INTO `t_goupd` VALUES (107,0,0,0,0,0,0,'Employé','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',123,3,0),(108,0,0,0,0,0,0,'Contrats de Travail','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',124,3,0),(109,0,0,0,0,0,0,'Avances de salaire','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',125,3,0),(110,0,0,0,0,0,0,'Remboursements avances','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',126,3,0),(111,0,0,0,0,0,0,'Demandes de Prêt','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',127,3,0),(112,0,0,0,0,0,0,'Remboursements de Prêts','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',128,3,0),(113,0,0,0,0,0,0,'Catégorie de Prêt','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',129,3,0),(114,0,0,0,0,0,0,'Acomptes de salaire','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',130,3,0),(115,0,0,0,0,0,0,'Rappels de salaire','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',131,3,0),(116,0,0,0,0,0,0,'Eléments Salaires','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',132,3,0),(117,0,0,0,0,0,0,'Ouvrir une periode','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',133,3,0),(118,0,0,0,0,0,0,'Préparation des salaires','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',134,3,0),(119,0,0,0,0,0,0,'Traitement des salaires','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',135,3,0),(120,0,0,0,0,0,0,'Salaires','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',136,3,0),(121,0,0,0,0,0,0,'Validation des salaires','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',137,3,0),(122,0,0,0,0,0,0,'Transfert Comptabilité','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',138,3,0),(123,0,0,0,0,0,0,'Fermer une periode','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',139,3,0),(124,0,0,0,0,0,0,'Grille de salaire','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',140,3,0),(125,0,0,0,0,0,0,'Indices de solde','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',141,3,0),(126,0,0,0,0,0,0,'Profils de paie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',142,3,0),(127,0,0,0,0,0,0,'Rubriques de paie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',143,3,0),(128,0,0,0,0,0,0,'Variables de paie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',144,3,0),(129,0,0,0,0,0,0,' Parametrages avancés','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',145,3,0),(130,0,0,0,0,0,0,'Dossier de paie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',146,3,0),(131,0,0,0,0,0,0,'Exercices','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',147,3,0),(132,0,0,0,0,0,0,'Periodes ','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',148,3,0),(133,0,0,0,0,0,0,'Trimestres','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',149,3,0),(134,0,0,0,0,0,0,'Bulletin de Paie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',150,3,0),(135,0,0,0,0,0,0,'Livre de Paie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',151,3,0),(136,0,0,0,0,0,0,'Dipe ','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',152,3,0),(137,0,0,0,0,0,0,'Generer le Dipe Magnetique','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',153,3,0),(138,0,0,0,0,0,0,'Brouillard de paie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',154,3,0),(139,0,0,0,0,0,0,'Etat des cotisations','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',155,3,0),(140,0,0,0,0,0,0,'Plan comptable','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',156,3,0),(141,0,0,0,0,0,0,'Plan Analytique','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',157,3,0),(142,0,0,0,0,0,0,'Taxes','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',158,3,0),(143,0,0,0,0,0,0,'Structure','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',159,3,0),(144,0,0,0,0,0,0,'Syndicat','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',160,3,0),(145,0,0,0,0,0,0,'Type Contract','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',161,3,0),(146,0,0,0,0,0,0,'Type Caisse','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',162,3,0),(147,0,0,0,0,0,0,'Catégorie','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',163,3,0),(148,0,0,0,0,0,0,'Echélon','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',164,3,0),(149,0,0,0,0,0,0,'Structure entreprise','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',165,3,0),(150,0,0,0,0,0,0,'Organigramme','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',166,3,0),(151,0,0,0,0,0,0,'Département administatif','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',167,3,0),(152,0,0,0,0,0,0,'Postes','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',168,3,0),(153,0,0,0,0,0,0,'Fonctions','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',169,3,0),(154,0,0,0,0,0,0,'niveau d\'etude','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',170,3,0),(155,0,0,0,0,0,0,'Spécialités','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',171,3,0),(156,0,0,0,0,0,0,'Diplômes','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',172,3,0),(157,0,0,0,0,0,0,'Regions','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',173,3,0),(158,0,0,0,0,0,0,'Departement','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',174,3,0),(159,0,0,0,0,0,0,'Pays','NIVEAU HABILITATION',NULL,'NIVEAUX HABILITATIONS',NULL,0,NULL,'0',175,3,0);
/*!40000 ALTER TABLE `t_goupd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_gradep`
--

LOCK TABLES `t_gradep` WRITE;
/*!40000 ALTER TABLE `t_gradep` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_gradep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_grilfrarh`
--

LOCK TABLES `t_grilfrarh` WRITE;
/*!40000 ALTER TABLE `t_grilfrarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_grilfrarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_groupe`
--

LOCK TABLES `t_groupe` WRITE;
/*!40000 ALTER TABLE `t_groupe` DISABLE KEYS */;
INSERT INTO `t_groupe` VALUES (3,0,0,1528707590385,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'PAYEUSER',5,0);
/*!40000 ALTER TABLE `t_groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_indperfrh`
--

LOCK TABLES `t_indperfrh` WRITE;
/*!40000 ALTER TABLE `t_indperfrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_indperfrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_inrconrh`
--

LOCK TABLES `t_inrconrh` WRITE;
/*!40000 ALTER TABLE `t_inrconrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_inrconrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_insolp`
--

LOCK TABLES `t_insolp` WRITE;
/*!40000 ALTER TABLE `t_insolp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_insolp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_jcomptable`
--

LOCK TABLES `t_jcomptable` WRITE;
/*!40000 ALTER TABLE `t_jcomptable` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_jcomptable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_jrnsaisie`
--

LOCK TABLES `t_jrnsaisie` WRITE;
/*!40000 ALTER TABLE `t_jrnsaisie` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_jrnsaisie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_kmsge`
--

LOCK TABLES `t_kmsge` WRITE;
/*!40000 ALTER TABLE `t_kmsge` DISABLE KEYS */;
INSERT INTO `t_kmsge` VALUES ('R',1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : AZERT\nDétail:AZERT','2018-06-25 16:20:01',0,NULL,0,1,NULL,1,NULL,NULL,0),('R',2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : Anniversaire\nDétail:AZERTY','2018-06-26 12:30:00',0,NULL,0,1,NULL,2,NULL,NULL,0),('R',3,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : Anniversaire\nDétail:AZERTY','2018-06-26 12:30:00',0,NULL,0,1,NULL,2,NULL,NULL,0),('R',4,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : Anniversaire\nDétail:AZERTY','2018-06-26 12:30:00',0,NULL,0,1,NULL,2,NULL,NULL,0),('R',5,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : Anniversaire\nDétail:AZERTY','2018-06-26 12:30:00',0,NULL,0,1,NULL,2,NULL,NULL,0),('R',6,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : Anniversaire\nDétail:AZERTY','2018-06-26 12:30:00',0,NULL,0,1,NULL,2,NULL,NULL,0),('R',7,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : Anniversaire\nDétail:AZERTY','2018-06-26 12:30:00',0,NULL,0,1,NULL,2,NULL,NULL,0),('R',8,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Titre : Anniversaire\nDétail:AZERTY','2018-06-26 12:30:00',0,NULL,0,1,NULL,2,NULL,NULL,0),('S',9,0,0,-1,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'azertt','2018-07-02 10:00:27',0,NULL,0,0,NULL,NULL,1,1,0);
/*!40000 ALTER TABLE `t_kmsge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_langrh`
--

LOCK TABLES `t_langrh` WRITE;
/*!40000 ALTER TABLE `t_langrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_langrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_langue`
--

LOCK TABLES `t_langue` WRITE;
/*!40000 ALTER TABLE `t_langue` DISABLE KEYS */;
INSERT INTO `t_langue` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'en','en','0','','','','','ANGLAIS',0);
/*!40000 ALTER TABLE `t_langue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liapof`
--

LOCK TABLES `t_liapof` WRITE;
/*!40000 ALTER TABLE `t_liapof` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_liapof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liavrh`
--

LOCK TABLES `t_liavrh` WRITE;
/*!40000 ALTER TABLE `t_liavrh` DISABLE KEYS */;
INSERT INTO `t_liavrh` VALUES (1,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'0',3,0),(2,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,1,'1',3,0),(3,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'2',3,0),(4,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'3',3,0),(5,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',2,0,'4',3,0),(6,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'0',2,0),(7,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'1',2,0),(8,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'2',2,0),(9,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'3',2,0),(10,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'4',2,0),(11,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'0',4,0),(12,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'1',4,0),(13,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'2',4,0),(14,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'3',4,0),(15,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'4',4,0),(16,0,0,0,0,1,1,NULL,NULL,NULL,NULL,NULL,0,NULL,'0',1,0,'5',4,0);
/*!40000 ALTER TABLE `t_liavrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_libeforh`
--

LOCK TABLES `t_libeforh` WRITE;
/*!40000 ALTER TABLE `t_libeforh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_libeforh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_libupa`
--

LOCK TABLES `t_libupa` WRITE;
/*!40000 ALTER TABLE `t_libupa` DISABLE KEYS */;
INSERT INTO `t_libupa` VALUES (353,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,360000,360000,1,87,0),(354,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,23000,23000,2,87,0),(355,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,3,87,0),(356,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,4,87,0),(357,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,21943,21943,6,87,0),(358,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,360000,360000,1,88,0),(359,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,23000,23000,2,88,0),(360,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,3,88,0),(361,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,4,88,0),(362,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,21943,21943,6,88,0),(428,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,360000,360000,1,100,0),(429,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,23000,23000,2,100,0),(430,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,30000,30000,3,100,0),(431,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,50000,50000,4,100,0),(432,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,26434.3141,26434.3141,6,100,0),(433,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,42774.42,42774.42,7,100,0);
/*!40000 ALTER TABLE `t_libupa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_licoon`
--

LOCK TABLES `t_licoon` WRITE;
/*!40000 ALTER TABLE `t_licoon` DISABLE KEYS */;
INSERT INTO `t_licoon` VALUES (2,0,0,2,1,0,0,'10','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,400000,'etabli',1,1,1,0),(3,0,0,3,1,0,0,'10','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,350000,'etabli',1,2,1,0),(4,0,0,4,1,0,0,'10','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,355000,'etabli',1,3,1,0),(5,0,0,5,1,0,0,'10','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,360000,'etabli',1,4,1,0),(6,0,0,6,1,0,0,'10','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',1,5,1,0),(7,0,0,7,1,0,0,'10','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',1,6,1,0),(8,0,0,8,1,0,0,'4','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',2,1,1,0),(9,0,0,9,1,0,0,'4','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',2,2,1,0),(10,0,0,10,1,0,0,'4','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',2,3,1,0),(11,0,0,11,1,0,0,'4','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',2,4,1,0),(12,0,0,12,1,0,0,'4','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',2,5,1,0),(13,0,0,13,1,0,0,'4','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',2,6,1,0),(14,0,0,14,1,0,0,'5','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',3,1,1,0),(15,0,0,15,1,0,0,'5','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',3,2,1,0),(16,0,0,16,1,0,0,'5','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',3,3,1,0),(17,0,0,17,1,0,0,'5','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',3,4,1,0),(18,0,0,18,1,0,0,'5','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',3,5,1,0),(19,0,0,19,1,0,0,'5','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',3,6,1,0),(20,0,0,20,1,0,0,'6','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',4,1,1,0),(21,0,0,21,1,0,0,'6','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',4,2,1,0),(22,0,0,22,1,0,0,'6','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',4,3,1,0),(23,0,0,23,1,0,0,'6','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',4,4,1,0),(24,0,0,24,1,0,0,'6','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',4,5,1,0),(25,0,0,25,1,0,0,'6','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',4,6,1,0),(26,0,0,26,1,0,0,'7','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',5,1,1,0),(27,0,0,27,1,0,0,'7','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',5,2,1,0),(28,0,0,28,1,0,0,'7','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',5,3,1,0),(29,0,0,29,1,0,0,'7','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',5,4,1,0),(30,0,0,30,1,0,0,'7','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',5,5,1,0),(31,0,0,31,1,0,0,'7','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',5,6,1,0),(32,0,0,32,1,0,0,'8','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',6,1,1,0),(33,0,0,33,1,0,0,'8','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',6,2,1,0),(34,0,0,34,1,0,0,'8','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',6,3,1,0),(35,0,0,35,1,0,0,'8','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',6,4,1,0),(36,0,0,36,1,0,0,'8','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',6,5,1,0),(37,0,0,37,1,0,0,'8','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',6,6,1,0),(38,0,0,38,1,0,0,'9','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,360000,'etabli',7,1,1,0),(39,0,0,39,1,0,0,'9','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,340000,'etabli',7,2,1,0),(40,0,0,40,1,0,0,'9','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',7,3,1,0),(41,0,0,41,1,0,0,'9','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',7,4,1,0),(42,0,0,42,1,0,0,'9','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',7,5,1,0),(43,0,0,43,1,0,0,'9','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',7,6,1,0),(44,0,0,44,1,0,0,'11','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',8,1,1,0),(45,0,0,45,1,0,0,'11','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',8,2,1,0),(46,0,0,46,1,0,0,'11','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',8,3,1,0),(47,0,0,47,1,0,0,'11','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',8,4,1,0),(48,0,0,48,1,0,0,'11','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',8,5,1,0),(49,0,0,49,1,0,0,'11','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',8,6,1,0),(50,0,0,50,1,0,0,'12','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',9,1,1,0),(51,0,0,51,1,0,0,'12','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',9,2,1,0),(52,0,0,52,1,0,0,'12','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',9,3,1,0),(53,0,0,53,1,0,0,'12','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',9,4,1,0),(54,0,0,54,1,0,0,'12','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',9,5,1,0),(55,0,0,55,1,0,0,'12','Ligne Convension collective',NULL,'Lignes Convension collective','kerenpaie',0,NULL,0,'etabli',9,6,1,0);
/*!40000 ALTER TABLE `t_licoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lidoac`
--

LOCK TABLES `t_lidoac` WRITE;
/*!40000 ALTER TABLE `t_lidoac` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lidoac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lidoac_ta`
--

LOCK TABLES `t_lidoac_ta` WRITE;
/*!40000 ALTER TABLE `t_lidoac_ta` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lidoac_ta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lids`
--

LOCK TABLES `t_lids` WRITE;
/*!40000 ALTER TABLE `t_lids` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lielvap`
--

LOCK TABLES `t_lielvap` WRITE;
/*!40000 ALTER TABLE `t_lielvap` DISABLE KEYS */;
INSERT INTO `t_lielvap` VALUES (3031,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,1,87,0),(3032,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,2,87,0),(3033,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,3,87,0),(3034,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,4,87,0),(3035,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,5,87,0),(3036,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,6,87,0),(3037,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,7,87,0),(3038,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,8,87,0),(3039,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,9,87,0),(3040,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,9,10,87,0),(3041,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,11,87,0),(3042,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,12,87,0),(3043,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,13,87,0),(3044,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,14,87,0),(3045,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,15,87,0),(3046,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,152,16,87,0),(3047,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,152,17,87,0),(3048,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,18,87,0),(3049,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,19,87,0),(3050,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,20,87,0),(3051,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,21,87,0),(3052,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,22,87,0),(3053,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,23,87,0),(3054,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,24,87,0),(3055,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,25,87,0),(3056,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,26,87,0),(3057,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,27,87,0),(3058,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,28,87,0),(3059,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,29,87,0),(3060,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,31,87,0),(3061,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,32,87,0),(3062,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,33,87,0),(3063,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,34,87,0),(3064,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,35,87,0),(3065,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,36,87,0),(3066,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,37,87,0),(3067,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,21943,38,87,0),(3068,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,21943,39,87,0),(3069,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,1,88,0),(3070,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,2,88,0),(3071,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,3,88,0),(3072,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,4,88,0),(3073,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,5,88,0),(3074,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,6,88,0),(3075,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,7,88,0),(3076,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,8,88,0),(3077,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,9,88,0),(3078,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,9,10,88,0),(3079,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,11,88,0),(3080,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,12,88,0),(3081,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,13,88,0),(3082,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,14,88,0),(3083,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,15,88,0),(3084,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,176,16,88,0),(3085,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,176,17,88,0),(3086,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,18,88,0),(3087,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,19,88,0),(3088,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,20,88,0),(3089,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,21,88,0),(3090,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,22,88,0),(3091,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,23,88,0),(3092,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,24,88,0),(3093,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,25,88,0),(3094,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,26,88,0),(3095,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,27,88,0),(3096,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,28,88,0),(3097,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,29,88,0),(3098,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,31,88,0),(3099,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,32,88,0),(3100,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,33,88,0),(3101,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,34,88,0),(3102,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,35,88,0),(3103,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,36,88,0),(3104,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,37,88,0),(3105,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,21943,38,88,0),(3106,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,21943,39,88,0),(3525,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,1,100,0),(3526,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,2,100,0),(3527,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,3,100,0),(3528,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,4,100,0),(3529,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,5,100,0),(3530,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,6,100,0),(3531,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,7,100,0),(3532,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,8,100,0),(3533,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,9,100,0),(3534,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,9,10,100,0),(3535,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,11,100,0),(3536,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,12,100,0),(3537,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,13,100,0),(3538,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,14,100,0),(3539,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,15,100,0),(3540,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,176,16,100,0),(3541,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,176,17,100,0),(3542,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,18,100,0),(3543,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,19,100,0),(3544,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,20,100,0),(3545,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,21,100,0),(3546,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,22,100,0),(3547,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,23,100,0),(3548,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,24,100,0),(3549,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,25,100,0),(3550,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,26,100,0),(3551,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,27,100,0),(3552,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,28,100,0),(3553,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,29,100,0),(3554,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,31,100,0),(3555,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,30000,32,100,0),(3556,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,33,100,0),(3557,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,34,100,0),(3558,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,42774.42,35,100,0),(3559,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,402774.42,36,100,0),(3560,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,360000,37,100,0),(3561,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,26434.3141,38,100,0),(3562,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,21943,39,100,0);
/*!40000 ALTER TABLE `t_lielvap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liem`
--

LOCK TABLES `t_liem` WRITE;
/*!40000 ALTER TABLE `t_liem` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_liem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liexbe`
--

LOCK TABLES `t_liexbe` WRITE;
/*!40000 ALTER TABLE `t_liexbe` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_liexbe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lifiporh`
--

LOCK TABLES `t_lifiporh` WRITE;
/*!40000 ALTER TABLE `t_lifiporh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lifiporh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liin`
--

LOCK TABLES `t_liin` WRITE;
/*!40000 ALTER TABLE `t_liin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_liin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liinsolp`
--

LOCK TABLES `t_liinsolp` WRITE;
/*!40000 ALTER TABLE `t_liinsolp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_liinsolp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_linofr`
--

LOCK TABLES `t_linofr` WRITE;
/*!40000 ALTER TABLE `t_linofr` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_linofr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liplforh`
--

LOCK TABLES `t_liplforh` WRITE;
/*!40000 ALTER TABLE `t_liplforh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_liplforh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liporh`
--

LOCK TABLES `t_liporh` WRITE;
/*!40000 ALTER TABLE `t_liporh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_liporh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_liposap`
--

LOCK TABLES `t_liposap` WRITE;
/*!40000 ALTER TABLE `t_liposap` DISABLE KEYS */;
INSERT INTO `t_liposap` VALUES (3,0,0,-1528793422473,1,0,0,'ING-Ingenieur en informatique','Fonction',NULL,NULL,NULL,0,NULL,3,1,2,0);
/*!40000 ALTER TABLE `t_liposap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lipotcp`
--

LOCK TABLES `t_lipotcp` WRITE;
/*!40000 ALTER TABLE `t_lipotcp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lipotcp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lirap`
--

LOCK TABLES `t_lirap` WRITE;
/*!40000 ALTER TABLE `t_lirap` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lirap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lirerh`
--

LOCK TABLES `t_lirerh` WRITE;
/*!40000 ALTER TABLE `t_lirerh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lirerh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_litheforrh`
--

LOCK TABLES `t_litheforrh` WRITE;
/*!40000 ALTER TABLE `t_litheforrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_litheforrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_livstarh`
--

LOCK TABLES `t_livstarh` WRITE;
/*!40000 ALTER TABLE `t_livstarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_livstarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_lot`
--

LOCK TABLES `t_lot` WRITE;
/*!40000 ALTER TABLE `t_lot` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_lot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_mecorh`
--

LOCK TABLES `t_mecorh` WRITE;
/*!40000 ALTER TABLE `t_mecorh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_mecorh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_medaille`
--

LOCK TABLES `t_medaille` WRITE;
/*!40000 ALTER TABLE `t_medaille` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_medaille` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_missirh`
--

LOCK TABLES `t_missirh` WRITE;
/*!40000 ALTER TABLE `t_missirh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_missirh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_moforrh`
--

LOCK TABLES `t_moforrh` WRITE;
/*!40000 ALTER TABLE `t_moforrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_moforrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_more`
--

LOCK TABLES `t_more` WRITE;
/*!40000 ALTER TABLE `t_more` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_more` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_nanalyse`
--

LOCK TABLES `t_nanalyse` WRITE;
/*!40000 ALTER TABLE `t_nanalyse` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_nanalyse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_nivetu`
--

LOCK TABLES `t_nivetu` WRITE;
/*!40000 ALTER TABLE `t_nivetu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_nivetu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_nofr`
--

LOCK TABLES `t_nofr` WRITE;
/*!40000 ALTER TABLE `t_nofr` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_nofr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_nomirh`
--

LOCK TABLES `t_nomirh` WRITE;
/*!40000 ALTER TABLE `t_nomirh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_nomirh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_ordmis_empl`
--

LOCK TABLES `t_ordmis_empl` WRITE;
/*!40000 ALTER TABLE `t_ordmis_empl` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ordmis_empl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_ordmissrh`
--

LOCK TABLES `t_ordmissrh` WRITE;
/*!40000 ALTER TABLE `t_ordmissrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ordmissrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_paavp`
--

LOCK TABLES `t_paavp` WRITE;
/*!40000 ALTER TABLE `t_paavp` DISABLE KEYS */;
INSERT INTO `t_paavp` VALUES (2,1,1,1528793414788,0,0,0,'PARAM01','Paramètrage Avancé ',NULL,'Paramètrages Avancés ','kerenpaie',0,'4361315865563218517','PARAM01','inactive','0',0);
/*!40000 ALTER TABLE `t_paavp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_partsearh`
--

LOCK TABLES `t_partsearh` WRITE;
/*!40000 ALTER TABLE `t_partsearh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_partsearh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_pays`
--

LOCK TABLES `t_pays` WRITE;
/*!40000 ALTER TABLE `t_pays` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_pepa`
--

LOCK TABLES `t_pepa` WRITE;
/*!40000 ALTER TABLE `t_pepa` DISABLE KEYS */;
INSERT INTO `t_pepa` VALUES (1,0,0,1,1,0,0,'JAV2018','Période de paie',NULL,'Périodes de paie','kerenpaie',1,'-984562080325134277',0,'JAV2018','2018-01-01','2018-01-31','ouvert',1,1,0),(2,0,0,1528386632057,1,0,0,'FEV2018','Période de paie',NULL,'Périodes de paie','kerenpaie',1,'-984562080325134277',0,'FEV2018','2018-02-01','2018-02-28','ouvert',1,1,0),(3,0,0,1528454035996,1,0,0,'MARS2018','Période de paie',NULL,'Périodes de paie','kerenpaie',1,'-984562080325134277',0,'MARS2018','2018-03-01','2018-03-31','ouvert',1,1,0),(4,0,0,1528454066288,1,0,0,'MARS2018','Période de paie',NULL,'Périodes de paie','kerenpaie',0,'-984562080325134277',0,'AVRIL2018','2018-04-01','2018-04-30','etabli',1,1,0),(5,0,0,1528454095187,1,0,0,'AVRIL2018','Période de paie',NULL,'Périodes de paie','kerenpaie',0,'-984562080325134277',0,'MAI2018','2018-05-01','2018-05-31','etabli',1,1,0),(6,0,0,1528454116915,1,0,0,'MAI2018','Période de paie',NULL,'Périodes de paie','kerenpaie',0,'-984562080325134277',0,'JUIN2018','2018-06-01','2018-06-30','etabli',1,1,0),(7,0,0,1528454189409,1,0,0,'JUILL2018','Période de paie',NULL,'Périodes de paie','kerenpaie',0,'-984562080325134277',0,'JUILL2018','2018-07-01','2018-07-31','etabli',1,1,0),(8,0,0,1528454212585,1,0,0,'JUILL2018','Période de paie',NULL,'Périodes de paie','kerenpaie',0,'-984562080325134277',0,'AOUT2018','2018-08-01','2018-08-31','etabli',1,1,0);
/*!40000 ALTER TABLE `t_pepa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_piececmle`
--

LOCK TABLES `t_piececmle` WRITE;
/*!40000 ALTER TABLE `t_piececmle` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_piececmle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_pj`
--

LOCK TABLES `t_pj` WRITE;
/*!40000 ALTER TABLE `t_pj` DISABLE KEYS */;
INSERT INTO `t_pj` VALUES (1,0,0,-1,1,0,0,'','',NULL,'','kerencore',0,'1234','Classeur1.csv',0,NULL,'1530522016041.csv',9,0);
/*!40000 ALTER TABLE `t_pj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_plaforrh`
--

LOCK TABLES `t_plaforrh` WRITE;
/*!40000 ALTER TABLE `t_plaforrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_plaforrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_planp`
--

LOCK TABLES `t_planp` WRITE;
/*!40000 ALTER TABLE `t_planp` DISABLE KEYS */;
INSERT INTO `t_planp` VALUES (64,0,0,64,1,0,0,NULL,'Planification',NULL,'Planifications','kerenpaie',0,NULL,'0',8,1,1,0),(65,0,0,65,1,0,0,NULL,'Planification',NULL,'Planifications','kerenpaie',0,NULL,'1',8,1,1,0),(66,0,0,66,1,0,0,NULL,'Planification',NULL,'Planifications','kerenpaie',0,NULL,'2',8,1,1,0),(67,0,0,67,1,0,0,NULL,'Planification',NULL,'Planifications','kerenpaie',0,NULL,'3',8,1,1,0),(68,0,0,68,1,0,0,NULL,'Planification',NULL,'Planifications','kerenpaie',0,NULL,'4',8,1,1,0),(69,0,0,69,1,0,0,NULL,'Planification',NULL,'Planifications','kerenpaie',0,NULL,'5',0,0,1,0),(70,0,0,70,1,0,0,NULL,'Planification',NULL,'Planifications','kerenpaie',0,NULL,'6',0,0,1,0);
/*!40000 ALTER TABLE `t_planp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_pojorh`
--

LOCK TABLES `t_pojorh` WRITE;
/*!40000 ALTER TABLE `t_pojorh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pojorh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_pos`
--

LOCK TABLES `t_pos` WRITE;
/*!40000 ALTER TABLE `t_pos` DISABLE KEYS */;
INSERT INTO `t_pos` VALUES (1,0,0,1,1,0,0,'RES01 - Responsables des moyens de liaisons','POSTE',NULL,'POSTES','kerenpaie',0,NULL,'RES01','','Responsables des moyens de liaisons',1,1,1,0);
/*!40000 ALTER TABLE `t_pos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_prpa`
--

LOCK TABLES `t_prpa` WRITE;
/*!40000 ALTER TABLE `t_prpa` DISABLE KEYS */;
INSERT INTO `t_prpa` VALUES (1,1,1,1,1,0,0,'MGT_PROFIL - PROFIL DE PAIE','Profil de Paie',NULL,'Profils de Paie','kerenpaie',0,'-1406171594167272372',0,'MGT_PROFIL','PROFIL DE PAIE','etabli',1,0);
/*!40000 ALTER TABLE `t_prpa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_prparubr`
--

LOCK TABLES `t_prparubr` WRITE;
/*!40000 ALTER TABLE `t_prparubr` DISABLE KEYS */;
INSERT INTO `t_prparubr` VALUES (1,1),(1,2),(1,3),(1,4),(1,6),(1,7);
/*!40000 ALTER TABLE `t_prparubr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_rappel`
--

LOCK TABLES `t_rappel` WRITE;
/*!40000 ALTER TABLE `t_rappel` DISABLE KEYS */;
INSERT INTO `t_rappel` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'AZER',1,0),(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,2,'2Minutes',0,0);
/*!40000 ALTER TABLE `t_rappel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_rappp`
--

LOCK TABLES `t_rappp` WRITE;
/*!40000 ALTER TABLE `t_rappp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_rappp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_reavp`
--

LOCK TABLES `t_reavp` WRITE;
/*!40000 ALTER TABLE `t_reavp` DISABLE KEYS */;
INSERT INTO `t_reavp` VALUES (1,1,1,1,0,0,0,'0345Z - BEKONDO Kangue Dieunedort','Remboursement Prêt',NULL,'Remboursements Prêts','kerenpaie',0,'7379660949986673989',1,'2018-01-10',50000,'confirme',1,1,1,0),(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'2018-02-01',50000,'etabli',1,NULL,1,0),(3,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'2018-03-01',50000,'etabli',1,NULL,1,0),(4,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'2018-04-01',50000,'etabli',1,NULL,1,0);
/*!40000 ALTER TABLE `t_reavp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_reclasrh`
--

LOCK TABLES `t_reclasrh` WRITE;
/*!40000 ALTER TABLE `t_reclasrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_reclasrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_recorh`
--

LOCK TABLES `t_recorh` WRITE;
/*!40000 ALTER TABLE `t_recorh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_recorh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_recrurh`
--

LOCK TABLES `t_recrurh` WRITE;
/*!40000 ALTER TABLE `t_recrurh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_recrurh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_rederh`
--

LOCK TABLES `t_rederh` WRITE;
/*!40000 ALTER TABLE `t_rederh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_rederh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_region`
--

LOCK TABLES `t_region` WRITE;
/*!40000 ALTER TABLE `t_region` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_reprp`
--

LOCK TABLES `t_reprp` WRITE;
/*!40000 ALTER TABLE `t_reprp` DISABLE KEYS */;
INSERT INTO `t_reprp` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'2018-07-11',40000,'etabli',1,NULL,1,1,0);
/*!40000 ALTER TABLE `t_reprp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_repserrh`
--

LOCK TABLES `t_repserrh` WRITE;
/*!40000 ALTER TABLE `t_repserrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_repserrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_retrogrh`
--

LOCK TABLES `t_retrogrh` WRITE;
/*!40000 ALTER TABLE `t_retrogrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_retrogrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_rubr`
--

LOCK TABLES `t_rubr` WRITE;
/*!40000 ALTER TABLE `t_rubr` DISABLE KEYS */;
INSERT INTO `t_rubr` VALUES (1,1,1,1,1,0,0,'100 - SALAIRE DE BASE','Rubrique de paie',NULL,'Rubriques de paie','kerenpaie',0,'6956286092155176573',NULL,NULL,1,1,'100',NULL,1,'SALBASE','SALAIRE DE BASE','3','0','1',1,NULL,0,100,100,'0',1,NULL,NULL,NULL,'0',0),(2,1,1,0,1,0,0,'101 - SURSALAIRE','Rubrique de paie',NULL,'Rubriques de paie','kerenpaie',0,'6956286092155176573',NULL,NULL,NULL,NULL,'101',NULL,NULL,'20000','SURSALAIRE','0','0','2',NULL,NULL,0,100,NULL,'0',1,NULL,NULL,NULL,'0',0),(3,1,1,0,1,0,0,'103 - Acompte sur le salaire','Rubrique de paie',NULL,'Rubriques de paie','kerenpaie',0,'6956286092155176573',1,NULL,NULL,0,'103',NULL,NULL,'MTACOMPTE','Acompte sur le salaire','3','0','2',NULL,NULL,0,100,NULL,'1',1,NULL,NULL,NULL,NULL,0),(4,1,1,4,1,0,0,'AVANCESAL - Avznces sur Salaire','Rubrique de paie',NULL,'Rubriques de paie','kerenpaie',0,'6956286092155176573',NULL,0,0,NULL,'AVANCESAL',NULL,NULL,'0','Avznces sur Salaire','3','0','2',NULL,NULL,0,100,NULL,'1',1,NULL,1,0,NULL,0),(5,1,1,1528733168740,1,0,0,'104 - PRET SUR SALAIRE','Rubrique de paie',NULL,'Rubriques de paie','kerenpaie',0,'6956286092155176573',0,NULL,NULL,0,'104',0,NULL,'0','PRET SUR SALAIRE','3','0','2',0,0,0,100,NULL,'1',1,NULL,NULL,NULL,NULL,0),(6,0,0,1530111843202,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,NULL,NULL,NULL,'401',0,NULL,'IRPP','IRPP','3','4','2',0,0,0,100,NULL,'1',1,NULL,NULL,NULL,'',0),(7,1,1,1530628481002,1,0,0,'106 - Indemnité de logement','Rubrique de paie',NULL,'Rubriques de paie','kerenpaie',0,'6956286092155176573',0,NULL,NULL,NULL,'106',0,NULL,'42774.42','Indemnité de logement','3','1','',0,0,0,100,NULL,'0',1,15,1,NULL,'1',0);
/*!40000 ALTER TABLE `t_rubr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_sanalytique`
--

LOCK TABLES `t_sanalytique` WRITE;
/*!40000 ALTER TABLE `t_sanalytique` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sanalytique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_sancrh`
--

LOCK TABLES `t_sancrh` WRITE;
/*!40000 ALTER TABLE `t_sancrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sancrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_seaformrh`
--

LOCK TABLES `t_seaformrh` WRITE;
/*!40000 ALTER TABLE `t_seaformrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_seaformrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_sean_form`
--

LOCK TABLES `t_sean_form` WRITE;
/*!40000 ALTER TABLE `t_sean_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sean_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_smes_can`
--

LOCK TABLES `t_smes_can` WRITE;
/*!40000 ALTER TABLE `t_smes_can` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_smes_can` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_smes_user`
--

LOCK TABLES `t_smes_user` WRITE;
/*!40000 ALTER TABLE `t_smes_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_smes_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_societe`
--

LOCK TABLES `t_societe` WRITE;
/*!40000 ALTER TABLE `t_societe` DISABLE KEYS */;
INSERT INTO `t_societe` VALUES (1,0,0,1,0,0,0,'MGT','SOCIETE',NULL,'SOCIETES','kerenpaie',0,NULL,'','Megatim SARL','','','','','MGT','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `t_societe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_speci`
--

LOCK TABLES `t_speci` WRITE;
/*!40000 ALTER TABLE `t_speci` DISABLE KEYS */;
INSERT INTO `t_speci` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'INFORMATIQUE','',0);
/*!40000 ALTER TABLE `t_speci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_stagerh`
--

LOCK TABLES `t_stagerh` WRITE;
/*!40000 ALTER TABLE `t_stagerh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_stagerh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_syndicatp`
--

LOCK TABLES `t_syndicatp` WRITE;
/*!40000 ALTER TABLE `t_syndicatp` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_syndicatp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_tacstarh`
--

LOCK TABLES `t_tacstarh` WRITE;
/*!40000 ALTER TABLE `t_tacstarh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_tacstarh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_taxe`
--

LOCK TABLES `t_taxe` WRITE;
/*!40000 ALTER TABLE `t_taxe` DISABLE KEYS */;
INSERT INTO `t_taxe` VALUES (1,0,0,1528193350750,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'1','11111','AZERTY',19.25,'','1','0',NULL,0);
/*!40000 ALTER TABLE `t_taxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_theforrh`
--

LOCK TABLES `t_theforrh` WRITE;
/*!40000 ALTER TABLE `t_theforrh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_theforrh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_tier`
--

LOCK TABLES `t_tier` WRITE;
/*!40000 ALTER TABLE `t_tier` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_tier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_trderh`
--

LOCK TABLES `t_trderh` WRITE;
/*!40000 ALTER TABLE `t_trderh` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_trderh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_tycon`
--

LOCK TABLES `t_tycon` WRITE;
/*!40000 ALTER TABLE `t_tycon` DISABLE KEYS */;
INSERT INTO `t_tycon` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'0','CDD',0);
/*!40000 ALTER TABLE `t_tycon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_tydme`
--

LOCK TABLES `t_tydme` WRITE;
/*!40000 ALTER TABLE `t_tydme` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_tydme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_typcaisp`
--

LOCK TABLES `t_typcaisp` WRITE;
/*!40000 ALTER TABLE `t_typcaisp` DISABLE KEYS */;
INSERT INTO `t_typcaisp` VALUES (19,0,0,0,1,0,0,'EPA - Caisse d\'Ã©pagne','Type de Caisse',NULL,'Types de Caisse','kerenpaie',0,NULL,'EPA','Caisse d\'épagne',0),(20,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SHOOL','Caisse scolaire',0);
/*!40000 ALTER TABLE `t_typcaisp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_typcon`
--

LOCK TABLES `t_typcon` WRITE;
/*!40000 ALTER TABLE `t_typcon` DISABLE KEYS */;
INSERT INTO `t_typcon` VALUES (1,0,0,1528454970753,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'URGENCES FAMILIALLE','2',2,0);
/*!40000 ALTER TABLE `t_typcon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_unac`
--

LOCK TABLES `t_unac` WRITE;
/*!40000 ALTER TABLE `t_unac` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_unac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_unge`
--

LOCK TABLES `t_unge` WRITE;
/*!40000 ALTER TABLE `t_unge` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_unge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,0,0,1,1,0,0,'Administrateur',NULL,NULL,NULL,'kerencore',0,NULL,1,'3','bekondo84dieu@gmail.com','1516637238390.png','Administrateur','2018-07-04 15:48:17','admin','YjVF4NQ3bMVItVfDKgF16w==',NULL,1,1,0),(2,0,0,1528286214522,1,0,0,'bekondo',NULL,NULL,NULL,'kerencore',0,NULL,1,'0','dbekondo@megatimgroup.com','1528704395553.png','bekondo','2018-06-14 11:03:17','admin','90dmi7+tNvn6SNjjGwJoRg==','etabli',NULL,1,0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_user_event`
--

LOCK TABLES `t_user_event` WRITE;
/*!40000 ALTER TABLE `t_user_event` DISABLE KEYS */;
INSERT INTO `t_user_event` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `t_user_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_user_rigth`
--

LOCK TABLES `t_user_rigth` WRITE;
/*!40000 ALTER TABLE `t_user_rigth` DISABLE KEYS */;
INSERT INTO `t_user_rigth` VALUES (2,3);
/*!40000 ALTER TABLE `t_user_rigth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_user_sct`
--

LOCK TABLES `t_user_sct` WRITE;
/*!40000 ALTER TABLE `t_user_sct` DISABLE KEYS */;
INSERT INTO `t_user_sct` VALUES (1,1);
/*!40000 ALTER TABLE `t_user_sct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_vari`
--

LOCK TABLES `t_vari` WRITE;
/*!40000 ALTER TABLE `t_vari` DISABLE KEYS */;
INSERT INTO `t_vari` VALUES (1,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SALBASE','SALAIRE DE BASE','','1',NULL,1,1,'','0',1,0),(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SALCATEGO','SALAIRE CATEGORIEL','','1',NULL,NULL,1,'','0',1,0),(3,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TYPECONTRAT','TYPE DE CONTRAT','','1',NULL,NULL,1,'','0',1,0),(4,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NBENFT21','NOMBRE ENFANTS ILLEGIBLES','','1',NULL,NULL,1,'','0',1,0),(5,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NBENFT','NOMBRE ENFANTS','','1',NULL,NULL,1,'','0',1,0),(6,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ANCIENITEGELE','ANCIENNITE GELES','','1',NULL,NULL,1,'','0',1,0),(7,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TYPEAGENT','TYPE AGENT','','1',NULL,NULL,1,'','0',1,0),(8,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'HANDICAPE','HANDICAPE','','1',NULL,NULL,1,'','0',1,0),(9,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SEXE','SEXE','','1',NULL,NULL,1,'','0',1,0),(10,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'CATEGORIE','CATEGORIE EMPLOYE','','1',NULL,NULL,1,'','0',1,0),(11,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'INDICE','INDICE EMPLOYE','','1',NULL,NULL,1,'','0',1,0),(12,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'AFFECTE','EMPLOYE AFFECTE','','1',NULL,NULL,1,'','0',1,0),(13,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'EAU','AVANTAGE EN EAU?','','1',NULL,NULL,1,'','0',1,0),(14,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ELECTRICITE','AVANTAGE EN ELECTRICITE','','1',NULL,NULL,1,'','0',1,0),(15,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'VEHICULE','EST VEHICULE?','','1',NULL,NULL,1,'','0',1,0),(16,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'HPAYEES','HEURES PAYES SUR LA PERIODE','','1',NULL,NULL,1,'','0',1,0),(17,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'HTRAV','HEURES TRAVAILLEES SUR LA PERIODE','','1',NULL,NULL,1,'','0',1,0),(18,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NHABS','HEURES ABSENCES SUR LA PERIODE','','1',NULL,NULL,1,'','0',1,0),(19,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'LOGEMENT','EST LOGE?','','1',NULL,NULL,1,'','0',1,0),(20,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'MANAGERE','DISPOSE MENAGE?','','1',NULL,NULL,1,'','0',1,0),(21,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ALIMENTAIRE','PENSION ALIMENTAIRE?','','1',NULL,NULL,1,'','0',1,0),(22,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'COMPSAL','COMPLEMENT SALAIRE','','1',NULL,NULL,1,'','0',1,0),(23,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SYNDIQUE','EST SYNDIQUE?','','1',NULL,NULL,1,'','0',1,0),(24,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TAUXSYNDICAL','TAUX SYNDICAL','','1',NULL,NULL,1,'','0',1,0),(25,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ANCIEN','ANCIENNITE (MOIS)','','1',NULL,NULL,1,'','0',1,0),(26,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'RETRAITECOMPL','RETRAITE COMPLEMENTAIRE','','1',NULL,NULL,1,'','0',1,0),(27,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'INDEMLOGEMENT','INDEMNITE LOGEMENT','','1',NULL,NULL,1,'','0',1,0),(28,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SALBASENEGO','SALAIRE DE BASE NEGOCIE','','1',NULL,NULL,1,'','0',1,0),(29,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NOEL','ARBRE NOEL','','1',NULL,NULL,1,'','0',1,0),(30,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'NMOIS','NBRE MOIS EXERCICE','','1',NULL,NULL,0,'','0',1,0),(31,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'MEDAILLE','MEDAILLES EMPLOYES','','1',NULL,NULL,1,'','0',1,0),(32,1,1,0,1,0,0,'ACOMPTE - ACOMPTE SALAIRE','Variable de paie',NULL,'Variables de paie','kerenpaie',0,'-144041932834708394','MTACOMPTE','ACOMPTE SALAIRE','','1',NULL,NULL,1,'','0',1,0),(33,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SBEX','Salaire de base exceptionnel','','1',1,1,1,'','0',1,0),(34,0,0,1528378368210,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SBB','SALAIRE DE BASE BRUT','','1',NULL,1,1,'','0',1,0),(35,1,1,1529417837964,1,0,0,'MTAXAVAN - Montant Taxes sur Avantages','Variable de paie',NULL,'Variables de paie','kerenpaie',0,'-144041932834708394','MTAXAVAN','Montant Taxes sur Avantages','','1',1,1,1,'','0',1,0),(36,0,0,1529417877926,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SBT','Salaire Brut Taxable','','1',1,1,1,'','0',1,0),(37,0,0,1529419143572,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'SALTAX','SALAIRE TAXABLE','','1',NULL,1,1,'','0',1,0),(38,1,1,1530111715779,1,0,0,'IRPP - Impôt sur le revenue par personne physique','Variable de paie',NULL,'Variables de paie','kerenpaie',0,'-144041932834708394','IRPP','Impôt sur le revenue par personne physique','if SBT<=62000 then\r\n    0\r\nelseif SBT<=310000 then\r\n   (SBT*0.7 - SBT * 2.8 - 41.667)*0.1\r\nelseif SBT <= 429000 then\r\n    (((SBT - 310000)*0.7)*0.15)+16693\r\nelseif SBT <= 667000 then\r\n    (((SBT-429000)*0.7)*0.25)+29188\r\nelse\r\n    (((SBT-667000)*0.7)*0.35)+70830 ','2',1,NULL,1,'1','3',1,0),(39,1,1,1530115213682,1,0,0,'IPPP - AZEZEE','Variable de paie',NULL,'Variables de paie','kerenpaie',0,'-144041932834708394','IPPP','AZEZEE','(((SBB - 310000)*0.7)*0.15)+16693','2',NULL,1,1,'0','3',1,0);
/*!40000 ALTER TABLE `t_vari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_view`
--

LOCK TABLES `t_view` WRITE;
/*!40000 ALTER TABLE `t_view` DISABLE KEYS */;
INSERT INTO `t_view` VALUES ('REPORT',5,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'rh_paie_rapport_all',NULL,NULL,0,'Generer les Bulletin',NULL,'ViewBulletinPaie',1,'pdf','kerenpaie','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kerenpaie\" entity=\"ViewBulletinPaie\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,136,0),('REPORT',6,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'rhpaie_brouillard01',NULL,NULL,0,'Brouillard des salaires',NULL,'BrouillardSalaire',1,'brouillard','kerenpaie','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"brouillard\" module=\"kerenpaie\" entity=\"BrouillardSalaire\"/>\n',NULL,NULL,NULL,NULL,NULL,NULL,136,0),('REPORT',7,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'rh_paie_rapport_EDT',NULL,NULL,0,'Generer les Bulletin',NULL,'ViewBulletinPaie',1,'pdf','kerenpaie','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kerenpaie\" entity=\"ViewBulletinPaie\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,150,0),('CALENDAR',8,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'rh_admin_calendar01',NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<calendarRecord allday=\"true\" startfield=\"debut\" titlefield=\"designation\" action_ref=\"rh_admin_2\" label=\"DEMANDE de CONGE\" id=\"rh_admin_calendar01\"/>\n',0,'DEMANDE de CONGE',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,'debut','designation',NULL,222,NULL,0),('CALENDAR',9,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'rh_admin_calendar02',NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<calendarRecord allday=\"true\" startfield=\"datepointage\" titlefield=\"designation\" action_ref=\"rh_admin_6\" label=\"PRESENCE JOURNALIER\" id=\"rh_admin_calendar02\"/>\n',0,'PRESENCE JOURNALIER',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,'datepointage','designation',NULL,227,NULL,0),('FORM',10,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_form01',NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<formRecord action_ref=\"base_account_07\" label=\"Banque\" id=\"base_account_form01\">\n    <header>\n        <button class=\"btn btn-primary\" value=\"{\'name\':\'base_account_07\'}\" label=\"Contact banque\" name=\"un button\" type=\"action\"/>\n        <button states=\"etabli\" class=\"btn btn-primary\" value=\"{\'model\':\'baseaccount\',\'entity\':\'Banque\',\'method\':\'workflow\'}\" label=\"Valider banque\" name=\"valider\" type=\"workflow\"/>\n        <field target=\"statusbar\" name=\"state\"/>\n    </header>\n    <sheet>\n        <field name=\"code\"/>\n        <field name=\"label\"/>\n        <field name=\"adresse\"/>\n        <field target=\"tel\" name=\"tel\"/>\n        <field target=\"tel\" name=\"fax\"/>\n        <field target=\"email\" name=\"courriel\"/>\n        <field name=\"active\"/>\n    </sheet>\n</formRecord>\n',0,'Banque',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,298,NULL,NULL,0),('Dashboard',11,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'dashboard_001',NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<dashboardRecord method_ref=\"dashboard\" model_ref=\"baseaccount\" entity_ref=\"ComptaDashboard\" action_ref=\"base_account_dashboard_01\" label=\"Tableau de Bord\" id=\"dashboard_001\">\n    <dashboard parent_ref=\"dashboard_001\" label=\"Trésorerie\" id=\"dashboard001\">\n        <dashboardentry parent_ref=\"dashboard001\" label=\"Données\" type=\"data,bar,pie,line\" id=\"dashentry001\">\n            <field method_ref=\"analytique\" model_ref=\"baseaccount\" entity_ref=\"EcritureComptable\" name=\"debit\"/>\n            <field name=\"credit\"/>\n        </dashboardentry>\n    </dashboard>\n    <dashboard parent_ref=\"dashboard_001\" label=\"Stock\" id=\"dashboard002\">\n        <dashboardentry parent_ref=\"dashboard001\" label=\"Données\" type=\"data\" id=\"dashentry001\">\n            <field name=\"debit\"/>\n            <field name=\"credit\"/>\n        </dashboardentry>\n        <dashboardentry parent_ref=\"dashboard001\" label=\"Graphe\" type=\"bar\" id=\"dashentry002\">\n            <field name=\"debit\"/>\n            <field name=\"credit\"/>\n        </dashboardentry>\n    </dashboard>\n    <dashboard parent_ref=\"dashboard_001\" label=\"Ventes\" id=\"dashboard003\">\n        <dashboardentry parent_ref=\"dashboard001\" label=\"Données\" type=\"data\" id=\"dashentry001\">\n            <field name=\"debit\"/>\n            <field name=\"credit\"/>\n        </dashboardentry>\n        <dashboardentry parent_ref=\"dashboard001\" label=\"Graphe\" type=\"bar\" id=\"dashentry002\">\n            <field name=\"debit\"/>\n            <field name=\"credit\"/>\n        </dashboardentry>\n    </dashboard>\n</dashboardRecord>\n',0,'Tableau de Bord',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,281,NULL,NULL,0),('TREE',12,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_tree01',NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<treeRecord action_ref=\"base_account_07\" label=\"Banques\" id=\"base_account_tree01\">\n    <field name=\"code\"/>\n    <field name=\"label\"/>\n    <field name=\"adresse\"/>\n    <field name=\"tel\"/>\n    <field name=\"fax\"/>\n    <field name=\"courriel\"/>\n</treeRecord>\n',0,'Banques',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,298,NULL,0),('REPORT',13,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report01',NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\"?><div for=\"{\'source\':\'datas\',\'var\':\'obj\'}\">\r\n			       <label>N Compte</label><p>obj.code</p>\r\n				   <label>Libelle</label><p>obj.libele</p>\r\n			       <table class=\"table  table-striped table-bordered table-hover table-condensed\">\r\n				       <thead> \r\n					      <tr style=\"font-weight: bold;\">\r\n						     <td>Section analytique</td><td>Clé repartition</td><td>quantité</td>\r\n						  </tr>\r\n					   </thead>\r\n					   <tbody>\r\n					      <tr for=\"{\'source\':\'obj.analytiques\',\'var\':\'obj\'}\">\r\n						     <td>obj.compte</td><td if=\"{\'op1\':\'obj.type\',\'op2\':\'0\',\'cond\':\'==\'}\">Pourcentage</td>\r\n							 <td if=\"{\'op1\':\'obj.type\',\'op2\':\'1\',\'cond\':\'==\'}\">Equilibre</td>\r\n							 <td if=\"{\'op1\':\'obj.type\',\'op2\':\'2\',\'cond\':\'==\'}\">Montant</td>\r\n							 <td>obj.quantite</td>\r\n						  </tr>\r\n					   </tbody>\r\n				   </table>\r\n			   </div>',0,'Situations',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,291,0),('REPORT',14,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report02',NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\"?><div>\r\n			       <table class=\"table  table-striped table-bordered table-hover table-condensed\">\r\n				       <thead> \r\n					      <tr style=\"font-weight: bold;\">\r\n						     <td>Date</td><td>N° pièce</td><td>Compte</td><td>Journal</td><td>Libelle</td><td>Débit</td><td>Crédit</td>\r\n						  </tr>\r\n					   </thead>\r\n					   <tbody>\r\n					      <tr for=\"{\'source\':\'requete\',\'var\':\'obj\'}\">\r\n						     <td>obj.dateEcriture</td><td>obj.refPiece</td><td>obj.compte</td>\r\n							 <td>obj.journal</td><td>obj.libelle</td><td>obj.debit</td><td>obj.credit</td>\r\n						  </tr>\r\n					   </tbody>\r\n				   </table>\r\n			   </div>',0,'Somethings',NULL,'EcritureSearch',0,'somethings','baseaccount','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"somethings\" module=\"baseaccount\" entity=\"EcritureSearch\">\n    <field name=\"code\"/>\n    <field name=\"libele\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,291,0),('REPORT',15,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report03',NULL,NULL,0,'IReport Report',NULL,'EcritureSearch',1,'pdf','baseaccount','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"baseaccount\" entity=\"EcritureSearch\">\n    <field name=\"code\"/>\n    <field name=\"libele\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,291,0);
/*!40000 ALTER TABLE `t_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_vill`
--

LOCK TABLES `t_vill` WRITE;
/*!40000 ALTER TABLE `t_vill` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_vill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `v_dipe_paie`
--

LOCK TABLES `v_dipe_paie` WRITE;
/*!40000 ALTER TABLE `v_dipe_paie` DISABLE KEYS */;
/*!40000 ALTER TABLE `v_dipe_paie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `v_laremlo`
--

LOCK TABLES `v_laremlo` WRITE;
/*!40000 ALTER TABLE `v_laremlo` DISABLE KEYS */;
/*!40000 ALTER TABLE `v_laremlo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-04 15:48:18
