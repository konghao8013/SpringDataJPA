package me.konghao.JPA1.springhibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "tb_userinfo")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 2300044412175011558L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(nullable = false, name = "name")
	private String name;
	@Column(nullable = false, name = "age")
	private String age;
	@Column(nullable = false, name = "address")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserInfo{" + "id=" + id + ", name='" + name + '\'' + ", age='" + age + '\'' + ", address='" + address
				+ '\'' + '}';
	}
}