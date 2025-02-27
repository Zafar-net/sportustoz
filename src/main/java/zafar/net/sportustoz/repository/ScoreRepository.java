package zafar.net.sportustoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zafar.net.sportustoz.entity.Normativ;
import zafar.net.sportustoz.entity.Score;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByNormativ(Normativ normativ);
}
