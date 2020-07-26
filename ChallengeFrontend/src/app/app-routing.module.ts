import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonComponent } from './person/person.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { PersonUpdateComponent } from './person-update/person-update.component';
import { PersonDeleteComponent } from './person-delete/person-delete.component';

const routes: Routes = [
  { path: 'person', component: PersonComponent },
  { path: 'addperson', component: PersonFormComponent },
  { path: 'deleteperson', component: PersonDeleteComponent },
  { path: 'updateperson', component: PersonUpdateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
