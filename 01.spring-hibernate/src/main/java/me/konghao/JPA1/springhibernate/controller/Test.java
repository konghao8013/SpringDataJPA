package me.konghao.JPA1.springhibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.konghao.JPA1.springhibernate.InterFace.UserInfoDao;
import me.konghao.JPA1.springhibernate.InterFace.UserInfoDaoPage;
import me.konghao.JPA1.springhibernate.Service.UserInfoService;
import me.konghao.JPA1.springhibernate.entity.UserInfo;

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
	/*
	 * public List<UserInfo> Test1() { return userInfoDao.f }
	 */
}
