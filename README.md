<p align="center">
  <h2>Spring-Boot-Api-Starter</h2>
</p>

<p align="center">  
  <a href="https://github.com/spring-projects/spring-boot">
    <img alt="spring boot version" src="https://img.shields.io/badge/spring%20boot-2.1.9.RELEASE-brightgreen">
  </a>
  <a href="https://github.com/wongminho/spring-boot-api-starter/releases">
    <img alt="spring-boot-api-starter releases" src="https://img.shields.io/github/release/wongminho/spring-boot-api-starter.svg?style=flat-square">
  </a>
</p>

## 简介

Spring-Boot-Api-Starter 是一个基于`SpringBoot`，快速构建`RESTful API`工程的脚手架，支持多数据源配置、分布式事务；快速生成各模块的基础代码，极大的提升了开发效率，使团队代码风格保持统一。

## 特征
- 集成 Spring Boot 常用开发组件集
- 集成 Mybatis Plus、Mybatis Plus Generator组件；实现单表业务零SQL
- 集成 Atomikos 支持分布式事务、以及支持多数据源配置
- 统一异常处理
- 统一响应结果封装
- 基于 JWT 实现基于 Token 的鉴权机制
- 使用 Druid Spring Boot Starter 集成 Druid 数据库连接池与监控
- 使用 AutoGenerator 快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率，使团队代码风格保持统一

### 项目环境 
中间件 | 版本 |  备注
-|-|-
JDK | 1.8+ | JDK1.8及以上 |
MySQL | 5.6+ | 5.6及以上，如果使用Druid的分布式驱动，暂不支持8.0+ |

### 技术选型
技术 | 版本 |  备注
-|-|-
Spring Boot | 2.1.9.RELEASE | 最新发布稳定版 |
Mybatis | 3.5.2 | 持久层框架 |
Mybatis Plus | 3.2.0 | Mybatis增强框架 |
Mybatis Plus Generator | 3.2.0 | MyBatis-Plus 的代码生成器 |
Jta-Atomikos | 2.1.9.RELEASE | 分布式事务管理 |
Alibaba Druid | 1.1.20 | 数据源 |
FastJson | 1.2.60 | JSON处理工具集 |
commons-lang3 | 3.9 | 常用工具包 |
jwt | 0.9.1 | json web token |
lombok | 1.18.10 | 注解生成Java Bean等工具 |

## 快速开始
1. 克隆项目:`git clone https://github.com/WongMinHo/spring-boot-api-starter.git`
2. 构建数据库，多数据源可以先创建两个数据库
3. 对`test`包内的代码生成器`MysqlFirstGenerator`、`MysqlSecondGenerator`进行配置，修改对应的连接地址、包目录、作者等
4. 输入表名，运行代码生成器，生成基础目录和代码结构，根据业务在基础代码上进行扩展
5. 修改本地环境配置文件`application-local.yml`，启动项目


## 开发建议
- 开发规范可以参考阿里巴巴Java开发手册（[最新版下载](https://github.com/alibaba/p3c))
- 公司内部可以把统一异常处理、统一响应结果、鉴权工具类等公共模块封装打包；项目需要用到时，引入工具包。
- API文档可以使用：[Swagger2](https://swagger.io/)、[ShowDoc](https://github.com/star7th/showdoc)。


## 相关技术文档
- Spring Boot（[查看官方文档](https://spring.io/projects/spring-boot/)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- Mybatis Plus（[查看官方文档](https://mybatis.plus/guide/)）
- Druid Spring Boot Starter（[查看官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）
- FastJson（[查看官方中文文档](https://github.com/alibaba/fastjson/wiki/Quick-Start-CN)）
- Jwt（[项目文档](https://github.com/jwtk/jjwt)）


## License
开源分享，感谢支持 [Star](https://github.com/wongminho/spring-boot-api-starter/stargazers) & [Fork](https://github.com/wongminho/spring-boot-api-starter/network/members) 。
