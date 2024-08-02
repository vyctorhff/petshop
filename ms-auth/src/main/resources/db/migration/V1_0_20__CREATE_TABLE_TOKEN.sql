CREATE TABLE tb_token(
    id serial PRIMARY KEY,
    user_id integer,
    token varchar(100),
    refresh varchar(70),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES tb_user
);