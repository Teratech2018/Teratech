--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
--- --- --- --- --- --- --- --- LEW VUES --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
------- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---
------------------------ DEBUT VUE SCOLARITE----------------------------------------------------------
DROP TABLE IF EXISTS e_zview_paiement ;
DROP TABLE IF EXISTS e_zview_bf_ecole ;
DROP TABLE IF EXISTS e_zview_bf ;
DROP TABLE  IF EXISTS e_zview_dashboard;
DROP TABLE IF EXISTS e_zview_note_helper;

DROP VIEW IF EXISTS e_zview_paiement ;
CREATE VIEW e_zview_paiement(ID,TOTAL_TTC,MNT_PAYER,DATE_PAI,SER_ID,ELEVE_ID,CLASSE_ID,CYCLE_ID,TYP_PAI,ANNEE_ID,REMISE,RISTOURNE,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT p.ID,p.zmnt,p.zmnt_verser,p.date_pai,p.F_ID,i.id, c.id, cy.id,p.typ_pai,p.annee_id,p.zremise,p.zristourne,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_p_paie p ,e_inscription i , e_classe c, e_filiere f, e_cycle cy
where p.eleve_id=i.id
and i.classe_id=c.id
and c.filiere_id=f.id
and f.cycle_id=cy.id ;

DROP VIEW IF EXISTS e_zview_bf_ecole ;
CREATE VIEW e_zview_bf_ecole(ID,CLASSE_ID,INSCRIPTION,INSCRIPTION_ENC,I_TRAN,I_TRAN_ENC,II_TRAN,II_TRAN_ENC,III_TRAN,
III_TRAN_ENC,REMISE,RISTOURNE,TOTAL_A,TOTAL_R,SOLDE,TX_RECO,CYCLE_ID,EFF,EFF_SOL,ANNEE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT e.ID,c.id,IFNULL(montantfrais('A','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('R','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('A','1',c.libelle,i.annee_id), 0),
IFNULL(montantfrais('R','1',c.libelle,i.annee_id), 0),IFNULL(montantfrais('A','2',c.libelle,i.annee_id), 0),IFNULL(montantfrais('R','2',c.libelle,i.annee_id), 0),IFNULL(montantfrais('A','3',c.libelle,i.annee_id), 0),
IFNULL(montantfrais('R','3',c.libelle,i.annee_id), 0),IFNULL(montantfrais('Re','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('Ri','0',c.libelle,i.annee_id), 0),
IFNULL(montantfrais('TA','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('TR','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('S','0',c.libelle,i.annee_id), 0),
ROUND(IFNULL(montantfrais('TR','0',c.libelle,i.annee_id), 0)/IFNULL(montantfrais('TA','0',c.libelle,i.annee_id), 0)*100,2),cy.id,
IFNULL(montantfrais('NI','0',c.libelle,i.annee_id), 0),IFNULL(montantfrais('NS','0',c.libelle,i.annee_id), 0),i.annee_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_p_fiche e, e_service s,e_inscription i, e_classe c, e_filiere f, e_cycle cy
where e.ser_id=s.id
and e.fiche_paie_id=i.id
and i.classe_id=c.id
and c.FILIERE_ID=f.id
and f.CYCLE_ID=cy.id
group by c.id ,i.annee_id;

DROP VIEW   IF EXISTS e_zview_bf ;
CREATE VIEW e_zview_bf(ID,CLASSE_ID,ELEVE_ID,INSCRIPTION_ENC,I_TRAN_ENC,II_TRAN_ENC,III_TRAN_ENC,REMISE,RISTOURNE,
TOTAL_A,TOTAL_R,SOLDE,CYCLE_ID,EFF,EFF_SOL,ANNEE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT e.ID,c.id,i.eleve_id,IFNULL(montantfraisclasse('R','0',i.eleve_id,c.libelle,i.annee_id), 0),IFNULL(montantfraisclasse('R','1',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('R','2',i.eleve_id,c.libelle,i.annee_id), 0),IFNULL(montantfraisclasse('R','3',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('Re','0',i.eleve_id,c.libelle,i.annee_id), 0),IFNULL(montantfraisclasse('Ri','0',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('TA','0',i.eleve_id,c.libelle,i.annee_id), 0),(IFNULL(montantfraisclasse('TR','0',i.eleve_id,c.libelle,i.annee_id), 0)),
IFNULL(montantfraisclasse('S','0',i.eleve_id,c.libelle,i.annee_id), 0),cy.id,IFNULL(montantfraisclasse('NI','0',i.eleve_id,c.libelle,i.annee_id), 0),
IFNULL(montantfraisclasse('NS','0',i.eleve_id,c.libelle,i.annee_id), 0),i.annee_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_p_fiche e, e_service s,e_inscription i, e_classe c, e_filiere f, e_cycle cy
where e.ser_id=s.id
and e.fiche_paie_id=i.id
and i.classe_id=c.id
and c.FILIERE_ID=f.id
and f.CYCLE_ID=cy.id
group by i.eleve_id ,i.annee_id;

DROP VIEW  IF EXISTS e_zview_dashboard;
CREATE VIEW e_zview_dashboard(ID,N_ELEVE,N_ELEVE_INS,N_ELEVE_T1,N_ELEVE_T2,N_ELEVE_T3,N_ELEVE_S,
PRE_G,ENC_G,SOLD_G,PRE_I,ENC_I,SOLD_I,PRE_T1,ENC_T1,SOLD_T1,PRE_T2,ENC_T2,SOLD_T2,PRE_T3,ENC_T3,SOLD_T3,ANNEE_ID,TX_REU,NBRE_ADMIS,REMISE_G,RISTOURNE_G,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT e.id,IFNULL(montantfraistotal('NE','0',i.annee_id), 0),IFNULL(montantfraistotal('NI','0',i.annee_id), 0),IFNULL(montantfraistotal('NS123','1',i.annee_id), 0),IFNULL(montantfraistotal('NS123','2',i.annee_id), 0),
IFNULL(montantfraistotal('NS123','3',i.annee_id), 0),IFNULL(montantfraistotal('NS','0',i.annee_id), 0),
IFNULL(montantfraistotal('TA','0',i.annee_id), 0),IFNULL(montantfraistotal('TR','0',i.annee_id), 0),IFNULL(montantfraistotal('TS','0',i.annee_id), 0),
IFNULL(montantfraistotal('A','0',i.annee_id), 0),IFNULL(montantfraistotal('R','0',i.annee_id), 0),IFNULL(montantfraistotal('S','0',i.annee_id), 0),
IFNULL(montantfraistotal('A','1',i.annee_id), 0),IFNULL(montantfraistotal('R','1',i.annee_id), 0),IFNULL(montantfraistotal('S','1',i.annee_id), 0),
IFNULL(montantfraistotal('A','2',i.annee_id), 0),IFNULL(montantfraistotal('R','2',i.annee_id), 0),IFNULL(montantfraistotal('S','2',i.annee_id), 0),
IFNULL(montantfraistotal('A','3',i.annee_id), 0),IFNULL(montantfraistotal('R','3',i.annee_id), 0),IFNULL(montantfraistotal('S','3',i.annee_id), 0),i.annee_id,0,0,IFNULL(montantfraistotal('Re','3',i.annee_id), 0),
IFNULL(montantfraistotal('Ri','3',i.annee_id), 0),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_p_fiche e , e_inscription i
where e.fiche_paie_id=i.id
group by i.annee_id;

DROP VIEW  IF EXISTS e_zview_eleve;
CREATE VIEW e_zview_eleve(ID,FICHE_ID,INS_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT concat(f.id,i.id),f.id,i.id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_p_fiche f, e_inscription i
where i.id=f.fiche_paie_id;

DROP VIEW IF EXISTS e_zview_retard;
CREATE VIEW e_zview_retard(ID,eleve_id,classe_id,service_id,FICHE_ID,DELAI,PAYER,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT concat(f.id,i.id,f.ser_id), i.id,i.classe_id,f.ser_id,f.id,f.delai,f.payer,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_inscription i , e_p_fiche f
where i.id=f.fiche_paie_id ;


------------------------ FIN VUE SCOLARITE----------------------------------------------------------

------------------------ DEBUT VUE PEDAGOGIQUE----------------------------------------------------------
 
DROP VIEW IF EXISTS e_zview_note_helper;
CREATE VIEW e_zview_note_helper(ID,MAT_NOTE_ID,CLASSE_ID,EXAMEN_ID,MATIERE_ID,NOTE_ID,ELEVE_ID,NOTE,NOTE1,NOTE2,NOTE3,
NOTET1,NOTET2,NOTET3,NOTEAN,
APPRECIATION,MOY_CLA_MATIERE,EXTR_MAX,EXTR_MIN,TOTAL_POINT,TOTAL_COEF,MOY_ETUDIANT,MOY_PREMIER,MOY_DERNIER,RANG,
RANG_MAT,MOY_GEN_CLS,NBRE_MOY,TX_REU,ECART_TYPE,NBRE_ELEVE,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT concat(e.id,n.id,e.examen_id), e.id, e.classe_id,e.examen_id,e.matiere_id,n.id,n.etudiant_id,n.note,n.note_1,n.note_2,n.note_3,
Truncate(n.notet1,2),truncate(n.notet2,2),truncate(n.notet3,2),truncate(n.noteann,2),n.appreciation,truncate(n.moymatcls,2),extremax,n.extremin,
IFNULL(totalpointexamen(n.etudiant_id,e.examen_id,n.annee_id),0.01),IFNULL(totalcoefexamen(n.etudiant_id,e.examen_id,n.annee_id),0.01),
IFNULL(moyelehelper(n.etudiant_id,e.examen_id,n.annee_id),0.01),moypremiercls(e.classe_id,e.examen_id,n.annee_id),
moydercls(e.classe_id,e.examen_id,n.annee_id),IFNULL(rankmoyenne(n.etudiant_id ,e.examen_id,n.annee_id,e.classe_id),0),
rankmat(n.etudiant_id  ,e.matiere_id,e.examen_id,n.annee_id),moygencls(e.classe_id,e.examen_id,n.annee_id),
nbremoycls(e.classe_id,e.examen_id,n.annee_id),((nbremoycls(e.classe_id,e.examen_id,n.annee_id) *100)/nbreelevecls(e.classe_id,n.annee_id)),
ecarttypemoy(e.classe_id,e.examen_id,n.annee_id),nbreelevecls(e.classe_id,n.annee_id),
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
 FROM e_note_mat e, e_notedlt n
 where e.id=n.el_note_id  and n.note !=0;
 
DROP VIEW IF EXISTS  e_zview_helper;
CREATE VIEW e_zview_helper(ID,EXAMEN_ID,ETUDIANT_ID,CLASSE_ID,MOY, ANNEE_ID,TYPE_EXAMEN,MOY1)
AS
SELECT concat(e.etudiant_id,x.id,m.classe_id),x.id, e.etudiant_id,m.classe_id,ifnull((sum((e.note *c.coef)) / sum(c.coef)),0.01), e.annee_id,x.libelle,
moyelehelperT(e.etudiant_id,e.annee_id,'T1')
from  e_notedlt e , e_note_mat m , e_coefmatdtl c , e_examen x
where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id and e.note !=0
group by e.etudiant_id ,x.id,e.annee_id ;


DROP VIEW  IF EXISTS e_zview_helper_bull ;
CREATE VIEW e_zview_helper_bull(ID,INS_ID,BULL_ID,CLASSE_ID,ANNEE_ID,MOYT1,MOYT2,MOYT3,MOYAN,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT concat( e.INSCRIPTION_ID),e.INSCRIPTION_ID,e.id, e.cls_id, e.annee_id,
Truncate((IFNULL(moyeleseqbul(e.INSCRIPTION_ID ,'0',e.annee_id),0)+IFNULL(moyeleseqbul(e.INSCRIPTION_ID ,'1',e.annee_id),0))/2,2) as MOYT1,
Truncate((IFNULL(moyeleseqbul(e.INSCRIPTION_ID ,'2',e.annee_id),0)+IFNULL(moyeleseqbul(e.INSCRIPTION_ID ,'3',e.annee_id),0))/2,2) as MOYT2,
Truncate((IFNULL(moyeleseqbul(e.INSCRIPTION_ID ,'4',e.annee_id),0)+IFNULL(moyeleseqbul(e.INSCRIPTION_ID ,'5',e.annee_id),0))/2,2) as MOYT2,
0,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_bul e
group by e.INSCRIPTION_ID;

DROP VIEW IF EXISTS  e_zview_helper_ligne ;
CREATE VIEW e_zview_helper_ligne(ID,INS_ID,CLASSE_ID,BULL_ID,LGN_ID, MAT_ID,ANNEE_ID,NOTET1,NOTET2,NOTET3,NOTEAN,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT concat(e.id, e.INSCRIPTION_ID,l.id), e.INSCRIPTION_ID, e.cls_id, e.id,l.id, l.mat_id,  e.annee_id,
Truncate((IFNULL(notematbul(e.INSCRIPTION_ID ,l.mat_id,'0',e.annee_id),0)+IFNULL(notematbul(e.INSCRIPTION_ID ,l.mat_id,'1',e.annee_id),0))/2,2) as NOTET1,
Truncate((IFNULL(notematbul(e.INSCRIPTION_ID ,l.mat_id,'2',e.annee_id),0)+IFNULL(notematbul(e.INSCRIPTION_ID ,l.mat_id,'3',e.annee_id),0))/2,2) as NOTET2,
Truncate((IFNULL(notematbul(e.INSCRIPTION_ID ,l.mat_id,'4',e.annee_id),0)+IFNULL(notematbul(e.INSCRIPTION_ID ,l.mat_id,'5',e.annee_id),0))/2,2) as NOTET3,
0,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_bul e ,  e_bul_lgn l
where e.id=l.lgn_bul_id
group by mat_id ,e.inscription_id;

DROP VIEW IF EXISTS e_zview_bulletin ;
CREATE VIEW e_zview_bulletin(ID,LGN_ID, BULL_ID,INS_ID,ELEVE_ID,CLASSE_ID,EXAMEN_ID,MOY,RANG,
NOTE1,NOTE2,NOTE3,NOTE4,NOTE5,NOTE6,
MOY1,MOY2,MOY3,MOY4,MOY5,MOY6,RANG1,RANG2,RANG3,RANG4,RANG5,RANG6,
APPS,ABS_ID, RANGT1,RANGT2, RANGT3,
NBMOYT1,ECARTT1,MINMOYT1,MYGENT1,MAXMOYT1,
NBMOYT2,ECARTT2,MINMOYT2,MYGENT2,MAXMOYT2,
NBMOYT3,ECARTT3,MINMOYT3,MYGENT3,MAXMOYT3,ANNEE_ID,
RANKMATT1,RANKMATT2,RANKMATT3,
MOYMATT1,MOYMATT2,MOYMATT3,
APPMOY1,APPT1,APPT2,APPT3,
ABST0,ABST1,ABST2,ABST3,ABST4,ABST5,
TCOEFS1,TCOEFS2,TCOEFS3,TCOEFS4,TCOEFS5,TCOEFS6,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT concat(e.id,l.id,e.examen_id),l.id, e.id, e.INSCRIPTION_ID,e.INS_ID, e.cls_id, e.examen_id, e.moyenne,e.rang ,
notematbul(e.INSCRIPTION_ID ,l.mat_id,'0',e.annee_id), notematbul(e.INSCRIPTION_ID ,l.mat_id,'1',e.annee_id),
notematbul(e.INSCRIPTION_ID ,l.mat_id,'2',e.annee_id), notematbul(e.INSCRIPTION_ID ,l.mat_id,'3',e.annee_id),
notematbul(e.INSCRIPTION_ID ,l.mat_id,'4',e.annee_id), notematbul(e.INSCRIPTION_ID ,l.mat_id,'5',e.annee_id),

moyeleseqbul(e.INSCRIPTION_ID ,'0',e.annee_id),moyeleseqbul(e.INSCRIPTION_ID ,'1',e.annee_id),moyeleseqbul(e.INSCRIPTION_ID ,'2',e.annee_id),
moyeleseqbul(e.INSCRIPTION_ID ,'3',e.annee_id),moyeleseqbul(e.INSCRIPTION_ID ,'4',e.annee_id),moyeleseqbul(e.INSCRIPTION_ID ,'5',e.annee_id),

rankseqnbul(e.INSCRIPTION_ID ,'0',e.cls_id,e.annee_id),rankseqnbul(e.INSCRIPTION_ID ,'1',e.cls_id,e.annee_id),
rankseqnbul(e.INSCRIPTION_ID ,'2',e.cls_id,e.annee_id),rankseqnbul(e.INSCRIPTION_ID ,'3',e.cls_id,e.annee_id),
rankseqnbul(e.INSCRIPTION_ID ,'4',e.cls_id,e.annee_id),rankseqnbul(e.INSCRIPTION_ID ,'5',e.cls_id,e.annee_id),
appreciationbull(e.moyenne),abscence(e.examen_id,e.INSCRIPTION_ID,e.annee_id),

rankmoyennebull(e.INSCRIPTION_ID ,e.annee_id,e.cls_id,'T1'),rankmoyennebull(e.INSCRIPTION_ID ,e.annee_id,e.cls_id,'T2'),
rankmoyennebull(e.INSCRIPTION_ID ,e.annee_id,e.cls_id,'T3'),

nbremoyclsbull(e.annee_id,e.cls_id,'T1'),ecarttypemoybull(e.annee_id,e.cls_id,'T1'),moyderclsbull(e.annee_id,e.cls_id,'T1'),
moygenclsbull(e.annee_id,e.cls_id,'T1'),moypremierclsbull(e.annee_id,e.cls_id,'T1'),

nbremoyclsbull(e.annee_id,e.cls_id,'T2'),ecarttypemoybull(e.annee_id,e.cls_id,'T2'),moyderclsbull(e.annee_id,e.cls_id,'T2'),
moygenclsbull(e.annee_id,e.cls_id,'T2'),moypremierclsbull(e.annee_id,e.cls_id,'T2'),

nbremoyclsbull(e.annee_id,e.cls_id,'T3'),ecarttypemoybull(e.annee_id,e.cls_id,'T3'),moyderclsbull(e.annee_id,e.cls_id,'T3'),
moygenclsbull(e.annee_id,e.cls_id,'T3'),moypremierclsbull(e.annee_id,e.cls_id,'T3'),e.annee_id,

rankmatbull(e.inscription_id,e.annee_id,e.cls_id,'T1',l.mat_id),rankmatbull(e.inscription_id,e.annee_id,e.cls_id,'T2',l.mat_id),
rankmatbull(e.inscription_id,e.annee_id,e.cls_id,'T3',l.mat_id),

moygenmatbull(e.annee_id,e.cls_id,'T1',l.mat_id ),
moygenmatbull(e.annee_id,e.cls_id,'T2',l.mat_id ),moygenmatbull(e.annee_id,e.cls_id,'T3',l.mat_id ),

appreciationmatbull(e.moyt1),appreciationmatbull(l.notet1),appreciationmatbull(l.notet2),appreciationmatbull(l.notet3),
abscencebull('0',e.inscription_id ,e.annee_id),abscencebull('1',e.inscription_id ,e.annee_id),
abscencebull('2',e.inscription_id ,e.annee_id),abscencebull('3',e.inscription_id ,e.annee_id),
abscencebull('4',e.inscription_id ,e.annee_id),abscencebull('5',e.inscription_id ,e.annee_id),

IFNULL(totalcoefexamenseq(e.inscription_id,'0',e.annee_id),0),IFNULL(totalcoefexamenseq(e.inscription_id,'1',e.annee_id),0),
IFNULL(totalcoefexamenseq(e.inscription_id,'2',e.annee_id),0),IFNULL(totalcoefexamenseq(e.inscription_id,'3',e.annee_id),0),
IFNULL(totalcoefexamenseq(e.inscription_id,'4',e.annee_id),0),IFNULL(totalcoefexamenseq(e.inscription_id,'5',e.annee_id),0),

"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
FROM e_bul e ,  e_bul_lgn l
where e.id=l.lgn_bul_id ;

DROP VIEW IF EXISTS e_zview_abs ;
CREATE VIEW e_zview_abs(ID,PERI_ID,CLASSE_ID,LIGNE_ID,ANNEE_ID,ETAT,ELEVE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT concat(e.id,l.id,e.peri_id), e.peri_id, e.classe_id, l.id,e.annee_id, e.etat,l.eleve_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
from   e_abs e , e_abs_lgn l
where e.id= l.ID_ABS;

DROP VIEW e_zview_note_matiere ;
CREATE VIEW e_zview_note_matiere(ID,MAT_NOTE_ID,CLASSE_ID,EXAMEN_ID,MATIERE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT e.id+n.id, e.id, e.classe_id,e.examen_id,e.matiere_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
 FROM e_note_mat e, e_notedlt n
 where e.id=n.el_note_id;
 
 DROP VIEW IF EXISTS e_zview_note_module ;
 CREATE VIEW e_zview_note_module(ID,MAT_NOTE_ID,CLASSE_ID,EXAMEN_ID,MODULE_ID,
DESIGNATION,EDITTITLE,LISTTITLE,MODULENAME,CREATEONFIELD,COMPAREID,SELECTED,DESABLECREATE,ACTIVATEFOLLOWER,ACTIVEFILELIEN,DESABLEDELETE,FOOTERSCRIPT,SERIAL,
DESABLEUPDATE,searchkeys,desabledatablock,ownermodule)
AS
SELECT e.id+n.id, e.id, e.classe_id,e.examen_id,e.module_id,
"defualt","defualt","defualt","defualt",0,0,0,0,0,0,0,"defualt","defualt",0,"","",""
 FROM e_note_mat e, e_notedlt_pr n
 where e.id=n.el_note_id;
 
 --- --- --- --- --- --- --- --- SOLDE --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
 
 --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
--- --- --- --- --- --- --- --- PROCEDURES --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
------- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---

-- rank par classe sur la moyenne
DROP FUNCTION `rankseqn`;
DELIMITER $$
CREATE FUNCTION `rankseqn`(eleve BIGINT(20),examen varchar(255), exercice varchar(255), classe BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(moy,(select GROUP_CONCAT(DISTINCT moy ORDER BY moy DESC) FROM e_zview_helper e where e.type_examen=examen  and annee_id=exercice and e.classe_id=classe )) into valeur from e_zview_helper e
		where e.type_examen=examen and e.etudiant_id=eleve and annee_id=exercice and e.classe_id=classe ;
	return valeur ;

end $$

DELIMITER ;

--- moyennee sequence id 
DROP FUNCTION  IF EXISTS`appreciation`;
DELIMITER $$
CREATE FUNCTION `appreciation`(examen BIGINT(20),eleve BIGINT(20),exercice varchar(255)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT moyenne into valeur FROM e_app e where e.i_deb<=(select moyenne from e_bul b where examen_id=examen and INSCRIPTION_ID=eleve) 
		and e.i_fin>=(select moyenne from e_bul b where b.examen_id=examen and INSCRIPTION_ID=eleve); 

		return valeur ;

end $$

DELIMITER ;

--- moyennee sequence id 
DROP FUNCTION IF EXISTS `appreciationen`;
DELIMITER $$
CREATE FUNCTION `appreciationen`(examen BIGINT(20),eleve BIGINT(20),exercice varchar(255)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT moyenne_en into valeur FROM e_app e where e.i_deb<=(select moyenne from e_bul b where examen_id=examen and INSCRIPTION_ID=eleve) 
		and e.i_fin>=(select moyenne from e_bul b where b.examen_id=examen and INSCRIPTION_ID=eleve); 

		return valeur ;

end $$

DELIMITER ;


DELIMITER $$
DROP FUNCTION IF EXISTS `sanction`;
CREATE FUNCTION `sanction`(examen BIGINT(20),eleve BIGINT(20),exercice varchar(255)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT sanction into valeur FROM e_app e where e.i_deb<=(select moyenne from e_bul b where examen_id=examen and INSCRIPTION_ID=eleve) 
		and e.i_fin>=(select moyenne from e_bul b where b.examen_id=examen and INSCRIPTION_ID=eleve);

		return valeur ;

end $$

DELIMITER ;


DELIMITER $$
DROP FUNCTION IF EXISTS `abscence`;
CREATE FUNCTION `abscence`(examen BIGINT(20),eleve BIGINT(20),exercice varchar(255)) RETURNS BIGINT(20)
begin

    DECLARE valeur BIGINT(20);
		SELECT id into valeur FROM e_zview_abs e where  e.annee_id=exercice and e.eleve_id=eleve and e.peri_id=examen;
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
CREATE FUNCTION `rankmoyenne`(eleve BIGINT(20),examen varchar(255), exercice varchar(255),classe BIGINT(20)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(moy,(select GROUP_CONCAT(DISTINCT moy ORDER BY moy DESC) FROM e_zview_helper e where e.examen_id=examen  and annee_id=exercice and e.classe_id=classe )) into valeur from e_zview_helper e
		where e.examen_id=examen and e.etudiant_id=eleve and annee_id=exercice and e.classe_id=classe ;
	return valeur ;

end $$

DELIMITER ;

-- rank par matiere(("
DELIMITER $$
CREATE FUNCTION `rankmat`(eleve BIGINT(20),matiere BIGINT(20),seq varchar(255), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	SELECT FIND_IN_SET(note,(select GROUP_CONCAT( DISTINCT note ORDER BY note DESC)  FROM e_notedlt e, e_note_mat m , e_examen x
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
         and n.etudiant_id= eleve and e.matiere_id=matiere and x.libelle=examen and n.annee_id=exercice;

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
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param and e.annee_id=exercice and m.examen_id=examen
			and e.note!=0;

		return valeur ;

end $$

DELIMITER ;

--- total  coef
DELIMITER $$
CREATE FUNCTION `totalcoefexamen`(param BIGINT(20),examen BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c
		where e.el_note_id=m.id and m.matiere_id=c.id and e.etudiant_id=param and e.annee_id=exercice and m.examen_id=examen ;
			and e.note!=0;

		return valeur ;

end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `totalcoefexamenseq`(param BIGINT(20),examen varchar(255),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c, e_examen x
		where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id and  e.etudiant_id=param 
			and e.annee_id=exercice and x.libelle=examen ;
			and e.note!=0;

		return valeur ;

end $$

DELIMITER ;


--- total  coef
DELIMITER $$
CREATE FUNCTION `moyeleseq`(param BIGINT(20),seq varchar(255),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef)/sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c , e_examen x
		where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id   and e.etudiant_id=param and e.annee_id=exercice and x.libelle=seq
		and e.note!=0;
		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;



DELIMITER $$
CREATE FUNCTION `moyelehelper`(param BIGINT(20),seq BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
		SELECT sum(e.note*c.coef)/sum(c.coef) into valeur from  e_notedlt e , e_note_mat m , e_coefmatdtl c , e_examen x
		where e.el_note_id=m.id and m.matiere_id=c.id  and m.examen_id=x.id   and e.etudiant_id=param and e.annee_id=exercice and x.id=seq
		and e.note!=0;
		return TRUNCATE(valeur,3) ;

end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `moyelehelperT`(param BIGINT(20),exercice varchar(255),trimestre varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
		then set valeur=(IFNULL(moyeleseq(param,'0',exercice),0)+IFNULL(moyeleseq(param,'1',exercice),0))/2;
	  return	TRUNCATE(valeur,3) ;
	  elseif trimestre='T2'
		then set valeur=(IFNULL(moyeleseq(param,'2',exercice),0)+IFNULL(moyeleseq(param,'3',exercice),0))/2;
	  return	TRUNCATE(valeur,3) ;
	    elseif trimestre='T3'
		then set valeur=(IFNULL(moyeleseq(param,'4',exercice),0)+IFNULL(moyeleseq(param,'5',exercice),0))/2;
	  return	TRUNCATE(valeur,3) ;
 end if ;
end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `rankmoyenneT`(eleve BIGINT(20), exercice varchar(255),classe BIGINT(20),trimestre varchar(255) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT FIND_IN_SET(moy1,(select GROUP_CONCAT(DISTINCT moy1 ORDER BY moy1 DESC) FROM e_zview_helper_trimestre e where    annee_id=exercice and e.classe_id=classe )) into valeur from e_zview_helper_trimestre e
		where e.examen_id=1 and e.etudiant_id=eleve and annee_id=exercice and e.classe_id=classe ;
	return valeur ;

	elseif trimestre='T2'
 then	SELECT FIND_IN_SET(moy2,(select GROUP_CONCAT(DISTINCT moy2 ORDER BY moy2 DESC) FROM e_zview_helper_trimestre e where    annee_id=exercice and e.classe_id=classe )) into valeur from e_zview_helper_trimestre e
		where e.examen_id=1 and e.etudiant_id=eleve and annee_id=exercice and e.classe_id=classe ;
	return valeur ;

	elseif trimestre='T3'
	then SELECT FIND_IN_SET(moy3,(select GROUP_CONCAT(DISTINCT moy3 ORDER BY moy3 DESC) FROM e_zview_helper_trimestre e where    annee_id=exercice and e.classe_id=classe )) into valeur from e_zview_helper_trimestre e
		where e.examen_id=1 and e.etudiant_id=eleve and annee_id=exercice and e.classe_id=classe ;
	return valeur ;
 end if ;	
end $$

DELIMITER ;


DELIMITER $$
CREATE FUNCTION `notematbul`(eleve BIGINT(20),matiere BIGINT(20),examen BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
    SELECT l.note into valeur from e_bul e ,  e_bul_lgn l, e_examen x where e.id=l.lgn_bul_id and e.examen_id=x.id
        and x.libelle=examen and e.INSCRIPTION_ID=eleve  and l.mat_id=matiere  and e.annee_id=exercice;

		return valeur ;

end $$

DELIMITER ;


DELIMITER $$
CREATE FUNCTION `moyeleseqbul`(eleve BIGINT(20),examen BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
    SELECT e.moyenne into valeur from e_bul e , e_examen x where e.examen_id=x.id
        and x.libelle=examen and e.INSCRIPTION_ID=eleve   and e.annee_id=exercice ;
		return valeur ;

end $$

DELIMITER ;


DELIMITER $$
CREATE FUNCTION `moyeleseqbul2`(eleve BIGINT(20),examen BIGINT(20),examen2 BIGINT(20),exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
    SELECT sum(e.moyenne) into valeur from e_bul e , e_examen x where e.examen_id=x.id
        and (x.libelle=examen or x.libelle=examen2) and e.INSCRIPTION_ID=eleve   and e.annee_id=exercice ;
		return valeur ;

end $$

DELIMITER ;


DELIMITER $$
CREATE FUNCTION `rankseqnbul`(eleve BIGINT(20),examen BIGINT(20), classe BIGINT(20), exercice varchar(255)) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
    SELECT e.rang into valeur from e_bul e , e_examen x where e.examen_id=x.id
        and x.libelle=examen and e.INSCRIPTION_ID=eleve  and e.cls_id=classe and e.annee_id=exercice;
		return valeur ;

end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `appreciationbull`(moyenne decimal(38,2)) RETURNS BIGINT(20)
begin

    DECLARE valeur BIGINT(20);
		SELECT ID into valeur FROM e_app e where e.i_deb<=moyenne and e.i_fin>=moyenne;

		return valeur ;

end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `appreciationenbull`(moyenne decimal(38,2)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT moyenne_en into valeur FROM e_app e where e.i_deb<=moyenne and e.i_fin>=moyenne;

		return valeur ;

end $$

DELIMITER ;


DELIMITER $$
CREATE FUNCTION `appreciationmatbull`(note decimal(38,2)) RETURNS BIGINT(20)
begin

    DECLARE valeur BIGINT(20);

	 SELECT ID into valeur FROM e_app e where e.i_deb<=note and e.i_fin>=note;

		return valeur ;

end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `sanctionbull`(moyenne decimal(38,2)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT sanction into valeur FROM e_app e where e.i_deb<=moyenne and e.i_fin>=moyenne;

		return valeur ;

end $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION `sanctionenbull`(moyenne decimal(38,2)) RETURNS varchar(255)
begin

    DECLARE valeur varchar(255);
		SELECT sanction_en into valeur FROM e_app e where e.i_deb<=moyenne and e.i_fin>=moyenne;

		return valeur ;

end $$

DELIMITER ;

DROP FUNCTION `rankmoyennebull`;
DELIMITER $$
CREATE FUNCTION `rankmoyennebull`(eleve BIGINT(20), exercice varchar(255),classe BIGINT(20),trimestre varchar(255) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT FIND_IN_SET(moyt1,(select GROUP_CONCAT(DISTINCT moyt1 ORDER BY moyt1 DESC) FROM e_bul e where annee_id=exercice and e.cls_id=classe  and e.examen_id=1 )) into valeur from e_bul e
		where e.INSCRIPTION_ID=eleve and annee_id=exercice and e.cls_id=classe and e.examen_id=1 ;
	return valeur ;

	elseif trimestre='T2'
 then	SELECT FIND_IN_SET(moyt2,(select GROUP_CONCAT(DISTINCT moyt2 ORDER BY moyt2 DESC) FROM e_bul e where annee_id=exercice and e.cls_id=classe  and e.examen_id=1 )) into valeur from e_bul e
		where e.INSCRIPTION_ID=eleve and annee_id=exercice and e.cls_id=classe and e.examen_id=1  ;
	return valeur ;

	elseif trimestre='T3'
	then SELECT FIND_IN_SET(moyt3,(select GROUP_CONCAT(DISTINCT moyt3 ORDER BY moyt3 DESC) FROM e_bul e where annee_id=exercice and e.cls_id=classe  and e.examen_id=1)) into valeur from e_bul e
		where e.INSCRIPTION_ID=eleve and annee_id=exercice and e.cls_id=classe and e.examen_id=1 ;
	return valeur ;
 end if ;	
end $$

DELIMITER ;

DROP FUNCTION `moygenclsbull`;
DELIMITER $$
CREATE FUNCTION `moygenclsbull`( exercice varchar(255),classe BIGINT(20),trimestre varchar(255) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT avg(e.moyt1) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1   ;
	return TRUNCATE(valeur,2) ;

	elseif trimestre='T2'
 then SELECT avg(e.moyt2) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1  ;
		return TRUNCATE(valeur,2) ;

	elseif trimestre='T3'
	then SELECT avg(e.moyt3) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1   ;
		return TRUNCATE(valeur,2) ;
 end if ;
end $$

DELIMITER ;

DROP FUNCTION `moyderclsbull`;
DELIMITER $$
CREATE FUNCTION `moyderclsbull`( exercice varchar(255),classe BIGINT(20),trimestre varchar(255) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT min(e.moyt1) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1  ;
	return TRUNCATE(valeur,2) ;

	elseif trimestre='T2'
 then SELECT min(e.moyt2) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice  and e.examen_id=1 ;
		return TRUNCATE(valeur,2) ;

	elseif trimestre='T3'
	then SELECT min(e.moyt3) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1  ;
		return TRUNCATE(valeur,2) ;
 end if ;
end $$

DELIMITER ;

DROP FUNCTION `moypremierclsbull`;
DELIMITER $$
CREATE FUNCTION `moypremierclsbull`( exercice varchar(255),classe BIGINT(20),trimestre varchar(255) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT max(e.moyt1) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1  ;
	return TRUNCATE(valeur,2) ;

	elseif trimestre='T2'
 then SELECT max(e.moyt2) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1  ;
		return TRUNCATE(valeur,2) ;

	elseif trimestre='T3'
	then SELECT max(e.moyt3) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1  ;
		return TRUNCATE(valeur,2) ;
 end if ;
end $$

DELIMITER ;

DROP FUNCTION `ecarttypemoybull`;
DELIMITER $$
CREATE FUNCTION `ecarttypemoybull`( exercice varchar(255),classe BIGINT(20),trimestre varchar(255) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT std(e.moyt1) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.examen_id=1  ;
	return TRUNCATE(valeur,2) ;

	elseif trimestre='T2'
 then SELECT std(e.moyt2) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice  and e.examen_id=1 ;
		return TRUNCATE(valeur,2) ;

	elseif trimestre='T3'
	then SELECT std(e.moyt3) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice  and e.examen_id=1 ;
		return TRUNCATE(valeur,2) ;
 end if ;
end $$

DELIMITER ;

DROP FUNCTION `nbremoyclsbull`;
DELIMITER $$
CREATE FUNCTION `nbremoyclsbull`( exercice varchar(255),classe BIGINT(20),trimestre varchar(255) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT count(e.moyt1) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.moyt1>=10 and e.examen_id=1 ;
	return valeur ;

	elseif trimestre='T2'
 then SELECT count(e.moyt2) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.moyt2>=10 and e.examen_id=1 ;
		return valeur ;

	elseif trimestre='T3'
	then SELECT count(e.moyt3) into valeur from  e_bul e where e.cls_id=classe and e.annee_id=exercice and e.moyt3>=10 and e.examen_id=1 ;
		return valeur ;
 end if ;
end $$

DELIMITER ;


DROP FUNCTION moygenmatbull ;
DELIMITER $$
CREATE FUNCTION `moygenmatbull`( exercice varchar(255),classe BIGINT(20),trimestre varchar(255),  matiere BIGINT(20) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT avg(l.notet1) into valeur from  e_bul e , e_bul_lgn l where e.id=l.lgn_bul_id and e.cls_id=classe and e.annee_id=exercice and e.examen_id=1 and l.mat_id=matiere   ;
	return TRUNCATE(valeur,2) ;

	elseif trimestre='T2'
then SELECT avg(l.notet2) into valeur from  e_bul e , e_bul_lgn l where e.id=l.lgn_bul_id and e.cls_id=classe and e.annee_id=exercice and e.examen_id=1 and l.mat_id=matiere ;
		return TRUNCATE(valeur,2) ;

	elseif trimestre='T3'
then SELECT avg(l.notet3) into valeur from  e_bul e , e_bul_lgn l where e.id=l.lgn_bul_id and e.cls_id=classe and e.annee_id=exercice and e.examen_id=1 and l.mat_id=matiere;
		return TRUNCATE(valeur,2) ;
 end if ;
end $$

DELIMITER ;


DROP FUNCTION rankmatbull ;
DELIMITER $$
CREATE FUNCTION `rankmatbull`( eleve BIGINT(20),exercice varchar(255),classe BIGINT(20),trimestre varchar(255),  matiere BIGINT(20) ) RETURNS decimal(38,2)
begin

    DECLARE valeur decimal(38,2);
	if trimestre='T1'
	 then SELECT FIND_IN_SET(notet1,(select GROUP_CONCAT( DISTINCT notet1 ORDER BY notet1 DESC)  FROM e_bul e, e_bul_lgn l
			where l.lgn_bul_id=e.id  and l.mat_id=matiere  and e.annee_id=exercice and e.cls_id=classe and e.examen_id=1) )into valeur   FROM e_bul e, e_bul_lgn l
			where l.lgn_bul_id=e.id   and l.mat_id=matiere  and e.annee_id=exercice and e.cls_id=classe and e.examen_id=1 and e.inscription_id=eleve ;

	return valeur ;

	elseif trimestre='T2'
then SELECT FIND_IN_SET(notet2,(select GROUP_CONCAT( DISTINCT notet2 ORDER BY notet2 DESC)  FROM e_bul e, e_bul_lgn l
			where l.lgn_bul_id=e.id  and l.mat_id=matiere  and e.annee_id=exercice and e.cls_id=classe and e.examen_id=1) )into valeur   FROM e_bul e, e_bul_lgn l
			where l.lgn_bul_id=e.id   and l.mat_id=matiere  and e.annee_id=exercice and e.cls_id=classe and e.examen_id=1 and e.inscription_id=eleve ;

	return valeur ;

	elseif trimestre='T3'
then SELECT FIND_IN_SET(notet3,(select GROUP_CONCAT( DISTINCT notet3 ORDER BY notet3 DESC)  FROM e_bul e, e_bul_lgn l
			where l.lgn_bul_id=e.id  and l.mat_id=matiere  and e.annee_id=exercice and e.cls_id=classe and e.examen_id=1) )into valeur   FROM e_bul e, e_bul_lgn l
			where l.lgn_bul_id=e.id   and l.mat_id=matiere  and e.annee_id=exercice and e.cls_id=classe and e.examen_id=1 and e.inscription_id=eleve ;

	return valeur ;
 end if ;
end $$

DELIMITER ;



DELIMITER $$
CREATE FUNCTION `appreciationmatbull`(note decimal(38,2)) RETURNS BIGINT(20)
begin

    DECLARE valeur BIGINT(20);

	 SELECT ID into valeur FROM e_app e where e.i_deb<=note and e.i_fin>=note;

		return valeur ;

end $$

DELIMITER ;

DROP FUNCTION `abscencebull` ;
DELIMITER $$
CREATE FUNCTION `abscencebull`(examen varchar(255),eleve BIGINT(20),exercice varchar(255)) RETURNS BIGINT(20)
begin

    DECLARE valeur BIGINT(20);
		SELECT e.id into valeur FROM e_zview_abs e , e_examen x where e.peri_id=x.id and   e.annee_id=exercice and e.eleve_id=eleve and x.libelle=examen;
		return valeur ;

end $$

DELIMITER ;


 --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
--- --- --- --- --- --- --- --- TRIGGER --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
------- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---


delimiter |
DROP TRIGGER IF EXISTS  moyenne_trim |

CREATE TRIGGER moyenne_trim
BEFORE INSERT ON e_bul
FOR EACH ROW
  BEGIN
      SET NEW.moyt1=((select moyenne from e_bul e, e_examen x where e.examen_id=x.id   and x.libelle='0' and ins_id=new.ins_id)+
                     (select moyenne from e_bul e , e_examen x where e.examen_id=x.id   and x.libelle='1' and ins_id=new.ins_id))/2;

      SET NEW.moyt2=((select moyenne from e_bul e, e_examen x where e.examen_id=x.id   and x.libelle='2' and ins_id=new.ins_id)+
                     (select moyenne from e_bul e , e_examen x where e.examen_id=x.id   and x.libelle='3' and ins_id=new.ins_id))/2;

      SET NEW.moyt3=((select moyenne from e_bul e, e_examen x where e.examen_id=x.id   and x.libelle='4' and ins_id=new.ins_id)+
                     (select moyenne from e_bul e , e_examen x where e.examen_id=x.id   and x.libelle='5' and ins_id=new.ins_id))/2;
      SET NEW.moyann= (NEW.moyt1+NEW.moyt2+NEW.moyt3)/3;
    END|
	--trigger note
delimiter |
DROP TRIGGER IF EXISTS  note |

CREATE TRIGGER note
BEFORE UPDATE ON e_notedlt
FOR EACH ROW
  BEGIN
      SET NEW.notet1=(( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='0' and annee_id=new.annee_id)+
                       ( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='1' and annee_id=new.annee_id))/2;

      SET NEW.notet2=(( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='2' and annee_id=new.annee_id)+
                       ( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='3' and annee_id=new.annee_id))/2;

      SET NEW.notet3=(( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='4' and annee_id=new.annee_id)+
                       ( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='5' and annee_id=new.annee_id))/2;
      SET NEW.noteann= (NEW.notet1+NEW.notet2+NEW.notet3)/3;
      SET NEW.moymatcls= (SELECT avg(note) from  e_notedlt  where el_note_id=new.el_note_id and annee_id=NEW.annee_id);

    END|
	
delimiter |
DROP TRIGGER IF EXISTS  note_insert |

CREATE TRIGGER note_insert
BEFORE INSERT ON e_notedlt
FOR EACH ROW
  BEGIN
      SET NEW.notet1=(( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='0' and annee_id=new.annee_id)+
                       ( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='1' and annee_id=new.annee_id))/2;

      SET NEW.notet2=(( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='2' and annee_id=new.annee_id)+
                       ( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='3' and annee_id=new.annee_id))/2;

      SET NEW.notet3=(( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='4' and annee_id=new.annee_id)+
                       ( select note from e_notedlt where etudiant_id= new.etudiant_id and matiere_id=new.matiere_id and type_examen='5' and annee_id=new.annee_id))/2;
      SET NEW.noteann= (NEW.notet1+NEW.notet2+NEW.notet3)/3;
      SET NEW.moymatcls= (SELECT avg(note) from  e_notedlt  where el_note_id=new.el_note_id and annee_id=NEW.annee_id);
      SET NEW.extremax=(SELECT max(note) from  e_notedlt n where el_note_id=new.el_note_id and annee_id=NEW.annee_id);
      SET NEW.extremin=(SELECT min(note) from  e_notedlt n where el_note_id=new.el_note_id and annee_id=NEW.annee_id);
    END|



 --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
--- --- --- --- --- --- --- --- HELPER CMD --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
------- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---


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

-- inti note
delete FROM e_bul_lgn ;
delete FROM e_bul ;
delete FROM e_notedlt ;
delete FROM e_note_mat ;

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

SELECT e.fiche_paie_id, sum(mnt_payer), i.mnt_paye+i.remise,sum(e.solde),i.solde FROM e_p_fiche e , e_inscription i
where e.fiche_paie_id=i.id
and i.classe_id=24
group by e.fiche_paie_id;


update e_notedlt e , e_note_mat m , e_classe c
set Appreciation=case
    when e.note between 18 and 20 then 'Excellent'
    when e.note  between  16 and 17.99 then 'Very Good'
    when e.note  between  14 and 15.99 then 'Good'
    when e.note  between  12 and 13.99 then 'Fair'
    when e.note  between  10 and 11.99 then 'Average'
    when e.note  between  9 and 9.99 then 'Inadequate'
    when e.note  between  8 and 8.99 then 'Insufficient'
    when e.note  between  7 and 7.99 then 'Weak'
    when e.note  between  2 and 6.99 then 'Very Weak'
    when e.note  between  0 and 1.99 then 'Very Poor'

    else 'alpha'
end
where e.el_note_id=m.id
and m.classe_id=c.id
and c.section_id=1;

update e_notedlt e , e_note_mat m , e_classe c
set Appreciation=case
    when e.note between 18 and 20 then 'Excellent'
    when e.note  between  16 and 17.99 then 'Très Bien'
    when e.note  between  14 and 15.99 then 'Bien'
    when e.note  between  12 and 13.99 then 'Assez Bien'
    when e.note  between  10 and 11.99 then 'Passable'
    when e.note  between  9 and 9.99 then 'Médiocre'
    when e.note  between  8 and 8.99 then 'Insuffisant'
    when e.note  between  7 and 7.99 then 'Faible'
    when e.note  between  2 and 6.99 then 'Très Faible'
    when e.note  between  0 and 1.99 then 'Null'

    else 'alpha'
end
where e.el_note_id=m.id
and m.classe_id=c.id
and c.section_id=2;


-- requette optimisation calcul bulletin trigger

update e_notedlt e  set matiere_id= (select matiere_id from e_note_mat where id = e.el_note_id);
update e_notedlt e  set type_examen= (select x.libelle from e_note_mat e, e_examen x where e.examen_id=x.id and e.id = e.el_note_id);
update e_notedlt e  set classe_id= (select classe_id from e_note_mat where id = e.el_note_id);



-- update table for new noyau champ searchkeys
update  e_inscription set searchkeys= concat(matricule," , ",nom);
update  e_eleve set searchkeys= concat(matricule," , ",nom);
