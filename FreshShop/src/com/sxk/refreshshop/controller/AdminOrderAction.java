package com.sxk.refreshshop.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxk.refreshshop.pojo.Order;
import com.sxk.refreshshop.pojo.OrderItem;
import com.sxk.refreshshop.service.OrderService;
import com.sxk.refreshshop.utils.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	// 模型驱动使用的类
	private Order order = new Order();

	public Order getModel() {
		return order;
	}
	// 接收page参数
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	private OrderService orderService = new OrderService();

	// 提供后台查询所有订单的方法:
	public String findAll(){
		// 订单的分页查询
		PageBean<Order> pageBean = orderService.findAll(page);
		// 将数据存入到值栈中保存到页面
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转:
		return "findAll";
	}

	// 修改订单状态
	public String updateState(){
		// 根据id查询订单
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(3);
		orderService.update(currOrder);
		// 页面跳转
		return "updateStateSuccess";
	}
	
	// 根据订单的id查询订单项:
	public String findOrderItem(){
		// 根据订单id查询订单项:
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		// 显示到页面:
		ActionContext.getContext().getValueStack().set("list", list);
		// 页面跳转
		return "findOrderItem";
	}
}
