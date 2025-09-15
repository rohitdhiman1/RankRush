
# Compounding Calculator

A simple web-based compounding calculator built with Spring Boot and Vue.js. The application features:

- Modern, user-friendly UI
- Input validation and error messages
- Responsive design for desktop and mobile
- Automatic formatting of large numbers with commas for readability

Only compounding calculations are supported.

## How to Run

1.  Build the project using Maven:
    ```bash
    mvn clean install
    ```
2.  Run the Spring Boot application:
    ```bash
    java -jar target/rank-rush-0.0.1-SNAPSHOT.jar
    ```
3.  Open your browser and navigate to `http://localhost:8080`.

## Features

- Enter large initial amounts and see them formatted with commas (e.g., 100,000)
- See final results and chart with readable figures
- All calculations are for compounding interest only

## Example

Enter:
- Initial Amount: 100,000
- Annual Rate: 7
- Duration: 10 years
- Annual Add-on: 1,000

Click "Calculate" to see the final amount and growth chart.