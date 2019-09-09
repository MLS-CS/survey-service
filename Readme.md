# Getting Started

This service provides apis to manage survey and support following features :
* create/retrieve/update surveys.
* create/retrieve/update questions and associate them to survey.
* create/retrieve/update answers and associate them to questions.

### Code Usage 
**Build it** : *mvnw.cmd clean install*

**Run It** : *java -jar target\survey-service-0.0.1-SNAPSHOT.jar*

**API Documentation** http://localhost:8081/api/swagger-ui.html

**API Usage (via Postman)**
  * Create Survey 
    * Request URL : http://localhost:8081/api/survey
    * Request Body:
       ```
       {
        "name": "Java",
        "description": "Java Survey"
       }
       ```
    * Response Header:
       ```
       Location : http://localhost:8081/api/survey/{surveyId}  
       ```
    * Response Status:
       ```
        201
       ```             
  
  * Update Survey 
    * Request URL : http://localhost:8081/api/survey/{surveyId}
    * Request Body:
        ```
        {
           "name": "Java",
           "description": "Java Survey"
        }
        ```
    * Response Status:
      ```
      200
      ```  
          
   * Retrieve Survey 
       * Request URL : http://localhost:8081/api/survey/{surveyId}
       * Response Body:
          ```
          {
           "name": "Java",
           "description": "Java Survey"
          }
          ```
          
   * Delete Survey 
        * Request URL : http://localhost:8081/api/survey/{surveyId}
        * Response Status:
          ```
          200
          ```
             
   * Create Question 
     * Request URL : http://localhost:8082/api/survey/{surveyId}/question
     * Request Body:
         ```
         {
          "category": "Basic",
          "description": "Is Java your favorite language"
         }
         ```
     * Response Header:
         ```
         Location : http://localhost:8082/api/survey/{surveyId}/question/{questionId}  
         ```
     * Response Status:
         ```
          201
         ```      
                
   * Update Question 
      * Request URL : http://localhost:8082/api/survey/{surveyId}/question/{questionId} 
      * Request Body:
          ```
          {
              "category": "Basic",
              "description": "Is Java your favorite language"
          }
          ```
      * Response Status:
        ```
        200
        ```  
            
   * Retrieve Question 
     * Request URL : http://localhost:8082/api/survey/{surveyId}/question/{questionId}
     * Response Body:
         ```
         {
             "category": "Basic",
             "description": "Is Java your favorite language"
         }
         ```
            
   * Delete Question 
     * Request URL : http://localhost:8082/api/survey/{surveyId}/question/{questionId}
     * Response Status:
         ```
         200
         ```
         
   * Create Answer 
     * Request URL : http://localhost:8082/api/survey/{surveyId}/question/{questionId}/answer
     * Request Body:
         ```
          {
             "description": "Yes"
          }
         ```
      * Response Header:
           ```
            Location : http://localhost:8082/api/survey/{surveyId}/question/{questionId}/answer/{answerId}
           ```
      * Response Status:
           ```
            201
           ```      
                   
   * Update Answer 
     * Request URL : http://localhost:8082/api/survey/{surveyId}/question/{questionId}/answer/{answerId} 
     * Request Body:
          ```
          {
              "description": "Yes"
          }
          ```
      * Response Status:
          ```
          200
          ```  
               
   * Retrieve Answer 
     * Request URL : http://localhost:8082/api/survey/{surveyId}/question/{questionId}/answer/{answerId}
     * Response Body:
         ```
         {
             "description": "Yes"
         }
         ```
               
   * Delete Answer 
     * Request URL : http://localhost:8082/api/survey/{surveyId}/question/{questionId}/answer/{answerId}
     * Response Status:
         ```
          200
         ```
          
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