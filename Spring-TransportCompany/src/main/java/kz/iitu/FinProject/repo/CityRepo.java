package kz.iitu.FinProject.repo;

import kz.iitu.FinProject.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}
