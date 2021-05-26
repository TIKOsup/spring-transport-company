package kz.iitu.FinProject.controller;

import kz.iitu.FinProject.model.Branch;
import kz.iitu.FinProject.model.City;
import kz.iitu.FinProject.repo.BranchRepo;
import kz.iitu.FinProject.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/branches")
public class BranchController {
    private final BranchRepo branchRepo;
    private final CityRepo cityRepo;

    @Autowired
    BranchController(BranchRepo branchRepo, CityRepo cityRepo) {
        this.branchRepo = branchRepo;
        this.cityRepo = cityRepo;
        if (branchRepo.count() <= 0) {
            ArrayList<Branch> branches = new ArrayList<>();
            branches.add(new Branch(30,"IITU", "Almas", "Fake address", 2));
            branches.add(new Branch(31,"Pony Express", "Almas", "Fake address", 2));
            branches.add(new Branch(32,"Alem TAT", "Almas", "Fake address", 2));
            branches.add(new Branch(33,"EMS Kazakhstan", "Almas", "Fake address", 2));
            branches.add(new Branch(34,"China Post", "Almas", "Fake address", 2));
            branchRepo.saveAll(branches);
        }
    }

    @GetMapping
    public String getAllBranches(Model model) {
        model.addAttribute("branches", branchRepo.findAll());
        model.addAttribute("cities", cityRepo.findAll());
        return "branch_list";
    }

    @GetMapping("/new")
    public String newBranch(Model model) {
        model.addAttribute("branch", new Branch());
        model.addAttribute("cities", cityRepo.findAll());
        return "branch_new";
    }

    @PostMapping()
    public String createBranch(@ModelAttribute("branch") Branch newBranch) {
        branchRepo.save(newBranch);
        return "redirect:/branches";
    }

    @GetMapping("/{id}/edit")
    public String editBranch(Model model, @PathVariable("id") long id) {
        model.addAttribute("branch", branchRepo.getOne(id));
        model.addAttribute("cities", cityRepo.findAll());
        return "branch_edit";
    }

    @PostMapping("/{id}")
    public String updateBranch(@ModelAttribute("branch") Branch branch, @PathVariable long id) {
        branch.setId(id);
        branch.setChangeDate(new Date(System.currentTimeMillis()));
        branchRepo.save(branch);
        return "redirect:/branches";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        branchRepo.deleteById(id);
        return "redirect:/branches";
    }
}
