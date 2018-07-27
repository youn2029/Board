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
			
			<div class="col-sm-9 col-sm-offset-3 col-md-6 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판 관리</h2><br>
						<form action="<%=request.getContextPath() %>/boardInsert" method="post">
							<table class="table custom-table">
								<tr>
									<td><label>게시판 이름</label></td>
									<td><input type="text" name="board_name" required></td>
									<td>
										<select name="board_use">
											<option value="y">사용</option>
											<option value="n">미사용</option>
										</select>
									</td>
									<td><button class="btn btn-primary" type="submit">생성</button></td>
								</tr>
							</table>
						</form>
						
						<c:forEach items="${boardList }" var="boardVo">
							<form action="<%=request.getContextPath() %>/boardUpdate" method="post">
								<table class="table custom-table">
									<tr>
										<td><label>게시판 이름</label></td>
										<td><input type="text" id="board_name" name="board_name" value="${boardVo.board_name }" required></td>
										<td>
											<select name="board_use">
												<option value="y" ${boardVo.board_use =='y'?"selected":""}>사용</option>
												<option value="n" ${boardVo.board_use =='n'?"selected":""}>미사용</option>
											</select>
											<input type="hidden" name="board_no" value="${boardVo.board_no }">
										</td>
										<td><button class="btn btn-success" type="submit">수정</button></td>
									</tr>
								</table>
							</form>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>