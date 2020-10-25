package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    public EventCategoryRepository EventCategoryRepository;

//    displayAllEvents
    @GetMapping()
    public String displayAllEvents(Model model){
        model.addAttribute("title","All Categories");
        model.addAttribute("categories",EventCategoryRepository.findAll());
        return "eventCategories/index";
    }

//    renderCreateEventCategoryForm
    @GetMapping("create")
    public String renderCreateEventCategoryForm(Model model){
        model.addAttribute("title","Create Category");
        model.addAttribute("EventCategory", new EventCategory());
        return "eventCategories/create";
    }

//    processCreateEventCategoryForm
    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory eventCategory, Errors errors,Model model){
        model.addAttribute("title","Create Category");

        if(errors.hasErrors()){
            model.addAttribute("Errors", "Create Event");
            return "eventCategories/create";
        } else {
            model.addAttribute("EventCategory",EventCategoryRepository.save(eventCategory));
            return "redirect:";
        }
    }

}
