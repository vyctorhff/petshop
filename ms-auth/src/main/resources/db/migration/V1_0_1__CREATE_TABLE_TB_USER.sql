CREATE TABLE tb_user(
    id SERIAL PRIMARY KEY,
    enrollment varchar(11) NOT NULL UNIQUE,
    pass varchar(20) NOT NULL
);