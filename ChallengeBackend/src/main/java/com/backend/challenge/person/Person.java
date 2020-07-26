package com.backend.challenge.person;

import com.backend.challenge.skill.Skill;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @NotNull(message = "cannot be null")
    @Id
    private String id;
    @NotNull(message = "cannot be null")
    private String firstname;
    @NotNull(message = "cannot be null")
    private String lastname;
    @NotNull(message = "cannot be null")
    private String fullname;
    @NotNull(message = "cannot be null")
    private String address;
//    @Email(regexp=".@.\\..*", message = "Email should be valid")
    @NotNull(message = "cannot be null")
    @Email(message = "Email should be valid")
    private String mail;
    @NotNull(message = "cannot be null")
    private String phoneNumber;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Skill> skills;


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
