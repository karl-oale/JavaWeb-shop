<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/shop/manage/admin_doprodselect" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/shop/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/shop/manage/admin_toaddprod"><i class="icon-font"></i>新增商品</a>
                       <!--  <a id="batchDel" href="javascript:delmore('你确定要删除这些用户吗','myform')"><i class="icon-font"></i>批量删除</a> -->
                        <!--  <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>-->
                    </div>
                </div>
                <div class="result-content">
                    
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name=""  onclick="selall(this)" type="checkbox"></th>
                            <th>商品图片</th>
                            <th>商品名称</th>
                            <th>商品售价</th>
                           <th>商品库存</th>
                           <th>商品分类</th>
                            <th>操作</th>
                        </tr>
                        
                        <C:forEach var="p"  items="${prodlist}">
		                        <tr>
		                            <td class="tc"><input name="id[]" value="${p.PROD_ID}" type="checkbox"></td>
		                            <td><img alt="" src="../img/product/${p.PROD_FNAME }" width="80px" height="80px"></td>
		                            <td>${p.PROD_NAME}</td>
		                            <td>${p.PROD_PR}</td>
		                            <td>${p.PROD_STK}</td>
		                            <td>
		                            	<C:forEach var="c" items="${catelist }">
		                            		<C:if test="${p.PROD_FID == c.CATE_ID }">
		                            			${c.CATE_NAME}--|--
		                            		</C:if>
		                            		<C:if test="${p.PROD_CID == c.CATE_ID }">
		                            			${c.CATE_NAME}
		                            		</C:if>
		                            	</C:forEach>
		                            	
		                            </td>
		                            
		                            <td>
		                                <a class="link-update" href="admin_toprodupdate?pid=${p.PROD_ID}&cpage=${cpage}">修改</a>
		                                
		                                
		                                	<a class="link-del" href="javascript:Delete('你去确定要删除【${p.PROD_NAME }】商品吗','/shop/manage/admin_doproddel?id=${p.PROD_ID }&cpage=${cpage }')">删除</a>
		                                
		                                
		                            </td>
		                        </tr>
		                    
                        </C:forEach>
                        
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
								}
							}
                        
                        	
                        	function delmore(mess,formname) {
                        		if (confirm(mess)) {
									var form = document.getElementById(formname);
									form.submit();
								}
							}
                        </script>
                        
                    </table>
                    <div class="list-page">
                    
                    共${tsum }条记录，当前${cpage}/${tpage<1?1:tpage}页
                    <a href="admin_doprodselect?cp=1${searchword}">首页</a>
                    <a href="admin_doprodselect?cp=${(cpage-1<1)?1:cpage-1}${searchword}">上一页</a>
                    <a href="admin_doprodselect?cp=${(cpage+1>tpage)?tpage:cpage+1}${searchword}">下一页</a>
                    <a href="admin_doprodselect?cp=${tpage}${searchword}">尾页</a>
                    
                    
                    
                    
                    
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>