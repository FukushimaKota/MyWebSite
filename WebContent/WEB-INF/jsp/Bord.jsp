<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Controller.bordServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="Mock/CSS/bord.css">
<title>投稿された名前</title>
</head>
<body class="table-area" style="background: url(img/b120.jpg);">
	<div class="a">
		<a href="TopServlet">Top</a>
	</div>

<%-- 	<c:if test="${userInfo.id == thread.userId}"> --%>
		<div class="delete">
			<a href="bordDeleteServlet?id=${thread.id}">削除</a>
		</div>
<%-- 	</c:if> --%>

	<h3 class="tittle">${thread.tittle}</h3>

	<p>投稿日:${thread.createDate}</p>
	<p>投稿者:${user.name}</p>
	<p>${thread.text}</p>
	<p></p>
	<p></p>

	<c:if test="${userInfo.loginId != null}">
		<form action="bordServlet" method="post">

			<input type="hidden" value="${userInfo.id}" name="id"> <input
				type="hidden" value="${thread.id}" name="id2">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">コメント</span>
				</div>
				<textarea name="comment" class="form-control"
					aria-label="With textarea"></textarea>
				<button class="button" type="submit">投稿</button>
			</div>
		</form>
	</c:if>

	<!-- 繰り返し -->

	<p class="space">コメント欄</p>
	<table class="table">
				<thead>
				<tr>
					<th>名前</th>
					<th>コメント</th>
				</tr>
			</thead>

	<c:forEach var="commentList" items="${commentList}">
			<thead>
				<tr>
					<th>${user.name}</th>
					<th>${commentList.comment}</th>
				</tr>
			</thead>
	</c:forEach>
	</table>
	<!--
 <table class="table">
  <thead>
      <tr>
   	  <th>bikakinn</th>
      <th>ほう</th>
    </tr>
      <tr>
   	  <th>zyuukakinn</th>
      <th>ゲーム部とかは？結構面白いよ。</th>
    </tr>
    <tr>
   	  <th>bikakinn</th>
      <th>最近のvtuberでいい人おらん？</th>
    </tr>
  </thead>
  </table> -->

	<a href=TopServlet>Topに戻る</a>
</body>
</html>
