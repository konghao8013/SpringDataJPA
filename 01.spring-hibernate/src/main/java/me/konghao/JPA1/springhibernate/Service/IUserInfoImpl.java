package me.konghao.JPA1.springhibernate.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import me.konghao.JPA1.springhibernate.InterFace.UserInfoRepository;
import me.konghao.JPA1.springhibernate.entity.UserInfo;

/*注意命名规范*/
@Repository
public class IUserInfoImpl implements UserInfoRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserInfo queryById(Integer id) {
		// TODO 自动生成的方法存根
		System.out.println("执行勒自定义的repository");

		return em.find(UserInfo.class, id);
	}

}
