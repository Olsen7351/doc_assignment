import React, { useState, useEffect } from 'react';

function TodoView() {
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        // Update the URL to match the endpoint in your backend
        fetch('/getTodos') // Change this URL to match your backend endpoint
            .then(response => response.json())
            .then(data => setTodos(data)) // Store todos in state
            .catch(error => console.error('Error fetching todos:', error)); // Handle errors
    }, []);

    return (
        <div className="todoView">
            <h1>Todo View</h1>

            {/* Display all the todos */}
            <ul>
                {todos.map(todo => (
                    <li key={todo.id}>{todo.title}</li>
                ))}
            </ul>

        </div>
    );
}

export default TodoView;
