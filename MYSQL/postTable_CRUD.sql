select count(*) from `withearth`.donapost where dona_title like '%무료%';
select * from `withearth`.donapost where dona_title like '%무료%';

SELECT * FROM `withearth`.donapost p left join `withearth`.postfile f on p.dona_idx=f.dona_idx	where dona_title like '%무료%';
SELECT * FROM withearth.donapost;

select * from `withearth`.donapost p inner join `withearth`.postfile f on p.dona_idx=f.dona_idx
where file_idx = (select min(file_idx) from `withearth`.postfile f) limit 0,5