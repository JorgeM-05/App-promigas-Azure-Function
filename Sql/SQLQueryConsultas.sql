
/*  */
select * from sector;
select * from type_contract;
select * from opportunities;
select * from country;
select * from cf_capex;



/*  INSERT PAISES */
insert into country values('Colombia','url');
insert into country values('Venezuela','url');
insert into country values('Panama','url');
insert into country values('Argentina','url');

/* INSERT SECTOR */
select * from sector;
insert into sector values('Transporte Gas');
insert into sector values('Distribucion Gas');
insert into sector values('Distribucion E.E');
insert into sector values('Solares');
insert into sector values('Auto. Gen');
insert into sector values('Co. Gen');
insert into sector values('Otros');
/* Tipo de contrato*/

insert into type_contract values('BONT')
insert into type_contract values('BOOM')

/* INSERT OPORTUNIDADES */

select * from opportunities;

insert into opportunities values(1,1,2,0,1,'Vincorte1','12/12/2022','5.4939722,-70.9520643','Proyecto fotovoltaico1',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(1,2,1,0,1,'Vincorte2','12/12/2022','5.4939722,-72.9520643','Proyecto fotovoltaico2',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(1,2,2,0,1,'Vincorte3','12/12/2022','5.4939722,-76.9520643','Proyecto fotovoltaico3',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(2,3,1,0,1,'Vincort4','12/12/2022','5.4939722,-65.9520643','Proyecto fotovoltaico4',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(2,1,2,0,1,'Vincorte5','12/12/2022','5.4939722,-70.9520643','Proyecto fotovoltaico1',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(2,2,1,0,1,'Vincorte6','12/12/2022','5.4939722,-72.9520643','Proyecto fotovoltaico2',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(2,2,2,0,1,'Vincorte7','12/12/2022','5.4939722,-76.9520643','Proyecto fotovoltaico3',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(2,3,1,0,1,'Vincort8','12/12/2022','5.4939722,-65.9520643','Proyecto fotovoltaico4',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(3,1,2,0,1,'Vincorte3','12/12/2022','5.4939722,-70.9520643','Proyecto fotovoltaico1',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(3,2,1,0,1,'Vincorte10','12/12/2022','5.4939722,-72.9520643','Proyecto fotovoltaico2',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(3,2,2,0,1,'Vincorte11','12/12/2022','5.4939722,-76.9520643','Proyecto fotovoltaico3',123, 232,'12/12/2022',4850,4900,51,49,0);
insert into opportunities values(3,3,1,0,1,'Vincort12','12/12/2022','5.4939722,-65.9520643','Proyecto fotovoltaico4',123, 232,'12/12/2022',4850,4900,51,49,0);


/* insert capex */
insert into cf_capex values(5,'2022',170,29,2000000,80900);
insert into cf_capex values(5,'2022',170,20,2000000,80900);
insert into cf_capex values(5,'2022',170,15,2000000,80900);
insert into cf_capex values(5,'2022',170,-5,2000000,80900);
insert into cf_capex values(5,'2022',170,10,2000000,80900);

insert into cf_capex values(6,'2022',170,29,2000000,80900);
insert into cf_capex values(6,'2022',170,20,2000000,80900);
insert into cf_capex values(6,'2022',170,15,2000000,80900);
insert into cf_capex values(6,'2022',170,-5,2000000,80900);
insert into cf_capex values(6,'2022',170,10,2000000,80900);

insert into cf_capex values(7,'2022',170,29,2000000,80900);
insert into cf_capex values(7,'2022',170,20,2000000,80900);
insert into cf_capex values(7,'2022',170,15,2000000,80900);
insert into cf_capex values(7,'2022',170,-5,2000000,80900);
insert into cf_capex values(7,'2022',170,10,2000000,80900);

insert into cf_capex values(8,'2022',170,29,2000000,80900);
insert into cf_capex values(8,'2022',170,20,2000000,80900);
insert into cf_capex values(8,'2022',170,15,2000000,80900);
insert into cf_capex values(8,'2022',170,-5,2000000,80900);
insert into cf_capex values(8,'2022',180,10,2000000,80900);

insert into cf_capex values(9,'2022',180,29,2000000,80900);
insert into cf_capex values(9,'2022',180,20,2000000,80900);
insert into cf_capex values(9,'2022',190,15,2000000,80900);
insert into cf_capex values(9,'2022',190,-5,2000000,80900);
insert into cf_capex values(9,'2022',190,10,2000000,80900);

insert into cf_capex values(10,'2022',1100,29,2000000,80900);
insert into cf_capex values(10,'2022',1100,20,2000000,80900);
insert into cf_capex values(10,'2022',1100,15,2000000,80900);
insert into cf_capex values(10,'2022',1100,-5,2000000,80900);
insert into cf_capex values(10,'2022',1100,10,2000000,80900);

insert into cf_capex values(11,'2022',170,29,2000000,80900);
insert into cf_capex values(11,'2022',170,20,2000000,80900);
insert into cf_capex values(11,'2022',170,15,2000000,80900);
insert into cf_capex values(11,'2022',170,-5,2000000,80900);
insert into cf_capex values(11,'2022',170,10,2000000,80900);

insert into cf_capex values(12,'2022',170,29,2000000,80900);
insert into cf_capex values(12,'2022',170,20,2000000,80900);
insert into cf_capex values(12,'2022',170,15,2000000,80900);
insert into cf_capex values(12,'2022',170,-5,2000000,80900);
insert into cf_capex values(12,'2022',170,10,2000000,80900);

insert into cf_capex values(13,'2022',170,29,2000000,80900);
insert into cf_capex values(13,'2022',170,20,2000000,80900);
insert into cf_capex values(13,'2022',170,15,2000000,80900);
insert into cf_capex values(13,'2022',170,-5,2000000,80900);
insert into cf_capex values(13,'2022',170,10,2000000,80900);

insert into cf_capex values(14,'2022',170,29,2000000,80900);
insert into cf_capex values(14,'2022',170,20,2000000,80900);
insert into cf_capex values(14,'2022',170,15,2000000,80900);
insert into cf_capex values(14,'2022',170,-5,2000000,80900);
insert into cf_capex values(14,'2022',170,10,2000000,80900);

insert into cf_capex values(15,'2022',170,29,2000000,80900);
insert into cf_capex values(15,'2022',170,20,2000000,80900);
insert into cf_capex values(15,'2022',170,15,2000000,80900);
insert into cf_capex values(15,'2022',170,-5,2000000,80900);
insert into cf_capex values(15,'2022',170,10,2000000,80900);

insert into cf_capex values(16,'2022',170,29,2000000,80900);
insert into cf_capex values(16,'2022',170,20,2000000,80900);
insert into cf_capex values(16,'2022',170,15,2000000,80900);
insert into cf_capex values(16,'2022',170,-5,2000000,80900);
insert into cf_capex values(16,'2022',170,10,2000000,80900);



/*  */ 









select * from opportunities;
select * from sector;
select * from country;
select * from cf_capex;



select * from dbo.opportunities op 
            INNER Join dbo.country c On op.id_country=c.unique_id
            INNER JOIN dbo.type_contract t On t.unique_id = op.id_type_contract
            INNER JOIN dbo.sector s On s.unique_id = op.id_sector
            where c.name_country = 'colombia';