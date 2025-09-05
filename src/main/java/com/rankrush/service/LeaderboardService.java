package com.rankrush.service;

import com.rankrush.model.User;
import org.springframework.data.domain.Range;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveZSetOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LeaderboardService {

    private static final String LEADERBOARD_KEY = "leaderboard";
    private final ReactiveZSetOperations<String, User> zSetOperations;

    public LeaderboardService(ReactiveRedisTemplate<String, User> redisTemplate) {
        this.zSetOperations = redisTemplate.opsForZSet();
    }

    public Mono<Void> addUser(User user) {
        return zSetOperations.add(LEADERBOARD_KEY, user, user.getPoints()).then();
    }

    public Flux<User> getTopUsers(int limit) {
        return zSetOperations.reverseRange(LEADERBOARD_KEY, Range.from(Range.Bound.inclusive(0L)).to(Range.Bound.inclusive(limit - 1L)));
    }

    public Mono<Long> getRank(User user) {
        return zSetOperations.reverseRank(LEADERBOARD_KEY, user);
    }
}

