package me.konghao.JPA1.springhibernate.InterFace;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import me.konghao.JPA1.springhibernate.entity.UserInfo;

public interface UserInfoDao extends CrudRepository<UserInfo, Integer> {

	// @Query("select name,age,address from UserInfo")
	// select o from UserModel o where o.age >= ?1
	@Query(value = "select name,age,address,id from UserInfo")
	List<UserInfo> query();
	
	@Query(value = "select t from UserInfo t where id<55 order by id desc")
	List<UserInfo> Top50();

}