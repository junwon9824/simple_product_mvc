<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%--       <%@ include file="/WEB-INF/views/common/confirm.jsp" %>
 --%>      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">상품등록</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-register" method="POST" enctype="multipart/form-data" action="">
          	<input type="hidden" name="pgno" value="1">
		    <input type="hidden" name="key" value="">
		    <input type="hidden" name="word" value="">
            <div class="mb-3">
              <label for="code" class="form-label">코드 : </label>
              <input
                type="text"
                class="form-control"
                id="code"
                name="code"
                placeholder="코드"
              />
            </div>
             <div class="mb-3">
              <label for="id" class="form-label">model : </label>
              <input
                type="text"
                class="form-control"
                id="model"
                name="model"
                placeholder="model"
              />
            </div>
            <div class="mb-3">
              <label for="code" class="form-label">가격 : </label>
              <input
                type="text"
                class="form-control"
                id="price"
                name="price"
                placeholder="price"
              />
            </div>
            <div class="mb-3">
              <label for="code" class="form-label">id : </label>
              <input
                type="text"
                class="form-control"
                id="id"
                name="id"
                placeholder="id"
              />
            </div>
            <div class="col-auto text-center">
              <button type="button" id="btn-register" class="btn btn-outline-primary mb-3">
                글작성
              </button>
              <button type="button" id="btn-list" class="btn btn-outline-danger mb-3">
                목록으로이동...
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <form id="form-param" method="get" action="">
      <input type="hidden" id="pgno" name="pgno" value="${pgno}">
      <input type="hidden" id="key" name="key" value="${key}">
      <input type="hidden" id="word" name="word" value="${word}">
    </form>
    <script>
      document.querySelector("#btn-register").addEventListener("click", function () {
        if (!document.querySelector("#subject").value) {
          alert("제목 입력!!");
          return;
        } else if (!document.querySelector("#content").value) {
          alert("내용 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-register");
          form.setAttribute("action", "${root}/article/write");
          form.submit();
        }
      });
      
      document.querySelector("#btn-list").addEventListener("click", function () {
      	if(confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {
      		let form = document.querySelector("#form-param");
         	form.setAttribute("action", "${root}/article/list");
            form.submit();
     	}
      });
    </script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
