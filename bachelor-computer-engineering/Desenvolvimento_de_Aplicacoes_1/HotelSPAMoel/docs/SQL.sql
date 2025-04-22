/* DROP database */
/*DROP DATABASE HOTELGEST*/
/*CREATE DATABASE HOTELGEST*/

/* DROP all tables. If they are there, they shoudn't be!*/
DROP TABLE tbl_fill;
DROP TABLE tbl_apply;
DROP TABLE tbl_sell;
DROP TABLE tbl_allow;
DROP TABLE tbl_refer;
DROP TABLE tbl_agravate;
DROP TABLE tbl_give;
DROP TABLE tbl_service_line;
DROP TABLE tbl_fd_line;
DROP TABLE tbl_sale;
DROP TABLE tbl_stay;
DROP TABLE tbl_room;
DROP TABLE tbl_blacklist;
DROP TABLE tbl_reservation;
DROP TABLE tbl_food_drink;
DROP TABLE tbl_log;
DROP TABLE tbl_service;
DROP TABLE tbl_extra;
DROP TABLE tbl_employee;
DROP TABLE tbl_registered;
DROP TABLE tbl_tax;
DROP TABLE tbl_client;
DROP TABLE tbl_discount;
DROP TABLE tbl_orientation;
DROP TABLE tbl_type;
DROP TABLE tbl_log_type;
DROP TABLE tbl_category;
/* Table creation follows.... .*/
/* Wihtout dependencies */
CREATE TABLE tbl_category(
	id INT IDENTITY,
	category_name NCHAR(50) NOT NULL,  
	CONSTRAINT pk_tbl_category PRIMARY KEY (id)
);

CREATE TABLE tbl_log_type(
	id SMALLINT,
	tp_name NCHAR(50) NOT NULL,  
	CONSTRAINT pk_tbl_log_type PRIMARY KEY (id)
);

CREATE TABLE tbl_type(
	id INT IDENTITY,
	tp_name NCHAR(50) NOT NULL,  
	CONSTRAINT pk_tbl_type PRIMARY KEY (id)
);

CREATE TABLE tbl_orientation(
	id INT IDENTITY,
	orientation NCHAR(25),
	CONSTRAINT pk_tbl_orientation PRIMARY KEY (id)
);

CREATE TABLE tbl_discount(
	id INT IDENTITY,
	discount_name NCHAR(25) NOT NULL,
	percentage REAL,
	CONSTRAINT pk_tbl_discount PRIMARY KEY (id)
);

CREATE TABLE tbl_client(
	id INT IDENTITY,
	client_name NCHAR(200) NOT NULL,
	registration_number VARCHAR(9),
	phone VARCHAR(12),
	cellphone VARCHAR(12),
	email VARCHAR(250),
	fax VARCHAR(12),
	client_type VARCHAR(1),
	address NCHAR(150),
	city NCHAR(50),
	zip_code VARCHAR(8),
	country VARCHAR(50),
	CONSTRAINT pk_tbl_client PRIMARY KEY (id)
);

CREATE TABLE tbl_tax(
	id INT IDENTITY,
	tax_name NCHAR(50) NOT NULL,
	percentage REAL NOT NULL,
	CONSTRAINT pk_tbl_tax PRIMARY KEY (id)
);

CREATE TABLE tbl_registered(
	id INT IDENTITY,
	first_name NCHAR(100) NOT NULL,
	surname NCHAR(100) NOT NULL,
	phone VARCHAR(12),
	cellphone VARCHAR(12),
	email VARCHAR(250),
	id_number VARCHAR(9) NOT NULL,
	CONSTRAINT pk_tbl_registered PRIMARY KEY (id)
);

CREATE TABLE tbl_employee(
	id INT IDENTITY,
	first_name NCHAR(100) NOT NULL,
	surname NCHAR(100) NOT NULL,
	registration_number VARCHAR(9),
	phone VARCHAR(12),
	cellphone VARCHAR(12),
	email VARCHAR(250),
	id_number VARCHAR(9) NOT NULL,
	iban VARCHAR(34) NOT NULL,
	birth_date VARCHAR(10) NOT NULL,
	emp_username VARCHAR(50) NOT NULL,
	emp_password VARCHAR(32) NOT NULL,
	emp_type VARCHAR NOT NULL DEFAULT('N'),
	CONSTRAINT pk_tbl_employee PRIMARY KEY (id)
);

CREATE TABLE tbl_extra(
	id INT IDENTITY,
	extra_name NCHAR(50) NOT NULL,
	price SMALLMONEY NOT NULL,
	CONSTRAINT pk_tbl_extra PRIMARY KEY (id)
);

CREATE TABLE tbl_service(
	id INT IDENTITY,
	serv_name NCHAR(50) NOT NULL,
	price SMALLMONEY NOT NULL,
	CONSTRAINT pk_tbl_service PRIMARY KEY (id)
);

