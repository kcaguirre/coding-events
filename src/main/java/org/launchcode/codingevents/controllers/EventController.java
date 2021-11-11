package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    @GetMapping
    public String event (Model model) {
        List<String> events = new ArrayList<>();
        events.add("One fish");
        events.add("Two fish");
        events.add("Red fish");
        events.add("Blue fish");
        model.addAttribute("events", events);
        return "events/index";
    }
}
