<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu_header.jsp"%>


<div class="address">
    <div class="wrapper clearfix">
    <a href="indexcate">首页</a><span>/</span>
    <a href="/shop/tofacate?fid=${p.PROD_FID }">
    
    <C:forEach var="c" items="${catelist }">
		<C:if test="${c.CATE_ID==p.PROD_FID }">
		${c.CATE_NAME }
		</C:if>
	</C:forEach>
    </a>
    <span>/</span>
    <a href="/shop/tochcate?fid=${p.PROD_FID }&cid=${p.PROD_CID}">
    <C:forEach var="c" items="${catelist }">
		<C:if test="${c.CATE_ID==p.PROD_CID }">
		${c.CATE_NAME }
		</C:if>
	</C:forEach>
    </a>
    <span>/</span>
    ${p.PROD_NAME }
    </div>
</div>




<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl"><img class="det" src="img/product/${p.PROD_FNAME }" height="100px"width="100px"/>
                
            </div>
            <div class="fr intro">
                <div class="title"><h4>${p.PROD_NAME }</h4>
                    <p>${p.PROD_DESC }</p><span>￥${p.PROD_PR }</span></div>
                <div class="proIntro">
                    <p>库存<span>${p.PROD_STK }</span>件</p>
                    <div class="num clearfix"><img class="fl sub" src="img/temp/sub.jpg">
                    <span id="num" class="fl" contentEditable="true">1</span>
                    <img class="fl add" src="img/temp/add.jpg">
                        
                </div>
                <div class="btns clearfix" style="margin-top: 30px;">
                <a href="javascript:shopbuy(${p.PROD_ID })"><p class="buy fl">立即购买</p></a>
                <a href="javascript:orderadd(${p.PROD_ID},0)"><p class="cart fr">加入购物车</p></a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script>
function shopbuy(id){
	var num=document.getElementById("num").innerHTML;
	location.href='prodtoplaceorder?pid='+id+'&num='+num;
}

function orderadd(pid,type){
	
	var num=document.getElementById("num").innerHTML;

	var url='/shop/orderadd?pid='+pid+'&num='+num+'&type='+type;
	
	location.href=url;
}


</script>

<%@ include file="footer.jsp"%>