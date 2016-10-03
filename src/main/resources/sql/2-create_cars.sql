CREATE TABLE public.cars
(
    id bigint NOT NULL,
    color character varying,
    model character varying,
    CONSTRAINT cars_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

ALTER TABLE public.cars
    OWNER to postgres;

 insert into cars (select 1, 'Orange', '2101');
 insert into cars (select 2, 'Blue', '2101');
 insert into cars (select 3, 'Dark', '2101');
 insert into cars (select 4, 'Orange', '2102');
 insert into cars (select 5, 'Blue', '2102');
 insert into cars (select 6, 'Red', '2102');
 insert into cars (select 7, 'Dark', '2103');
 insert into cars (select 8, 'Orange', '2104');
 insert into cars (select 9, 'Dark', '2104');
