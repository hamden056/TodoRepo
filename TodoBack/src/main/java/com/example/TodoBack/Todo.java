package com.example.TodoBack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Todo {
    @Id
    private int id ;
    private String name ;
    private int nummer ;
    private String adresse    ;
}
