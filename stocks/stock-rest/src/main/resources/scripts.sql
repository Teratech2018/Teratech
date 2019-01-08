create view v_laremlo
(id,compareid,designation,editTitle,listTitle,moduleName,selected,createonfield,desablecreate,desableupdate,desabledelete,serial,activefilelien,
footerScript,activatefollower,code,art_id,lie_id,entr_id,emp_id,stock,searchkeys,ownermodule,lot_id)
as
select concat(art.id,lie.id,emp.id) ,concat(art.id,lie.id,emp.id),null,null,null,null,0,0,0,0,0,null,0,null,0, concat(art.id,lie.id,emp.id) , art.id ,lie.id,emp.entr_id, emp.id,lie.stock,null,'teratechstock',lot.id
from t_art as art , t_empl as emp,t_liem_st as lie,t_entr as entr,t_lot as lot
where art.id = lie.art_id and emp.id=lie.emp_id and entr.id=lie.entr_id
group by concat(art.id,emp.id)