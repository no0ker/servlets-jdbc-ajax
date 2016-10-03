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