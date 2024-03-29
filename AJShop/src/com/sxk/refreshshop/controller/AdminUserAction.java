package com.sxk.refreshshop.controller;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxk.refreshshop.pojo.AdminUser;
import com.sxk.refreshshop.service.AdminUserService;

public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {
	
	private static final long serialVersionUID = 1L;
	
	// 模型驱动使用的对象
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// 注入AdminUserService
	private AdminUserService adminUserService = new AdminUserService();

	// 后台登录的执行的方法
	public String login() {
		// 调用service方法完成登录
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// 判断
		if (existAdminUser == null) {
			// 用户名或密码错误
			this.addActionError("用户名或密码错误!");
			return "loginFail";
		} else {
			// 登录成功:
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
}
