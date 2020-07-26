package com.backend.challenge.person;

import com.backend.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/Person/{id}")
    public Person getPerson(@PathVariable String id) {
        Person person = null;
        if(personRepository.findById(id).isPresent() == false) throw new PersonNotFoundException("The person with the id " + id + " is not found");
        else{
             person = personRepository.findById(id).get();
        }
        return person;
    }

    @PostMapping("/Person")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @DeleteMapping (value = "/Person/{id}")
    public void deletePerson(@PathVariable String id) {
        Person person = personRepository.findById(id).get();
        if(person==null) throw new PersonNotFoundException("The person with the id " + id + " is not found");
        personRepository.deleteById(id);
    }

    @PutMapping("/Person")
    public void updateNote(@RequestBody Person updated) {
        Person person = personRepository.findById(updated.getId()).get();
        if(person==null) throw new PersonNotFoundException("The person with the id " + updated.getId() + " is not found");
        person.setFirstname(updated.getFirstname());
        person.setLastname(updated.getLastname());
        person.setFullname(updated.getFullname());
        person.setAddress(updated.getAddress());
        person.setMail(updated.getMail());
        person.setPhoneNumber(updated.getPhoneNumber());
        person.setSkills(updated.getSkills());
        Person updatedPerson = personRepository.save(person);
    }

}
