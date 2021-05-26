package kz.iitu.FinProject.repo;

import kz.iitu.FinProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
