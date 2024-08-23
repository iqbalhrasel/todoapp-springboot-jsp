package com.pxc.todoapp_jsp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxc.todoapp_jsp.dao.TodoRepo;
import com.pxc.todoapp_jsp.model.Todo;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepo todoRepo;

	public List<Todo> getAllTodosByUsername(String username) {
		
		return todoRepo.findByUsername(username);
	}

	public void saveTodo(Todo todo) {
		todo.setCreatedAt(LocalDate.now());
		todo.setLastUpdated(LocalDate.now());
		todoRepo.save(todo);
	}

	public Todo findTodoByid(int id) {
		return todoRepo.findById(id).orElse(new Todo());
	}

	public void updateTodo(Todo todo) {
		todo.setLastUpdated(LocalDate.now());
		todoRepo.save(todo);
	}

	public void deleteTodoById(int id) {
		todoRepo.deleteById(id);
	}

}
