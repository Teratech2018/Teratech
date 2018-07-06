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

REM ----------------------------------------------------------------------------------------------------------
REM -- SCRIPT D'EXPLOITATION DE LA BASE DE DONNEES GEPA														--
REM -- Ce programme permet de faire une sauvegarde des données de GEPA sous MySQL							--
REM -- 																										--
REM -- AUTEUR: BASILE MBALI																					--
REM -- PROJET: GEPA																			 	 			--
REM --																										--
REM -- DATE: 27 Septembre 2016																				--
REM ----------------------------------------------------------------------------------------------------------

mysqldump -uroot -pmegatim --no-create-info keren_db > data_file.sql
mysqldump -uroot -pmegatim --no-data keren_db > schema_file.sql
