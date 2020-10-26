package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity {

    @NotBlank(message = "Category is required")
    private String name;

    @OneToMany(mappedBy="eventCategory")
    private final List<Event> events = new ArrayList<>(); // list cannot change, but contents can


    // constructor 1
    public EventCategory(String name) {
        this.name = name;
    }

    // constructor 2 - creates an instance used by the ORM
    public EventCategory() {
    }


    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }
}
