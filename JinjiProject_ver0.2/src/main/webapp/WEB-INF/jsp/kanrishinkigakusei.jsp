<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規学生登録</title>
	</head>
	<body>
		<a>Asteriaを実行する。</a>
		<form action="ServletKanriShinkiGakuseiUpdate" method="post">
			<input type="text" name="ID" placeholder="ID" required>
			<input type="text" name="Name" placeholder="名前" required>
			<input type="submit" value="新規学生登録"  />
		</form>
		<form action="ServletKanriLogin" method="post">
			<input type="submit" value="管理画面に戻る"  />
		</form>
	</body>
</html>