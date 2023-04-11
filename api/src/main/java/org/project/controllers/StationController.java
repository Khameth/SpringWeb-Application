package org.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StationController {
    @GetMapping("/stations")
    public String stations(Model model){
        model.addAttribute("title","Stations");
        return "stations/stations";
    }
    @GetMapping("/stations/add")
    public String workersAdd(Model model){
        return "stations/stations_add";
    }
}
