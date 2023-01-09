CREATE TABLE rental (
	id INTEGER NOT NULL AUTO_INCREMENT
	,name_rental VARCHAR(255)
	,internet_domain VARCHAR(255)
	,contact_address VARCHAR(255)
	,OWNER VARCHAR(255)
	,logo_type VARCHAR(255)
	,PRIMARY KEY (id)
	);

CREATE TABLE branch (
	id INTEGER NOT NULL AUTO_INCREMENT
	,address_city VARCHAR(255)
	,fk_rental_id INTEGER NOT NULL
	,PRIMARY KEY (id)
	,FOREIGN KEY (fk_rental_id) REFERENCES rental(id)
	);

CREATE TABLE employee (
    id INTEGER NOT NULL AUTO_INCREMENT
    ,type VARCHAR(255)
    ,first_name VARCHAR(255)
    ,last_name VARCHAR(255)
    ,PRIMARY KEY (id)
    ,fk_branch_id INTEGER NOT NULL
    ,FOREIGN KEY (fk_branch_id) REFERENCES branch(id)
    );

CREATE TABLE car (
	id INTEGER NOT NULL AUTO_INCREMENT
	,STATUS VARCHAR(255)
	,amount DOUBLE PRECISION
	,body_type VARCHAR(255)
	,car_name VARCHAR(255)
	,colour VARCHAR(255)
	,mileage INTEGER
	,model VARCHAR(255)
	,PRIMARY KEY (id)
	,fk_branch_id INTEGER NOT NULL
	,FOREIGN KEY (fk_branch_id) REFERENCES branch(id)
	);

CREATE TABLE customer (
	id INTEGER NOT NULL AUTO_INCREMENT
	,first_name VARCHAR(255)
	,name VARCHAR(255)
	,email VARCHAR(255)
	,address VARCHAR(255)
	,PRIMARY KEY (id)
	);

CREATE TABLE reservation (
	id INTEGER NOT NULL AUTO_INCREMENT
	,date_of_reservation timestamp
	,date_from timestamp
	,date_to timestamp
	,amount DOUBLE
	,PRIMARY KEY (id)
	,car_id INTEGER NOT NULL
	,customer_id INTEGER NOT NULL
	,FOREIGN KEY (car_id) REFERENCES car(id)
	,FOREIGN KEY (customer_id) REFERENCES customer(id)
	);

CREATE TABLE revenue (
	id INTEGER NOT NULL AUTO_INCREMENT
	,car_rental_amount DOUBLE PRECISION
	, PRIMARY KEY(id)
	);

CREATE TABLE refund (
	id INTEGER NOT NULL AUTO_INCREMENT
	,return_date timestamp
	,surcharge DOUBLE
	,comments VARCHAR(255)
	,fk_employee_id INTEGER NOT NULL
	,fk_reservation_id INTEGER NOT NULL UNIQUE
	,PRIMARY KEY (id)
	,FOREIGN KEY (fk_reservation_id) REFERENCES reservation(id)
	,FOREIGN KEY (fk_employee_id) REFERENCES employee(id)
	);
