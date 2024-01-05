ALTER TABLE tb_user
    DROP COLUMN pass;

ALTER TABLE tb_user
    ADD COLUMN pass varchar(50);
