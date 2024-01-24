ALTER TABLE tb_user
    DROP COLUMN password;

ALTER TABLE tb_user
    ADD COLUMN pass VARCHAR(100);

UPDATE tb_user
    SET pass = '$2a$10$nAJ2Cfmr2nT0/vcYaQUD2eX7hZOmYTVp7PzO62ot2/b3WffES8Pf6'
WHERE
    name = 'admin';
