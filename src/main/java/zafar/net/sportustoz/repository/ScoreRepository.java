package zafar.net.sportustoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zafar.net.sportustoz.entity.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
