import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../service/person.service';
import { Person } from '../model/person';

@Component({
  selector: 'app-person-delete',
  templateUrl: './person-delete.component.html',
  styleUrls: ['./person-delete.component.css']
})
export class PersonDeleteComponent {
  person: Person;
  hide = true;

  constructor(private personService: PersonService) {
    this.person = new Person();
  }

  onSubmit() {
    this.personService.find(this.person.id).subscribe(data => this.person = data, error => {
      this.person.firstname = 'not found';
      this.person.lastname = 'not found';
      this.person.address = 'not found';
      this.person.mail = 'not found';
      this.person.phoneNumber = 'not found';
    });
    this.personService.delete(this.person.id);
    this.hide = false;
  }
}
