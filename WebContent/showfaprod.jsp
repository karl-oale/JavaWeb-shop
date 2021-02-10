<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu_header.jsp"%>

<!------------------------------ad------------------------------>
<a href="#" class="ad"><img src="img/h2.jpg" style="max-width: 100%;"/></a>
<!------------------------------news------------------------------>
<div class="address">
    <div class="wrapper clearfix">
    <a href="indexcate">首页</a><span>/</span>
    
    <C:forEach var="c" items="${catelist }">
		<C:if test="${c.CATE_ID==fid }">
		${c.CATE_NAME }
		</C:if>
	</C:forEach>
   
    </div>
</div>


<div class="news">
	<div class="wrapper">
		<div class="flower clearfix tran pList">
			
			
			<C:forEach var="c" items="${catelist }">
				<C:if test="${c.CATE_ID==fid }">
					<h1 style="text-align: center; font-size: 40px;">${c.CATE_NAME }</h1>
					<hr >
					</C:if>
			</C:forEach>
					
					<C:forEach var="c" items="${catelist }">
					
						<C:if test="${c.CATE_PARENT==fid }">
						<p style="font-size: 25px;margin-top: 20px;"><b>-----------------------------------------------------------</b></p>
						<p style="font-size: 30px;margin-top: 10px;margin-bottom: 10px;color: #2F4F4F;">${c.CATE_NAME }</p>
						<p style="font-size: 25px;margin-bottom: 20px;"><b>-----------------------------------------------------------</b></p>
							<C:forEach var="p" items="${prodlist }">
								<C:if test="${p.PROD_FID==fid  and p.PROD_CID==c.CATE_ID }">
		
									<a href="toproddetail?pid=${p.PROD_ID }" class="product clearfix tran">
										<dl>
											<dt>
												<span class="abl"></span>
												<img
													src="img/product/${p.PROD_FNAME }" width="356px"
													height="356px" />
												<span class="abr"></span>
											</dt>
											<dd>${p.PROD_NAME }</dd>
											<dd>
												<span>¥ ${p.PROD_PR }</span>
											</dd>
										</dl>
									</a>
								</C:if>
							</C:forEach>
							
						</C:if>
					
					<div class="clearboth"></div>
					
					</C:forEach>
					
					<div class="clearboth"></div>
				
		</div>

	</div>
</div>


<%@ include file="footer.jsp"%>