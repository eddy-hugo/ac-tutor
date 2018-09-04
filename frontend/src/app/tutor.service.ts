import { Injectable } from '@angular/core';
import { Tutor } from './tutor';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TutorService {
  private tutorsUrl = 'http://127.0.0.1:8082/tutor'; 

  
  constructor(private http: HttpClient,
    private messageService: MessageService) { }

    private log(message: string) {
      this.messageService.add(`TutorService: ${message}`);
    }

  getTutors(): Observable<Tutor[]> {
    return this.http.get<Tutor[]>(this.tutorsUrl+'/all') .pipe(
      catchError(this.handleError('gettutores', []))
    );
  } 

  getTutor(id: number):  Observable<Tutor>  {
    const url = `${this.tutorsUrl}/${id}`;
    return this.http.get<Tutor>(url).pipe( 
      tap(_ => this.log(`fetched tutor id=${id}`)),
    catchError(this.handleError<Tutor>(`getTutor id=${id}`))
  );


  } 

  updateTutor (tutor: Tutor): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.put(this.tutorsUrl, tutor, httpOptions).pipe(
      tap(_ => this.log(`updated tutor id=${tutor.id}`)),
      catchError(this.handleError<any>('updateTutor'))
    );
  }

  addTutor (tutor: Tutor): Observable<Tutor> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.post<Tutor>(this.tutorsUrl, tutor, httpOptions).pipe(
      tap((tutor: Tutor) => this.log(`added tutor w/ id=${tutor.id}`)),
      catchError(this.handleError<Tutor>('addTutor'))
    );
  }

  deleteTutor (tutor: Tutor | number): Observable<Tutor> {

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    const id = typeof tutor === 'number' ? tutor : tutor.id;
    const url = `${this.tutorsUrl}/${id}`;
  
    return this.http.delete<Tutor>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted tutor id=${id}`)),
      catchError(this.handleError<Tutor>('deleteTutor'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
   
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
   
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
   
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  searchTutors(term: string): Observable<Tutor[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Tutor[]>(`${this.tutorsUrl}/?name=${term}`).pipe(
      tap(_ => this.log(`found tutors matching "${term}"`)),
      catchError(this.handleError<Tutor[]>('searchTutors', []))
    );
  }
}
