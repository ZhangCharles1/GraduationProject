package com.sxk.refreshshop.service;

import java.util.List;

import com.sxk.refreshshop.dao.ProductDao;
import com.sxk.refreshshop.pojo.Product;
import com.sxk.refreshshop.utils.PageBean;

public class ProductService {
	// 注入ProductDao
	private ProductDao productDao = new ProductDao();

	// 首页上热门商品查询
	public List<Product> findHot() {
		return productDao.findHot();
	}

	// 首页上最新商品的查询
	public List<Product> findNew() {
		return productDao.findNew();
	}

	// 根据商品ID查询商品
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	// 根据一级分类的cid带有分页查询商品
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

//	// 根据二级分类查询商品信息
//	public PageBean<Product> findByPageCsid(Integer csid, int page) {
//		PageBean<Product> pageBean = new PageBean<Product>();
//		// 设置当前页数:
//		pageBean.setPage(page);
//		// 设置每页显示记录数:
//		int limit = 8;
//		pageBean.setLimit(limit);
//		// 设置总记录数:
//		int totalCount = 0;
//		totalCount = productDao.findCountCsid(csid);
//		pageBean.setTotalCount(totalCount);
//		// 设置总页数:
//		int totalPage = 0;
//		// Math.ceil(totalCount / limit);
//		if (totalCount % limit == 0) {
//			totalPage = totalCount / limit;
//		} else {
//			totalPage = totalCount / limit + 1;
//		}
//		pageBean.setTotalPage(totalPage);
//		// 每页显示的数据集合:
//		// 从哪开始:
//		int begin = (page - 1) * limit;
//		List<Product> list = productDao.findByPageCsid(csid, begin, limit);
//		pageBean.setList(list);
//		return pageBean;
//	}

	// 后台查询所有商品带分页
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层保存商品方法:
//	public void save(Product product) {
//		productDao.save(product);
//	}

	// 业务层删除商品
	public void delete(Product product) {
		productDao.delete(product);
	}

	// 业务层修改商品的方法
//	public void update(Product product) {
//		productDao.update(product);
//	}

}
