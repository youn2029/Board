<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- head.jsp --%>
<%@include file="/common/head.jsp" %>

<body>
	
	<%-- top --%>
	<%@include file="/common/top.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
				
			<%-- left --%>
			<%@include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-12 blog-main">
						<form id="frm" class="form-horizontal" role="form" method="post" action="<%=request.getContextPath() %>/replyInsert" enctype="multipart/form-data">
							<input type="hidden" name="board_no" value="${board_no }"> 
							<input type="hidden" name="post_pno" value="${post_pno }"> 
							<input type="hidden" name="post_group" value="${post_group }"> 
							<h2 class="sub-header">게시판 답글 등록</h2><br>
							
							<div class="form-group">
								<label for="pic" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="post_title" name="post_title" placeholder="제목" required>
								</div>
							</div>
							
							<div class="form-group">
								<label for="id" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									<textarea name="post_content" id="post_content" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
								</div>
							</div>
		
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">첨부파일</label>
								<div id="file" class="col-sm-10">
									<div style="margin:0 0 10px 0" class="form-group">
										<button id="btnPlus" type="button" class="btn btn-default btn-sm">
										  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										</button>
								        <button id="btnMinus" style="margin:0 0 0 5px" type="button" class="btn btn-default btn-sm">
								        	<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
								        </button>    
									</div>
									<ul class="list-unstyled file-list">
										<li><input style="margin-bottom:10px;" type="file" id="file_1" name="uploadFile"></li>
									</ul>
								</div>
							</div>					
		
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" id="savebutton" class="btn btn-default pull-right">등록</button>
								</div>
							</div>							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(function(){
		
		var count = $(".file-list").length;
		
		$("#btnPlus").click(function(){
			
			if(count < 5){
				var tmpHtml = "";
		        tmpHtml += "<li><input style=\"margin-bottom:10px;\" type=\"file\" id=\"file_"+(count+1)+"\" name=\"uploadFile\"></li>";
		 
		        $(".file-list").append(tmpHtml);
		        
		        count++;				
			}
		});
		
		$("#btnMinus").click(function(){			
			if(count > 1){
				$("ul.file-list li:last").remove();
				
				count--;
			}
		});
		
		var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

		$(document).ready(function() {
			// Editor Setting
			nhn.husky.EZCreator.createInIFrame({
				oAppRef : oEditors, // 전역변수 명과 동일해야 함.
				elPlaceHolder : "post_content", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
				sSkinURI : "<%=request.getContextPath() %>/SE2/SmartEditor2Skin.html", // Editor HTML
				fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
				htParams : {
					// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseToolbar : true,
					// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true,
					// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true, 
				}
			});
			
			// 전송버튼 클릭이벤트
			$("#savebutton").click(function(){
				if(confirm("저장하시겠습니까?")) {
					// id가 smarteditor인 textarea에 에디터에서 대입
					oEditors.getById["post_content"].exec("UPDATE_CONTENTS_FIELD", []);

					// 이부분에 에디터 validation 검증
					if(validation()) {
						$("#frm").submit();
					}
				}
			})
			
		});

		// 필수값 Check
		function validation(){
			var contents = $.trim(oEditors[0].getContents());
			if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
				alert("내용을 입력하세요.");
				oEditors.getById['post_content'].exec('FOCUS');
				return false;
			}

			return true;
		}
		
		

	});
</script>
</body>
</html>