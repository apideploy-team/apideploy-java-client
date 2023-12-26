### Introduction

**apideploy-java-client** is a java system **API document automatic generation toolkit and [apideploy.com](https://www.apideploy.com) website deployment SDK**. It supports [Swagger2(OAS 2.0)](https://swagger.io/specification/v2/), [Swagger3 (OAS 3.0)](https://swagger.io/specification/v3/), [Javadoc specifications](https://en.wikipedia.org/wiki/Javadoc), and Java development frameworks such as [Spring WebMVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html), [Spring WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html) and [Apache Dubbo](https://dubbo.apache.org/en/index.html)'s documentation comments.

Note: This client is suitable for systems using Java 1.8 or below. The swagger part is implemented based on [springfox](https://github.com/springfox/springfox).If your system is based on Spring Boot 3.0 or above, please use [apideploy-jakarta-client]( https://github.com/apideploy-team/apideploy-jakarta-client).

### Guides

1.Add maven dependency to pom.xml.

> You have to choose the appropriate dependencies according to the framework of your system. The following is the correspondence between maven dependencies and frameworks.
>

<table style="overflow-x: auto;width: 100%;border-collapse: collapse;"> <tr> <th>/</th> <th>Spring WebMVC</th> <th>Spring WebFlux</th> <th>Apache Dubbo</th> </tr> <tr> <td>Swagger2(OAS 2.0)</td> <td>&lt;dependency&gt; &nbsp;&nbsp;&nbsp;&nbsp; &lt;groupId&gt;com.kalman03&lt;/groupId&gt;  &nbsp;&nbsp;&nbsp;&nbsp;  &lt;artifactId&gt;apideploy-swagger2-webmvc&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td></td> <td></td> </tr> <tr> <td>Swagger3(OAS 3.0)</td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-swagger3-webmvc&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-swagger3-webflux&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td></td> </tr> <tr> <td>Javadoc</td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-javadoc-springweb&lt;/artifactId&gt; &lt;/dependency&gt;</td> <td></td> <td>&lt;dependency&gt; &lt;groupId&gt;com.kalman03&lt;/groupId&gt; &lt;artifactId&gt;apideploy-javadoc-springweb&lt;/artifactId&gt; &lt;/dependency&gt;</td> </tr> </table>



2.Config the application.properties or application.yaml.

```properties
apideploy.config.enabled=true
apideploy.config.endpoint=https://www.apideploy.cn/openapi/sync
apideploy.config.appId=${appId}
apideploy.config.appSecret=${appSecret}
apideploy.config.autoPublish=true
```

The `${appId}` and `${appSecret}` in the configuration file can be applied for free through the apideploy.com website. For detailed application methods, please refer to: www.

For more parameter configuration, please refer to: www

3.Run it and see the final result.

The above three steps have completed all the configuration of apideploy. The next step is to write your Javadoc (strongly recommended) or complete the API definition based on Swagger. When everything is ready, run the system locally and the API will be automatically generated and synchronized to the [apideploy.com](https://www.apideploy.com) website. Then you can happily check, debug and do version management on [apideploy.com](https://www.apideploy.com) .

### Samples

For more samples, please refer to [apideploy-java-demos](https://github.com/apideploy-team/apideploy-java-demos).

### License

apideploy-java-client is released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0).

