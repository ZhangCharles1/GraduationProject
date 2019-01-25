package com.sxk.refreshshop.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxk.refreshshop.pojo.User;
import com.sxk.refreshshop.service.UserService;
import com.sxk.refreshshop.utils.PageBean;

public class UserAdminAction extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;

	// 模型驱动使用的类
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	private UserService userService = new UserService();
	
	// 接受page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 后台查询所有用户的方法带分页:
	public String findAll(){
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	// 后台用户的删除
	public String delete(){
		User existUser = userService.findByUid(user.getUid());
		userService.delete(existUser);
		return "deleteSuccess";
	}
	
	// 后台用户的编辑
	public String edit(){
		user = userService.findByUid(user.getUid());
		return "editSuccess";
	}
	
}
