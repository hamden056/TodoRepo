package com.example.TodoBack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
public class TodoController {
    @Autowired
    private TodoService todoService ;

    @GetMapping("findByid{id}")
    public ResponseEntity<Todo> getOne(@PathVariable int id  ) {
        return new ResponseEntity<>(todoService.getOne(id) , HttpStatus.OK) ;}

    @GetMapping("All")
    public ResponseEntity<List<Todo> >getAll(){
        return new ResponseEntity<>(todoService.getAll(),HttpStatus.OK) ;
    }

    @DeleteMapping("remove{id}")
    public ResponseEntity<Void> removeOne(@PathVariable int id){
        todoService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;}

    @DeleteMapping("removeAll")
    public ResponseEntity<Void>removeAll() {
        todoService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;}

    @PostMapping("post")
    public ResponseEntity<Todo> postOne(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.save(todo),HttpStatus.CREATED) ;}

    @PostMapping("postlist")
    public ResponseEntity<List<Todo>>postlist(@RequestBody List<Todo> list) {
        return new ResponseEntity<>(todoService.saveAll(list),HttpStatus.CREATED);}

    @PutMapping("update{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id , @RequestBody Todo todo) {
        if (todoService.isPresent(id)){
            todo.setId(id);
            return new ResponseEntity<>(todoService.save(todo) , HttpStatus.OK) ;}
        else {return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;}}}
