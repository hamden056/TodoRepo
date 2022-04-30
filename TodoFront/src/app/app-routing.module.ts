import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodoComponent } from './Components/todo/todo.component';
import {UpdateComponent} from './Components/update/update.component'
const routes: Routes = [
  
  {path :'todo' , component : TodoComponent},
  {path : 'todo/update/:id', component : UpdateComponent },
  {path :'' , redirectTo: '/todo',pathMatch:'full'},
  {path : '**', redirectTo: '/todo',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
