<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=2.0">
    <title>레이아웃</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/layout.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<c:out value="${contextPath}"/>/js/layoutjq.js"></script>

</head>

<body>
    <%-- <%@include file="./header.jsp" %> --%>
	<jsp:include page="./header.jsp"/>
    <section><!-- 홈페이지 내용, aside : 홈페이지 배너-->
        <div>
            <article id="article1">드라이브스루 매장</article> <!--신문에서 하나하나 기사가 나눠있는 섹션이 나누어져있는 것-->
            <article id="article2">리저브 매장</article>
        </div>
        <aside>
            <ul>
                <li> 2023년 SUMMER EVENT 안내 </li>
                <li>단체 및 기업구매</li>
            </ul>
        </aside>
    </section>

    <%@ include file="./footer.jsp" %>
</body>

</html>