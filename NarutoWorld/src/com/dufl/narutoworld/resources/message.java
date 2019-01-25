package com.dufl.narutoworld.resources;

import java.util.List;

import com.dufl.narutoworld.service.LinksService;
import com.dufl.narutoworld.service.NewsService;
import com.dufl.narutoworld.vo.Links;
import com.dufl.narutoworld.vo.News;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class message extends ActionSupport {

	private static final long serialVersionUID = 2353125932548676189L;

	private LinksService linksService = new LinksService();
	
	private NewsService newsService = new NewsService();
	
	@Override
	public String execute() throws Exception {
		List<Links> linksList = linksService.selectAll();
		ActionContext.getContext().put("linksList",linksList);
		
		List<News> newsList = newsService.selectAll();
		ActionContext.getContext().put("newsList",newsList);
		
		return SUCCESS;
	}
}
