package org.project.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import org.project.entities.Station;
import org.project.entities.Worker;
import org.project.services.StationService;
import org.project.services.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
@Controller
@SessionAttributes({"station", "worker"})
@RequestMapping("/stations")
@AllArgsConstructor
public class StationController {
    private StationService stationService;
    private WorkerService workerService;

    @ApiOperation(value = "Get all stations")
    @GetMapping("/list")
    public String stations(Model model){
        model.addAttribute("stations",stationService.findAll());
        return "stations/stations_list";
    }

    @ApiOperation("Get station by id")
    @GetMapping("/{id}")
    public String stationInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("station", stationService.findById(id));
        return "stations/station_info";
    }

    @ApiOperation(value = "Create new station")
    @GetMapping("/add/new")
    public String createStation(Model model){
        model.addAttribute("station",new Station());
        model.addAttribute("workers", workerService.findAll());
        return "stations/station_add";
    }

    @ApiOperation(value = "Create new station")
    @ApiIgnore
    @PostMapping("/add")
    public String create(Station station){
        stationService.save(station);
        return "redirect:/stations/list";
    }

    @ApiOperation(value = "Edit station by id")
    @GetMapping("/edit/{id}")
    public String editStation(@PathVariable("id") long id, Model model){
        model.addAttribute("station",stationService.findById(id));
        model.addAttribute("workers",workerService.findAll());
        return "stations/station_edit";
    }

    @ApiOperation(value = "Edit station")
    @ApiIgnore
    @PostMapping("/edit")
    public String edit(Station station){
        stationService.update(station);
        return "redirect:/stations/list";
    }

    @ApiOperation(value = "Delete station by id")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        stationService.deleteById(id);
        return "redirect:/stations/list";
    }


}