/*with dependencies*/
CREATE TABLE tbl_log(
	id INT IDENTITY,
	log_action VARCHAR(250) NOT NULL,
	action_date VARCHAR(10),
	employee_id INT NOT NULL,
	log_type_id SMALLINT NOT NULL,
	CONSTRAINT fk_tbl_log_employid FOREIGN KEY (employee_id) REFERENCES tbl_employee(id),
	CONSTRAINT fk_tbl_log_log_typeid FOREIGN KEY (log_type_id) REFERENCES tbl_log_type(id),
	CONSTRAINT pk_tbl_log PRIMARY KEY (id)
);

CREATE TABLE tbl_food_drink(
	id INT IDENTITY,
	fd_name NCHAR(50) NOT NULL,
	min_stock INT NOT NULL,
	stock INT NOT NULL,
	price SMALLMONEY NOT NULL,
	category_id INT NOT NULL,
	CONSTRAINT fk_tbl_food_drink_categoryid FOREIGN KEY (category_id) REFERENCES tbl_category(id),
	CONSTRAINT pk_tbl_food_drink PRIMARY KEY (id)
);

CREATE TABLE tbl_reservation(
	id INT IDENTITY,
	client_id INT NOT NULL,
	employee_id INT NOT NULL,
	registered_id INT NOT NULL,
	reservation_date VARCHAR(10) NOT NULL,
	destination_date VARCHAR(10) NOT NULL,
	second_choise VARCHAR(1) NOT NULL DEFAULT('N'),
	CONSTRAINT fk_tbl_reservation_employid FOREIGN KEY (employee_id) REFERENCES tbl_employee(id),
	CONSTRAINT fk_tbl_reservation_clid FOREIGN KEY (client_id) REFERENCES tbl_client(id),
	CONSTRAINT fk_tbl_reservation_registeredid FOREIGN KEY (registered_id) REFERENCES tbl_registered(id),
	CONSTRAINT pk_tbl_reservation PRIMARY KEY (id)
);

CREATE TABLE tbl_blacklist(
	id INT IDENTITY,
	reservation_id INT NOT NULL,
	client_id INT NOT NULL,
	entry_date VARCHAR(10) NOT NULL,
	CONSTRAINT fk_tbl_blacklist_reservid FOREIGN KEY (reservation_id) REFERENCES tbl_reservation(id),
	CONSTRAINT fk_tbl_clid FOREIGN KEY (client_id) REFERENCES tbl_client(id),
	CONSTRAINT pk_tbl_blacklist PRIMARY KEY (id)	
);

CREATE TABLE tbl_room(
	id INT IDENTITY,
	identification VARCHAR(10) NOT NULL,
	orientation_id INT NOT NULL,
	tp_id INT NOT NULL,	
	CONSTRAINT fk_tbl_room_orid FOREIGN KEY (orientation_id) REFERENCES tbl_orientation(id),
	CONSTRAINT fk_tbl_room_typeid FOREIGN KEY (tp_id) REFERENCES tbl_type(id),
	CONSTRAINT pk_tbl_room PRIMARY KEY (id)
);

CREATE TABLE tbl_stay(
	id INT IDENTITY,
	checkin_date VARCHAR(10) NOT NULL,
	checkout_date VARCHAR(10),
	sub_total SMALLMONEY NOT NULL,
	tax_id INT NOT NULL,
	active VARCHAR(1) NOT NULL DEFAULT('S'),
	room_id INT NOT NULL,
	employee_id INT NOT NULL,
	registered_id INT NOT NULL,
	CONSTRAINT fk_tbl_stay_taxid FOREIGN KEY (tax_id) REFERENCES tbl_tax(id),
	CONSTRAINT fk_tbl_stay_roomid FOREIGN KEY (room_id) REFERENCES tbl_room(id),
	CONSTRAINT fk_tbl_stay_employid FOREIGN KEY (employee_id) REFERENCES tbl_employee(id),
	CONSTRAINT fk_tbl_stay_regid FOREIGN KEY (registered_id) REFERENCES tbl_registered(id),
	CONSTRAINT pk_tbl_stay PRIMARY KEY (id)
);

CREATE TABLE tbl_sale(
	id INT IDENTITY,
	sale_date VARCHAR(10) NOT NULL,
	price SMALLMONEY NOT NULL,
	payed SMALLMONEY NOT NULL DEFAULT(0),
	employee_id INT NOT NULL,
	client_id INT NOT NULL,
	CONSTRAINT fk_tbl_sale_employid FOREIGN KEY (employee_id) REFERENCES tbl_employee(id),
	CONSTRAINT fk_tbl_sale_clid FOREIGN KEY (client_id) REFERENCES tbl_client(id),
	CONSTRAINT pk_tbl_sale PRIMARY KEY (id)
);

