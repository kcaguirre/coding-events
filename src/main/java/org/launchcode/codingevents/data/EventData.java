package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    private static Map<Integer, Event> events = new HashMap<>();

    public static Collection<Event> getAll(){
        return events.values();
    }

    public static void add(Event event){
        events.put(event.getId(),event);
    }

    public static Event getbyId(Integer id){
        return events.get(id);
    }

    public static void remove(int id){
            events.remove(id);

    }
}

