# -Weather-API-from-Rapid-API
SpringBoot Java and integrate Weather API from Rapid API. On the basis of that integration, expose your RESTful APIs as follows with JSON response.

## Technologies Used

•	Java
•	Spring Boot
•	Spring Security
•	Weather API from RapidAPI

## Getting Started

1.	Clone the repository:

git clone https://github.com/Rishavzkc/-Weather-API-from-Rapid-API.git

2.	Run the project:

o	Navigate to the project directory in your terminal.
o	Use the appropriate command to start the Spring Boot application, typically:

mvn spring-boot:run


4.	Obtain Client Credentials:

o	Once the project starts, random client ID and client secret will be displayed in the console. Copy these values.

## Testing the APIs

API 1: Get Weather Forecast Summary

curl --location --request GET "http://localhost:8080/weather/get-forecast-summary-by-location/Berlin" --header "<client-id>:<client-secret>"

API 2: Get Hourly Weather Forecast Details

curl --location --request GET "http://localhost:8080/weather/get-forecast-hourly-by-location/Berlin" --header  "<client-id>:<client-secret>"

Note: Replace <client-id> and <client-secret> with the generated values from the console.


