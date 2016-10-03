 create table public.cities
    (
        id bigint not null,
        name character varying not null,
        constraint cities_pkey primary key (id)
    )
    tablespace pg_default;

alter table public.cities owner to postgres;

 insert into cities (select 1, 'Perm');
 insert into cities (select 2, 'Saratov');
 insert into cities (select 3, 'Novosibirsk');
 insert into cities (select 4, 'City4');
 insert into cities (select 5, 'City5');
 insert into cities (select 6, 'City6');
 insert into cities (select 7, 'City7');
 insert into cities (select 8, 'City8');
 insert into cities (select 9, 'City9');
 insert into cities (select 10, 'City10');