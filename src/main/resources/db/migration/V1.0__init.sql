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
        last_name varchar(255),
        email varchar(255),
        address varchar(255)
        );

        create table revenue(
        id integer not null,
        car_rental_amount double precision
        );

        create table reservation(
        id integer not null,
        date_of_reservation varchar(255),
        date_from varchar(255),
        date_to varchar (255),




        );