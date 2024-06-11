<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.7.1.min.js"></script>   
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<H1>${param.pagenum } 페이지의 게시물 목록입니다. </H1>
<table border="3">
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
	<c:forEach items="${boardlist }" var="dto">
		<tr><td>${dto.seq }</td><td><a href="boarddetail?seq=${dto.seq }">${dto.title }</a></td><td>${dto.writer }</td><td>${dto.viewcount }</td>
	</c:forEach> 
</table>

<h3>페이지를 선택하세요</h3>
<% 
int totalboard = (Integer)request.getAttribute("totalboard");
int totalpage = 0;
if(totalboard % 3 == 0){
	totalpage = totalboard / 3;
}
else{
	totalpage = totalboard / 3 + 1;
}

for(int i = 1; i <= totalpage; i++){
%>


<a href="<%=request.getRequestURI() %>?pagenum=<%=i%>"> <%=i%>페이지 </a>
<%
}
%>
</body>
</html>




