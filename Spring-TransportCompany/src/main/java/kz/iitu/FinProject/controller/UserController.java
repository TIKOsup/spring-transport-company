package kz.iitu.FinProject.controller;

import kz.iitu.FinProject.model.User;
import kz.iitu.FinProject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping()
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    @PostMapping()
    public User add(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }

    @GetMapping("/{id}")
    public Optional<User> find(@PathVariable("id") long id) {
        return userRepo.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        userRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") long id, @RequestBody User new_user) {
        new_user.setId(id);
        userRepo.save(new_user);
        return new_user;
    }
}
