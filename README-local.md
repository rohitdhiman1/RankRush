# RankRush - Running Locally

This document provides instructions on how to run the RankRush application locally without using Docker.

## Prerequisites

*   Java 17 or later
*   Maven 3.2+
*   Redis running on `localhost:6379`

## Steps

1.  **Start Redis:**
    Make sure you have a Redis instance running on `localhost:6379`. If you have Docker installed, you can easily start one with the following command:
    ```bash
    docker run -d -p 6379:6379 redis
    ```

2.  **Build the application:**
    Navigate to the project's root directory and run the following Maven command to build the project:
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    Once the build is complete, you can run the application using the following command:
    ```bash
    java -jar target/rank-rush-0.0.1-SNAPSHOT.jar
    ```

4.  **Access the application:**
    Open your web browser and navigate to `http://localhost:8080`. You should see the RankRush leaderboard.

5.  **Start the simulation:**
    Click the "Start Simulation" button to begin populating the leaderboard with mock data. The leaderboard will update in real-time.
