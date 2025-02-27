package zafar.net.sportustoz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zafar.net.sportustoz.dto.ScoreCreateDto;
import zafar.net.sportustoz.entity.Score;
import zafar.net.sportustoz.service.ScoreService;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> submitScore(@RequestBody ScoreCreateDto dto) {
        return ResponseEntity.ok(scoreService.submitScore(dto));
    }
}

