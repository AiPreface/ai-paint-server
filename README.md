## ai-paint-server

绘图后台服务。

# Installation and Getting Started

`推荐使用docker部署避免环境问题。`

## docker-compose部署

### 准备工作

1. 下载[docker-compose.yaml](paint-admin%2Fdocker-compose.yaml)，放入任意目录，例如/paint
2. 下载[mysql](paint-admin%2Fsrc%2Fmain%2Fresources%2Fdocker%2Fmysql)
   目录，与[docker-compose.yaml](paint-admin%2Fdocker-compose.yaml)所在目录同级，这是mysql docker相关配置文件
3. 下载[redis](paint-admin%2Fsrc%2Fmain%2Fresources%2Fdocker%2Fredis)
   目录，与[docker-compose.yaml](paint-admin%2Fdocker-compose.yaml)所在目录同级，这是redis docker相关配置文件
4. 打开[docker-compose.yaml](paint-admin%2Fdocker-compose.yaml)
   ，修改相关配置，具体请看文件内注释，关键是修改映射端口和各服务密码，如果要映射端口到宿主机，请勿设置空密码或简单密码。

示例目录结构

```
.
├── paint
│   ├── docker-compose.yaml
│   ├── mysql
│   ├── redis
```

### 运行项目

* 后台运行

```
docker-compose up -d
```

* 停止运行

```
docker-compose stop
```

* 停止并卸载容器

```
docker-compose down
```

* 查看日志

```
docker-compose logs -f paint-server --tail=400
```

* 查看接口文档

```
http://localhost:9527/prod-api/swagger-ui/index.html
```

* 重启

```
docker-compose restart
```

* 有新镜像时更新

```
docker-compose stop
docker-compose pull
docker-compose up -d --remove-orphans
```

## 鸣谢

RuoYi-Vue