package kz.iitu.FinProject.repo;

import kz.iitu.FinProject.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Long> {
}
