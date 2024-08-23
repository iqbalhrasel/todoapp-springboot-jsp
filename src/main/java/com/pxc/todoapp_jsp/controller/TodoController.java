package com.pxc.todoapp_jsp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pxc.todoapp_jsp.model.Todo;
import com.pxc.todoapp_jsp.service.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        return authentication.getName();
    }
	
	@GetMapping({"/", "home"})
	public String homePage(ModelMap modelMap) {
		List<Todo> todos = service.getAllTodosByUsername(getLoggedInUsername());
		modelMap.put("homeActive", "active");
		modelMap.put("todos", todos);
		return "home";
	}
	
	@GetMapping("add-todo")
	public String addTodoPage(ModelMap modelMap) {
		Todo todo = new Todo();
		todo.setTargetDate(LocalDate.now());
		todo.setUsername(getLoggedInUsername());
		
		modelMap.put("addTodoActive", "active");
		modelMap.put("todo", todo);
		return "todoForm";
	}
	
	@PostMapping("add-todo")
	public String addTodo(@Valid Todo todo, BindingResult result, ModelMap modelMap) {
		if(result.hasErrors()) {
			if(todo.getTitle().length()<2)
				modelMap.put("titleAlert", "yes");
			
			if(todo.getDescription().length()<2)
				modelMap.put("descriptionAlert", "yes");
			return "todoForm";
		}
		
		service.saveTodo(todo);
		return "redirect:/";
	}
	
	@GetMapping("edit-todo")
	public String editTodoPage(int id, ModelMap modelMap) {
		Todo todo = service.findTodoByid(id);
		modelMap.put("todo", todo);
		return "todoForm";
	}
	
	@PostMapping("edit-todo")
	public String editTodo(@Valid Todo todo, BindingResult result, ModelMap modelMap) {
		if(result.hasErrors()) {
			if(todo.getTitle().length()<2)
				modelMap.put("titleAlert", "yes");
			
			if(todo.getDescription().length()<2)
				modelMap.put("descriptionAlert", "yes");
			return "todoForm";
		}
		
		service.updateTodo(todo);
		return "redirect:/";
	}
	
	@GetMapping("delete-todo")
	public String deleteTodo(int id) {
		service.deleteTodoById(id);
		return "redirect:/";
	}
	
	@GetMapping("about")
	public String aboutPage(ModelMap modelMap) {
		
		modelMap.put("aboutActive", "active");
		return "about";
	}

}
