package org.project.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.project.entities.TimePeriod;
import org.project.services.TimePeriodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@SessionAttributes("timeperiod")
@RequestMapping("/timeperiod")
@AllArgsConstructor
public class TimePeriodController {
    private TimePeriodService timePeriodService;

    @ApiOperation(value = "Get timeperiod by id")
    @GetMapping("/{id}")
    public String timeperiodInfo(@PathVariable("id") long id, Model model) {
        model.addAttribute("timeperiod", timePeriodService.findById(id));
        return "timeperiods/timeperiod_info";
    }

    @ApiOperation(value = "Create new timeperiod")
    @GetMapping("/add/new")
    public String addTimeperiod(Model model) {
        model.addAttribute("timeperiod", new TimePeriod());
        return "timeperiods/timeperiod_add";
    }

    @ApiOperation(value = "Create new timeperiod")
    @PostMapping("/add")
    public String createTimeperiod(TimePeriod timePeriod) {
        timePeriodService.save(timePeriod);
        return "redirect:/timeperiod/add/new";
    }

    @ApiOperation(value = "Edit timeperiod by id")
    @GetMapping("/edit/{id}")
    public String editTimeperiod(@PathVariable("id") long id, Model model) {
        model.addAttribute("timeperiod", timePeriodService.findById(id));
        return "timeperiods/timeperiod_edit";
    }

    @ApiOperation(value = "Edit timeperiod")
    @PostMapping("/edit")
    public String editTimeperiod(TimePeriod timePeriod) {
        timePeriodService.update(timePeriod);
        return String.format("redirect:/timeperiod/%s", timePeriod.getId());
    }

    @ApiOperation(value = "Delete timeperiod by id")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        timePeriodService.deleteById(id);
        return "redirect:/";
    }
}

