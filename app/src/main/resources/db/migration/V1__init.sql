-- Drop table

-- DROP TABLE public."location";

CREATE TABLE public."location" (
	id serial NOT NULL,
	"name" varchar NULL,
	CONSTRAINT location_pk PRIMARY KEY (id)
);


-- Drop table

-- DROP TABLE public.user_account;

CREATE TABLE public.user_account (
	id serial NOT NULL,
	"name" varchar NULL,
	gender varchar NULL,
	about varchar NULL,
	location_id int4 NULL,
	birth_date date NULL,
	phone varchar NULL,
	CONSTRAINT user_account_pk PRIMARY KEY (id)
);

ALTER TABLE public.user_account ADD CONSTRAINT user_account_fk FOREIGN KEY (location_id) REFERENCES location(id);

-- Drop table

-- DROP TABLE public.message;

CREATE TABLE public.message (
	id serial NOT NULL,
	body varchar NULL,
	created timestamp NULL,
	from_user_id int4 NULL,
	to_user_id int4 NULL,
	CONSTRAINT message_pk PRIMARY KEY (id)
);

ALTER TABLE public.message ADD CONSTRAINT message_from_user_fk FOREIGN KEY (from_user_id) REFERENCES user_account(id);
ALTER TABLE public.message ADD CONSTRAINT message_to_user_fk FOREIGN KEY (to_user_id) REFERENCES user_account(id);

