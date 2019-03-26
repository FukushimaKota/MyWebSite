<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="Mock/CSS/Top.css">
<title>掲示板TOP</title>
</head>
<body style="background: url(img/b120.jpg);">

<div class="logout">
	<c:if test="${userInfo.loginId != null}">
<h6>${userInfo.name}さん<a class="logout2" href="LoginServlet">ログイン</a></h6>
	</c:if>
</div>

<!-- <h3 class=a>TOP</h3> -->
<div class="a">
<a href="TopServlet">Top</a>
</div>

<div class="right">
<a href="writeServlet">新しいスレッド作成</a>
</div>

<div class="right">
<a href="UserListServlet">ユーザ一覧</a>
</div>

<div class="table-area">
	<table class="table sampleTable">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">更新日</th>
	      <th scope="col">記事</th>
	      <th> </th>
	    </tr>
	  </thead>

	<!--   <c:forEach></c:forEach> -->

	  <tbody>
	      <tr>
	      <th scope="row">2018-09-20</th>
	      <td ><a href="bordServlet">vtuber</a></td>
	    </tr>
	    <tr>
	      <th scope="row">2018-09-14</th>
	      <td><a href="">悲報、このマンガがすごい!本家に訴えられたった。</a></td>
	    </tr>
	    <tr>
	      <th scope="row">2018-09-12</th>
	      <td><a href="bord1.html">(勝手に)この漫画がすごい、2019年予想</a></td>
	    </tr>
	    <tr>
	      <th scope="row">2018-08-29</th>
	      <td><a href="bord1.html">ドロップダウンメニューを一連のボタンと混在させる場合</a></td>
	    </tr>
	  </tbody>
	</table>
</div>

</body>
</html>