package com.example.TodoBack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.BDDMockito. *  ;
import static org.assertj.core.api.Assertions.* ;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class )
public class TodoServiceTest {

    @MockBean
    private TodoRepository todoRepository ;


    @Autowired
    private TodoService todoService ;

    @TestConfiguration
    static class TodoServiceContextConfiguration{
        @Bean
        public TodoService custormerService () {
            return new TodoService() ;
        }

    }

    Todo todo1 =   new Todo(1,"Jak",2,"Str1") ;
    Todo todo2 = new Todo(3,"Marc",3,"Str2") ;
    List<Todo> todoList = Arrays.asList(todo1,todo2) ;

    @Test
    public void whengetAll_ReturnTodoList()  {
        given(todoRepository.findAll()).willReturn(todoList) ;
        assertThat(todoService.getAll()).hasSize(2)
                .contains(todo1,todo2) ;

    }
    @Test
    public void whenGetById_TodoshouldBeFound() {
        Todo todo = new Todo(1, "Hamden", 4, "Str");
        given(todoRepository.findById(anyInt())).willReturn(Optional.ofNullable(todo));
        Todo tod = todoService.getOne(1);

        assertThat(tod.getName()).containsIgnoringCase("Hamden");
    }

}



