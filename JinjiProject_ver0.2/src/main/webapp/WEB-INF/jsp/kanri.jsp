<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>人事管理</title>
	</head>
	<body>
		<form action="ServletKanriShinkiGakusei" method="post">
			<input type="submit" value="新規学生登録"  />
		</form>
		<form action="ServletKanriGakuseiKensaku" method="post">
			<input type="submit" value="検索"  />
		</form>
		<form action="ServletKanriGakuseiList" method="post">
			<input type="submit" value="学生一覧"  />
		</form>
		<form action="ServletKanriToukei" method="post">
			<input type="submit" value="統計画面"  />
		</form>
		<form action="ServletKanriLogin" method="post">
			<input type="submit" value="管理画面に戻る"  />
		</form>
	</body>
</html>