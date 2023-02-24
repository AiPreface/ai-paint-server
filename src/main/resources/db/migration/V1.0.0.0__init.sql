CREATE TABLE `paint`
(
    `id`            bigint unsigned                                               NOT NULL COMMENT '主键',
    `user_id`       varchar(50) COLLATE utf8mb4_general_ci                        NOT NULL COMMENT '用户id',
    `image_url`     varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图链',
    `title`         varchar(255) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '标题',
    `like_count`    int unsigned                                                  NOT NULL COMMENT '点赞数',
    `comment_count` int unsigned                                                  NOT NULL COMMENT '评论数',
    `create_time`   datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      NOT NULL COMMENT '更新时间',
    `is_deleted`    tinyint unsigned                                              NOT NULL COMMENT '逻辑删除',
    PRIMARY KEY (`id`),
    KEY `idx_create_time` (`create_time`),
    KEY `idx_user_id_create_time` (`user_id`, `create_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `paint_tag`
(
    `id`          bigint unsigned                         NOT NULL,
    `paint_id`    bigint                                  NOT NULL COMMENT '绘图id',
    `tag`         varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签，例如JK、原神，一个标签一条数据',
    `create_time` datetime                                NOT NULL COMMENT '创建时间',
    `update_time` datetime                                NOT NULL COMMENT '更新时间',
    `is_deleted`  tinyint unsigned                        NOT NULL COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `paint_comment`
(
    `id`          bigint unsigned                                              NOT NULL,
    `paint_id`    bigint                                                       NOT NULL COMMENT '绘图id',
    `user_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
    `comment`     varchar(1000) COLLATE utf8mb4_general_ci                     NOT NULL COMMENT '评论',
    `create_time` datetime                                                     NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                     NOT NULL COMMENT '更新时间',
    `is_deleted`  tinyint unsigned                                             NOT NULL COMMENT '逻辑删除',
    PRIMARY KEY (`id`),
    KEY `idx_paint_id_user_id` (`paint_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `paint_like`
(
    `id`          bigint unsigned                                              NOT NULL,
    `paint_id`    bigint                                                       NOT NULL COMMENT '绘图id',
    `user_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
    `create_time` datetime                                                     NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                     NOT NULL COMMENT '更新时间',
    `is_deleted`  tinyint unsigned                                             NOT NULL COMMENT '逻辑删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_paint_id_user_id` (`paint_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;