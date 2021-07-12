<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>人事検索</title>
	</head>
	<body>
		<form action="ServletKanriKensakuUpdate" method="post">
			<select name="type">
				<option value="ID">ID</option>
				<option value="Name">名前</option>
			</select>
			<input type="text" name="keyword" required />
			<input type="submit" value="検索"  />
		</form>
		<form action="ServletKanriLogin" method="post">
			<input type="submit" value="管理画面に戻る"  />
		</form>
	</body>
</html>