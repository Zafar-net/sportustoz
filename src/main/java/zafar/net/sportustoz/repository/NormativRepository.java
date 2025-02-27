package zafar.net.sportustoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zafar.net.sportustoz.entity.Normativ;

@Repository
public interface NormativRepository extends JpaRepository<Normativ, Long> {
}
