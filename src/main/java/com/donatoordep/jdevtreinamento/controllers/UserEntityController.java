package com.donatoordep.jdevtreinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donatoordep.jdevtreinamento.dto.UserDTO;
import com.donatoordep.jdevtreinamento.services.UserService;

@RestController
@RequestMapping("/user")
public class UserEntityController {

	@Autowired
	UserService service;

	@PostMapping(path = "/insert")
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@PutMapping(path = "/update")
	public ResponseEntity<UserDTO> updateData(@RequestBody UserDTO dto) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(dto, dto.getId()));
	}

	@GetMapping(path = "/{name}")
	public ResponseEntity<List<UserDTO>> findByName(@PathVariable(name = "name") String name) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findByName(name));
	}
}
