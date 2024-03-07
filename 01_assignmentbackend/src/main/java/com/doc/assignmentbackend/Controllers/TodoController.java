package com.doc.assignmentbackend.Controllers;

import com.doc.assignmentbackend.Model.Todo;
import com.doc.assignmentbackend.Services.ITodoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    private final ObjectMapper mapper;
    private ITodoService todoService;

    public TodoController(@Autowired ITodoService todoService, ObjectMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }
    @GetMapping("/todo")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }
    @PostMapping("/todo")
    public Todo addTodos(@RequestBody String todo) {
        //Convert String to Todo
        Todo todoObj = null;
        try {
            todoObj = mapper.readValue(todo, Todo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return todoService.addTodos(todoObj);
    }
}
