import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PersonFormComponent } from './person-form/person-form.component';
import {RouterModule} from '@angular/router';
import { PersonComponent } from './person/person.component';
import {FormsModule} from '@angular/forms';
import { PersonUpdateComponent } from './person-update/person-update.component';
import { PersonDeleteComponent } from './person-delete/person-delete.component';
import { PersonService } from './service/person.service';

@NgModule({
  declarations: [
    AppComponent,
    PersonFormComponent,
    PersonComponent,
    PersonUpdateComponent,
    PersonDeleteComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
