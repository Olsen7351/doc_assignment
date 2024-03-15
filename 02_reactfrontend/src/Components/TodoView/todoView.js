import React, { useState, useEffect } from 'react';
import './todoView.css';

function TodoView() {
    const [todos, setTodos] = useState([]);
    const [newTodo, setNewTodo] = useState({ title: '', description: '' });

    useEffect(() => {
        // Update the URL to match the endpoint in your backend
        fetch('http://10.102.25.223:8080/todo', {
            method: 'GET'
        }) // Change this URL to match your backend endpoint
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setTodos(data);
            })
            .catch((err) => {
                console.log(err.message);
            });
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewTodo({
            ...newTodo,
            [name]: value
        });

    };

    const handleSubmit = (e) => {
        e.preventDefault();
        fetch('http://10.102.25.223:8080/todoPost', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newTodo)
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setTodos([...todos, data]); // Add the new todo to the list of todos
                setNewTodo({ title: '', description: '' }); // Clear the form
            })
            .catch((err) => {
                console.log(err.message);
            });
    };

    const handleDelete = (id) => {
        fetch(`http://10.102.25.223:8080/todoDelete/${id}`, {
            method: 'DELETE'
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                // Returning the id of the deleted todo to handle it immediately
                return id;
            })
            .then((deletedId) => {
                // Update todos state immediately by filtering out the deleted todo
                setTodos(prevTodos => prevTodos.filter((todo) => todo.id !== deletedId));
            })
            .catch((err) => {
                console.error('Error:', err);
            });
    };



    return (
        <div className="todo-list">
            <h1>Todo View</h1>
            <ul className='todoListView'>
                {todos.map((todo, index) => (
                    <li key={index}>
                        <h2>{todo.id} : {todo.title}</h2>
                        <p>{todo.description}</p>
                        <button onClick={() => handleDelete(todo.id)}>&#10006;</button>
                    </li>
                ))}
            </ul>

            {/* Form to add a new todo */}
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="title"
                    placeholder="Title"
                    value={newTodo.title}
                    onChange={handleChange}
                />
                <textarea
                    name="description"
                    placeholder="Description"
                    value={newTodo.description}
                    onChange={handleChange}
                ></textarea>
                <button type="submit">Add Todo</button>
            </form>
        </div>
    );
}

export default TodoView;
