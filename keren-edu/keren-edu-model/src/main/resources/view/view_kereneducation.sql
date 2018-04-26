CREATE VIEW e_zview_bul(ID, CLASSE_ID,EXAMEN_ID,MATIERE_ID,INS_ID,COEF_ID,NOTE_ID,MODULE_ID,BULLETIN_ID,
MOY_CLA_MAT,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL)
AS
SELECT e.id+i.id+m.id+n.id+i.id, e.classe_id,e.examen_id ,m.matiere_id,i.id, cd.id,n.id ,mo.id, b.id,
TRUNCATE(moyclsmat(m.matiere_id),2),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt"
FROM e_note e ,e_note_mat m ,e_notedlt n, e_inscription i, e_coefmat c ,e_coefmatdtl cd,e_module mo,e_module_e_matiere mom,
e_bul_e_examen bl,e_bul b
where e.id=m.matiere_note_id
and m.id=n.el_note_id and n.etudiant_id=i.eleve_id
and e.classe_id=c.classe_id
and m.matiere_id=cd.matiere_id
and m.matiere_id=mom.matiereList_id
and mom.e_module_id=mo.id
and e.examen_id=bl.sequence_id
and bl.e_bul_id=b.id;


CREATE VIEW e_zview_bulletin(ID, MAT_NOT_ID,NOTE_ID,MOY_CLA_MATIERE,EXTR_MAX,EXTR_MIN,TOTAL_POINT,TOTAL_COEF,MOY_ETUDIANT
,MOY_PREMIER,MOY_DERNIER,ELEVE_ID,CLASSE_ID,INS_ID,MODULE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL)
AS
SELECT m.id+n.id, m.id,n.id,TRUNCATE(moyclsmat(n.el_note_id),2),extrememax(n.el_note_id),extrememin(n.el_note_id),totalpointetud(n.etudiant_id),
totalcoef(n.etudiant_id),TRUNCATE(moyetudiant(n.etudiant_id),2),20,02,e.id,c.id,i.id,mo.id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt"
FROM e_note_mat m ,e_notedlt n, e_eleve e, e_classe c,e_inscription i,e_coefmatdtl co, e_module mo,e_module_e_matiere mom
where m.id=n.el_note_id
and n.etudiant_id=e.id
and m.classe_id=c.id
and e.id=i.eleve_id
and m.matiere_id=co.id
and co.matiere_id=mom.matiereList_id
and mom.e_module_id=mo.id



--- moyenne classe /matiere
DELIMITER $$
CREATE FUNCTION `moyclsmat`(param BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT avg(n.note) into valeur from  e_notedlt n where n.el_note_id=param;

		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;
--- extreme maximun
DELIMITER $$
CREATE FUNCTION `extrememax`(param BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT max(n.note) into valeur from  e_notedlt n where n.el_note_id=param;

		return valeur ;

end $$

DELIMITER ;

--- extreme min
DELIMITER $$
CREATE FUNCTION `extrememin`(param BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT min(n.note) into valeur from  e_notedlt n where n.el_note_id=param;

		return valeur ;

end $$

DELIMITER ;

--- total des point avec coef
DELIMITER $$
CREATE FUNCTION `totalpointetud`(param BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param;

		return valeur ;

end $$

DELIMITER ;

--- total  coef
DELIMITER $$
CREATE FUNCTION `totalcoef`(param BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param;

		return valeur ;

end $$

DELIMITER ;


--- total  coef
DELIMITER $$
CREATE FUNCTION `moyetudiant`(param BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef)/sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param;

		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;


SELECT mat.id+en.id+n.id,  mat.id , en.id ,n.id ,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt"
FROM e_coefmatdtl mat ,e_note_mat en,e_notedlt n
where mat.id=en.matiere_id
and en.id=n.el_note_id
union
SELECT mat.id+mat.matiere_id+mat.PROF_ID+COEF,mat.id as code, null ,null,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt"
FROM e_coefmatdtl mat
where mat.id not in (select en.matiere_id from e_note_mat en )
;