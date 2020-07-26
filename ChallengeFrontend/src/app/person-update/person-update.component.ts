import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../service/person.service';
import { Person } from '../model/person';

@Component({
  selector: 'app-person-update',
  templateUrl: './person-update.component.html',
  styleUrls: ['./person-update.component.css']
})
export class PersonUpdateComponent {
  person: Person;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private personService: PersonService) {
    this.person = new Person();
  }

  onSubmit() {
    this.person.fullname = this.person.firstname + ' ' + this.person.lastname;
    this.personService.update(this.person);
    console.log(this.person.fullname);
  }
}
