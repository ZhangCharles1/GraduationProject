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
		<title>新影随我来商城</title>
		<link href="themes/xecmoban_shunfeng/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				当前位置:
				<a href=".">首页</a>
				<code>
					&gt;
				</code>
				用户中心
			</div>
		</div>
		<div class="blank"></div>
		<div class="block clearfix">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
						<h5>
							<span>个人资料</span>
						</h5>
						<div class="blank"></div>
						<form action="index/personal.action" method="post" onsubmit="return userEdit()">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										用户名：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										${sessionScope.users.username }
										<input type="hidden" name="users.username" style="width: 160px" id="username"
											value="${sessionScope.users.username }" />
										<input type="hidden" name="users.password" style="width: 160px" id="password"
											value="${sessionScope.users.password }" />
										<input type="hidden" name="users.usersid" style="width: 160px" id="usersid"
											value="${sessionScope.users.usersid }" />
										<input type="hidden" name="users.role" style="width: 160px" id="role" value="${sessionScope.users.role }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										姓名：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input name="users.realname" type="text" size="25" class="inputBg" id="realname"
											value="${sessionScope.users.realname }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										性别：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input type="radio" name="users.sex" id="sex" value="男" checked="checked" />
										男 &nbsp;&nbsp;
										<input type="radio" name="users.sex" id="sex" value="女" />
										女
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										出生日期：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input name="users.birthday" type="text" size="25" class="inputBg" id="birthday" onclick="WdatePicker()"
											value="${sessionScope.users.birthday }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										职业：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input name="users.duty" type="text" size="25" class="inputBg" id="duty" value="${sessionScope.users.duty }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										联系方式：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input name="users.contact" type="text" size="25" class="inputBg" id="contact"
											value="${sessionScope.users.contact }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										电子邮件：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input name="users.email" type="text" size="25" class="inputBg" id="email"
											value="${sessionScope.users.email }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">
										联系地址：
									</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">
										<input name="users.address" type="text" size="25" class="inputBg" id="address"
											value="${sessionScope.users.address }" />
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF">
										<input type="submit" class="bnt_blue_1" style="border: none;" value="确认修改" />
									</td>
								</tr>
							</table>
						</form>
						<div class="blank5"></div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
