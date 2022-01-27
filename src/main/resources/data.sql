INSERT INTO user (id, user_name, password, active, roles) VALUES
(1, 'bob', '123456', true, 'USER'),
(2, 'admin', '123456', true, 'ADMIN'),
(3, 'alice', '123456', true, 'USER');

INSERT INTO user_profile (id, user_name, theme, summary, first_name, last_name, email) VALUES
(1, 'bob', '1', 'test summary of bob', 'bob', 'cristiano', 'crisbob@gmail.com'),
(2, 'admin', '2', 'test summary of admin', 'admin', 'resume', 'resumeadmin@mgmail.com'),
(3, 'alice', '3', 'test summary of alice', 'alice', 'roger', 'raclice@gmail.com');

INSERT INTO job_history (id, summary, title, from_date, to_date, current_job, user_id) VALUES
(11, 'bob dxc vietnam', 'associate software engineer', '2019-08-25', '2021-05-01', false, 1),
(12, 'bob sai digital', 'software engineer', '2021-05-01', '2021-12-01', true, 1),
(13, 'admin dxc vietnam', 'associate software engineer', '2019-08-25', '2021-05-01', false, 2),
(14, 'admin sai digital', 'software engineer', '2021-05-01', '2021-12-01', true, 2),
(15, 'alice dxc vietnam', 'associate software engineer', '2019-08-25', '2021-05-01', false, 3),
(16, 'alice sai digital', 'software engineer', '2021-05-01', '2021-12-01', true, 3);

INSERT INTO job_responsibility (job_id, responsibility) VALUES
(11, 'estimate user story and break down task'),
(11, 'work with SA and front end team to design rest api'),
(11, 'develop new feature, bug fixing'),
(12, 'develop new SAP feature'),
(12, 'service maintenance, bug fixing'),
(13, 'estimate user story and break down task'),
(13, 'work with SA and front end team to design rest api'),
(13, 'develop new feature, bug fixing'),
(14, 'develop new SAP feature'),
(14, 'service maintenance, bug fixing'),
(15, 'estimate user story and break down task'),
(15, 'work with SA and front end team to design rest api'),
(15, 'develop new feature, bug fixing'),
(16, 'develop new SAP feature'),
(16, 'service maintenance, bug fixing');

INSERT INTO education (id, from_date, to_date, qualification, school_name, summary, user_id) VALUES
(1, '2014-09-11', '2018-09-11', 'bachelor degree','university of science', 'information technology', 1),
(2, '2014-09-11', '2018-09-11', 'bachelor degree', 'university of science', 'information technology', 2),
(3, '2014-09-11', '2018-09-11', 'bachelor degree', 'university of science', 'information technology', 3);

INSERT INTO user_skill (user_id, skill) VALUES
(1, 'HTML'),
(1, 'CSS'),
(1, 'JAVA'),
(1, 'GIT'),
(2, 'HTML'),
(2, 'CSS'),
(2, 'JAVA'),
(2, 'GIT'),
(3, 'HTML'),
(3, 'CSS'),
(3, 'JAVA'),
(3, 'GIT');


--
--INSERT INTO user_job_history_relation (user_id, job_history_id) VALUES
--(1, 11),
--(1, 12),
--(2, 13),
--(2, 14),
--(3, 15),
--(3, 16);