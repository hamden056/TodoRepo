import { Injectable } from '@angular/core';
import {HttpClient} from'@angular/common/http' ; 
import { Observable } from 'rxjs';
import { Todo } from '../Moduls/todo';



@Injectable({
  providedIn: 'root'
})
export class TodoService {

   url : String ='http://localhost:8080/'
  constructor(private http :HttpClient) { }

  public getAll () : Observable<Todo[]>{
    return this.http.get<Todo[]>(this.url + 'All')
  
  }
  public addTodo(todo :Todo){
    return this.http.post<Todo>(this.url + 'post' , todo) ; 
  }
  public delete(id:number) {
    return this.http.delete<Todo>(this.url +'remove'+ id) ; 
  }
  public getById(id : number) {
    return this.http.get<Todo>(this.url +'findById' +id );
  }
  public update(id:number , todo : Todo) {
    return this.http.put<Todo>(this.url+ 'update' + id , todo) ; 
  }

}

