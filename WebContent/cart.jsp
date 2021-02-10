<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu_header.jsp"%>

<div class="cart mt">
    
    <form action="carttoplaceorder" >
    <div class="site"><p class=" wrapper clearfix"><span class="fl">购物车</span>
    <img class="top" src="img/temp/cartTop01.png">
    <a href="indexcate" class="fr">继续购物&gt;</a></p></div>
    <!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>单价</div>
            <div>数量</div>
            <div>小计</div>
            <div>操作</div>
        </div>
        <input name="t" value="1" type="hidden">
        <input name="t" value="2" type="hidden">
        <input name="t" value="3" type="hidden">
        <C:forEach var="c" items="${cartlist}">
		        <div class="th">
		            <div class="pro clearfix">
			            <label class="fl">
				            <input name="id[]" value="${c.ORDER_ID }"  type="checkbox"/>
				            <span></span>
			            </label>
			            <a class="fl" href="toproddetail?pid=${c.ORDER_PID }">
			                <dl class="clearfix">
			                    <dt class="fl">
			                    	<img src="img/product/${c.ORDER_PFNAME }" style="height: 120px;width: 120px;">
			                    </dt>
			                    <dd class="fl">
			                    	<p>${c.ORDER_PNAME }</p>
			                    </dd>
			                </dl>
			            </a>
		            </div>
		            
		            <div class="price">￥${c.ORDER_PPR }</div>
		            
		            <div class="number">
			            <p class="num clearfix">
			            	<img class="fl sub" src="img/temp/sub.jpg">
			            	<span class="fl">${c.ORDER_PNUM }</span>
			            	<img class="fl add" src="img/temp/add.jpg">
			            </p>
		            </div>
		            
		            <div class="price sAll">￥${c.ORDER_PNUM * c.ORDER_PPR }</div>
		            
		            <div class="price"><a  href="javascript:Delete('你去确定要删除【${c.ORDER_PNAME }】订单吗','toorderdel?oid=${c.ORDER_ID }')">删除</a></div>
		        
		        </div>
        
        </C:forEach>
        
        <div class="goOn">空空如也~<a href="index.html">去逛逛</a></div>
        <div class="tr clearfix">
        	<label class="fl">
	        	<input class="allChoose" name=""  onclick="selall(this)" type="checkbox">
	        	<span></span>
        	</label>
           
            <p class="fr">
	            <span>共<small id="sl">0</small>件商品</span>
	            <span>合计:&nbsp;￥</span><span ><small id="all" >0.00</small></span>
	            <input style="margin-left: 40px;
    width: 150px;
    text-align: center;
    color: #fff;
    background: #8e8e8e;" class="count" value="结算" type="submit">
	           
            </p>
        </div>
    </div>
</form>
</div>






<div class="mask"></div>
<div class="tipDel"><p>确定要删除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="toorderdel?oid=${c.ORDER_ID }">确定</a><a class="fr cancel" href="#">取消</a></p></div>
    
    					<script>
                        	function Delete(mess,url) {
								if (confirm(mess)) {
									location.href=url;
								}
							}
                        	
                        	function selall(th) {
								var a = document.getElementsByName('id[]');
								for (var i = 0; i < a.length; i++) {
									a[i].checked = th.checked;
									/* alert(id[i]); */
								}
							}
                        
                        	
                        	function delmore(mess,formname) {
                        		if (confirm(mess)) {
									var form = document.getElementById(formname);
									form.submit();
								}
							}
                        </script>
    
 
<%@ include file="footer.jsp"%>