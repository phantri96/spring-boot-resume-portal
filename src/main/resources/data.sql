INSERT INTO user (id, user_name, password, active, roles) VALUES
(1, 'bob', '123456', true, 'USER'),
(2, 'admin', '123456', true, 'ADMIN'),
(3, 'alice', '123456', true, 'USER');

INSERT INTO user_profile (id, user_name, theme, summary, first_name, last_name, email) VALUES
(1, 'bob', '1', 'test summary of bob', 'bob', 'cristiano', 'crisbob@gmail.com'),
(2, 'admin', '2', 'test summary of admin', 'admin', 'resume', 'resumeadmin@mgmail.com'),
(3, 'alice', '3', 'test summary of alice', 'alice', 'roger', 'raclice@gmail.com');

INSERT INTO job_history (id, summary, title, from_date, to_date, current_job) VALUES
(11, 'bob dxc vietnam', 'associate software engineer', '2019-08-25', '2021-05-01', false),
(12, 'bob sai digital', 'software engineer', '2021-05-01', '2021-12-01', true),
(13, 'admin dxc vietnam', 'associate software engineer', '2019-08-25', '2021-05-01', false),
(14, 'admin sai digital', 'software engineer', '2021-05-01', '2021-12-01', true),
(15, 'alice dxc vietnam', 'associate software engineer', '2019-08-25', '2021-05-01', false),
(16, 'alice sai digital', 'software engineer', '2021-05-01', '2021-12-01', true);


INSERT INTO user_job_history_relation (user_id, job_history_id) VALUES
(1, 11),
(1, 12),
(2, 13),
(2, 14),
(3, 15),
(3, 16);