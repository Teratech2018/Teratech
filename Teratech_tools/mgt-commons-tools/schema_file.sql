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
-- Table structure for table `canal_grp`
--

DROP TABLE IF EXISTS `canal_grp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `canal_grp` (
  `CAN_ID` bigint(20) NOT NULL,
  `GRP_ID` bigint(20) NOT NULL,
  KEY `FK195B22A1BBDA8BE0` (`CAN_ID`),
  KEY `FK195B22A14A1C2364` (`GRP_ID`),
  CONSTRAINT `FK195B22A14A1C2364` FOREIGN KEY (`GRP_ID`) REFERENCES `t_groupe` (`id`),
  CONSTRAINT `FK195B22A1BBDA8BE0` FOREIGN KEY (`CAN_ID`) REFERENCES `t_canal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `canal_user`
--

DROP TABLE IF EXISTS `canal_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `canal_user` (
  `CAN_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  KEY `FK120F918FBBDA8BE0` (`CAN_ID`),
  KEY `FK120F918F224ABC49` (`USER_ID`),
  CONSTRAINT `FK120F918F224ABC49` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK120F918FBBDA8BE0` FOREIGN KEY (`CAN_ID`) REFERENCES `t_canal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_abscence`
--

DROP TABLE IF EXISTS `e_abscence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_abscence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATE_ABS` date DEFAULT NULL,
  `HD` varchar(255) DEFAULT NULL,
  `HF` varchar(255) DEFAULT NULL,
  `OBS` varchar(255) DEFAULT NULL,
  `ANNEE_ID` bigint(20) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `TYPE_ABS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCCB37B1629F3B03E` (`CLASSE_ID`),
  KEY `FKCCB37B161B9DDF55` (`TYPE_ABS_ID`),
  KEY `FKCCB37B16F09BDF49` (`ANNEE_ID`),
  CONSTRAINT `FKCCB37B161B9DDF55` FOREIGN KEY (`TYPE_ABS_ID`) REFERENCES `e_tabscence` (`id`),
  CONSTRAINT `FKCCB37B1629F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FKCCB37B16F09BDF49` FOREIGN KEY (`ANNEE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_abscence_e_eleve`
--

DROP TABLE IF EXISTS `e_abscence_e_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_abscence_e_eleve` (
  `e_abscence_id` bigint(20) NOT NULL,
  `eleveList_id` bigint(20) NOT NULL,
  KEY `FK1C2D574AC07E9132` (`e_abscence_id`),
  KEY `FK1C2D574A9FA5C62E` (`eleveList_id`),
  CONSTRAINT `FK1C2D574A9FA5C62E` FOREIGN KEY (`eleveList_id`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FK1C2D574AC07E9132` FOREIGN KEY (`e_abscence_id`) REFERENCES `e_abscence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_annee`
--

DROP TABLE IF EXISTS `e_annee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_annee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `CONNECTED` tinyint(1) DEFAULT NULL,
  `D_DEBUT` varchar(255) DEFAULT NULL,
  `D_FIN` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_app`
--

DROP TABLE IF EXISTS `e_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CAPACITE` bigint(20) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DUREE` bigint(20) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `NIV_FORMT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_avance_prof`
--

DROP TABLE IF EXISTS `e_avance_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_avance_prof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `ZMNT` bigint(20) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DATE_PAI` date DEFAULT NULL,
  `TYP_PAI` varchar(255) DEFAULT NULL,
  `FM_ID` bigint(20) DEFAULT NULL,
  `PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF0A0E2DAEC57E265` (`FM_ID`),
  KEY `FKF0A0E2DAD25FEBC2` (`PAIE_ID`),
  CONSTRAINT `FKF0A0E2DAD25FEBC2` FOREIGN KEY (`PAIE_ID`) REFERENCES `e_reg_prof` (`id`),
  CONSTRAINT `FKF0A0E2DAEC57E265` FOREIGN KEY (`FM_ID`) REFERENCES `e_fpaie_prof` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_bstage`
--

DROP TABLE IF EXISTS `e_bstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_bstage` (
  `EBS` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ACT` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `demission` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `MOTIF` varchar(255) DEFAULT NULL,
  `NBRE_PL` smallint(6) DEFAULT NULL,
  `REF` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `LIEU_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B0C60F620CF8DB1` (`LIEU_ID`),
  CONSTRAINT `FK4B0C60F620CF8DB1` FOREIGN KEY (`LIEU_ID`) REFERENCES `e_lstage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_bul`
--

DROP TABLE IF EXISTS `e_bul`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_bul` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_bul_e_examen`
--

DROP TABLE IF EXISTS `e_bul_e_examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_bul_e_examen` (
  `e_bul_id` bigint(20) NOT NULL,
  `sequence_id` bigint(20) NOT NULL,
  KEY `FK270CAC25C102E9B` (`e_bul_id`),
  KEY `FK270CAC24DB218DA` (`sequence_id`),
  CONSTRAINT `FK270CAC24DB218DA` FOREIGN KEY (`sequence_id`) REFERENCES `e_examen` (`id`),
  CONSTRAINT `FK270CAC25C102E9B` FOREIGN KEY (`e_bul_id`) REFERENCES `e_bul` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_caisse`
--

DROP TABLE IF EXISTS `e_caisse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_caisse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `DATE_ENC` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `DEPENSE` bigint(20) DEFAULT NULL,
  `REVENU` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_classe`
--

DROP TABLE IF EXISTS `e_classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_classe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `EFFECTIF` bigint(20) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `TYP_FORMATION` varchar(255) DEFAULT NULL,
  `FILIERE_ID` bigint(20) DEFAULT NULL,
  `NIVEAU_ID` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `EFFECTIF` (`EFFECTIF`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`),
  KEY `FK4C5637071D405596` (`FILIERE_ID`),
  KEY `FK4C563707A1EDEE9E` (`NIVEAU_ID`),
  KEY `FK4C56370726A1B0B1` (`PROF_ID`),
  CONSTRAINT `FK4C5637071D405596` FOREIGN KEY (`FILIERE_ID`) REFERENCES `e_filiere` (`id`),
  CONSTRAINT `FK4C56370726A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK4C563707A1EDEE9E` FOREIGN KEY (`NIVEAU_ID`) REFERENCES `e_niv_cls` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_cmail`
--

DROP TABLE IF EXISTS `e_cmail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_cmail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PWORD` varchar(255) DEFAULT NULL,
  `SERVEUR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `PWORD` (`PWORD`),
  UNIQUE KEY `SERVEUR` (`SERVEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_coefmat`
--

DROP TABLE IF EXISTS `e_coefmat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_coefmat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK43C1925929F3B03E` (`CLASSE_ID`),
  CONSTRAINT `FK43C1925929F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_coefmatdtl`
--

DROP TABLE IF EXISTS `e_coefmatdtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_coefmatdtl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `COEF` bigint(20) DEFAULT NULL,
  `COUT_HEURE` bigint(20) DEFAULT NULL,
  `HEURE_TOTAL` bigint(20) DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  `COEF_MAT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDB2728E3CD3DF236` (`MATIERE_ID`),
  KEY `FKDB2728E3F0F24BD5` (`COEF_MAT_ID`),
  KEY `FKDB2728E326A1B0B1` (`PROF_ID`),
  CONSTRAINT `FKDB2728E326A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FKDB2728E3CD3DF236` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_matiere` (`id`),
  CONSTRAINT `FKDB2728E3F0F24BD5` FOREIGN KEY (`COEF_MAT_ID`) REFERENCES `e_coefmat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_contacts`
--

DROP TABLE IF EXISTS `e_contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `TELEPHONE` varchar(255) DEFAULT NULL,
  `VILLE` varchar(255) DEFAULT NULL,
  `CONTACTS_ID_ETB` bigint(20) DEFAULT NULL,
  `CONTACTS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK448C32EDE8F7F56D` (`CONTACTS_ID_ETB`),
  KEY `FK448C32ED95DD6C6` (`CONTACTS_ID`),
  CONSTRAINT `FK448C32ED95DD6C6` FOREIGN KEY (`CONTACTS_ID`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FK448C32EDE8F7F56D` FOREIGN KEY (`CONTACTS_ID_ETB`) REFERENCES `e_etbl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_diplome`
--

DROP TABLE IF EXISTS `e_diplome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_diplome` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_dlieu`
--

DROP TABLE IF EXISTS `e_dlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_dlieu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `DIV_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`),
  KEY `FK86A5A0F7C75F258D` (`DIV_ID`),
  CONSTRAINT `FK86A5A0F7C75F258D` FOREIGN KEY (`DIV_ID`) REFERENCES `e_lstage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_dossier`
--

DROP TABLE IF EXISTS `e_dossier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_dossier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ALLERTE_MEDICALE` varchar(255) DEFAULT NULL,
  `DATE_CONSULTATION` date DEFAULT NULL,
  `HEURE_ARRIVE` time DEFAULT NULL,
  `HEURE_DEPART` time DEFAULT NULL,
  `OBJET` varchar(255) DEFAULT NULL,
  `OBS` varchar(255) DEFAULT NULL,
  `REFERENCE_HOPITAL` varchar(255) DEFAULT NULL,
  `DOSSIER_MEDICALE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7972F0F19F69D411` (`DOSSIER_MEDICALE_ID`),
  CONSTRAINT `FK7972F0F19F69D411` FOREIGN KEY (`DOSSIER_MEDICALE_ID`) REFERENCES `e_eleve` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_ech_dlt`
--

DROP TABLE IF EXISTS `e_ech_dlt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_ech_dlt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `MNT` bigint(20) DEFAULT NULL,
  `DATE_ECH` date DEFAULT NULL,
  `ECH_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK993AD8DD56DECC9A` (`ECH_ID`),
  CONSTRAINT `FK993AD8DD56DECC9A` FOREIGN KEY (`ECH_ID`) REFERENCES `e_echeance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_echeance`
--

DROP TABLE IF EXISTS `e_echeance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_echeance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATE_DEBUT` date DEFAULT NULL,
  `PERIODE` varchar(255) DEFAULT NULL,
  `TYP_PLAN` varchar(255) DEFAULT NULL,
  `Nbre_ECH` bigint(20) DEFAULT NULL,
  `FICHE_PAI_ID` bigint(20) DEFAULT NULL,
  `Ech_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8E73788482B5B86C` (`Ech_ID`),
  KEY `FK8E737884655F9B7D` (`FICHE_PAI_ID`),
  CONSTRAINT `FK8E737884655F9B7D` FOREIGN KEY (`FICHE_PAI_ID`) REFERENCES `e_fpaie` (`id`),
  CONSTRAINT `FK8E73788482B5B86C` FOREIGN KEY (`Ech_ID`) REFERENCES `e_reglement` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_eleve`
--

DROP TABLE IF EXISTS `e_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_eleve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATENAIS` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `EMAIL_MERE` varchar(255) DEFAULT NULL,
  `EMAIL_PERE` varchar(255) DEFAULT NULL,
  `PHOTO` varchar(255) DEFAULT NULL,
  `L_NAIS` varchar(255) DEFAULT NULL,
  `MATRICULE` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `SEXE` varchar(255) DEFAULT NULL,
  `SITFAMILIALE` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `TEL_MERE` varchar(255) DEFAULT NULL,
  `TEL_PERE` varchar(255) DEFAULT NULL,
  `NATIONALITE_ID` bigint(20) DEFAULT NULL,
  `NIVEAU_ID` bigint(20) DEFAULT NULL,
  `PREFESSION_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK86B3AB73C8997E` (`PREFESSION_ID`),
  KEY `FK86B3AB73B3FB8AF0` (`NIVEAU_ID`),
  KEY `FK86B3AB735E3BB5AC` (`NATIONALITE_ID`),
  CONSTRAINT `FK86B3AB735E3BB5AC` FOREIGN KEY (`NATIONALITE_ID`) REFERENCES `e_nat` (`id`),
  CONSTRAINT `FK86B3AB73B3FB8AF0` FOREIGN KEY (`NIVEAU_ID`) REFERENCES `e_niv` (`id`),
  CONSTRAINT `FK86B3AB73C8997E` FOREIGN KEY (`PREFESSION_ID`) REFERENCES `e_prof` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_emarge`
--

DROP TABLE IF EXISTS `e_emarge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_emarge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `D_EMARG` date DEFAULT NULL,
  `CLS_ID` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4FCDFA9126A1B0B1` (`PROF_ID`),
  KEY `FK4FCDFA91D9978FE1` (`CLS_ID`),
  CONSTRAINT `FK4FCDFA9126A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK4FCDFA91D9978FE1` FOREIGN KEY (`CLS_ID`) REFERENCES `e_classe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_emarge_dlt`
--

DROP TABLE IF EXISTS `e_emarge_dlt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_emarge_dlt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `HEURE_DEBUT` varchar(255) DEFAULT NULL,
  `HEURE_FIN` varchar(255) DEFAULT NULL,
  `STATUT` varchar(255) DEFAULT NULL,
  `MAT_ID` bigint(20) DEFAULT NULL,
  `EMARG_DLT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6C68FE3E5A256387` (`EMARG_DLT_ID`),
  KEY `FK6C68FE3EE4521CE5` (`MAT_ID`),
  CONSTRAINT `FK6C68FE3E5A256387` FOREIGN KEY (`EMARG_DLT_ID`) REFERENCES `e_emarge` (`id`),
  CONSTRAINT `FK6C68FE3EE4521CE5` FOREIGN KEY (`MAT_ID`) REFERENCES `e_matiere` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_etbl`
--

