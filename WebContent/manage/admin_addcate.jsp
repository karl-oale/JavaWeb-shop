<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
            <a href="admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/shop/manage/admin_docateselect">分类管理</a>
            <span class="crumb-step">&gt;</span>
            <span>新增分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                
                
                <form action="/shop/manage/admin_docateadd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            
                        </tr>
                        	<tr>
                                <th><i class="require-red">*</i>父类：</th>
                                <td>
                                    <select name ="cateParent" >
                                    		
                                    		
                                    		<C:forEach var="u"  items="${catelist}">
                                    		
                                    		<C:if test="${u.CATE_PARENT==0 }">
                                    			<option value="${u.CATE_ID }">${u.CATE_ID }${u.CATE_NAME }</option>
                                    		</C:if>
                                    		</C:forEach>
                                    		
                                    </select>
                                </td>
                            </tr>
                        
                            <tr>
                                <th><i class="require-red">*</i>名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="cateName" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>