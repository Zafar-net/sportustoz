package zafar.net.sportustoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zafar.net.sportustoz.entity.AgeType;

@Repository
public interface AgeTypeRepository extends JpaRepository<AgeType, Long> {
}
