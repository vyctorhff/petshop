ALTER TABLE tb_user
    DROP COLUMN enrollment;

ALTER TABLE tb_user
    ADD COLUMN enrollment INTEGER;
