create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE patient (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(64) not null,
    surname varchar(64) not null,
    patronymic varchar(64) not null,
    doctor varchar(64) not null,
    PRIMARY KEY (id)
) engine=MyISAM;