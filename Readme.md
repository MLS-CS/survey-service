# Getting Started

This service provides apis to manage survey and support following features :
* create/retrieve/update surveys.
* create/retrieve/update questions and associate them to survey.
* create/retrieve/update answers and associate them to questions.

### Code Usage 
**Build it** : *mvnw.cmd clean install*

**Run It** : *java -jar target\survey-service-0.0.1-SNAPSHOT.jar*

**API Documentation** http://localhost:8081/api/swagger-ui.html

**Publish Sonar Results** : *mvnw.cmd clean install sonar:sonar -Dsonar.projectKey={projectKey}  -Dsonar.organization={organization}  -Dsonar.host.url={host}  -Dsonar.login={login}*

**Build Docker Container** : *mvnw.cmd clean install dockerfile:build*

### Dev Operations
[Survey Service Travis CI Build](https://travis-ci.org/MLS-CS/survey-service)
: Have integrated code repo with Travis CI which builds the app does following :

* perform and publish, code analysis and code coverage result to sonar cloud.
    * [Survey Service Sonar Report](https://sonarcloud.io/dashboard?id=MLS-CS_survey-service)
* build and publish docker container to docker hub
    * [Survey Service Docker Hub](https://cloud.docker.com/u/mlscs/repository/docker/mlscs/survey-service)
* deployment of docker container is done manually as of now.

### Guides
Refereed following guide's for development:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)