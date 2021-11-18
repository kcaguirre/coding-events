package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static HashMap<String, String> events = new HashMap<>();

    @GetMapping
    public String listAllEvents (Model model) {events.put("Free personal training", "Come get a free 1 hour session with a Generic Fitness trainer!");
        events.put("Cat adoption event", "Adoption drive for adoptable Philly cats.");
        events.put("Hackathon", "Coders of all levels welcome");
        model.addAttribute("events", events);
        return "events/index";
    }
//Because the following 2 mappings are GET and POST, its ok for them to
    // live at the events/create
    @GetMapping("create")
    public String renderCreateForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName){
       // events.add(eventName);
        return "redirect:";
    }
}
