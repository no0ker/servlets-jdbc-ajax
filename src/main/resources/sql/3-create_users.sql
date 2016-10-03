CREATE TABLE public.users
(
    id bigint NOT NULL,
    firstname character varying,
    middlename character varying,
    secondname character varying,
    city_id bigint,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT "city_id_FK" FOREIGN KEY (city_id)
        REFERENCES public.cities (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;

ALTER TABLE public.users OWNER to postgres;

insert into users (select 1, 'FN1', 'MN1', 'SN1', '1');
insert into users (select 2, 'FN2', 'MN2', 'SN2', '1');
insert into users (select 3, 'FN3', 'MN3', 'SN3', '1');
insert into users (select 4, 'FN4', 'MN4', 'SN4', '2');
insert into users (select 5, 'FN5', 'MN5', 'SN5', '2');
insert into users (select 6, 'FN6', 'MN6', 'SN6', '5');
insert into users (select 7, 'FN7', 'MN7', 'SN7', '10');