<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- top -->
	<%@ include file="/common/top.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id="frm" class="form-horizontal" role="form" action="/studentUpdate" method="post" enctype="multipart/form-data">
										
					<div class="form-group">
						<label for="pic" class="col-sm-2 control-label">프로필</label>
						<div class="col-sm-10">
							<img src="/pic?id=${studentVo.id }">
							<input type="file" name="pic">
						</div>
					</div>
					
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">학생 아이디</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.id }</label>
							<input type="hidden" class="form-control" id="id" name="id" value="${studentVo.id }">
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">학생 이름</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name" placeholder="학생 이름" value="${studentVo.name }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="call_cnt" class="col-sm-2 control-label">호출횟수</label>
						<div class="col-sm-10">							
							<label class="control-label">${studentVo.call_cnt }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label id="addr1Label" class="control-label">${studentVo.addr1 }</label>
							<input type="hidden" name="addr1" id="addr1Input" value="${studentVo.addr1 }">
							<button type="button" id="findAddr">주소검색</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소" value="${studentVo.addr2 }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="hidden" name="zipcd" id="zipcdInput" value="${studentVo.zipcd }">
							<label id="zipcdLabel" class="control-label">${studentVo.zipcd }</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="updateBtn" class="btn btn-default">수정</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>
    