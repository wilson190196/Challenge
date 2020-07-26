package com.backend.challenge.skill;

import com.backend.challenge.person.Person;
import com.backend.challenge.person.PersonRepository;
import com.backend.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {

    @Autowired
    private SkillsRepository skillsRepository;


    @GetMapping("/Skill/{id}")
    public Skill getSkill(@PathVariable String id) {
        Skill skill = null;
        if(skillsRepository.findById(id).isPresent() == false) throw new PersonNotFoundException("The skill with the id " + id + " is not found");
        else{
             skill = skillsRepository.findById(id).get();
        }
        return skill;
    }

    @PostMapping("/Skill")
    public void addPerson(@RequestBody Skill skill) {
        skillsRepository.save(skill);
    }

    @DeleteMapping (value = "/Skill/{id}")
    public void deletePerson(@PathVariable String id) {
        Skill skill = skillsRepository.findById(id).get();
        if(id == null) throw new PersonNotFoundException("The skill with the id " + id + " is not found");
        skillsRepository.deleteById(id);
    }

    @PutMapping("/Skill")
    public void updateNote(@RequestBody Skill updated) {
        Skill skill = skillsRepository.findById(updated.getName()).get();
        if(skill == null) throw new PersonNotFoundException("The skill with the id " + updated.getId() + " is not found");
        skill.setId(updated.getId());
        skill.setName(updated.getName());
        skill.setLevel(updated.getLevel());
        skill.setPersons(updated.getPersons());
        Skill updatedSkill = skillsRepository.save(skill);
    }

}
