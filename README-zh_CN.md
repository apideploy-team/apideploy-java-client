### 介绍

**apideploy-java8-client** 是一个Java系统的API 文档自动生成工具包与[apideploy.com](https://www.apideploy.com)网站的部署SDK，它兼容[Swagger2（OAS 2.0）](https://swagger.io/specification/v2/), [Swagger3 (OAS 3.0)](https://swagger.io/specification/v3/), [Javadoc](https://zh.wikipedia.org/wiki/Javadoc)规范，支持Java开发框架如 [Spring WebMVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html), [Spring WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html) 以及[Apache Dubbo](https://cn.dubbo.apache.org/zh-cn/)的文档注释。

**注意：**该SDK适合使用**Java1.8以下**版本的系统（仅在1.8版本进行过测试，低于1.8请自行测试），swagger 部分是基于[springfox](https://github.com/springfox/springfox)的实现。**如果你的系统基于Spring Boot 3.0以上版本，请使用[apideploy-jakarta-client](https://github.com/apideploy-team/apideploy-jakarta-client)**。

### 使用指南

1.添加Maven依赖到pom.xml：

> 你得根据你系统的框架选择合适的依赖，以下是maven依赖与框架的对应关系

<table style="overflow-x: auto;width: 100%;border-collapse: collapse;"> <tr> <th>/</th> <th>Spring WebMVC</th> <th>Spring WebFlux</th> <th>Apache Dubbo</th> </tr> <tr> <td>Swagger2(OAS 2.0)</td> <td>&lt;dependency&gt; &nbsp;&nbsp;&nbsp;&nbsp; &lt;groupId&gt;com.kalman03&lt;/groupId&gt;  &nbsp;&nbsp;&nbsp;&nbsp;  &lt;artifactId&gt;apideploy-swagger2-webmvc&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td></td> <td></td> </tr> <tr> <td>Swagger3(OAS 3.0)</td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-swagger3-webmvc&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-swagger3-webflux&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td></td> </tr> <tr> <td>Javadoc</td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-javadoc-springweb&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td></td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-javadoc-springweb&lt;/artifactId&gt; &lt;/dependency&gt;</td> </tr> </table>



2.配置application.properties or application.yaml（以下基于springboot的项目application.properties配置示例）：

```properties
apideploy.config.enabled=true
apideploy.config.endpoint=https://www.apideploy.cn/openapi/sync
apideploy.config.appId=${appId}
apideploy.config.appSecret=${appSecret}
apideploy.config.autoPublish=true
```

配置文件中的`${appId}`和`${appSecret}`可以通过apideploy.com网站免费申请。关于详细申请方式，请参考：www。

关于更多参数配置请参考：www

3.运行并查看结果。

以上步骤已经完成所有关于apideploy的配置，接下来就是写你的Javadoc（推荐）或者基于Swagger的方式完成API的定义。当一切就绪，在本地运行该系统，API会自动生成并同步到apideploy网站，接下来就可以在apideploy上愉快的查阅、调试并做版本管理了。

### Demo

更多使用案例，请参考 [apideploy-java-demos](https://github.com/apideploy-team/apideploy-java-demos).

### License

apideploy-java8-client is released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0).

