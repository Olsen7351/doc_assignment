package com.doc.assignmentbackend.Services;

import com.doc.assignmentbackend.Model.DTO.TodoPOST;
import com.doc.assignmentbackend.Model.Todo;

import java.util.List;

public interface ITodoService {
    public List<Todo> getTodos();

    public Todo addTodos(TodoPOST todo);
    public void deleteTodos(int id);
}
