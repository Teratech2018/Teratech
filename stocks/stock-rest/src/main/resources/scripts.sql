create view v_laremlo
(id,compareid,designation,editTitle,listTitle,moduleName,selected,createonfield,desablecreate,desabledelete,serial,activefilelien,
footerScript,activatefollower,code,art_id,lie_id,entr_id,emp_id,stock)
as
select concat(art.id,lie.id,emp.id) ,concat(art.id,lie.id,emp.id),null,null,null,null,0,0,0,0,null,0,null,0, concat(art.id,lie.id,emp.id) , art.id ,lie.id,emp.entr_id, emp.id,lie.stock
from t_art as art , t_empl as emp,t_liem as lie
where art.id = lie.liem_id and emp.id=lie.emp_id
group by concat(art.id,emp.id)