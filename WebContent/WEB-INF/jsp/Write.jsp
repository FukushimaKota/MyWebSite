<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="Mock/CSS/write.css">
<title>新しい投稿</title>
</head>
<body style="background: url(img/b120.jpg);">

<div class="logout">
<a class="logout2" href="LogoutServlet">ログアウト</a>
</div>

<div class="a">
<a href="TopServlet">Top</a>
</div>

<p></p>
<div class="input-group mb-3 table-area">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">タイトル</span>
  </div>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group table-area aaa">
  <div class="input-group-prepend">
    <span class="input-group-text">本文</span>
  </div>
  <textarea class="form-control" aria-label="With textarea"></textarea>
</div>

<div class="center">
<button type="button" class="btn btn-info">ツイート</button>
</div>

<p></p>
<a></a>
<div class="return">
<a href="TopServlet">Topに戻る</a>
</div>
</body>
</html>