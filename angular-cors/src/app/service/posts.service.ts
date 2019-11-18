import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Posts } from '../shared/models/posts.model';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private http: HttpClient) { }

  server='http://localhost:8080';
  postsUrl = 'api/posts';

  getPosts(): Observable<Posts[]>{
    let uri = `${this.server}/${this.postsUrl}`
    console.log(`Getting post from ${uri}`);
    return this.http.get<Posts[]>(uri)
    .pipe(
      tap(_ => this.log('fetched posts')),
      catchError(this.handleError('getPosts', []))
    );
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    console.log(message);
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
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
}
