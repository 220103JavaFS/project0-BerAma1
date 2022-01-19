CREATE TABLE address (
	address_id serial4 NOT NULL,
	street_address varchar(15) NULL,
	city varchar(30) NULL,
	state varchar(30) NULL,
	zip_code varchar(15) NULL,
	CONSTRAINT address_pkey PRIMARY KEY (address_id)
);


CREATE TABLE account (
	account_id int4 NOT NULL,
	acct_type varchar(15) NULL,
	act_balance numeric(20, 2) NULL,
	act_status varchar(15) NULL,
	open_date date NULL,
	interest_rate numeric(5, 3) NULL,
	CONSTRAINT account_pkey PRIMARY KEY (account_id)
);

-- public.customer definition



CREATE TABLE customer (
	cust_id int4 NOT NULL,
	firsname varchar(15) NULL,
	lastname varchar(15) NULL,
	phonenumber varchar(15) NULL,
	email varchar(15) NULL,
	username varchar(15) NULL,
	"password" varchar(15) NULL,
	user_role varchar(15) NULL,
	address_id int4 NULL,
	transfer_id int4 NULL,
	deposit_id int4 NULL,
	CONSTRAINT customer_email_key UNIQUE (email),
	CONSTRAINT customer_phonenumber_key UNIQUE (phonenumber),
	CONSTRAINT customer_pkey PRIMARY KEY (cust_id)
);


-- public.customer foreign keys

ALTER TABLE public.customer ADD CONSTRAINT customer_address_id_fkey FOREIGN KEY (address_id) REFERENCES address(address_id);
ALTER TABLE public.customer ADD CONSTRAINT customer_deposit_id_fkey FOREIGN KEY (deposit_id) REFERENCES deposit(deposit_id);
ALTER TABLE public.customer ADD CONSTRAINT customer_transfer_id_fkey FOREIGN KEY (transfer_id) REFERENCES transfer(transfer_id);


CREATE TABLE customer_account (
	cust_id int4 NULL,
	account_id int4 NULL
);


-- public.customer_account foreign keys

ALTER TABLE public.customer_account ADD CONSTRAINT customer_account_account_id_fkey FOREIGN KEY (account_id) REFERENCES account(account_id);
ALTER TABLE public.customer_account ADD CONSTRAINT customer_account_cust_id_fkey FOREIGN KEY (cust_id) REFERENCES customer(cust_id);

-- public.deposit definition


CREATE TABLE deposit (
	deposit_id serial4 NOT NULL,
	sender_id int4 NULL,
	sender_account int4 NULL,
	receiver_id int4 NULL,
	receiver_account int4 NULL,
	deposit_amount numeric(4, 2) NULL,
	deposit_date date NULL,
	CONSTRAINT deposit_pkey PRIMARY KEY (deposit_id)
); -- public.employee definition

-- Drop table

-- DROP TABLE employee;

CREATE TABLE employee (
	emp_id int4 NOT NULL,
	firsname varchar(15) NULL,
	lastname varchar(15) NULL,
	phonenumber varchar(15) NULL,
	email varchar(15) NULL,
	username varchar(15) NULL,
	"password" varchar(15) NULL,
	emp_role varchar(15) NULL,
	address_id int4 NULL,
	transfer_id int4 NULL,
	deposit_id int4 NULL,
	CONSTRAINT employee_email_key UNIQUE (email),
	CONSTRAINT employee_phonenumber_key UNIQUE (phonenumber),
	CONSTRAINT employee_pkey PRIMARY KEY (emp_id)
);


-- public.employee foreign keys

ALTER TABLE public.employee ADD CONSTRAINT employee_address_id_fkey FOREIGN KEY (address_id) REFERENCES address(address_id);
ALTER TABLE public.employee ADD CONSTRAINT employee_deposit_id_fkey FOREIGN KEY (deposit_id) REFERENCES deposit(deposit_id);
ALTER TABLE public.employee ADD CONSTRAINT employee_transfer_id_fkey FOREIGN KEY (transfer_id) REFERENCES transfer(transfer_id);

-- public.indentity definition

-- Drop table

-- DROP TABLE indentity;

CREATE TABLE indentity (
	id_type varchar(15) NULL,
	id_number varchar(15) NOT NULL,
	cust_id int4 NULL,
	issued_state varchar(15) NULL,
	issued_date date NULL,
	exp_date date NULL,
	date_of_birth date NULL,
	CONSTRAINT indentity_pkey PRIMARY KEY (id_number)
);


-- public.indentity foreign keys

ALTER TABLE public.indentity ADD CONSTRAINT indentity_cust_id_fkey FOREIGN KEY (cust_id) REFERENCES customer(cust_id);

-- public.login definition


CREATE TABLE login (
	user_id int4 NULL,
	username varchar(15) NULL,
	"password" varchar(15) NULL,
	user_role varchar(15) NULL
);

-- public.transfer definition


CREATE TABLE transfer (
	transfer_id serial4 NOT NULL,
	sender_id int4 NULL,
	sender_account int4 NULL,
	receiver_id int4 NULL,
	receiver_account int4 NULL,
	transfer_amount numeric(4, 2) NULL,
	transfer_date date NULL,
	CONSTRAINT transfer_pkey PRIMARY KEY (transfer_id)
);
-- public.withdraw definition


CREATE TABLE withdraw (
	withdraw_id int4 NOT NULL,
	withdrawer_id int4 NULL,
	withdrawer_account int4 NULL,
	withdraw_amount int4 NULL,
	withdraw_date date NULL DEFAULT CURRENT_DATE,
	CONSTRAINT withdraw_pkey PRIMARY KEY (withdraw_id)
);
