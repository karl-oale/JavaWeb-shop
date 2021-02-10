
var flag=true;

function change(img)
{
	img.src="getcode?"+new Date().getTime();
}

function FocusItem(th)
{
	if($(th).attr('name') == 'veryCode')
	{
		$(th).next().next().html('').removeClass('error');
		$(th).next().next().html('').removeClass('correct');
	}
	else{
		$(th).next('span').html('').removeClass('error');
		$(th).next('span').html('').removeClass('correct');
	}
	
}

function CheckItem(th)
{
	var msgbox=$(th).next('span');
	var codebox=$(th).next().next();
	
	switch($(th).attr('name')){
		case 'userName':
					if(th.value == "")
					{
						msgbox.html('用户名不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else
					{
						var url="usernamecheck?name="+encodeURI($(th).val())+"&"+new Date().getTime();
						
						$.get(url, function(data)
									{
										
										if(data=='flase')
										{
											msgbox.html('此用户名已被占用');
						
											msgbox.addClass('error');
											flag=flag&false;
										}
										else
										{
											msgbox.html('此用户名可用');
						
											msgbox.addClass('correct');
											flag=flag&true;
										}
									}
								)
					}
					break;
					
		case 'name':
					if(th.value == "")
					{
						msgbox.html('用户昵称不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else{
						flag=flag&true;
					}
					break;
					
		case 'passWord':
					if(th.value == "")
					{
						msgbox.html('用户密码不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else{
						flag=flag&true;
					}
					break;
					
		case 'rePassWord':
					if(th.value == "")
					{
						msgbox.html('确认密码不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else if($(th).val() !=$('input[name="passWord"]').val())
					{
						msgbox.html('确认密码不一致！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else{
						flag=flag&true;
					}
					break;
					
		case 'birthday':
					if(th.value == "")
					{
						msgbox.html('出生日期不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else{
						flag=flag&true;
					}
					break;
					
		case 'email':
					if(th.value == "")
					{
						msgbox.html('用户邮箱不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else{
						flag=flag&true;
					}
					break;
					
		case 'mobile':
					if(th.value == "")
					{
						msgbox.html('手机号码不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else{
						flag=flag&true;
					}
					break;
					
		case 'address':
					if(th.value == "")
					{
						msgbox.html('送货地址不能为空！');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else{
						flag=flag&true;
					}
					break;
					
		case 'veryCode':
					if(th.value == "")
					{
						codebox.html('验证码不能为空！');
						
						codebox.addClass('error');
						flag=flag&false;
					}
					
					else
					{
						var url="codecheck?incode="+encodeURI($(th).val())+"&"+new Date().getTime();
						
						$.get(url, function(codedata)
									{
										/*alert(codedata);*/
										if(codedata=='flase')
										{
											
											codebox.html('验证码错误');
						
											codebox.addClass('error');
											flag=flag&false;
										}
										else
										{
											codebox.html('验证码正确');
						
											codebox.addClass('correct');
											flag=flag&true;
										}
									}
								)
					}
					break;
		
	}
	
}



function checkForm(th){
	
	var frms = th.getElementsByTagName('input');
	flag=true;
	for(var i = 0;i < frms.length; i++)
	{
		if(frms[i] != null){
			if(frms[i].getAttribute("onblur"))
			{
				CheckItem(frms[i]);
			}
		}
	}
	
	alert(flag);
	
	if(flag==0)
	{
		return false;
	}else
	{
		return true;
	}
	
	
}