-- comentario de linea

/*
	comentario de bloque
*/

-- selecciono la base x defecto
use pubs;

-- veo las tablas de la base seleccionada
show tables;

-- version de mysql
select version();-- 10.4.21-MariaDB

-- queries
select * from authors;

-- veo la estructura de la tabla autores
describe authors;

-- listar nombre , apellido y telefono de los autores
select 	concat(au_fname,' ',au_lname) as autor,
		phone telefono
from	authors;

-- columnas agregadas y calculadas
select	21 as IVA,
		'esto es un comentario',
        title titulo,
        price precio,
        round(price * 1.21, 2) as 'precio con IVA'
from	titles;

-- filtros
-- listar los libros que cuesten entre 10 y 20 U$s
select * from titles where price between 10 and 20;

-- listar los puestos de trabajo que sean editores y diseñadores
select * from jobs where job_desc in ('editor','designer');

-- listar los empleados cuyo nombre empiece con m
select * from employee where fname like 'm%';

-- listar los empleados cuyo nombre empiece con m, el 2do caracter 
-- sea cualquiera, el 3er caracter sea r y termine de cualquier forma
select * from employee where fname like 'm_r%';

-- ordenar por precio descendente a los libros que no sean de cocina
select * from titles where type not like '%cook%' order by price desc;

-- listar los empleados que ingresaron entre 1990 y 1994, ordenados 
-- alfabeticamente
select 		* 
from 		employee 
where 		year(hire_date) between 1990 and 1994
order by	lname, fname; 







