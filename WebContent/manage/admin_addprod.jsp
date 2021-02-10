<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="admin_menu.jsp" %>
   
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
            <a href="admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/shop/manage/admin_douserselect">商品管理</a>
            <span class="crumb-step">&gt;</span>
            <span>新增商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/shop/manage/admin_doprodadd" method="post" enctype="multipart/form-data" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        
                        <tr>
                                <th><i class="require-red">*</i>商品类别：</th>
                                <td>
                                    <select class="common-text required"  name="prodfcid">
                                    	<C:forEach var="f" items="${catelist}">
                                    	
                                    		<C:if test="${f.CATE_ID != 0 and f.CATE_PARENT==0}"> 
                                    			<option value="${f.CATE_ID }" disabled="disabled">${f.CATE_NAME }</option>
                                    		
	                                    		 <C:forEach var="c" items="${catelist}">
	                                    			<C:if test="${c.CATE_PARENT == f.CATE_ID }">
	                                    				<option value="${f.CATE_ID },${c.CATE_ID}" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-|${c.CATE_NAME }</option>
	                                    			</C:if>
	                                    		</C:forEach>
                                    		
                                    		</C:if>
                                    	</C:forEach>
                                    </select>
                                </td>
                            </tr>
                            
                        
                            <tr>
                                <th><i class="require-red">*</i>商品名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="prodname" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>商品价格：</th>
                                <td>
                                    <input class="common-text required" id="title" name="prodpr" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>商品库存：</th>
                                <td>
                                    <input class="common-text required" id="title" name="prodstk" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>商品描述：</th>
                                <td>
                                    <input class="common-text required" id="title" name="proddesc" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>商品图片：</th>
                                <td>
                                    <input class="common-text required" id="title" name="prodfname" size="50" value="" type="file">
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