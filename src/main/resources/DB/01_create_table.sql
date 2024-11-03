CREATE TABLE meli.iptrace (
	id serial8 NOT NULL,
	pais varchar(100) NULL,
	distancia float8 NULL,
	invocaciones int8 NULL,
	CONSTRAINT iptrace_pk PRIMARY KEY (id)
);
