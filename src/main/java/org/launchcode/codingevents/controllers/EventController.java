package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String listAllEvents (Model model) {
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }
//Because the following 2 mappings are GET and POST, its ok for them to
    // live at the events/create
    @GetMapping("create")
    public String renderCreateForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent){
       EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){
       if (eventIds != null){
           for (int id : eventIds) {
               EventData.remove(id);
           }
       }

        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String renderEditForm(Model model, @PathVariable int eventId){
    Event eventToEdit = EventData.getbyId(eventId);
    model.addAttribute("event", eventToEdit);
    String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
    model.addAttribute("title", title);
    return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description){
        Event eventToEdit = EventData.getbyId(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        return "redirect:";
    }

}
