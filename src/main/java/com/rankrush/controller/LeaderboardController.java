package com.rankrush.controller;

import com.rankrush.model.User;
import com.rankrush.service.LeaderboardService;
import com.rankrush.service.SimulationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class LeaderboardController {

    private final LeaderboardService leaderboardService;
    private final SimulationService simulationService;

    public LeaderboardController(LeaderboardService leaderboardService, SimulationService simulationService) {
        this.leaderboardService = leaderboardService;
        this.simulationService = simulationService;
    }

    @GetMapping(value = "/leaderboard", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getLeaderboard() {
        return leaderboardService.getTopUsers(50);
    }

    @PostMapping("/simulation/start")
    public void startSimulation() {
        simulationService.startSimulation();
    }
}
