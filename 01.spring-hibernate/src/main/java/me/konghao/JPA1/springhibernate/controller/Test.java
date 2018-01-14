package me.konghao.JPA1.springhibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.konghao.JPA1.springhibernate.InterFace.UserInfoDao;
import me.konghao.JPA1.springhibernate.InterFace.UserInfoDaoPage;
import me.konghao.JPA1.springhibernate.Service.IUserInfoImpl;
import me.konghao.JPA1.springhibernate.Service.UserInfoService;
import me.konghao.JPA1.springhibernate.entity.*;
@RestController
public class Test {
	@RequestMapping("test")
	public String test() {
		return "show test";
	}

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private UserInfoDaoPage pageDao;
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private IUserInfoImpl userinfoIdao;

	@RequestMapping(value = "query", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public List<UserInfo> query() {
		List<UserInfo> users = userInfoService.query();
		
		return users;
	}

	@RequestMapping(value = "pageQuery")
	public List<UserInfo> pageQuery(@RequestParam("page") int page, @RequestParam("size") int size) {
		// PageRequest
		
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		Iterable<UserInfo> iterList = userInfoService.findAllPage(pageable);
		List<UserInfo> users = new ArrayList<UserInfo>();
		iterList.forEach(a -> {
			users.add(a);
		});

		return users;
	}

	@RequestMapping(value = "queryNameAndAge")
	public UserInfo findByNameAndAge(@RequestParam("name") String name, @RequestParam("age") String age) {
		return this.pageDao.findByNameAndAge(name, age);
	}

	@RequestMapping(value = "top50")
	public List<UserInfo> top50() {
		return this.userInfoService.Top50();
	}

	@RequestMapping(value = "sqlTop50")
	public List<UserInfo> sqlTop50() {

		return this.userInfoService.sqlQueryTop50();
	}

	@RequestMapping("queryByName")
	public UserInfo queryByName(@RequestParam("name") String name) {
		return this.userInfoService.queryByName(name);

	}

	@RequestMapping("queryNameLike")
	public List<UserInfo> queryNameLike(@RequestParam("name") String name, @RequestParam("minId") Integer minId,
			@RequestParam("maxId") Integer maxId) {
		return this.userInfoService.queryNameLike(name, minId, maxId);
	}

	@RequestMapping("updateAgeById")
	public String updateAgeById(String age, Integer id) {
		this.userInfoService.updateAgeById(age, id);
		return "OK";
		// org.springframework.transaction.annotation.Transactional
	}

	@RequestMapping("queryPageOrderIdAscAgeDesc")
	public List<UserInfo> queryPageOrderIdDescAgeAsc() {
		return this.userInfoService.queryPageOrderIdAscAgeDesc();
	}

	@RequestMapping("JpaFindAll")
	public List<UserInfo> JpaFindAll() {
		return this.userInfoService.JpaFindAll();
	}

	@RequestMapping("jpaSDaoOnely")
	public List<UserInfo> jpaSDaoOnely() {
		return this.userInfoService.jpaSDaoOnely();
	}

	@RequestMapping("jpaSDaoMulti")
	public List<UserInfo> jpaSDaoMulti() {
		return this.userInfoService.jpaSDaoMulti();
	}

	@RequestMapping("jpaSDaoPageMulti")
	public List<UserInfo> jpaSDaoPageMulti() {
		return this.userInfoService.jpaSDaoPageMulti();
	}

	@RequestMapping("queryById")
	public UserInfo queryById(@RequestParam("id") Integer id) {
		return this.userinfoIdao.queryById(id);
	}
	/*
	 * public List<UserInfo> Test1() { return userInfoDao.f }
	 */
}
