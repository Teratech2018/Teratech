CREATE VIEW e_zview_bul(ID, CLASSE_ID,EXAMEN_ID,MATIERE_ID,INS_ID,COEF_ID,NOTE_ID,MODULE_ID,BULLETIN_ID,
MOY_CLA_MAT,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT e.id+i.id+m.id+n.id+i.id, e.classe_id,e.examen_id ,m.matiere_id,i.id, cd.id,n.id ,mo.id, b.id,
TRUNCATE(moyclsmat(m.matiere_id),2),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
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
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT m.id+n.id, m.id,n.id,TRUNCATE(moyclsmat(n.el_note_id),2),extrememax(n.el_note_id),extrememin(n.el_note_id),totalpointetud(n.etudiant_id),
totalcoef(n.etudiant_id),TRUNCATE(moyetudiant(n.etudiant_id),2),20,02,e.id,c.id,i.id,mo.id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_note_mat m ,e_notedlt n, e_eleve e, e_classe c,e_inscription i,e_coefmatdtl co, e_module mo,e_module_e_matiere mom
where m.id=n.el_note_id
and n.etudiant_id=e.id
and m.classe_id=c.id
and e.id=i.eleve_id
and m.matiere_id=co.id
and co.matiere_id=mom.matiereList_id
and mom.e_module_id=mo.id

CREATE VIEW e_zview_paiement(ID,TOTAL_TTC,MNT_PAYER,DATE_PAI,SER_ID,ELEVE_ID,CLASSE_ID,CYCLE_ID,TYP_PAI,ANNEE_ID,REMISE,RISTOURNE,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT p.ID,p.zmnt,p.zmnt_verser,p.date_pai,p.F_ID,i.id, c.id, cy.id,p.typ_pai,p.annee_id,p.zremise,p.zristourne,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_p_paie p ,e_inscription i , e_classe c, e_filiere f, e_cycle cy
where p.eleve_id=i.id
and i.classe_id=c.id
and c.filiere_id=f.id
and f.cycle_id=cy.id ;

CREATE VIEW e_zview_bf_ecole(ID,CLASSE_ID,INSCRIPTION,INSCRIPTION_ENC,I_TRAN,I_TRAN_ENC,II_TRAN,II_TRAN_ENC,III_TRAN,
III_TRAN_ENC,REMISE,RISTOURNE,TOTAL_A,TOTAL_R,SOLDE,TX_RECO,CYCLE_ID,EFF,EFF_SOL,ANNEE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT e.ID,c.id,IFNULL(montantfrais('A','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('R','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('A','1',c.libelle,i.annee_id), 0),
IFNULL(montantfrais('R','1',c.libelle,i.annee_id), 0),IFNULL(montantfrais('A','2',c.libelle,i.annee_id), 0),IFNULL(montantfrais('R','2',c.libelle,i.annee_id), 0),IFNULL(montantfrais('A','3',c.libelle,i.annee_id), 0),
IFNULL(montantfrais('R','3',c.libelle,i.annee_id), 0),IFNULL(montantfrais('Re','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('Ri','0',c.libelle,i.annee_id), 0),
IFNULL(montantfrais('TA','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('TR','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('S','0',c.libelle,i.annee_id), 0),
ROUND(IFNULL(montantfrais('TR','0',c.libelle,i.annee_id), 0)/IFNULL(montantfrais('TA','0',c.libelle,i.annee_id), 0)*100,2),cy.id,
IFNULL(montantfrais('NI','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('NS','0',c.libelle,i.annee_id), 0),i.annee_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_p_fiche e, e_service s,e_inscription i, e_classe c, e_filiere f, e_cycle cy
where e.ser_id=s.id
and e.fiche_paie_id=i.id
and i.classe_id=c.id
and c.FILIERE_ID=f.id
and f.CYCLE_ID=cy.id
group by c.id ,i.annee_id;

CREATE VIEW e_zview_bf(ID,CLASSE_ID,ELEVE_ID,INSCRIPTION_ENC,I_TRAN_ENC,II_TRAN_ENC,III_TRAN_ENC,REMISE,RISTOURNE,
TOTAL_A,TOTAL_R,SOLDE,CYCLE_ID,EFF,EFF_SOL,ANNEE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT e.ID,c.id,i.eleve_id,IFNULL(montantfraisclasse('R','0',i.eleve_id,c.libelle,i.annee_id), 0),IFNULL(montantfraisclasse('R','1',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('R','2',i.eleve_id,c.libelle,i.annee_id), 0),IFNULL(montantfraisclasse('R','3',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('Re','0',i.eleve_id,c.libelle,i.annee_id), 0),IFNULL(montantfraisclasse('Ri','0',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('TA','0',i.eleve_id,c.libelle,i.annee_id), 0),(IFNULL(montantfraisclasse('TR','0',i.eleve_id,c.libelle,i.annee_id), 0)),
IFNULL(montantfraisclasse('S','0',i.eleve_id,c.libelle,i.annee_id), 0),cy.id,IFNULL(montantfraisclasse('NI','0',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('NS','0',i.eleve_id,c.libelle,i.annee_id), 0),i.annee_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_p_fiche e, e_service s,e_inscription i, e_classe c, e_filiere f, e_cycle cy
where e.ser_id=s.id
and e.fiche_paie_id=i.id
and i.classe_id=c.id
and c.FILIERE_ID=f.id
and f.CYCLE_ID=cy.id
group by i.eleve_id ,i.annee_id;


CREATE VIEW e_zview_dashboard(ID,N_ELEVE,N_ELEVE_INS,N_ELEVE_T1,N_ELEVE_T2,N_ELEVE_T3,N_ELEVE_S,
PRE_G,ENC_G,SOLD_G,PRE_I,ENC_I,SOLD_I,PRE_T1,ENC_T1,SOLD_T1,PRE_T2,ENC_T2,SOLD_T2,PRE_T3,ENC_T3,SOLD_T3,ANNEE_ID,TX_REU,NBRE_ADMIS,REMISE_G,RISTOURNE_G,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT e.id,IFNULL(montantfraistotal('NE','0',i.annee_id), 0),IFNULL(montantfraistotal('NI','0',i.annee_id), 0),IFNULL(montantfraistotal('NS123','1',i.annee_id), 0),IFNULL(montantfraistotal('NS123','2',i.annee_id), 0),
IFNULL(montantfraistotal('NS123','3',i.annee_id), 0),IFNULL(montantfraistotal('NS','0',i.annee_id), 0),
IFNULL(montantfraistotal('TA','0',i.annee_id), 0),IFNULL(montantfraistotal('TR','0',i.annee_id), 0),IFNULL(montantfraistotal('TS','0',i.annee_id), 0),
IFNULL(montantfraistotal('A','0',i.annee_id), 0),IFNULL(montantfraistotal('R','0',i.annee_id), 0),IFNULL(montantfraistotal('S','0',i.annee_id), 0),
IFNULL(montantfraistotal('A','1',i.annee_id), 0),IFNULL(montantfraistotal('R','1',i.annee_id), 0),IFNULL(montantfraistotal('S','1',i.annee_id), 0),
IFNULL(montantfraistotal('A','2',i.annee_id), 0),IFNULL(montantfraistotal('R','2',i.annee_id), 0),IFNULL(montantfraistotal('S','2',i.annee_id), 0),
IFNULL(montantfraistotal('A','3',i.annee_id), 0),IFNULL(montantfraistotal('R','3',i.annee_id), 0),IFNULL(montantfraistotal('S','3',i.annee_id), 0),i.annee_id,0,0,IFNULL(montantfraistotal('Re','3',i.annee_id), 0),
IFNULL(montantfraistotal('Ri','3',i.annee_id), 0),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_p_fiche e , e_inscription i
where e.fiche_paie_id=i.id
group by i.annee_id;

CREATE VIEW e_zview_note_helper(ID,MAT_NOTE_ID,CLASSE_ID,EXAMEN_ID,MATIERE_ID,NOTE_ID,ELEVE_ID,NOTE,APPRECIATION,MOY_CLA_MATIERE,
EXTR_MAX,EXTR_MIN,TOTAL_POINT,TOTAL_COEF,MOY_ETUDIANT,MOY_PREMIER,MOY_DERNIER,RANG,RANG_MAT,MOY_GEN_CLS,NBRE_MOY,TX_REU,ECART_TYPE,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT e.id+n.id, e.id, e.classe_id,e.examen_id,e.matiere_id,n.id,n.etudiant_id,n.note,n.appreciation,
moyclsmat(e.id,n.annee_id),extrememax(e.id,n.annee_id),extrememin(e.id,n.annee_id),
totalpointexamen(n.etudiant_id,e.examen_id,n.annee_id),totalcoefexamen(n.etudiant_id,e.examen_id,n.annee_id),
moyenneeleve(n.etudiant_id,e.examen_id,n.annee_id),moypremiercls(e.classe_id,e.examen_id,n.annee_id),
moydercls(e.classe_id,e.examen_id,n.annee_id),rankmoyenne(n.etudiant_id ,e.examen_id,n.annee_id),
rankmat(n.etudiant_id  ,e.matiere_id,e.examen_id,n.annee_id),moygencls(e.classe_id,e.examen_id,n.annee_id),
nbremoycls(e.classe_id,e.examen_id,n.annee_id),((nbremoycls(e.classe_id,e.examen_id,n.annee_id) *100)/nbreelevecls(e.classe_id,n.annee_id)),
ecarttypemoy(e.classe_id,e.examen_id,n.annee_id),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
 FROM e_note_mat e, e_notedlt n
 where e.id=n.el_note_id;
 
 -- helper generate bulletin
CREATE VIEW e_zview_helper(ID,EXAMEN_ID,ETUDIANT_ID,CLASSE_ID,MOY, ANNEE_ID,TYPE_EXAMEN)
AS
SELECT e.etudiant_id+x.id+m.classe_id,x.id, e.etudiant_id,m.classe_id, sum(e.note*c.coef)/sum(c.coef), e.annee_id,x.libelle
from  e_notedlt e , e_note_mat m , e_coefmatdtl c , e_examen x
where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id
group by e.etudiant_id ,x.id,e.annee_id ;

-- bulletin global all eleve
CREATE VIEW e_zview_bulletin(ID,INS_ID,ELEVE_ID,CLASSE_ID,CYCLE_ID,ANNEE_ID,COEF_ID,MAT_ID,EXAMEN_ID,
NOTE1,NOTE2,NOTE3,NOTE4,NOTE5,NOTE6,
MOY_CLA_MATIERE,EXTR_MAX_MAT,EXTR_MIN_MAT,
MOY1,MOY2,MOY3,MOY4,MOY5,MOY6,RANG_MAT,
RANG_MOY,MOY_GEN_CLS,MOY_PREMIER,MOY_DERNIER,NBRE_MOY,NBRE_ELVE,TX_REU,TOTAL_POINT,TOTAL_COEF,
RANG1,RANG2,RANG3,RANG4,RANG5,RANG6,ECART_TYPE,APP_MAT, APP,SANCTION,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
select (i.id+i.eleve_id+i.classe_id+n.id), i.id ,i.eleve_id, i.classe_id,i.cycle_id, i.annee_id, mat.id , mat.matiere_id , e.examen_id,
IFNULL(notemat(i.id ,mat.matiere_id,'0',i.annee_id), 0),IFNULL(notemat(i.id ,mat.matiere_id,'1',i.annee_id), 0) ,
IFNULL(notemat(i.id ,mat.matiere_id,'2',i.annee_id), 0) ,IFNULL(notemat(i.id ,mat.matiere_id,'3',i.annee_id), 0) ,
IFNULL(notemat(i.id ,mat.matiere_id,'4',i.annee_id), 0) ,IFNULL(notemat(i.id ,mat.matiere_id,'5',i.annee_id), 0) ,

IFNULL(moyclsmat(e.id,i.annee_id), 0) ,IFNULL(extrememax(e.id,i.annee_id), 0) ,IFNULL(extrememin(e.id,i.annee_id), 0),
IFNULL(moyeleseq(i.id,'0',i.annee_id), 0),IFNULL(moyeleseq(i.id,'1',i.annee_id), 0),
IFNULL(moyeleseq(i.id,'2',i.annee_id), 0),IFNULL(moyeleseq(i.id,'3',i.annee_id), 0),IFNULL(moyeleseq(i.id,'4',i.annee_id), 0) ,
IFNULL(moyeleseq(i.id,'5',i.annee_id), 0),rankmat(i.id ,mat.matiere_id,e.examen_id,i.annee_id),
rankmoyenne(i.id ,e.examen_id,i.annee_id),
moygencls(i.classe_id,e.examen_id,i.annee_id),moypremiercls(i.classe_id,e.examen_id,i.annee_id),
moydercls(i.classe_id,e.examen_id,i.annee_id),nbremoycls(i.classe_id,e.examen_id,i.annee_id),nbreelevecls(i.classe_id,i.annee_id),
((nbremoycls(i.classe_id,e.examen_id,i.annee_id) *100)/nbreelevecls(i.classe_id,i.annee_id)),
totalpointexamen(i.id,e.examen_id,i.annee_id), totalcoefexamen(i.id,e.examen_id,i.annee_id),
rankseqn(i.id ,'0',i.annee_id),rankseqn(i.id ,'1',i.annee_id),rankseqn(i.id ,'2',i.annee_id),rankseqn(i.id ,'3',i.annee_id),
rankseqn(i.id ,'4',i.annee_id),rankseqn(i.id ,'5',i.annee_id),ecarttypemoy(i.classe_id,e.examen_id,i.annee_id),
n.APPRECIATION,appreciation(e.examen_id,i.id,i.annee_id),
santion(e.examen_id,i.id,i.annee_id),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
from e_inscription i, e_coefmatdtl mat,e_note_mat e, e_notedlt n
where i.id=n.etudiant_id
and e.id=n.el_note_id
and mat.matiere_id=e.matiere_id

CREATE VIEW e_zview_paiement(ID,TOTAL_TTC,MNT_PAYER,DATE_PAI,SER_ID,ELEVE_ID,CLASSE_ID,CYCLE_ID,TYP_PAI,ANNEE_ID,REMISE,RISTOURNE,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT p.ID,p.zmnt,p.zmnt_verser,p.date_pai,p.F_ID,i.id, c.id, cy.id,p.typ_pai,p.annee_id,p.zremise,p.zristourne,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_p_paie p ,e_inscription i , e_classe c, e_filiere f, e_cycle cy
where p.eleve_id=i.id
and i.classe_id=c.id
and c.filiere_id=f.id
and f.cycle_id=cy.id ;

-- help select prof classe
CREATE VIEW e_zview_profclasse(ID,PROF_ID,CLASSE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT c.id, c.prof_id,c.classe_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
from   e_coefmatdtl c 
where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id
group by e.etudiant_id ,x.id,e.annee_id ;

CREATE VIEW e_zview_emarg(ID,JOUR_ID,CLASSE_ID,TH_ID,ANNEE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT j.id+e.id, j.id, j.classe_id, j.annee_id, e.id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
from   e_th_cours e , e_jcours  j
where j.id= e.TRANCHE_COURS_ID;

CREATE VIEW e_zview_eleve(ID,FICHE_ID,INS_ID,EFF,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT f.id+i.id,f.id,i.id,IFNULL(montantfraisclasse('NI','0',i.eleve_id,i.classe_id,i.annee_id),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_p_fiche f, e_inscription i
where i.id=f.fiche_paie_id;

CREATE VIEW e_zview_retard(ID,eleve_id,classe_id,service_id,FICHE_ID,DELAI,PAYER,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE)
AS
SELECT i.id, i.id,i.classe_id,f.ser_id,f.id,f.delai,f.payer,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0
FROM e_inscription i , e_p_fiche f
where i.id=f.fiche_paie_id ;

-- rank par classe sur la moyenne
DELIMITER $$
CREATE FUNCTION `rankseqn`(eleve BIGINT(20),examen varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(moy,(select GROUP_CONCAT(moy ORDER BY moy DESC) FROM e_zview_helper e where e.type_examen=examen  and annee_id=exercice)) into valeur from e_zview_helper e
		where e.type_examen=examen and e.etudiant_id=eleve and annee_id=exercice;
	return valeur ;

end $$

DELIMITER ;

--- moyennee sequence id 
DELIMITER $$
CREATE FUNCTION `appreciation`(examen BIGINT(20),eleve BIGINT(20),exercice varchar(255)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT appre into valeur FROM e_bul e where examen_id=examen and INSCRIPTION_ID=eleve;

		return valeur ;

end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `sanction`(examen BIGINT(20),eleve BIGINT(20),exercice varchar(255)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT sanction into valeur FROM e_bul e where examen_id=examen and INSCRIPTION_ID=eleve;

		return valeur ;

end $$

DELIMITER ;


--- moyennee sequence id 
DELIMITER $$
CREATE FUNCTION `moyeleseqnote`(param BIGINT(20),seq varchar(255),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef)/sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c 
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param and e.annee_id=exercice and  m.examen_id=seq;

		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;

DELIMITER $$

CREATE  FUNCTION `montantfrais`(etat varchar(255),param varchar(255), code varchar(255), exercice varchar(255)) RETURNS decimal(38,0)
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
       then    select sum(e.SOLDE) into valeur FROM e_inscription e, e_classe c where  e.classe_id=c.id and c.libelle=code and e.annee_id=exercice;
        return valeur ;
        elseif etat='Re'
       then    select sum(e.REMISE) into valeur FROM e_inscription e ,e_classe c where e.classe_id=c.id and e.annee_id=exercice and c.libelle=code;
        return valeur ;
        elseif etat='Ri'
       then    select sum(e.RISTOURNE) into valeur FROM e_inscription e ,e_classe c where e.classe_id=c.id and e.annee_id=exercice and c.libelle=code;
        return valeur ;
       elseif etat='TA'
       then    select sum(e.total) into valeur FROM e_inscription e, e_classe c where  e.classe_id=c.id and c.libelle=code and e.annee_id=exercice;
        return valeur ;
       elseif etat='TR'
       then    select sum(e.MNT_PAYE) into valeur FROM e_inscription e, e_classe c where  e.classe_id=c.id and c.libelle=code and e.annee_id=exercice;
        return valeur ;
       elseif etat='NS'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=code and i.SOLDE <=0 and i.annee_id=exercice ;
        return valeur ;
        elseif etat='NI'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=code and i.annee_id=exercice;
        return valeur ;
       else return valeur ;
       end if ;
end $$

DELIMITER ;

DELIMITER $$

CREATE  FUNCTION `montantfraisclasse`(etat varchar(255),param varchar(255), code decimal(38,0),classeid varchar(255), exercice varchar(255)) RETURNS decimal(38,0)
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
       then    select sum(e.SOLDE) into valeur FROM e_inscription e where  e.eleve_id=code and e.annee_id=exercice;
        return valeur ;
        elseif etat='Re'
       then    select sum(e.REMISE) into valeur FROM e_inscription e where e.eleve_id=code and e.annee_id=exercice;
        return valeur ;
        elseif etat='Ri'
       then    select sum(e.RISTOURNE) into valeur FROM e_inscription e where e.eleve_id=code and e.annee_id=exercice;
        return valeur ;
       elseif etat='TA'
       then    select sum(e.total) into valeur FROM e_inscription e where  e.eleve_id=code and e.annee_id=exercice;
        return valeur ;
       elseif etat='TR'
       then    select sum(e.MNT_PAYE) into valeur FROM e_inscription e where  e.eleve_id=code and e.annee_id=exercice;
	    return valeur ;
       elseif etat='NS'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=classeid and i.SOLDE <=0 and i.annee_id=exercice ;
        return valeur ;
        elseif etat='NI'
       then    select count(i.id) into valeur FROM e_inscription i, e_classe c where i.classe_id=c.id and c.libelle=classeid and i.annee_id=exercice;
        return valeur ;
       else return valeur ;
       end if ;
end $$

DELIMITER ;

DELIMITER $$

CREATE  FUNCTION `montantfraistotal`(etat varchar(255),param varchar(255), exercice varchar(255)) RETURNS decimal(38,0)
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
       then    select sum(e.REMISE) into valeur FROM e_inscription e where e.annee_id=exercice;
        return valeur ;
        elseif etat='Ri'
       then    select sum(e.RISTOURNE) into valeur FROM e_inscription e where e.annee_id=exercice;
        return valeur ;
       elseif etat='TA'
       then    select sum(e.total) into valeur FROM e_inscription e where e.annee_id=exercice;
        return valeur ;
       elseif etat='TR'
       then    select sum(e.MNT_PAYE) into valeur FROM  e_inscription e where  e.annee_id=exercice;
        return valeur ;
       elseif etat='TS'
       then    select sum(e.SOLDE) into valeur FROM e_inscription e where  e.annee_id=exercice;
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
end $$

DELIMITER ;
---  nombre eleve classe 
DELIMITER $$
CREATE FUNCTION `nbreelevecls`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT count(e.id) into valeur from  e_inscription e where e.classe_id=param and e.annee_id=exercice ;
		return valeur ;

end $$

DELIMITER ;

--ecarttype 
DELIMITER $$
CREATE FUNCTION `ecarttypemoy`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT std(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen ;
		return valeur ;

end $$

DELIMITER ;

---  nombre de moyenne  classe 
DELIMITER $$
CREATE FUNCTION `nbremoycls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT count(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen and e.moy>=10;
		return valeur ;

end $$

DELIMITER ;


--- moyenne premier classe  examen
DELIMITER $$
CREATE FUNCTION `moypremiercls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT max(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen;
		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;



--- moyenne premier classe  examen
DELIMITER $$
CREATE FUNCTION `moydercls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT min(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen;
		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;


--- moyenne eleve
DELIMITER $$
CREATE FUNCTION `moyenneeleve`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT e.moy into valeur from  e_zview_helper e where e.etudiant_id=param and e.annee_id=exercice and e.examen_id=examen;
		return  TRUNCATE(valeur,3);

end $$

DELIMITER ;

--- moyenne general classe 
DELIMITER $$
CREATE FUNCTION `moygencls`(param BIGINT(20), examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT avg(e.moy) into valeur from  e_zview_helper e where e.classe_id=param and e.annee_id=exercice and e.examen_id=examen;
		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;

-- rank par classe sur la moyenne
DELIMITER $$
CREATE FUNCTION `rankmoyenne`(eleve BIGINT(20),examen varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(moy,(select GROUP_CONCAT(moy ORDER BY moy DESC) FROM e_zview_helper e where e.examen_id=examen  and annee_id=exercice)) into valeur from e_zview_helper e
		where e.examen_id=examen and e.etudiant_id=eleve and annee_id=exercice;
	return valeur ;

end $$

DELIMITER ;

-- rank par matiere
DELIMITER $$
CREATE FUNCTION `rankmat`(eleve BIGINT(20),matiere BIGINT(20),seq varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(note,(select GROUP_CONCAT(note ORDER BY note DESC)  FROM e_notedlt e, e_note_mat m , e_examen x
			where e.el_note_id=m.id and m.examen_id=x.id and m.examen_id=seq and m.matiere_id=matiere  and e.annee_id=exercice) ) into valeur from e_notedlt e, e_note_mat m , e_examen x
				where e.el_note_id=m.id and m.examen_id=x.id and m.examen_id=seq and m.matiere_id=matiere and e.etudiant_id=eleve and e.annee_id=exercice;
		return valeur ;

end $$

DELIMITER ;

-- note eleve matiere
DELIMITER $$
CREATE FUNCTION `notemat`(eleve BIGINT(20),matiere BIGINT(20),examen varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT n.note into valeur  from e_note_mat e , e_notedlt n, e_examen x where e.id= n.el_note_id and e.examen_id=x.id
         and n.etudiant_id= eleve and matiere_id=matiere and x.libelle=examen and annee_id=exercice;

		return valeur ;

end $$

DELIMITER ;

--- moyenne classe /matiere
DELIMITER $$
CREATE FUNCTION `moyclsmat`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT avg(n.note) into valeur from  e_notedlt n where n.el_note_id=param and n.annee_id=exercice;

		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;
--- extreme maximun
DELIMITER $$
CREATE FUNCTION `extrememax`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT max(n.note) into valeur from  e_notedlt n where n.el_note_id=param and n.annee_id=exercice;

		return valeur ;

end $$

DELIMITER ;

--- extreme min
DELIMITER $$
CREATE FUNCTION `extrememin`(param BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT min(n.note) into valeur from  e_notedlt n where n.el_note_id=param and n.annee_id=exercice;

		return valeur ;

end $$

DELIMITER ;

--- total des point avec coef
DELIMITER $$
CREATE FUNCTION `totalpointexamen`(param BIGINT(20),examen BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param and e.annee_id=exercice and m.examen_id=examen;

		return valeur ;

end $$

DELIMITER ;

--- total  coef
DELIMITER $$
CREATE FUNCTION `totalcoefexamen`(param BIGINT(20),examen BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param and e.annee_id=exercice and m.examen_id=examen;

		return valeur ;

end $$

DELIMITER ;


--- total  coef
DELIMITER $$
CREATE FUNCTION `moyeleseq`(param BIGINT(20),seq varchar(255),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef)/sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c , e_examen x
		where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id   and e.etudiant_id=param and e.annee_id=exercice and x.libelle=seq;

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

--init paiement
delete from e_p_paie;
delete from e_p_rgl ;
update e_inscription set remise=0;
update e_inscription set mnt_paye=0;
update e_inscription set solde =mnt;
update e_p_fiche set solde = m_ht ;
update e_p_fiche set mnt_payer=0;
update e_p_fiche set payer=0;
-- delete classe
delete FROM e_p_rgl  where el_id=43;
delete FROM e_p_paie  where eleve_id=43;
delete FROM e_p_fiche  where fiche_paie_id=43 ;
delete FROM e_inscription  where id=43;
delete FROM e_classe  where id=29;

-- update date paiement 
UPDATE e_p_fiche as e
SET e.delai = ( select delai from e_service s where s.id = e.ser_id) ;

UPDATE e_inscription as e
SET e.nom = ( select nom from e_eleve s where s.id = e.eleve_id) ;

UPDATE e_inscription as e
SET e.matricule = ( select matricule from e_eleve s where s.id = e.eleve_id) ;

UPDATE e_p_paie as e
SET e.matricule = ( select s.matricule from e_eleve s, e_inscription i where i.id = e.eleve_id and s.id=i.eleve_id) ;

UPDATE e_p_paie as e
SET e.nom = ( select s.nom from e_eleve s, e_inscription i where i.id = e.eleve_id and s.id=i.eleve_id) ;

UPDATE e_p_paie as e
SET e.classe = ( select c.libelle from  e_inscription i, e_classe c where i.id = e.eleve_id and i.classe_id=c.id) ;
