package kz.iitu.FinProject.controller;


import kz.iitu.FinProject.model.City;
import kz.iitu.FinProject.model.Task;
import kz.iitu.FinProject.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/cities")
public class CityController {

    private final CityRepo cityRepo;

    @Autowired
    CityController(CityRepo cityRepo){
        this.cityRepo = cityRepo;
        if (cityRepo.count() <= 0) {
            ArrayList<City> cities = new ArrayList<>();
            cities.add(new City(1, "Astana"));
            cities.add(new City(2, "Almaty"));
            cities.add(new City(3, "Kokshetau"));
            cities.add(new City(17,"Shymkent"));
            cities.add(new City(9,"Karaganda"));
            cities.add(new City(14,"Pavlodar"));
            cities.add(new City(6,"Atyrau"));
            cities.add(new City(7, "Oral"));
            cities.add(new City(12, "Aktau"));
            cities.add(new City(16, "Ust-Kamenogorsk"));
            cities.add(new City(4, "Aktobe"));
            cityRepo.saveAll(cities);
        }
    }
    @GetMapping
    public String getAllCities(Model model){
        model.addAttribute("cities", cityRepo.findAll());
        return "city_list";
    }

    @GetMapping("/new")
    public String newCity(Model model) {
        model.addAttribute("city", new City());
        return "city_new";
    }
    @PostMapping()
    public String createCity(@ModelAttribute("city") City newCity) {
        cityRepo.save(newCity);
        return "redirect:/cities";
    }

    @GetMapping("/{id}/edit")
    public String editCity(Model model, @PathVariable("id") long id){
        model.addAttribute("city", cityRepo.getOne(id));
        return "city_edit";
    }

    @PostMapping("/{id}")
    public String updateTask(@ModelAttribute("city") City city, @PathVariable long id){
        city.setId(id);
        cityRepo.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        cityRepo.deleteById(id);
        return "redirect:/cities";
    }
}
