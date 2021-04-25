CREATE TABLE if NOT EXISTS employee
(
    employee_id bigserial NOT NULL
        CONSTRAINT employee_pkey
            PRIMARY KEY ,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    department_id bigserial NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    gender VARCHAR (6) NOT NULL,
    date_of_birth DATE NOT NULL
);