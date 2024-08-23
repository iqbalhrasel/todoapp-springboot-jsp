package com.pxc.todoapp_jsp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pxc.todoapp_jsp.model.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer>{
	List<Todo> findByUsername(String username);

}
