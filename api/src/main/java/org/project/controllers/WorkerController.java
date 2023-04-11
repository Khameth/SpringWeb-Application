package org.project.controllers;

import org.project.entities.Worker;
import org.project.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/workers")
    public String workers(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers",workers);
        model.addAttribute("title","Workers");
        return "workers/workers";
    }
    @GetMapping("/workers/add")
    public String workersAdd(Model model){
        return "workers/workers_add";
    }

    @PostMapping("/workers/add")
    public String workersPostAdd(@RequestParam String fullName,@RequestParam int age, Model model){
        Worker worker = new Worker(fullName , age);
        workerRepository.save(worker);
        return "redirect:/workers";
    }


}
