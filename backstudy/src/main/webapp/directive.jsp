<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.util.Scanner"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page buffer="1024kb" %>
<%--현재페이지에서 발생하면 err1.jsp로 forward하라 --%>
<%@page errorPage = "err1.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>directive.jsp</title>
</head>
<body>
<%
for(int i=1; i<=100; i++){
%>
	<span><%=i%></span>
<%
}
%>

<%
FileInputStream fis = null;
String fileName = "noneextist.txt";
String fileRealPath=this.getServletContext().getRealPath("noneextist.txt");

fis = new FileInputStream(fileRealPath); //??
Scanner sc = new Scanner(fis);

/*
try{
fis = new FileInputStream(fileRealPath); //??
Scanner sc = new Scanner(fis);
}catch(FileNotFoundException e){
	RequestDispatcher rd;
	rd=request.getRequestDispatcher("err.jsp");
	request.setAttribute("e",e);
	rd.forward(request, response);
	*/
%> <%--=e.getMessage()--%>
<%
/*}*/
%>
</body>
</html>