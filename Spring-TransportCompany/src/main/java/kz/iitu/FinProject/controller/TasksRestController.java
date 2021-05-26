package kz.iitu.FinProject.controller;

import kz.iitu.FinProject.model.Task;
import kz.iitu.FinProject.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksRestController {
    private final TaskRepo taskRepo;

    @Autowired
    TasksRestController(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    @GetMapping
    List<Task> getAllTasks(){
        return taskRepo.findAll();
    }

    @PostMapping
    Task newTask(@RequestBody Task task){
        return taskRepo.save(task);
    }

    @GetMapping("/{id}")
    Task getTaskById(@PathVariable long id){
        return taskRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    Task updateTask(@RequestBody Task newTask, @PathVariable long id){
        return taskRepo.findById(id)
                .map(task -> {
                    task.setAssigneeId(newTask.getAssigneeId());
                    task.setDescription(newTask.getDescription());
                    task.setOriginBranchId(newTask.getOriginBranchId());
                    task.setOriginCityId(newTask.getOriginCityId());
                    task.setDestinationBranchId(newTask.getDestinationBranchId());
                    task.setDestinationCityId(newTask.getDestinationCityId());
                    return taskRepo.save(task);
                }).orElseGet(() ->{
                    return taskRepo.save(newTask);
                });
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable long id){
        taskRepo.deleteById(id);
    }
}
