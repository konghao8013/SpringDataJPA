package me.konghao.JPA1.springhibernate.InterFace;

import me.konghao.JPA1.springhibernate.entity.UserInfo;

public interface UserInfoRepository {
	public UserInfo queryById(Integer id);
}
