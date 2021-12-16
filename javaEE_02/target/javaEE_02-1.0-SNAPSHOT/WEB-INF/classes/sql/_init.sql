-- sqlite

-- 删除所有相关表
drop table if exists user;
drop table if exists Commodity;
drop table if exists user_Commodity;
drop table if exists Cart;
drop table if exists detail_img;
drop table if exists commodity_detail_img;

-- 用户表
create table user
(
    id           integer primary key autoincrement not null,
    user_account varchar(10)                       not null,
    password     varchar(16)                       not null
);

-- 商品信息表
create table Commodity
(
    id     integer primary key autoincrement not null,
    name   varchar(20)                       not null,
    detail varchar(200),
    price  double                            not null,
    count  integer                           not null
);

-- 用户-商品关联表
create table user_Commodity
(
    id           integer primary key autoincrement not null,
    user_id      integer                           not null,
    commodity_id integer                           not null
);

--购物车
create table Cart
(
    id              integer primary key autoincrement not null,
    user_id         integer                           not null,
    commodity_id    integer                           not null,
    commodity_count integer                           not null
);

-- 商品图片表
create table detail_img
(
    id       integer primary key autoincrement not null,
    img_info varchar(300)                      not null
);

-- 商品与图片的关联表
create table commodity_detail_img
(
    id           integer primary key autoincrement not null,
    img_info     varchar(300)                      not null,
    commodity_id integer                           not null
);

insert into user(user_account, password)
VALUES ('test', '123456');





