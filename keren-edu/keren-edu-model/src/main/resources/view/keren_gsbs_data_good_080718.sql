-- MySQL dump 10.13  Distrib 5.1.56, for Win32 (ia32)
--
-- Host: localhost    Database: keren_gsbs_db
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
-- Dumping data for table `canal_grp`
--

LOCK TABLES `canal_grp` WRITE;
/*!40000 ALTER TABLE `canal_grp` DISABLE KEYS */;
/*!40000 ALTER TABLE `canal_grp` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `canal_user`
--

LOCK TABLES `canal_user` WRITE;
/*!40000 ALTER TABLE `canal_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `canal_user` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_abscence`
--

LOCK TABLES `e_abscence` WRITE;
/*!40000 ALTER TABLE `e_abscence` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_abscence` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `e_abscence_e_eleve`
--

LOCK TABLES `e_abscence_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_abscence_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_abscence_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_annee`
--

LOCK TABLES `e_annee` WRITE;
/*!40000 ALTER TABLE `e_annee` DISABLE KEYS */;
INSERT INTO `e_annee` VALUES (1,0,0,1531149443548,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'2018',1,'2018-09-03','2019-06-21');
/*!40000 ALTER TABLE `e_annee` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `I_DEB` bigint(20) DEFAULT NULL,
  `I_FIN` bigint(20) DEFAULT NULL,
  `APP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `APP` (`APP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_app`
--

LOCK TABLES `e_app` WRITE;
/*!40000 ALTER TABLE `e_app` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_app` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_avance_prof`
--

LOCK TABLES `e_avance_prof` WRITE;
/*!40000 ALTER TABLE `e_avance_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_avance_prof` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_bstage`
--

LOCK TABLES `e_bstage` WRITE;
/*!40000 ALTER TABLE `e_bstage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bstage` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `APPRE` varchar(255) DEFAULT NULL,
  `AVERT` tinyint(1) DEFAULT NULL,
  `BLAME` tinyint(1) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `CON_DIS` tinyint(1) DEFAULT NULL,
  `CONSIGNE` bigint(20) DEFAULT NULL,
  `ECRAT_TYPE` bigint(20) DEFAULT NULL,
  `Exclusions` bigint(20) DEFAULT NULL,
  `EXTR_MAX` bigint(20) DEFAULT NULL,
  `EXTR_MIN` bigint(20) DEFAULT NULL,
  `MOY_DER` bigint(20) DEFAULT NULL,
  `MOYENNE` bigint(20) DEFAULT NULL,
  `MOY_CLA` bigint(20) DEFAULT NULL,
  `MOY_PREMIER` bigint(20) DEFAULT NULL,
  `NB_ABS` bigint(20) DEFAULT NULL,
  `NB_ABS_N` bigint(20) DEFAULT NULL,
  `NB_MOY` bigint(20) DEFAULT NULL,
  `RANG` bigint(20) DEFAULT NULL,
  `RETARD` bigint(20) DEFAULT NULL,
  `Sanction` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `T_COEF` bigint(20) DEFAULT NULL,
  `T_POINT` bigint(20) DEFAULT NULL,
  `TX_REU` bigint(20) DEFAULT NULL,
  `CLS_ID` bigint(20) DEFAULT NULL,
  `INS_ID` bigint(20) DEFAULT NULL,
  `INSCRIPTION_ID` bigint(20) DEFAULT NULL,
  `EXAMEN_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5BBF39FC050B54B` (`INS_ID`),
  KEY `FK5BBF39F793CFE33` (`EXAMEN_ID`),
  KEY `FK5BBF39FB011B878` (`INSCRIPTION_ID`),
  KEY `FK5BBF39FD9978FE1` (`CLS_ID`),
  CONSTRAINT `FK5BBF39F793CFE33` FOREIGN KEY (`EXAMEN_ID`) REFERENCES `e_examen` (`id`),
  CONSTRAINT `FK5BBF39FB011B878` FOREIGN KEY (`INSCRIPTION_ID`) REFERENCES `e_inscription` (`id`),
  CONSTRAINT `FK5BBF39FC050B54B` FOREIGN KEY (`INS_ID`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FK5BBF39FD9978FE1` FOREIGN KEY (`CLS_ID`) REFERENCES `e_classe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_bul`
--

LOCK TABLES `e_bul` WRITE;
/*!40000 ALTER TABLE `e_bul` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bul` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_bul_lgn`
--

DROP TABLE IF EXISTS `e_bul_lgn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_bul_lgn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `COEF` bigint(20) DEFAULT NULL,
  `EXTR_MAX` bigint(20) DEFAULT NULL,
  `EXTR_MIN` bigint(20) DEFAULT NULL,
  `MOY_CLA` bigint(20) DEFAULT NULL,
  `MOY_20` bigint(20) DEFAULT NULL,
  `NOTE_1` bigint(20) DEFAULT NULL,
  `APPRECIATION` varchar(255) DEFAULT NULL,
  `POUR_REU` bigint(20) DEFAULT NULL,
  `RANG` bigint(20) DEFAULT NULL,
  `TOTAL` bigint(20) DEFAULT NULL,
  `MAT_ID` bigint(20) DEFAULT NULL,
  `MODULE_ID` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  `LGN_BUL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1977DDB3914540BB` (`MAT_ID`),
  KEY `FK1977DDB3EB699C0E` (`MODULE_ID`),
  KEY `FK1977DDB326A1B0B1` (`PROF_ID`),
  KEY `FK1977DDB3B97F24ED` (`LGN_BUL_ID`),
  CONSTRAINT `FK1977DDB326A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK1977DDB3914540BB` FOREIGN KEY (`MAT_ID`) REFERENCES `e_mat_dlt` (`id`),
  CONSTRAINT `FK1977DDB3B97F24ED` FOREIGN KEY (`LGN_BUL_ID`) REFERENCES `e_bul` (`id`),
  CONSTRAINT `FK1977DDB3EB699C0E` FOREIGN KEY (`MODULE_ID`) REFERENCES `e_module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_bul_lgn`
--

LOCK TABLES `e_bul_lgn` WRITE;
/*!40000 ALTER TABLE `e_bul_lgn` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bul_lgn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_bul_mod`
--

DROP TABLE IF EXISTS `e_bul_mod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_bul_mod` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `TYPE_BULL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_bul_mod`
--

LOCK TABLES `e_bul_mod` WRITE;
/*!40000 ALTER TABLE `e_bul_mod` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bul_mod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_bul_mod_e_examen`
--

DROP TABLE IF EXISTS `e_bul_mod_e_examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_bul_mod_e_examen` (
  `e_bul_mod_id` bigint(20) NOT NULL,
  `sequence_id` bigint(20) NOT NULL,
  KEY `FK4C31C75FE8E8C86F` (`e_bul_mod_id`),
  KEY `FK4C31C75F4DB218DA` (`sequence_id`),
  CONSTRAINT `FK4C31C75F4DB218DA` FOREIGN KEY (`sequence_id`) REFERENCES `e_examen` (`id`),
  CONSTRAINT `FK4C31C75FE8E8C86F` FOREIGN KEY (`e_bul_mod_id`) REFERENCES `e_bul_mod` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_bul_mod_e_examen`
--

LOCK TABLES `e_bul_mod_e_examen` WRITE;
/*!40000 ALTER TABLE `e_bul_mod_e_examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_bul_mod_e_examen` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `DATE_ENC` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PAI_ET_ID` bigint(20) DEFAULT NULL,
  `TYP_PAI` varchar(255) DEFAULT NULL,
  `REVENU` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_caisse`
--

LOCK TABLES `e_caisse` WRITE;
/*!40000 ALTER TABLE `e_caisse` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_caisse` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CAPACITE` bigint(20) DEFAULT NULL,
  `CYCLE_ID` bigint(20) DEFAULT NULL,
  `EFFECTIF` bigint(20) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `TYP_FORMATION` varchar(255) DEFAULT NULL,
  `FILIERE_ID` bigint(20) DEFAULT NULL,
  `NIVEAU_ID` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `LIBELLE` (`LIBELLE`),
  KEY `FK4C5637071D405596` (`FILIERE_ID`),
  KEY `FK4C563707A1EDEE9E` (`NIVEAU_ID`),
  KEY `FK4C56370726A1B0B1` (`PROF_ID`),
  CONSTRAINT `FK4C5637071D405596` FOREIGN KEY (`FILIERE_ID`) REFERENCES `e_filiere` (`id`),
  CONSTRAINT `FK4C56370726A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK4C563707A1EDEE9E` FOREIGN KEY (`NIVEAU_ID`) REFERENCES `e_niv_cls` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_classe`
--

LOCK TABLES `e_classe` WRITE;
/*!40000 ALTER TABLE `e_classe` DISABLE KEYS */;
INSERT INTO `e_classe` VALUES (1,0,0,1531212781704,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,'CLASS5 A','0',24,NULL,14),(3,0,0,1531213679257,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0,0,'CLASS1 A','0',19,NULL,13),(4,0,0,1531213784010,1,0,0,0,'CLASS1 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CLASS3 A','0',21,NULL,33),(5,0,0,1531213811624,1,0,0,0,'CLASS3 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CLASS4 A','0',22,NULL,17),(6,0,0,1531213840032,1,0,0,0,'CLASS4 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CLASS2 A','0',20,NULL,21),(7,0,0,1531213891184,1,0,0,0,'CLASS2 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CE1 A','0',10,NULL,11),(8,0,0,1531213992103,1,0,0,0,'CE1 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CE1 B','0',10,NULL,12),(9,0,0,1531214021617,1,0,0,0,'CE1 B','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CE2 A','0',11,NULL,7),(10,0,0,1531214068889,1,0,0,0,'CE2 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CE2 B','0',11,NULL,16),(11,0,0,0,1,0,0,0,'CM2 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',1,NULL,NULL,1,1,'CM2 A','0',13,NULL,6),(12,0,0,1531214140712,1,0,0,0,'CM2 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CP A','0',9,NULL,8),(13,0,0,1531214167920,1,0,0,0,'CP A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'SIL A','0',8,NULL,9),(14,0,0,1531214196088,1,0,0,0,'SIL A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CP B','0',9,NULL,10),(15,0,0,0,1,0,0,0,'CM1 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',1,NULL,NULL,1,1,'CM1 A','0',12,NULL,18),(16,0,0,1531214291648,1,0,0,0,'CM1 A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'CM1 B','0',12,NULL,19),(17,0,0,1531214333840,1,0,0,0,'SIL A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,1,0,'SIL B','0',8,NULL,20),(18,0,0,1531214366768,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0,0,'PN A','0',17,NULL,22),(19,0,0,1531214405519,1,0,0,0,'PN A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,2,0,'PN B','0',17,NULL,27),(20,0,0,1531214501817,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0,0,'NURSERY I','0',18,NULL,26),(21,0,0,1531214543281,1,0,0,0,'NURSERY I','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,2,0,'NURSERY II','0',18,NULL,29),(22,0,0,1531214583304,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,0,0,'GS A','0',16,NULL,28),(23,0,0,1531214630552,1,0,0,0,'GS A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,2,0,'MS A','0',15,NULL,31),(24,0,0,1531214666481,1,0,0,0,'MS A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,2,0,'PS A','0',14,NULL,30),(25,0,0,1531214717070,1,0,0,0,'PS A','Gestion des Classes',NULL,'Gestion des Classes','kereneducation',0,NULL,NULL,2,0,'PM A','0',31,NULL,34);
/*!40000 ALTER TABLE `e_classe` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_cmail`
--

LOCK TABLES `e_cmail` WRITE;
/*!40000 ALTER TABLE `e_cmail` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_cmail` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_coefmat`
--

LOCK TABLES `e_coefmat` WRITE;
/*!40000 ALTER TABLE `e_coefmat` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_coefmat` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `GROUPE_ID` bigint(20) DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  `PROF_ID` bigint(20) DEFAULT NULL,
  `COEF_MAT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDB2728E37A31160C` (`MATIERE_ID`),
  KEY `FKDB2728E329F3B03E` (`CLASSE_ID`),
  KEY `FKDB2728E3EF8F7274` (`GROUPE_ID`),
  KEY `FKDB2728E3F0F24BD5` (`COEF_MAT_ID`),
  KEY `FKDB2728E326A1B0B1` (`PROF_ID`),
  CONSTRAINT `FKDB2728E326A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FKDB2728E329F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FKDB2728E37A31160C` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_mat_dlt` (`id`),
  CONSTRAINT `FKDB2728E3EF8F7274` FOREIGN KEY (`GROUPE_ID`) REFERENCES `e_module` (`id`),
  CONSTRAINT `FKDB2728E3F0F24BD5` FOREIGN KEY (`COEF_MAT_ID`) REFERENCES `e_coefmat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_coefmatdtl`
--

LOCK TABLES `e_coefmatdtl` WRITE;
/*!40000 ALTER TABLE `e_coefmatdtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_coefmatdtl` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_contacts`
--

LOCK TABLES `e_contacts` WRITE;
/*!40000 ALTER TABLE `e_contacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_cycle`
--

DROP TABLE IF EXISTS `e_cycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_cycle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `CYCLE` varchar(255) DEFAULT NULL,
  `CYCLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK869D5C8C69C72A6` (`CYCLE_ID`),
  CONSTRAINT `FK869D5C8C69C72A6` FOREIGN KEY (`CYCLE_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_cycle`
--

LOCK TABLES `e_cycle` WRITE;
/*!40000 ALTER TABLE `e_cycle` DISABLE KEYS */;
INSERT INTO `e_cycle` VALUES (1,0,0,1531199742329,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Groupe Scolaire Bilingue les Sauterelles','1',NULL),(2,0,0,1531199793567,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Groupe Scolaire Bilingue les Sauterelles: Maternelle','0',NULL),(3,0,0,1531199814336,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Groupe Scolaire Bilingue les Sauterelles: Secondaire','2',NULL);
/*!40000 ALTER TABLE `e_cycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_depense`
--

DROP TABLE IF EXISTS `e_depense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_depense` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `Code` varchar(255) DEFAULT NULL,
  `DATE_ENC` date DEFAULT NULL,
  `DEPENSE` bigint(20) DEFAULT NULL,
  `TYPE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6831EB7053C771CC` (`TYPE_ID`),
  CONSTRAINT `FK6831EB7053C771CC` FOREIGN KEY (`TYPE_ID`) REFERENCES `e_t_dps` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_depense`
--

LOCK TABLES `e_depense` WRITE;
/*!40000 ALTER TABLE `e_depense` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_depense` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_diplome`
--

LOCK TABLES `e_diplome` WRITE;
/*!40000 ALTER TABLE `e_diplome` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_diplome` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_dlieu`
--

LOCK TABLES `e_dlieu` WRITE;
/*!40000 ALTER TABLE `e_dlieu` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_dlieu` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_dossier`
--

LOCK TABLES `e_dossier` WRITE;
/*!40000 ALTER TABLE `e_dossier` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_dossier` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ADR_HOP` varchar(255) DEFAULT NULL,
  `ALLERTE_MEDICALE` varchar(255) DEFAULT NULL,
  `BLOC` varchar(255) DEFAULT NULL,
  `DATENAIS` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `EMAIL_MERE` varchar(255) DEFAULT NULL,
  `EMAIL_PERE` varchar(255) DEFAULT NULL,
  `EMAIL_TUTEUR` varchar(255) DEFAULT NULL,
  `PHOTO` varchar(255) DEFAULT NULL,
  `inscrit` tinyint(1) NOT NULL,
  `L_NAIS` varchar(255) DEFAULT NULL,
  `MATRICULE` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `QUARTIER` varchar(255) DEFAULT NULL,
  `REFERENCE_HOPITAL` varchar(255) DEFAULT NULL,
  `SEXE` varchar(255) DEFAULT NULL,
  `SITFAMILIALE` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `TEL_MERE` varchar(255) DEFAULT NULL,
  `TEL_PERE` varchar(255) DEFAULT NULL,
  `TEL_TUTEUR` varchar(255) DEFAULT NULL,
  `TEL` varchar(255) DEFAULT NULL,
  `NATIONALITE_ID` bigint(20) DEFAULT NULL,
  `NIVEAU_ID` bigint(20) DEFAULT NULL,
  `PREFESSION_ID` bigint(20) DEFAULT NULL,
  `RESP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK86B3AB73C8997E` (`PREFESSION_ID`),
  KEY `FK86B3AB734896CDA` (`RESP_ID`),
  KEY `FK86B3AB73B3FB8AF0` (`NIVEAU_ID`),
  KEY `FK86B3AB735E3BB5AC` (`NATIONALITE_ID`),
  CONSTRAINT `FK86B3AB734896CDA` FOREIGN KEY (`RESP_ID`) REFERENCES `e_resp` (`id`),
  CONSTRAINT `FK86B3AB735E3BB5AC` FOREIGN KEY (`NATIONALITE_ID`) REFERENCES `e_nat` (`id`),
  CONSTRAINT `FK86B3AB73B3FB8AF0` FOREIGN KEY (`NIVEAU_ID`) REFERENCES `e_niv` (`id`),
  CONSTRAINT `FK86B3AB73C8997E` FOREIGN KEY (`PREFESSION_ID`) REFERENCES `e_prof` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_eleve`
--

LOCK TABLES `e_eleve` WRITE;
/*!40000 ALTER TABLE `e_eleve` DISABLE KEYS */;
INSERT INTO `e_eleve` VALUES (1,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M1/2018','ABEGA ','JEAN CLAUDE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M2/2018','ADA AVA ','SABINE NAOMIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M3/2018','ADAWA BOUBA','null',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M4/2018','ADJEMOU ','FERNANDE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M5/2018','AMBADIANG ','GREGOIRE JOEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M6/2018','AMOUGOU ATEBA ','RAPHAEL HERMANN',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M7/2018','ARBO GASTE NGUELA ','LAFACE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M8/2018','ASSOMO NKOMO ','GABRIELLE SALOME',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M9/2018','ATOUBA NDEMBA','null',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M10/2018','BABAGMAK EDOA','null',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M11/2018','BACOMWA TOUZIK ','TAITIM',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M12/2018','BANDOLO ','ELISETTE VERUSHKA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M13/2018','BANGDA ','LUIS NAZARIO',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M14/2018','BEKONO MEFOUMANA ','ALEXANDRA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M15/2018','BELECK A NGAM ','MIREILLE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M16/2018','BELLA NAMA ','VICTORINE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M17/2018','DJEUFACK TONFOCK ','ANICK',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M18/2018','EDA BETEH BALBINE ','JOSEPHINE LAURENNE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M19/2018','EKOMANE BEYENE ','JEANNE NEFERTITIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M20/2018','ELLA BENGONO ','MARCELINE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M21/2018','EKONO TENO FABIEN ','PHAREL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M22/2018','ENGOULOU',' MARIE CYNTHIA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M23/2018','ELOUMA ONGUENE ','GEOVANI LUDOVIC',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M24/2018','ESSONO ETOUNDI ','BENOIT',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M25/2018','ESSAMA MBO\'OSSI','null',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M26/2018','EYENGA ','SORELLE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M27/2018','ETOA EBODE ','INES STEPHANIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M28/2018','FEUMBI NGODOM ','DANIEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M29/2018','FEUBI ','MANUELA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M30/2018','GOMENI  YEPMO ','YANN',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M31/2018',' ISANGYA ESSA\'A  ','MARIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M32/2018','KAKE MAWE ','EYREEN',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M33/2018','KEMGANG KOUAMO',' FORTUNE BLANCHE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M34/2018','KENMOE TOUKAM ','MICHEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M35/2018','KENNE OBAMA ','GAELLE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M36/2018','KOUAMO MOYO ','STEVE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M37/2018','MADJACK ZEHMA ','ANGE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M38/2018','MAKOMO ASSOLA  ','MAEVA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M39/2018','MAMIAH ','EMMANUEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M40/2018','MBA PEGUEDJI ','DARRYL ISMAEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M41/2018','MBEUTCHA ','EMANUEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M42/2018','MBIA ','CHANTAL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M43/2018','MEDJO NKOLO SAME ','MYLENE ZELIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M44/2018','MELI NGOUONET ',' PRIDIBEN LEAS',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M45/2018','METIODA NANA ','BELLE JOLIE GRACE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M46/2018','MELINGUI ','AGNES',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M47/2018','MEUTCHEHE SAYOUGNE ','PAOLA WINNIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(48,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M48/2018','MEUTCHEHE MEUKEGNE',' PATXI WINSTON',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M49/2018','MVOGO ','AVIDI',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M50/2018','MEVA\'A NKOMEZO\'O ','AGRIPINE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M51/2018','NAMA ','MELANIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M52/2018','MVONDO ','BERNARD',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(53,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M53/2018','NDZENGUE ENDEZOUMO ','PHILOMENE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M54/2018','NAYIMBO ','FLORE MISPA ANDREINA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M55/2018','NGO BIHIHA ','ELYSEE GLORIA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M56/2018','NGAH ','EDJENGTE DESIRE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M57/2018','NGONO BADANG ','AXELLE CARLA',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M58/2018','NGONO ','AGNES',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M59/2018','NGUETNIA AMOUGOU ','ARTHUR JUNIOR',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M60/2018','NGONO MEDOUGA ','JULIENNE SAMANTHA ',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(61,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M61/2018','NTONGA NAOUSSI ','ANGE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M62/2018','NYATEBA ','FRANCISCA RAPHAELLE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(63,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M63/2018','NOA ESSOMBA',' PIERRE ARMANG',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(64,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M64/2018','NOUMTCHUE TCHINDA ','MANUELLA ANGE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(65,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M65/2018','OLINGA OLINGA ','JEAN GASTON',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(66,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M66/2018','POKAM ELONGUE ','JACQUES EMMANUEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(67,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M67/2018','NZOGNOU ','SOPLIFNIE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(68,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M68/2018','OBOUGOU',' TONY WILLIAM',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(69,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M69/2018','SONOC ','KIZITO',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(70,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M70/2018','TCHIMOU ','ARCEL GADDIEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(71,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M71/2018','SIKATI TCHADAM ','DAINA LAURE',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(72,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M72/2018','SIMO KAMSU ','CEDRIC CABREL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(73,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M73/2018','WOCZOU SIMANI ','MADELEINE C',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(74,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M74/2018','YOSSA MEPEYOU ','LEONEL WINGTOM',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(75,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M75/2018','TSOGO ','ELISABETH ARIEL',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(76,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M76/2018','WENGA KALAMO ','LOIC',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(77,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,'M77/2018','YOUTA MBOUGANG','null',NULL,NULL,'0','0','initial',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_emarge`
--

LOCK TABLES `e_emarge` WRITE;
/*!40000 ALTER TABLE `e_emarge` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_emarge` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  KEY `FK6C68FE3E1F8CF14` (`MAT_ID`),
  CONSTRAINT `FK6C68FE3E1F8CF14` FOREIGN KEY (`MAT_ID`) REFERENCES `e_coefmatdtl` (`id`),
  CONSTRAINT `FK6C68FE3E5A256387` FOREIGN KEY (`EMARG_DLT_ID`) REFERENCES `e_emarge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_emarge_dlt`
--

LOCK TABLES `e_emarge_dlt` WRITE;
/*!40000 ALTER TABLE `e_emarge_dlt` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_emarge_dlt` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  CONSTRAINT `FKB94D9AF5700D07E6` FOREIGN KEY (`EVA_ID`) REFERENCES `e_suvi_eleve` (`id`),
  CONSTRAINT `FKB94D9AF57F897E9` FOREIGN KEY (`VAL_ID`) REFERENCES `e_professeur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_evastge`
--

LOCK TABLES `e_evastge` WRITE;
/*!40000 ALTER TABLE `e_evastge` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_evastge` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `SUR` bigint(20) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `PERIODE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FK5068EA2254D33C3E` (`PERIODE_ID`),
  CONSTRAINT `FK5068EA2254D33C3E` FOREIGN KEY (`PERIODE_ID`) REFERENCES `e_periode` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_examen`
--

LOCK TABLES `e_examen` WRITE;
/*!40000 ALTER TABLE `e_examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_examen` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `CYCLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FKD89B15FE828599D6` (`CYCLE_ID`),
  CONSTRAINT `FKD89B15FE828599D6` FOREIGN KEY (`CYCLE_ID`) REFERENCES `e_cycle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_filiere`
--

LOCK TABLES `e_filiere` WRITE;
/*!40000 ALTER TABLE `e_filiere` DISABLE KEYS */;
INSERT INTO `e_filiere` VALUES (8,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'SIL',NULL,'Classe Préparatoire',1),(9,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CP',NULL,'Classe Préparatoire',1),(10,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CE1',NULL,'Cours Elémentaire',1),(11,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CE2',NULL,'Cours Elémentaire',1),(12,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CM1',NULL,'Cours Moyen',1),(13,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CM2',NULL,'Cours Moyen',1),(14,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'PS',NULL,'Petite Section',2),(15,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'MS',NULL,'Moyen Section',2),(16,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'GS',NULL,'Grande Section',2),(17,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'PN',NULL,'Pre nursery',2),(18,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'N',NULL,'Nursey',2),(19,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CLASS1',NULL,'Classe Préparatoire',1),(20,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CLASS2',NULL,'Classe Préparatoire',1),(21,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CLASS3',NULL,'Cours Elémentaire',1),(22,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CLASS4',NULL,'Cours Elémentaire',1),(23,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CLASS6',NULL,'Cours Moyen',1),(24,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'CLASS5',NULL,'Cours Moyen',1),(25,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'5EME',NULL,'CINQUIEME',3),(26,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'6EME',NULL,'SIXIEME',3),(27,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'FROMI',NULL,'FROMI',3),(28,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'4EME',NULL,'QAUTRIEME',3),(29,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'FROMIII',NULL,'FROMIII',3),(30,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'FROMII',NULL,'FROMII',3),(31,0,0,1531214735771,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,50,'PM',NULL,'PreMaternelle',2);
/*!40000 ALTER TABLE `e_filiere` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_fpaie_prof`
--

LOCK TABLES `e_fpaie_prof` WRITE;
/*!40000 ALTER TABLE `e_fpaie_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_fpaie_prof` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `CYCLE_ID` bigint(20) DEFAULT NULL,
  `DATE_INS` date DEFAULT NULL,
  `STATUT` varchar(255) DEFAULT NULL,
  `MNT` bigint(20) DEFAULT NULL,
  `MNT_PAYE` bigint(20) DEFAULT NULL,
  `REMISE` bigint(20) DEFAULT NULL,
  `RISTOURNE` bigint(20) DEFAULT NULL,
  `SOLDE` bigint(20) DEFAULT NULL,
  `TOTAL` bigint(20) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `ELEVE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCDFEAFE29F3B03E` (`CLASSE_ID`),
  KEY `FKCDFEAFE6DF650C` (`ELEVE_ID`),
  CONSTRAINT `FKCDFEAFE29F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FKCDFEAFE6DF650C` FOREIGN KEY (`ELEVE_ID`) REFERENCES `e_eleve` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_inscription`
--

LOCK TABLES `e_inscription` WRITE;
/*!40000 ALTER TABLE `e_inscription` DISABLE KEYS */;
INSERT INTO `e_inscription` VALUES (2,0,0,1531218530442,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'2018',1,'2018-07-10','1',76500,0,0,0,76500,76500,15,1);
/*!40000 ALTER TABLE `e_inscription` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `JOURS` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK57CFB47A29F3B03E` (`CLASSE_ID`),
  CONSTRAINT `FK57CFB47A29F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_jcours`
--

LOCK TABLES `e_jcours` WRITE;
/*!40000 ALTER TABLE `e_jcours` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_jcours` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_lstage`
--

LOCK TABLES `e_lstage` WRITE;
/*!40000 ALTER TABLE `e_lstage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_lstage` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_mail`
--

LOCK TABLES `e_mail` WRITE;
/*!40000 ALTER TABLE `e_mail` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_mail` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `e_mail_e_eleve`
--

LOCK TABLES `e_mail_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_mail_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_mail_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_mat`
--

DROP TABLE IF EXISTS `e_mat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_mat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `FILIERE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FILIERE_ID` (`FILIERE_ID`),
  KEY `FK5BC1A861D405596` (`FILIERE_ID`),
  CONSTRAINT `FK5BC1A861D405596` FOREIGN KEY (`FILIERE_ID`) REFERENCES `e_filiere` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_mat`
--

LOCK TABLES `e_mat` WRITE;
/*!40000 ALTER TABLE `e_mat` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_mat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_mat_dlt`
--

DROP TABLE IF EXISTS `e_mat_dlt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_mat_dlt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `COEF` int(11) DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FK3DAC1BB3CD3DF236` (`MATIERE_ID`),
  CONSTRAINT `FK3DAC1BB3CD3DF236` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_mat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_mat_dlt`
--

LOCK TABLES `e_mat_dlt` WRITE;
/*!40000 ALTER TABLE `e_mat_dlt` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_mat_dlt` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  CONSTRAINT `FK8AEC5CB9CD3DF236` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_mat` (`id`),
  CONSTRAINT `FK8AEC5CB9F09BDF49` FOREIGN KEY (`ANNEE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_matierecoutprof`
--

LOCK TABLES `e_matierecoutprof` WRITE;
/*!40000 ALTER TABLE `e_matierecoutprof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_matierecoutprof` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_module`
--

LOCK TABLES `e_module` WRITE;
/*!40000 ALTER TABLE `e_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_module` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_nat`
--

LOCK TABLES `e_nat` WRITE;
/*!40000 ALTER TABLE `e_nat` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_nat` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_niv`
--

LOCK TABLES `e_niv` WRITE;
/*!40000 ALTER TABLE `e_niv` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_niv` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_niv_cls`
--

LOCK TABLES `e_niv_cls` WRITE;
/*!40000 ALTER TABLE `e_niv_cls` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_niv_cls` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `CLASSE_ID` bigint(20) DEFAULT NULL,
  `EXAMEN_ID` bigint(20) DEFAULT NULL,
  `MATIERE_ID` bigint(20) DEFAULT NULL,
  `PROF` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC4A20E2DEAE4A465` (`MATIERE_ID`),
  KEY `FKC4A20E2D29F3B03E` (`CLASSE_ID`),
  KEY `FKC4A20E2D3947F049` (`PROF`),
  KEY `FKC4A20E2D793CFE33` (`EXAMEN_ID`),
  CONSTRAINT `FKC4A20E2D29F3B03E` FOREIGN KEY (`CLASSE_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FKC4A20E2D3947F049` FOREIGN KEY (`PROF`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FKC4A20E2D793CFE33` FOREIGN KEY (`EXAMEN_ID`) REFERENCES `e_examen` (`id`),
  CONSTRAINT `FKC4A20E2DEAE4A465` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_coefmatdtl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_note_mat`
--

LOCK TABLES `e_note_mat` WRITE;
/*!40000 ALTER TABLE `e_note_mat` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_note_mat` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `NOTE` bigint(20) DEFAULT NULL,
  `APPRECIATION` varchar(255) DEFAULT NULL,
  `SUR` bigint(20) DEFAULT NULL,
  `ETUDIANT_ID` bigint(20) DEFAULT NULL,
  `EL_NOTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8A78E9E0948EE958` (`EL_NOTE_ID`),
  KEY `FK8A78E9E0EE6CA474` (`ETUDIANT_ID`),
  CONSTRAINT `FK8A78E9E0948EE958` FOREIGN KEY (`EL_NOTE_ID`) REFERENCES `e_note_mat` (`id`),
  CONSTRAINT `FK8A78E9E0EE6CA474` FOREIGN KEY (`ETUDIANT_ID`) REFERENCES `e_inscription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_notedlt`
--

LOCK TABLES `e_notedlt` WRITE;
/*!40000 ALTER TABLE `e_notedlt` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_notedlt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_p_ech_dlt`
--

DROP TABLE IF EXISTS `e_p_ech_dlt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_p_ech_dlt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATE_ECH` date DEFAULT NULL,
  `ID_PAIE` bigint(20) DEFAULT NULL,
  `MNT` bigint(20) DEFAULT NULL,
  `MNT_PAYER` bigint(20) DEFAULT NULL,
  `SOLDE` bigint(20) DEFAULT NULL,
  `ETAT` varchar(255) DEFAULT NULL,
  `ECH_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_p_ech_dlt`
--

LOCK TABLES `e_p_ech_dlt` WRITE;
/*!40000 ALTER TABLE `e_p_ech_dlt` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_p_ech_dlt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_p_fiche`
--

DROP TABLE IF EXISTS `e_p_fiche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_p_fiche` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `ANNEE_ID` varchar(255) DEFAULT NULL,
  `MNT_PAYER` bigint(20) DEFAULT NULL,
  `payer` tinyint(1) NOT NULL,
  `SOLDE` bigint(20) DEFAULT NULL,
  `M_HT` bigint(20) DEFAULT NULL,
  `MNT_PAI_TMP` bigint(20) DEFAULT NULL,
  `QTE` bigint(20) DEFAULT NULL,
  `REMISE` bigint(20) DEFAULT NULL,
  `RISTOURNE` bigint(20) DEFAULT NULL,
  `TOTAL_TTC` bigint(20) DEFAULT NULL,
  `SER_ID` bigint(20) DEFAULT NULL,
  `FICHE_PAIE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD8345A9432E932EB` (`SER_ID`),
  KEY `FKD8345A94A794E421` (`FICHE_PAIE_ID`),
  CONSTRAINT `FKD8345A9432E932EB` FOREIGN KEY (`SER_ID`) REFERENCES `e_service` (`id`),
  CONSTRAINT `FKD8345A94A794E421` FOREIGN KEY (`FICHE_PAIE_ID`) REFERENCES `e_inscription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_p_fiche`
--

LOCK TABLES `e_p_fiche` WRITE;
/*!40000 ALTER TABLE `e_p_fiche` DISABLE KEYS */;
INSERT INTO `e_p_fiche` VALUES (2,0,0,0,1,0,1,0,'INS','Fiche de Paiements ',NULL,'Fiche de Paiements','kereneducation',0,NULL,NULL,0,0,11500,11500,NULL,1,0,0,11500,1,2),(3,0,0,0,1,0,1,0,'TRANCHE I','Fiche de Paiements ',NULL,'Fiche de Paiements','kereneducation',0,NULL,NULL,0,0,25000,25000,NULL,1,0,0,25000,4,2),(4,0,0,0,1,0,1,0,'TRANCHE 2','Fiche de Paiements ',NULL,'Fiche de Paiements','kereneducation',0,NULL,NULL,0,0,20000,20000,NULL,1,0,0,20000,5,2),(5,0,0,0,1,0,1,0,'TRANCHE 3','Fiche de Paiements ',NULL,'Fiche de Paiements','kereneducation',0,NULL,NULL,0,0,20000,20000,NULL,1,0,0,20000,6,2);
/*!40000 ALTER TABLE `e_p_fiche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_p_paie`
--

DROP TABLE IF EXISTS `e_p_paie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_p_paie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
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
  `TOTAL_A_PAYER` bigint(20) DEFAULT NULL,
  `TOTAL_PAYER` bigint(20) DEFAULT NULL,
  `TYP_PAI` varchar(255) DEFAULT NULL,
  `ZMNT` bigint(20) DEFAULT NULL,
  `ZMNT_VERSER` bigint(20) DEFAULT NULL,
  `ZREMISE` bigint(20) DEFAULT NULL,
  `ElEVE_ID` bigint(20) DEFAULT NULL,
  `F_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`CODE`),
  KEY `FK61D492562CD8D36D` (`F_ID`),
  KEY `FK61D49256C9754C63` (`ElEVE_ID`),
  CONSTRAINT `FK61D492562CD8D36D` FOREIGN KEY (`F_ID`) REFERENCES `e_p_fiche` (`id`),
  CONSTRAINT `FK61D49256C9754C63` FOREIGN KEY (`ElEVE_ID`) REFERENCES `e_inscription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_p_paie`
--

LOCK TABLES `e_p_paie` WRITE;
/*!40000 ALTER TABLE `e_p_paie` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_p_paie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_p_rgl`
--

DROP TABLE IF EXISTS `e_p_rgl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_p_rgl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
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
  KEY `FK8748F42ECF37C149` (`EL_ID`),
  CONSTRAINT `FK8748F42ECF37C149` FOREIGN KEY (`EL_ID`) REFERENCES `e_inscription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_p_rgl`
--

LOCK TABLES `e_p_rgl` WRITE;
/*!40000 ALTER TABLE `e_p_rgl` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_p_rgl` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_paie_prof`
--

LOCK TABLES `e_paie_prof` WRITE;
/*!40000 ALTER TABLE `e_paie_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_paie_prof` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `ANNEE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE31AB4EAF09BDF49` (`ANNEE_ID`),
  CONSTRAINT `FKE31AB4EAF09BDF49` FOREIGN KEY (`ANNEE_ID`) REFERENCES `e_annee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_periode`
--

LOCK TABLES `e_periode` WRITE;
/*!40000 ALTER TABLE `e_periode` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_periode` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_presence`
--

LOCK TABLES `e_presence` WRITE;
/*!40000 ALTER TABLE `e_presence` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_presence` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `e_presence_e_eleve`
--

LOCK TABLES `e_presence_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_presence_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_presence_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_prime_prof`
--

LOCK TABLES `e_prime_prof` WRITE;
/*!40000 ALTER TABLE `e_prime_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_prime_prof` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_prof`
--

LOCK TABLES `e_prof` WRITE;
/*!40000 ALTER TABLE `e_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_prof` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `Statut` varchar(255) DEFAULT NULL,
  `SAL` bigint(20) DEFAULT NULL,
  `SEXE` varchar(255) DEFAULT NULL,
  `STATUS_ID` varchar(255) DEFAULT NULL,
  `Tx_H` bigint(20) DEFAULT NULL,
  `DIP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NOM` (`NOM`),
  KEY `FK1D166D0857DEABB` (`DIP_ID`),
  CONSTRAINT `FK1D166D0857DEABB` FOREIGN KEY (`DIP_ID`) REFERENCES `e_diplome` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_professeur`
--

LOCK TABLES `e_professeur` WRITE;
/*!40000 ALTER TABLE `e_professeur` DISABLE KEYS */;
INSERT INTO `e_professeur` VALUES (1,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'EMAGO ',0,'agnes louise','0',0,'1',NULL,0,NULL),(2,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Elangwe ',0,'celine','0',0,'1',NULL,0,NULL),(3,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Ntsama  ',0,'parfait','1',0,'0',NULL,0,NULL),(4,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Napoleon ',0,'Keming','2',0,'0',NULL,0,NULL),(5,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' djomo ',0,'null','3',0,'1',NULL,0,NULL),(6,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Mme Abalang ',0,'flore','2',0,'1',NULL,0,NULL),(7,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Mme Mbomezomo ',0,'peggy','2',0,'0',NULL,0,NULL),(8,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Mme Messomo ',0,'pauline','2',0,'1',NULL,0,NULL),(9,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Mme Ngono  ',0,'Flore','2',0,'1',NULL,0,NULL),(10,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' DJUIDJE  ',0,'Irene','2',0,'1',NULL,0,NULL),(11,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Nguele ',0,'Danny','2',0,'1',NULL,0,NULL),(12,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' wedan Nana  ',0,'Franck','2',0,'0',NULL,0,NULL),(13,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Edjimbi  ',0,'Caroline','2',0,'1',NULL,0,NULL),(14,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Ajumi ',0,'Emmanuel','2',0,'0',NULL,0,NULL),(15,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Nsoh ',0,'Elvis','2',0,'0',NULL,0,NULL),(16,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Endomba ',0,'Emmeratine','2',0,'1',NULL,0,NULL),(17,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Ayuk eyong ',0,'catherine','2',0,'1',NULL,0,NULL),(18,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Longueu ndjatti ',0,'alice mireille','2',0,'1',NULL,0,NULL),(19,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Mme kom ngounou ',0,'chimene','2',0,'1',NULL,0,NULL),(20,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Moumepisse ',0,'marie gilbert','2',0,'1',NULL,0,NULL),(21,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Mme Fru  ',0,'Loveline','2',0,'1',NULL,0,NULL),(22,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Mbou ',0,'Doliane','2',0,'1',NULL,0,NULL),(23,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Nelson Besusuh',0,'null','2',0,'1',NULL,0,NULL),(24,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Jick ging ',0,'siloline','2',0,'1',NULL,0,NULL),(25,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Motchue ',0,'Stephanie','2',0,'1',NULL,0,NULL),(26,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Nkawa  ',0,'Carine','2',0,'1',NULL,0,NULL),(27,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Amontum ',0,'Rose','2',0,'1',NULL,0,NULL),(28,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Menguele ',0,'Edwige','2',0,'1',NULL,0,NULL),(29,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Nsoye ',0,'Evert','2',0,'0',NULL,0,NULL),(30,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Tchounang ',0,'Dorothe','2',0,'1',NULL,0,NULL),(31,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Bong pagbe',0,'null','2',0,'0',NULL,0,NULL),(32,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Atangana ',0,'Merlin Robert','4',0,'0',NULL,0,NULL),(33,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,'Noah ',0,'Gabriel','2',0,'0',NULL,0,NULL),(34,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Ndengue ',0,'Odette','2',0,'1',NULL,0,NULL),(35,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' OSSA ',0,'christine','4',0,'1',NULL,0,NULL),(36,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,' Emmanuel ',0,' Emmanuel ','2',0,'0',NULL,0,NULL);
/*!40000 ALTER TABLE `e_professeur` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_profmatens`
--

LOCK TABLES `e_profmatens` WRITE;
/*!40000 ALTER TABLE `e_profmatens` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_profmatens` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_reduction`
--

LOCK TABLES `e_reduction` WRITE;
/*!40000 ALTER TABLE `e_reduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_reduction` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_reg_prof`
--

LOCK TABLES `e_reg_prof` WRITE;
/*!40000 ALTER TABLE `e_reg_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_reg_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_resp`
--

DROP TABLE IF EXISTS `e_resp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_resp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DATENAIS` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NE` smallint(6) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `SEXE` varchar(255) DEFAULT NULL,
  `TEL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NOM` (`NOM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_resp`
--

LOCK TABLES `e_resp` WRITE;
/*!40000 ALTER TABLE `e_resp` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_resp` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_retenue_prof`
--

LOCK TABLES `e_retenue_prof` WRITE;
/*!40000 ALTER TABLE `e_retenue_prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_retenue_prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_s_filiere`
--

DROP TABLE IF EXISTS `e_s_filiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_s_filiere` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `MNT` bigint(20) DEFAULT NULL,
  `FILIERE_ID` bigint(20) DEFAULT NULL,
  `SERVICE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK59D4A8B21D405596` (`FILIERE_ID`),
  KEY `FK59D4A8B22198C76` (`SERVICE_ID`),
  CONSTRAINT `FK59D4A8B21D405596` FOREIGN KEY (`FILIERE_ID`) REFERENCES `e_filiere` (`id`),
  CONSTRAINT `FK59D4A8B22198C76` FOREIGN KEY (`SERVICE_ID`) REFERENCES `e_service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_s_filiere`
--

LOCK TABLES `e_s_filiere` WRITE;
/*!40000 ALTER TABLE `e_s_filiere` DISABLE KEYS */;
INSERT INTO `e_s_filiere` VALUES (1,0,0,0,1,0,0,0,'SIL Classe Préparatoire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,8,1),(2,0,0,0,1,0,0,0,'CP Classe Préparatoire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,9,1),(3,0,0,0,1,0,0,0,'CE1 Cours Elémentaire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,10,1),(4,0,0,0,1,0,0,0,'CE2 Cours Elémentaire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,11,1),(5,0,0,0,1,0,0,0,'CM1 Cours Moyen-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,12,1),(6,0,0,0,1,0,0,0,'CM2 Cours Moyen-16500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,16500,13,1),(7,0,0,0,1,0,0,0,'PS Petite Section-25500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25500,14,1),(8,0,0,0,1,0,0,0,'MS Moyen Section-25500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25500,15,1),(9,0,0,0,1,0,0,0,'GS Grande Section-25500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25500,16,1),(10,0,0,0,1,0,0,0,'PN Pre nursery-25500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25500,17,1),(11,0,0,0,1,0,0,0,'N Nursey-25500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25500,18,1),(12,0,0,0,1,0,0,0,'CLASS1 Classe Préparatoire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,19,1),(13,0,0,0,1,0,0,0,'CLASS2 Classe Préparatoire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,20,1),(14,0,0,0,1,0,0,0,'CLASS3 Cours Elémentaire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,21,1),(15,0,0,0,1,0,0,0,'CLASS4 Cours Elémentaire-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,22,1),(16,0,0,0,1,0,0,0,'CLASS6 Cours Moyen-16500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,16500,23,1),(17,0,0,0,1,0,0,0,'CLASS5 Cours Moyen-11500','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,11500,24,1),(18,0,0,0,1,0,0,0,'5EME CINQUIEME-19999','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,19999,25,1),(19,0,0,0,1,0,0,0,'6EME SIXIEME-20000','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,26,1),(20,0,0,0,1,0,0,0,'FROMI FROMI-20000','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,27,1),(21,0,0,0,1,0,0,0,'4EME QAUTRIEME-20000','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,28,1),(22,0,0,0,1,0,0,0,'FROMIII FROMIII-20000','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,29,1),(23,0,0,0,1,0,0,0,'FROMII FROMII-20000','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,30,1),(24,0,0,-1531214800561,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,25500,31,1),(25,0,0,0,1,0,0,0,'SIL Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,8,4),(26,0,0,0,1,0,0,0,'CP Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,9,4),(27,0,0,0,1,0,0,0,'CE1 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,10,4),(28,0,0,0,1,0,0,0,'CE2 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,11,4),(29,0,0,0,1,0,0,0,'CM1 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,12,4),(30,0,0,0,1,0,0,0,'CM2 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,35000,13,4),(31,0,0,0,1,0,0,0,'PS Petite Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,14,4),(32,0,0,0,1,0,0,0,'MS Moyen Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,15,4),(33,0,0,0,1,0,0,0,'GS Grande Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,16,4),(34,0,0,0,1,0,0,0,'PN Pre nursery-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,17,4),(35,0,0,0,1,0,0,0,'N Nursey-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,18,4),(36,0,0,0,1,0,0,0,'CLASS1 Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,19,4),(37,0,0,0,1,0,0,0,'CLASS2 Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,20,4),(38,0,0,0,1,0,0,0,'CLASS3 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,21,4),(39,0,0,0,1,0,0,0,'CLASS4 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,30000,22,4),(40,0,0,0,1,0,0,0,'CLASS6 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,23,4),(41,0,0,0,1,0,0,0,'CLASS5 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,35000,24,4),(42,0,0,0,1,0,0,0,'5EME CINQUIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,45000,25,4),(43,0,0,0,1,0,0,0,'6EME SIXIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,45000,26,4),(44,0,0,0,1,0,0,0,'FROMI FROMI-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,45000,27,4),(45,0,0,0,1,0,0,0,'4EME QAUTRIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,45000,28,4),(46,0,0,0,1,0,0,0,'FROMIII FROMIII-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,45000,29,4),(47,0,0,0,1,0,0,0,'FROMII FROMII-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,45000,30,4),(48,0,0,0,1,0,0,0,'PM PreMaternelle-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,31,4),(49,0,0,0,1,0,0,0,'SIL Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,8,5),(50,0,0,0,1,0,0,0,'CP Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,9,5),(51,0,0,0,1,0,0,0,'CE1 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,10,5),(52,0,0,0,1,0,0,0,'CE2 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,11,5),(53,0,0,0,1,0,0,0,'CM1 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,12,5),(54,0,0,0,1,0,0,0,'CM2 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,13,5),(55,0,0,0,1,0,0,0,'PS Petite Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,14,5),(56,0,0,0,1,0,0,0,'MS Moyen Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,15,5),(57,0,0,0,1,0,0,0,'GS Grande Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,16,5),(58,0,0,0,1,0,0,0,'PN Pre nursery-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,17,5),(59,0,0,0,1,0,0,0,'N Nursey-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,18,5),(60,0,0,0,1,0,0,0,'CLASS1 Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,19,5),(61,0,0,0,1,0,0,0,'CLASS2 Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,20,5),(62,0,0,0,1,0,0,0,'CLASS3 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,21,5),(63,0,0,0,1,0,0,0,'CLASS4 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,22,5),(64,0,0,0,1,0,0,0,'CLASS6 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,23,5),(65,0,0,0,1,0,0,0,'CLASS5 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,24,5),(66,0,0,0,1,0,0,0,'5EME CINQUIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,25,5),(67,0,0,0,1,0,0,0,'6EME SIXIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,26,5),(68,0,0,0,1,0,0,0,'FROMI FROMI-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,27,5),(69,0,0,0,1,0,0,0,'4EME QAUTRIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,28,5),(70,0,0,0,1,0,0,0,'FROMIII FROMIII-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,29,5),(71,0,0,0,1,0,0,0,'FROMII FROMII-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,40000,30,5),(72,0,0,0,1,0,0,0,'PM PreMaternelle-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,25000,31,5),(73,0,0,0,1,0,0,0,'SIL Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,8,6),(74,0,0,0,1,0,0,0,'CP Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,9,6),(75,0,0,0,1,0,0,0,'CE1 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,10,6),(76,0,0,0,1,0,0,0,'CE2 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,11,6),(77,0,0,0,1,0,0,0,'CM1 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,12,6),(78,0,0,0,1,0,0,0,'CM2 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,13,6),(79,0,0,0,1,0,0,0,'PS Petite Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,14,6),(80,0,0,0,1,0,0,0,'MS Moyen Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,15,6),(81,0,0,0,1,0,0,0,'GS Grande Section-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,16,6),(82,0,0,0,1,0,0,0,'PN Pre nursery-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,17,6),(83,0,0,0,1,0,0,0,'N Nursey-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,18,6),(84,0,0,0,1,0,0,0,'CLASS1 Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,19,6),(85,0,0,0,1,0,0,0,'CLASS2 Classe Préparatoire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,20,6),(86,0,0,0,1,0,0,0,'CLASS3 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,21,6),(87,0,0,0,1,0,0,0,'CLASS4 Cours Elémentaire-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,22,6),(88,0,0,0,1,0,0,0,'CLASS6 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,23,6),(89,0,0,0,1,0,0,0,'CLASS5 Cours Moyen-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,20000,24,6),(90,0,0,0,1,0,0,0,'5EME CINQUIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,15000,25,6),(91,0,0,0,1,0,0,0,'6EME SIXIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,15000,26,6),(92,0,0,0,1,0,0,0,'FROMI FROMI-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,15000,27,6),(93,0,0,0,1,0,0,0,'4EME QAUTRIEME-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,15000,28,6),(94,0,0,0,1,0,0,0,'FROMIII FROMIII-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,15000,29,6),(95,0,0,0,1,0,0,0,'FROMII FROMII-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,15000,30,6),(96,0,0,0,1,0,0,0,'PM PreMaternelle-0','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,15000,31,6);
/*!40000 ALTER TABLE `e_s_filiere` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `DELAI` date DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `TYPE_SERVICE` varchar(255) DEFAULT NULL,
  `MNT` double DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_service`
--

LOCK TABLES `e_service` WRITE;
/*!40000 ALTER TABLE `e_service` DISABLE KEYS */;
INSERT INTO `e_service` VALUES (1,0,0,0,1,0,0,0,'INS','Gestion des Services Scolaire',NULL,'Gestion des Services Scolaire','kereneducation',0,NULL,'2018-09-12',NULL,'0',395499,'INS'),(4,0,0,1531217575794,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'2018-09-30',NULL,'1',790000,'TRANCHE I'),(5,0,0,1531218089678,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'2018-11-30',NULL,'2',625000,'TRANCHE 2'),(6,0,0,1531218325386,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'2019-01-30',NULL,'3',445000,'TRANCHE 3');
/*!40000 ALTER TABLE `e_service` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `e_service_e_filiere`
--

LOCK TABLES `e_service_e_filiere` WRITE;
/*!40000 ALTER TABLE `e_service_e_filiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_service_e_filiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_smsserver_out`
--

DROP TABLE IF EXISTS `e_smsserver_out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_smsserver_out` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `CHOIX_DEST_MSG` varchar(255) DEFAULT NULL,
  `dst_port` int(11) DEFAULT NULL,
  `encoding` varchar(255) DEFAULT NULL,
  `errors` int(11) DEFAULT NULL,
  `flash_sms` int(11) DEFAULT NULL,
  `gateway_id` varchar(255) DEFAULT NULL,
  `text` longtext,
  `recipient` varchar(255) DEFAULT NULL,
  `originator` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `ref_no` varchar(255) DEFAULT NULL,
  `sent_date` datetime DEFAULT NULL,
  `src_port` int(11) DEFAULT NULL,
  `status_report` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `wap_expiry_date` varchar(255) DEFAULT NULL,
  `wap_signal` varchar(255) DEFAULT NULL,
  `wap_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_smsserver_out`
--

LOCK TABLES `e_smsserver_out` WRITE;
/*!40000 ALTER TABLE `e_smsserver_out` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_smsserver_out` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_sstage`
--

LOCK TABLES `e_sstage` WRITE;
/*!40000 ALTER TABLE `e_sstage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_sstage` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `PROF_ID` bigint(20) DEFAULT NULL,
  `SERVI_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK877C86A4E7DB348B` (`SERVI_ID`),
  KEY `FK877C86A4B5E85162` (`BS_ID`),
  KEY `FK877C86A426A1B0B1` (`PROF_ID`),
  KEY `FK877C86A4D9978FE1` (`CLS_ID`),
  CONSTRAINT `FK877C86A426A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK877C86A4B5E85162` FOREIGN KEY (`BS_ID`) REFERENCES `e_bstage` (`id`),
  CONSTRAINT `FK877C86A4D9978FE1` FOREIGN KEY (`CLS_ID`) REFERENCES `e_classe` (`id`),
  CONSTRAINT `FK877C86A4E7DB348B` FOREIGN KEY (`SERVI_ID`) REFERENCES `e_dlieu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_stage`
--

LOCK TABLES `e_stage` WRITE;
/*!40000 ALTER TABLE `e_stage` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_stage_e_eleve`
--

DROP TABLE IF EXISTS `e_stage_e_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_stage_e_eleve` (
  `e_stage_id` bigint(20) NOT NULL,
  `elevelist_id` bigint(20) NOT NULL,
  KEY `FK2CB0F4D89FA5C62E` (`elevelist_id`),
  KEY `FK2CB0F4D88A897D36` (`e_stage_id`),
  CONSTRAINT `FK2CB0F4D88A897D36` FOREIGN KEY (`e_stage_id`) REFERENCES `e_stage` (`id`),
  CONSTRAINT `FK2CB0F4D89FA5C62E` FOREIGN KEY (`elevelist_id`) REFERENCES `e_eleve` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_stage_e_eleve`
--

LOCK TABLES `e_stage_e_eleve` WRITE;
/*!40000 ALTER TABLE `e_stage_e_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_stage_e_eleve` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_status`
--

LOCK TABLES `e_status` WRITE;
/*!40000 ALTER TABLE `e_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_suvi_eleve`
--

DROP TABLE IF EXISTS `e_suvi_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_suvi_eleve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
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
  `PROF_ID` bigint(20) DEFAULT NULL,
  `SERVI_ID` bigint(20) DEFAULT NULL,
  `ETU_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK65067BDE7DB348B` (`SERVI_ID`),
  KEY `FK65067BDD150EA5` (`ETU_ID`),
  KEY `FK65067BD26A1B0B1` (`PROF_ID`),
  KEY `FK65067BD6DF650C` (`ELEVE_ID`),
  CONSTRAINT `FK65067BD26A1B0B1` FOREIGN KEY (`PROF_ID`) REFERENCES `e_professeur` (`id`),
  CONSTRAINT `FK65067BD6DF650C` FOREIGN KEY (`ELEVE_ID`) REFERENCES `e_eleve` (`id`),
  CONSTRAINT `FK65067BDD150EA5` FOREIGN KEY (`ETU_ID`) REFERENCES `e_sstage` (`id`),
  CONSTRAINT `FK65067BDE7DB348B` FOREIGN KEY (`SERVI_ID`) REFERENCES `e_dlieu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_suvi_eleve`
--

LOCK TABLES `e_suvi_eleve` WRITE;
/*!40000 ALTER TABLE `e_suvi_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_suvi_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_t_dps`
--

DROP TABLE IF EXISTS `e_t_dps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_t_dps` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_t_dps`
--

LOCK TABLES `e_t_dps` WRITE;
/*!40000 ALTER TABLE `e_t_dps` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_t_dps` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_tabscence`
--

LOCK TABLES `e_tabscence` WRITE;
/*!40000 ALTER TABLE `e_tabscence` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_tabscence` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  CONSTRAINT `FK1D1605388924A7C3` FOREIGN KEY (`TACHE_ID`) REFERENCES `e_suvi_eleve` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_tachestge`
--

LOCK TABLES `e_tachestge` WRITE;
/*!40000 ALTER TABLE `e_tachestge` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_tachestge` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `MAT_ID` bigint(20) DEFAULT NULL,
  `TRANCHE_COURS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9DB2EE991F8CF14` (`MAT_ID`),
  KEY `FK9DB2EE99D406B38D` (`TRANCHE_COURS_ID`),
  CONSTRAINT `FK9DB2EE991F8CF14` FOREIGN KEY (`MAT_ID`) REFERENCES `e_coefmatdtl` (`id`),
  CONSTRAINT `FK9DB2EE99D406B38D` FOREIGN KEY (`TRANCHE_COURS_ID`) REFERENCES `e_jcours` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_th_cours`
--

LOCK TABLES `e_th_cours` WRITE;
/*!40000 ALTER TABLE `e_th_cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_th_cours` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_unite_ens`
--

LOCK TABLES `e_unite_ens` WRITE;
/*!40000 ALTER TABLE `e_unite_ens` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_unite_ens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_v_anniv`
--

DROP TABLE IF EXISTS `e_v_anniv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_v_anniv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_v_anniv`
--

LOCK TABLES `e_v_anniv` WRITE;
/*!40000 ALTER TABLE `e_v_anniv` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_v_anniv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_v_list_elev`
--

DROP TABLE IF EXISTS `e_v_list_elev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_v_list_elev` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_v_list_elev`
--

LOCK TABLES `e_v_list_elev` WRITE;
/*!40000 ALTER TABLE `e_v_list_elev` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_v_list_elev` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_v_rpaie`
--

DROP TABLE IF EXISTS `e_v_rpaie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_v_rpaie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_v_rpaie`
--

LOCK TABLES `e_v_rpaie` WRITE;
/*!40000 ALTER TABLE `e_v_rpaie` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_v_rpaie` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
-- Dumping data for table `e_visite`
--

LOCK TABLES `e_visite` WRITE;
/*!40000 ALTER TABLE `e_visite` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_visite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `e_zview_bf`
--

DROP TABLE IF EXISTS `e_zview_bf`;
/*!50001 DROP VIEW IF EXISTS `e_zview_bf`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `e_zview_bf` (
  `ID` bigint(20),
  `CLASSE_ID` bigint(20),
  `ELEVE_ID` bigint(20),
  `INSCRIPTION_ENC` decimal(38,0),
  `I_TRAN_ENC` decimal(38,0),
  `II_TRAN_ENC` decimal(38,0),
  `III_TRAN_ENC` decimal(38,0),
  `REMISE` decimal(38,0),
  `RISTOURNE` decimal(38,0),
  `TOTAL_A` decimal(38,0),
  `TOTAL_R` decimal(38,0),
  `SOLDE` decimal(38,0),
  `CYCLE_ID` bigint(20),
  `EFF` decimal(38,0),
  `EFF_SOL` decimal(38,0),
  `ANNEE_ID` varchar(255),
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
  `SERIAL` varchar(7),
  `DESABLEUPDATE` int(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `e_zview_bf_ecole`
--

DROP TABLE IF EXISTS `e_zview_bf_ecole`;
/*!50001 DROP VIEW IF EXISTS `e_zview_bf_ecole`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `e_zview_bf_ecole` (
  `ID` bigint(20),
  `CLASSE_ID` bigint(20),
  `INSCRIPTION` decimal(38,0),
  `INSCRIPTION_ENC` decimal(38,0),
  `I_TRAN` decimal(38,0),
  `I_TRAN_ENC` decimal(38,0),
  `II_TRAN` decimal(38,0),
  `II_TRAN_ENC` decimal(38,0),
  `III_TRAN` decimal(38,0),
  `III_TRAN_ENC` decimal(38,0),
  `REMISE` decimal(38,0),
  `RISTOURNE` decimal(38,0),
  `TOTAL_A` decimal(38,0),
  `TOTAL_R` decimal(38,0),
  `SOLDE` decimal(38,0),
  `TX_RECO` decimal(44,2),
  `CYCLE_ID` bigint(20),
  `EFF` decimal(38,0),
  `EFF_SOL` decimal(38,0),
  `ANNEE_ID` varchar(255),
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
  `SERIAL` varchar(7),
  `DESABLEUPDATE` int(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  CONSTRAINT `FK556474FFCD3DF236` FOREIGN KEY (`MATIERE_ID`) REFERENCES `e_mat` (`id`),
  CONSTRAINT `FK556474FFEB699C0E` FOREIGN KEY (`MODULE_ID`) REFERENCES `e_module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_zview_bul`
--

LOCK TABLES `e_zview_bul` WRITE;
/*!40000 ALTER TABLE `e_zview_bul` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_zview_bul` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `e_zview_bulletin`
--

DROP TABLE IF EXISTS `e_zview_bulletin`;
/*!50001 DROP VIEW IF EXISTS `e_zview_bulletin`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `e_zview_bulletin` (
  `ID` bigint(23),
  `INS_ID` bigint(20),
  `ELEVE_ID` bigint(20),
  `CLASSE_ID` bigint(20),
  `CYCLE_ID` bigint(20),
  `ANNEE_ID` varchar(255),
  `COEF_ID` bigint(20),
  `MAT_ID` bigint(20),
  `EXAMEN_ID` bigint(20),
  `NOTE1` decimal(38,2),
  `NOTE2` decimal(38,2),
  `NOTE3` decimal(38,2),
  `NOTE4` decimal(38,2),
  `NOTE5` decimal(38,2),
  `NOTE6` decimal(38,2),
  `MOY_CLA_MATIERE` decimal(38,2),
  `EXTR_MAX_MAT` decimal(38,2),
  `EXTR_MIN_MAT` decimal(38,2),
  `MOY1` decimal(38,2),
  `MOY2` decimal(38,2),
  `MOY3` decimal(38,2),
  `MOY4` decimal(38,2),
  `MOY5` decimal(38,2),
  `MOY6` decimal(38,2),
  `RANG_MAT` decimal(38,2),
  `RANG_MOY` decimal(38,2),
  `MOY_GEN_CLS` decimal(38,2),
  `MOY_PREMIER` decimal(38,2),
  `MOY_DERNIER` decimal(38,2),
  `NBRE_MOY` decimal(38,2),
  `NBRE_ELVE` decimal(38,2),
  `TX_REU` decimal(47,6),
  `TOTAL_POINT` decimal(38,2),
  `TOTAL_COEF` decimal(38,2),
  `RANG1` int(1),
  `RANG2` int(1),
  `RANG3` int(1),
  `RANG4` int(1),
  `RANG5` int(1),
  `RANG6` int(1),
  `ECART_TYPE` decimal(38,2),
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
  `SERIAL` varchar(7),
  `DESABLEUPDATE` int(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `e_zview_dashboard`
--

DROP TABLE IF EXISTS `e_zview_dashboard`;
/*!50001 DROP VIEW IF EXISTS `e_zview_dashboard`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `e_zview_dashboard` (
  `ID` bigint(20),
  `N_ELEVE` decimal(38,0),
  `N_ELEVE_INS` decimal(38,0),
  `N_ELEVE_T1` decimal(38,0),
  `N_ELEVE_T2` decimal(38,0),
  `N_ELEVE_T3` decimal(38,0),
  `N_ELEVE_S` decimal(38,0),
  `PRE_G` decimal(38,0),
  `ENC_G` decimal(38,0),
  `SOLD_G` decimal(38,0),
  `PRE_I` decimal(38,0),
  `ENC_I` decimal(38,0),
  `SOLD_I` decimal(38,0),
  `PRE_T1` decimal(38,0),
  `ENC_T1` decimal(38,0),
  `SOLD_T1` decimal(38,0),
  `PRE_T2` decimal(38,0),
  `ENC_T2` decimal(38,0),
  `SOLD_T2` decimal(38,0),
  `PRE_T3` decimal(38,0),
  `ENC_T3` decimal(38,0),
  `SOLD_T3` decimal(38,0),
  `ANNEE_ID` varchar(255),
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
  `SERIAL` varchar(7),
  `DESABLEUPDATE` int(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `e_zview_helper`
--

DROP TABLE IF EXISTS `e_zview_helper`;
/*!50001 DROP VIEW IF EXISTS `e_zview_helper`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `e_zview_helper` (
  `ID` bigint(22),
  `EXAMEN_ID` bigint(20),
  `ETUDIANT_ID` bigint(20),
  `CLASSE_ID` bigint(20),
  `MOY` decimal(64,4),
  `ANNEE_ID` varchar(255),
  `TYPE_EXAMEN` varchar(255)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `e_zview_note_helper`
--

DROP TABLE IF EXISTS `e_zview_note_helper`;
/*!50001 DROP VIEW IF EXISTS `e_zview_note_helper`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `e_zview_note_helper` (
  `ID` bigint(21),
  `MAT_NOTE_ID` bigint(20),
  `CLASSE_ID` bigint(20),
  `EXAMEN_ID` bigint(20),
  `MATIERE_ID` bigint(20),
  `NOTE_ID` bigint(20),
  `ELEVE_ID` bigint(20),
  `NOTE` bigint(20),
  `APPRECIATION` varchar(255),
  `MOY_CLA_MATIERE` decimal(38,2),
  `EXTR_MAX` decimal(38,2),
  `EXTR_MIN` decimal(38,2),
  `TOTAL_POINT` decimal(38,2),
  `TOTAL_COEF` decimal(38,2),
  `MOY_ETUDIANT` decimal(38,2),
  `MOY_PREMIER` decimal(38,2),
  `MOY_DERNIER` decimal(38,2),
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
  `SERIAL` varchar(7),
  `DESABLEUPDATE` int(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `e_zview_paiement`
--

DROP TABLE IF EXISTS `e_zview_paiement`;
/*!50001 DROP VIEW IF EXISTS `e_zview_paiement`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `e_zview_paiement` (
  `ID` bigint(20),
  `TOTAL_TTC` bigint(20),
  `MNT_PAYER` bigint(20),
  `DATE_PAI` date,
  `SER_ID` bigint(20),
  `ELEVE_ID` bigint(20),
  `CLASSE_ID` bigint(20),
  `CYCLE_ID` bigint(20),
  `TYP_PAI` varchar(255),
  `ANNEE_ID` varchar(255),
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
  `SERIAL` varchar(7),
  `DESABLEUPDATE` int(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
-- Dumping data for table `email_copies`
--

LOCK TABLES `email_copies` WRITE;
/*!40000 ALTER TABLE `email_copies` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_copies` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `email_piecesjointes`
--

LOCK TABLES `email_piecesjointes` WRITE;
/*!40000 ALTER TABLE `email_piecesjointes` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_piecesjointes` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `k_email`
--

LOCK TABLES `k_email` WRITE;
/*!40000 ALTER TABLE `k_email` DISABLE KEYS */;
/*!40000 ALTER TABLE `k_email` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK2650106588E89945` (`LANG_ID`),
  CONSTRAINT `FK2650106588E89945` FOREIGN KEY (`LANG_ID`) REFERENCES `t_langue` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `k_terme`
--

LOCK TABLES `k_terme` WRITE;
/*!40000 ALTER TABLE `k_terme` DISABLE KEYS */;
/*!40000 ALTER TABLE `k_terme` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `report` varchar(255) DEFAULT NULL,
  `securitylevel` smallint(6) NOT NULL,
  `viewMode` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `requete` varchar(255) DEFAULT NULL,
  `AC_ID` bigint(20) DEFAULT NULL,
  `MOD_ID` bigint(20) DEFAULT NULL,
  `ACT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK52ECEE6876B222F1` (`AC_ID`),
  KEY `FK52ECEE68C35C6179` (`ACT_ID`),
  KEY `FK52ECEE68ED94853F` (`MOD_ID`),
  CONSTRAINT `FK52ECEE6876B222F1` FOREIGN KEY (`AC_ID`) REFERENCES `m_agroup` (`id`),
  CONSTRAINT `FK52ECEE68C35C6179` FOREIGN KEY (`ACT_ID`) REFERENCES `m_action` (`id`),
  CONSTRAINT `FK52ECEE68ED94853F` FOREIGN KEY (`MOD_ID`) REFERENCES `m_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_action`
--

LOCK TABLES `m_action` WRITE;
/*!40000 ALTER TABLE `m_action` DISABLE KEYS */;
INSERT INTO `m_action` VALUES ('MENU_ACT',47,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'AnneScolaireModal',1,'icon icon-calendar',' Selectionner l\'année Scolaire','keren_education_dashboard_01',NULL,1,'kereneducation','keren_education_selectexo','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',48,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'EducationDashboard',0,'glyphicon glyphicon-th','Dashboard ','','solde',0,'kereneducation','keren_education_dashboard_01','',0,'dashboard',NULL,NULL,9,NULL,NULL),('MENU_ACT',49,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Etablissement',0,'icon-home',' Ecole','',NULL,0,'kereneducation','keren_education_Etb','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',50,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Eleve',0,'glyphicon glyphicon-user blue',' Fichier des Elèves','',NULL,0,'kereneducation','keren_education_02','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',51,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Inscription',0,'icon icon-book',' Pré-Inscription','',NULL,0,'kereneducation','keren_education_ins','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',52,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'selectClasse',0,'glyphicon glyphicon-th','Inscription/Scolarité','keren_education_paie',NULL,1,'kereneducation','keren_education_paie_link','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',53,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Paiement',1,'glyphicon glyphicon-th','Inscription/Scolarité','',NULL,0,'kereneducation','keren_education_paie','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',54,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Echeancier',1,'glyphicon glyphicon-th',' Gestion des Echéances de paiement  ','',NULL,0,'kereneducation','keren_education_paie_ech','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',55,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Paiement',1,'glyphicon glyphicon-th',' Paiements','',NULL,0,'kereneducation','keren_education_paie_limit','',0,'tree,form',NULL,NULL,9,NULL,NULL),('MENU_ACT',56,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'TypeDepense',0,'icon icon-shopping-cart','Type de Dépenses','',NULL,0,'kereneducation','keren_education_typedps','',0,'tree,form',NULL,NULL,10,NULL,NULL),('MENU_ACT',57,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Caisse',0,'icon icon-shopping-cart','Recettes','',NULL,0,'kereneducation','keren_education_cai','',0,'tree,form',NULL,NULL,10,NULL,NULL),('MENU_ACT',58,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Depense',0,'icon icon-shopping-cart','Dépenses','',NULL,0,'kereneducation','keren_education_depense','',0,'tree,form',NULL,NULL,10,NULL,NULL),('MENU_ACT',59,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewAnniversaire',0,'icon icon-calendar','Etat des Anniversaires','',NULL,0,'kereneducation','keren_education_Report_01','',0,'tree,form',NULL,NULL,11,NULL,NULL),('MENU_ACT',60,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewListeEleve',0,'glyphicon glyphicon-th','Liste des Elèves','',NULL,0,'kereneducation','keren_education_Report_02','',0,'tree,form',NULL,NULL,11,NULL,NULL),('MENU_ACT',61,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewDltPaiement',0,'glyphicon glyphicon-th',' Détails des Paiements','',NULL,0,'kereneducation','keren_education_Report_041','',0,'tree,form',NULL,NULL,11,NULL,NULL),('MENU_ACT',62,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewRetardPaiement',0,'glyphicon glyphicon-th',' Retard de Paiements','',NULL,0,'kereneducation','keren_education_Report_04','',0,'tree,form',NULL,NULL,11,NULL,NULL),('MENU_ACT',63,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewBilanFinancier',0,'glyphicon glyphicon-th','Bilan Financiers des éléves/Classe','',NULL,0,'kereneducation','keren_education_Report_03','',0,'tree,form',NULL,NULL,11,NULL,NULL),('MENU_ACT',64,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'ViewBilanFinancierEcole',0,'glyphicon glyphicon-th','Bilan Financiers Global','',NULL,0,'kereneducation','keren_education_Report_05','',0,'tree,form',NULL,NULL,11,NULL,NULL),('MENU_ACT',65,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'AnneScolaire',0,'icon icon-calendar',' Annee Scolaire, et Période','',NULL,0,'kereneducation','keren_education_Anne','',0,'tree,form',NULL,NULL,12,NULL,NULL),('MENU_ACT',66,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Classe',0,'glyphicon glyphicon-th','Classe','',NULL,0,'kereneducation','keren_education_cla','',0,'tree,form',NULL,NULL,12,NULL,NULL),('MENU_ACT',67,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Filiere',0,'glyphicon glyphicon-th','Filiere','',NULL,0,'kereneducation','keren_education_Fil','',0,'tree,form',NULL,NULL,12,NULL,NULL),('MENU_ACT',68,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Professeur',0,'icon icon-group',' Enseignants/Personnels','',NULL,0,'kereneducation','keren_education_ens','',0,'tree,form',NULL,NULL,12,NULL,NULL),('MENU_ACT',69,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'Service',0,'icon icon-wrench','Services Financiers','',NULL,0,'kereneducation','keren_education_ser','',0,'tree,form',NULL,NULL,12,NULL,NULL);
/*!40000 ALTER TABLE `m_action` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK53247AF032D05D9B` (`AG_ID`),
  CONSTRAINT `FK53247AF032D05D9B` FOREIGN KEY (`AG_ID`) REFERENCES `m_module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_agroup`
--

LOCK TABLES `m_agroup` WRITE;
/*!40000 ALTER TABLE `m_agroup` DISABLE KEYS */;
INSERT INTO `m_agroup` VALUES (9,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'icon-home',' Ecole','keren_education_ecole',0,1,7),(10,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'icon icon-tasks',' Economat','keren_education_caisse',0,1,7),(11,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'icon icon-cogs',' Rapport','keren_education_Report',0,1,7),(12,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'icon icon-cogs',' Paramètres','keren_education_para',0,1,7);
/*!40000 ALTER TABLE `m_agroup` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_module`
--

LOCK TABLES `m_module` WRITE;
/*!40000 ALTER TABLE `m_module` DISABLE KEYS */;
INSERT INTO `m_module` VALUES (1,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'BKD','Accounting',NULL,1,NULL,1,'Comptabilite','',NULL,'base_account',10,'Mise en place du referentiel comptable','1.0','http://www.keren.com',NULL),(2,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'BKD','Courrier',NULL,1,NULL,1,'Gestion du Courrier','',NULL,'courrier',10,'Gestion du Courrier','1.0','http://www.keren.com',NULL),(3,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'NTW','education',NULL,1,NULL,1,'Suivi Pedagogique','',NULL,'kereneducation',9,'Plateforme de gestion scoalaire','1.0','http://www.keren.com',NULL),(4,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'NTW','paiement',NULL,1,NULL,1,'Gestion Financieres','',NULL,'paiement',10,'Plateforme de gestion scoalaire','1.0','http://www.keren.com',NULL),(5,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'BKD','Accounting',NULL,1,NULL,1,'Administration du personels','',NULL,'rhadmin',10,'Mise en place du referentiel des resources humaines','1.0','http://www.keren.com',NULL),(6,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'BKD','Accounting',NULL,1,NULL,1,'Gestion de la paie','',NULL,'rhpaie',10,'Calcul de la paie','1.0','http://www.keren.com',NULL),(7,0,0,0,1,1,0,0,'Scolarite','APPLICATION',NULL,'APPLICATIONS','kerencore',0,NULL,1,1,1,'NTW','Scolarite',NULL,1,NULL,1,'Scolarite','',NULL,'scolarite',7,'Plateforme de gestion scoalaire','1.0','http://www.keren.com',NULL),(8,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,0,1,1,'NTW','stage',NULL,1,NULL,1,'Gestion des Stages','',NULL,'stage',10,'Plateforme de gestion scoalaire','1.0','http://www.keren.com',NULL);
/*!40000 ALTER TABLE `m_module` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_canal`
--

LOCK TABLES `t_canal` WRITE;
/*!40000 ALTER TABLE `t_canal` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_canal` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `taux` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_devise`
--

LOCK TABLES `t_devise` WRITE;
/*!40000 ALTER TABLE `t_devise` DISABLE KEYS */;
INSERT INTO `t_devise` VALUES (1,0,0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CFA',1);
/*!40000 ALTER TABLE `t_devise` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK19C4ECFEF3A1AAE` (`OWN_ID`),
  KEY `FK19C4ECF7E847E1D` (`RAP_ID`),
  CONSTRAINT `FK19C4ECF7E847E1D` FOREIGN KEY (`RAP_ID`) REFERENCES `t_rappel` (`id`),
  CONSTRAINT `FK19C4ECFEF3A1AAE` FOREIGN KEY (`OWN_ID`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_event`
--

LOCK TABLES `t_event` WRITE;
/*!40000 ALTER TABLE `t_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_export`
--

DROP TABLE IF EXISTS `t_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_export` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activatefollower` tinyint(1) NOT NULL,
  `activefilelien` tinyint(1) NOT NULL,
  `compareid` bigint(20) NOT NULL,
  `createonfield` tinyint(1) NOT NULL,
  `desablecreate` tinyint(1) NOT NULL,
  `desabledelete` tinyint(1) NOT NULL,
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cycle` smallint(6) DEFAULT NULL,
  `execDay` date DEFAULT NULL,
  `heure` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_export`
--

LOCK TABLES `t_export` WRITE;
/*!40000 ALTER TABLE `t_export` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_export` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `t_fol_aban`
--

LOCK TABLES `t_fol_aban` WRITE;
/*!40000 ALTER TABLE `t_fol_aban` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fol_aban` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `t_fol_can`
--

LOCK TABLES `t_fol_can` WRITE;
/*!40000 ALTER TABLE `t_fol_can` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fol_can` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK3514DE1C2CFAFD9F` (`SENDER_ID`),
  CONSTRAINT `FK3514DE1C2CFAFD9F` FOREIGN KEY (`SENDER_ID`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_follow`
--

LOCK TABLES `t_follow` WRITE;
/*!40000 ALTER TABLE `t_follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_follow` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK1B58B76B20C9F8A` (`GROUP_ID`),
  KEY `FK1B58B76C35C6179` (`ACT_ID`),
  CONSTRAINT `FK1B58B76B20C9F8A` FOREIGN KEY (`GROUP_ID`) REFERENCES `t_groupe` (`id`),
  CONSTRAINT `FK1B58B76C35C6179` FOREIGN KEY (`ACT_ID`) REFERENCES `m_action` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_goupd`
--

LOCK TABLES `t_goupd` WRITE;
/*!40000 ALTER TABLE `t_goupd` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_goupd` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `M_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK352384112D7C2FF4` (`M_ID`),
  CONSTRAINT `FK352384112D7C2FF4` FOREIGN KEY (`M_ID`) REFERENCES `m_module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_groupe`
--

LOCK TABLES `t_groupe` WRITE;
/*!40000 ALTER TABLE `t_groupe` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_groupe` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK1ECF824BBDA8BE0` (`CAN_ID`),
  KEY `FK1ECF824A112E36C` (`SEND_ID`),
  KEY `FK1ECF8246B93EB7B` (`RECI_ID`),
  KEY `FK1ECF82444549E75` (`SMES_ID`),
  CONSTRAINT `FK1ECF82444549E75` FOREIGN KEY (`SMES_ID`) REFERENCES `t_follow` (`id`),
  CONSTRAINT `FK1ECF8246B93EB7B` FOREIGN KEY (`RECI_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK1ECF824A112E36C` FOREIGN KEY (`SEND_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK1ECF824BBDA8BE0` FOREIGN KEY (`CAN_ID`) REFERENCES `t_canal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_kmsge`
--

LOCK TABLES `t_kmsge` WRITE;
/*!40000 ALTER TABLE `t_kmsge` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_kmsge` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_langue`
--

LOCK TABLES `t_langue` WRITE;
/*!40000 ALTER TABLE `t_langue` DISABLE KEYS */;
INSERT INTO `t_langue` VALUES (1,0,0,1,0,0,0,0,'LANGUE',NULL,NULL,NULL,'kerencore',NULL,NULL,1,'FR','fr_FR','1','dd/MM/yyyy','.','hh:MM:ss','.','Francais');
/*!40000 ALTER TABLE `t_langue` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK94B729D6AA509E78` (`DEVISE_ID`),
  CONSTRAINT `FK94B729D6AA509E78` FOREIGN KEY (`DEVISE_ID`) REFERENCES `t_devise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pays`
--

LOCK TABLES `t_pays` WRITE;
/*!40000 ALTER TABLE `t_pays` DISABLE KEYS */;
INSERT INTO `t_pays` VALUES (1,0,0,1,0,0,0,0,'REPUBLIQUE DU CAMEROUN','PAYS',NULL,'PAYS','kerencore',NULL,NULL,'CMR','1515504545337.png','REPUBLIQUE DU CAMEROUN',1);
/*!40000 ALTER TABLE `t_pays` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK279DC571A41AAC` (`KMSGE_ID`),
  CONSTRAINT `FK279DC571A41AAC` FOREIGN KEY (`KMSGE_ID`) REFERENCES `t_kmsge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pj`
--

LOCK TABLES `t_pj` WRITE;
/*!40000 ALTER TABLE `t_pj` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pj` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_rappel`
--

LOCK TABLES `t_rappel` WRITE;
/*!40000 ALTER TABLE `t_rappel` DISABLE KEYS */;
INSERT INTO `t_rappel` VALUES (1,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,5,'rappel 001',0);
/*!40000 ALTER TABLE `t_rappel` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK472DD13F36471BD8` (`PAYS_ID`),
  CONSTRAINT `FK472DD13F36471BD8` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_region`
--

LOCK TABLES `t_region` WRITE;
/*!40000 ALTER TABLE `t_region` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_region` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `t_smes_can`
--

LOCK TABLES `t_smes_can` WRITE;
/*!40000 ALTER TABLE `t_smes_can` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_smes_can` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `t_smes_user`
--

LOCK TABLES `t_smes_user` WRITE;
/*!40000 ALTER TABLE `t_smes_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_smes_user` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  `ADR` varchar(255) DEFAULT NULL,
  `ANNIV_TUTEUR` tinyint(1) DEFAULT NULL,
  `ANNIV_ELEVE` tinyint(1) DEFAULT NULL,
  `DELAI_PAIEMENT` tinyint(1) DEFAULT NULL,
  `CONTACT` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `LOGO` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `SITE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE44A85895E0D927` (`SOCP_ID`),
  KEY `FKE44A858958597449` (`DEV_ID`),
  KEY `FKE44A858936471BD8` (`PAYS_ID`),
  CONSTRAINT `FKE44A858936471BD8` FOREIGN KEY (`PAYS_ID`) REFERENCES `t_pays` (`id`),
  CONSTRAINT `FKE44A858958597449` FOREIGN KEY (`DEV_ID`) REFERENCES `t_devise` (`id`),
  CONSTRAINT `FKE44A85895E0D927` FOREIGN KEY (`SOCP_ID`) REFERENCES `t_societe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_societe`
--

LOCK TABLES `t_societe` WRITE;
/*!40000 ALTER TABLE `t_societe` DISABLE KEYS */;
INSERT INTO `t_societe` VALUES (1,0,0,0,1,0,0,0,'Groupe Scolaire Bilingue les sauterelles','Etablissement Scolaire',NULL,'Etablissement Scolaire','kereneducation',0,NULL,NULL,'GSBS',NULL,NULL,NULL,NULL,'mgt',NULL,NULL,NULL,NULL,NULL,1,1,NULL,'306085',0,1,0,'674160446','ecolebilingue@yahoo.fr','1530004411990.png','Groupe Scolaire Bilingue les sauterelles',NULL);
/*!40000 ALTER TABLE `t_societe` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK94B9B0D685E5DD40` (`SC_ID`),
  KEY `FK94B9B0D688E89945` (`LANG_ID`),
  KEY `FK94B9B0D631280CFC` (`SC_ID`),
  CONSTRAINT `FK94B9B0D631280CFC` FOREIGN KEY (`SC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B9B0D685E5DD40` FOREIGN KEY (`SC_ID`) REFERENCES `t_societe` (`id`),
  CONSTRAINT `FK94B9B0D688E89945` FOREIGN KEY (`LANG_ID`) REFERENCES `t_langue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,0,0,1,1,0,0,0,'Administrateur',NULL,NULL,NULL,'kerencore',0,NULL,0,'3','wntchuente@gmail.com','1515513689293.png','Administrateur','2018-07-10 11:53:45','admin','YjVF4NQ3bMVItVfDKgF16w==','etabli',1,1);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `FK8D3C15D182F5E840` (`EVENT_ID`),
  KEY `FK8D3C15D14AFF9C08` (`USER_ID`),
  CONSTRAINT `FK8D3C15D1224ABC49` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK8D3C15D14AFF9C08` FOREIGN KEY (`USER_ID`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK8D3C15D182F5E840` FOREIGN KEY (`EVENT_ID`) REFERENCES `t_event` (`id`),
  CONSTRAINT `FK8D3C15D1BAF1D6EC` FOREIGN KEY (`EVENT_ID`) REFERENCES `t_event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_event`
--

LOCK TABLES `t_user_event` WRITE;
/*!40000 ALTER TABLE `t_user_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_event` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `t_user_rigth`
--

LOCK TABLES `t_user_rigth` WRITE;
/*!40000 ALTER TABLE `t_user_rigth` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_rigth` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `t_user_sct`
--

LOCK TABLES `t_user_sct` WRITE;
/*!40000 ALTER TABLE `t_user_sct` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_sct` ENABLE KEYS */;
UNLOCK TABLES;

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
  `desableupdate` tinyint(1) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `editTitle` varchar(255) DEFAULT NULL,
  `footerScript` varchar(255) DEFAULT NULL,
  `listTitle` varchar(255) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `selected` tinyint(1) DEFAULT NULL,
  `serial` varchar(255) DEFAULT NULL,
  `actif` tinyint(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `ignor` tinyint(1) DEFAULT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK94B9FFB02958D88B` (`R_ITEM_ID`),
  KEY `FK94B9FFB03623A47F` (`F_ITEM_ID`),
  KEY `FK94B9FFB051E1B68D` (`T_ITEM_ID`),
  CONSTRAINT `FK94B9FFB02958D88B` FOREIGN KEY (`R_ITEM_ID`) REFERENCES `m_action` (`id`),
  CONSTRAINT `FK94B9FFB03623A47F` FOREIGN KEY (`F_ITEM_ID`) REFERENCES `m_action` (`id`),
  CONSTRAINT `FK94B9FFB051E1B68D` FOREIGN KEY (`T_ITEM_ID`) REFERENCES `m_action` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_view`
--

LOCK TABLES `t_view` WRITE;
/*!40000 ALTER TABLE `t_view` DISABLE KEYS */;
INSERT INTO `t_view` VALUES ('Dashboard',15,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'dashboardeduc_001',0,NULL,'<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<dashboardRecord method_ref=\"dashboard\" model_ref=\"kereneducation\" entity_ref=\"EducationDashboard\" action_ref=\"keren_education_dashboard_01\" label=\"Tableau de Bord\" id=\"dashboardeduc_001\">\n    <dashboard parent_ref=\"dashboardeduc_001\" label=\"Effectifs\" id=\"dashboardeduc001\">\n        <dashboardentry parent_ref=\"dashboardeduc001\" label=\"Données\" type=\"bar,data\" id=\"dashentryeduc001\">\n            <field name=\"nbreEtud\"/>\n            <field method_ref=\"inscrit\" model_ref=\"kereneducation\" entity_ref=\"Inscription\" name=\"totalIns\"/>\n            <field name=\"totalt1\"/>\n            <field name=\"totalt2\"/>\n            <field name=\"totalt3\"/>\n            <field name=\"solvable\"/>\n        </dashboardentry>\n    </dashboard>\n    <dashboard parent_ref=\"dashboardeduc_002\" label=\"Bilan Financier Global\" id=\"dashboardeduc002\">\n        <dashboardentry parent_ref=\"dashboardeduc002\" label=\"Données\" type=\"pie,data\" id=\"dashentryeduc002\">\n            <field name=\"previsionG\"/>\n            <field name=\"encaisseG\"/>\n            <field name=\"soldeG\"/>\n        </dashboardentry>\n    </dashboard>\n    <dashboard parent_ref=\"dashboardeduc_003\" label=\"Etat Encaissement des Inscriptions\" id=\"dashboardeduc003\">\n        <dashboardentry parent_ref=\"dashboardeduc003\" label=\"Données\" type=\"bar,data\" id=\"dashentryeduc003\">\n            <field name=\"previsionI\"/>\n            <field name=\"encaisseI\"/>\n            <field name=\"soldeI\"/>\n        </dashboardentry>\n    </dashboard>\n    <dashboard parent_ref=\"dashboardeduc_004\" label=\"Etat Encaissement Première Tranche\" id=\"dashboardeduc004\">\n        <dashboardentry parent_ref=\"dashboardeduc004\" label=\"Données\" type=\"bar,data\" id=\"dashentryeduc004\">\n            <field name=\"previsionT1\"/>\n            <field name=\"encaisseT1\"/>\n            <field name=\"soldeT1\"/>\n        </dashboardentry>\n    </dashboard>\n    <dashboard parent_ref=\"dashboardeduc_005\" label=\"Etat Encaissement Deuxième Tranche\" id=\"dashboardeduc005\">\n        <dashboardentry parent_ref=\"dashboardeduc005\" label=\"Données\" type=\"bar,data\" id=\"dashentryeduc005\">\n            <field name=\"previsionT2\"/>\n            <field name=\"encaisseT2\"/>\n            <field name=\"soldeT2\"/>\n        </dashboardentry>\n    </dashboard>\n    <dashboard parent_ref=\"dashboardeduc_006\" label=\"Etat Encaissement Troisième Tranche\" id=\"dashboardeduc006\">\n        <dashboardentry parent_ref=\"dashboardeduc006\" label=\"Données\" type=\"bar,data\" id=\"dashentryeduc006\">\n            <field name=\"previsionT3\"/>\n            <field name=\"encaisseT3\"/>\n            <field name=\"soldeT3\"/>\n        </dashboardentry>\n    </dashboard>\n</dashboardRecord>\n',0,'Tableau de Bord',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,48,NULL,NULL),('REPORT',16,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report_01',0,NULL,NULL,0,'Liste des Etudiants',NULL,'EleveSearch',1,'pdf','kereneducation','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kereneducation\" entity=\"EleveSearch\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,50),('REPORT',17,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report_02',0,NULL,NULL,0,'Certificat de scolarite',NULL,'EleveSearch',1,'pdf','kereneducation','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kereneducation\" entity=\"EleveSearch\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,51),('REPORT',18,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report_anniv',0,NULL,NULL,0,'Anniversaire',NULL,'ViewAnniversaireModal',1,'pdf','kereneducation','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kereneducation\" entity=\"ViewAnniversaireModal\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,59),('REPORT',19,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report_bilan',0,NULL,NULL,0,'Imprimer le Bilan financier',NULL,'ViewBilanFinancierEcoleModal',1,'pdf','kereneducation','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kereneducation\" entity=\"ViewBilanFinancierEcoleModal\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,64),('REPORT',20,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report_bilanclasse',0,NULL,NULL,0,'Imprimer le Recap. du Bilan',NULL,'ViewBilanFinancierModal',1,'pdf','kereneducation','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kereneducation\" entity=\"ViewBilanFinancierModal\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,63),('REPORT',21,0,0,0,1,0,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,1,'base_account_report_paiement',0,NULL,NULL,0,'Listing des Paiements',NULL,'ViewDltPaiementModal',1,'pdf','kereneducation','<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<search method=\"pdf\" module=\"kereneducation\" entity=\"ViewDltPaiementModal\">\n    <field name=\"Nationalité\"/>\n    <field name=\"Matricule\"/>\n</search>\n',NULL,NULL,NULL,NULL,NULL,NULL,61);
/*!40000 ALTER TABLE `t_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'keren_gsbs_db'
--
/*!50003 DROP FUNCTION IF EXISTS `ecarttypemoy` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `ecarttypemoy`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT std(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen ;
		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `extrememax` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `extrememax`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT max(n.note) into valeur from  e_notedlt n where n.el_note_id=param and n.annee_id=exercice;

		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `extrememin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `extrememin`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT min(n.note) into valeur from  e_notedlt n where n.el_note_id=param and n.annee_id=exercice;

		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `montantfrais` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `montantfrais`(etat varchar(255),param varchar(255), code varchar(255), exercice varchar(255)) RETURNS decimal(38,0)
begin
         DECLARE valeur decimal(38,0);
           if etat='A'
       then   select sum(e.total_ttc) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and type_service=param and c.libelle=code and i.annee_id=exercice;
       return valeur ;
       elseif etat='R'
       then   select sum(e.MNT_PAYER) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and type_service=param and c.libelle=code and i.annee_id=exercice;
        return valeur ;
        elseif etat='S'
       then    select sum(e.SOLDE) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and c.libelle=code and i.annee_id=exercice;
        return valeur ;
        elseif etat='Re'
       then    select sum(e.REMISE) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id  and c.libelle=code and i.annee_id=exercice;
        return valeur ;
        elseif etat='Ri'
       then    select sum(e.RISTOURNE) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and c.libelle=code and i.annee_id=exercice;
        return valeur ;
       elseif etat='TA'
       then    select sum(e.total_ttc) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and c.libelle=code and i.annee_id=exercice;
        return valeur ;
       elseif etat='TR'
       then    select sum(e.MNT_PAYER) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and c.libelle=code and i.annee_id=exercice;
        return valeur ;
       elseif etat='NS'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=code and i.SOLDE <=0 and i.annee_id=exercice ;
        return valeur ;
        elseif etat='NI'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=code and i.annee_id=exercice;
        return valeur ;
       else return valeur ;
       end if ;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `montantfraisclasse` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `montantfraisclasse`(etat varchar(255),param varchar(255), code decimal(38,0),classeid decimal(38,0), exercice varchar(255)) RETURNS decimal(38,0)
begin
         DECLARE valeur decimal(38,0);
           if etat='A'
       then   select sum(e.total_ttc) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and type_service=param and i.eleve_id=code and i.annee_id=exercice;
       return valeur ;
       elseif etat='R'
       then   select sum(e.MNT_PAYER) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and type_service=param and i.eleve_id=code and i.annee_id=exercice;
        return valeur ;
        elseif etat='S'
       then    select sum(e.SOLDE) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and i.eleve_id=code and i.annee_id=exercice;
        return valeur ;
        elseif etat='Re'
       then    select sum(e.REMISE) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id  and i.eleve_id=code and i.annee_id=exercice;
        return valeur ;
        elseif etat='Ri'
       then    select sum(e.RISTOURNE) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and i.eleve_id=code and i.annee_id=exercice;
        return valeur ;
       elseif etat='TA'
       then    select sum(e.total_ttc) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and i.eleve_id=code and i.annee_id=exercice;
        return valeur ;
       elseif etat='TR'
       then    select sum(e.MNT_PAYER) into valeur FROM e_p_fiche e, e_service s,e_inscription i, e_classe c
             where e.ser_id=s.id and e.fiche_paie_id=i.id and i.classe_id=c.id and i.eleve_id=code and i.annee_id=exercice;
        return valeur ;
       elseif etat='NS'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=classeid and i.SOLDE <=0 and i.annee_id=exercice ;
        return valeur ;
        elseif etat='NI'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=classeid and i.annee_id=exercice;
        return valeur ;
       else return valeur ;
       end if ;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `montantfraistotal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `montantfraistotal`(etat varchar(255),param varchar(255), exercice varchar(255)) RETURNS decimal(38,0)
begin
         DECLARE valeur decimal(38,0);
           if etat='A'
       then   select sum(e.total_ttc) into valeur FROM e_p_fiche e, e_service s,e_inscription i
             where e.ser_id=s.id and e.fiche_paie_id=i.id  and s.type_service=param and i.annee_id=exercice;
       return valeur ;
       elseif etat='R'
       then   select sum(e.MNT_PAYER) into valeur FROM e_p_fiche e, e_service s,e_inscription i
             where e.ser_id=s.id and e.fiche_paie_id=i.id  and type_service=param  and i.annee_id=exercice;
        return valeur ;
        elseif etat='S'
       then    select sum(e.SOLDE) into valeur FROM e_p_fiche e, e_service s,e_inscription i
             where e.ser_id=s.id and e.fiche_paie_id=i.id and  type_service=param and i.annee_id=exercice;
        return valeur ;
        elseif etat='Re'
       then    select sum(e.REMISE) into valeur FROM e_p_fiche e, e_service s,e_inscription i
             where e.ser_id=s.id and e.fiche_paie_id=i.id and s.type_service=param  and i.annee_id=exercice;
        return valeur ;
        elseif etat='Ri'
       then    select sum(e.RISTOURNE) into valeur FROM e_p_fiche e, e_service s,e_inscription i
             where e.ser_id=s.id and e.fiche_paie_id=i.id and s.type_service=param and i.annee_id=exercice;
        return valeur ;
       elseif etat='TA'
       then    select sum(e.total_ttc) into valeur FROM e_p_fiche e ,e_inscription i where e.fiche_paie_id=i.id and i.annee_id=exercice;
        return valeur ;
       elseif etat='TR'
       then    select sum(e.MNT_PAYER) into valeur FROM e_p_fiche e, e_inscription i where e.fiche_paie_id=i.id and  i.annee_id=exercice;
        return valeur ;
       elseif etat='TS'
       then    select sum(e.SOLDE) into valeur FROM e_p_fiche e, e_inscription i where e.fiche_paie_id=i.id and  i.annee_id=exercice;
        return valeur ;
        elseif etat='NE'
       then    select count(e.id) into valeur FROM e_eleve e  ;
        return valeur ;
       elseif etat='NS'
       then    select count(i.id) into valeur FROM e_inscription i where  i.SOLDE <=0 and i.annee_id=exercice ;
        return valeur ;
        elseif etat='NI'
       then    select count(i.id) into valeur FROM e_inscription i  where i.annee_id=exercice;
        return valeur ;
       elseif etat='NS123'
       then    select count(i.id) into valeur FROM e_p_fiche e, e_service s,e_inscription i
               where e.ser_id=s.id and e.fiche_paie_id=i.id  and s.type_service=param and e.SOLDE<=0 and i.annee_id=exercice;
        return valeur ;

       else return valeur ;
       end if ;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `moyclsmat` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `moyclsmat`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT avg(n.note) into valeur from  e_notedlt n where n.el_note_id=param and n.annee_id=exercice;

		return TRUNCATE(valeur,3) ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `moydercls` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `moydercls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT min(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen;
		return TRUNCATE(valeur,3) ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `moyeleseq` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `moyeleseq`(param BIGINT(20),seq varchar(255),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef)/sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c , e_examen x
		where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id   and e.etudiant_id=param and e.annee_id=exercice and x.libelle=seq;

		return TRUNCATE(valeur,3) ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `moyenneeleve` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `moyenneeleve`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT e.moy into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen;
		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `moygencls` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `moygencls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT avg(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen;
		return TRUNCATE(valeur,3) ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `moypremiercls` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `moypremiercls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT max(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen;
		return TRUNCATE(valeur,3) ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `nbreelevecls` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `nbreelevecls`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT count(e.id) into valeur from  e_inscription e where e.classe_id=param and e.annee_id=exercice ;
		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `nbremoycls` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `nbremoycls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT count(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen and e.moy>=10;
		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `notemat` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `notemat`(eleve BIGINT(20),matiere BIGINT(20),examen varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT n.note into valeur  from e_note_mat e , e_notedlt n, e_examen x where e.id= n.el_note_id and e.examen_id=x.id
         and n.etudiant_id= eleve and matiere_id=matiere and x.libelle=examen and annee_id=exercice;

		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `rankmat` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `rankmat`(eleve BIGINT(20),matiere BIGINT(20),seq varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(note,(select GROUP_CONCAT(note ORDER BY note DESC)  FROM e_notedlt e, e_note_mat m , e_examen x
			where e.el_note_id=m.id and m.examen_id=x.id and m.examen_id=seq and m.matiere_id=matiere and e.etudiant_id=eleve and e.annee_id=exercice) ) into valeur from e_notedlt e, e_note_mat m , e_examen x
				where e.el_note_id=m.id and m.examen_id=x.id and m.examen_id=seq and m.matiere_id=matiere and e.etudiant_id=eleve and e.annee_id=exercice;
		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `rankmoyenne` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `rankmoyenne`(eleve BIGINT(20),examen varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(moy,(select GROUP_CONCAT(moy ORDER BY moy DESC) FROM e_zview_helper e where e.examen_id=examen  and annee_id=exercice)) into valeur from e_zview_helper e
		where e.examen_id=examen and e.etudiant_id=eleve and annee_id=exercice;
	return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `totalcoefexamen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `totalcoefexamen`(param BIGINT(20),examen BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param and e.annee_id=exercice and m.examen_id=examen;

		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `totalpointexamen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `totalpointexamen`(param BIGINT(20),examen BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param and e.annee_id=exercice and m.examen_id=examen;

		return valeur ;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `e_zview_bf`
--

/*!50001 DROP TABLE IF EXISTS `e_zview_bf`*/;
/*!50001 DROP VIEW IF EXISTS `e_zview_bf`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `e_zview_bf` AS select `e`.`id` AS `ID`,`c`.`id` AS `CLASSE_ID`,`i`.`ELEVE_ID` AS `ELEVE_ID`,ifnull(`montantfraisclasse`('R','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `INSCRIPTION_ENC`,ifnull(`montantfraisclasse`('R','1',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `I_TRAN_ENC`,ifnull(`montantfraisclasse`('R','2',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `II_TRAN_ENC`,ifnull(`montantfraisclasse`('R','3',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `III_TRAN_ENC`,ifnull(`montantfraisclasse`('Re','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `REMISE`,ifnull(`montantfraisclasse`('Ri','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `RISTOURNE`,ifnull(`montantfraisclasse`('TA','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `TOTAL_A`,ifnull(`montantfraisclasse`('TR','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `TOTAL_R`,ifnull(`montantfraisclasse`('S','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `SOLDE`,`cy`.`id` AS `CYCLE_ID`,ifnull(`montantfraisclasse`('NI','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `EFF`,ifnull(`montantfraisclasse`('NS','0',`i`.`ELEVE_ID`,`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `EFF_SOL`,`i`.`ANNEE_ID` AS `ANNEE_ID`,'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL`,0 AS `DESABLEUPDATE` from (((((`e_p_fiche` `e` join `e_service` `s`) join `e_inscription` `i`) join `e_classe` `c`) join `e_filiere` `f`) join `e_cycle` `cy`) where ((`e`.`SER_ID` = `s`.`id`) and (`e`.`FICHE_PAIE_ID` = `i`.`id`) and (`i`.`CLASSE_ID` = `c`.`id`) and (`c`.`FILIERE_ID` = `f`.`id`) and (`f`.`CYCLE_ID` = `cy`.`id`)) group by `i`.`ELEVE_ID`,`i`.`ANNEE_ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `e_zview_bf_ecole`
--

/*!50001 DROP TABLE IF EXISTS `e_zview_bf_ecole`*/;
/*!50001 DROP VIEW IF EXISTS `e_zview_bf_ecole`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `e_zview_bf_ecole` AS select `e`.`id` AS `ID`,`c`.`id` AS `CLASSE_ID`,ifnull(`montantfrais`('A','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `INSCRIPTION`,ifnull(`montantfrais`('R','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `INSCRIPTION_ENC`,ifnull(`montantfrais`('A','1',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `I_TRAN`,ifnull(`montantfrais`('R','1',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `I_TRAN_ENC`,ifnull(`montantfrais`('A','2',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `II_TRAN`,ifnull(`montantfrais`('R','2',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `II_TRAN_ENC`,ifnull(`montantfrais`('A','3',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `III_TRAN`,ifnull(`montantfrais`('R','3',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `III_TRAN_ENC`,ifnull(`montantfrais`('Re','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `REMISE`,ifnull(`montantfrais`('Ri','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `RISTOURNE`,ifnull(`montantfrais`('TA','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `TOTAL_A`,ifnull(`montantfrais`('TR','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `TOTAL_R`,ifnull(`montantfrais`('S','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `SOLDE`,round(((ifnull(`montantfrais`('TR','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) / ifnull(`montantfrais`('TA','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0)) * 100),2) AS `TX_RECO`,`cy`.`id` AS `CYCLE_ID`,ifnull(`montantfrais`('NI','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `EFF`,ifnull(`montantfrais`('NS','0',`c`.`LIBELLE`,`i`.`ANNEE_ID`),0) AS `EFF_SOL`,`i`.`ANNEE_ID` AS `ANNEE_ID`,'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL`,0 AS `DESABLEUPDATE` from (((((`e_p_fiche` `e` join `e_service` `s`) join `e_inscription` `i`) join `e_classe` `c`) join `e_filiere` `f`) join `e_cycle` `cy`) where ((`e`.`SER_ID` = `s`.`id`) and (`e`.`FICHE_PAIE_ID` = `i`.`id`) and (`i`.`CLASSE_ID` = `c`.`id`) and (`c`.`FILIERE_ID` = `f`.`id`) and (`f`.`CYCLE_ID` = `cy`.`id`)) group by `c`.`id`,`i`.`ANNEE_ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `e_zview_bulletin`
--

/*!50001 DROP TABLE IF EXISTS `e_zview_bulletin`*/;
/*!50001 DROP VIEW IF EXISTS `e_zview_bulletin`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `e_zview_bulletin` AS select (((`i`.`id` + `i`.`ELEVE_ID`) + `i`.`CLASSE_ID`) + `n`.`id`) AS `ID`,`i`.`id` AS `INS_ID`,`i`.`ELEVE_ID` AS `ELEVE_ID`,`i`.`CLASSE_ID` AS `CLASSE_ID`,`i`.`CYCLE_ID` AS `CYCLE_ID`,`i`.`ANNEE_ID` AS `ANNEE_ID`,`mat`.`id` AS `COEF_ID`,`mat`.`MATIERE_ID` AS `MAT_ID`,`e`.`EXAMEN_ID` AS `EXAMEN_ID`,ifnull(`notemat`(`i`.`id`,`mat`.`MATIERE_ID`,'0',`i`.`ANNEE_ID`),0) AS `NOTE1`,ifnull(`notemat`(`i`.`id`,`mat`.`MATIERE_ID`,'1',`i`.`ANNEE_ID`),0) AS `NOTE2`,ifnull(`notemat`(`i`.`id`,`mat`.`MATIERE_ID`,'2',`i`.`ANNEE_ID`),0) AS `NOTE3`,ifnull(`notemat`(`i`.`id`,`mat`.`MATIERE_ID`,'3',`i`.`ANNEE_ID`),0) AS `NOTE4`,ifnull(`notemat`(`i`.`id`,`mat`.`MATIERE_ID`,'4',`i`.`ANNEE_ID`),0) AS `NOTE5`,ifnull(`notemat`(`i`.`id`,`mat`.`MATIERE_ID`,'5',`i`.`ANNEE_ID`),0) AS `NOTE6`,ifnull(`moyclsmat`(`e`.`id`,`i`.`ANNEE_ID`),0) AS `MOY_CLA_MATIERE`,ifnull(`extrememax`(`e`.`id`,`i`.`ANNEE_ID`),0) AS `EXTR_MAX_MAT`,ifnull(`extrememin`(`e`.`id`,`i`.`ANNEE_ID`),0) AS `EXTR_MIN_MAT`,ifnull(`moyeleseq`(`i`.`id`,'0',`i`.`ANNEE_ID`),0) AS `MOY1`,ifnull(`moyeleseq`(`i`.`id`,'1',`i`.`ANNEE_ID`),0) AS `MOY2`,ifnull(`moyeleseq`(`i`.`id`,'2',`i`.`ANNEE_ID`),0) AS `MOY3`,ifnull(`moyeleseq`(`i`.`id`,'3',`i`.`ANNEE_ID`),0) AS `MOY4`,ifnull(`moyeleseq`(`i`.`id`,'4',`i`.`ANNEE_ID`),0) AS `MOY5`,ifnull(`moyeleseq`(`i`.`id`,'5',`i`.`ANNEE_ID`),0) AS `MOY6`,`rankmat`(`i`.`id`,`mat`.`MATIERE_ID`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `RANG_MAT`,`rankmoyenne`(`i`.`id`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `RANG_MOY`,`moygencls`(`i`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `MOY_GEN_CLS`,`moypremiercls`(`i`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `MOY_PREMIER`,`moydercls`(`i`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `MOY_DERNIER`,`nbremoycls`(`i`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `NBRE_MOY`,`nbreelevecls`(`i`.`CLASSE_ID`,`i`.`ANNEE_ID`) AS `NBRE_ELVE`,((`nbremoycls`(`i`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) * 100) / `nbreelevecls`(`i`.`CLASSE_ID`,`i`.`ANNEE_ID`)) AS `TX_REU`,`totalpointexamen`(`i`.`id`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `TOTAL_POINT`,`totalcoefexamen`(`i`.`id`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `TOTAL_COEF`,1 AS `RANG1`,2 AS `RANG2`,3 AS `RANG3`,4 AS `RANG4`,5 AS `RANG5`,6 AS `RANG6`,`ecarttypemoy`(`i`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`i`.`ANNEE_ID`) AS `ECART_TYPE`,'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL`,0 AS `DESABLEUPDATE` from (((`e_inscription` `i` join `e_coefmatdtl` `mat`) join `e_note_mat` `e`) join `e_notedlt` `n`) where ((`i`.`id` = `n`.`ETUDIANT_ID`) and (`e`.`id` = `n`.`EL_NOTE_ID`) and (`mat`.`MATIERE_ID` = `e`.`MATIERE_ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `e_zview_dashboard`
--

/*!50001 DROP TABLE IF EXISTS `e_zview_dashboard`*/;
/*!50001 DROP VIEW IF EXISTS `e_zview_dashboard`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `e_zview_dashboard` AS select `i`.`id` AS `ID`,ifnull(`montantfraistotal`('NE','0',`i`.`ANNEE_ID`),0) AS `N_ELEVE`,ifnull(`montantfraistotal`('NI','0',`i`.`ANNEE_ID`),0) AS `N_ELEVE_INS`,ifnull(`montantfraistotal`('NS123','1',`i`.`ANNEE_ID`),0) AS `N_ELEVE_T1`,ifnull(`montantfraistotal`('NS123','2',`i`.`ANNEE_ID`),0) AS `N_ELEVE_T2`,ifnull(`montantfraistotal`('NS123','3',`i`.`ANNEE_ID`),0) AS `N_ELEVE_T3`,ifnull(`montantfraistotal`('NS','0',`i`.`ANNEE_ID`),0) AS `N_ELEVE_S`,ifnull(`montantfraistotal`('TA','0',`i`.`ANNEE_ID`),0) AS `PRE_G`,ifnull(`montantfraistotal`('TR','0',`i`.`ANNEE_ID`),0) AS `ENC_G`,ifnull(`montantfraistotal`('TS','0',`i`.`ANNEE_ID`),0) AS `SOLD_G`,ifnull(`montantfraistotal`('A','0',`i`.`ANNEE_ID`),0) AS `PRE_I`,ifnull(`montantfraistotal`('R','0',`i`.`ANNEE_ID`),0) AS `ENC_I`,ifnull(`montantfraistotal`('S','0',`i`.`ANNEE_ID`),0) AS `SOLD_I`,ifnull(`montantfraistotal`('A','1',`i`.`ANNEE_ID`),0) AS `PRE_T1`,ifnull(`montantfraistotal`('R','1',`i`.`ANNEE_ID`),0) AS `ENC_T1`,ifnull(`montantfraistotal`('S','1',`i`.`ANNEE_ID`),0) AS `SOLD_T1`,ifnull(`montantfraistotal`('A','2',`i`.`ANNEE_ID`),0) AS `PRE_T2`,ifnull(`montantfraistotal`('R','2',`i`.`ANNEE_ID`),0) AS `ENC_T2`,ifnull(`montantfraistotal`('S','2',`i`.`ANNEE_ID`),0) AS `SOLD_T2`,ifnull(`montantfraistotal`('A','3',`i`.`ANNEE_ID`),0) AS `PRE_T3`,ifnull(`montantfraistotal`('R','3',`i`.`ANNEE_ID`),0) AS `ENC_T3`,ifnull(`montantfraistotal`('S','3',`i`.`ANNEE_ID`),0) AS `SOLD_T3`,`i`.`ANNEE_ID` AS `ANNEE_ID`,'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL`,0 AS `DESABLEUPDATE` from `e_inscription` `i` group by `i`.`ANNEE_ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `e_zview_helper`
--

/*!50001 DROP TABLE IF EXISTS `e_zview_helper`*/;
/*!50001 DROP VIEW IF EXISTS `e_zview_helper`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `e_zview_helper` AS select ((`e`.`ETUDIANT_ID` + `x`.`id`) + `m`.`CLASSE_ID`) AS `ID`,`x`.`id` AS `EXAMEN_ID`,`e`.`ETUDIANT_ID` AS `ETUDIANT_ID`,`m`.`CLASSE_ID` AS `CLASSE_ID`,(sum((`e`.`NOTE` * `c`.`COEF`)) / sum(`c`.`COEF`)) AS `MOY`,`e`.`ANNEE_ID` AS `ANNEE_ID`,`x`.`LIBELLE` AS `TYPE_EXAMEN` from (((`e_notedlt` `e` join `e_note_mat` `m`) join `e_coefmatdtl` `c`) join `e_examen` `x`) where ((`e`.`EL_NOTE_ID` = `m`.`id`) and (`m`.`MATIERE_ID` = `c`.`id`) and (`m`.`EXAMEN_ID` = `x`.`id`)) group by `e`.`ETUDIANT_ID`,`x`.`id`,`e`.`ANNEE_ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `e_zview_note_helper`
--

/*!50001 DROP TABLE IF EXISTS `e_zview_note_helper`*/;
/*!50001 DROP VIEW IF EXISTS `e_zview_note_helper`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `e_zview_note_helper` AS select (`e`.`id` + `n`.`id`) AS `ID`,`e`.`id` AS `MAT_NOTE_ID`,`e`.`CLASSE_ID` AS `CLASSE_ID`,`e`.`EXAMEN_ID` AS `EXAMEN_ID`,`e`.`MATIERE_ID` AS `MATIERE_ID`,`n`.`id` AS `NOTE_ID`,`n`.`ETUDIANT_ID` AS `ELEVE_ID`,`n`.`NOTE` AS `NOTE`,`n`.`APPRECIATION` AS `APPRECIATION`,`moyclsmat`(`e`.`id`,`n`.`ANNEE_ID`) AS `MOY_CLA_MATIERE`,`extrememax`(`e`.`id`,`n`.`ANNEE_ID`) AS `EXTR_MAX`,`extrememin`(`e`.`id`,`n`.`ANNEE_ID`) AS `EXTR_MIN`,`totalpointexamen`(`n`.`ETUDIANT_ID`,`e`.`EXAMEN_ID`,`n`.`ANNEE_ID`) AS `TOTAL_POINT`,`totalcoefexamen`(`n`.`ETUDIANT_ID`,`e`.`EXAMEN_ID`,`n`.`ANNEE_ID`) AS `TOTAL_COEF`,`moyenneeleve`(`n`.`ETUDIANT_ID`,`e`.`EXAMEN_ID`,`n`.`ANNEE_ID`) AS `MOY_ETUDIANT`,`moypremiercls`(`e`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`n`.`ANNEE_ID`) AS `MOY_PREMIER`,`moydercls`(`e`.`CLASSE_ID`,`e`.`EXAMEN_ID`,`n`.`ANNEE_ID`) AS `MOY_DERNIER`,'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL`,0 AS `DESABLEUPDATE` from (`e_note_mat` `e` join `e_notedlt` `n`) where (`e`.`id` = `n`.`EL_NOTE_ID`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `e_zview_paiement`
--

/*!50001 DROP TABLE IF EXISTS `e_zview_paiement`*/;
/*!50001 DROP VIEW IF EXISTS `e_zview_paiement`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `e_zview_paiement` AS select `p`.`id` AS `ID`,`p`.`ZMNT` AS `TOTAL_TTC`,`p`.`ZMNT_VERSER` AS `MNT_PAYER`,`p`.`DATE_PAI` AS `DATE_PAI`,`p`.`F_ID` AS `SER_ID`,`i`.`id` AS `ELEVE_ID`,`c`.`id` AS `CLASSE_ID`,`cy`.`id` AS `CYCLE_ID`,`p`.`TYP_PAI` AS `TYP_PAI`,`p`.`ANNEE_ID` AS `ANNEE_ID`,'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL`,0 AS `DESABLEUPDATE` from (((((`e_p_paie` `p` join `e_p_fiche` `fi`) join `e_inscription` `i`) join `e_classe` `c`) join `e_filiere` `f`) join `e_cycle` `cy`) where ((`p`.`F_ID` = `fi`.`id`) and (`fi`.`FICHE_PAIE_ID` = `i`.`id`) and (`i`.`CLASSE_ID` = `c`.`id`) and (`c`.`FILIERE_ID` = `f`.`id`) and (`f`.`CYCLE_ID` = `cy`.`id`)) */;
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

-- Dump completed on 2018-07-10 11:54:00
