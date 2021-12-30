create table sys_user
(
    id          bigint       not null comment 'id',
    username    varchar(20)  not null comment '账号',
    password    varchar(200) not null comment '密码',
    status      tinyint(1) default 1 not null comment '状态 1可用 0禁用',
    create_time datetime     not null comment '创建时间',
    update_time datetime     not null comment '修改时间',
    is_del      tinyint      not null comment '是否删除 0否 1是',
    constraint sys_user_pk
        primary key (id)
) comment '系统用户表';

create unique index sys_user_username_uindex
    on sys_user (username);