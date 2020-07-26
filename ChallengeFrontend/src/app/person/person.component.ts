import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../service/person.service';
import { Person } from '../model/person';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent{
  person: Person;
  hide = true;

  constructor(private personService: PersonService) {
    this.person = new Person();
  }

  onSubmit() {
    this.personService.find(this.person.id).subscribe(data => this.person = data,
        error => {this.person.firstname = 'not found';
                  this.person.lastname = 'not found';
                  this.person.fullname = 'not found';
                  this.person.address = 'not found';
                  this.person.mail = 'not found';
                  this.person.phoneNumber = 'not found'; } );
    this.hide = false;
  }

}
