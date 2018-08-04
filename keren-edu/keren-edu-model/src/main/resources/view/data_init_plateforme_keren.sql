


--
-- init data`
--

INSERT INTO `t_devise` VALUES (1,0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CFA',1),(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NARRA',0.123);

INSERT INTO `t_pays` VALUES (1,0,0,1,0,0,0,'REPUBLIQUE DU CAMEROUN','PAYS',NULL,'PAYS','kerencore',NULL,NULL,'CMR','1515504545337.png','REPUBLIQUE DU CAMEROUN',1),(2,0,0,2,0,0,0,'SENEGAL','PAYS',NULL,'PAYS','teratechstock',NULL,NULL,'SEN','1515513162663.png','SENEGAL',1),
(6,0,0,6,1,0,0,'FEDERAL REPUBLIC OF NIGERIA','PAYS',NULL,'PAYS','teratechstock',0,NULL,'NGR','1515513264407.png','FEDERAL REPUBLIC OF NIGERIA',2);

INSERT INTO `t_taxe` VALUES (1,0,0,1,1,0,0,'TVA - Taxe ?á valeur ajout?®e','Taxe',NULL,'Plan Taxes','baseaccount',0,NULL,'1','TVA','19.25',19.25,'Taxes sur les achats','0','0'),
(2,0,0,0,1,0,0,NULL,NULL,NULL,NULL,NULL,0,NULL,'1','CD','Exemplz',2.5,'','0',NULL);

INSERT INTO `t_compte` VALUES (1,0,0,1,1,0,0,'201111 - SOMME TUNINGS','Compte',NULL,'Plan Comptable','baseaccount',0,NULL,'201111','0','SOMME TUNINGS','1','XXXXX','1','0',NULL);

INSERT INTO `t_jcomptable` VALUES (1,0,0,1,1,0,0,'Journal des achats','Journal comptable',NULL,'Journaux comptable','baseaccount',0,NULL,1,NULL,'ACH','Journal des achats','1',NULL);

INSERT INTO `t_societe` VALUES (1,0,0,1,0,0,0,'MGT','SOCIETE',NULL,'SOCIETES','kerenpaie',0,NULL,'FOUDA-YDE','AGENCE NATIONAL DES NORMES ET DE LA QUALITE','','','','1517575079227.png','ANOR','','','','695427874','YAOUNDE',1,1,1,1,1,NULL,NULL);

INSERT INTO `t_user` VALUES
(1,0,0,1,1,0,0,'Administrateur',NULL,NULL,NULL,'kerencore',0,NULL,0,'3','ntchuente@gmail.com','1515513689293.png','Administrateur','2018-06-09 16:55:50','admin','YjVF4NQ3bMVItVfDKgF16w==','etabli',1,1),
(3,0,0,3,1,0,0,'Nadege Tchuente','UTILISATEUR',NULL,'UTILISATEURS','kerencore',0,NULL,1,'0','wntchuente@gmail.com','1515513673801.png','Nadege Tchuente',NULL,'admin','mgt','etabli',1,1),
(4,0,0,4,1,0,0,'ABEGA',NULL,NULL,NULL,'kerencore',0,NULL,1,'0','serge@gmail.com','','ABEGA','2018-02-12 21:09:59','admin','MGT','etabli',1,1);