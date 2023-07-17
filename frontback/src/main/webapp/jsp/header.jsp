<%@ page  contentType="text/html; charset=UTF-8"%>
<% String contextpath = request.getContextPath(); %>
<header><!--메뉴나열-->
        <h1><a class="logo" href="<%=contextpath%>/jsp/layout.jsp">스타벅스코리아</a>
        </h1>
        <nav> <!--메뉴들이 들어가는 자리-->
            <ul>
            <%//로그인 성공되었다 세션속성명:loginedId, 값 : 로그인한 아이디 
            String loginedId = (String)session.getAttribute("loginedId");
            if(loginedId == null){
            %>
                <li><a href="<%=contextpath%>/jsp/login.jsp">로그인</a></li>
                <li><a href="<%=contextpath%>/jsp/signup.jsp">가입</a></li>
                <%}else{ %>
                <li><a href="logout">로그아웃</a></li>
                <%} %>

                <li><a href="<%=contextpath%>/productlist">상품목록</a></li>
                <li><a>장바구니목록</a></li>
                <li><a>주문목록</a></li>
            </ul>
        </nav>
    </header>