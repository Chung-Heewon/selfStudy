<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=2.0">
    <title>레이아웃</title>
    <link rel="stylesheet" href="../css/layout.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="../js/layoutjq.js"></script>"

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