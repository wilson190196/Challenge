package com.backend.challenge.skill;

import com.backend.challenge.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsRepository extends JpaRepository<Skill, String> {

}
