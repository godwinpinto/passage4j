# Passage-4J
A Java SDK for Passage

## Description
Implement seamless passwordless authentication in your app or website with just a few lines of code and perform validations and application/user maintenance with this Java SDK.

## Installation
### Maven
Include this in your pom.xml
```
...add this to project node...
    <repositories>
    <repository>
      <id>godwinpinto-passage4j</id>
      <url>https://packagecloud.io/godwinpinto/passage4j/maven2</url>
      <releases>
        <enabled>true</enabled>
      </releases>
      <snapshots>
        <enabled>true</enabled>
      </snapshots>
    </repository>
    </repositories>
    --------------------
    ...add this to dependency node...
    <dependency>
      <groupId>id.passageidentity.passage4j</groupId>
      <artifactId>core</artifactId>
      <version>0.0.1</version>
    </dependency>
    ...
```
### Gradle
Add this entry anywhere in your build.gradle file
```
...
repositories {
    maven {
        url "https://packagecloud.io/godwinpinto/passage4j/maven2"
    }
}
...
compile 'id.passageidentity.passage4j:core:0.0.1'
```

### Current Version compiled on
Java 17+

# How to use
1. Visit Passage console and create an app [https://console.passage.id/login](https://console.passage.id/login)
2. copy the app id and api key 
3. Follow below steps to configure passage in your app

**Configure Passage4J and create Instance**
```java
import id.passageidentity.passage4j.core.app.Passage;
import id.passageidentity.passage4j.core.app.PassageConfig;
import id.passageidentity.passage4j.core.app.PassageNew;
...
Passage passage;
...
PassageConfig config=new PassageConfig();
config.setHeaderAuth(true);
config.setApiKey(System.getenv("PASSAGE_API_KEY"));

//Create the passage client
passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);

/** 
 * now you have the passage object configured with your api key and app id
 * As a recommendation dont hardcode your key and app id in application
 * You can always use 1password connect to store your keys more securely :)
*/
```

**Using Passage API's via Passage-4J**
```java

//Fetch Passage App information
AppInfoBean appInfoBean=passage.app().getInfo();

//Create Magic link
passage.app().createMagicLink(createMagicLinkBodyBean);

//Fetch User information
UserBean userBean=passage.user().getInfo("<passage user id>");

//Authenticate web user
/** 
* Based on the framework you are using, fetch the request header
* String token = request().getHeader("Authorization");
* No need to check additional token value, the same is implemented in below function
**/
String userID = passage.auth().authenticateRequestWithAuthHeader(token);

/**
* you can also fetch the passage token from cookie name cookie_name_psg_auth_token
*/
String userID = passage.auth().authenticateRequestWithCookie("<cookie_name_psg_auth_token>"");
// Note: this user id will return the passage user id
```

### More examples:
Visit [https://github.com/godwinpinto/example-passage4j](https://github.com/godwinpinto/example-passage4j) to intergate Passage-4J with examples on how to do with;
1. Spring boot
2. Quarkus
3. Micronaut
4. Vertx

### Contributions
Refer to CONTRIBUTING.md

### Code of Conduct
Refer to code_of_conduct.md

### Java Documentation
Refer to /docs/api

### ToDo
- [ ] Test classes
- [ ] Proxy implementation for Passage Wrapper client
- [ ] Logging using slf4J
- [ ] Migration test to lower version of java, probably JDK1.8
- [ ] Moving project to maven (needs passage teams support)
- [ ] GitHub CI pipeline to push directly to maven
- [ ] Jacoco test coverage integration
- [ ] Sonar source integration for code quality

