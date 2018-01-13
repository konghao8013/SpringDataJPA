package me.konghao.JPA1.springhibernate.InterFace;

import org.springframework.data.repository.PagingAndSortingRepository;

import me.konghao.JPA1.springhibernate.entity.UserInfo;

public interface UserInfoDaoPage extends PagingAndSortingRepository<UserInfo, Integer> {
	UserInfo findByNameAndAge(String name, String age);
}
