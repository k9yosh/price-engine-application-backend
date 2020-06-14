create table product
(
	id serial not null
		constraint product_pk
			primary key,
	name varchar not null,
	carton_units integer not null,
	carton_price numeric(12,2) default 0.00 not null
);

alter table product owner to postgres;

INSERT INTO public.product (id, name, carton_units, carton_price) VALUES (1, 'Penguine-Ears', 20, 175.00);
INSERT INTO public.product (id, name, carton_units, carton_price) VALUES (2, 'Horseshoe', 5, 825.00);