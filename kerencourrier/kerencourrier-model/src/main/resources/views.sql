DROP VIEW IF EXISTS `v_courrgc`;
CREATE OR REPLACE VIEW `v_courrgc` AS
SELECT distinct c.id  as id ,c.id as compareid,'' as editTitle,'' as serial,'' as listTitle,'' as designation,'' as footerScript,'' as moduleName,false as activefilelien,false as createonfield,true as desablecreate,true as desabledelete,true as desableupdate,false as selected,false as activatefollower, c.id as COU_ID , CONCAT(c.code,',',IFNULL(c.porte,''),',',IFNULL(c.t_cat,''),',',IFNULL(c.objet,''),',',IFNULL(c.signataire,''),',',IFNULL(c.mots_cles,''),',',IFNULL(p.code,''),',',IFNULL(n.code,''),',',IFNULL(n.intitule,''),',',IFNULL(c1.nom,''),',',IFNULL(c1.prenom,''),',',IFNULL(c1.structure,''),',',IFNULL(c1.sig,''),',',IFNULL(d.code,''),',',IFNULL(d.nom,'')) as motscles
FROM t_courrgc as c,t_priokc as p,t_nacogc as n ,t_contkc c1,t_contkc c2,t_depsoc as d , t_docokc d1
WHERE (c.t_nature IS NULL OR c.t_nature=n.id)
  AND (c.t_prio IS NULL OR c.t_prio=p.id)
  AND (c.t_corres IS NULL OR c.t_corres=c1.id)
  AND (c.des_id IS NULL OR c.des_id=c2.id)
  AND (c.t_serv IS NULL OR d.id=c.t_serv)
  AND (c.t_dos IS NULL OR d1.id=c.t_dos);
  
  
DROP VIEW IF EXISTS `v_creport`;
CREATE OR REPLACE VIEW `v_creport` AS
SELECT distinct c.id  as id ,c.id as compareid,'' as editTitle,'' as serial,'' as listTitle,'' as designation,'' as footerScript,'' as moduleName,false as activefilelien,false as createonfield,true as desablecreate,true as desabledelete,true as desableupdate,false as selected,false as activatefollower, c.id as COU_ID , CONCAT(c.code,',',IFNULL(c.porte,''),',',IFNULL(c.t_cat,''),',',IFNULL(c.objet,''),',',IFNULL(c.signataire,''),',',IFNULL(c.mots_cles,''),',',IFNULL(p.code,''),',',IFNULL(n.code,''),',',IFNULL(n.intitule,''),',',IFNULL(c1.nom,''),',',IFNULL(c1.prenom,''),',',IFNULL(c1.structure,''),',',IFNULL(c1.sig,''),',',IFNULL(d.code,''),',',IFNULL(d.nom,'')) as motscles
FROM t_courrgc as c,t_priokc as p,t_nacogc as n ,t_contkc c1,t_contkc c2,t_depsoc as d , t_docokc d1
WHERE (c.t_nature IS NULL OR c.t_nature=n.id)
  AND (c.t_prio IS NULL OR c.t_prio=p.id)
  AND (c.t_corres IS NULL OR c.t_corres=c1.id)
  AND (c.des_id IS NULL OR c.des_id=c2.id)
  AND (c.t_serv IS NULL OR d.id=c.t_serv)
  AND (c.t_dos IS NULL OR d1.id=c.t_dos);