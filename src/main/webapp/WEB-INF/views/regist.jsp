<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>상품 정보 등록</h2>
 	 <form id="registForm" method="POST" action="">
	  
	  <input type="hidden" name="action" value="">
	    
	    <div class="form-group">
	      <label for="productCode">고유번호</label>
	      <input type="text" class="form-control" id="code" name="code" placeholder="고유번호 입력">
	    </div>
	    
	    <div class="form-group">
	      <label for="model">모델명</label>
	      <input type="text" class="form-control" id="model" name="model" placeholder="모델명 입력">
	    </div>
	    
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" id="price" name="price" placeholder="가격 입력" >
	    </div>
	    
		<div class="form-group">
	      <label for="userId">등록자명</label>
	      <input type="text" class="form-control" id="id" name="id">
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	</div>
	 
	 
	<script type="text/javascript"> 
	
	document.querySelector("#regist").addEventListener("click", function () {	
		
          let form = document.querySelector("#registForm");
          form.setAttribute("action", "${root}/article/write");
          form.submit();
	});
	
    </script>
    
	<%-- --%>
<%@ include file="/include/footer.jsp" %>