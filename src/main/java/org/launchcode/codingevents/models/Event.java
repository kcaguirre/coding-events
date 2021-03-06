package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {
    private int id;
    private static int nextID = 1;

    private String name;
    private String description;

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextID;
        nextID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
