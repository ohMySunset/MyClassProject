SELECT * FROM `withearth`.donapost p left join 
(select file_name, dona_idx from `withearth`.postfile f group by dona_idx)pt
on p.dona_idx=pt.dona_idx ;

select ANY_VALUE(file_name),ANY_VALUE(dona_idx) from `withearth`.postfile f group by dona_idx;