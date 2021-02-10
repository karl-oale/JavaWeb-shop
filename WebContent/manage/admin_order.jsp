<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/shop/manage/admin_doorderselect" method="get">
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
            <form action="/shop/manage/admin_doorderdel?cp=${cpage }" id="myform" method="post">
               <div class="result-title">
                    <div class="result-list">
                        <a id="batchDel" href="javascript:delmore('你确定要删除这些订单吗','myform')"><i class="icon-font"></i>批量删除</a>
                        <!--  <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>-->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name=""  onclick="selall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>商品</th>
                            <th>单价</th>
                            <th>数量</th>
                           <th>小计</th>
                           <th>用户名</th>
                            <th>操作</th>
                        </tr>
                        
                        <C:forEach var="o"  items="${orderlist}">
		                        <tr>
		                            <td class="tc"><input name="id[]" value="${o.ORDER_ID}" type="checkbox"></td>
		                            <td>${o.ORDER_ID}</td>
		                            <td><img src="../img/product/${o.ORDER_PFNAME }" style="height: 80px;width: 80px;">${o.ORDER_PNAME}</td>
		                            <td>￥${o.ORDER_PPR }</td>
		                            <td>${o.ORDER_PNUM}</td>
		                            <td>￥${o.ORDER_PNUM * o.ORDER_PPR }</td>
		                            <td>${o.ORDER_UID }</td>
		                            <td>
		                                
		                                	<a class="link-del" href="javascript:Delete('你去确定要删除【${o.ORDER_PNAME }】订单吗','/shop/manage/admin_doorderdel?oid=${o.ORDER_ID }&cp=${cpage }')">删除</a>
		                                
		                                
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
                    <a href="admin_doorderselect?cp=1${searchword}">首页</a>
                    <a href="admin_doorderselect?cp=${(cpage-1<1)?1:cpage-1}${searchword}">上一页</a>
                    <a href="admin_doorderselect?cp=${(cpage+1>tpage)?tpage:cpage+1}${searchword}">下一页</a>
                    <a href="admin_doorderselect?cp=${tpage}${searchword}">尾页</a>
                    
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>