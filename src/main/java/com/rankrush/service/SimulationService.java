package com.rankrush.service;

import com.rankrush.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class SimulationService {

    private final LeaderboardService leaderboardService;
    private final AtomicBoolean simulationRunning = new AtomicBoolean(false);

    private final List<String> userNames = List.of("rohitdhiman", "john.doe", "jane.smith", "test.user", "user.one");
    private final List<String> names = List.of("Rohit Dhiman", "John Doe", "Jane Smith", "Test User", "User One");
    private final List<String> locations = List.of("New York", "London", "Tokyo", "Paris", "Sydney");
    private final Random random = new Random();

    public SimulationService(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    public void startSimulation() {
        if (simulationRunning.compareAndSet(false, true)) {
            Flux.interval(Duration.ofMillis(500))
                    .take(Duration.ofSeconds(60))
                    .flatMap(i -> {
                        int userIndex = random.nextInt(userNames.size());
                        User user = new User(
                                userNames.get(userIndex),
                                names.get(userIndex),
                                locations.get(random.nextInt(locations.size())),
                                random.nextDouble() * 100
                        );
                        return leaderboardService.addUser(user);
                    })
                    .doOnComplete(() -> simulationRunning.set(false))
                    .subscribeOn(Schedulers.boundedElastic())
                    .subscribe();
        }
    }
}
