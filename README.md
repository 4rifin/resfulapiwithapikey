# resfulapiwithapikey
RESTful API with API Key Token Authentication in Java using Spring Boot

Summary:
    Configure the API Key filter (ApiKeyFilter.java) to check for API key authentication.

    Create Custom Authentication Token (ApiKeyAuthenticationToken.java) for API key validation.

    Configure Spring Security to use the ApiKeyFilter and secure endpoints.

    Create a REST controller to handle requests and test the authentication.

RESTful API with API Key Token Authentication in Java using Spring Boot

Test the API:

    Run the Spring Boot Application:

        In IntelliJ IDEA, right-click on the DemoApplication class and select Run.

    Test the API with Postman or cURL:

        Use Postman or cURL to send a GET request to http://localhost:8080/api/data with the x-api-key header.

    In Postman, set the header:

        Key: x-api-key

        Value: your-api-key (replace with the actual API key).

    Using cURL:

curl -X GET http://localhost:8080/api/data -H "x-api-key: your-api-key"

If the API key is correct, you'll receive the response:

This is a protected API endpoint

If the API key is missing or incorrect, you'll get a 401 Unauthorized response.
