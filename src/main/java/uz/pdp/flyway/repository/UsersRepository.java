package uz.pdp.flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.flyway.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}