create database ibzi
	with owner postgres
;

create table if not exists test
(
	id integer not null
		constraint task_pkey
			primary key,
	title varchar(50)
)
;

alter table test owner to postgres
;

create table if not exists task
(
	id integer not null
		constraint task_pkey1
			primary key,
	type varchar(100),
	name varchar(100),
	test_id integer
		constraint task_test_id_fk
			references test
)
;

alter table task owner to postgres
;

create table if not exists question
(
	id integer not null
		constraint question_pk
			primary key,
	name varchar(100),
	task_id integer
		constraint question_task_id_fk
			references task
)
;

alter table question owner to postgres
;

create table if not exists answer
(
	id integer not null
		constraint answer_pk
			primary key,
	question_id integer
		constraint answer_question_id_fk
			references question,
	name varchar(100),
	is_correct boolean
)
;

alter table answer owner to postgres
;

