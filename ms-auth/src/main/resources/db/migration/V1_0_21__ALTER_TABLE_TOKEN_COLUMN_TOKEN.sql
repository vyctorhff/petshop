ALTER TABLE tb_token
    DROP COLUMN token;

ALTER TABLE tb_token
    ADD COLUMN token varchar(300);
