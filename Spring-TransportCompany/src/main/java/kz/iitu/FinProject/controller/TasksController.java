package kz.iitu.FinProject.controller;

import kz.iitu.FinProject.model.Task;
import kz.iitu.FinProject.repo.BranchRepo;
import kz.iitu.FinProject.repo.CityRepo;
import kz.iitu.FinProject.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final TaskRepo taskRepo;
    private final CityRepo cityRepo;
    private final BranchRepo branchRepo;

    @Autowired
    TasksController(TaskRepo taskRepo, CityRepo cityRepo, BranchRepo branchRepo) {
        this.taskRepo = taskRepo;
        this.cityRepo = cityRepo;
        this.branchRepo = branchRepo;
    }

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskRepo.findAll());
        model.addAttribute("cities", cityRepo.findAll());
        model.addAttribute("branches", branchRepo.findAll());
        return "task_list";
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("cities", cityRepo.findAll());
        model.addAttribute("branches", branchRepo.findAll());
        return "task_new";
    }

    @PostMapping()
    public String createTask(@ModelAttribute("city") Task newTask) {
        newTask.setStatus("Not completed");
        newTask.setChangeDate(LocalDateTime.now());
        taskRepo.save(newTask);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTask(Model model, @PathVariable("id") long id) {
        model.addAttribute("task", taskRepo.getOne(id));
        model.addAttribute("cities", cityRepo.findAll());
        model.addAttribute("branches", branchRepo.findAll());
        return "task_edit";
    }

    @PostMapping("/{id}")
    public String updateTask(@ModelAttribute("task") Task task, @PathVariable long id) {
        task.setId(id);
        task.setStatus("Not completed");
        task.setChangeDate(LocalDateTime.now());
        taskRepo.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        taskRepo.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/complete")
    public String completeTask(@PathVariable("id") long id){
        Task toComplete = taskRepo.getOne(id);
        toComplete.setStatus("Completed");
        toComplete.setChangeDate(LocalDateTime.now());
        taskRepo.save(toComplete);
        return "redirect:/tasks";
    }
}
