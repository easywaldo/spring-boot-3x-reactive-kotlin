DROP TABLE IF EXISTS book;
create table book (
    ID bigint NOT NULL AUTO_INCREMENT,
    NAME varchar(100) not null,
    WRITER varchar(100) not null,
    created_at date,
    updated_at date,
    primary key(ID)
)