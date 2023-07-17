<%@page import="com.my.util.PageBean"%>
<%@page import="com.my.product.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%String contextPath = request.getContextPath(); //'frontback'%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<%=contextPath%>/css/productlist.css">
<link rel="stylesheet" href="<%=contextPath%>/css/layout.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<%=contextPath%>/js/layoutjq.js"></script>
"
<script src="<%=contextPath %>/js/productlist.jq.js"></script>



</head>

<body>
	<jsp:include page="./header.jsp" />
</body>
<section>
	<%String msg = (String)request.getAttribute("msg");
  if(msg != null){ //상품목록검색 실패
%>
	<h3>
		상품목록 검색 실패:
		<%=msg%></h3>
	<% 
  }else{
	//List<Product> list = (List)request.getAttribute("list");
	PageBean<Product> pb = (PageBean<Product>)request.getAttribute("pagebean");
	//List<Product> list = pb.getList();
	int totalCnt = pb.getTotalCnt(); //총상품수
	
%>
	<div class="productlist">
		<%for(Product p : pb.getList()){
%>
		<div class="product <%=p.getProdNo()%>">
			<ul>
				<li><img src="<%=contextPath%>/images/<%=p.getProdNo()%>.jpg"
					alt="<%=p.getProdNo()%>"> <span><%=p.getProdName()%></span></li>
			</ul>
		</div>
		<%}//for %>
	</div>
	<div class="pagegroup">
		<%
    //int cntPerPageGroup=3; //페이지 그룹
	int cntPerPageGroup = pb.getCntPerPageGroup();
    //int cntPerPage =4; //한페이지에 보여줄 최대상품수
    int cntPerPage = pb.getCntPerPage();
    /*int currentPage =1;
    String cp = request.getParameter("cp");
    	if(cp != null && !cp.equals("")){
    	currentPage=Integer.parseInt(cp);
    	}*/
    int currentPage = pb.getCurrentPage();
	/*totalCnt       totalPage
	   1                1
	   2                1
	   3                1
	   4                1
	   
	   5                2
	   6                2
	   7                2
	   8                2
	   
	   9                3
	   10               3
	
	*/
	//int totalPage = (int)Math.ceil((double)totalCnt/cntPerPage);  //총상품수 cntPerPage 활용
    int totalPage = pb.getTotalPage();
    /* currentPage  StartPage endPage
      
    
    */
    	
    /*int startPage = (currentPage-1)/cntPerPageGroup*cntPerPageGroup+1;
    int endPage = startPage + cntPerPageGroup -1;
    if(totalPage<endPage){
    	endPage = totalPage;
    }
    */
    int startPage = pb.getStartPage();
    int endPage = pb.getEndPage();
    if(startPage >1){
	%><span class="page<%=startPage-1%>">PREV</span>&nbsp;&nbsp;
	<%
    }
    for(int i=startPage; i<=endPage; i++){
    %><span class="page<%=i%>">[<%=i%>]</span>&nbsp;&nbsp;
	<%} 
    
    if(totalPage > endPage){
    %><span class="page<%=endPage+1%>">NEXT</span>
	<%} %>
	</div>

	<%}//else %>
</section>
<%@ include file="./footer.jsp"%>


</html>