INSERT INTO tb_user
(id, enrollment, pass)
VALUES
(1, '1', '$2a$10$nAJ2Cfmr2nT0/vcYaQUD2eX7hZOmYTVp7PzO62ot2/b3WffES8Pf6');

INSERT INTO tb_user_role
(id, user_id, role_id)
VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3);