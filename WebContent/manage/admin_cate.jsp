<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        
        <div class="result-wrap">
            <form action="/shop/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/shop/manage/admin_toaddcate"><i class="icon-font"></i>新增分类</a>
                        
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="50%">
                        <tr>
                            
                            <th width="40px">序号</th>
                            <th>名称</th>
                            <th>父类</th>
                            <th>操作</th>
                        </tr>
                        
                        <C:forEach var="u"  items="${catelist}">
                        	<C:if test="${u.CATE_PARENT==0 and u.CATE_ID!=0 }">
		                         
		                         <tr>
				                            
				                            <td>${u.CATE_ID}</td>
				                            <td>${u.CATE_NAME}</td>
				                            <td>${u.CATE_PARENT}</td>
				                            <td>
				                                
				                                <a class="link-update" href="admin_tocateupdate?id=${u.CATE_ID }">修改</a>
				                                <a class="link-del" href="javascript:Delete('你去确定要删除【${u.CATE_ID }${u.CATE_NAME }】分类吗','/shop/manage/admin_docatedel?id=${u.CATE_ID }')">删除</a>
				                                
				                                
				                            </td>
		                         </tr>
		                         <C:forEach var="c"  items="${catelist}">
		                         		<C:if test="${c.CATE_PARENT== u.CATE_ID }">
					                         <tr>
					                           
					                            <td>${c.CATE_ID}</td>
					                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-||-${c.CATE_NAME}</td>
					                            <td>${c.CATE_PARENT}</td>
					                            <td>
					                                
					                                <a class="link-update" href="admin_tocateupdate?id=${c.CATE_ID }">修改</a>
					                                <a class="link-del" href="javascript:Delete('你去确定要删除【${c.CATE_ID }${c.CATE_NAME }】分类吗','/shop/manage/admin_docatedel?id=${c.CATE_ID }')">删除</a>
					                                
					                                
					                            </td>
					                        </tr>
		                        		</C:if>
		                         
		                    	 </C:forEach>
		                    	  </C:if>
                        </C:forEach>
                        
                        <script>
                        	function Delete(mess,url) {
                        		
                        		if (confirm(mess)) {
									
										location.href=url;
									}
									
								}
							
                        	
                        </script>
                        
                    </table>
                    
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>