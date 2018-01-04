package com.tgb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgb.model.User;
import com.tgb.service.AdminService;


@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired(required = true)
	private AdminService adminService;
	
	/**
	 * 管理员初始化主页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/adminIndex","/list",""})
	public String getAllUser(HttpServletRequest request,ModelMap map){
		
		List<User> findAll = adminService.findAll();
		map.put("userList", findAll);
		return "/adminIndex";
	}
	/**
	 * 通过id获得用户详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getUserInfoById")
	@ResponseBody
	public User getUserInfoById(User user,HttpServletRequest request,ModelMap map){
		user = adminService.getUserInfoById(user.getId());
		map.put("user", user);
		return user;
	}
}
