package zafar.net.sportustoz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zafar.net.sportustoz.dto.ScoreCreateDto;
import zafar.net.sportustoz.entity.AppUser;
import zafar.net.sportustoz.entity.Score;
import zafar.net.sportustoz.repository.AppUserRepository;
import zafar.net.sportustoz.repository.ScoreRepository;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final AppUserRepository appUserRepository;

    public Score submitScore(ScoreCreateDto dto) {
        AppUser user = appUserRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        int ball = calculateScore(dto.getSecund(), dto.getMinute(), dto.getPullUp());

        Score score = Score.builder()
                .user(user)
                .secund(dto.getSecund())
                .minute(dto.getMinute())
                .pullUp(dto.getPullUp())
                .ball(ball)
                .build();
        return scoreRepository.save(score);
    }

    private int calculateScore(Double secund, Double minute, Integer pullUp) {
        int score = 0;
        if (secund <= 12) score += 10;
        if (minute <= 10) score += 10;
        if (pullUp >= 15) score += 10;
        return score;
    }
}
