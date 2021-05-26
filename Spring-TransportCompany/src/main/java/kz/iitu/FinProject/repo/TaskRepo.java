package kz.iitu.FinProject.repo;

import kz.iitu.FinProject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
