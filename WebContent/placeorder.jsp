<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu_header.jsp"%>


<div class="order cart mt">
	<!-----------------site------------------->
	
	<input type="hidden" name="isExsit" value="${isExsit}" ></input>
	<div class="site">
		<p class="wrapper clearfix">
			<span class="fl">订单确认</span><img class="top"
				src="img/temp/cartTop02.png">
		</p>
	</div>
	<!-----------------orderCon------------------->
	<div class="orderCon wrapper clearfix">
		<div class="orderL fl">
			<!--------h3---------------->
			<h3>收件信息</h3>
			<!--------addres---------------->
			<div class="addres clearfix">


				<div class="addre fl on">
					<div class="tit clearfix">
						<p class="fl">
							${userLogin.USER_NAME }<span class="default">[默认地址]</span>
						</p>
					</div>
					<div class="addCon">
						<p>${userLogin.USER_ADDRESS }</p>
						<p>${userLogin.USER_MOBILE }</p>
					</div>
				</div>


			</div>

			<h3>支付方式</h3>
			<!--------way---------------->

			<div class="way clearfix">
				<img class="on" src="img/temp/way01.jpg"> <img
					src="img/temp/way02.jpg"> <img src="img/temp/way03.jpg">
				<img src="img/temp/way04.jpg">
			</div>
			<h3>选择快递</h3>
			<!--------dis---------------->
			<div class="dis clearfix">
				<span class="on">顺风快递</span> <span>百世汇通</span> <span>圆通快递</span> <span>中通快递</span>
			</div>
		</div>
		<div class="orderR fr">
			<div class="msg">
				<h3>
					订单内容
				</h3>
				<!--------ul---------------->




			<C:forEach var="order" items="${orderlist }">
			
			

				<ul class="clearfix">
					<li class="fl"><img src="img/product/${order.ORDER_PFNAME }" style="width: 100px;height: 100px;"></li>
					<li class="fl">
						<p>${order.ORDER_PNAME }</p>
						<p>数量：${order.ORDER_PNUM }</p>
					</li>
					<li class="fr">￥${order.ORDER_PNUM*order.ORDER_PPR }</li>
				</ul>

			</C:forEach>



			</div>
			<!--------tips---------------->
			<div class="tips">
				<p>
					<span class="fl">商品金额：</span> <span class="fr">￥${tpr }</span>
				</p>
				
				<p>
					<span class="fl">运费：</span> <span class="fr">免运费</span>
				</p>
			</div>

			<!--------tips count---------------->
			<div class="count tips">
				<p>
					<span class="fl">合计：</span><span class="fr">￥${tpr }</span>
				</p>
			</div>
			<a href="took" class="pay">去支付</a>
		</div>
	</div>
</div>



<%@ include file="footer.jsp"%>