# 放入docker-compose.yaml ./mysql/init目录下，用于mysql数据库初始化后执行，创建业务服务所需数据库
drop database if exists `ai_paint`;
CREATE DATABASE `ai_paint` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;