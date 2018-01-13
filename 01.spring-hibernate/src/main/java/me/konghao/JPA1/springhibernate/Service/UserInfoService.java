package me.konghao.JPA1.springhibernate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import me.konghao.JPA1.springhibernate.InterFace.UserInfoDao;
import me.konghao.JPA1.springhibernate.InterFace.UserInfoDaoPage;
import me.konghao.JPA1.springhibernate.entity.UserInfo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private UserInfoDaoPage pageDao;

	public List<UserInfo> query() {
		return userInfoDao.query();
	}

	public Iterable<UserInfo> findAllPage(Pageable pageable) {
		Page<UserInfo> persons = pageDao.findAll(pageable);

		return persons;
	}

	@PersistenceContext
	private EntityManager em;

	public List<UserInfo> Top50() {
		/*
		 * Query dataQuery = em.createQuery(dataSql); Query countQuery =
		 * em.createQuery(countSql);
		 * 
		 * if(null != user && !StringUtils.isEmpty(user.getName())) {
		 * dataQuery.setParameter(1, user.getName()); countQuery.setParameter(1,
		 * user.getName()); }long totalSize = (long)
		 * countQuery.getSingleResult(); Page<User> page = new Page();
		 * page.setTotalSize(totalSize); List<User> data =
		 * dataQuery.getResultList(); page.setData(data);
		 */
		String sqlString = "select t from UserInfo t where id<55";
		Query dataQuery = em.createQuery(sqlString);
		List<UserInfo> data = dataQuery.getResultList();
		return data;
	}

	public List<UserInfo> sqlQueryTop50() {
		List<UserInfo> data = this.userInfoDao.Top50();
		return data;
	}

	public UserInfo findByNameAndAge(String name, String age) {
		return this.pageDao.findByNameAndAge(name, age);
	}

}