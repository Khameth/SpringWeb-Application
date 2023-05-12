package org.project.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.project.entities.Worker;
import org.project.services.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
@Controller
@SessionAttributes("worker")
@RequestMapping("/workers")
@AllArgsConstructor
public class WorkerController {
    private WorkerService workerService;

    @ApiOperation(value = "Get all workers")
    @GetMapping("/list")
    public String workers(Model model){
        model.addAttribute("workers",workerService.findAll());
        return "workers/workers_list";
    }

    @ApiOperation(value = "Get worker by id")
    @GetMapping("/{id}")
    public String workerInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("worker",workerService.findById(id));
        return "workers/worker_info";
    }

    @ApiOperation(value = "Create new worker")
    @GetMapping("/add/new")
    public String createWorker(Model model) {
        model.addAttribute("worker", Worker.builder().build());
        return "workers/worker_add";
    }

    @ApiOperation(value = "Create new worker")
    @ApiIgnore
    @PostMapping("/add")
    public String create(Worker worker){
        workerService.save(worker);
        return "redirect:/workers/list";
    }

    @ApiOperation(value = "Edit worker by id")
    @GetMapping("/edit/{id}")
    public String editWorker(@PathVariable("id") long id, Model model){
        model.addAttribute("worker", workerService.findById(id));
        return "workers/worker_edit";
    }

    @ApiOperation(value = "Edit worker")
    @ApiIgnore
    @PostMapping("/edit")
    public String edit(Worker worker){
        workerService.update(worker);
        return "redirect:/workers/list";
    }

    @ApiOperation(value = "Delete worker by id")
    @GetMapping("/delete/{id}")
    public String deleteWorker(@PathVariable("id") long id){
        workerService.deleteById(id);
        return "redirect:/workers/list";
    }
}
