package com.donatoordep.jdevtreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.donatoordep.jdevtreinamento.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT u FROM UserEntity u WHERE u.name LIKE %?1%")
	public List<UserEntity> findByName(String name);
}
