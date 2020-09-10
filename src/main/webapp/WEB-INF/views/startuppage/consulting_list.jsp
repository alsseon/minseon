<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />


<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/animate.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/magnific-popup.css">
    <style>
        .table{
            
            margin-bottom: -30px;
            text-align: center;
        }
        body > div.row.mt-5 > div > div > ul{
            margin-bottom: 150px;
        }
        #thead-c{
            background-color:#95adbe;
            
            color: white;
        }
        
    </style>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    
<title>컨설팅 현황 출력창</title>
</head>

<body>
	<h2 align = "center">컨설팅 현황 더보기</h3>
	<div class="container">
		<h3>요청한 컨설팅 내역</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>전문가명</th>
                <th>컨설팅 신청 날짜</th>
                
            </tr>
          </thead>

 		<tbody>
 			<c:forEach var="conlist" items="${conlist}" >     
   				<tr align="center">
			      <c:if test = "${conlist.status==0}">
			      	<td>${conlist.expname}</td>
			      	<td>${conlist.reqdate}</td>
			      </c:if>
	    	</tr>
  		</c:forEach>   
	</table>
</div>

	   <div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
              	<c:if test="${pagevo.startPage != 1}">
	                <li><a href="${contextPath}/startuppage/consulting_list.do?nowPage=${pagevo.startPage-1}&cntPerPage=${pagevo.cntPerPage}">&lt;</a></li>
	            </c:if>
	            <c:forEach begin = "${pagevo.startPage}" end = "${pagevo.endPage}" var="idx">
	            	<c:choose>
	            	<c:when test="${idx == pagevo.nowPage }">
	                <li class="active"><span>${idx}</span></li>
	                </c:when>
	                <c:when test="${idx!= pagevo.nowPage}">
	                <li><a href="${contextPath}/startuppage/consulting_list.do?nowPage=${idx}&cntPerPage=${pagevo.cntPerPage}"> ${idx} </a></li>
	                </c:when>
	                </c:choose>
	             </c:forEach>
	              <c:if test="${pagevo.endPage != pagevo.lastPage}">
	                <li><a href="${contextPath}/startuppage/manu_estilist.do?nowPage=${pagevo.endPage+1 }&cntPerPage=${pagevo.cntPerPage}">&gt;</a></li>
	              </c:if>
              </ul>
              
            </div>
          </div>
         
        </div>
        
        
        
        
        
        
        
        
        <div class="container">
		<h3>요청한 컨설팅 내역</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>전문가명</th>
                <th>컨설팅 신청 날짜</th>
                
            </tr>
          </thead>

 		<tbody>
 			<c:forEach var="conlist" items="${conlist}" >     
   				<tr align="center">
			      <c:if test = "${conlist.status==0}">
			      	<td>${conlist.expname}</td>
			      	<td>${conlist.reqdate}</td>
			      </c:if>
	    	</tr>
  		</c:forEach>   
	</table>
</div>

	   <div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
              	<c:if test="${pagevo.startPage != 1}">
	                <li><a href="${contextPath}/startuppage/consulting_list.do?nowPage=${pagevo.startPage-1}&cntPerPage=${pagevo.cntPerPage}">&lt;</a></li>
	            </c:if>
	            <c:forEach begin = "${pagevo.startPage}" end = "${pagevo.endPage}" var="idx">
	            	<c:choose>
	            	<c:when test="${idx == pagevo.nowPage }">
	                <li class="active"><span>${idx}</span></li>
	                </c:when>
	                <c:when test="${idx!= pagevo.nowPage}">
	                <li><a href="${contextPath}/startuppage/consulting_list.do?nowPage=${idx}&cntPerPage=${pagevo.cntPerPage}"> ${idx} </a></li>
	                </c:when>
	                </c:choose>
	             </c:forEach>
	              <c:if test="${pagevo.endPage != pagevo.lastPage}">
	                <li><a href="${contextPath}/startuppage/manu_estilist.do?nowPage=${pagevo.endPage+1 }&cntPerPage=${pagevo.cntPerPage}">&gt;</a></li>
	              </c:if>
              </ul>
              
            </div>
          </div>
         
        </div>
		 <a href = "${contextPath}/startuppage/manu_estilist_sh.do">이전으로</a>
	  <script src="${contextPath}/resources/js/jquery.min.js"></script>
  	  <script src="${contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
  	  <script src="${contextPath}/resources/js/popper.min.js"></script>
	  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	  <script src="${contextPath}/resources/js/jquery.easing.1.3.js"></script>
	  <script src="${contextPath}/resources/js/jquery.waypoints.min.js"></script>
	  <script src="${contextPath}/resources/js/jquery.stellar.min.js"></script>
	  <script src="${contextPath}/resources/js/owl.carousel.min.js"></script>
	  <script src="${contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
	  <script src="${contextPath}/resources/js/jquery.animateNumber.min.js"></script>
	  <script src="${contextPath}/resources/js/scrollax.min.js"></script>
	  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	  <script src="${contextPath}/resources/js/google-map.js"></script>
	  <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
