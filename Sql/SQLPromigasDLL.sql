/* pais */
create table  dbo.country (
	 unique_id  int primary key identity(1,1) Not null,
	 name_country   nvarchar  (20) Not null,
	 url_flags nvarchar (150)
)

/* oportunidades */
create table     dbo.opportunities  (
	 unique_id  int primary key identity(1,1) Not null,
	 id_country   int  Not Null,
	 id_sector int  Not Null,
	 id_type_contract  int Not null,
	 greenfield   bit Not null,
	 mYa   bit Not null,
	 project_title   nvarchar (80),
	 date_update   date ,
	 coordinates   nvarchar  (50),
	 opportunity_descrip   nvarchar  (1000),
	 horizon_operation   int not null,
	 pre_operation_horizon  int, 
	 POC   date ,
	 TRM_base_capex  int not null,
	 TRM_fin_capex   int not null,
	 prop_capex_usd  int not null,
	 prop_capex_cop  int not null,
	 financial_asset bit,
)

alter table opportunities add constraint FK_oppor_country 
	FOREIGN KEY (id_country)
	REFERENCES country(unique_id)


/* sector */
create table   dbo.sector(
	 unique_id   int primary key identity(1,1) Not null,
	 type_sector nvarchar  (50) not null,
)

alter table opportunities add constraint FK_sector_opor 
	FOREIGN KEY (id_sector)
	REFERENCES sector(unique_id)
	/*Contrato */

create table     dbo.type_contract (
	 unique_id  int primary key identity(1,1) Not null,
	 type_contract nvarchar(50)  Not Null,
)
alter table opportunities add constraint FK_typ_opor 
	FOREIGN KEY (id_type_contract)
	REFERENCES type_contract(unique_id)

/*Indicadores */
create table     dbo.indicators (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 indicator_debt_usd    nvarchar (20),
	 indicator_debt_cop    float  (20),
	 debt_net_usd   nvarchar (20),
	 debt_net__cop  float  (20),
	 indicator_ebitda_usd   nvarchar (20),
	 indicator_ebitda_cop  float  (20),
	 ffo_usd   nvarchar (20),
	 ffo_cop   float  (20),
)

alter table indicators add constraint FK_ind_opor
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)


/* Beneficios tributarios*/
create table    dbo.benef_tributaries (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity  int  Not Null,
	 benef_tribu_law1715   int  Not Null,
	 benef_tribu_law_crec   int  Not Null,
	 benef_tribu_cej  int  Not Null,
	 benef_tribu_others  int  Not Null,
)
alter table benef_tributaries add constraint FK_bentr_opor 
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)



/******************  CIFRAS OPERATIVAS *******************************************/

/* CO DISTRIBUCION*/
create table     dbo.co_distribution  (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 volume_distribution   float  (20),
	 distr_connec_period   int,
	 distr_kms_red   float  (20),
	 distr_user_accumulated   int,
	 distr_penetration   nvarchar(20),
)
alter table co_distribution add constraint FK_dis_co
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)

/* CO SOLUCIONES ENERGETICAS*/
create table  dbo.co_energy_solutions  (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 solenerg_power_unit   nvarchar  (30),
	 solenerg_power_figure   float  (20),
	 solenerg_gener_unit   nvarchar  (30),
	 solenerg_gener_figure   float  (20),
	 solenerg_degradation_average   float (20),
	 solenerg_hour_sun   float  (20),
)
alter table co_energy_solutions add constraint FK_solen_co
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)

/* CO TRANSPORTE*/
create table     dbo.co_transport  (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 transp_capacity_max   float  (20),
	 trans_capacity_hired   float  (20),
	 trans_vol_trans   float  (20),
	 trans_length_pipeline   float  (20),
)
alter table co_transport add constraint FK_trans_co
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)

/****************** FIN CIFRAS OPERATIVAS *******************************************/



/********************  CIFRAS FINANCIERAS **********************************	 */
/* tirEquity*/
create table     dbo.cf_tir_equity (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 tir_equity_figure   float  (20),
	 tir_equity_unit    nvarchar (30),
	 tir_equity_capital_structure nvarchar  (30) ,
	 tir_equity_debt_cost nvarchar  (30) ,
	 tir_equity_amortization   nvarchar  (40) ,
)
alter table  cf_tir_equity add constraint FK_tireq_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)


/* tirproyecto*/
create table     dbo.cf_tir_project (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 tir_project_figure   float  (20),
	 tir_project_unit   nvarchar  (30) ,
)
alter table  cf_tir_project add constraint FK_tirp_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)
	

/* tarifa */
create table     dbo.cf_tarif (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 value_tarif_usd  int,
	 value_tarif_cop   int,
)
alter table  cf_tarif add constraint FK_tar_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)



/* dividendos*/
create table     dbo.cf_dividends (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 dividens_usd numeric (18,0),
	 value_dividends_usd   numeric (18,0),
	 dividens_cop numeric (18,0),
	 value_dividends_cop   numeric (18,0),
)
alter table  cf_dividends add constraint FK_div_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)



/* Cf fclAccionista*/
create table     dbo.cf_fcl_shareholder (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 shareholder_usd   numeric (18,0),
	 value_share_usd   numeric (18,0),
	 shareholder_cop   numeric (18,0),
	 value_share_cop   numeric (18,0),
)
alter table cf_fcl_shareholder add constraint FK_fcla_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)

	
/* Cf fcl*/
create table  dbo.cf_fcl (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 fcl_usd numeric (18,0),
	 value_fcl_usd   numeric (18,0),
	 fcl_cop numeric (18,0),
	 value_fcl_cop   numeric (18,0),
)
alter table cf_fcl add constraint FK_fcl_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)



/* Cf utilneta*/
create table     dbo.cf_utility_net (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 utility_usd numeric (18,0),
	 value_utility_usd   numeric (18,0),
	 utility_cop numeric (18,0),
	 value_utility_cop  numeric (18,0),
)
alter table cf_utility_net add constraint FK_utiln_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)



/* Cf ingresos*/
create table     dbo.cf_income (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 income_usd   numeric (18,0),
	 value_income_usd   numeric (18,0),
	 income_cop   numeric (18,0),
	 value_income_cop   numeric (18,0),
)
alter table cf_income add constraint FK_incom_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)



/* Cf ebitda*/
create table     dbo.cf_ebitda (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year   date ,
	 ebitda_usd   numeric (18,0),
	 value_ebitda_usd   numeric (18,0),
	 ebitda_cop      numeric (18,0),
	 value_ebitda_cop   numeric (18,0),
)
alter table cf_ebitda add constraint FK_ebit_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)



/* Cf capex*/
create table   dbo.cf_capex (
	 unique_id  int primary key identity(1,1) Not null,
	 id_opportunity   int  Not Null,
	 year  date ,
	 capex_usd    numeric (18,0),
	 value_capex_usd   numeric (18,0),
	 capex_cop  numeric (18,0),
	 value_capex_cop  numeric (18,0),
)
alter table  cf_capex add constraint FK_capex_cifin
	FOREIGN KEY (id_opportunity)
	REFERENCES opportunities(unique_id)


/********************  FIN CIFRAS FINANCIERAS **********************************	 */


