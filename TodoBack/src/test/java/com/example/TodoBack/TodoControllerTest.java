package com.example.TodoBack  ;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get ;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post ;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete ;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.* ;
import static org.mockito.BDDMockito.* ;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TodoControllerTest {
    @MockBean
    private TodoService todoService ;

    @Autowired
    MockMvc mockMvc   ;

    //GetMappingTest//

    @Test
    public void whengetAllTodos_thenReturnJsonArray() throws Exception {
        Todo todo1   = new Todo(1,"Jak",3,"Str1")  ;
        Todo todo2  = new Todo(2,"Mia",4,"Str2")  ;

        List<Todo> todlist = Arrays.asList(todo1, todo2) ;

        given(todoService.getAll()).willReturn(todlist) ;

        mockMvc.perform(get("/All").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].name", equalTo(todo2.getName())));
    }

    //PostMappingTest//

    @Test
    public void whenPostTodo_thenCreateTodo() throws  Exception{
        Todo todo = new Todo(1,"Marc",2,"Str") ;


        given(todoService.save(any())).willReturn(todo) ;

        ObjectMapper mapper  = new ObjectMapper() ;

        //weil wir in unserer RequestBody als JsonText schreiben werden //

        mockMvc.perform(post("/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(todo)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(todo.getName()))) ;
    }

    //DeleteMappingTest//

    @Test
    public void whenDeleteAllTodo_thenremoveAll()  throws  Exception{

        mockMvc.perform(delete("/removeAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent()) ;
    }

}
