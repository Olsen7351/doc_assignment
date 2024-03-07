package com.doc.assignmentbackend.Services;

import com.doc.assignmentbackend.DAO.ITodoRepository;
import com.doc.assignmentbackend.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService, CommandLineRunner {
    @Autowired
    ITodoRepository iTodoRepository;
    @Override
    public List<Todo> getTodos() {
        return iTodoRepository.findAll();
    }

    @Override
    public Todo addTodos(Todo todo) {
        return iTodoRepository.save(todo);
    }

    // Fill with dummy data
    private void fillDummyData() {
        Todo todo1 = new Todo();
        todo1.setTitle("Task 1");
        todo1.setDescription("Task 1 Description");
        todo1.setStatus("false");
        iTodoRepository.save(todo1);

        Todo todo2 = new Todo();
        todo2.setTitle("Task 2");
        todo2.setDescription("Task 2 Description");
        todo2.setStatus("false");
        iTodoRepository.save(todo2);
    }

    @Override
    public void run(String... args) throws Exception {
        // Fill the database with dummy data on application startup
        fillDummyData();
    }
}
