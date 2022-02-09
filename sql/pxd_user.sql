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

create table sys_user_route
(
    id          bigint auto_increment comment 'id'
        primary key,
    user_id     bigint   not null comment '用户id',
    route_id    bigint   not null comment '权限（路由）id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
)
    comment '用户路由（权限）关联表';

create table sys_route
(
    id          bigint auto_increment comment 'id'
        primary key,
    parent_id   bigint default 0 not null comment '父id',
    name        varchar(20)      not null comment '名称',
    path        varchar(512)     null comment '路径',
    meta        varchar(1024)    null comment '附属信息',
    permission  varchar(512)     null comment '权限',
    create_time datetime         not null comment '创建时间',
    update_time datetime         not null comment '修改时间'
)
    comment '路由信息';

