<%@page import="com.my.product.dto.Product"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%String contextPath = request.getContextPath(); //'frontback'%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<%=contextPath %>/css/product.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<%=contextPath %>/js/productjq.js"></script>

</head>

<body>
	<div class="product_view">
		<% Product p = (Product)request.getAttribute("Product");%>
		<div class="product_view_pic">
			<img src="<%=contextPath%>/images/<%=p.getProdNo()%>.jpg">
		</div>
		<!--width : 450px, float : left-->
		<div>
			<h3>
				<%=p.getProdName() %><br>
				<%=p.getProdPrice() %> 원
			</h3>
		</div>
		<div class="product_view_detail">
			<fieldset>
				<legend>상세정보</legend>
				<div class = "prodNo">
				<span>상품번호 : </span>
				<span class = "prodNo"><%=p.getProdNo()%></span><br>
				</div>
				<div class ="prodName">
				<span>상품명 : </span>
				<span><%=p.getProdName()%></span><br> 
				</div>
				
				<div class= "prodPrice">
				<span>상품가격 :<%=p.getProdPrice()%></span><br> 
				</div>
				
				<div class="qty">				
				<span>수량 : <input type="number" name="qt"></span><br>
				</div>
				<button class="addtocart">장바구니 넣기</button>
		</div>
		<!--width:610px, float : right-->
		</fieldset>

	</div>
</body>

</html>