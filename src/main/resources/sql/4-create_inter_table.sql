CREATE TABLE public.inter
(
    user_id bigint NOT NULL,
    car_id bigint NOT NULL,
    CONSTRAINT "car_id_FK" FOREIGN KEY (car_id)
        REFERENCES public.cars (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "user_id_FK" FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
) TABLESPACE pg_default;

ALTER TABLE public.inter OWNER to postgres;

insert into inter (select 1, 1);
insert into inter (select 1, 2);
insert into inter (select 2, 3);
insert into inter (select 3, 4);
insert into inter (select 5, 7);
insert into inter (select 5, 8);
insert into inter (select 5, 9);