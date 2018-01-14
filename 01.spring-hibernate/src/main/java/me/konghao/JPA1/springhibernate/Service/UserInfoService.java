package me.konghao.JPA1.springhibernate.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.konghao.JPA1.springhibernate.InterFace.JpaRepositoryDao;
import me.konghao.JPA1.springhibernate.InterFace.JpaSpecificationDao;
import me.konghao.JPA1.springhibernate.InterFace.UserInfoDao;
import me.konghao.JPA1.springhibernate.InterFace.UserInfoDaoPage;
import me.konghao.JPA1.springhibernate.entity.UserInfo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private UserInfoDaoPage pageDao;

	@Autowired
	private JpaRepositoryDao japDao;
	@Autowired
	private JpaSpecificationDao jpasDao;

	public List<UserInfo> query() {
		return userInfoDao.query();
	}

	public Iterable<UserInfo> findAllPage(Pageable pageable) {
		Page<UserInfo> persons = pageDao.findAll(pageable);
		// persons.getContent()//获取数据
		// persons.getTotalElements();//总记录数字
		// persons.getTotalPages();//总页数
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

	public UserInfo queryByName(String name) {
		return this.userInfoDao.queryByName(name).get(0);

	}

	public List<UserInfo> queryNameLike(String name, Integer minId, Integer maxId) {
		return this.userInfoDao.queryNameLike(name, minId, maxId);
	}

	@Transactional
	public void updateAgeById(String age, Integer id) {
		this.userInfoDao.updateAgeById(age, id);

	}

	public List<UserInfo> queryPageOrderIdAscAgeDesc() {
		Sort sort = new Sort(new Order(Direction.ASC, "id"), new Order(Direction.DESC, "age"));
		Iterable<UserInfo> items = this.pageDao.findAll(sort);
		List<UserInfo> users = new ArrayList<UserInfo>();
		items.forEach(a -> {
			users.add(a);
		});

		return users;
	}

	public List<UserInfo> JpaFindAll() {
		return this.japDao.findAll();
	}

	public List<UserInfo> jpaSDaoOnely() {
		Specification<UserInfo> spec = new Specification<UserInfo>() {
			/**
			 * root 查询的跟对象，用于指定查询的属性 query 实现基本的查询，一般不使用 cd 用于构造查询条件 predicate
			 * 最终的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pre = null;
				pre = cb.equal(root.get("name").as(String.class), "name_22");

				// TODO 自动生成的方法存根
				return pre;
			}

		};
		return this.jpasDao.findAll(spec);
	}

	public List<UserInfo> jpaSDaoMulti() {
		Specification<UserInfo> spec = new Specification<UserInfo>() {
			/**
			 * root 查询的跟对象，用于指定查询的属性 query 实现基本的查询，一般不使用 cd 用于构造查询条件 predicate
			 * 最终的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> pres = new ArrayList<Predicate>();
				pres.add(cb.like(root.get("name").as(String.class), "%test%"));
				pres.add(cb.greaterThan(root.get("id").as(Integer.class), 850));

				Predicate[] preArray = new Predicate[pres.size()];
				// TODO 自动生成的方法存根
				return cb.and(pres.toArray(preArray));
			}

		};

		return this.jpasDao.findAll(spec);
	}

	public List<UserInfo> jpaSDaoPageMulti() {
		Specification<UserInfo> spec = new Specification<UserInfo>() {
			/**
			 * root 查询的跟对象，用于指定查询的属性 query 实现基本的查询，一般不使用 cd 用于构造查询条件 predicate
			 * 最终的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> pres = new ArrayList<Predicate>();
				pres.add(cb.like(root.get("name").as(String.class), "%test%"));
				pres.add(cb.greaterThan(root.get("id").as(Integer.class), 850));

				Predicate[] preArray = new Predicate[pres.size()];
				// TODO 自动生成的方法存根
				return cb.and(pres.toArray(preArray));
			}

		};
		Pageable page = new PageRequest(2, 20);
		Page<UserInfo> pages = this.jpasDao.findAll(spec, page);
		return pages.getContent();
	}
}