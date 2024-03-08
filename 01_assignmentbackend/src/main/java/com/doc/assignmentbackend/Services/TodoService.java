package com.doc.assignmentbackend.Services;

import com.doc.assignmentbackend.DAO.ITodoRepository;
import com.doc.assignmentbackend.Model.DTO.TodoPOST;
import com.doc.assignmentbackend.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {
    @Autowired
    ITodoRepository iTodoRepository;
    @Override
    public List<Todo> getTodos() {
        return iTodoRepository.findAll();
    }

    @Override
    public Todo addTodos(TodoPOST todo) {
        Todo newTodo = new Todo();
        newTodo.setTitle(todo.getTitle());
        newTodo.setDescription(todo.getDescription());

        return iTodoRepository.save(newTodo);
    }
    @Override
    public void deleteTodos(int id) {
        iTodoRepository.deleteById((long) id);
    }

}
