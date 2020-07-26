import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Person } from '../model/person';
import { Observable } from 'rxjs';

@Injectable()
// {providedIn: 'root'})
export class PersonService {
  private personUrl: string;

  constructor(private http: HttpClient) {
    this.personUrl = 'http://localhost:8080/Person';
  }

  public find(id: string): Observable<Person> {
    return this.http.get<Person>(this.personUrl + '/' + id);
  }

  public save(person: Person) {
   return this.http.post<Person>(this.personUrl, person).subscribe(
     () => {
       console.log('Storage done !');
     },
     (error) => {
       console.log('Error ! : ' + error);
     }
   );
  }

  public delete(id: Person['id']) {
    return this.http.delete<Person>(this.personUrl + '/' + id).subscribe(
      () => {
        console.log('delete done !');
      },
      (error) => {
        console.log('Error ! : ' + error);
      }
    );
  }

  public update(person: Person) {
    return this.http.put<Person>(this.personUrl, person).subscribe(
      () => {
        console.log('Storage done !');
      },
      (error) => {
        console.log('Error ! : ' + error);
      }
    );
  }

}
