<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Controller.TopServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="Mock/CSS/Top.css">
<title>掲示板TOP</title>
</head>
<body style="background: url(img/b120.jpg);">

	<div class="logout">
		<c:if test="${userInfo.loginId == null}">
			<a class="logout2" href="LoginServlet">ログイン</a>
		</c:if>
		<c:if test="${userInfo.loginId != null}">
			<h6>${userInfo.name}さん<a class="logout2" href="LogoutServlet">ログアウト</a></h6>
		</c:if>
	</div>

	<!-- <h3 class=a>TOP</h3> -->
	<div class="a">
		<a href="TopServlet">Top</a>
	</div>

	<div class="right">
		<c:if test="${userInfo.loginId != null}">
		<a href="writeServlet">新しいスレッド作成</a>
		</c:if>
	</div>

	<div class="right">
		<c:if test="${userInfo.loginId == 'admin'}">
			<a href="UserListServlet">ユーザ一覧</a>
		</c:if>
	</div>

	<div class="table-area">
		<table class="table sampleTable">
			<thead class="thead-dark">
				<tr>
					<th scope="col">更新日</th>
					<th scope="col">記事</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="thread" items="${threadList}">
					<tr>
						<th scope="row">${thread.createDate}</th>
						<td><a href="bordServlet?id=${thread.id}">${thread.tittle}</a></td>
					</tr>
				</c:forEach>

				<tr>
					<th scope="row">2018-09-20</th>
					<td><a href="bordServlet">vtuber</a></td>
				</tr>
			</tbody>

		</table>
	</div>

</body>
</html>