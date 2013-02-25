# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table app_logger (
  id                        bigint auto_increment not null,
  app_name                  varchar(255),
  event                     varchar(255),
  timestamp                 varchar(255),
  content                   varchar(255),
  display_id                varchar(255),
  constraint pk_app_logger primary key (id))
;

create table location (
  id                        bigint auto_increment not null,
  location_name             varchar(255),
  fb_album                  varchar(255),
  constraint pk_location primary key (id))
;

create table parameters (
  id                        bigint auto_increment not null,
  app_id                    varchar(255),
  app_secret                varchar(255),
  app_access_token          varchar(255),
  url                       varchar(255),
  permissions               varchar(255),
  page_id                   varchar(255),
  page_access_token         varchar(255),
  constraint pk_parameters primary key (id))
;

create table photo_item (
  id                        bigint auto_increment not null,
  file_name                 varchar(255),
  likes                     bigint,
  comments                  bigint,
  fb_id                     varchar(255),
  display_id                varchar(255),
  constraint pk_photo_item primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table app_logger;

drop table location;

drop table parameters;

drop table photo_item;

SET FOREIGN_KEY_CHECKS=1;

