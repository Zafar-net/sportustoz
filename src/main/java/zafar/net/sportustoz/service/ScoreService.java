package zafar.net.sportustoz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zafar.net.sportustoz.dto.ScoreCreateDto;
import zafar.net.sportustoz.entity.AgeType;
import zafar.net.sportustoz.entity.AppUser;
import zafar.net.sportustoz.entity.Normativ;
import zafar.net.sportustoz.entity.Score;
import zafar.net.sportustoz.repository.AppUserRepository;
import zafar.net.sportustoz.repository.NormativRepository;
import zafar.net.sportustoz.repository.ScoreRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ScoreService {
    private final AppUserService appUserService;
    private final NormativRepository normativRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(AppUserService appUserService, NormativRepository normativRepository, ScoreRepository scoreRepository) {
        this.appUserService = appUserService;
        this.normativRepository = normativRepository;
        this.scoreRepository = scoreRepository;
    }

    public int calculateScore(AppUser user, Double secund, Double minute, Integer pullUp) {
        int score = 0;

        AgeType ageType = appUserService.determineAgeType(user.getAge());

        Optional<Normativ> optionalNormativ = normativRepository.findByAgeType_Id(Math.toIntExact(ageType.getId()));

        if (optionalNormativ.isEmpty()) {
            throw new RuntimeException("Mos normativ topilmadi!");
        }

        Normativ normativ = optionalNormativ.get();
        List<Score> scoreList = scoreRepository.findByNormativ(normativ);

        for (Score s : scoreList) {
            if (s.getSecund() != null && secund <= s.getSecund()) {
                score += s.getBall();
            }
            if (s.getMinute() != null && minute <= s.getMinute()) {
                score += s.getBall();
            }
            if (s.getPullUp() != null && pullUp >= s.getPullUp()) {
                score += s.getBall();
            }
        }

        System.out.println("Hisoblangan ball: " + score);
        return score;
    }
    public Score submitScore(ScoreCreateDto dto) {

        AppUser user = appUserService.getUserById(dto.getUserId());

        int scoreValue = calculateScore(user, dto.getSecund(), dto.getMinute(), dto.getPullUp());

        AgeType ageType = appUserService.determineAgeType(user.getAge());

        Normativ normativ = normativRepository.findByAgeType_Id(Math.toIntExact(ageType.getId()))
                .orElseThrow(() -> new RuntimeException("Mos normativ topilmadi!"));

        Score score = new Score();
        score.setAppUser(user);
        score.setNormativ(normativ);
        score.setSecund(dto.getSecund());
        score.setMinute(dto.getMinute());
        score.setPullUp(dto.getPullUp() != null ? dto.getPullUp().doubleValue() : null);

        score.setBall(scoreValue);

        return scoreRepository.save(score);
    }



}