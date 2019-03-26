<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="Mock/CSS/login.css">
<title>ログイン</title>
</head>
<body class="body" style="background: url(img/b120.jpg);">

	<div class="z">
		<a href="TopServlet">Top</a>
	</div>

	<c:if test="${errMsg != null}">
		<div class="error" role="alert">${errMsg}</div>
	</c:if>

	<form action="LoginServlet" method="post">
		<div class="login-area">
			ログインID<input class="input a" type="text" name="loginId" required="required"><br>
			<p>
			<p>
				パスワード<input class="input" type="password" name="password" required="required"><br>
			<p>
			<p>
			<p>
				<button class="login" type="submit">ログイン</button>
			</p>
			<!-- 	<a href="userlist1.html"><input class="login" type="submit" value="ログイン"></a> -->
		</div>

		<div class="new">
			<a href="NewUserServlet">新規登録</a>
		</div>
		<p class="text">初めて使う方は↑こちらから</p>

	</form>
</body>
</html>



<%-- <title>ログイン</title>
</head>
<body>
	<form action="LoginServlet"method="post">

<div class=title>
	<h1>ログイン画面</h1>
</div>

<c:if test="${errMsg != null}" >
	    <div class="error"role="alert">
		  ${errMsg}
		</div>
	</c:if>

	<div class="login-area">

	<p><input type="text" name="loginId" id="inputLoginId" class="input" placeholder="ログインID" required></p>
    <p><input type="password" name="password" id="inputPassword" class="input" placeholder="パスワード" required></p>
    <p><button class="login" type="submit">ログイン</button></p>

	</div>

	</form>
	</body>
	</html> --%>