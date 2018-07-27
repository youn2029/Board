<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- head.jsp --%>
<%@include file="/common/head.jsp" %>

<body>
	
	<%-- top --%>
	<%@include file="/common/top.jsp" %>
	
	<%-- update화면이동 --%>
	<form id="updateFrm" action="<%=request.getContextPath() %>/postUpdate" method="get">
		<input type="hidden" name="post_no" value="${postVo.post_no }">
	</form>				
	
	<%-- delete --%>
	<form id="deleteFrm" action="<%=request.getContextPath() %>/postDelete" method="get">
		<input type="hidden" name="post_no" value="${postVo.post_no }">
		<input type="hidden" name="board_no" value="${postVo.board_no }"> 
	</form>
	
	<%-- replyInsert --%>
	<form id="replyInsertFrm" action="<%=request.getContextPath() %>/replyInsert" method="get">
		<input type="hidden" name="post_pno" value="${postVo.post_no }">
		<input type="hidden" name="post_group" value="${postVo.post_group }">
		<input type="hidden" name="board_no" value="${postVo.board_no }">
	</form>
	
	<div class="container-fluid">
		<div class="row">
				
			<%-- left --%>
			<%@include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-11 blog-main">
						<form id="frm" class="form-horizontal" role="form" method="post" action="<%=request.getContextPath() %>/postUpdate">
							<input type="hidden" name="board_no" value="${postVo.board_no }"> 
							<h2 class="sub-header">게시판 상세보기</h2><br>
							
							<!-- 제목 -->
							<div class="form-group">
								<label for="post_title" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-8">
									<label name="post_title" class="control-label">${postVo.post_title }</label>
								</div>
							</div>
							
							<!-- 게시글 내용 -->
							<div class="form-group">
								<label for="post_content" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-9" style="margin-top:10px;">
									${postVo.post_content }
<%-- 									<textarea class="form-control" name="post_content" rows="10" required readonly>${postVo.post_content }</textarea> --%>
								</div>
							</div>
							
							<!-- 첨부파일 -->
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">첨부파일</label>
								<div id="file" class="col-sm-10">
										<ul class="list-unstyled" style="margin-top:5px;">
											<c:forEach items="${fileList }" var="fileVo">
												<li style="margin-bottom:10px;"><a href="<%=request.getContextPath() %>/fileDownload?file_no=${fileVo.file_no }">${fileVo.file_name }</a></li>
											</c:forEach>
										</ul>
								</div>
							</div>			
		
						</form>
						
						<!-- 댓글 등록 -->
						<form id="recFrm" class="form-horizontal"  method="post" action="<%=request.getContextPath() %>/recInsert">
							<div class="form-group">
								<label class="col-sm-2 control-label">댓글</label>
								<input type="hidden" name="post_no" value="${postVo.post_no }">
								<div class="col-sm-8" style="folat=left;">
									<textarea class="form-control" id="rec_content" name="rec_content" rows="2" required></textarea>
								</div>
								<input class="btn btn-default" style="folat=left;" type="submit" id="btnRecInsert" value="댓글 등록">
							</div>
						</form>
						
						<!-- 댓글 목록 -->
						<c:forEach items="${recList }" var="recVo">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<input type="hidden" name="post_no" value="${postVo.post_no }">
									<div class="col-sm-9">
										<table width="100%">
											<tr>
												<c:choose>
													<c:when test="${recVo.rec_delete=='y' }">
														<td width="100%"><label>[ &excl; - 삭제된 댓글입니다 ]</label></td>
													</c:when>
													<c:otherwise>
														<td width="15%"><label name="std_id" >${recVo.std_id }</label></td>
														<td width="60%"><label name="rec_content" >${recVo.rec_content }</label></td>
														<td width="15%">
															<label name="rec_date"><fmt:formatDate value="${recVo.rec_date }" pattern="yyyy-MM-dd"/></label>
														</td>
														<td width="10%">
															<!-- 삭제 버튼 -->
															<c:if test="${stdVo.id == recVo.id }">
																	<input class="btn btn-default btnRecDelete" type="button" data-id="${recVo.rec_no }" id="btnRecDelete" value="삭제">
															</c:if>
														</td>
													</c:otherwise>
												</c:choose>
											</tr>
										</table>										
									</div>
								</div>
						</c:forEach>
						
						<!-- 수정/삭제/답글 버튼 -->
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="pull-right" aria-label="...">
									<input class="btn btn-default" type="button" id="btnPostUpdate" value="수정">
									<input class="btn btn-default" type="button" id="btnPostDelete" value="삭제">
									<input class="btn btn-default" type="button" id="btnReplyInsert" value="답글">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- 댓글 삭제시 form -->
<form class="form-horizontal" id="recDeleteFrm" action="<%=request.getContextPath() %>/recDelete" method="post">
	<input type="hidden" id="rec_post_no" name="post_no" value="${postVo.post_no }">
	<input type="hidden" id="rec_no" name="rec_no" value="">
</form>
<script type="text/javascript">
	$(function(){
		
		var post_id = ${postVo.id };
		var id = ${stdVo.id };
		
		// 수정&삭제 버튼 숨기기
		if (post_id!=id) {
			$("#btnPostUpdate").hide();
			$("#btnPostDelete").hide();
		}
		
		// 수정버튼
		$("#btnPostUpdate").click(function(){			
			$("#updateFrm").submit();
		});
		
		// 삭제버튼
		$("#btnPostDelete").click(function(){
			var check = confirm("정말로 삭제 하시겠습니까?");
			
			if(check)
				$("#deleteFrm").submit();			
		});
		
		// 답글버튼
		$("#btnReplyInsert").click(function(){
			$("#replyInsertFrm").submit();
		});
		
		// 삭제 버튼
		$(".btnRecDelete").click(function(){
			$("#rec_no").val($(this).data("id"));
			
			if (confirm("정말로 삭제 하시겠습니까?")) {
				$("#recDeleteFrm").submit();
			}
		});
		
		// 댓글 내용 글자수 제한
		$('#rec_content').keyup(function() {
			
	        // 텍스트영역의 길이를 체크
	        var textLength = $(this).val().length;
	         
	        // 제한된 길이보다 입력된 길이가 큰 경우 제한 길이만큼만 자르고 텍스트영역에 넣음
	        if (textLength > 500) {
	        	alert("500자 이하로 입력해주세요!");
	            $(this).val($(this).val().substr(0, 500));
	        }
	    });		
		
	});
</script>
</body>
</html>