package com.backend.challenge.skill;

import com.backend.challenge.person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    private String id;
    @NotNull(message = "cannot be null")
    private String name;
    @NotNull(message = "cannot be null")
    private int level;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Person> persons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
