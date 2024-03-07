package com.doc.assignmentbackend.DAO;

import com.doc.assignmentbackend.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository extends JpaRepository<Todo, Long> {

}
