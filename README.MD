# 使用方法

1. 安装maven,配置环境变量

2. 安装mysql，创建db，名称自取，创建users表，表的样式为

+----------+----------+------+------+
| name     | password | uid  | age  |
+----------+----------+------+------+
| admin    | 654321   |  100 |   50 |

包括name(String),password(String),uid(int),age(int)四个字段

3.修改配置文件
#Mysql 连接
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/**db名称**?characterEncoding=utf8&useSSL=false
spring.datasource.username=*数据库用户名*
spring.datasource.password=*数据库密码*

4.运行
命令： mvn spring-boot:run