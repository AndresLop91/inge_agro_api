-- public.gender definition

-- Drop table

-- DROP TABLE public.gender;

CREATE TABLE public.gender (
	id int8 NOT NULL,
	gender_name varchar(255) NULL,
	CONSTRAINT gender_pkey PRIMARY KEY (id)
);


-- public.identification_type definition

-- Drop table

-- DROP TABLE public.identification_type;

CREATE TABLE public.identification_type (
	id int8 NOT NULL,
	identification_type varchar(255) NULL,
	CONSTRAINT identification_type_pkey PRIMARY KEY (id)
);


-- public.product_type definition

-- Drop table

-- DROP TABLE public.product_type;

CREATE TABLE public.product_type (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT product_type_pkey PRIMARY KEY (id)
);


-- public.quantity_type definition

-- Drop table

-- DROP TABLE public.quantity_type;

CREATE TABLE public.quantity_type (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT quantity_type_pkey PRIMARY KEY (id)
);


-- public.stock definition

-- Drop table

-- DROP TABLE public.stock;

CREATE TABLE public.stock (
	id int8 NOT NULL,
	initial_quantity int4 NULL,
	remaining_quantity int4 NULL,
	sold_quantity int4 NULL,
	time_creation timestamp NULL,
	CONSTRAINT stock_pkey PRIMARY KEY (id)
);


-- public.person definition

-- Drop table

-- DROP TABLE public.person;

CREATE TABLE public.person (
	id int8 NOT NULL,
	born_date timestamp NULL,
	first_name varchar(255) NULL,
	identification_number varchar(255) NULL,
	last_name varchar(255) NULL,
	time_creation timestamp NULL,
	gender_id int8 NULL,
	identification_type_id int8 NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id),
	CONSTRAINT fkdnrxegc10d13rsmlda9n6trqk FOREIGN KEY (identification_type_id) REFERENCES public.identification_type(id),
	CONSTRAINT fko03vt9dgcffsjsb0jiaiuomc2 FOREIGN KEY (gender_id) REFERENCES public.gender(id)
);


-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id int8 NOT NULL,
	description varchar(255) NULL,
	price numeric(19, 2) NULL,
	time_creation timestamp NULL,
	product_type_id int8 NULL,
	quantity_type_id int8 NULL,
	stock_id int8 NULL,
	active bool NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id),
	CONSTRAINT fk90w0j7y2y7chsmk4v4k02ekqf FOREIGN KEY (stock_id) REFERENCES public.stock(id),
	CONSTRAINT fklabq3c2e90ybbxk58rc48byqo FOREIGN KEY (product_type_id) REFERENCES public.product_type(id),
	CONSTRAINT fklfsayunh1vy5to1b9qx04v1tw FOREIGN KEY (quantity_type_id) REFERENCES public.quantity_type(id)
);


-- public.sell_product definition

-- Drop table

-- DROP TABLE public.sell_product;

CREATE TABLE public.sell_product (
	id int8 NOT NULL,
	quantity int4 NULL,
	product_id int8 NULL,
	CONSTRAINT sell_product_pkey PRIMARY KEY (id),
	CONSTRAINT fkhgntlm6y1w1v74qwkxkp2ni13 FOREIGN KEY (product_id) REFERENCES public.product(id)
);


-- public.user_data definition

-- Drop table

-- DROP TABLE public.user_data;

CREATE TABLE public.user_data (
	id int8 NOT NULL,
	"password" varchar(255) NULL,
	time_creation timestamp NULL,
	time_modification timestamp NULL,
	username varchar(255) NULL,
	person_id int8 NULL,
	CONSTRAINT user_data_pkey PRIMARY KEY (id),
	CONSTRAINT fki35m64fnmry2li889uk0t9pwj FOREIGN KEY (person_id) REFERENCES public.person(id)
);


-- public.guest_user definition

-- Drop table

-- DROP TABLE public.guest_user;

CREATE TABLE public.guest_user (
	id int8 NOT NULL,
	person_id int8 NULL,
	CONSTRAINT guest_user_pkey PRIMARY KEY (id),
	CONSTRAINT fkmb61favehcso0aprc42u0ji4s FOREIGN KEY (person_id) REFERENCES public.person(id)
);


-- public.seller definition

-- Drop table

-- DROP TABLE public.seller;

CREATE TABLE public.seller (
	id int8 NOT NULL,
	time_creation timestamp NULL,
	user_id int8 NULL,
	CONSTRAINT seller_pkey PRIMARY KEY (id),
	CONSTRAINT fks88slijk51hepln3i20hw1wm7 FOREIGN KEY (user_id) REFERENCES public.user_data(id)
);


-- public.seller_products definition

-- Drop table

-- DROP TABLE public.seller_products;

CREATE TABLE public.seller_products (
	seller_data_id int8 NOT NULL,
	products_id int8 NOT NULL,
	CONSTRAINT uk_iemjsutf7nimmyt7xoelaktg1 UNIQUE (products_id),
	CONSTRAINT fk1lvaagcjjuytidwm9608hsg0y FOREIGN KEY (products_id) REFERENCES public.product(id),
	CONSTRAINT fktb3b4owlwv7xm2p4sbw17gtob FOREIGN KEY (seller_data_id) REFERENCES public.seller(id)
);


-- public.buyer definition

-- Drop table

-- DROP TABLE public.buyer;

CREATE TABLE public.buyer (
	id int8 NOT NULL,
	creation_time timestamp NULL,
	is_guest bool NULL,
	guest_user_id int8 NULL,
	user_id int8 NULL,
	CONSTRAINT buyer_pkey PRIMARY KEY (id),
	CONSTRAINT fkglon7t418aq44b3jue26bxcfn FOREIGN KEY (guest_user_id) REFERENCES public.guest_user(id),
	CONSTRAINT fklnl8eh2bar3qch8751pqha8hj FOREIGN KEY (user_id) REFERENCES public.user_data(id)
);


-- public.cart definition

-- Drop table

-- DROP TABLE public.cart;

CREATE TABLE public.cart (
	id int8 NOT NULL,
	user_id int8 NULL,
	bought bool NULL,
	CONSTRAINT cart_pkey PRIMARY KEY (id),
	CONSTRAINT fkpdupa21asbc6naosjvgmrtgvs FOREIGN KEY (user_id) REFERENCES public.buyer(id)
);


-- public.cart_products definition

-- Drop table

-- DROP TABLE public.cart_products;

CREATE TABLE public.cart_products (
	cart_data_id int8 NOT NULL,
	products_id int8 NOT NULL,
	CONSTRAINT uk_3kg5kx19f8oy0lo76hdhc1uw1 UNIQUE (products_id),
	CONSTRAINT fkeg95xj1r4leh4p88k52fjcfgx FOREIGN KEY (products_id) REFERENCES public.sell_product(id),
	CONSTRAINT fkg0ge9mb822x2wvcygbrrb1pgg FOREIGN KEY (cart_data_id) REFERENCES public.cart(id)
);