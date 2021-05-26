package kz.iitu.FinProject.controller;

import kz.iitu.FinProject.model.City;
import kz.iitu.FinProject.model.Task;
import kz.iitu.FinProject.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityRestController {

    private final CityRepo cityRepo;

    @Autowired
    CityRestController(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @GetMapping
    List<City> getAllTasks() {
        return cityRepo.findAll();
    }
}
