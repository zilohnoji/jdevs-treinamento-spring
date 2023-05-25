package com.donatoordep.jdevtreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.donatoordep.jdevtreinamento.dto.UserDTO;
import com.donatoordep.jdevtreinamento.entities.UserEntity;
import com.donatoordep.jdevtreinamento.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements GenericService<UserEntity, Long, UserDTO> {

	@Autowired
	UserRepository repository;

	@Override
	public JpaRepository<UserEntity, Long> repository() {return repository;}

	/* <-- Personalized Queries --> */
	
	public List<UserDTO> findByName(String name) {
		return repository.findByName(name.toLowerCase()).stream().map(x -> x.convertFrom()).toList();
	}
}
