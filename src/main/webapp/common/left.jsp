<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li><a href="<%=request.getContextPath() %>/boardList">게시판 생성</a></li>
		
		<c:forEach items="${usableBoardList }" var="boardVo">
			<li><a href="<%=request.getContextPath() %>/postList?board_no=${boardVo.board_no }">${boardVo.board_name }</a></li>
		</c:forEach>
		
	</ul>
</div>