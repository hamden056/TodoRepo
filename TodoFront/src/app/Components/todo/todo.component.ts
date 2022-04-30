import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Todo } from 'src/app/Moduls/todo';
import { TodoService } from 'src/app/Services/todo.service'

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

listOftodos ?:Todo[] ; 
todoForm !: FormGroup ; 
show =false ; 
up =false ; 
  constructor(private todoService  : TodoService ,private fb: FormBuilder) { }

  ngOnInit(): void {
    this.todoService.getAll().subscribe(todo=>this.listOftodos=todo)  ; 

this.todoForm = this.fb.group({
  id:[''] , 
  name : [''] ,
  nummer : [''] , 
  adresse : [''] ,

}) ; 

  }
  handelSubmit() {
    this.todoService.addTodo(this.todoForm.value).subscribe();
    this.ngOnInit ; 
  }
  showAddTodo(){
    this.show =!this.show ; 
  }
 

  delete(id:number) {
    this.todoService.delete(id).subscribe(); 

  }


}