CREATE TABLE tbl_fd_line(
	id INT IDENTITY,
	quantitity SMALLINT NOT NULL,
	fd_id INT NOT NULL,
	stay_id INT NOT NULL,
	sale_id INT NOT NULL,
	unit_price SMALLMONEY NOT NULL,
	CONSTRAINT fk_tbl_fd_line_saleid FOREIGN KEY (sale_id) REFERENCES tbl_sale(id),
	CONSTRAINT fk_tbl_fd_line_fdid FOREIGN KEY (fd_id) REFERENCES tbl_food_drink(id),
	CONSTRAINT fk_tbl_fd_line_stayid FOREIGN KEY (stay_id) REFERENCES tbl_stay(id),
	CONSTRAINT pk_tbl_fd_line PRIMARY KEY (id)
);

CREATE TABLE tbl_service_line(
	id INT IDENTITY,
	quantitity SMALLINT NOT NULL,
	service_id INT NOT NULL,
	stay_id INT NOT NULL,
	sale_id INT NOT NULL,
	service_price SMALLMONEY NOT NULL,
	CONSTRAINT fk_tbl_service_line_saleid FOREIGN KEY (sale_id) REFERENCES tbl_sale(id),
	CONSTRAINT fk_tbl_service_line_servid FOREIGN KEY (service_id) REFERENCES tbl_service(id),
	CONSTRAINT fk_tbl_service_line_stayid FOREIGN KEY (stay_id) REFERENCES tbl_stay(id),
	CONSTRAINT pk_tbl_service_line PRIMARY KEY (id)
);

/* Relationships */
CREATE TABLE tbl_give(
	discount_id INT NOT NULL,
	stay_id INT,
	CONSTRAINT fk_tbl_give_discid FOREIGN KEY (discount_id) REFERENCES tbl_discount(id),
	CONSTRAINT fk_tbl_give_stayid FOREIGN KEY (stay_id) REFERENCES tbl_stay(id),
	CONSTRAINT pk_tbl_give PRIMARY KEY (stay_id)
);

CREATE TABLE tbl_agravate(
	tax_id INT NOT NULL,
	fd_id INT NOT NULL,
	CONSTRAINT fk_tbl_agravate_fdid FOREIGN KEY (fd_id) REFERENCES tbl_food_drink(id),
	CONSTRAINT fk_tbl_agravate_taxid FOREIGN KEY (tax_id) REFERENCES tbl_tax(id),
	CONSTRAINT pk_tbl_agravate PRIMARY KEY (fd_id, tax_id)	
);

CREATE TABLE tbl_refer(
	tax_id INT NOT NULL,
	service_id INT NOT NULL,
	CONSTRAINT fk_tbl_refer_servid FOREIGN KEY (service_id) REFERENCES tbl_service(id),
	CONSTRAINT fk_tbl_refer_taxid FOREIGN KEY (tax_id) REFERENCES tbl_tax(id),
	CONSTRAINT pk_tbl_refer PRIMARY KEY (tax_id, service_id)	
);

CREATE TABLE tbl_allow(
	extra_id INT,
	stay_id INT,
	CONSTRAINT fk_tbl_allow_extraid FOREIGN KEY (extra_id) REFERENCES tbl_extra(id),
	CONSTRAINT fk_tbl_allow_stayid FOREIGN KEY (stay_id) REFERENCES tbl_stay(id),
	CONSTRAINT pk_tbl_allow PRIMARY KEY (extra_id, stay_id)
);

CREATE TABLE tbl_sell(
	sale_id INT,
	stay_id INT NOT NULL,
	CONSTRAINT fk_tbl_sell_saleid FOREIGN KEY (sale_id) REFERENCES tbl_sale(id),
	CONSTRAINT fk_tbl_sell_stayid FOREIGN KEY (stay_id) REFERENCES tbl_stay(id),
	CONSTRAINT pk_tbl_sell PRIMARY KEY (sale_id)
);

CREATE TABLE tbl_apply(
	service_line_id INT NOT NULL,
	discount_id INT NOT NULL,
	CONSTRAINT fk_tbl_apply_servlineid FOREIGN KEY (service_line_id) REFERENCES tbl_service_line(id),
	CONSTRAINT fk_tbl_apply_discid FOREIGN KEY (discount_id) REFERENCES tbl_discount(id),
	CONSTRAINT pk_tbl_apply PRIMARY KEY (service_line_id, discount_id)	
);

CREATE TABLE tbl_fill(
	room_id INT NOT NULL,
	fd_id INT NOT NULL,
	qnt SMALLINT NOT NULL,
	CONSTRAINT fk_tbl_fill_roomid FOREIGN KEY (room_id) REFERENCES tbl_room(id),
	CONSTRAINT fk_tbl_fill_fdid FOREIGN KEY (fd_id) REFERENCES tbl_food_drink(id),
	CONSTRAINT pk_tbl_fill PRIMARY KEY (room_id, fd_id)	
)

INSERT INTO tbl_log_type VALUES(0, 'Administração');
INSERT INTO tbl_log_type VALUES(1, 'Estadias');
INSERT INTO tbl_log_type VALUES(2, 'Lista de Clientes Bloqueados');
INSERT INTO tbl_log_type VALUES(3, 'Reservas');