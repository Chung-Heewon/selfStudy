<%@page import="com.my.product.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
/*
request의 속성(이름 : "p")값 얻기
속성값이 null이면 Product객체생성 후 
request의 속성(이름:"p", 값 : Product객체)추가
*/
Product p = (Product)request.getAttribute("p");
if(p==null){
	p = new Product();
	request.setAttribute("p",p);
}
--%>

<jsp:useBean id ="p" 
			 class ="com.my.product.dto.Product" 
			 scope="request"></jsp:useBean>
<%--p.setProdNo("C0001"); p.setProdName("이름값"); --%>
<jsp:setProperty name ="p" property="prodNo"value="C0001"></jsp:setProperty>

<%--out.print(p.getProdNo()) --%>
<jsp:getProperty name="p" property="prodNo"></jsp:getProperty>

<%--class User{Dog dog;}
Dog d = new Dog();
u.setDog(d);
String dogName = u.getDog().getName();
out.print(dogName);
 --%>
 
 <%-- 
<jsp:useBean id="d" class="Dog" scope="request"></jsp:useBean>
<jsp:setProperty name ="u" property="dog" value="d"></jsp:setProperty>
<jsp:getProperty name ="u" property="dog">
--%>

</body>
</html>