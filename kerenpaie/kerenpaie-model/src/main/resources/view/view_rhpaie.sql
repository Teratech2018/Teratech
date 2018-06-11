CREATE VIEW V_BULLETIN_PAIE(ID,RUBRIQUE_ID,LIGNE_BULL_ID,BUL_ID,MATRICULE,PERIODE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL)
AS
SELECT CONCAT(r.id,l.id,b.id) , r.id,l.id,b.id ,e.matricule, p.id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt"
FROM t_rubr r ,t_libupa l,t_bupa b, t_employ e,t_pepa p
where r.id=l.rubr_id
and b.id=l.libupa_id
and b.emp_id=e.id
and b.pepa_id=p.id


CREATE VIEW v_dipe_paie
 AS 
 select concat(`b`.`id`,`p`.`id`) AS `ID`,`b`.`id` AS `BULL_ID`,`p`.`id` AS `PERIODE_ID`,0 AS `SB`
 ,1 AS `SEXCEP`,2 AS `STAXABLE`,3 AS `SCOTCNPS`,4 AS `SCOTPLAF`,5 AS `RET`,6 AS `RETIRPP`,7 AS `RETTAXCOM`,
 'defualt' AS `DESIGNATION`,'defualt' AS `EDITTITLE`,'defualt' AS `LISTTITLE`,'defualt' AS `MODULENAME`,0 AS `CREATEONFIELD`,
 0 AS `COMPAREID`,0 AS `SELECTED`,0 AS `DESABLECREATE`,0 AS `ACTIVATEFOLLOWER`,0 AS `ACTIVEFILELIEN`,0 AS `DESABLEDELETE`,
 'defualt' AS `FOOTERSCRIPT`,'defualt' AS `SERIAL` from (`t_bupa` `b` join `t_pepa` `p`) 
 where (`b`.`PEPA_ID` = `p`.`id`);