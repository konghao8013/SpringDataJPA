package me.konghao.JPA1.springhibernate.InterFace;

import org.springframework.data.jpa.repository.JpaRepository;

import me.konghao.JPA1.springhibernate.entity.UserInfo;

public interface JpaRepositoryDao extends JpaRepository<UserInfo, Integer> {

}
