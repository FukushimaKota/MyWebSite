<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="Mock/CSS/borddelete.css">
<title>削除</title>
</head>
<body style="background: url(img/b120.jpg);">
<div class="a">
<a href="TopServlet">Top</a>
</div>
<p class="aa">本当に削除しますか？</p>

<form action="bordDeleteServlet"method="post">
<div class="button">
<input type="hidden" value="${thread.id}" name=id>
<input class=a type="submit" name="cancellation" value="キャンセル">
<input class=b type="submit" name="OK" value="OK">
</div>
</form>
</body>
</html>