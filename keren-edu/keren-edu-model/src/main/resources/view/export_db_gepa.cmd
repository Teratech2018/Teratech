ECHO OFF 
REM ----------------------------------------------------------------------------------------------------------
REM -- SCRIPT D'EXPLOITATION DE LA BASE DE DONNEES GEPA														--
REM -- Ce programme permet de faire une sauvegarde des données de GEPA sous MySQL							--
REM -- 																										--
REM -- AUTEUR: BASILE MBALI																					--
REM -- PROJET: GEPA																			 	 			--
REM --																										--
REM -- DATE: 27 Septembre 2016																				--
REM ----------------------------------------------------------------------------------------------------------

REM mysqldump -uroot -pmegatim gepa_db > gepa_data_save.sql
REM mysqldump -uroot -pmegatim gepa > gepa_data_save.sql

REM mysqldump --routines=true -umandjek -pci*_1502@1982  anor_db > anor_init_db_141219.sql
ECHO on

mysqldump --routines=true -uroot -pmegatim  keren_school_gsbs > keren_school_good.sql

