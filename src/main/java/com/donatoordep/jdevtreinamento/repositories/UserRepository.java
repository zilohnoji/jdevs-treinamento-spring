package com.donatoordep.jdevtreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.donatoordep.jdevtreinamento.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT u FROM UserEntity u WHERE LOWER(u.name) LIKE %:name%")
	public List<UserEntity> findByName(String name);
}
