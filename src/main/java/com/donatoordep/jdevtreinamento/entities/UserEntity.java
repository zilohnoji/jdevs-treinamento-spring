package com.donatoordep.jdevtreinamento.entities;

import java.io.Serializable;
import java.util.Objects;

import com.donatoordep.jdevtreinamento.dto.UserDTO;
import com.donatoordep.jdevtreinamento.utils.ConversibleContract;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tb")
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class UserEntity implements Serializable, ConversibleContract<UserDTO> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user")
	private Long id;
	private String name;
	private Integer age;

	public UserEntity() {
	}

	public UserEntity(UserDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.age = dto.getAge();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(age, other.age) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public UserDTO convertFrom() {
		return new UserDTO(this);
	}

}
