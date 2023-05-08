package org.project.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.project.entities.Gender;
import org.project.services.GenderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@SessionAttributes("gender")
@RequestMapping("/gender")
@AllArgsConstructor
public class GenderController {
    private GenderService genderService;

    @ApiOperation(value = "Get gender by id")
    @GetMapping("/{id}")
    public String genderInfo(@PathVariable("id") long id, Model model) {
        model.addAttribute("gender", genderService.findById(id));
        return "genders/gender_info";
    }

    @ApiOperation(value = "Edit gender by id")
    @GetMapping("/edit/{id}")
    public String editGender(@PathVariable("id") long id, Model model) {
        model.addAttribute("gender", genderService.findById(id));
        return "genders/gender_edit";
    }

    @ApiOperation(value = "Edit gender")
    @PostMapping("/edit")
    public String edit(Gender gender) {
        genderService.update(gender);
        return String.format("redirect:/gender/%s", gender.getId());
    }

    @ApiOperation(value = "Create new gender")
    @GetMapping("/add/new")
    public String addGender(Model model) {
        model.addAttribute("gender", new Gender());
        return "genders/gender_add";
    }

    @ApiOperation(value = "Create new gender")
    @PostMapping("/add")
    public String add(Gender gender) {
        genderService.save(gender);
        return "redirect:/";
    }

    @ApiOperation(value = "Delete gender by id")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        genderService.deleteById(id);
        return "redirect:/";
    }
}

