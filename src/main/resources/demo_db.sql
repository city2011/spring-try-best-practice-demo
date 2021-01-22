-- auto-generated definition
create table demo_table
(
    id           int auto_increment
        primary key,
    demo_name    varchar(64)                         null,
    demo_value   varchar(64)                         null,
    create_time  timestamp default CURRENT_TIMESTAMP not null,
    update_time  timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    content_text text                                null
);