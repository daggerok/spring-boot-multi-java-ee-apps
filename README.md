# spring-boot-multi-java-ee-apps [![CI](https://github.com/daggerok/spring-boot-multi-java-ee-apps/workflows/CI/badge.svg)](https://github.com/daggerok/spring-boot-multi-java-ee-apps/actions?query=workflow%3ACI)
Yeah, creepy ee...

```bash
./mvnw clean ; ./mvnw ; ./mvnw -f webapps-deploymen docker:build docker:start
./mvnw -f webapps-deploymen docker:stop docker:remove
http :8080/webapp1/hello
http :8080/webapp2/hello
```

## links

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Package Spring Boot in EAP](https://howtodoinjava.com/spring-boot2/sb-multi-module-maven-project/)

