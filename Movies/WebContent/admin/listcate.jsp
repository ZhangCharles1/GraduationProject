<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>新影随我来网站</title>
		<link href="themes/xecmoban_shunfeng/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				当前位置:
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				商品类别
			</div>
		</div>
		<div class="blank"></div>
		<div class="block">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>商品类别</span>
					</h3>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td bgcolor="#FFFFFF" align="center">
								<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
									<tr>
										<th bgcolor="#ffffff">
											类别名称
										</th>
										<th bgcolor="#ffffff">
											操作
										</th>
									</tr>
									<s:iterator value="cateList" id="cateList">
										<tr>
											<td bgcolor="#ffffff" align="center">
												<s:property value="catename" />
											</td>
											<td bgcolor="#ffffff" align="center">
												<s:a href="cate/deleteCate.action?cate.cateid=%{cateid}"
													onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</s:a>
											</td>
										</tr>
									</s:iterator>
									<tr align="right" bgcolor="#ffffff">
										<td colspan="20">
											&nbsp;&nbsp;&nbsp;${msg} &nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp; 第${pageCur}页&nbsp;&nbsp;
											<s:url id="url_pre" value="cate/getAllCate.action">
												<s:param name="pageCur" value="pageCur-1"></s:param>
											</s:url>
											<s:url id="url_next" value="cate/getAllCate.action">
												<s:param name="pageCur" value="pageCur+1"></s:param>
											</s:url>
											<s:a href="%{url_pre}">上一页</s:a>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<s:a href="%{url_next}">下一页</s:a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
	</body>
</html>