DROP TABLE IF EXISTS `e_etbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_etbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DES` varchar(255) DEFAULT NULL,
  `ENTETE_ETAT` varchar(255) DEFAULT NULL,
  `FOOTER_ETAT` varchar(255) DEFAULT NULL,
  `LOGO` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_evastge`
--

DROP TABLE IF EXISTS `e_evastge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_evastge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CRITERE` varchar(255) DEFAULT NULL,
  `NOTE` varchar(255) DEFAULT NULL,
  `VAL_ID` bigint(20) DEFAULT NULL,
  `EVA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CRITERE` (`CRITERE`),
  KEY `FKB94D9AF57F897E9` (`VAL_ID`),
  KEY `FKB94D9AF5700D07E6` (`EVA_ID`),
  CONSTRAINT `FKB94D9AF5700D07E6` FOREIGN KEY (`EVA_ID`) REFERENCES `e_sstgeel` (`id`),
  CONSTRAINT `FKB94D9AF57F897E9` FOREIGN KEY (`VAL_ID`) REFERENCES `e_professeur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_examen`
--

DROP TABLE IF EXISTS `e_examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_examen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `STATUT` varchar(255) DEFAULT NULL,
  `SUR` bigint(20) DEFAULT NULL,
  `PERIODE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FK5068EA2254D33C3E` (`PERIODE_ID`),
  CONSTRAINT `FK5068EA2254D33C3E` FOREIGN KEY (`PERIODE_ID`) REFERENCES `e_periode` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_filiere`
--

DROP TABLE IF EXISTS `e_filiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_filiere` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CAPACITE` bigint(20) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DUREE` bigint(20) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `NIV_FORMT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_fpaie`
--

DROP TABLE IF EXISTS `e_fpaie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_fpaie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `TYP_REG` varchar(255) DEFAULT NULL,
  `MNT_PAI` bigint(20) DEFAULT NULL,
  `M_HT` bigint(20) DEFAULT NULL,
  `MNT_PAI_TMP` decimal(19,2) DEFAULT NULL,
  `QTE` bigint(20) DEFAULT NULL,
  `REMISE` bigint(20) DEFAULT NULL,
  `TOTAL_TTC` bigint(20) DEFAULT NULL,
  `TVA` bigint(20) DEFAULT NULL,
  `INS_ID` bigint(20) DEFAULT NULL,
  `SER_ID` bigint(20) DEFAULT NULL,
  `FICHE_PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK86C383D932E932EB` (`SER_ID`),
  KEY `FK86C383D9AED76507` (`FICHE_PAIE_ID`),
  KEY `FK86C383D982E69CA2` (`INS_ID`),
  CONSTRAINT `FK86C383D932E932EB` FOREIGN KEY (`SER_ID`) REFERENCES `e_service` (`id`),
  CONSTRAINT `FK86C383D982E69CA2` FOREIGN KEY (`INS_ID`) REFERENCES `e_inscription` (`id`),
  CONSTRAINT `FK86C383D9AED76507` FOREIGN KEY (`FICHE_PAIE_ID`) REFERENCES `e_reglement` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_fpaie_prof`
--

DROP TABLE IF EXISTS `e_fpaie_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_fpaie_prof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `COUT_TOTAL` bigint(20) DEFAULT NULL,
  `MOIS` varchar(255) DEFAULT NULL,
  `NHEMARGE` bigint(20) DEFAULT NULL,
  `NHPLANIF` bigint(20) DEFAULT NULL,
  `AVANCE` bigint(20) DEFAULT NULL,
  `PRIME` bigint(20) DEFAULT NULL,
  `RETENU` bigint(20) DEFAULT NULL,
  `P_ID` bigint(20) DEFAULT NULL,
  `HIS_PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3DB157FFA8B57415` (`HIS_PAIE_ID`),
  KEY `FK3DB157FF3947A83A` (`P_ID`),
  CONSTRAINT `FK3DB157FF3947A83A` FOREIGN KEY (`P_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK3DB157FFA8B57415` FOREIGN KEY (`HIS_PAIE_ID`) REFERENCES `e_reg_prof` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_inscription`
--

DROP TABLE IF EXISTS `e_inscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_inscription` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATE_INS` date DEFAULT NULL,
  `STATUT` varchar(255) DEFAULT NULL,
  `MNT` decimal(19,2) DEFAULT NULL,
  `MNT_PAYE` decimal(19,2) DEFAULT NULL,
  `SOLDE` decimal(19,2) DEFAULT NULL,
  `ANNEE_ID` bigint(20) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `ELEVE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCDFEAFE29F3B03E` (`CLASSE_ID`),
  KEY `FKCDFEAFE6DF650C` (`ELEVE_ID`),
  KEY `FKCDFEAFEF09BDF49` (`ANNEE_ID`),
  CONSTRAINT `FKCDFEAFE29F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FKCDFEAFE6DF650C` FOREIGN KEY (`ELEVE_ID`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FKCDFEAFEF09BDF49` FOREIGN KEY (`ANNEE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_jcours`
--

DROP TABLE IF EXISTS `e_jcours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_jcours` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `JOURS` varchar(255) DEFAULT NULL,
  `JOURS_COURS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK57CFB47A7CCECA88` (`JOURS_COURS_ID`),
  CONSTRAINT `FK57CFB47A7CCECA88` FOREIGN KEY (`JOURS_COURS_ID`) REFERENCES `e_plcours` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_lstage`
--

DROP TABLE IF EXISTS `e_lstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_lstage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_mail`
--

DROP TABLE IF EXISTS `e_mail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_mail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `OBJET` varchar(255) DEFAULT NULL,
  `CHOIX_DEST_MSG` varchar(255) DEFAULT NULL,
  `MSG` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_mail_e_eleve`
--

DROP TABLE IF EXISTS `e_mail_e_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_mail_e_eleve` (
  `e_mail_id` bigint(20) NOT NULL,
  `eleveList_id` bigint(20) NOT NULL,
  KEY `FK22ACA6859FA5C62E` (`eleveList_id`),
  KEY `FK22ACA685FD209836` (`e_mail_id`),
  CONSTRAINT `FK22ACA6859FA5C62E` FOREIGN KEY (`eleveList_id`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FK22ACA685FD209836` FOREIGN KEY (`e_mail_id`) REFERENCES `e_mail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_matiere`
--

DROP TABLE IF EXISTS `e_matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_matiere` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `FILIERE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`),
  KEY `FK3DB0ABD51D405596` (`FILIERE_ID`),
  CONSTRAINT `FK3DB0ABD51D405596` FOREIGN KEY (`FILIERE_ID`) REFERENCES `e_filiere` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_matierecoutprof`
--

DROP TABLE IF EXISTS `e_matierecoutprof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_matierecoutprof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `COUT_HEURE` bigint(20) DEFAULT NULL,
  `HEURE_TOTAL` bigint(20) DEFAULT NULL,
  `ANNEE_ID` bigint(20) DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  `MATIERE_ENS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8AEC5CB9CD3DF236` (`MATIERE_ID`),
  KEY `FK8AEC5CB9F09BDF49` (`ANNEE_ID`),
  KEY `FK8AEC5CB951240F4E` (`MATIERE_ENS_ID`),
  CONSTRAINT `FK8AEC5CB951240F4E` FOREIGN KEY (`MATIERE_ENS_ID`) REFERENCES `e_profmatens` (`id`),
  CONSTRAINT `FK8AEC5CB9CD3DF236` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_matiere` (`id`),
  CONSTRAINT `FK8AEC5CB9F09BDF49` FOREIGN KEY (`ANNEE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_module`
--

DROP TABLE IF EXISTS `e_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `COEF` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `UNITE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FK5D9257863EFA0D26` (`UNITE_ID`),
  KEY `FK5D92578629F3B03E` (`CLASSE_ID`),
  CONSTRAINT `FK5D92578629F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FK5D9257863EFA0D26` FOREIGN KEY (`UNITE_ID`) REFERENCES `e_unite_ens` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_module_e_matiere`
--

DROP TABLE IF EXISTS `e_module_e_matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_module_e_matiere` (
  `e_module_id` bigint(20) NOT NULL,
  `matiereList_id` bigint(20) NOT NULL,
  KEY `FK9C78CE5C50E51CB4` (`e_module_id`),
  KEY `FK9C78CE5CAC47B458` (`matiereList_id`),
  CONSTRAINT `FK9C78CE5C50E51CB4` FOREIGN KEY (`e_module_id`) REFERENCES `e_module` (`id`),
  CONSTRAINT `FK9C78CE5CAC47B458` FOREIGN KEY (`matiereList_id`) REFERENCES `e_matiere` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_nat`
--

DROP TABLE IF EXISTS `e_nat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_nat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_niv`
--

DROP TABLE IF EXISTS `e_niv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_niv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_niv_cls`
--

DROP TABLE IF EXISTS `e_niv_cls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_niv_cls` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_note`
--

DROP TABLE IF EXISTS `e_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `EXAMEN_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB1C7DF8C29F3B03E` (`CLASSE_ID`),
  KEY `FKB1C7DF8C793CFE33` (`EXAMEN_ID`),
  CONSTRAINT `FKB1C7DF8C29F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FKB1C7DF8C793CFE33` FOREIGN KEY (`EXAMEN_ID`) REFERENCES `e_examen` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_note_mat`
--

DROP TABLE IF EXISTS `e_note_mat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_note_mat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  `MATIERE_NOTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC4A20E2DCD3DF236` (`MATIERE_ID`),
  KEY `FKC4A20E2DB5B169A3` (`MATIERE_NOTE_ID`),
  CONSTRAINT `FKC4A20E2DB5B169A3` FOREIGN KEY (`MATIERE_NOTE_ID`) REFERENCES `e_note` (`id`),
  CONSTRAINT `FKC4A20E2DCD3DF236` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_matiere` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_notedlt`
--

DROP TABLE IF EXISTS `e_notedlt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_notedlt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `NOTE` bigint(20) DEFAULT NULL,
  `APPRECIATION` varchar(255) DEFAULT NULL,
  `ETUDIANT_ID` bigint(20) DEFAULT NULL,
  `EL_NOTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8A78E9E0948EE958` (`EL_NOTE_ID`),
  KEY `FK8A78E9E02BD6BD1D` (`ETUDIANT_ID`),
  CONSTRAINT `FK8A78E9E02BD6BD1D` FOREIGN KEY (`ETUDIANT_ID`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FK8A78E9E0948EE958` FOREIGN KEY (`EL_NOTE_ID`) REFERENCES `e_note_mat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_paie`
--

DROP TABLE IF EXISTS `e_paie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_paie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATE_PAI` date DEFAULT NULL,
  `TYP_PAI` varchar(255) DEFAULT NULL,
  `ZMNT` bigint(20) DEFAULT NULL,
  `F_ID` bigint(20) DEFAULT NULL,
  `PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB1C892672CD8D36D` (`F_ID`),
  KEY `FKB1C89267A0EF7249` (`PAIE_ID`),
  CONSTRAINT `FKB1C892672CD8D36D` FOREIGN KEY (`F_ID`) REFERENCES `e_fpaie` (`id`),
  CONSTRAINT `FKB1C89267A0EF7249` FOREIGN KEY (`PAIE_ID`) REFERENCES `e_reglement` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_paie_prof`
--

DROP TABLE IF EXISTS `e_paie_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_paie_prof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DATE_PAI` date DEFAULT NULL,
  `TYP_PAI` varchar(255) DEFAULT NULL,
  `ZMNT` bigint(20) DEFAULT NULL,
  `FM_ID` bigint(20) DEFAULT NULL,
  `PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3F53231EC57E265` (`FM_ID`),
  KEY `FK3F53231D25FEBC2` (`PAIE_ID`),
  CONSTRAINT `FK3F53231D25FEBC2` FOREIGN KEY (`PAIE_ID`) REFERENCES `e_reg_prof` (`id`),
  CONSTRAINT `FK3F53231EC57E265` FOREIGN KEY (`FM_ID`) REFERENCES `e_fpaie_prof` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_periode`
--

DROP TABLE IF EXISTS `e_periode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_periode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `D_DEBUT` varchar(255) DEFAULT NULL,
  `D_DEBUT_SAI_NOTE` varchar(255) DEFAULT NULL,
  `D_FIN` varchar(255) DEFAULT NULL,
  `D_FIN_SAI_NOTE` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `PERIODE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE31AB4EA2ED8BBE6` (`PERIODE_ID`),
  CONSTRAINT `FKE31AB4EA2ED8BBE6` FOREIGN KEY (`PERIODE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_plcours`
--

DROP TABLE IF EXISTS `e_plcours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_plcours` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CLASSE_ID` (`CLASSE_ID`),
  KEY `FKEE3C133429F3B03E` (`CLASSE_ID`),
  CONSTRAINT `FKEE3C133429F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_presence`
--

DROP TABLE IF EXISTS `e_presence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_presence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATE_PRS` date DEFAULT NULL,
  `HD` varchar(255) DEFAULT NULL,
  `HF` varchar(255) DEFAULT NULL,
  `OBS` varchar(255) DEFAULT NULL,
  `ANNEE_ID` bigint(20) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1A466F9529F3B03E` (`CLASSE_ID`),
  KEY `FK1A466F95F09BDF49` (`ANNEE_ID`),
  CONSTRAINT `FK1A466F9529F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FK1A466F95F09BDF49` FOREIGN KEY (`ANNEE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_presence_e_eleve`
--

DROP TABLE IF EXISTS `e_presence_e_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_presence_e_eleve` (
  `e_presence_id` bigint(20) NOT NULL,
  `eleveList_id` bigint(20) NOT NULL,
  KEY `FK7F7F5CC99FA5C62E` (`eleveList_id`),
  KEY `FK7F7F5CC96E63CCD2` (`e_presence_id`),
  CONSTRAINT `FK7F7F5CC96E63CCD2` FOREIGN KEY (`e_presence_id`) REFERENCES `e_presence` (`id`),
  CONSTRAINT `FK7F7F5CC99FA5C62E` FOREIGN KEY (`eleveList_id`) REFERENCES `e_eleve` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_prime_prof`
--

DROP TABLE IF EXISTS `e_prime_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_prime_prof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `OBS` varchar(255) DEFAULT NULL,
  `ZMNT` bigint(20) DEFAULT NULL,
  `FM_ID` bigint(20) DEFAULT NULL,
  `PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3BAF533EC57E265` (`FM_ID`),
  KEY `FK3BAF533D25FEBC2` (`PAIE_ID`),
  CONSTRAINT `FK3BAF533D25FEBC2` FOREIGN KEY (`PAIE_ID`) REFERENCES `e_reg_prof` (`id`),
  CONSTRAINT `FK3BAF533EC57E265` FOREIGN KEY (`FM_ID`) REFERENCES `e_fpaie_prof` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_prof`
--

DROP TABLE IF EXISTS `e_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_prof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_professeur`
--

DROP TABLE IF EXISTS `e_professeur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_professeur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `TELEPHONE` varchar(255) DEFAULT NULL,
  `DATENAIS` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PHOTO` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `NUM_BAN` bigint(20) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `SAL` bigint(20) DEFAULT NULL,
  `SEXE` varchar(255) DEFAULT NULL,
  `Tx_H` bigint(20) DEFAULT NULL,
  `DIP_ID` bigint(20) DEFAULT NULL,
  `STATUS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1D166D0857DEABB` (`DIP_ID`),
  KEY `FK1D166D014985D2D` (`STATUS_ID`),
  CONSTRAINT `FK1D166D014985D2D` FOREIGN KEY (`STATUS_ID`) REFERENCES `e_status` (`id`),
  CONSTRAINT `FK1D166D0857DEABB` FOREIGN KEY (`DIP_ID`) REFERENCES `e_diplome` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_profmatens`
--

DROP TABLE IF EXISTS `e_profmatens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_profmatens` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` bigint(20) DEFAULT NULL,
  `FIL_ID` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE7AF83D73B7B3C5` (`FIL_ID`),
  KEY `FKE7AF83D26A1B0B1` (`PROF_ID`),
  KEY `FKE7AF83DF09BDF49` (`ANNEE_ID`),
  CONSTRAINT `FKE7AF83D26A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FKE7AF83D73B7B3C5` FOREIGN KEY (`FIL_ID`) REFERENCES `e_filiere` (`id`),
  CONSTRAINT `FKE7AF83DF09BDF49` FOREIGN KEY (`ANNEE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_reduction`
--

DROP TABLE IF EXISTS `e_reduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_reduction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `POURCENTAGE` decimal(19,2) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `MNT` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_reg_prof`
--

DROP TABLE IF EXISTS `e_reg_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_reg_prof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `PAYER` bigint(20) DEFAULT NULL,
  `APAYER` bigint(20) DEFAULT NULL,
  `SOLD` bigint(20) DEFAULT NULL,
  `AVANCE` bigint(20) DEFAULT NULL,
  `PRIME` bigint(20) DEFAULT NULL,
  `RETENU` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3CACB2BE26A1B0B1` (`PROF_ID`),
  CONSTRAINT `FK3CACB2BE26A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_reglement`
--

DROP TABLE IF EXISTS `e_reglement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_reglement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `PAYER` bigint(20) DEFAULT NULL,
  `APAYER` bigint(20) DEFAULT NULL,
  `SOLD` bigint(20) DEFAULT NULL,
  `EL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6E7B3891CF37C149` (`EL_ID`),
  CONSTRAINT `FK6E7B3891CF37C149` FOREIGN KEY (`EL_ID`) REFERENCES `e_inscription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_retenue_prof`
--

DROP TABLE IF EXISTS `e_retenue_prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_retenue_prof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `OBS` varchar(255) DEFAULT NULL,
  `ZMNT` bigint(20) DEFAULT NULL,
  `FM_ID` bigint(20) DEFAULT NULL,
  `PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7C805CF8EC57E265` (`FM_ID`),
  KEY `FK7C805CF8D25FEBC2` (`PAIE_ID`),
  CONSTRAINT `FK7C805CF8D25FEBC2` FOREIGN KEY (`PAIE_ID`) REFERENCES `e_reg_prof` (`id`),
  CONSTRAINT `FK7C805CF8EC57E265` FOREIGN KEY (`FM_ID`) REFERENCES `e_fpaie_prof` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_service`
--

DROP TABLE IF EXISTS `e_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DELAI` date DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `MNT` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_service_e_filiere`
--

DROP TABLE IF EXISTS `e_service_e_filiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_service_e_filiere` (
  `e_service_id` bigint(20) NOT NULL,
  `filiere_id` bigint(20) NOT NULL,
  KEY `FK7CAE339A1D405596` (`filiere_id`),
  KEY `FK7CAE339A4C0E2090` (`e_service_id`),
  CONSTRAINT `FK7CAE339A1D405596` FOREIGN KEY (`filiere_id`) REFERENCES `e_filiere` (`id`),
  CONSTRAINT `FK7CAE339A4C0E2090` FOREIGN KEY (`e_service_id`) REFERENCES `e_service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_sms`
--

DROP TABLE IF EXISTS `e_sms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_sms` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CHOIX_DEST_MSG` varchar(255) DEFAULT NULL,
  `MSG` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_sms_e_eleve`
--

DROP TABLE IF EXISTS `e_sms_e_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_sms_e_eleve` (
  `e_sms_id` bigint(20) NOT NULL,
  `eleveList_id` bigint(20) NOT NULL,
  KEY `FK88A095B3D94681BE` (`e_sms_id`),
  KEY `FK88A095B39FA5C62E` (`eleveList_id`),
  CONSTRAINT `FK88A095B39FA5C62E` FOREIGN KEY (`eleveList_id`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FK88A095B3D94681BE` FOREIGN KEY (`e_sms_id`) REFERENCES `e_sms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_sstage`
--

DROP TABLE IF EXISTS `e_sstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_sstage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `REF` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `BS_ID` bigint(20) DEFAULT NULL,
  `CLS_ID` bigint(20) DEFAULT NULL,
  `SERVI_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK680EC385E7DB348B` (`SERVI_ID`),
  KEY `FK680EC385B5E85162` (`BS_ID`),
  KEY `FK680EC385D9978FE1` (`CLS_ID`),
  CONSTRAINT `FK680EC385B5E85162` FOREIGN KEY (`BS_ID`) REFERENCES `e_bstage` (`id`),
  CONSTRAINT `FK680EC385D9978FE1` FOREIGN KEY (`CLS_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FK680EC385E7DB348B` FOREIGN KEY (`SERVI_ID`) REFERENCES `e_dlieu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_sstgeel`
--

DROP TABLE IF EXISTS `e_sstgeel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_sstgeel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `VAL_FINAL` varchar(255) DEFAULT NULL,
  `E_CONTACT` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `E_NOM` varchar(255) DEFAULT NULL,
  `OBS` varchar(255) DEFAULT NULL,
  `ELEVE_ID` bigint(20) DEFAULT NULL,
  `BS_ID` bigint(20) DEFAULT NULL,
  `SERVI_ID` bigint(20) DEFAULT NULL,
  `ETU_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK99CC603FE7DB348B` (`SERVI_ID`),
  KEY `FK99CC603FD150EA5` (`ETU_ID`),
  KEY `FK99CC603F3EAE04B9` (`BS_ID`),
  KEY `FK99CC603FC9754C63` (`ELEVE_ID`),
  CONSTRAINT `FK99CC603F3EAE04B9` FOREIGN KEY (`BS_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK99CC603FC9754C63` FOREIGN KEY (`ELEVE_ID`) REFERENCES `e_inscription` (`id`),
  CONSTRAINT `FK99CC603FD150EA5` FOREIGN KEY (`ETU_ID`) REFERENCES `e_sstage` (`id`),
  CONSTRAINT `FK99CC603FE7DB348B` FOREIGN KEY (`SERVI_ID`) REFERENCES `e_dlieu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_stage`
--

DROP TABLE IF EXISTS `e_stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_stage` (
  `ES` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `MOTIF` varchar(255) DEFAULT NULL,
  `REF` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `BS_ID` bigint(20) DEFAULT NULL,
  `CLS_ID` bigint(20) DEFAULT NULL,
  `SERVI_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK877C86A4E7DB348B` (`SERVI_ID`),
  KEY `FK877C86A4B5E85162` (`BS_ID`),
  KEY `FK877C86A4D9978FE1` (`CLS_ID`),
  CONSTRAINT `FK877C86A4B5E85162` FOREIGN KEY (`BS_ID`) REFERENCES `e_bstage` (`id`),
  CONSTRAINT `FK877C86A4D9978FE1` FOREIGN KEY (`CLS_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FK877C86A4E7DB348B` FOREIGN KEY (`SERVI_ID`) REFERENCES `e_dlieu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_stage_e_inscription`
--

DROP TABLE IF EXISTS `e_stage_e_inscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_stage_e_inscription` (
  `e_stage_id` bigint(20) NOT NULL,
  `elevelist_id` bigint(20) NOT NULL,
  KEY `FK6D7D4A3623BAD85` (`elevelist_id`),
  KEY `FK6D7D4A38A897D36` (`e_stage_id`),
  CONSTRAINT `FK6D7D4A3623BAD85` FOREIGN KEY (`elevelist_id`) REFERENCES `e_inscription` (`id`),
  CONSTRAINT `FK6D7D4A38A897D36` FOREIGN KEY (`e_stage_id`) REFERENCES `e_stage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_status`
--

DROP TABLE IF EXISTS `e_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_tabscence`
--

DROP TABLE IF EXISTS `e_tabscence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_tabscence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_tachestge`
--

DROP TABLE IF EXISTS `e_tachestge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_tachestge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DIFFICULTE` varchar(255) DEFAULT NULL,
  `PROPOSITIONS` varchar(255) DEFAULT NULL,
  `TACHE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FK1D1605388924A7C3` (`TACHE_ID`),
  CONSTRAINT `FK1D1605388924A7C3` FOREIGN KEY (`TACHE_ID`) REFERENCES `e_sstgeel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_th_cours`
--

DROP TABLE IF EXISTS `e_th_cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_th_cours` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `HEURE_DEBUT` varchar(255) DEFAULT NULL,
  `HEURE_FIN` varchar(255) DEFAULT NULL,
  `ZNHT` bigint(20) DEFAULT NULL,
  `MAT_PROF_ID` bigint(20) DEFAULT NULL,
  `TRANCHE_COURS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9DB2EE99E0BFCE9C` (`MAT_PROF_ID`),
  KEY `FK9DB2EE99D406B38D` (`TRANCHE_COURS_ID`),
  CONSTRAINT `FK9DB2EE99D406B38D` FOREIGN KEY (`TRANCHE_COURS_ID`) REFERENCES `e_jcours` (`id`),
  CONSTRAINT `FK9DB2EE99E0BFCE9C` FOREIGN KEY (`MAT_PROF_ID`) REFERENCES `e_coefmatdtl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_unite_ens`
--

DROP TABLE IF EXISTS `e_unite_ens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_unite_ens` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  UNIQUE KEY `DESCRIPTION` (`DESCRIPTION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_visite`
--

DROP TABLE IF EXISTS `e_visite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_visite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ALLERTE_MEDICALE` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DATE_CONSULTATION` date DEFAULT NULL,
  `HEURE_ARRIVE` bigint(20) DEFAULT NULL,
  `HEURE_DEPART` bigint(20) DEFAULT NULL,
  `OBJET` varchar(255) DEFAULT NULL,
  `REFERENCE_HOPITAL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `e_zview_bul`
--

DROP TABLE IF EXISTS `e_zview_bul`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_zview_bul` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `MOY_CLA_MAT` double DEFAULT NULL,
  `BULLETIN_ID` bigint(20) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `COEF_ID` bigint(20) DEFAULT NULL,
  `EXAMEN_ID` bigint(20) DEFAULT NULL,
  `INS_ID` bigint(20) DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  `MODULE_ID` bigint(20) DEFAULT NULL,
  `NOTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK556474FFCD3DF236` (`MATIERE_ID`),
  KEY `FK556474FF29F3B03E` (`CLASSE_ID`),
  KEY `FK556474FF82E69CA2` (`INS_ID`),
  KEY `FK556474FF8F9C0064` (`NOTE_ID`),
  KEY `FK556474FFEB699C0E` (`MODULE_ID`),
  KEY `FK556474FFC0A8CB93` (`BULLETIN_ID`),
  KEY `FK556474FF793CFE33` (`EXAMEN_ID`),
  KEY `FK556474FF7A9D6B47` (`COEF_ID`),
  CONSTRAINT `FK556474FF29F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FK556474FF793CFE33` FOREIGN KEY (`EXAMEN_ID`) REFERENCES `e_examen` (`id`),
  CONSTRAINT `FK556474FF7A9D6B47` FOREIGN KEY (`COEF_ID`) REFERENCES `e_coefmatdtl` (`id`),
  CONSTRAINT `FK556474FF82E69CA2` FOREIGN KEY (`INS_ID`) REFERENCES `e_inscription` (`id`),
  CONSTRAINT `FK556474FF8F9C0064` FOREIGN KEY (`NOTE_ID`) REFERENCES `e_notedlt` (`id`),
  CONSTRAINT `FK556474FFC0A8CB93` FOREIGN KEY (`BULLETIN_ID`) REFERENCES `e_bul` (`id`),
  CONSTRAINT `FK556474FFCD3DF236` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_matiere` (`id`),
  CONSTRAINT `FK556474FFEB699C0E` FOREIGN KEY (`MODULE_ID`) REFERENCES `e_module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `email_copies`
--

DROP TABLE IF EXISTS `email_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_copies` (
  `Email_id` bigint(20) NOT NULL,
  `copies` varchar(255) DEFAULT NULL,
  KEY `FKFBD674F68ECD0446` (`Email_id`),
  CONSTRAINT `FKFBD674F68ECD0446` FOREIGN KEY (`Email_id`) REFERENCES `k_email` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `email_piecesjointes`
--

DROP TABLE IF EXISTS `email_piecesjointes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_piecesjointes` (
  `Email_id` bigint(20) NOT NULL,
  `piecesjointes` varchar(255) DEFAULT NULL,
  KEY `FK7BCB24508ECD0446` (`Email_id`),
  CONSTRAINT `FK7BCB24508ECD0446` FOREIGN KEY (`Email_id`) REFERENCES `k_email` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `k_email`
--

DROP TABLE IF EXISTS `k_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `k_email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CIB` varchar(255) NOT NULL,
  `SENT_D` datetime DEFAULT NULL,
  `SRC` varchar(255) NOT NULL,
  `SUB` varchar(255) NOT NULL,
  `MESS` longtext,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `k_terme`
--

DROP TABLE IF EXISTS `k_terme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `k_terme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `orign` varchar(255) DEFAULT NULL,
  `traduc` varchar(255) DEFAULT NULL,
  `LANG_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2650106588E89945` (`LANG_ID`),
  CONSTRAINT `FK2650106588E89945` FOREIGN KEY (`LANG_ID`) REFERENCES `t_langue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `liplafor_empl`
--

DROP TABLE IF EXISTS `liplafor_empl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liplafor_empl` (
  `LIPLFO_ID` bigint(20) NOT NULL,
  `EMPL_ID` bigint(20) NOT NULL,
  KEY `FKFF1AE9A2C5325ADA` (`EMPL_ID`),
  KEY `FKFF1AE9A247EAE858` (`LIPLFO_ID`),
  CONSTRAINT `FKFF1AE9A247EAE858` FOREIGN KEY (`LIPLFO_ID`) REFERENCES `t_liplforh` (`id`),
  CONSTRAINT `FKFF1AE9A2C5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `liplafor_form`
--

DROP TABLE IF EXISTS `liplafor_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liplafor_form` (
  `LIPLFO_ID` bigint(20) NOT NULL,
  `EMPL_ID` bigint(20) NOT NULL,
  KEY `FKFF1B65C2C5325ADA` (`EMPL_ID`),
  KEY `FKFF1B65C247EAE858` (`LIPLFO_ID`),
  CONSTRAINT `FKFF1B65C247EAE858` FOREIGN KEY (`LIPLFO_ID`) REFERENCES `t_liplforh` (`id`),
  CONSTRAINT `FKFF1B65C2C5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `m_action`
--

DROP TABLE IF EXISTS `m_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_action` (
  `ACTION` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `entityName` varchar(255) DEFAULT NULL,
  `hide` tinyint(1) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `modal` tinyint(1) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `securitylevel` smallint(6) NOT NULL,
  `viewMode` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `requete` varchar(255) DEFAULT NULL,
  `AC_ID` bigint(20) DEFAULT NULL,
  `MOD_ID` bigint(20) DEFAULT NULL,
  `ACT_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK52ECEE6876B222F1` (`AC_ID`),
  KEY `FK52ECEE68C35C6179` (`ACT_ID`),
  KEY `FK52ECEE68ED94853F` (`MOD_ID`),
  CONSTRAINT `FK52ECEE6876B222F1` FOREIGN KEY (`AC_ID`) REFERENCES `m_agroup` (`id`),
  CONSTRAINT `FK52ECEE68C35C6179` FOREIGN KEY (`ACT_ID`) REFERENCES `m_action` (`id`),
  CONSTRAINT `FK52ECEE68ED94853F` FOREIGN KEY (`MOD_ID`) REFERENCES `m_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `m_agroup`
--

DROP TABLE IF EXISTS `m_agroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_agroup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `securitylevel` smallint(6) NOT NULL,
  `showmenu` tinyint(1) NOT NULL,
  `AG_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK53247AF032D05D9B` (`AG_ID`),
  CONSTRAINT `FK53247AF032D05D9B` FOREIGN KEY (`AG_ID`) REFERENCES `m_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `m_module`
--

DROP TABLE IF EXISTS `m_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `application` tinyint(1) NOT NULL,
  `auto_install` tinyint(1) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `entityName` varchar(255) DEFAULT NULL,
  `hasmenu` tinyint(1) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `installable` tinyint(1) NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `longDescription` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `ORDRE` smallint(6) DEFAULT NULL,
  `shortDescription` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_acom`
--

DROP TABLE IF EXISTS `t_acom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_acom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `COMP_ID` bigint(20) DEFAULT NULL,
  `JOCO_ID` bigint(20) DEFAULT NULL,
  `MORE_ID` bigint(20) DEFAULT NULL,
  `FAC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B05E8B9B33B87B` (`COMP_ID`),
  KEY `FK94B05E8BED70B2C1` (`JOCO_ID`),
  KEY `FK94B05E8BBDAB7FA7` (`FAC_ID`),
  KEY `FK94B05E8B2854CF86` (`MORE_ID`),
  KEY `FK94B05E8B3E0A66A3` (`COMP_ID`),
  KEY `FK94B05E8B3201CEE9` (`JOCO_ID`),
  KEY `FK94B05E8B2594C791` (`FAC_ID`),
  KEY `FK94B05E8B9AD3E835` (`MORE_ID`),
  CONSTRAINT `FK94B05E8B2594C791` FOREIGN KEY (`FAC_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK94B05E8B2854CF86` FOREIGN KEY (`MORE_ID`) REFERENCES `t_more` (`id`),
  CONSTRAINT `FK94B05E8B3201CEE9` FOREIGN KEY (`JOCO_ID`) REFERENCES `t_jcomptable` (`id`),
  CONSTRAINT `FK94B05E8B3E0A66A3` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B05E8B9AD3E835` FOREIGN KEY (`MORE_ID`) REFERENCES `t_more` (`id`),
  CONSTRAINT `FK94B05E8B9B33B87B` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B05E8BBDAB7FA7` FOREIGN KEY (`FAC_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK94B05E8BED70B2C1` FOREIGN KEY (`JOCO_ID`) REFERENCES `t_jcomptable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_acomp`
--

DROP TABLE IF EXISTS `t_acomp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_acomp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `effet` date DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `ELVAP_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `VAR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK15B73254F9BE711` (`VAR_ID`),
  KEY `FK15B7325DF45A7D2` (`ELVAP_ID`),
  KEY `FK15B732529AE54FA` (`EMPL_ID`),
  CONSTRAINT `FK15B732529AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK15B73254F9BE711` FOREIGN KEY (`VAR_ID`) REFERENCES `t_vari` (`id`),
  CONSTRAINT `FK15B7325DF45A7D2` FOREIGN KEY (`ELVAP_ID`) REFERENCES `t_elvap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_actmisrh`
--

DROP TABLE IF EXISTS `t_actmisrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_actmisrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `objectif` varchar(255) DEFAULT NULL,
  `resultat` varchar(255) DEFAULT NULL,
  `INDPER_ID` bigint(20) DEFAULT NULL,
  `MISS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF9A2CD066E160B22` (`MISS_ID`),
  KEY `FKF9A2CD06F6C237F2` (`MISS_ID`),
  KEY `FKF9A2CD06C1BA27AE` (`INDPER_ID`),
  CONSTRAINT `FKF9A2CD066E160B22` FOREIGN KEY (`MISS_ID`) REFERENCES `t_missirh` (`id`),
  CONSTRAINT `FKF9A2CD06C1BA27AE` FOREIGN KEY (`INDPER_ID`) REFERENCES `t_indperfrh` (`id`),
  CONSTRAINT `FKF9A2CD06F6C237F2` FOREIGN KEY (`MISS_ID`) REFERENCES `t_missirh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_aff_canrh`
--

DROP TABLE IF EXISTS `t_aff_canrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_aff_canrh` (
  `T_BESRECRH_id` bigint(20) NOT NULL,
  `candidatures_id` bigint(20) NOT NULL,
  KEY `FKAC1D8EBD12AAC268` (`candidatures_id`),
  KEY `FKAC1D8EBDA5A8E3B0` (`T_BESRECRH_id`),
  CONSTRAINT `FKAC1D8EBD12AAC268` FOREIGN KEY (`candidatures_id`) REFERENCES `t_cansporh` (`id`),
  CONSTRAINT `FKAC1D8EBDA5A8E3B0` FOREIGN KEY (`T_BESRECRH_id`) REFERENCES `t_besrecrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_afferh`
--

DROP TABLE IF EXISTS `t_afferh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_afferh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `decision` date DEFAULT NULL,
  `deffet` date DEFAULT NULL,
  `lieuA` varchar(255) DEFAULT NULL,
  `lieuN` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `FONCA_ID` bigint(20) DEFAULT NULL,
  `FONCN_ID` bigint(20) DEFAULT NULL,
  `POSTA_ID` bigint(20) DEFAULT NULL,
  `POSTN_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK2A3903254E0C7DDE` (`POSTN_ID`),
  KEY `FK2A3903257CA60D3C` (`FONCA_ID`),
  KEY `FK2A3903257CABF60F` (`FONCN_ID`),
  KEY `FK2A390325C5325ADA` (`EMPL_ID`),
  KEY `FK2A3903254E06950B` (`POSTA_ID`),
  CONSTRAINT `FK2A3903254E06950B` FOREIGN KEY (`POSTA_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK2A3903254E0C7DDE` FOREIGN KEY (`POSTN_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK2A3903257CA60D3C` FOREIGN KEY (`FONCA_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK2A3903257CABF60F` FOREIGN KEY (`FONCN_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK2A390325C5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_apof`
--

DROP TABLE IF EXISTS `t_apof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_apof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `datecommande` date DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `typeselection` varchar(255) DEFAULT NULL,
  `UTIL_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B08F5160F32152` (`UTIL_ID`),
  CONSTRAINT `FK94B08F5160F32152` FOREIGN KEY (`UTIL_ID`) REFERENCES `t_tier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_art`
--

DROP TABLE IF EXISTS `t_art`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_art` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `achete` tinyint(1) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codebarre` varchar(255) DEFAULT NULL,
  `coutstockage` double DEFAULT NULL,
  `couttransp` double DEFAULT NULL,
  `delaiL` smallint(6) DEFAULT NULL,
  `garantie` smallint(6) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `poidbrut` double DEFAULT NULL,
  `poidnet` double DEFAULT NULL,
  `politiquestock` varchar(255) DEFAULT NULL,
  `puachat` double DEFAULT NULL,
  `puvente` double DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unitepoid` varchar(255) DEFAULT NULL,
  `vendu` tinyint(1) DEFAULT NULL,
  `FAAR_ID` bigint(20) DEFAULT NULL,
  `ART_ID` bigint(20) DEFAULT NULL,
  `UNAC_ID` bigint(20) DEFAULT NULL,
  `UNGE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4CBE3D817EC1F92` (`UNGE_ID`),
  KEY `FK4CBE3D8502AF09D` (`FAAR_ID`),
  KEY `FK4CBE3D8A34DDE9E` (`UNAC_ID`),
  KEY `FK4CBE3D8CB8813E6` (`ART_ID`),
  KEY `FK4CBE3D83BEB6C40` (`UNGE_ID`),
  KEY `FK4CBE3D87189C9CB` (`FAAR_ID`),
  KEY `FK4CBE3D8F6747ECC` (`UNAC_ID`),
  KEY `FK4CBE3D8D2DB1278` (`ART_ID`),
  KEY `FK4CBE3D867347763` (`UNGE_ID`),
  KEY `FK4CBE3D8EEBC982E` (`FAAR_ID`),
  KEY `FK4CBE3D8D5BBF6AF` (`UNAC_ID`),
  KEY `FK4CBE3D88B4A5D75` (`ART_ID`),
  CONSTRAINT `FK4CBE3D817EC1F92` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK4CBE3D83BEB6C40` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK4CBE3D8502AF09D` FOREIGN KEY (`FAAR_ID`) REFERENCES `t_faar` (`id`),
  CONSTRAINT `FK4CBE3D867347763` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK4CBE3D87189C9CB` FOREIGN KEY (`FAAR_ID`) REFERENCES `t_faar` (`id`),
  CONSTRAINT `FK4CBE3D88B4A5D75` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK4CBE3D8A34DDE9E` FOREIGN KEY (`UNAC_ID`) REFERENCES `t_unac` (`id`),
  CONSTRAINT `FK4CBE3D8CB8813E6` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK4CBE3D8D2DB1278` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK4CBE3D8D5BBF6AF` FOREIGN KEY (`UNAC_ID`) REFERENCES `t_unac` (`id`),
  CONSTRAINT `FK4CBE3D8EEBC982E` FOREIGN KEY (`FAAR_ID`) REFERENCES `t_faar` (`id`),
  CONSTRAINT `FK4CBE3D8F6747ECC` FOREIGN KEY (`UNAC_ID`) REFERENCES `t_unac` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_avancrh`
--

DROP TABLE IF EXISTS `t_avancrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_avancrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `deffet` date DEFAULT NULL,
  `denreg` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `CATA_ID` bigint(20) DEFAULT NULL,
  `CATN_ID` bigint(20) DEFAULT NULL,
  `ECHEA_ID` bigint(20) DEFAULT NULL,
  `ECHEN_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK37F2566C86F60106` (`CATN_ID`),
  KEY `FK37F2566C86F01833` (`CATA_ID`),
  KEY `FK37F2566C3C8FED51` (`ECHEA_ID`),
  KEY `FK37F2566CC5325ADA` (`EMPL_ID`),
  KEY `FK37F2566C3C95D624` (`ECHEN_ID`),
  CONSTRAINT `FK37F2566C3C8FED51` FOREIGN KEY (`ECHEA_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK37F2566C3C95D624` FOREIGN KEY (`ECHEN_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK37F2566C86F01833` FOREIGN KEY (`CATA_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK37F2566C86F60106` FOREIGN KEY (`CATN_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK37F2566CC5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_avsap`
--

DROP TABLE IF EXISTS `t_avsap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_avsap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `duree` smallint(6) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK16423C244289C74` (`RUBR_ID`),
  KEY `FK16423C23D09BA56` (`EMP_ID`),
  CONSTRAINT `FK16423C23D09BA56` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK16423C244289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_banque`
--

DROP TABLE IF EXISTS `t_banque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_banque` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `courriel` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_besformrh`
--

DROP TABLE IF EXISTS `t_besformrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_besformrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cout` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `note` longtext,
  `state` varchar(255) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK5E397C3F8DFB8BF8` (`SOC_ID`),
  CONSTRAINT `FK5E397C3F8DFB8BF8` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_besrecrh`
--

DROP TABLE IF EXISTS `t_besrecrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_besrecrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `motivation` varchar(255) DEFAULT NULL,
  `place` smallint(6) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `VILL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9DFFFC1C63DD65B` (`EMP_ID`),
  KEY `FKC9DFFFC1416F38A` (`VILL_ID`),
  CONSTRAINT `FKC9DFFFC1416F38A` FOREIGN KEY (`VILL_ID`) REFERENCES `t_vill` (`id`),
  CONSTRAINT `FKC9DFFFC1C63DD65B` FOREIGN KEY (`EMP_ID`) REFERENCES `t_emplrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_besstarh`
--

DROP TABLE IF EXISTS `t_besstarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_besstarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ddebut` date DEFAULT NULL,
  `demission` date DEFAULT NULL,
  `description` longtext,
  `dfin` date DEFAULT NULL,
  `justif` longtext,
  `place` smallint(6) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `SPEC_ID` bigint(20) DEFAULT NULL,
  `STRUC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9F4E1512F154200` (`STRUC_ID`),
  KEY `FKC9F4E1519E01852F` (`SPEC_ID`),
  CONSTRAINT `FKC9F4E1512F154200` FOREIGN KEY (`STRUC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKC9F4E1519E01852F` FOREIGN KEY (`SPEC_ID`) REFERENCES `t_speci` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_bonifrh`
--

DROP TABLE IF EXISTS `t_bonifrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bonifrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `deffet` date DEFAULT NULL,
  `denreg` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `CATA_ID` bigint(20) DEFAULT NULL,
  `CATN_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK619B9C4986F60106` (`CATN_ID`),
  KEY `FK619B9C4986F01833` (`CATA_ID`),
  KEY `FK619B9C49C5325ADA` (`EMPL_ID`),
  CONSTRAINT `FK619B9C4986F01833` FOREIGN KEY (`CATA_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK619B9C4986F60106` FOREIGN KEY (`CATN_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK619B9C49C5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_bupa`
--

DROP TABLE IF EXISTS `t_bupa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bupa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `dpayement` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `PEPA_ID` bigint(20) DEFAULT NULL,
  `ANC` double DEFAULT NULL,
  `ANG` double DEFAULT NULL,
  `ANA` double DEFAULT NULL,
  `CPA` double DEFAULT NULL,
  `CSA` double DEFAULT NULL,
  `CAC` double DEFAULT NULL,
  `CRE` double DEFAULT NULL,
  `CPR` double DEFAULT NULL,
  `CAN` double DEFAULT NULL,
  `CCP` double DEFAULT NULL,
  `CCS` double DEFAULT NULL,
  `CHT` double DEFAULT NULL,
  `CHS` double DEFAULT NULL,
  `CSB` double DEFAULT NULL,
  `CSC` double DEFAULT NULL,
  `CSE` double DEFAULT NULL,
  `CST` double DEFAULT NULL,
  `SBB` double DEFAULT NULL,
  `SCO` double DEFAULT NULL,
  `SEX` double DEFAULT NULL,
  `STA` double DEFAULT NULL,
  `TAAV` double DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B1168F3D09BA56` (`EMP_ID`),
  KEY `FK94B1168F1C92BCC7` (`PEPA_ID`),
  CONSTRAINT `FK94B1168F1C92BCC7` FOREIGN KEY (`PEPA_ID`) REFERENCES `t_pepa` (`id`),
  CONSTRAINT `FK94B1168F3D09BA56` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_camodrh`
--

DROP TABLE IF EXISTS `t_camodrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_camodrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_canal`
--

DROP TABLE IF EXISTS `t_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_canal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `confidentialite` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `publication` varchar(255) DEFAULT NULL,
  `sendMail` tinyint(1) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_canalytique`
--

DROP TABLE IF EXISTS `t_canalytique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_canalytique` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `classe` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `reportANouveau` tinyint(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `NA_ID` bigint(20) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFA6C3F83FE9761EC` (`NA_ID`),
  KEY `FKFA6C3F8349EACEA9` (`SOC_ID`),
  KEY `FKFA6C3F83E1F22A87` (`NA_ID`),
  KEY `FKFA6C3F83A3826672` (`SOC_ID`),
  KEY `FKFA6C3F83F0D5559E` (`NA_ID`),
  KEY `FKFA6C3F83E6AFF6C4` (`NA_ID`),
  KEY `FKFA6C3F835BF1B16F` (`SOC_ID`),
  KEY `FKFA6C3F83B6F3837E` (`NA_ID`),
  CONSTRAINT `FKFA6C3F8349EACEA9` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKFA6C3F835BF1B16F` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKFA6C3F83A3826672` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKFA6C3F83B6F3837E` FOREIGN KEY (`NA_ID`) REFERENCES `t_nanalyse` (`id`),
  CONSTRAINT `FKFA6C3F83E1F22A87` FOREIGN KEY (`NA_ID`) REFERENCES `t_nanalyse` (`id`),
  CONSTRAINT `FKFA6C3F83E6AFF6C4` FOREIGN KEY (`NA_ID`) REFERENCES `t_nanalyse` (`id`),
  CONSTRAINT `FKFA6C3F83F0D5559E` FOREIGN KEY (`NA_ID`) REFERENCES `t_nanalyse` (`id`),
  CONSTRAINT `FKFA6C3F83FE9761EC` FOREIGN KEY (`NA_ID`) REFERENCES `t_nanalyse` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cansporh`
--

DROP TABLE IF EXISTS `t_cansporh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cansporh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `naissa` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `quatier` varchar(255) DEFAULT NULL,
  `resume` longtext,
  `statut` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `PAY_ID` bigint(20) DEFAULT NULL,
  `VIL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55B34923B7FC5D24` (`VIL_ID`),
  KEY `FK55B34923AB2443EC` (`PAY_ID`),
  CONSTRAINT `FK55B34923AB2443EC` FOREIGN KEY (`PAY_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK55B34923B7FC5D24` FOREIGN KEY (`VIL_ID`) REFERENCES `t_vill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_capr`
--

DROP TABLE IF EXISTS `t_capr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_capr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `suiviestock` tinyint(1) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_caprp`
--

DROP TABLE IF EXISTS `t_caprp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_caprp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `duree` smallint(6) DEFAULT NULL,
  `gelee` tinyint(1) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK176BDC544289C74` (`RUBR_ID`),
  CONSTRAINT `FK176BDC544289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cat`
--

DROP TABLE IF EXISTS `t_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` smallint(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cat_ech`
--

DROP TABLE IF EXISTS `t_cat_ech`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cat_ech` (
  `CAT_ID` bigint(20) NOT NULL,
  `ECH_ID` bigint(20) NOT NULL,
  KEY `FK7EFC86762AF4BF0D` (`ECH_ID`),
  KEY `FK7EFC867649B3B5E8` (`CAT_ID`),
  KEY `FK7EFC8676C678C4ED` (`ECH_ID`),
  KEY `FK7EFC8676144DC3C8` (`CAT_ID`),
  CONSTRAINT `FK7EFC8676144DC3C8` FOREIGN KEY (`CAT_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK7EFC86762AF4BF0D` FOREIGN KEY (`ECH_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK7EFC867649B3B5E8` FOREIGN KEY (`CAT_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK7EFC8676C678C4ED` FOREIGN KEY (`ECH_ID`) REFERENCES `t_eche` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_catfrarh`
--

DROP TABLE IF EXISTS `t_catfrarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_catfrarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `COMP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK5F39DF802D565729` (`COMP_ID`),
  CONSTRAINT `FK5F39DF802D565729` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_catmisrh`
--

DROP TABLE IF EXISTS `t_catmisrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_catmisrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cbancaire`
--

DROP TABLE IF EXISTS `t_cbancaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cbancaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `CB_ID` bigint(20) DEFAULT NULL,
  `CPT_ID` bigint(20) DEFAULT NULL,
  `principal` tinyint(1) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFA01BA73EA769C7` (`CB_ID`),
  KEY `FKFA01BA791B77C5F` (`CPT_ID`),
  KEY `FKFA01BA7F44E02E2` (`CB_ID`),
  KEY `FKFA01BA7AE72136A` (`CPT_ID`),
  KEY `FKFA01BA76F2EE04B` (`CB_ID`),
  KEY `FKFA01BA74E16829F` (`CB_ID`),
  KEY `FKFA01BA7171DF18D` (`CPT_ID`),
  KEY `FKFA01BA7D88DC036` (`EMP_ID`),
  KEY `FKFA01BA7F7D68E6B` (`CB_ID`),
  CONSTRAINT `FKFA01BA7171DF18D` FOREIGN KEY (`CPT_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FKFA01BA73EA769C7` FOREIGN KEY (`CB_ID`) REFERENCES `t_banque` (`id`),
  CONSTRAINT `FKFA01BA74E16829F` FOREIGN KEY (`CB_ID`) REFERENCES `t_banque` (`id`),
  CONSTRAINT `FKFA01BA76F2EE04B` FOREIGN KEY (`CB_ID`) REFERENCES `t_banque` (`id`),
  CONSTRAINT `FKFA01BA791B77C5F` FOREIGN KEY (`CPT_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FKFA01BA7AE72136A` FOREIGN KEY (`CPT_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FKFA01BA7D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FKFA01BA7F44E02E2` FOREIGN KEY (`CB_ID`) REFERENCES `t_banque` (`id`),
  CONSTRAINT `FKFA01BA7F7D68E6B` FOREIGN KEY (`CB_ID`) REFERENCES `t_banque` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cessarh`
--

DROP TABLE IF EXISTS `t_cessarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cessarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `cause` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `decision` date DEFAULT NULL,
  `motif` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK85BC4FCAC5325ADA` (`EMPL_ID`),
  CONSTRAINT `FK85BC4FCAC5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_civilite`
--

DROP TABLE IF EXISTS `t_civilite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_civilite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `shortcut` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cocorh`
--

DROP TABLE IF EXISTS `t_cocorh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cocorh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2E205059D88DC036` (`EMP_ID`),
  CONSTRAINT `FK2E205059D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_compte`
--

DROP TABLE IF EXISTS `t_compte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_compte` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `lettrage` varchar(255) DEFAULT NULL,
  `libele` varchar(255) DEFAULT NULL,
  `nature` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `reportdesanouveau` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `TAXE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2E24E00B2B07ADEA` (`TAXE_ID`),
  KEY `FK2E24E00B49EACEA9` (`SOC_ID`),
  KEY `FK2E24E00B113ABAEF` (`TAXE_ID`),
  KEY `FK2E24E00BA3826672` (`SOC_ID`),
  KEY `FK2E24E00B3C83C612` (`TAXE_ID`),
  KEY `FK2E24E00B5BF1B16F` (`SOC_ID`),
  KEY `FK2FF6D82B8C0169F8` (`TAXE_ID`),
  KEY `FK2FF6D82B60FE2018` (`TAXE_ID`),
  CONSTRAINT `FK2E24E00B113ABAEF` FOREIGN KEY (`TAXE_ID`) REFERENCES `t_taxe` (`id`),
  CONSTRAINT `FK2E24E00B2B07ADEA` FOREIGN KEY (`TAXE_ID`) REFERENCES `t_taxe` (`id`),
  CONSTRAINT `FK2E24E00B3C83C612` FOREIGN KEY (`TAXE_ID`) REFERENCES `t_taxe` (`id`),
  CONSTRAINT `FK2E24E00B49EACEA9` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK2E24E00B5BF1B16F` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK2E24E00BA3826672` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK2FF6D82B60FE2018` FOREIGN KEY (`TAXE_ID`) REFERENCES `t_taxe` (`id`),
  CONSTRAINT `FK2FF6D82B8C0169F8` FOREIGN KEY (`TAXE_ID`) REFERENCES `t_taxe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_comrubrp`
--

DROP TABLE IF EXISTS `t_comrubrp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_comrubrp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `CHPAT_ID` bigint(20) DEFAULT NULL,
  `CHSAL_ID` bigint(20) DEFAULT NULL,
  `TIERPAT_ID` bigint(20) DEFAULT NULL,
  `TIERSAL_ID` bigint(20) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3889ABA744289C74` (`RUBR_ID`),
  KEY `FK3889ABA7DF6AA27F` (`CHSAL_ID`),
  KEY `FK3889ABA74184163C` (`TIERSAL_ID`),
  KEY `FK3889ABA7C3617E18` (`SOC_ID`),
  KEY `FK3889ABA7DA4FBB9A` (`CHPAT_ID`),
  KEY `FK3889ABA73C692F57` (`TIERPAT_ID`),
  CONSTRAINT `FK3889ABA73C692F57` FOREIGN KEY (`TIERPAT_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK3889ABA74184163C` FOREIGN KEY (`TIERSAL_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK3889ABA744289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK3889ABA7C3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK3889ABA7DA4FBB9A` FOREIGN KEY (`CHPAT_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK3889ABA7DF6AA27F` FOREIGN KEY (`CHSAL_ID`) REFERENCES `t_compte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_contact`
--

DROP TABLE IF EXISTS `t_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `courriel` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `poste` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `CIV_ID` bigint(20) DEFAULT NULL,
  `CONT_ID` bigint(20) DEFAULT NULL,
  `CON_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9686C315D648C326` (`CONT_ID`),
  KEY `FK9686C315DA074F7B` (`CIV_ID`),
  KEY `FK9686C31591A6AAA4` (`CON_ID`),
  KEY `FK9686C315B95596D4` (`CONT_ID`),
  KEY `FK9686C3155A396906` (`CIV_ID`),
  KEY `FK9686C315AE6141AF` (`CON_ID`),
  KEY `FK9686C315ECFAB77` (`CONT_ID`),
  KEY `FK9686C315AFB37DA9` (`CIV_ID`),
  KEY `FK9686C315170D1FD2` (`CON_ID`),
  CONSTRAINT `FK9686C315170D1FD2` FOREIGN KEY (`CON_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK9686C3155A396906` FOREIGN KEY (`CIV_ID`) REFERENCES `t_civilite` (`id`),
  CONSTRAINT `FK9686C31591A6AAA4` FOREIGN KEY (`CON_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK9686C315AE6141AF` FOREIGN KEY (`CON_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK9686C315AFB37DA9` FOREIGN KEY (`CIV_ID`) REFERENCES `t_civilite` (`id`),
  CONSTRAINT `FK9686C315B95596D4` FOREIGN KEY (`CONT_ID`) REFERENCES `t_entr` (`id`),
  CONSTRAINT `FK9686C315D648C326` FOREIGN KEY (`CONT_ID`) REFERENCES `t_entr` (`id`),
  CONSTRAINT `FK9686C315DA074F7B` FOREIGN KEY (`CIV_ID`) REFERENCES `t_civilite` (`id`),
  CONSTRAINT `FK9686C315ECFAB77` FOREIGN KEY (`CONT_ID`) REFERENCES `t_entr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_conv`
--

DROP TABLE IF EXISTS `t_conv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_conv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B1743F44289C74` (`RUBR_ID`),
  CONSTRAINT `FK94B1743F44289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cotrp`
--

DROP TABLE IF EXISTS `t_cotrp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cotrp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `darret` date DEFAULT NULL,
  `dessai` date DEFAULT NULL,
  `drecurtement` date DEFAULT NULL,
  `fessai` date DEFAULT NULL,
  `gele` smallint(6) DEFAULT NULL,
  `indice` smallint(6) DEFAULT NULL,
  `lieuaff` varchar(255) DEFAULT NULL,
  `lieurecr` varchar(255) DEFAULT NULL,
  `medialles` smallint(6) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `CATE_ID` bigint(20) DEFAULT NULL,
  `ECHE_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `FONC_ID` bigint(20) DEFAULT NULL,
  `TYCO_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK17D29FB6A586DC` (`ECHE_ID`),
  KEY `FK17D29FBBC57DBCF` (`CATE_ID`),
  KEY `FK17D29FB6A2A24E1` (`FONC_ID`),
  KEY `FK17D29FB29AE54FA` (`EMPL_ID`),
  KEY `FK17D29FB7DD07CCF` (`TYCO_ID`),
  KEY `FK17D29FBA2298CBC` (`ECHE_ID`),
  KEY `FK17D29FB86F1E9AF` (`CATE_ID`),
  KEY `FK17D29FB3F26DB01` (`FONC_ID`),
  KEY `FK17D29FBC5325ADA` (`EMPL_ID`),
  KEY `FK17D29FBA1E92AF` (`TYCO_ID`),
  CONSTRAINT `FK17D29FB29AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK17D29FB3F26DB01` FOREIGN KEY (`FONC_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK17D29FB6A2A24E1` FOREIGN KEY (`FONC_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK17D29FB6A586DC` FOREIGN KEY (`ECHE_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK17D29FB7DD07CCF` FOREIGN KEY (`TYCO_ID`) REFERENCES `t_tycon` (`id`),
  CONSTRAINT `FK17D29FB86F1E9AF` FOREIGN KEY (`CATE_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK17D29FBA1E92AF` FOREIGN KEY (`TYCO_ID`) REFERENCES `t_tycon` (`id`),
  CONSTRAINT `FK17D29FBA2298CBC` FOREIGN KEY (`ECHE_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK17D29FBBC57DBCF` FOREIGN KEY (`CATE_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK17D29FBC5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_cpayment`
--

DROP TABLE IF EXISTS `t_cpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cpayment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `jours` smallint(6) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_de_csrh`
--

DROP TABLE IF EXISTS `t_de_csrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_de_csrh` (
  `CC_ID` bigint(20) NOT NULL,
  `DE_ID` bigint(20) NOT NULL,
  KEY `FKBB44A2B9F5A05FCA` (`DE_ID`),
  KEY `FKBB44A2B9E8F910E3` (`CC_ID`),
  CONSTRAINT `FKBB44A2B9E8F910E3` FOREIGN KEY (`CC_ID`) REFERENCES `t_cocorh` (`id`),
  CONSTRAINT `FKBB44A2B9F5A05FCA` FOREIGN KEY (`DE_ID`) REFERENCES `t_deexrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_decorh`
--

DROP TABLE IF EXISTS `t_decorh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_decorh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `compensation` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `duree` smallint(6) DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `finEffetif` date DEFAULT NULL,
  `joursp` smallint(6) DEFAULT NULL,
  `motif` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `DEPE_ID` bigint(20) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `TYP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2F483DEEE2BB0F79` (`TYP_ID`),
  KEY `FK2F483DEE3D09BA56` (`EMP_ID`),
  KEY `FK2F483DEE9F9A0FC4` (`DEPE_ID`),
  KEY `FK2F483DEE7E3F1559` (`TYP_ID`),
  KEY `FK2F483DEED88DC036` (`EMP_ID`),
  KEY `FK2F483DEE50BA2DA4` (`DEPE_ID`),
  CONSTRAINT `FK2F483DEE3D09BA56` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK2F483DEE50BA2DA4` FOREIGN KEY (`DEPE_ID`) REFERENCES `t_depsoc` (`id`),
  CONSTRAINT `FK2F483DEE7E3F1559` FOREIGN KEY (`TYP_ID`) REFERENCES `t_typcon` (`id`),
  CONSTRAINT `FK2F483DEE9F9A0FC4` FOREIGN KEY (`DEPE_ID`) REFERENCES `t_depsoc` (`id`),
  CONSTRAINT `FK2F483DEED88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK2F483DEEE2BB0F79` FOREIGN KEY (`TYP_ID`) REFERENCES `t_typcon` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_deexrh`
--

DROP TABLE IF EXISTS `t_deexrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_deexrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `dated` date DEFAULT NULL,
  `daten` date DEFAULT NULL,
  `motif` longtext,
  `reference` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `AUT_ID` bigint(20) DEFAULT NULL,
  `DES_ID` bigint(20) DEFAULT NULL,
  `TYDE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2F49487529967B25` (`TYDE_ID`),
  KEY `FK2F494875D66988AC` (`DES_ID`),
  KEY `FK2F494875D22CEB3E` (`AUT_ID`),
  CONSTRAINT `FK2F49487529967B25` FOREIGN KEY (`TYDE_ID`) REFERENCES `t_tydme` (`id`),
  CONSTRAINT `FK2F494875D22CEB3E` FOREIGN KEY (`AUT_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK2F494875D66988AC` FOREIGN KEY (`DES_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_demforrh`
--

DROP TABLE IF EXISTS `t_demforrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_demforrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `decision` longtext,
  `motif` longtext,
  `objet` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `BEFO_ID` bigint(20) DEFAULT NULL,
  `DEMA_ID` bigint(20) DEFAULT NULL,
  `STRU_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8EC0EFBE198C821A` (`BEFO_ID`),
  KEY `FK8EC0EFBE534F77FB` (`STRU_ID`),
  KEY `FK8EC0EFBE82761409` (`DEMA_ID`),
  CONSTRAINT `FK8EC0EFBE198C821A` FOREIGN KEY (`BEFO_ID`) REFERENCES `t_besformrh` (`id`),
  CONSTRAINT `FK8EC0EFBE534F77FB` FOREIGN KEY (`STRU_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK8EC0EFBE82761409` FOREIGN KEY (`DEMA_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_dep`
--

DROP TABLE IF EXISTS `t_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_dep` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  `REG_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4CBED841861A8C9` (`REG_ID`),
  KEY `FK4CBED84ED5E5EE9` (`REG_ID`),
  CONSTRAINT `FK4CBED841861A8C9` FOREIGN KEY (`REG_ID`) REFERENCES `t_region` (`id`),
  CONSTRAINT `FK4CBED84ED5E5EE9` FOREIGN KEY (`REG_ID`) REFERENCES `t_region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_deploirh`
--

DROP TABLE IF EXISTS `t_deploirh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_deploirh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ddebut` datetime DEFAULT NULL,
  `dfin` datetime DEFAULT NULL,
  `SAL_ID` bigint(20) DEFAULT NULL,
  `VIL_ID` bigint(20) DEFAULT NULL,
  `MISS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9433E4D86E160B22` (`MISS_ID`),
  KEY `FK9433E4D8B7FC5D24` (`VIL_ID`),
  KEY `FK9433E4D8EFC6AD60` (`SAL_ID`),
  CONSTRAINT `FK9433E4D86E160B22` FOREIGN KEY (`MISS_ID`) REFERENCES `t_missirh` (`id`),
  CONSTRAINT `FK9433E4D8B7FC5D24` FOREIGN KEY (`VIL_ID`) REFERENCES `t_vill` (`id`),
  CONSTRAINT `FK9433E4D8EFC6AD60` FOREIGN KEY (`SAL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_deprp`
--

DROP TABLE IF EXISTS `t_deprp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_deprp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `dpret` date DEFAULT NULL,
  `drembour` date DEFAULT NULL,
  `duree` smallint(6) DEFAULT NULL,
  `montantpro` double DEFAULT NULL,
  `montantsol` double DEFAULT NULL,
  `quotite` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `CAPR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK186A6C27F8D5AB7` (`CAPR_ID`),
  KEY `FK186A6C229AE54FA` (`EMPL_ID`),
  CONSTRAINT `FK186A6C229AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK186A6C27F8D5AB7` FOREIGN KEY (`CAPR_ID`) REFERENCES `t_caprp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_depsoc`
--

DROP TABLE IF EXISTS `t_depsoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_depsoc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `DEP_ID` bigint(20) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `POSTE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2F4E3563F3600F4B` (`DEP_ID`),
  KEY `FK2F4E35633D09BA56` (`EMP_ID`),
  KEY `FK2F4E3563A4802D2B` (`DEP_ID`),
  KEY `FK2F4E3563D88DC036` (`EMP_ID`),
  KEY `FK2F4E35633F7C68A7` (`POSTE_ID`),
  CONSTRAINT `FK2F4E35633D09BA56` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK2F4E35633F7C68A7` FOREIGN KEY (`POSTE_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK2F4E3563A4802D2B` FOREIGN KEY (`DEP_ID`) REFERENCES `t_depsoc` (`id`),
  CONSTRAINT `FK2F4E3563D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK2F4E3563F3600F4B` FOREIGN KEY (`DEP_ID`) REFERENCES `t_depsoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_detrecrh`
--

DROP TABLE IF EXISTS `t_detrecrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_detrecrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `niveau` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `ETAREC_ID` bigint(20) DEFAULT NULL,
  `DETREC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9B57321EA96532D4` (`DETREC_ID`),
  KEY `FK9B57321EAFA264C2` (`ETAREC_ID`),
  CONSTRAINT `FK9B57321EA96532D4` FOREIGN KEY (`DETREC_ID`) REFERENCES `t_recrurh` (`id`),
  CONSTRAINT `FK9B57321EAFA264C2` FOREIGN KEY (`ETAREC_ID`) REFERENCES `t_etaprh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_devise`
--

DROP TABLE IF EXISTS `t_devise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_devise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_diplo`
--

DROP TABLE IF EXISTS `t_diplo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_diplo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_doac`
--

DROP TABLE IF EXISTS `t_doac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_doac` (
  `DOAC` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codefourni` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `datecommande` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `typedocument` int(11) DEFAULT NULL,
  `facturerecue` tinyint(1) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `escompte` double DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `transport` double DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `FOUR_ID` bigint(20) DEFAULT NULL,
  `CORE_ID` bigint(20) DEFAULT NULL,
  `COMP_ID` bigint(20) DEFAULT NULL,
  `DOAC_ID` bigint(20) DEFAULT NULL,
  `JOCO_ID` bigint(20) DEFAULT NULL,
  `dateoffre` date DEFAULT NULL,
  `validiteoffre` date DEFAULT NULL,
  `origine` varchar(255) DEFAULT NULL,
  `APOF_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B1E6F89B33B87B` (`COMP_ID`),
  KEY `FK94B1E6F8ED70B2C1` (`JOCO_ID`),
  KEY `FK94B1E6F8BA32CC80` (`FOUR_ID`),
  KEY `FK94B1E6F89A79B201` (`DOAC_ID`),
  KEY `FK94B1E6F8C1A30217` (`CORE_ID`),
  KEY `FK94B1E6F8786EDBCC` (`EMPL_ID`),
  KEY `FK94B1E6F83E0A66A3` (`COMP_ID`),
  KEY `FK94B1E6F83201CEE9` (`JOCO_ID`),
  KEY `FK94B1E6F83F9941AE` (`FOUR_ID`),
  KEY `FK94B1E6F84F2CC638` (`DOAC_ID`),
  KEY `FK94B1E6F8DB48F4EB` (`DOAC_ID`),
  KEY `FK94B1E6F8A6D8A2AB` (`APOF_ID`),
  KEY `FK94B1E6F8A4FCE7A9` (`CORE_ID`),
  KEY `FK94B1E6F893C3C5DB` (`EMPL_ID`),
  CONSTRAINT `FK94B1E6F83201CEE9` FOREIGN KEY (`JOCO_ID`) REFERENCES `t_jcomptable` (`id`),
  CONSTRAINT `FK94B1E6F83E0A66A3` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B1E6F83F9941AE` FOREIGN KEY (`FOUR_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B1E6F84F2CC638` FOREIGN KEY (`DOAC_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK94B1E6F8786EDBCC` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B1E6F893C3C5DB` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B1E6F89A79B201` FOREIGN KEY (`DOAC_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK94B1E6F89B33B87B` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B1E6F8A4FCE7A9` FOREIGN KEY (`CORE_ID`) REFERENCES `t_cpayment` (`id`),
  CONSTRAINT `FK94B1E6F8A6D8A2AB` FOREIGN KEY (`APOF_ID`) REFERENCES `t_apof` (`id`),
  CONSTRAINT `FK94B1E6F8BA32CC80` FOREIGN KEY (`FOUR_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B1E6F8C1A30217` FOREIGN KEY (`CORE_ID`) REFERENCES `t_cpayment` (`id`),
  CONSTRAINT `FK94B1E6F8DB48F4EB` FOREIGN KEY (`DOAC_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK94B1E6F8ED70B2C1` FOREIGN KEY (`JOCO_ID`) REFERENCES `t_jcomptable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_docba`
--

DROP TABLE IF EXISTS `t_docba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_docba` (
  `OP` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EN_ID` bigint(20) DEFAULT NULL,
  `CIBL_ID` bigint(20) DEFAULT NULL,
  `EMCI_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK18AFFACF0AC8B39` (`EN_ID`),
  KEY `FK18AFFAC2CEF2541` (`CIBL_ID`),
  KEY `FK18AFFAC8963B2B4` (`EMCI_ID`),
  KEY `FK18AFFACFA540FB6` (`EN_ID`),
  CONSTRAINT `FK18AFFAC2CEF2541` FOREIGN KEY (`CIBL_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK18AFFAC8963B2B4` FOREIGN KEY (`EMCI_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK18AFFACF0AC8B39` FOREIGN KEY (`EN_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK18AFFACFA540FB6` FOREIGN KEY (`EN_ID`) REFERENCES `t_empl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_eche`
--

DROP TABLE IF EXISTS `t_eche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_eche` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_ecre`
--

DROP TABLE IF EXISTS `t_ecre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ecre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `etat` tinyint(1) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `MORE_ID` bigint(20) DEFAULT NULL,
  `ECRE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B2305C9852CEBE` (`ECRE_ID`),
  KEY `FK94B2305C2854CF86` (`MORE_ID`),
  KEY `FK94B2305C3C16A8` (`ECRE_ID`),
  KEY `FK94B2305C9AD3E835` (`MORE_ID`),
  CONSTRAINT `FK94B2305C2854CF86` FOREIGN KEY (`MORE_ID`) REFERENCES `t_more` (`id`),
  CONSTRAINT `FK94B2305C3C16A8` FOREIGN KEY (`ECRE_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK94B2305C9852CEBE` FOREIGN KEY (`ECRE_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK94B2305C9AD3E835` FOREIGN KEY (`MORE_ID`) REFERENCES `t_more` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_ecrit_anal`
--

DROP TABLE IF EXISTS `t_ecrit_anal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ecrit_anal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `credit` decimal(19,2) DEFAULT NULL,
  `dateEcriture` date DEFAULT NULL,
  `debit` decimal(19,2) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `refPiece` varchar(255) DEFAULT NULL,
  `CPTE_ID` bigint(20) DEFAULT NULL,
  `EXER_ID` bigint(20) DEFAULT NULL,
  `ECRIT_ANAL_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5D54EE836FFBE3C1` (`EXER_ID`),
  KEY `FK5D54EE8356920FC3` (`ECRIT_ANAL_ID`),
  KEY `FK5D54EE83F3E1A017` (`CPTE_ID`),
  CONSTRAINT `FK5D54EE8356920FC3` FOREIGN KEY (`ECRIT_ANAL_ID`) REFERENCES `t_ecriture` (`id`),
  CONSTRAINT `FK5D54EE836FFBE3C1` FOREIGN KEY (`EXER_ID`) REFERENCES `t_exercmble` (`id`),
  CONSTRAINT `FK5D54EE83F3E1A017` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_canalytique` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_ecrit_tier`
--

DROP TABLE IF EXISTS `t_ecrit_tier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ecrit_tier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `credit` decimal(19,2) DEFAULT NULL,
  `dateEcriture` date DEFAULT NULL,
  `debit` decimal(19,2) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `refPiece` varchar(255) DEFAULT NULL,
  `CPTE_ID` bigint(20) DEFAULT NULL,
  `EXER_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5D5D7F4D6FFBE3C1` (`EXER_ID`),
  KEY `FK5D5D7F4D1D20F308` (`CPTE_ID`),
  CONSTRAINT `FK5D5D7F4D1D20F308` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK5D5D7F4D6FFBE3C1` FOREIGN KEY (`EXER_ID`) REFERENCES `t_exercmble` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_ecriture`
--

DROP TABLE IF EXISTS `t_ecriture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ecriture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `credit` decimal(19,2) DEFAULT NULL,
  `dateEcriture` date DEFAULT NULL,
  `debit` decimal(19,2) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `refPiece` varchar(255) DEFAULT NULL,
  `CPTE_ID` bigint(20) DEFAULT NULL,
  `ECRIT_TIER_ID` bigint(20) DEFAULT NULL,
  `EXER_ID` bigint(20) DEFAULT NULL,
  `JRN_ID` bigint(20) DEFAULT NULL,
  `JRNSAISIE_ID` bigint(20) DEFAULT NULL,
  `TIER_ID` bigint(20) DEFAULT NULL,
  `PIEC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK958A78D423AC4336` (`JRNSAISIE_ID`),
  KEY `FK958A78D46FFBE3C1` (`EXER_ID`),
  KEY `FK958A78D43D7970E9` (`PIEC_ID`),
  KEY `FK958A78D493AB7E44` (`TIER_ID`),
  KEY `FK958A78D49D46358C` (`CPTE_ID`),
  KEY `FK958A78D4FE66DAEC` (`JRN_ID`),
  KEY `FK958A78D4280C3C38` (`ECRIT_TIER_ID`),
  CONSTRAINT `FK958A78D423AC4336` FOREIGN KEY (`JRNSAISIE_ID`) REFERENCES `t_jrnsaisie` (`id`),
  CONSTRAINT `FK958A78D4280C3C38` FOREIGN KEY (`ECRIT_TIER_ID`) REFERENCES `t_ecrit_tier` (`id`),
  CONSTRAINT `FK958A78D43D7970E9` FOREIGN KEY (`PIEC_ID`) REFERENCES `t_piececmle` (`id`),
  CONSTRAINT `FK958A78D46FFBE3C1` FOREIGN KEY (`EXER_ID`) REFERENCES `t_exercmble` (`id`),
  CONSTRAINT `FK958A78D493AB7E44` FOREIGN KEY (`TIER_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK958A78D49D46358C` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK958A78D4FE66DAEC` FOREIGN KEY (`JRN_ID`) REFERENCES `t_jcomptable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_elsalp`
--

DROP TABLE IF EXISTS `t_elsalp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_elsalp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `alimentaire` tinyint(1) DEFAULT NULL,
  `eau` tinyint(1) DEFAULT NULL,
  `electricite` tinyint(1) DEFAULT NULL,
  `logement` tinyint(1) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `valeur` double DEFAULT NULL,
  `vehicule` tinyint(1) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `SYND_ID` bigint(20) DEFAULT NULL,
  `menagere` tinyint(1) DEFAULT NULL,
  `aliMode` varchar(255) DEFAULT NULL,
  `eauMode` varchar(255) DEFAULT NULL,
  `elecMode` varchar(255) DEFAULT NULL,
  `logeMode` varchar(255) DEFAULT NULL,
  `menMode` varchar(255) DEFAULT NULL,
  `vehMode` varchar(255) DEFAULT NULL,
  `logMode` tinyint(1) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3166CBC429AE54FA` (`EMPL_ID`),
  KEY `FK3166CBC4DDFA9A76` (`SYND_ID`),
  CONSTRAINT `FK3166CBC429AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK3166CBC4DDFA9A76` FOREIGN KEY (`SYND_ID`) REFERENCES `t_syndicatp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_elsalrub`
--

DROP TABLE IF EXISTS `t_elsalrub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_elsalrub` (
  `ELSA_ID` bigint(20) NOT NULL,
  `RUBR_ID` bigint(20) NOT NULL,
  KEY `FK72E2FCD344289C74` (`RUBR_ID`),
  KEY `FK72E2FCD3EC1F8CE4` (`ELSA_ID`),
  CONSTRAINT `FK72E2FCD344289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK72E2FCD3EC1F8CE4` FOREIGN KEY (`ELSA_ID`) REFERENCES `t_elsalp` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_elvap`
--

DROP TABLE IF EXISTS `t_elvap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_elvap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `PEPA_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `CAP` smallint(6) DEFAULT NULL,
  `CPP` smallint(6) DEFAULT NULL,
  `CCA` smallint(6) DEFAULT NULL,
  `CCP` smallint(6) DEFAULT NULL,
  `CCSA` double DEFAULT NULL,
  `CANA` double DEFAULT NULL,
  `CCPA` double DEFAULT NULL,
  `CHS` double DEFAULT NULL,
  `CHT` double DEFAULT NULL,
  `CJT` double DEFAULT NULL,
  `CSBB` double DEFAULT NULL,
  `CSCO` double DEFAULT NULL,
  `CSEX` double DEFAULT NULL,
  `CSTA` double DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK19801531C92BCC7` (`PEPA_ID`),
  KEY `FK198015329AE54FA` (`EMPL_ID`),
  CONSTRAINT `FK19801531C92BCC7` FOREIGN KEY (`PEPA_ID`) REFERENCES `t_pepa` (`id`),
  CONSTRAINT `FK198015329AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_empl`
--

DROP TABLE IF EXISTS `t_empl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_empl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codebarre` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `couloir` varchar(255) DEFAULT NULL,
  `hauteur` varchar(255) DEFAULT NULL,
  `rayon` varchar(255) DEFAULT NULL,
  `rebus` tinyint(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ENTR_ID` bigint(20) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `TIER_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B255AF3EB40551` (`ENTR_ID`),
  KEY `FK94B255AF93AB7E44` (`TIER_ID`),
  KEY `FK94B255AF8BCA4128` (`EMP_ID`),
  KEY `FK94B255AF21C0D8FF` (`ENTR_ID`),
  KEY `FK94B255AFB066154F` (`TIER_ID`),
  KEY `FK94B255AF9D77A6BA` (`EMP_ID`),
  KEY `FK94B255AF773AEDA2` (`ENTR_ID`),
  KEY `FK94B255AF1911F372` (`TIER_ID`),
  KEY `FK94B255AFA71F2B37` (`EMP_ID`),
  CONSTRAINT `FK94B255AF1911F372` FOREIGN KEY (`TIER_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B255AF21C0D8FF` FOREIGN KEY (`ENTR_ID`) REFERENCES `t_entr` (`id`),
  CONSTRAINT `FK94B255AF3EB40551` FOREIGN KEY (`ENTR_ID`) REFERENCES `t_entr` (`id`),
  CONSTRAINT `FK94B255AF773AEDA2` FOREIGN KEY (`ENTR_ID`) REFERENCES `t_entr` (`id`),
  CONSTRAINT `FK94B255AF8BCA4128` FOREIGN KEY (`EMP_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B255AF93AB7E44` FOREIGN KEY (`TIER_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B255AF9D77A6BA` FOREIGN KEY (`EMP_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B255AFA71F2B37` FOREIGN KEY (`EMP_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B255AFB066154F` FOREIGN KEY (`TIER_ID`) REFERENCES `t_tier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_employ`
--

DROP TABLE IF EXISTS `t_employ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_employ` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `adresse1` varchar(255) DEFAULT NULL,
  `adresse2` varchar(255) DEFAULT NULL,
  `affecte` tinyint(1) DEFAULT NULL,
  `alimentaire` tinyint(1) DEFAULT NULL,
  `anciennite` double DEFAULT NULL,
  `ANGELE` double DEFAULT NULL,
  `cmplsalaire` double DEFAULT NULL,
  `cni` varchar(255) DEFAULT NULL,
  `comptebancaire` varchar(255) DEFAULT NULL,
  `contribuable` varchar(255) DEFAULT NULL,
  `cv` varchar(255) DEFAULT NULL,
  `datedelivrance` date DEFAULT NULL,
  `dipe` varchar(255) DEFAULT NULL,
  `eau` tinyint(1) DEFAULT NULL,
  `electricite` tinyint(1) DEFAULT NULL,
  `etatcivil` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `handicape` tinyint(1) DEFAULT NULL,
  `IDEMLOG` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `indice` smallint(6) DEFAULT NULL,
  `lieuaffectation` varchar(255) DEFAULT NULL,
  `lieudelivrance` varchar(255) DEFAULT NULL,
  `lieudenaiss` varchar(255) DEFAULT NULL,
  `lieurecrut` varchar(255) DEFAULT NULL,
  `logement` tinyint(1) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `menagere` tinyint(1) DEFAULT NULL,
  `modile` varchar(255) DEFAULT NULL,
  `naissance` date DEFAULT NULL,
  `nbreenfants` smallint(6) DEFAULT NULL,
  `nbrejours` double DEFAULT NULL,
  `noel` double DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `numsec` varchar(255) DEFAULT NULL,
  `passeport` varchar(255) DEFAULT NULL,
  `RETCOM` double DEFAULT NULL,
  `salbase` double DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `syndique` tinyint(1) DEFAULT NULL,
  `TAUXSYN` double DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `vehicule` tinyint(1) DEFAULT NULL,
  `CAT_ID` bigint(20) DEFAULT NULL,
  `COM_ID` bigint(20) DEFAULT NULL,
  `DEP_ID` bigint(20) DEFAULT NULL,
  `DEPSOC_ID` bigint(20) DEFAULT NULL,
  `ECH_ID` bigint(20) DEFAULT NULL,
  `FON_ID` bigint(20) DEFAULT NULL,
  `PAYS_ID` bigint(20) DEFAULT NULL,
  `POS_ID` bigint(20) DEFAULT NULL,
  `PRPA_ID` bigint(20) DEFAULT NULL,
  `REG_ID` bigint(20) DEFAULT NULL,
  `SPEC_ID` bigint(20) DEFAULT NULL,
  `STRU_ID` bigint(20) DEFAULT NULL,
  `BQ_ID` bigint(20) DEFAULT NULL,
  `AUCO` smallint(6) DEFAULT NULL,
  `COEX` smallint(6) DEFAULT NULL,
  `COMA` smallint(6) DEFAULT NULL,
  `COPE` smallint(6) DEFAULT NULL,
  `CORE` smallint(6) DEFAULT NULL,
  `COAC` smallint(6) DEFAULT NULL,
  `POCO` smallint(6) DEFAULT NULL,
  `aliMode` tinyint(1) DEFAULT NULL,
  `eauMode` tinyint(1) DEFAULT NULL,
  `elecMode` tinyint(1) DEFAULT NULL,
  `logeMode` tinyint(1) DEFAULT NULL,
  `menMode` tinyint(1) DEFAULT NULL,
  `menNbre` smallint(6) DEFAULT NULL,
  `vehMode` tinyint(1) DEFAULT NULL,
  `vehNbre` smallint(6) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `embauche` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3173AFD9472602FA` (`FON_ID`),
  KEY `FK3173AFD92AF4BF0D` (`ECH_ID`),
  KEY `FK3173AFD9F1A0186D` (`DEPSOC_ID`),
  KEY `FK3173AFD91B466957` (`COM_ID`),
  KEY `FK3173AFD9F3600F4B` (`DEP_ID`),
  KEY `FK3173AFD9D7C673B8` (`POS_ID`),
  KEY `FK3173AFD949B3B5E8` (`CAT_ID`),
  KEY `FK3173AFD967808B72` (`PRPA_ID`),
  KEY `FK3173AFD9A08CDF0F` (`SPEC_ID`),
  KEY `FK3173AFD988B56A1B` (`STRU_ID`),
  KEY `FK3173AFD9F4A13AC9` (`PAYS_ID`),
  KEY `FK3173AFD91861A8C9` (`REG_ID`),
  KEY `FK3173AFD91C22B91A` (`FON_ID`),
  KEY `FK3173AFD9C678C4ED` (`ECH_ID`),
  KEY `FK3173AFD96483B68D` (`DEPSOC_ID`),
  KEY `FK3173AFD9A3EE1777` (`COM_ID`),
  KEY `FK3173AFD9A4802D2B` (`DEP_ID`),
  KEY `FK3173AFD9E6527198` (`POS_ID`),
  KEY `FK3173AFD9144DC3C8` (`CAT_ID`),
  KEY `FK3173AFD9534F77FB` (`STRU_ID`),
  KEY `FK3173AFD9B794F8E9` (`PAYS_ID`),
  KEY `FK3173AFD9ED5E5EE9` (`REG_ID`),
  KEY `FK3173AFD96F279A5B` (`BQ_ID`),
  CONSTRAINT `FK3173AFD9144DC3C8` FOREIGN KEY (`CAT_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK3173AFD91861A8C9` FOREIGN KEY (`REG_ID`) REFERENCES `t_region` (`id`),
  CONSTRAINT `FK3173AFD91B466957` FOREIGN KEY (`COM_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK3173AFD91C22B91A` FOREIGN KEY (`FON_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK3173AFD92AF4BF0D` FOREIGN KEY (`ECH_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK3173AFD9472602FA` FOREIGN KEY (`FON_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK3173AFD949B3B5E8` FOREIGN KEY (`CAT_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK3173AFD9534F77FB` FOREIGN KEY (`STRU_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK3173AFD96483B68D` FOREIGN KEY (`DEPSOC_ID`) REFERENCES `t_dep` (`id`),
  CONSTRAINT `FK3173AFD967808B72` FOREIGN KEY (`PRPA_ID`) REFERENCES `t_prpa` (`id`),
  CONSTRAINT `FK3173AFD96F279A5B` FOREIGN KEY (`BQ_ID`) REFERENCES `t_banque` (`id`),
  CONSTRAINT `FK3173AFD988B56A1B` FOREIGN KEY (`STRU_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK3173AFD9A08CDF0F` FOREIGN KEY (`SPEC_ID`) REFERENCES `t_speci` (`id`),
  CONSTRAINT `FK3173AFD9A3EE1777` FOREIGN KEY (`COM_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK3173AFD9A4802D2B` FOREIGN KEY (`DEP_ID`) REFERENCES `t_depsoc` (`id`),
  CONSTRAINT `FK3173AFD9B794F8E9` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK3173AFD9C678C4ED` FOREIGN KEY (`ECH_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK3173AFD9D7C673B8` FOREIGN KEY (`POS_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK3173AFD9E6527198` FOREIGN KEY (`POS_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK3173AFD9ED5E5EE9` FOREIGN KEY (`REG_ID`) REFERENCES `t_region` (`id`),
  CONSTRAINT `FK3173AFD9F1A0186D` FOREIGN KEY (`DEPSOC_ID`) REFERENCES `t_dep` (`id`),
  CONSTRAINT `FK3173AFD9F3600F4B` FOREIGN KEY (`DEP_ID`) REFERENCES `t_depsoc` (`id`),
  CONSTRAINT `FK3173AFD9F4A13AC9` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_emplrh`
--

DROP TABLE IF EXISTS `t_emplrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_emplrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` longtext,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_emrup`
--

DROP TABLE IF EXISTS `t_emrup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_emrup` (
  `EMPL_ID` bigint(20) NOT NULL,
  `RUBR_ID` bigint(20) NOT NULL,
  KEY `FK198691A44289C74` (`RUBR_ID`),
  KEY `FK198691A29AE54FA` (`EMPL_ID`),
  CONSTRAINT `FK198691A29AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK198691A44289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_entr`
--

DROP TABLE IF EXISTS `t_entr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_entr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `adresse1` varchar(255) DEFAULT NULL,
  `adresse2` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `cp` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `principal` tinyint(1) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `PAYS_ID` bigint(20) DEFAULT NULL,
  `REGI_ID` bigint(20) DEFAULT NULL,
  `TIER_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B259F293AB7E44` (`TIER_ID`),
  KEY `FK94B259F287FCB7` (`REGI_ID`),
  KEY `FK94B259F236471BD8` (`PAYS_ID`),
  KEY `FK94B259F2B066154F` (`TIER_ID`),
  KEY `FK94B259F2FB29C7CE` (`REGI_ID`),
  KEY `FK94B259F2D03EC0AF` (`PAYS_ID`),
  KEY `FK94B259F21911F372` (`TIER_ID`),
  KEY `FK94B259F2E856A931` (`REGI_ID`),
  KEY `FK94B259F238EA9ED2` (`PAYS_ID`),
  CONSTRAINT `FK94B259F21911F372` FOREIGN KEY (`TIER_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B259F236471BD8` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK94B259F238EA9ED2` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK94B259F287FCB7` FOREIGN KEY (`REGI_ID`) REFERENCES `t_region` (`id`),
  CONSTRAINT `FK94B259F293AB7E44` FOREIGN KEY (`TIER_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B259F2B066154F` FOREIGN KEY (`TIER_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B259F2D03EC0AF` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK94B259F2E856A931` FOREIGN KEY (`REGI_ID`) REFERENCES `t_region` (`id`),
  CONSTRAINT `FK94B259F2FB29C7CE` FOREIGN KEY (`REGI_ID`) REFERENCES `t_region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_escale`
--

DROP TABLE IF EXISTS `t_escale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_escale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `CIB_ID` bigint(20) DEFAULT NULL,
  `SOU_ID` bigint(20) DEFAULT NULL,
  `ESCA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK31C22A50B33677A4` (`SOU_ID`),
  KEY `FK31C22A50978BBDA1` (`CIB_ID`),
  KEY `FK31C22A50BCA7136E` (`ESCA_ID`),
  CONSTRAINT `FK31C22A50978BBDA1` FOREIGN KEY (`CIB_ID`) REFERENCES `t_vill` (`id`),
  CONSTRAINT `FK31C22A50B33677A4` FOREIGN KEY (`SOU_ID`) REFERENCES `t_vill` (`id`),
  CONSTRAINT `FK31C22A50BCA7136E` FOREIGN KEY (`ESCA_ID`) REFERENCES `t_ordmissrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_etablrh`
--

DROP TABLE IF EXISTS `t_etablrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_etablrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_etaprh`
--

DROP TABLE IF EXISTS `t_etaprh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_etaprh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `dernier` tinyint(1) DEFAULT NULL,
  `note` longtext,
  `sequ` smallint(6) DEFAULT NULL,
  `DEP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK31CF921FA4802D2B` (`DEP_ID`),
  CONSTRAINT `FK31CF921FA4802D2B` FOREIGN KEY (`DEP_ID`) REFERENCES `t_depsoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_evastarh`
--

DROP TABLE IF EXISTS `t_evastarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_evastarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `note` double DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `SUISTA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK662B1C1196CC09DF` (`SUISTA_ID`),
  KEY `FK662B1C11C5325ADA` (`EMPL_ID`),
  CONSTRAINT `FK662B1C1196CC09DF` FOREIGN KEY (`SUISTA_ID`) REFERENCES `t_stagerh` (`id`),
  CONSTRAINT `FK662B1C11C5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_event`
--

DROP TABLE IF EXISTS `t_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `allDay` tinyint(1) NOT NULL,
  `confidentialite` smallint(6) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `disponibilite` smallint(6) NOT NULL,
  `duree` varchar(255) DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `notify` tinyint(1) NOT NULL,
  `recurrent` tinyint(1) NOT NULL,
  `start` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `OWN_ID` bigint(20) DEFAULT NULL,
  `RAP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK19C4ECFEF3A1AAE` (`OWN_ID`),
  KEY `FK19C4ECF7E847E1D` (`RAP_ID`),
  CONSTRAINT `FK19C4ECF7E847E1D` FOREIGN KEY (`RAP_ID`) REFERENCES `t_rappel` (`id`),
  CONSTRAINT `FK19C4ECFEF3A1AAE` FOREIGN KEY (`OWN_ID`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_exbe`
--

DROP TABLE IF EXISTS `t_exbe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_exbe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `dateExpr` date DEFAULT NULL,
  `motivation` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `UTIL_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B27D4160F32152` (`UTIL_ID`),
  CONSTRAINT `FK94B27D4160F32152` FOREIGN KEY (`UTIL_ID`) REFERENCES `t_tier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_exercmble`
--

DROP TABLE IF EXISTS `t_exercmble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_exercmble` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `code` varchar(255) NOT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `ouvert` tinyint(1) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FKFFF47DC6C3617E18` (`SOC_ID`),
  CONSTRAINT `FKFFF47DC6C3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_expcanrh`
--

DROP TABLE IF EXISTS `t_expcanrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_expcanrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `description` longtext,
  `duree` smallint(6) DEFAULT NULL,
  `entrep` varchar(255) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `CANSPO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE8A65994C46D5493` (`CANSPO_ID`),
  CONSTRAINT `FKE8A65994C46D5493` FOREIGN KEY (`CANSPO_ID`) REFERENCES `t_cansporh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_faar`
--

DROP TABLE IF EXISTS `t_faar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_faar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codefiscal` varchar(255) DEFAULT NULL,
  `coutstockage` double DEFAULT NULL,
  `couttransport` double DEFAULT NULL,
  `delailivraison` smallint(6) DEFAULT NULL,
  `garantie` smallint(6) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `suivistock` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `CAPR_ID` bigint(20) DEFAULT NULL,
  `FAAR_ID` bigint(20) DEFAULT NULL,
  `PAYS_ID` bigint(20) DEFAULT NULL,
  `UNGE_ID` bigint(20) DEFAULT NULL,
  `UNAC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B29B37217B3CF3` (`CAPR_ID`),
  KEY `FK94B29B3717EC1F92` (`UNGE_ID`),
  KEY `FK94B29B37502AF09D` (`FAAR_ID`),
  KEY `FK94B29B3736471BD8` (`PAYS_ID`),
  KEY `FK94B29B37A34DDE9E` (`UNAC_ID`),
  KEY `FK94B29B37668882A1` (`CAPR_ID`),
  KEY `FK94B29B373BEB6C40` (`UNGE_ID`),
  KEY `FK94B29B377189C9CB` (`FAAR_ID`),
  KEY `FK94B29B37D03EC0AF` (`PAYS_ID`),
  KEY `FK94B29B37F6747ECC` (`UNAC_ID`),
  KEY `FK94B29B3762414444` (`CAPR_ID`),
  KEY `FK94B29B3767347763` (`UNGE_ID`),
  KEY `FK94B29B37EEBC982E` (`FAAR_ID`),
  KEY `FK94B29B3738EA9ED2` (`PAYS_ID`),
  KEY `FK94B29B37D5BBF6AF` (`UNAC_ID`),
  CONSTRAINT `FK94B29B3717EC1F92` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK94B29B37217B3CF3` FOREIGN KEY (`CAPR_ID`) REFERENCES `t_capr` (`id`),
  CONSTRAINT `FK94B29B3736471BD8` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK94B29B3738EA9ED2` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK94B29B373BEB6C40` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK94B29B37502AF09D` FOREIGN KEY (`FAAR_ID`) REFERENCES `t_faar` (`id`),
  CONSTRAINT `FK94B29B3762414444` FOREIGN KEY (`CAPR_ID`) REFERENCES `t_capr` (`id`),
  CONSTRAINT `FK94B29B37668882A1` FOREIGN KEY (`CAPR_ID`) REFERENCES `t_capr` (`id`),
  CONSTRAINT `FK94B29B3767347763` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK94B29B377189C9CB` FOREIGN KEY (`FAAR_ID`) REFERENCES `t_faar` (`id`),
  CONSTRAINT `FK94B29B37A34DDE9E` FOREIGN KEY (`UNAC_ID`) REFERENCES `t_unac` (`id`),
  CONSTRAINT `FK94B29B37D03EC0AF` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK94B29B37D5BBF6AF` FOREIGN KEY (`UNAC_ID`) REFERENCES `t_unac` (`id`),
  CONSTRAINT `FK94B29B37EEBC982E` FOREIGN KEY (`FAAR_ID`) REFERENCES `t_faar` (`id`),
  CONSTRAINT `FK94B29B37F6747ECC` FOREIGN KEY (`UNAC_ID`) REFERENCES `t_unac` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_fam`
--

DROP TABLE IF EXISTS `t_fam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `eligible` tinyint(1) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `naissance` date DEFAULT NULL,
  `qualite` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4CBF4873D09BA56` (`EMP_ID`),
  KEY `FK4CBF487D88DC036` (`EMP_ID`),
  CONSTRAINT `FK4CBF4873D09BA56` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK4CBF487D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_fiin`
--

DROP TABLE IF EXISTS `t_fiin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fiin` (
  `NIV` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `dateinventaire` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `ENTR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B2BA3321C0D8FF` (`ENTR_ID`),
  KEY `FK94B2BA338A1C415E` (`EMPL_ID`),
  CONSTRAINT `FK94B2BA3321C0D8FF` FOREIGN KEY (`ENTR_ID`) REFERENCES `t_entr` (`id`),
  CONSTRAINT `FK94B2BA338A1C415E` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_empl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_fiporh`
--

DROP TABLE IF EXISTS `t_fiporh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fiporh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `porte` varchar(255) DEFAULT NULL,
  `DEP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32F03603A4802D2B` (`DEP_ID`),
  CONSTRAINT `FK32F03603A4802D2B` FOREIGN KEY (`DEP_ID`) REFERENCES `t_depsoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_foca`
--

DROP TABLE IF EXISTS `t_foca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_foca` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `mesure` varchar(255) DEFAULT NULL,
  `valeur` double DEFAULT NULL,
  `FONC_ID` bigint(20) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B2CFF244289C74` (`RUBR_ID`),
  KEY `FK94B2CFF27298F080` (`FONC_ID`),
  CONSTRAINT `FK94B2CFF244289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK94B2CFF27298F080` FOREIGN KEY (`FONC_ID`) REFERENCES `t_cat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_focapr`
--

DROP TABLE IF EXISTS `t_focapr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_focapr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `mesure` varchar(255) DEFAULT NULL,
  `valeur` double DEFAULT NULL,
  `FONC_ID` bigint(20) DEFAULT NULL,
  `SERV_ID` bigint(20) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK333EA57444289C74` (`RUBR_ID`),
  KEY `FK333EA5746A2A24E1` (`FONC_ID`),
  KEY `FK333EA574B93B71E4` (`SERV_ID`),
  CONSTRAINT `FK333EA57444289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK333EA5746A2A24E1` FOREIGN KEY (`FONC_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK333EA574B93B71E4` FOREIGN KEY (`SERV_ID`) REFERENCES `t_depsoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_fol_aban`
--

DROP TABLE IF EXISTS `t_fol_aban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fol_aban` (
  `FOL_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  KEY `FK6F2671B5757FD05A` (`FOL_ID`),
  KEY `FK6F2671B5224ABC49` (`USER_ID`),
  CONSTRAINT `FK6F2671B5224ABC49` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK6F2671B5757FD05A` FOREIGN KEY (`FOL_ID`) REFERENCES `t_follow` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_fol_can`
--

DROP TABLE IF EXISTS `t_fol_can`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fol_can` (
  `FOL_ID` bigint(20) NOT NULL,
  `CAN_ID` bigint(20) NOT NULL,
  KEY `FK35224D29757FD05A` (`FOL_ID`),
  KEY `FK35224D29BBDA8BE0` (`CAN_ID`),
  CONSTRAINT `FK35224D29757FD05A` FOREIGN KEY (`FOL_ID`) REFERENCES `t_follow` (`id`),
  CONSTRAINT `FK35224D29BBDA8BE0` FOREIGN KEY (`CAN_ID`) REFERENCES `t_canal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_follow`
--

DROP TABLE IF EXISTS `t_follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `entityid` bigint(20) NOT NULL,
  `entityserial` varchar(255) DEFAULT NULL,
  `noteinterne` tinyint(1) DEFAULT NULL,
  `SENDER_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3514DE1C2CFAFD9F` (`SENDER_ID`),
  CONSTRAINT `FK3514DE1C2CFAFD9F` FOREIGN KEY (`SENDER_ID`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_fonc`
--

DROP TABLE IF EXISTS `t_fonc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fonc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_forcanrh`
--

DROP TABLE IF EXISTS `t_forcanrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_forcanrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ECOL_ID` bigint(20) DEFAULT NULL,
  `NIV_ID` bigint(20) DEFAULT NULL,
  `SPEC_ID` bigint(20) DEFAULT NULL,
  `CANSPO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK77D922687742B066` (`ECOL_ID`),
  KEY `FK77D92268EDAB2BB9` (`NIV_ID`),
  KEY `FK77D922689E01852F` (`SPEC_ID`),
  KEY `FK77D92268C46D5493` (`CANSPO_ID`),
  CONSTRAINT `FK77D922687742B066` FOREIGN KEY (`ECOL_ID`) REFERENCES `t_etablrh` (`id`),
  CONSTRAINT `FK77D922689E01852F` FOREIGN KEY (`SPEC_ID`) REFERENCES `t_speci` (`id`),
  CONSTRAINT `FK77D92268C46D5493` FOREIGN KEY (`CANSPO_ID`) REFERENCES `t_cansporh` (`id`),
  CONSTRAINT `FK77D92268EDAB2BB9` FOREIGN KEY (`NIV_ID`) REFERENCES `t_nivetu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_formarh`
--

DROP TABLE IF EXISTS `t_formarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_formarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `note` longtext,
  `state` varchar(255) DEFAULT NULL,
  `MOFO_ID` bigint(20) DEFAULT NULL,
  `LIPLFO_ID` bigint(20) DEFAULT NULL,
  `THEM_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK356EA608B8545A93` (`THEM_ID`),
  KEY `FK356EA60847EAE858` (`LIPLFO_ID`),
  KEY `FK356EA6082CFC41A7` (`MOFO_ID`),
  CONSTRAINT `FK356EA6082CFC41A7` FOREIGN KEY (`MOFO_ID`) REFERENCES `t_moforrh` (`id`),
  CONSTRAINT `FK356EA60847EAE858` FOREIGN KEY (`LIPLFO_ID`) REFERENCES `t_liplforh` (`id`),
  CONSTRAINT `FK356EA608B8545A93` FOREIGN KEY (`THEM_ID`) REFERENCES `t_theforrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_formrh`
--

DROP TABLE IF EXISTS `t_formrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_formrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `qualif` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_fosp`
--

DROP TABLE IF EXISTS `t_fosp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fosp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `mesure` varchar(255) DEFAULT NULL,
  `valeur` double DEFAULT NULL,
  `FONC_ID` bigint(20) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B2D1F144289C74` (`RUBR_ID`),
  KEY `FK94B2D1F1EFA5D7AC` (`FONC_ID`),
  CONSTRAINT `FK94B2D1F144289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK94B2D1F1EFA5D7AC` FOREIGN KEY (`FONC_ID`) REFERENCES `t_speci` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_framisrh`
--

DROP TABLE IF EXISTS `t_framisrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_framisrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `groupe` varchar(255) DEFAULT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `CATMIS_ID` bigint(20) DEFAULT NULL,
  `FRMI_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFA1A1263F0690412` (`FRMI_ID`),
  KEY `FKFA1A1263E551E009` (`CATMIS_ID`),
  CONSTRAINT `FKFA1A1263E551E009` FOREIGN KEY (`CATMIS_ID`) REFERENCES `t_catfrarh` (`id`),
  CONSTRAINT `FKFA1A1263F0690412` FOREIGN KEY (`FRMI_ID`) REFERENCES `t_ordmissrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_goupd`
--

DROP TABLE IF EXISTS `t_goupd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_goupd` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `habilitation` varchar(255) DEFAULT NULL,
  `ACT_ID` bigint(20) DEFAULT NULL,
  `GROUP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1B58B76B20C9F8A` (`GROUP_ID`),
  KEY `FK1B58B76C35C6179` (`ACT_ID`),
  CONSTRAINT `FK1B58B76B20C9F8A` FOREIGN KEY (`GROUP_ID`) REFERENCES `t_groupe` (`id`),
  CONSTRAINT `FK1B58B76C35C6179` FOREIGN KEY (`ACT_ID`) REFERENCES `m_action` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_gradep`
--

DROP TABLE IF EXISTS `t_gradep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_gradep` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_grilfrarh`
--

DROP TABLE IF EXISTS `t_grilfrarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_grilfrarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `externe` double DEFAULT NULL,
  `interne` double DEFAULT NULL,
  `FONC_ID` bigint(20) DEFAULT NULL,
  `CAFRA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK82BEB132660B9F13` (`CAFRA_ID`),
  KEY `FK82BEB1323F26DB01` (`FONC_ID`),
  CONSTRAINT `FK82BEB1323F26DB01` FOREIGN KEY (`FONC_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK82BEB132660B9F13` FOREIGN KEY (`CAFRA_ID`) REFERENCES `t_catfrarh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_groupe`
--

DROP TABLE IF EXISTS `t_groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_groupe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `M_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK352384112D7C2FF4` (`M_ID`),
  CONSTRAINT `FK352384112D7C2FF4` FOREIGN KEY (`M_ID`) REFERENCES `m_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_indperfrh`
--

DROP TABLE IF EXISTS `t_indperfrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_indperfrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_inrconrh`
--

DROP TABLE IF EXISTS `t_inrconrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_inrconrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `dateDebutConge` date DEFAULT NULL,
  `dateFinconge` date DEFAULT NULL,
  `dureeconge` smallint(6) DEFAULT NULL,
  `joursr` smallint(6) DEFAULT NULL,
  `motif` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `DC_ID` bigint(20) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7A9CCAF6D88DC036` (`EMP_ID`),
  KEY `FK7A9CCAF6303FE19D` (`DC_ID`),
  CONSTRAINT `FK7A9CCAF6303FE19D` FOREIGN KEY (`DC_ID`) REFERENCES `t_decorh` (`id`),
  CONSTRAINT `FK7A9CCAF6D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_insolp`
--

DROP TABLE IF EXISTS `t_insolp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_insolp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK385691D044289C74` (`RUBR_ID`),
  CONSTRAINT `FK385691D044289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_jcomptable`
--

DROP TABLE IF EXISTS `t_jcomptable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jcomptable` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `analytique` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB74AF9C049EACEA9` (`SOC_ID`),
  KEY `FKB74AF9C0A3826672` (`SOC_ID`),
  KEY `FKB74AF9C05BF1B16F` (`SOC_ID`),
  KEY `FKB74AF9C0C3617E18` (`SOC_ID`),
  CONSTRAINT `FKB74AF9C049EACEA9` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKB74AF9C05BF1B16F` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKB74AF9C0A3826672` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKB74AF9C0C3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_jrnsaisie`
--

DROP TABLE IF EXISTS `t_jrnsaisie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_jrnsaisie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `credit` decimal(19,2) DEFAULT NULL,
  `debit` decimal(19,2) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `EXER_ID` bigint(20) DEFAULT NULL,
  `JRND_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK53B2C86F6FFBE3C1` (`EXER_ID`),
  KEY `FK53B2C86FF3253F14` (`JRND_ID`),
  CONSTRAINT `FK53B2C86F6FFBE3C1` FOREIGN KEY (`EXER_ID`) REFERENCES `t_exercmble` (`id`),
  CONSTRAINT `FK53B2C86FF3253F14` FOREIGN KEY (`JRND_ID`) REFERENCES `t_jcomptable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_kmsge`
--

DROP TABLE IF EXISTS `t_kmsge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_kmsge` (
  `TYPE_MSGE` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `entityid` bigint(20) NOT NULL,
  `entityserial` varchar(255) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `typeMessage` int(11) DEFAULT NULL,
  `CAN_ID` bigint(20) DEFAULT NULL,
  `RECI_ID` bigint(20) DEFAULT NULL,
  `SEND_ID` bigint(20) DEFAULT NULL,
  `SMES_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1ECF824BBDA8BE0` (`CAN_ID`),
  KEY `FK1ECF824A112E36C` (`SEND_ID`),
  KEY `FK1ECF8246B93EB7B` (`RECI_ID`),
  KEY `FK1ECF82444549E75` (`SMES_ID`),
  CONSTRAINT `FK1ECF82444549E75` FOREIGN KEY (`SMES_ID`) REFERENCES `t_follow` (`id`),
  CONSTRAINT `FK1ECF8246B93EB7B` FOREIGN KEY (`RECI_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK1ECF824A112E36C` FOREIGN KEY (`SEND_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK1ECF824BBDA8BE0` FOREIGN KEY (`CAN_ID`) REFERENCES `t_canal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_langrh`
--

DROP TABLE IF EXISTS `t_langrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_langrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `langue` varchar(255) DEFAULT NULL,
  `niveau` varchar(255) DEFAULT NULL,
  `CANSPO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3CBB86EFC46D5493` (`CANSPO_ID`),
  CONSTRAINT `FK3CBB86EFC46D5493` FOREIGN KEY (`CANSPO_ID`) REFERENCES `t_cansporh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_langue`
--

DROP TABLE IF EXISTS `t_langue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_langue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codeISO` varchar(255) DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `formatDate` varchar(255) DEFAULT NULL,
  `formatDecimal` varchar(255) DEFAULT NULL,
  `formatHeure` varchar(255) DEFAULT NULL,
  `formatMillier` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liapof`
--

DROP TABLE IF EXISTS `t_liapof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liapof` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `prevu` date DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `ART_ID` bigint(20) DEFAULT NULL,
  `APOF_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D267B8EA6D8A2AB` (`APOF_ID`),
  KEY `FK3D267B8E8B4A5D75` (`ART_ID`),
  CONSTRAINT `FK3D267B8E8B4A5D75` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK3D267B8EA6D8A2AB` FOREIGN KEY (`APOF_ID`) REFERENCES `t_apof` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liavrh`
--

DROP TABLE IF EXISTS `t_liavrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liavrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `quantite` smallint(6) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `LIAV_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D26927358588687` (`LIAV_ID`),
  CONSTRAINT `FK3D26927358588687` FOREIGN KEY (`LIAV_ID`) REFERENCES `t_elsalp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_libeforh`
--

DROP TABLE IF EXISTS `t_libeforh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_libeforh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `places` smallint(6) DEFAULT NULL,
  `POS_ID` bigint(20) DEFAULT NULL,
  `BF_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8E8BBACAE6527198` (`POS_ID`),
  KEY `FK8E8BBACA2CD3E722` (`BF_ID`),
  CONSTRAINT `FK8E8BBACA2CD3E722` FOREIGN KEY (`BF_ID`) REFERENCES `t_besformrh` (`id`),
  CONSTRAINT `FK8E8BBACAE6527198` FOREIGN KEY (`POS_ID`) REFERENCES `t_pos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_libupa`
--

DROP TABLE IF EXISTS `t_libupa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_libupa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `tauxpat` double DEFAULT NULL,
  `tauxsal` double DEFAULT NULL,
  `valeur` double DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `LIBUPA_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D2702CC44289C74` (`RUBR_ID`),
  KEY `FK3D2702CCF2BC310F` (`LIBUPA_ID`),
  CONSTRAINT `FK3D2702CC44289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK3D2702CCF2BC310F` FOREIGN KEY (`LIBUPA_ID`) REFERENCES `t_bupa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=434 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_licoon`
--

DROP TABLE IF EXISTS `t_licoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_licoon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `salbase` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `CATE_ID` bigint(20) DEFAULT NULL,
  `ECHE_ID` bigint(20) DEFAULT NULL,
  `LICOON_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D2760936A586DC` (`ECHE_ID`),
  KEY `FK3D276093BC57DBCF` (`CATE_ID`),
  KEY `FK3D27609396365C66` (`LICOON_ID`),
  CONSTRAINT `FK3D2760936A586DC` FOREIGN KEY (`ECHE_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK3D27609396365C66` FOREIGN KEY (`LICOON_ID`) REFERENCES `t_conv` (`id`),
  CONSTRAINT `FK3D276093BC57DBCF` FOREIGN KEY (`CATE_ID`) REFERENCES `t_cat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lidoac`
--

DROP TABLE IF EXISTS `t_lidoac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lidoac` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `fabrication` date DEFAULT NULL,
  `peremption` date DEFAULT NULL,
  `prevue` date DEFAULT NULL,
  `puht` double DEFAULT NULL,
  `qtefacturee` double DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `remise` double DEFAULT NULL,
  `stokdispo` double DEFAULT NULL,
  `totalht` double DEFAULT NULL,
  `ART_ID` bigint(20) DEFAULT NULL,
  `LIDOAC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D27D335E1C7EB27` (`LIDOAC_ID`),
  KEY `FK3D27D335CB8813E6` (`ART_ID`),
  KEY `FK3D27D3352BD21B91` (`LIDOAC_ID`),
  KEY `FK3D27D3358B4A5D75` (`ART_ID`),
  CONSTRAINT `FK3D27D3352BD21B91` FOREIGN KEY (`LIDOAC_ID`) REFERENCES `t_doac` (`id`),
  CONSTRAINT `FK3D27D3358B4A5D75` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK3D27D335CB8813E6` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK3D27D335E1C7EB27` FOREIGN KEY (`LIDOAC_ID`) REFERENCES `t_doac` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lidoac_ta`
--

DROP TABLE IF EXISTS `t_lidoac_ta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lidoac_ta` (
  `LIDOAC_ID` bigint(20) NOT NULL,
  `TAXE_ID` bigint(20) NOT NULL,
  KEY `FKBD7CD3B72B07ADEA` (`TAXE_ID`),
  KEY `FKBD7CD3B7D40D314` (`LIDOAC_ID`),
  KEY `FKBD7CD3B73C83C612` (`TAXE_ID`),
  KEY `FKBD7CD3B716F654EA` (`LIDOAC_ID`),
  CONSTRAINT `FKBD7CD3B716F654EA` FOREIGN KEY (`LIDOAC_ID`) REFERENCES `t_lidoac` (`id`),
  CONSTRAINT `FKBD7CD3B72B07ADEA` FOREIGN KEY (`TAXE_ID`) REFERENCES `t_taxe` (`id`),
  CONSTRAINT `FKBD7CD3B73C83C612` FOREIGN KEY (`TAXE_ID`) REFERENCES `t_taxe` (`id`),
  CONSTRAINT `FKBD7CD3B7D40D314` FOREIGN KEY (`LIDOAC_ID`) REFERENCES `t_lidoac` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lids`
--

DROP TABLE IF EXISTS `t_lids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lids` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `fabrication` date DEFAULT NULL,
  `peremption` date DEFAULT NULL,
  `puht` double DEFAULT NULL,
  `punet` double DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `totalht` double DEFAULT NULL,
  `ART_ID` bigint(20) DEFAULT NULL,
  `lot_id` bigint(20) DEFAULT NULL,
  `UNG_ID` bigint(20) DEFAULT NULL,
  `DOST_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B573D71B07D129` (`UNG_ID`),
  KEY `FK94B573D7B4C56440` (`lot_id`),
  KEY `FK94B573D7E455056F` (`DOST_ID`),
  KEY `FK94B573D7D2DB1278` (`ART_ID`),
  KEY `FK94B573D74650DC4C` (`UNG_ID`),
  KEY `FK94B573D7E8DE3FD` (`lot_id`),
  KEY `FK94B573D75A2BCEC` (`DOST_ID`),
  KEY `FK94B573D78B4A5D75` (`ART_ID`),
  CONSTRAINT `FK94B573D71B07D129` FOREIGN KEY (`UNG_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK94B573D74650DC4C` FOREIGN KEY (`UNG_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK94B573D75A2BCEC` FOREIGN KEY (`DOST_ID`) REFERENCES `t_docba` (`id`),
  CONSTRAINT `FK94B573D78B4A5D75` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK94B573D7B4C56440` FOREIGN KEY (`lot_id`) REFERENCES `t_lot` (`id`),
  CONSTRAINT `FK94B573D7D2DB1278` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK94B573D7E455056F` FOREIGN KEY (`DOST_ID`) REFERENCES `t_docba` (`id`),
  CONSTRAINT `FK94B573D7E8DE3FD` FOREIGN KEY (`lot_id`) REFERENCES `t_lot` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lielvap`
--

DROP TABLE IF EXISTS `t_lielvap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lielvap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `valeur` double DEFAULT NULL,
  `VAR_ID` bigint(20) DEFAULT NULL,
  `BUPA_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK67DF9CB64F9BE711` (`VAR_ID`),
  KEY `FK67DF9CB6CA81F52C` (`BUPA_ID`),
  CONSTRAINT `FK67DF9CB64F9BE711` FOREIGN KEY (`VAR_ID`) REFERENCES `t_vari` (`id`),
  CONSTRAINT `FK67DF9CB6CA81F52C` FOREIGN KEY (`BUPA_ID`) REFERENCES `t_bupa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3563 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liem`
--

DROP TABLE IF EXISTS `t_liem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `prevision` double DEFAULT NULL,
  `stock` double DEFAULT NULL,
  `stockale` double DEFAULT NULL,
  `stockmax` double DEFAULT NULL,
  `stockmin` double DEFAULT NULL,
  `stocksec` double DEFAULT NULL,
  `terme` double DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `LIEM_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B573F08BCA4128` (`EMP_ID`),
  KEY `FK94B573F029957824` (`LIEM_ID`),
  KEY `FK94B573F09D77A6BA` (`EMP_ID`),
  KEY `FK94B573F030E876B6` (`LIEM_ID`),
  KEY `FK94B573F0A71F2B37` (`EMP_ID`),
  KEY `FK94B573F0E957C1B3` (`LIEM_ID`),
  CONSTRAINT `FK94B573F029957824` FOREIGN KEY (`LIEM_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK94B573F030E876B6` FOREIGN KEY (`LIEM_ID`) REFERENCES `t_art` (`id`),
  CONSTRAINT `FK94B573F08BCA4128` FOREIGN KEY (`EMP_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B573F09D77A6BA` FOREIGN KEY (`EMP_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B573F0A71F2B37` FOREIGN KEY (`EMP_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B573F0E957C1B3` FOREIGN KEY (`LIEM_ID`) REFERENCES `t_art` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liexbe`
--

DROP TABLE IF EXISTS `t_liexbe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liexbe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `ART_ID` bigint(20) DEFAULT NULL,
  `EXBE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D28697E63EB5C4E` (`EXBE_ID`),
  KEY `FK3D28697E8B4A5D75` (`ART_ID`),
  CONSTRAINT `FK3D28697E63EB5C4E` FOREIGN KEY (`EXBE_ID`) REFERENCES `t_exbe` (`id`),
  CONSTRAINT `FK3D28697E8B4A5D75` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lifiporh`
--

DROP TABLE IF EXISTS `t_lifiporh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lifiporh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `absencepaye` tinyint(1) DEFAULT NULL,
  `absent` tinyint(1) DEFAULT NULL,
  `datepointage` time DEFAULT NULL,
  `heurearrive` varchar(255) DEFAULT NULL,
  `heuredepart` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `FIPO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK959C0700D88DC036` (`EMP_ID`),
  KEY `FK959C070016BF676F` (`FIPO_ID`),
  CONSTRAINT `FK959C070016BF676F` FOREIGN KEY (`FIPO_ID`) REFERENCES `t_fiporh` (`id`),
  CONSTRAINT `FK959C0700D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liin`
--

DROP TABLE IF EXISTS `t_liin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `peremption` date DEFAULT NULL,
  `puajuste` double DEFAULT NULL,
  `puht` double DEFAULT NULL,
  `stockconstate` double DEFAULT NULL,
  `stockdispo` double DEFAULT NULL,
  `stockecart` double DEFAULT NULL,
  `ARTI_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `LIIN_ID` bigint(20) DEFAULT NULL,
  `REIN_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B5746D70928F` (`LIIN_ID`),
  KEY `FK94B5746DFB311795` (`ARTI_ID`),
  KEY `FK94B5746DD42959C7` (`REIN_ID`),
  KEY `FK94B5746D8A1C415E` (`EMPL_ID`),
  CONSTRAINT `FK94B5746D70928F` FOREIGN KEY (`LIIN_ID`) REFERENCES `t_lot` (`id`),
  CONSTRAINT `FK94B5746D8A1C415E` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK94B5746DD42959C7` FOREIGN KEY (`REIN_ID`) REFERENCES `t_fiin` (`id`),
  CONSTRAINT `FK94B5746DFB311795` FOREIGN KEY (`ARTI_ID`) REFERENCES `t_art` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liinsolp`
--

DROP TABLE IF EXISTS `t_liinsolp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liinsolp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `indice` smallint(6) DEFAULT NULL,
  `salbase` double DEFAULT NULL,
  `CATE_ID` bigint(20) DEFAULT NULL,
  `TYCO_ID` bigint(20) DEFAULT NULL,
  `ECHE_ID` bigint(20) DEFAULT NULL,
  `GRAD_ID` bigint(20) DEFAULT NULL,
  `INSOLP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9B0262CD68D98498` (`INSOLP_ID`),
  KEY `FK9B0262CD6A586DC` (`ECHE_ID`),
  KEY `FK9B0262CD5D02F974` (`GRAD_ID`),
  KEY `FK9B0262CDBC57DBCF` (`CATE_ID`),
  KEY `FK9B0262CD7DD07CCF` (`TYCO_ID`),
  CONSTRAINT `FK9B0262CD5D02F974` FOREIGN KEY (`GRAD_ID`) REFERENCES `t_gradep` (`id`),
  CONSTRAINT `FK9B0262CD68D98498` FOREIGN KEY (`INSOLP_ID`) REFERENCES `t_insolp` (`id`),
  CONSTRAINT `FK9B0262CD6A586DC` FOREIGN KEY (`ECHE_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK9B0262CD7DD07CCF` FOREIGN KEY (`TYCO_ID`) REFERENCES `t_tycon` (`id`),
  CONSTRAINT `FK9B0262CDBC57DBCF` FOREIGN KEY (`CATE_ID`) REFERENCES `t_cat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_linofr`
--

DROP TABLE IF EXISTS `t_linofr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_linofr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `COMP_ID` bigint(20) DEFAULT NULL,
  `NOFR_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D2C5F959B33B87B` (`COMP_ID`),
  KEY `FK3D2C5F95193308B3` (`NOFR_ID`),
  CONSTRAINT `FK3D2C5F95193308B3` FOREIGN KEY (`NOFR_ID`) REFERENCES `t_nofr` (`id`),
  CONSTRAINT `FK3D2C5F959B33B87B` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liplforh`
--

DROP TABLE IF EXISTS `t_liplforh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liplforh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ddebut` date DEFAULT NULL,
  `dfin` date DEFAULT NULL,
  `duree` smallint(6) DEFAULT NULL,
  `num` smallint(6) DEFAULT NULL,
  `places` smallint(6) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `FORMA_ID` bigint(20) DEFAULT NULL,
  `MOFOR_ID` bigint(20) DEFAULT NULL,
  `PAYS_ID` bigint(20) DEFAULT NULL,
  `PLAFOR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA6D23803C7F2119D` (`PLAFOR_ID`),
  KEY `FKA6D23803C2CD662B` (`MOFOR_ID`),
  KEY `FKA6D238033D24333B` (`FORMA_ID`),
  KEY `FKA6D23803B794F8E9` (`PAYS_ID`),
  CONSTRAINT `FKA6D238033D24333B` FOREIGN KEY (`FORMA_ID`) REFERENCES `t_formrh` (`id`),
  CONSTRAINT `FKA6D23803B794F8E9` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FKA6D23803C2CD662B` FOREIGN KEY (`MOFOR_ID`) REFERENCES `t_moforrh` (`id`),
  CONSTRAINT `FKA6D23803C7F2119D` FOREIGN KEY (`PLAFOR_ID`) REFERENCES `t_plaforrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liporh`
--

DROP TABLE IF EXISTS `t_liporh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liporh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `absencepaye` tinyint(1) DEFAULT NULL,
  `absent` tinyint(1) DEFAULT NULL,
  `datepointage` date DEFAULT NULL,
  `heurearrive` varchar(255) DEFAULT NULL,
  `heuredepart` varchar(255) DEFAULT NULL,
  `retard` tinyint(1) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `POJO_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D2D49BD3D09BA56` (`EMP_ID`),
  KEY `FK3D2D49BDD88DC036` (`EMP_ID`),
  KEY `FK3D2D49BD166A5DB3` (`POJO_ID`),
  CONSTRAINT `FK3D2D49BD166A5DB3` FOREIGN KEY (`POJO_ID`) REFERENCES `t_pojorh` (`id`),
  CONSTRAINT `FK3D2D49BD3D09BA56` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK3D2D49BDD88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_liposap`
--

DROP TABLE IF EXISTS `t_liposap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_liposap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `FONC_ID` bigint(20) DEFAULT NULL,
  `LIPOSA_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK687BF11B6A2A24E1` (`FONC_ID`),
  KEY `FK687BF11BAA64D961` (`LIPOSA_ID`),
  CONSTRAINT `FK687BF11B6A2A24E1` FOREIGN KEY (`FONC_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK687BF11BAA64D961` FOREIGN KEY (`LIPOSA_ID`) REFERENCES `t_paavp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lipotcp`
--

DROP TABLE IF EXISTS `t_lipotcp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lipotcp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `FONC_ID` bigint(20) DEFAULT NULL,
  `LIPOTC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK687BF51AAA73D9A0` (`LIPOTC_ID`),
  KEY `FK687BF51A88BE5722` (`FONC_ID`),
  CONSTRAINT `FK687BF51A88BE5722` FOREIGN KEY (`FONC_ID`) REFERENCES `t_tycon` (`id`),
  CONSTRAINT `FK687BF51AAA73D9A0` FOREIGN KEY (`LIPOTC_ID`) REFERENCES `t_paavp` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lirap`
--

DROP TABLE IF EXISTS `t_lirap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lirap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `percu` double DEFAULT NULL,
  `solde` double DEFAULT NULL,
  `RUBR_ID` bigint(20) DEFAULT NULL,
  `RAP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F939B944289C74` (`RUBR_ID`),
  KEY `FK1F939B98A50DD1A` (`RAP_ID`),
  CONSTRAINT `FK1F939B944289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK1F939B98A50DD1A` FOREIGN KEY (`RAP_ID`) REFERENCES `t_rappp` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lirerh`
--

DROP TABLE IF EXISTS `t_lirerh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lirerh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `recommendation` longtext,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `DE_ID` bigint(20) DEFAULT NULL,
  `RC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D2E0CF1F5A05FCA` (`DE_ID`),
  KEY `FK3D2E0CF1D88DC036` (`EMP_ID`),
  KEY `FK3D2E0CF1F0081675` (`RC_ID`),
  CONSTRAINT `FK3D2E0CF1D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK3D2E0CF1F0081675` FOREIGN KEY (`RC_ID`) REFERENCES `t_recorh` (`id`),
  CONSTRAINT `FK3D2E0CF1F5A05FCA` FOREIGN KEY (`DE_ID`) REFERENCES `t_deexrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_litheforrh`
--

DROP TABLE IF EXISTS `t_litheforrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_litheforrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cout` double DEFAULT NULL,
  `heures` smallint(6) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `CATMOD_ID` bigint(20) DEFAULT NULL,
  `THEME_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK4DB30364AE077C6` (`THEME_ID`),
  KEY `FK4DB3036A8D8E364` (`CATMOD_ID`),
  CONSTRAINT `FK4DB30364AE077C6` FOREIGN KEY (`THEME_ID`) REFERENCES `t_theforrh` (`id`),
  CONSTRAINT `FK4DB3036A8D8E364` FOREIGN KEY (`CATMOD_ID`) REFERENCES `t_camodrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_livstarh`
--

DROP TABLE IF EXISTS `t_livstarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_livstarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `propo` longtext,
  `quantite` double DEFAULT NULL,
  `SUISTA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB17818E896CC09DF` (`SUISTA_ID`),
  CONSTRAINT `FKB17818E896CC09DF` FOREIGN KEY (`SUISTA_ID`) REFERENCES `t_stagerh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lot`
--

DROP TABLE IF EXISTS `t_lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `encours` double DEFAULT NULL,
  `fabrication` date DEFAULT NULL,
  `peremption` date DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `sorties` double DEFAULT NULL,
  `LIEM_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reference` (`reference`),
  KEY `FK4CC0CC6F77DB2A5` (`LIEM_ID`),
  KEY `FK4CC0CC61F9FF37` (`LIEM_ID`),
  KEY `FK4CC0CC62B20FD34` (`LIEM_ID`),
  CONSTRAINT `FK4CC0CC61F9FF37` FOREIGN KEY (`LIEM_ID`) REFERENCES `t_liem` (`id`),
  CONSTRAINT `FK4CC0CC62B20FD34` FOREIGN KEY (`LIEM_ID`) REFERENCES `t_liem` (`id`),
  CONSTRAINT `FK4CC0CC6F77DB2A5` FOREIGN KEY (`LIEM_ID`) REFERENCES `t_liem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_mecorh`
--

DROP TABLE IF EXISTS `t_mecorh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_mecorh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `qualite` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `MC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3EA3DB85D88DC036` (`EMP_ID`),
  KEY `FK3EA3DB85E985FBED` (`MC_ID`),
  CONSTRAINT `FK3EA3DB85D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK3EA3DB85E985FBED` FOREIGN KEY (`MC_ID`) REFERENCES `t_cocorh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_medaille`
--

DROP TABLE IF EXISTS `t_medaille`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_medaille` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `recu` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK26069EFC29AE54FA` (`EMPL_ID`),
  CONSTRAINT `FK26069EFC29AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_missirh`
--

DROP TABLE IF EXISTS `t_missirh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_missirh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cout` double DEFAULT NULL,
  `dapprob` date DEFAULT NULL,
  `dcloture` date DEFAULT NULL,
  `dcreation` date DEFAULT NULL,
  `ddebut` date DEFAULT NULL,
  `dfin` date DEFAULT NULL,
  `dvalidation` date DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_moforrh`
--

DROP TABLE IF EXISTS `t_moforrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_moforrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cout` double DEFAULT NULL,
  `heures` smallint(6) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `CATMO_ID` bigint(20) DEFAULT NULL,
  `THEME_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FKA712535240E8A758` (`CATMO_ID`),
  KEY `FKA71253524AE077C6` (`THEME_ID`),
  CONSTRAINT `FKA712535240E8A758` FOREIGN KEY (`CATMO_ID`) REFERENCES `t_camodrh` (`id`),
  CONSTRAINT `FKA71253524AE077C6` FOREIGN KEY (`THEME_ID`) REFERENCES `t_theforrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_more`
--

DROP TABLE IF EXISTS `t_more`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_more` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_nanalyse`
--

DROP TABLE IF EXISTS `t_nanalyse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_nanalyse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_nivetu`
--

DROP TABLE IF EXISTS `t_nivetu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_nivetu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_nofr`
--

DROP TABLE IF EXISTS `t_nofr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_nofr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `decheance` date DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `COMP_ID` bigint(20) DEFAULT NULL,
  `FOUR_ID` bigint(20) DEFAULT NULL,
  `JOUR_ID` bigint(20) DEFAULT NULL,
  `TAX_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B673589B33B87B` (`COMP_ID`),
  KEY `FK94B67358BA32CC80` (`FOUR_ID`),
  KEY `FK94B6735851E56EB9` (`TAX_ID`),
  KEY `FK94B67358EE6FB6F0` (`JOUR_ID`),
  CONSTRAINT `FK94B6735851E56EB9` FOREIGN KEY (`TAX_ID`) REFERENCES `t_taxe` (`id`),
  CONSTRAINT `FK94B673589B33B87B` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B67358BA32CC80` FOREIGN KEY (`FOUR_ID`) REFERENCES `t_tier` (`id`),
  CONSTRAINT `FK94B67358EE6FB6F0` FOREIGN KEY (`JOUR_ID`) REFERENCES `t_jcomptable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_nomirh`
--

DROP TABLE IF EXISTS `t_nomirh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_nomirh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `decision` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `FONCA_ID` bigint(20) DEFAULT NULL,
  `FONCN_ID` bigint(20) DEFAULT NULL,
  `POSTA_ID` bigint(20) DEFAULT NULL,
  `POSTN_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK40EA145E4E0C7DDE` (`POSTN_ID`),
  KEY `FK40EA145E7CA60D3C` (`FONCA_ID`),
  KEY `FK40EA145E7CABF60F` (`FONCN_ID`),
  KEY `FK40EA145EC5325ADA` (`EMPL_ID`),
  KEY `FK40EA145E4E06950B` (`POSTA_ID`),
  CONSTRAINT `FK40EA145E4E06950B` FOREIGN KEY (`POSTA_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK40EA145E4E0C7DDE` FOREIGN KEY (`POSTN_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK40EA145E7CA60D3C` FOREIGN KEY (`FONCA_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK40EA145E7CABF60F` FOREIGN KEY (`FONCN_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK40EA145EC5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_ordmis_empl`
--

DROP TABLE IF EXISTS `t_ordmis_empl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ordmis_empl` (
  `ORMI_ID` bigint(20) NOT NULL,
  `EMPL_ID` bigint(20) NOT NULL,
  KEY `FK99904402CC81195B` (`ORMI_ID`),
  KEY `FK99904402C5325ADA` (`EMPL_ID`),
  CONSTRAINT `FK99904402C5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK99904402CC81195B` FOREIGN KEY (`ORMI_ID`) REFERENCES `t_ordmissrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_ordmissrh`
--

DROP TABLE IF EXISTS `t_ordmissrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ordmissrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ddepart` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dretour` date DEFAULT NULL,
  `motif` varchar(255) DEFAULT NULL,
  `numero` smallint(6) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `CATE_ID` bigint(20) DEFAULT NULL,
  `HIERA_ID` bigint(20) DEFAULT NULL,
  `MISS_ID` bigint(20) DEFAULT NULL,
  `PAYS_ID` bigint(20) DEFAULT NULL,
  `SALA_ID` bigint(20) DEFAULT NULL,
  `VILL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1E42D808951212DB` (`SALA_ID`),
  KEY `FK1E42D8086E160B22` (`MISS_ID`),
  KEY `FK1E42D808BEB5EC6B` (`HIERA_ID`),
  KEY `FK1E42D808532E3108` (`CATE_ID`),
  KEY `FK1E42D808416F38A` (`VILL_ID`),
  KEY `FK1E42D808B794F8E9` (`PAYS_ID`),
  CONSTRAINT `FK1E42D808416F38A` FOREIGN KEY (`VILL_ID`) REFERENCES `t_vill` (`id`),
  CONSTRAINT `FK1E42D808532E3108` FOREIGN KEY (`CATE_ID`) REFERENCES `t_catmisrh` (`id`),
  CONSTRAINT `FK1E42D8086E160B22` FOREIGN KEY (`MISS_ID`) REFERENCES `t_missirh` (`id`),
  CONSTRAINT `FK1E42D808951212DB` FOREIGN KEY (`SALA_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK1E42D808B794F8E9` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FK1E42D808BEB5EC6B` FOREIGN KEY (`HIERA_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_paavp`
--

DROP TABLE IF EXISTS `t_paavp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_paavp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_partsearh`
--

DROP TABLE IF EXISTS `t_partsearh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_partsearh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `present` tinyint(1) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `PART_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBDA2C067D88DC036` (`EMP_ID`),
  KEY `FKBDA2C067BF82360A` (`PART_ID`),
  CONSTRAINT `FKBDA2C067BF82360A` FOREIGN KEY (`PART_ID`) REFERENCES `t_seaformrh` (`id`),
  CONSTRAINT `FKBDA2C067D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_pays`
--

DROP TABLE IF EXISTS `t_pays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pays` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `DEVISE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B729D6AA509E78` (`DEVISE_ID`),
  CONSTRAINT `FK94B729D6AA509E78` FOREIGN KEY (`DEVISE_ID`) REFERENCES `t_devise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_pepa`
--

DROP TABLE IF EXISTS `t_pepa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pepa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ddebut` date DEFAULT NULL,
  `dfin` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `EXE_ID` bigint(20) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B737B167990FC1` (`EXE_ID`),
  KEY `FK94B737B1C3617E18` (`SOC_ID`),
  CONSTRAINT `FK94B737B167990FC1` FOREIGN KEY (`EXE_ID`) REFERENCES `t_exercmble` (`id`),
  CONSTRAINT `FK94B737B1C3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_piececmle`
--

DROP TABLE IF EXISTS `t_piececmle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_piececmle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `credit` decimal(19,2) DEFAULT NULL,
  `datePiece` date DEFAULT NULL,
  `debit` decimal(19,2) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `EXER_ID` bigint(20) DEFAULT NULL,
  `JRN_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK2F32BD066FFBE3C1` (`EXER_ID`),
  KEY `FK2F32BD06FE66DAEC` (`JRN_ID`),
  CONSTRAINT `FK2F32BD066FFBE3C1` FOREIGN KEY (`EXER_ID`) REFERENCES `t_exercmble` (`id`),
  CONSTRAINT `FK2F32BD06FE66DAEC` FOREIGN KEY (`JRN_ID`) REFERENCES `t_jcomptable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_pj`
--

DROP TABLE IF EXISTS `t_pj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pj` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `attachename` varchar(255) DEFAULT NULL,
  `entityid` bigint(20) NOT NULL,
  `entityserial` varchar(255) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `KMSGE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK279DC571A41AAC` (`KMSGE_ID`),
  CONSTRAINT `FK279DC571A41AAC` FOREIGN KEY (`KMSGE_ID`) REFERENCES `t_kmsge` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_plaforrh`
--

DROP TABLE IF EXISTS `t_plaforrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_plaforrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `periode` varchar(255) DEFAULT NULL,
  `places` smallint(6) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `BEFOR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FKCB2081857EA76A80` (`BEFOR_ID`),
  CONSTRAINT `FKCB2081857EA76A80` FOREIGN KEY (`BEFOR_ID`) REFERENCES `t_besformrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_planp`
--

DROP TABLE IF EXISTS `t_planp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_planp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `heures` double DEFAULT NULL,
  `ouvert` tinyint(1) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK232B69CC3617E18` (`SOC_ID`),
  CONSTRAINT `FK232B69CC3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_pojorh`
--

DROP TABLE IF EXISTS `t_pojorh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pojorh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `datepointage` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `FIPO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK44527F0516BF676F` (`FIPO_ID`),
  CONSTRAINT `FK44527F0516BF676F` FOREIGN KEY (`FIPO_ID`) REFERENCES `t_fiporh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_pos`
--

DROP TABLE IF EXISTS `t_pos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `responsable` tinyint(1) DEFAULT NULL,
  `FON_ID` bigint(20) DEFAULT NULL,
  `DEP_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4CC1BC9472602FA` (`FON_ID`),
  KEY `FK4CC1BC91C22B91A` (`FON_ID`),
  KEY `FK4CC1BC9A4802D2B` (`DEP_ID`),
  CONSTRAINT `FK4CC1BC91C22B91A` FOREIGN KEY (`FON_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK4CC1BC9472602FA` FOREIGN KEY (`FON_ID`) REFERENCES `t_fonc` (`id`),
  CONSTRAINT `FK4CC1BC9A4802D2B` FOREIGN KEY (`DEP_ID`) REFERENCES `t_depsoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_prpa`
--

DROP TABLE IF EXISTS `t_prpa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_prpa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `SOCI_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B7687E7F5459FD` (`SOCI_ID`),
  CONSTRAINT `FK94B7687E7F5459FD` FOREIGN KEY (`SOCI_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_prparubr`
--

DROP TABLE IF EXISTS `t_prparubr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_prparubr` (
  `PRPA_ID` bigint(20) NOT NULL,
  `RUBR_ID` bigint(20) NOT NULL,
  KEY `FK21D9875144289C74` (`RUBR_ID`),
  KEY `FK21D9875167808B72` (`PRPA_ID`),
  CONSTRAINT `FK21D9875144289C74` FOREIGN KEY (`RUBR_ID`) REFERENCES `t_rubr` (`id`),
  CONSTRAINT `FK21D9875167808B72` FOREIGN KEY (`PRPA_ID`) REFERENCES `t_prpa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_rappel`
--

DROP TABLE IF EXISTS `t_rappel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rappel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `quantite` smallint(6) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `unite` smallint(6) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_rappp`
--

DROP TABLE IF EXISTS `t_rappp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rappp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `RAPP_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK24A1E16FDD1F2E1` (`RAPP_ID`),
  KEY `FK24A1E1629AE54FA` (`EMPL_ID`),
  CONSTRAINT `FK24A1E1629AE54FA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK24A1E16FDD1F2E1` FOREIGN KEY (`RAPP_ID`) REFERENCES `t_elvap` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_reavp`
--

DROP TABLE IF EXISTS `t_reavp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reavp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `AVSA_ID` bigint(20) DEFAULT NULL,
  `ELVAP_ID` bigint(20) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK24BB7FDDF45A7D2` (`ELVAP_ID`),
  KEY `FK24BB7FDB2E63F01` (`AVSA_ID`),
  KEY `FK24BB7FDC3617E18` (`SOC_ID`),
  CONSTRAINT `FK24BB7FDB2E63F01` FOREIGN KEY (`AVSA_ID`) REFERENCES `t_avsap` (`id`),
  CONSTRAINT `FK24BB7FDC3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK24BB7FDDF45A7D2` FOREIGN KEY (`ELVAP_ID`) REFERENCES `t_elvap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_reclasrh`
--

DROP TABLE IF EXISTS `t_reclasrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reclasrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `deffet` date DEFAULT NULL,
  `denreg` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `ECHEA_ID` bigint(20) DEFAULT NULL,
  `ECHEN_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK2C4F214F3C8FED51` (`ECHEA_ID`),
  KEY `FK2C4F214FC5325ADA` (`EMPL_ID`),
  KEY `FK2C4F214F3C95D624` (`ECHEN_ID`),
  CONSTRAINT `FK2C4F214F3C8FED51` FOREIGN KEY (`ECHEA_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK2C4F214F3C95D624` FOREIGN KEY (`ECHEN_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK2C4F214FC5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_recorh`
--

DROP TABLE IF EXISTS `t_recorh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_recorh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `datetenue` date DEFAULT NULL,
  `lieutenue` varchar(255) DEFAULT NULL,
  `CC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK472C16A0E8F910E3` (`CC_ID`),
  CONSTRAINT `FK472C16A0E8F910E3` FOREIGN KEY (`CC_ID`) REFERENCES `t_cocorh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_recrurh`
--

DROP TABLE IF EXISTS `t_recrurh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_recrurh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `niveau` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `BESREC_ID` bigint(20) DEFAULT NULL,
  `CAND_ID` bigint(20) DEFAULT NULL,
  `ETAREC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9E58273EC6FD8939` (`BESREC_ID`),
  KEY `FK9E58273EACE770A1` (`CAND_ID`),
  KEY `FK9E58273EAFA264C2` (`ETAREC_ID`),
  CONSTRAINT `FK9E58273EACE770A1` FOREIGN KEY (`CAND_ID`) REFERENCES `t_cansporh` (`id`),
  CONSTRAINT `FK9E58273EAFA264C2` FOREIGN KEY (`ETAREC_ID`) REFERENCES `t_etaprh` (`id`),
  CONSTRAINT `FK9E58273EC6FD8939` FOREIGN KEY (`BESREC_ID`) REFERENCES `t_besrecrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_rederh`
--

DROP TABLE IF EXISTS `t_rederh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rederh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `dater` date DEFAULT NULL,
  `resume` longtext,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `DE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK472C6575F5A05FCA` (`DE_ID`),
  KEY `FK472C6575D88DC036` (`EMP_ID`),
  CONSTRAINT `FK472C6575D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK472C6575F5A05FCA` FOREIGN KEY (`DE_ID`) REFERENCES `t_deexrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_region`
--

DROP TABLE IF EXISTS `t_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_region` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `PAYS_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK472DD13F36471BD8` (`PAYS_ID`),
  CONSTRAINT `FK472DD13F36471BD8` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_reprp`
--

DROP TABLE IF EXISTS `t_reprp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reprp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `DEPR_ID` bigint(20) DEFAULT NULL,
  `ELVAP_ID` bigint(20) DEFAULT NULL,
  `CATE_ID` bigint(20) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK24BEFD0DF45A7D2` (`ELVAP_ID`),
  KEY `FK24BEFD0C3617E18` (`SOC_ID`),
  KEY `FK24BEFD07FBFCFE8` (`CATE_ID`),
  KEY `FK24BEFD018448E77` (`DEPR_ID`),
  CONSTRAINT `FK24BEFD018448E77` FOREIGN KEY (`DEPR_ID`) REFERENCES `t_deprp` (`id`),
  CONSTRAINT `FK24BEFD07FBFCFE8` FOREIGN KEY (`CATE_ID`) REFERENCES `t_caprp` (`id`),
  CONSTRAINT `FK24BEFD0C3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK24BEFD0DF45A7D2` FOREIGN KEY (`ELVAP_ID`) REFERENCES `t_elvap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_repserrh`
--

DROP TABLE IF EXISTS `t_repserrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_repserrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `CON_ID` bigint(20) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK42E293A4D88DC036` (`EMP_ID`),
  KEY `FK42E293A4D9CFA9BA` (`CON_ID`),
  CONSTRAINT `FK42E293A4D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK42E293A4D9CFA9BA` FOREIGN KEY (`CON_ID`) REFERENCES `t_decorh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_retrogrh`
--

DROP TABLE IF EXISTS `t_retrogrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_retrogrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `deffet` date DEFAULT NULL,
  `denreg` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `CATA_ID` bigint(20) DEFAULT NULL,
  `CATN_ID` bigint(20) DEFAULT NULL,
  `ECHEA_ID` bigint(20) DEFAULT NULL,
  `ECHEN_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK49AC410A86F60106` (`CATN_ID`),
  KEY `FK49AC410A86F01833` (`CATA_ID`),
  KEY `FK49AC410A3C8FED51` (`ECHEA_ID`),
  KEY `FK49AC410AC5325ADA` (`EMPL_ID`),
  KEY `FK49AC410A3C95D624` (`ECHEN_ID`),
  CONSTRAINT `FK49AC410A3C8FED51` FOREIGN KEY (`ECHEA_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK49AC410A3C95D624` FOREIGN KEY (`ECHEN_ID`) REFERENCES `t_eche` (`id`),
  CONSTRAINT `FK49AC410A86F01833` FOREIGN KEY (`CATA_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK49AC410A86F60106` FOREIGN KEY (`CATN_ID`) REFERENCES `t_cat` (`id`),
  CONSTRAINT `FK49AC410AC5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_rubr`
--

DROP TABLE IF EXISTS `t_rubr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rubr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `acomptesal` tinyint(1) DEFAULT NULL,
  `baseexcepsal` tinyint(1) DEFAULT NULL,
  `basetaxablesal` tinyint(1) DEFAULT NULL,
  `brutsal` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `congesal` tinyint(1) DEFAULT NULL,
  `cotisablesal` tinyint(1) DEFAULT NULL,
  `formule` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `nature` varchar(255) DEFAULT NULL,
  `porte` varchar(255) DEFAULT NULL,
  `proratesal` tinyint(1) DEFAULT NULL,
  `rappelsal` tinyint(1) DEFAULT NULL,
  `tauxpat` double DEFAULT NULL,
  `tauxsal` double DEFAULT NULL,
  `tauxtax` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `tauxplaf` double DEFAULT NULL,
  `avantagenat` tinyint(1) DEFAULT NULL,
  `tauxava` double DEFAULT NULL,
  `natureAv` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B85ADEC3617E18` (`SOC_ID`),
  CONSTRAINT `FK94B85ADEC3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_sanalytique`
--

DROP TABLE IF EXISTS `t_sanalytique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sanalytique` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `CA_ID` bigint(20) DEFAULT NULL,
  `CPTE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK48B76B93BEC88F57` (`CA_ID`),
  KEY `FK48B76B939D46358C` (`CPTE_ID`),
  KEY `FK48B76B93405F3CDC` (`CA_ID`),
  KEY `FK48B76B93C2EA1551` (`CPTE_ID`),
  KEY `FK48B76B93359AB7F` (`CA_ID`),
  KEY `FK48B76B93401CE3B4` (`CPTE_ID`),
  KEY `FK48B76B93B632A665` (`CA_ID`),
  KEY `FK48B76B93A6C1261A` (`CPTE_ID`),
  KEY `FK48B76B93E82F2C85` (`CA_ID`),
  KEY `FK48B76B932F68D43A` (`CPTE_ID`),
  CONSTRAINT `FK48B76B932F68D43A` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK48B76B93359AB7F` FOREIGN KEY (`CA_ID`) REFERENCES `t_canalytique` (`id`),
  CONSTRAINT `FK48B76B93401CE3B4` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK48B76B93405F3CDC` FOREIGN KEY (`CA_ID`) REFERENCES `t_canalytique` (`id`),
  CONSTRAINT `FK48B76B939D46358C` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK48B76B93A6C1261A` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK48B76B93B632A665` FOREIGN KEY (`CA_ID`) REFERENCES `t_canalytique` (`id`),
  CONSTRAINT `FK48B76B93BEC88F57` FOREIGN KEY (`CA_ID`) REFERENCES `t_canalytique` (`id`),
  CONSTRAINT `FK48B76B93C2EA1551` FOREIGN KEY (`CPTE_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK48B76B93E82F2C85` FOREIGN KEY (`CA_ID`) REFERENCES `t_canalytique` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_sancrh`
--

DROP TABLE IF EXISTS `t_sancrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sancrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `compterendu` longtext,
  `dateeffet` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `sanction` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `CC_ID` bigint(20) DEFAULT NULL,
  `LIRO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK48AD6444D88DC036` (`EMP_ID`),
  KEY `FK48AD64441691CFEE` (`LIRO_ID`),
  KEY `FK48AD6444F5915F8B` (`CC_ID`),
  CONSTRAINT `FK48AD64441691CFEE` FOREIGN KEY (`LIRO_ID`) REFERENCES `t_lirerh` (`id`),
  CONSTRAINT `FK48AD6444D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK48AD6444F5915F8B` FOREIGN KEY (`CC_ID`) REFERENCES `t_deexrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_seaformrh`
--

DROP TABLE IF EXISTS `t_seaformrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_seaformrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cours` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `hdebut` varchar(255) DEFAULT NULL,
  `hfin` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `FORMA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK7E94B0BE3D244181` (`FORMA_ID`),
  CONSTRAINT `FK7E94B0BE3D244181` FOREIGN KEY (`FORMA_ID`) REFERENCES `t_formarh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_sean_form`
--

DROP TABLE IF EXISTS `t_sean_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sean_form` (
  `SEAN_ID` bigint(20) NOT NULL,
  `FORM_ID` bigint(20) NOT NULL,
  KEY `FK8D1780D96416007E` (`SEAN_ID`),
  KEY `FK8D1780D9F8819D34` (`FORM_ID`),
  CONSTRAINT `FK8D1780D96416007E` FOREIGN KEY (`SEAN_ID`) REFERENCES `t_seaformrh` (`id`),
  CONSTRAINT `FK8D1780D9F8819D34` FOREIGN KEY (`FORM_ID`) REFERENCES `t_formrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_smes_can`
--

DROP TABLE IF EXISTS `t_smes_can`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_smes_can` (
  `SMESS_ID` bigint(20) NOT NULL,
  `CAN_ID` bigint(20) NOT NULL,
  KEY `FK3F3BE304D8828728` (`SMESS_ID`),
  KEY `FK3F3BE304BBDA8BE0` (`CAN_ID`),
  CONSTRAINT `FK3F3BE304BBDA8BE0` FOREIGN KEY (`CAN_ID`) REFERENCES `t_canal` (`id`),
  CONSTRAINT `FK3F3BE304D8828728` FOREIGN KEY (`SMESS_ID`) REFERENCES `t_kmsge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_smes_user`
--

DROP TABLE IF EXISTS `t_smes_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_smes_user` (
  `SMESS_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  KEY `FKA848EEF7D8828728` (`SMESS_ID`),
  KEY `FKA848EEF7224ABC49` (`USER_ID`),
  CONSTRAINT `FKA848EEF7224ABC49` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKA848EEF7D8828728` FOREIGN KEY (`SMESS_ID`) REFERENCES `t_kmsge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_societe`
--

DROP TABLE IF EXISTS `t_societe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_societe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codePostal` varchar(255) DEFAULT NULL,
  `courriel` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `numFiscal` varchar(255) DEFAULT NULL,
  `registre` varchar(255) DEFAULT NULL,
  `siteWeb` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `DEV_ID` bigint(20) DEFAULT NULL,
  `PAYS_ID` bigint(20) DEFAULT NULL,
  `SOCP_ID` bigint(20) DEFAULT NULL,
  `CAVA_ID` bigint(20) DEFAULT NULL,
  `JOCO_ID` bigint(20) DEFAULT NULL,
  `CREGR_ID` bigint(20) DEFAULT NULL,
  `cnps` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE44A85895E0D927` (`SOCP_ID`),
  KEY `FKE44A858958597449` (`DEV_ID`),
  KEY `FKE44A858936471BD8` (`PAYS_ID`),
  KEY `FKE44A858952FB3F60` (`DEV_ID`),
  KEY `FKE44A8589D03EC0AF` (`PAYS_ID`),
  KEY `FKE44A8589D8DC6197` (`CREGR_ID`),
  KEY `FKE44A8589E8A79AFA` (`DEV_ID`),
  KEY `FKE44A8589E4DAC9CF` (`JOCO_ID`),
  KEY `FKE44A8589F4A13AC9` (`PAYS_ID`),
  KEY `FKE44A85898D42D24F` (`CAVA_ID`),
  KEY `FKE44A858949F19676` (`SOCP_ID`),
  KEY `FKE44A8589BDA4511A` (`DEV_ID`),
  KEY `FKE44A8589B794F8E9` (`PAYS_ID`),
  CONSTRAINT `FKE44A858936471BD8` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FKE44A858949F19676` FOREIGN KEY (`SOCP_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKE44A858952FB3F60` FOREIGN KEY (`DEV_ID`) REFERENCES `t_devise` (`id`),
  CONSTRAINT `FKE44A858958597449` FOREIGN KEY (`DEV_ID`) REFERENCES `t_devise` (`id`),
  CONSTRAINT `FKE44A85895E0D927` FOREIGN KEY (`SOCP_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FKE44A85898D42D24F` FOREIGN KEY (`CAVA_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FKE44A8589B794F8E9` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FKE44A8589BDA4511A` FOREIGN KEY (`DEV_ID`) REFERENCES `t_devise` (`id`),
  CONSTRAINT `FKE44A8589D03EC0AF` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FKE44A8589D8DC6197` FOREIGN KEY (`CREGR_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FKE44A8589E4DAC9CF` FOREIGN KEY (`JOCO_ID`) REFERENCES `t_jcomptable` (`id`),
  CONSTRAINT `FKE44A8589E8A79AFA` FOREIGN KEY (`DEV_ID`) REFERENCES `t_devise` (`id`),
  CONSTRAINT `FKE44A8589F4A13AC9` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_speci`
--

DROP TABLE IF EXISTS `t_speci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_speci` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_stagerh`
--

DROP TABLE IF EXISTS `t_stagerh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_stagerh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ddebut` date DEFAULT NULL,
  `dfin` date DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `note` longtext,
  `portable` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `transport` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ddebutr` date DEFAULT NULL,
  `dfinr` date DEFAULT NULL,
  `BEST_ID` bigint(20) DEFAULT NULL,
  `DEPAR_ID` bigint(20) DEFAULT NULL,
  `ETAB_ID` bigint(20) DEFAULT NULL,
  `EMPL_ID` bigint(20) DEFAULT NULL,
  `NIVE_ID` bigint(20) DEFAULT NULL,
  `SPEC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FKECB5A8A9A0BFDDCA` (`NIVE_ID`),
  KEY `FKECB5A8A9937B3E31` (`ETAB_ID`),
  KEY `FKECB5A8A9515F8BA2` (`BEST_ID`),
  KEY `FKECB5A8A99E01852F` (`SPEC_ID`),
  KEY `FKECB5A8A9C5325ADA` (`EMPL_ID`),
  KEY `FKECB5A8A92B8DC71A` (`DEPAR_ID`),
  CONSTRAINT `FKECB5A8A92B8DC71A` FOREIGN KEY (`DEPAR_ID`) REFERENCES `t_depsoc` (`id`),
  CONSTRAINT `FKECB5A8A9515F8BA2` FOREIGN KEY (`BEST_ID`) REFERENCES `t_besstarh` (`id`),
  CONSTRAINT `FKECB5A8A9937B3E31` FOREIGN KEY (`ETAB_ID`) REFERENCES `t_etablrh` (`id`),
  CONSTRAINT `FKECB5A8A99E01852F` FOREIGN KEY (`SPEC_ID`) REFERENCES `t_speci` (`id`),
  CONSTRAINT `FKECB5A8A9A0BFDDCA` FOREIGN KEY (`NIVE_ID`) REFERENCES `t_nivetu` (`id`),
  CONSTRAINT `FKECB5A8A9C5325ADA` FOREIGN KEY (`EMPL_ID`) REFERENCES `t_employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_syndicatp`
--

DROP TABLE IF EXISTS `t_syndicatp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_syndicatp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `COMP_ID` bigint(20) DEFAULT NULL,
  `STRUC_ID` bigint(20) DEFAULT NULL,
  `TYPCAIS_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4817F7DCA4AEA909` (`COMP_ID`),
  KEY `FK4817F7DC647B3420` (`STRUC_ID`),
  KEY `FK4817F7DC3B44D5AA` (`TYPCAIS_ID`),
  CONSTRAINT `FK4817F7DC3B44D5AA` FOREIGN KEY (`TYPCAIS_ID`) REFERENCES `t_typcaisp` (`id`),
  CONSTRAINT `FK4817F7DC647B3420` FOREIGN KEY (`STRUC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK4817F7DCA4AEA909` FOREIGN KEY (`COMP_ID`) REFERENCES `t_compte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_tacstarh`
--

DROP TABLE IF EXISTS `t_tacstarh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tacstarh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `diff` longtext,
  `propo` longtext,
  `SUISTA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK28E3920B96CC09DF` (`SUISTA_ID`),
  CONSTRAINT `FK28E3920B96CC09DF` FOREIGN KEY (`SUISTA_ID`) REFERENCES `t_stagerh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_taxe`
--

DROP TABLE IF EXISTS `t_taxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_taxe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `calculTaxe` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `porte` varchar(255) DEFAULT NULL,
  `sens` varchar(255) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B8FB2549EACEA9` (`SOC_ID`),
  KEY `FK94B8FB25A3826672` (`SOC_ID`),
  KEY `FK94B8FB255BF1B16F` (`SOC_ID`),
  CONSTRAINT `FK94B8FB2549EACEA9` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B8FB255BF1B16F` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B8FB25A3826672` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_theforrh`
--

DROP TABLE IF EXISTS `t_theforrh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_theforrh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_tier`
--

DROP TABLE IF EXISTS `t_tier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `classe` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `confiance` varchar(255) DEFAULT NULL,
  `courriel` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `poste` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `CV_ID` bigint(20) DEFAULT NULL,
  `CPT_ID` bigint(20) DEFAULT NULL,
  `PAYCLI_ID` bigint(20) DEFAULT NULL,
  `PAYFOU_ID` bigint(20) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B916ED30C2FCF8` (`CV_ID`),
  KEY `FK94B916ED78300C72` (`PAYFOU_ID`),
  KEY `FK94B916ED49EACEA9` (`SOC_ID`),
  KEY `FK94B916EDB0F51683` (`CV_ID`),
  KEY `FK94B916ED72E1C79E` (`PAYCLI_ID`),
  KEY `FK94B916ED11DCBEE3` (`CPT_ID`),
  KEY `FK94B916EDE02A7F47` (`PAYFOU_ID`),
  KEY `FK94B916EDA3826672` (`SOC_ID`),
  KEY `FK94B916EDDADC3A73` (`PAYCLI_ID`),
  KEY `FK94B916ED37809EA8` (`CPT_ID`),
  KEY `FK94B916ED66F2B26` (`CV_ID`),
  KEY `FK94B916ED5B89F204` (`PAYFOU_ID`),
  KEY `FK94B916ED5BF1B16F` (`SOC_ID`),
  KEY `FK94B916ED563BAD30` (`PAYCLI_ID`),
  KEY `FK94B916EDB4B36D0B` (`CPT_ID`),
  CONSTRAINT `FK94B916ED11DCBEE3` FOREIGN KEY (`CPT_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B916ED30C2FCF8` FOREIGN KEY (`CV_ID`) REFERENCES `t_civilite` (`id`),
  CONSTRAINT `FK94B916ED37809EA8` FOREIGN KEY (`CPT_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B916ED49EACEA9` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B916ED563BAD30` FOREIGN KEY (`PAYCLI_ID`) REFERENCES `t_cpayment` (`id`),
  CONSTRAINT `FK94B916ED5B89F204` FOREIGN KEY (`PAYFOU_ID`) REFERENCES `t_cpayment` (`id`),
  CONSTRAINT `FK94B916ED5BF1B16F` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B916ED66F2B26` FOREIGN KEY (`CV_ID`) REFERENCES `t_civilite` (`id`),
  CONSTRAINT `FK94B916ED72E1C79E` FOREIGN KEY (`PAYCLI_ID`) REFERENCES `t_cpayment` (`id`),
  CONSTRAINT `FK94B916ED78300C72` FOREIGN KEY (`PAYFOU_ID`) REFERENCES `t_cpayment` (`id`),
  CONSTRAINT `FK94B916EDA3826672` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B916EDB0F51683` FOREIGN KEY (`CV_ID`) REFERENCES `t_civilite` (`id`),
  CONSTRAINT `FK94B916EDB4B36D0B` FOREIGN KEY (`CPT_ID`) REFERENCES `t_compte` (`id`),
  CONSTRAINT `FK94B916EDDADC3A73` FOREIGN KEY (`PAYCLI_ID`) REFERENCES `t_cpayment` (`id`),
  CONSTRAINT `FK94B916EDE02A7F47` FOREIGN KEY (`PAYFOU_ID`) REFERENCES `t_cpayment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_trderh`
--

DROP TABLE IF EXISTS `t_trderh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_trderh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `dateavis` date DEFAULT NULL,
  `motivation` longtext,
  `sanction` varchar(255) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `DE_ID` bigint(20) DEFAULT NULL,
  `POS_ID` bigint(20) DEFAULT NULL,
  `SUP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B4D4840F5A05FCA` (`DE_ID`),
  KEY `FK4B4D4840F0E254F0` (`SUP_ID`),
  KEY `FK4B4D4840E6527198` (`POS_ID`),
  KEY `FK4B4D4840D88DC036` (`EMP_ID`),
  CONSTRAINT `FK4B4D4840D88DC036` FOREIGN KEY (`EMP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK4B4D4840E6527198` FOREIGN KEY (`POS_ID`) REFERENCES `t_pos` (`id`),
  CONSTRAINT `FK4B4D4840F0E254F0` FOREIGN KEY (`SUP_ID`) REFERENCES `t_employ` (`id`),
  CONSTRAINT `FK4B4D4840F5A05FCA` FOREIGN KEY (`DE_ID`) REFERENCES `t_deexrh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_tycon`
--

DROP TABLE IF EXISTS `t_tycon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tycon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_tydme`
--

DROP TABLE IF EXISTS `t_tydme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tydme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_typcaisp`
--

DROP TABLE IF EXISTS `t_typcaisp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_typcaisp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_typcon`
--

DROP TABLE IF EXISTS `t_typcon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_typcon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nature` varchar(255) DEFAULT NULL,
  `nbrejours` smallint(6) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_unac`
--

DROP TABLE IF EXISTS `t_unac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_unac` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `coeff` double DEFAULT NULL,
  `UNGE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B99D8617EC1F92` (`UNGE_ID`),
  KEY `FK94B99D863BEB6C40` (`UNGE_ID`),
  KEY `FK94B99D8667347763` (`UNGE_ID`),
  CONSTRAINT `FK94B99D8617EC1F92` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK94B99D863BEB6C40` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`),
  CONSTRAINT `FK94B99D8667347763` FOREIGN KEY (`UNGE_ID`) REFERENCES `t_unge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_unge`
--

DROP TABLE IF EXISTS `t_unge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_unge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `adminlevel` varchar(255) DEFAULT NULL,
  `courriel` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `lastconfirme` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `LANG_ID` bigint(20) DEFAULT NULL,
  `SC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B9B0D685E5DD40` (`SC_ID`),
  KEY `FK94B9B0D688E89945` (`LANG_ID`),
  CONSTRAINT `FK94B9B0D685E5DD40` FOREIGN KEY (`SC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B9B0D688E89945` FOREIGN KEY (`LANG_ID`) REFERENCES `t_langue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user_event`
--

DROP TABLE IF EXISTS `t_user_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_event` (
  `EVENT_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  KEY `FK8D3C15D1BAF1D6EC` (`EVENT_ID`),
  KEY `FK8D3C15D1224ABC49` (`USER_ID`),
  CONSTRAINT `FK8D3C15D1224ABC49` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK8D3C15D1BAF1D6EC` FOREIGN KEY (`EVENT_ID`) REFERENCES `t_event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user_rigth`
--

DROP TABLE IF EXISTS `t_user_rigth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_rigth` (
  `USER_ID` bigint(20) NOT NULL,
  `RIGTH_ID` bigint(20) NOT NULL,
  KEY `FK8DED66BB224ABC49` (`USER_ID`),
  KEY `FK8DED66BB3EE8F865` (`RIGTH_ID`),
  CONSTRAINT `FK8DED66BB224ABC49` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK8DED66BB3EE8F865` FOREIGN KEY (`RIGTH_ID`) REFERENCES `t_groupe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user_sct`
--

DROP TABLE IF EXISTS `t_user_sct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_sct` (
  `USER_ID` bigint(20) NOT NULL,
  `SCT_ID` bigint(20) NOT NULL,
  KEY `FK4C55C51B224ABC49` (`USER_ID`),
  KEY `FK4C55C51B49496EEC` (`SCT_ID`),
  CONSTRAINT `FK4C55C51B224ABC49` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK4C55C51B49496EEC` FOREIGN KEY (`SCT_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_vari`
--

DROP TABLE IF EXISTS `t_vari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vari` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `formule` longtext,
  `methodcal` varchar(255) DEFAULT NULL,
  `repannuel` tinyint(1) DEFAULT NULL,
  `repmens` tinyint(1) DEFAULT NULL,
  `salarie` tinyint(1) DEFAULT NULL,
  `typeformule` varchar(255) DEFAULT NULL,
  `typevar` varchar(255) DEFAULT NULL,
  `SOC_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `FK94B9E32DC3617E18` (`SOC_ID`),
  CONSTRAINT `FK94B9E32DC3617E18` FOREIGN KEY (`SOC_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_view`
--

DROP TABLE IF EXISTS `t_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_view` (
  `TYPE_VIEW` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `script` longtext,
  `sequence` smallint(6) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `clazz` varchar(255) DEFAULT NULL,
  `entity` varchar(255) DEFAULT NULL,
  `extern` tinyint(1) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `script_s` longtext,
  `allday` tinyint(1) DEFAULT NULL,
  `endfield` varchar(255) DEFAULT NULL,
  `startfield` varchar(255) DEFAULT NULL,
  `titlefield` varchar(255) DEFAULT NULL,
  `F_ITEM_ID` bigint(20) DEFAULT NULL,
  `T_ITEM_ID` bigint(20) DEFAULT NULL,
  `R_ITEM_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK94B9FFB02958D88B` (`R_ITEM_ID`),
  KEY `FK94B9FFB03623A47F` (`F_ITEM_ID`),
  KEY `FK94B9FFB051E1B68D` (`T_ITEM_ID`),
  CONSTRAINT `FK94B9FFB02958D88B` FOREIGN KEY (`R_ITEM_ID`) REFERENCES `m_action` (`id`),
  CONSTRAINT `FK94B9FFB03623A47F` FOREIGN KEY (`F_ITEM_ID`) REFERENCES `m_action` (`id`),
  CONSTRAINT `FK94B9FFB051E1B68D` FOREIGN KEY (`T_ITEM_ID`) REFERENCES `m_action` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_vill`
--

DROP TABLE IF EXISTS `t_vill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary table structure for view `v_bulletin_paie`
--

DROP TABLE IF EXISTS `v_bulletin_paie`;
/*!50001 DROP VIEW IF EXISTS `v_bulletin_paie`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_bulletin_paie` (
  `ID` varbinary(60),
  `RUBRIQUE_ID` bigint(20),
  `LIGNE_BULL_ID` bigint(20),
  `BUL_ID` bigint(20),
  `MATRICULE` varchar(255),
  `PERIODE_ID` bigint(20),
  `DESIGNATION` varchar(7),
  `EDITTITLE` varchar(7),
  `LISTTITLE` varchar(7),
  `MODULENAME` varchar(7),
  `CREATEONFIELD` int(1),
  `COMPAREID` int(1),
  `SELECTED` int(1),
  `DESABLECREATE` int(1),
  `ACTIVATEFOLLOWER` int(1),
  `ACTIVEFILELIEN` int(1),
  `DESABLEDELETE` int(1),
  `FOOTERSCRIPT` varchar(7),
  `SERIAL` varchar(7)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `v_dipe_paie`
--

DROP TABLE IF EXISTS `v_dipe_paie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `v_dipe_paie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `RET` decimal(19,2) DEFAULT NULL,
  `RETIRPP` decimal(19,2) DEFAULT NULL,
  `RETTAXCOM` decimal(19,2) DEFAULT NULL,
  `SB` decimal(19,2) DEFAULT NULL,
  `SCOTCNPS` decimal(19,2) DEFAULT NULL,
  `SCOTPLAF` decimal(19,2) DEFAULT NULL,
  `SEXCEP` decimal(19,2) DEFAULT NULL,
  `STAXABLE` decimal(19,2) DEFAULT NULL,
  `BULL_ID` bigint(20) DEFAULT NULL,
  `PERIODE_ID` bigint(20) DEFAULT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA544A2295C178FE9` (`PERIODE_ID`),
  KEY `FKA544A229CA4E973D` (`BULL_ID`),
  CONSTRAINT `FKA544A2295C178FE9` FOREIGN KEY (`PERIODE_ID`) REFERENCES `t_pepa` (`id`),
  CONSTRAINT `FKA544A229CA4E973D` FOREIGN KEY (`BULL_ID`) REFERENCES `t_bupa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `v_laremlo`
--

DROP TABLE IF EXISTS `v_laremlo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `v_laremlo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `stock` double DEFAULT NULL,
  `ART_ID` bigint(20) DEFAULT NULL,
  `EMP_ID` bigint(20) DEFAULT NULL,
  `ENTR_ID` bigint(20) DEFAULT NULL,
  `LIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8375983F21C0D8FF` (`ENTR_ID`),
  KEY `FK8375983FB62C44B4` (`LIE_ID`),
  KEY `FK8375983F9D77A6BA` (`EMP_ID`),
  KEY `FK8375983FD2DB1278` (`ART_ID`),
  CONSTRAINT `FK8375983F21C0D8FF` FOREIGN KEY (`ENTR_ID`) REFERENCES `t_entr` (`id`),
  CONSTRAINT `FK8375983F9D77A6BA` FOREIGN KEY (`EMP_ID`) REFERENCES `t_empl` (`id`),
  CONSTRAINT `FK8375983FB62C44B4` FOREIGN KEY (`LIE_ID`) REFERENCES `t_liem` (`id`),
  CONSTRAINT `FK8375983FD2DB1278` FOREIGN KEY (`ART_ID`) REFERENCES `t_art` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Final view structure for view `v_bulletin_paie`
--

/*!50001 DROP TABLE IF EXISTS `v_bulletin_paie`*/;
/*!50001 DROP VIEW IF EXISTS `v_bulletin_paie`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_bulletin_paie` AS select concat(`r`.`id`,`l`.`id`,`b`.`id`) AS `ID`,`r`.`id` AS `RUBRIQUE_ID`,`l`.`id` AS `LIGNE_BULL_ID`,`b`.`id` AS `BUL_ID`,`e`.`matricule` AS `MATRICULE`,`p`.`id` AS `PERIODE_ID`,'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL` from ((((`t_rubr` `r` join `t_libupa` `l`) join `t_bupa` `b`) join `t_employ` `e`) join `t_pepa` `p`) where ((`r`.`id` = `l`.`RUBR_ID`) and (`b`.`id` = `l`.`LIBUPA_ID`) and (`b`.`EMP_ID` = `e`.`id`) and (`b`.`PEPA_ID` = `p`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-04 15:48:20
