package com.donatoordep.jdevtreinamento.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.donatoordep.jdevtreinamento.exceptions.IdentificationNullException;
import com.donatoordep.jdevtreinamento.exceptions.ResourceNotFoundException;
import com.donatoordep.jdevtreinamento.utils.ConversibleContract;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface GenericService<E extends ConversibleContract<DTO>, ID, DTO extends ConversibleContract<E>> {

	JpaRepository<E, ID> repository();

	default public DTO insert(DTO dto) {
		return repository().save(dto.convertFrom()).convertFrom();
	}

	default public List<DTO> findAll() {
		return repository().findAll().stream().map(x -> x.convertFrom()).toList();
	}

	default public void deleteById(ID id) {
		repository().deleteById(id);
	}

	default public DTO findById(ID id) {
		return repository().findById(id).orElseThrow(() -> new ResourceNotFoundException()).convertFrom();
	}

	default public DTO update(DTO dto, ID id) {
		if (id == null) throw new IdentificationNullException();
		return repository().save(dto.convertFrom()).convertFrom();
	}
}
