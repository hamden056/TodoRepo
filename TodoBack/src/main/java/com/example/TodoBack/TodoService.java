package com.example.TodoBack;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo getOne(int id) {
        return todoRepository.findById(id).get() ;
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> saveAll(List<Todo> list) {
        return todoRepository.saveAll(list);
    }

    public void deleteOne(int id) {
        todoRepository.deleteById(id);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }

    public boolean isPresent(int id){
        return todoRepository.findById(id).isPresent() ;

    }
}