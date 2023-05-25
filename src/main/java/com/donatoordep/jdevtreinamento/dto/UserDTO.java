package com.donatoordep.jdevtreinamento.dto;

import java.util.Objects;

import com.donatoordep.jdevtreinamento.entities.UserEntity;
import com.donatoordep.jdevtreinamento.utils.ConversibleContract;

public class UserDTO implements ConversibleContract<UserEntity>{
	private Long id;
	private String name;
	private Integer age;

	public UserDTO() {
	}

	public UserDTO(UserEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.age = entity.getAge();
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
		UserDTO other = (UserDTO) obj;
		return Objects.equals(age, other.age) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public UserEntity convertFrom() {
		return new UserEntity(this);
	}

}
