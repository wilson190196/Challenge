import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../service/person.service';
import { Person } from '../model/person';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent {
  person: Person;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private personService: PersonService) {
    this.person = new Person();
  }

  onSubmit() {
    this.person.fullname = this.person.firstname + ' ' + this.person.lastname;
    this.personService.save(this.person);
    console.log(this.person.fullname);
  }
}
