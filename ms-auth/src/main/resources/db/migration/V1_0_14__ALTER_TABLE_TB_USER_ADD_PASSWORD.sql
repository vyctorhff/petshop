ALTER TABLE tb_user
    DROP COLUMN pass;

ALTER TABLE tb_user
    ADD COLUMN password VARCHAR(100);
