<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%-- head.jsp --%>
<%@include file="/common/head.jsp" %>

<body>
	
	<%-- top --%>
	<%@include file="/common/top.jsp" %>
	
	<form action="<%=request.getContextPath() %>/postDetail" method="get" id="DetailFrm">
		<input type="hidden" name="post_no" id="post_no">
	</form>
	
	<div class="container-fluid">
		<div class="row">
				
			<%-- left --%>
			<%@include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${boardVo.board_name }</h2><br>
						<div class="table-responsive">
							<table class="table table-striped table table-hover" >
								<thead>
									<tr>
										<th>게시판 번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>등록일자</th>									
									</tr>
								</thead>
								<tbody>
									<% request.setAttribute("nbsp", " "); %>
									<c:forEach items="${postPageList }" var="postVo">
										<tr data-no="${postVo.post_no }" data-delete="${postVo.post_delete }">
											<td>${postVo.post_no }</td>											
											<td>
												<c:choose>
													<c:when test="${postVo.post_delete=='y' }">[ &excl; - 삭제된 글입니다 ]</c:when>
													<c:otherwise>${fn:replace(postVo.post_title, nbsp,'&nbsp;') }</c:otherwise>
												</c:choose>											
											</td>
											<td>${postVo.std_id }</td>
											<td><fmt:formatDate value="${postVo.post_date }" pattern="yyyy-MM-dd"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<a href="<%=request.getContextPath() %>/postInsert?board_no=${boardVo.board_no }" class="btn btn-default pull-right">게시글 등록</a>
						
						<div class="text-center">
							<ul class="pagination">
								<%= (String)request.getAttribute("nav") %>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(function(){
		
		// 테이블의 tr 클릭 이벤트
		$("table tbody tr").click(function(){
			
			if($(this).data("delete")=="y"){
				alert("해당 글은 삭제된 글입니다.");
				return;
			}else{
				$("#post_no").val($(this).data("no"));
				$("#DetailFrm").submit();				
			}
		});
	});
</script>
</body>
</html>