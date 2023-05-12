package org.project.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.project.entities.Goal;
import org.project.services.GoalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
@Controller
@SessionAttributes("goal")
@RequestMapping("/goals")
@AllArgsConstructor
public class GoalController {
    private GoalService goalService;

    @ApiOperation(value = "Get all goals")
    @GetMapping("/list")
    public String goals(Model model){
        model.addAttribute("goals", goalService.findAll());
        return "goals/goals_list";
    }

    @ApiOperation(value = "Get goal by id")
    @GetMapping("/{id}")
    public String goalInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("goal",goalService.findById(id));
        return "goals/goal_info";
    }
    @ApiOperation(value = "Create new goal")
    @GetMapping("/add/new")
    public String createGoal(Model model){
        model.addAttribute("goal", new Goal());
        return "goals/goal_add";
    }

    @ApiOperation("Create new goal")
    @ApiIgnore
    @PostMapping("/add")
    public String create(Goal goal){
        goalService.save(goal);
        return "redirect:/goals/list";
    }

    @ApiOperation(value = "Edit goal by id")
    @GetMapping("/edit/{id}")
    public String editGoal(@PathVariable("id") long id, Model model) {
        model.addAttribute("goal",goalService.findById(id));
        return "goals/goal_edit";
    }

    @ApiOperation(value = "Edit goal by id")
    @ApiIgnore
    @PostMapping("/edit")
    public String edit(Goal goal){
        goalService.update(goal);
        return "redirect:/goals/list";
    }

    @ApiOperation(value = "Delete goal by id")
    @GetMapping("/delete/{id}")
    public String deleteGoal(@PathVariable("id") long id){
        goalService.deleteById(id);
        return "redirect:/goals/list";
    }

}
