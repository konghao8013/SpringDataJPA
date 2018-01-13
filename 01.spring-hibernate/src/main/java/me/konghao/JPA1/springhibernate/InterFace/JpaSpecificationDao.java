package me.konghao.JPA1.springhibernate.InterFace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import me.konghao.JPA1.springhibernate.entity.UserInfo;

public interface JpaSpecificationDao extends JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {

}
