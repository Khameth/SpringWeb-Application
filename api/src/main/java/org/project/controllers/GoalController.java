package org.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GoalController {
    @GetMapping("/goals")
    public String goals(Model model){
        model.addAttribute("title","Goals");
        return "goals/goals";
    }
    @GetMapping("/goals/add")
    public String workersAdd(Model model){
        return "goals/goals_add";
    }
}
