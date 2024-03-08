package com.doc.assignmentbackend.Controllers;

import com.doc.assignmentbackend.Model.DTO.TodoPOST;
import com.doc.assignmentbackend.Model.Todo;
import com.doc.assignmentbackend.Services.ITodoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final ObjectMapper mapper;
    private final ITodoService todoService;

    public TodoController(@Autowired ITodoService todoService, ObjectMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }
    @GetMapping("/todo")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }
    @PostMapping("/todoPost")
    public Todo addTodos(@RequestBody String todo) {
        //Convert String to Todo
        TodoPOST todoObj = null;
        try {
            todoObj = mapper.readValue(todo, TodoPOST.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return todoService.addTodos(todoObj);
    }
    
    @DeleteMapping("/todoDelete/{id}")
    public void deleteTodos(@PathVariable int id) {
        todoService.deleteTodos(id);
    }
}
