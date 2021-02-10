<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script src="js/function.js" charset="GBK"></script>
<script src="js/jquery-1.12.4.min.js" charset="UTF-8"></script>

</head>
<body>
	<div class="reg">
		<form action="register" method="post" onsubmit="return checkForm(this)">
			
			<h1>用户注册</h1>

			<p>
				用户名称： <input type="text" name="userName" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请输入用户名">
					<span></span>
			</p>
			

			<p>
				用户昵称： <input type="text" name="name" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请输入昵称">
					<span></span>
			</p>
			

			<p>
				设置密码： <input type="password" name="passWord" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请输入密码">
					<span></span>
			</p>
			

			<p>
				确认密码： <input type="password" name="rePassWord" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请确认密码">
					<span></span>
			</p>
			

			<p>
				用户性别： 
				<input type="radio" name="sex" value="T" checked="checked">男
				<input type="radio" name="sex" value="F" >女
			</p>
			

			<p>
				出生日期： <input type="text" name="birthday" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请选择出生日期" id="test1">
					<span></span>
			</p>
			

			<p>
				用户邮箱： <input type="text" name="email" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请输入邮箱">
					<span></span>
			</p>
			

			<p>
				手机号码： <input type="text" name="mobile" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请确认手机号">
					<span></span>
			</p>
			

			<p>
				送货地址： <input type="text" name="address" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="请输入送货地址">
					<span></span>
			</p>
			

			<p class="txtL txt">
				<input class="code" type="text" name="veryCode" value=""
					onfocus="FocusItem(this)" onblur="CheckItem(this)"
					placeholder="验证码"> 
				<img src="getcode" alt="看不清，换一张"onclick="change(this)">
				<span></span>
			</p>
			

			<p>
				<input type="submit" name="" value="注册">
			</p>

			<p class="txtL txt">
				完成此注册，即表明您同意了我们的 <a href="#"><使用条款和隐私策略></a>
			</p>

			<p class="link">
				<a href="login.jsp">已有账号登录</a>
			</p>


		</form>
	</div>
<script src="layDate-v5.0.9/laydate/laydate.js"></script>
<script>
	lay('#version').html('-v' + laydate.v);
	
	//执行一个laydate实例
	laydate.render({
		elem : '#test1' //指定元素
	});
</script>

</body>
</html>