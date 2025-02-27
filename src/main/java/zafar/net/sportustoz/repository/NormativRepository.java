package zafar.net.sportustoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zafar.net.sportustoz.entity.Normativ;

import java.util.Optional;

@Repository
public interface NormativRepository extends JpaRepository<Normativ, Long> {
    Optional<Normativ> findByAgeType_Id(Integer ageTypeId);
}
