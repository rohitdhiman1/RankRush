# RankRush - Running with Docker

This document provides instructions on how to run the RankRush application using Docker and Docker Compose.

## Prerequisites

*   Docker
*   Docker Compose

## Steps

1.  **Build and run the application:**
    Navigate to the project's root directory and run the following command:
    ```bash
    docker-compose up --build
    ```
    This command will:
    *   Build the Docker image for the RankRush application.
    *   Start a Redis container.
    *   Start the RankRush application container.

2.  **Access the application:**
    Open your web browser and navigate to `http://localhost:8080`. You should see the RankRush leaderboard.

3.  **Start the simulation:**
    Click the "Start Simulation" button to begin populating the leaderboard with mock data. The leaderboard will update in real-time.

4.  **Stopping the application:**
    To stop the application, press `Ctrl+C` in the terminal where `docker-compose` is running, and then run the following command to remove the containers:
    ```bash
    docker-compose down
    ```
