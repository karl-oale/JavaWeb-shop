<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>我的商城</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><!-- <img src="img/logo.png"/> --></a></h1>
        <div class="fr clearfix" id="top1">
        	<p class="fl">
	        	<C:if test="${isLogin!=1 }">
	        			<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a> 
	        	</C:if>
	            
	            <C:if test="${isLogin==1 }">
	        			欢迎${userLogin.USER_NAME }<a href="logout" id="reg">退出</a>
	        	</C:if>
	           
	           <C:if test="${isAdminLogin==1 }">
	        			<a href="manage/admin_index.jsp" id="reg">进入后台</a>
	        	</C:if>
           	</p>
                <!-- <form action="#" method="get" class="fl"><input type="text" placeholder="智能家居"/>
                <input type="button"/></form> -->
                <div class="btn fl clearfix">
	                <a href="mygxin.html"><!-- 我的首页 -->
	                	<img src="img/grzx.png"/></a>
	                <a href="tocart"><!-- 购物车 -->
	                	<img src="img/gwc.png"/>
	                </a>
		             <p>
			                <a href="tocart">
			                	<img src="img/smewm.png"/>
			                </a>
		              </p>
	             </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexcate">首页</a></li>
   
            <C:forEach var="u"  items="${catelist}">
            
            	<C:if test="${u.CATE_PARENT==0 and u.CATE_ID!=0}">
            		<li><a href="/shop/tofacate?fid=${u.CATE_ID }">${u.CATE_NAME }</a>
		                <div class="sList2">
		                    <div class="clearfix">
		                    	<C:forEach var="c"  items="${catelist}">
		                    		<C:if test="${c.CATE_PARENT==u.CATE_ID }">
		                    		<a href="/shop/tochcate?fid=${u.CATE_ID }&cid=${c.CATE_ID }">${c.CATE_NAME }</a>
		                    	</C:if>
		                    	</C:forEach>
		                    </div>
		                </div>
	            	</li>
            	</C:if>
            </C:forEach>
        </ul>
    </div>
</div>
