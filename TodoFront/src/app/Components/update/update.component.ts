import { HttpClient } from '@angular/common/http';
import { identifierName } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Todo } from 'src/app/Moduls/todo';
import { TodoService } from 'src/app/Services/todo.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  todoToBeUpdated!:Todo ;

    updatedForm!: FormGroup

  show :boolean =false ; 

  constructor(private todoService :TodoService , private fb : FormBuilder , private rout : ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.rout.snapshot.paramMap.get('id') ; 
  
    this.todoService.getById(parseInt('id', 10)).subscribe(todo=>this.todoToBeUpdated=todo);
  

  this.updatedForm = this.fb.group({

    id: [''] , 
    name:[''], 
    nummer: [''], 
    adresse: [''],

  }) ; 
  
  }
  handelSubmitUpdate(){
    this.todoService.update(this.todoToBeUpdated.id , this.updatedForm.value).subscribe() ;
  }

  showUpdate(){
    this.show = !this.show ; 
  }

update(){

  this.updatedForm.setValue({
    id : this.todoToBeUpdated.id,
    name:this.todoToBeUpdated.name, 
    nummer :this.todoToBeUpdated.nummer , 
    adresse : this.todoToBeUpdated.adresse ,
  });

  this.show = !this.show ; 
}


}

