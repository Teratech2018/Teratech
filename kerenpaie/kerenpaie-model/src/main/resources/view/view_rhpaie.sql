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