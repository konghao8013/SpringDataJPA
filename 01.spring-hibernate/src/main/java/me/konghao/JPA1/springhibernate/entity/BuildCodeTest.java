package me.konghao.JPA1.springhibernate.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "tb_BuildCodeTest")
public class BuildCodeTest implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = -1663299499663536777L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Integer Id;
	@Column(name = "Name", nullable = false)
	private String Name;
	@Column(name = "Age", nullable = false)
	private Integer Age;
	@Column(name = "Address", nullable = false)
	private String Address;
	@Column(name = "DescA", nullable = false)
	private String DescA;

	/**
	 * 获取 这是ID列
	 **/
	public Integer getId() {
		return Id;
	}

	/**
	 * 设置 这是ID列
	 **/
	public void setId(Integer Id) {
		this.Id = Id;
	}

	/**
	 * 获取 这是名称
	 **/
	public String getName() {
		return Name;
	}

	/**
	 * 设置 这是名称
	 **/
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * 获取 年龄
	 **/
	public Integer getAge() {
		return Age;
	}

	/**
	 * 设置 年龄
	 **/
	public void setAge(Integer Age) {
		this.Age = Age;
	}

	/**
	 * 获取 地址
	 **/
	public String getAddress() {
		return Address;
	}

	/**
	 * 设置 地址
	 **/
	public void setAddress(String Address) {
		this.Address = Address;
	}

	/**
	 * 获取 说明
	 **/
	public String getDescA() {
		return DescA;
	}

	/**
	 * 设置 说明
	 **/
	public void setDescA(String DescA) {
		this.DescA = DescA;
	}

	@Override
	public String toString() {
		return "BuildCodeTest{" + "'Id'='" + Id + "'" + ",'Name'='" + Name + "'" + ",'Age'='" + Age + "'"
				+ ",'Address'='" + Address + "'" + ",'DescA'='" + DescA + "'" + '}';
	}
}
