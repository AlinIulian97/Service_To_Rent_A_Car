  create table car
  (
       id_car integer not null,
        status varchar(255),
        amount double precision,
        body_type varchar(255),
        car_name varchar(255),
        colour varchar(255),
        mileage integer,
        model varchar(255),
        primary key (id_car)
        );

        create table customer
        (
        id integer not null,
        first_name varchar(255),
        name varchar(255),
        email varchar(255),
        address varchar(255)
        );

        create table revenue(
        id integer not null,
        car_rental_amount integer
        )