 create table rental(
  id integer not null,
        type varchar(255),
         name_rental varchar(255),
         contact_address varchar(255),
         owner varchar(255),
         logo_type varchar(255),
         primary key (id)
 );

  create table branch (
       id integer not null,
        address_city varchar(255),
        fk_rental_id integer not null,
        primary key (id),
        foreign key(fk_rental_id) references rental(id)
        );