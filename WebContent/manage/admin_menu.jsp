<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8" />
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

</head>
<body>
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="admin_index.jsp" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on" href="admin_index.jsp">首页</a></li>
					<li><a href="../indexcate" target="_blank">网站首页</a></li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li>欢迎【${userLogin.USER_NAME }】管理员</li>
					<li><a href="/shop/manage/adminlogout">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
						<ul class="sub-menu">
							<li><a href="/shop/manage/admin_douserselect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
							<li><a href="/shop/manage/admin_docateselect"><i class="icon-font">&#xe005;</i>分类管理</a></li>
							<li><a href="/shop/manage/admin_doprodselect"><i class="icon-font">&#xe006;</i>商品管理</a></li>
							<li><a href="/shop/manage/admin_doorderselect"><i class="icon-font">&#xe004;</i>订单管理</a></li>
							<!-- <li><a href="admin_messade.jsp"><i class="icon-font">&#xe012;</i>留言管理</a></li>
							<li><a href="admin_news.jsp"><i class="icon-font">&#xe033;</i>新闻管理</a></li> -->
						</ul></li>
					<!-- <li><a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
						<ul class="sub-menu">
							<li><a href="system.html"><i class="icon-font">&#xe017;</i>系统设置</a></li>
							<li><a href="system.html"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
							<li><a href="system.html"><i class="icon-font">&#xe046;</i>数据备份</a></li>
							<li><a href="system.html"><i class="icon-font">&#xe045;</i>数据还原</a></li>
						</ul></li> -->
				</ul>
			</div>
		</div>
