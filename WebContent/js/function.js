
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
						msgbox.html('�û�������Ϊ�գ�');
						
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
											msgbox.html('���û����ѱ�ռ��');
						
											msgbox.addClass('error');
											flag=flag&false;
										}
										else
										{
											msgbox.html('���û�������');
						
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
						msgbox.html('�û��ǳƲ���Ϊ�գ�');
						
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
						msgbox.html('�û����벻��Ϊ�գ�');
						
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
						msgbox.html('ȷ�����벻��Ϊ�գ�');
						
						msgbox.addClass('error');
						flag=flag&false;
					}
					else if($(th).val() !=$('input[name="passWord"]').val())
					{
						msgbox.html('ȷ�����벻һ�£�');
						
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
						msgbox.html('�������ڲ���Ϊ�գ�');
						
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
						msgbox.html('�û����䲻��Ϊ�գ�');
						
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
						msgbox.html('�ֻ����벻��Ϊ�գ�');
						
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
						msgbox.html('�ͻ���ַ����Ϊ�գ�');
						
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
						codebox.html('��֤�벻��Ϊ�գ�');
						
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
											
											codebox.html('��֤�����');
						
											codebox.addClass('error');
											flag=flag&false;
										}
										else
										{
											codebox.html('��֤����ȷ');
						
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