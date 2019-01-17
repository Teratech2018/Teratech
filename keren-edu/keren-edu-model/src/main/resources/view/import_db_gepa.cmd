ECHO off
REM ----------------------------------------------------------------------------------------------------------
REM -- SCRIPT D'EXPLOITATION DE LA BASE DE DONNEES GEPA														--
REM -- Ce programme permet de faire une restauration des données de GEPA sous MySQL							--
REM -- 																										--
REM -- AUTEUR: BASILE MBALI																					--
REM -- PROJET: Interface Paiement															 	 			--
REM --																										--
REM -- DATE: 27 Septembre 2016																				--
REM ----------------------------------------------------------------------------------------------------------


ECHO on

mysql -uroot -pmegatim keren_gsbs_db  < keren_school_db_local_good.sql