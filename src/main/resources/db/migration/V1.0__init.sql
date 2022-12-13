  create table car
  (
       id integer not null,
        status varchar(255),
        amount double precision,
        body_type varchar(255),
        car_name varchar(255),
        colour varchar(255),
        mileage integer,
        model varchar(255),
        primary key (id)
        );

  create table customer
        (
        id integer not null,
        first_name varchar(255),
        name varchar(255),
        email varchar(255),
        address varchar(255),
        primary key (id)
        );

   CREATE TABLE reservation
                (
                id integer not null,
                date_of_reservation datetime(6),
                date_from datetime(6),
                date_to datetime(6),
                amount double,
                primary key (id),
                car_id integer not null,
                customer_id integer not null,
                foreign key(car_id) references car(id),
                foreign key(customer_id) references customer(id)
                );

         create table rental
         (
          id integer not null,
                type varchar(255),
                 name_rental varchar(255),
                 internet_domain varchar(255),
                 contact_address varchar(255),
                 owner varchar(255),
                 logo_type varchar(255),
                 primary key (id)
         );

          create table branch
          (
               id integer not null,
                address_city varchar(255),
                fk_rental_id integer not null,
                primary key (id),
                foreign key(fk_rental_id) references rental(id)
                );

                create table employee
                (
                 id integer not null,
                 type varchar(255),
                 first_name varchar(255),
                 last_name varchar(255),
                 colour varchar(255),
                 position varchar(255),
                 primary key (id)
                );

                 create table revenue
                        (
                        id integer not null,
                        car_rental_amount double precision
                        );


      create table  refund
      (
      id integer not null,
      return_date datetime(6),
      surcharge double,
      comments varchar(255),
      fk_employee_id integer NOT NULL,
      fk_reservation_id integer NOT NULL,
      primary key(id),
      FOREIGN key (`fk_reservation_id`) references `reservation`(id),
      FOREIGN KEY (`fk_employee_id`) REFERENCES `employee`(id)
      );

         create table employee_work_branch
                     (
                     branch_id integer NOT NULL,
                     employee_id integer NOT NULL,
                     PRIMARY KEY (branch_id , employee_id ),
                     FOREIGN KEY (`branch_id`) REFERENCES `branch`(id),
                     FOREIGN KEY (`employee_id`) REFERENCES `employee`(id)
                      );
