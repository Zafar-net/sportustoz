package zafar.net.sportustoz.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import zafar.net.sportustoz.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}