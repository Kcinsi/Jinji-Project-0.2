<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="bean.Gakusei" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>人事検索結果</title>
	</head>
	<body>
		<% List<Gakusei> gakusei_list = (List<Gakusei>) session.getAttribute("gakusei_list"); %>
		<table id="myTable" class="table table-striped" > 
			<thead>
				<tr>
					<td>ID</td>
					<td>名前</td>
				</tr>
			</thead>
			<tbody>
			<% for(int i=0; i<gakusei_list.size(); i++) { 
				Gakusei gakusei = gakusei_list.get(i); 
			%>
				<tr>
					<td><% out.println(gakusei.getID()); %></td>
					<td><% out.println(gakusei.getName()); %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<form action="ServletKanriGakuseiKensaku" method="post">
			<input type="submit" value="検索画面に戻る"  />
		</form>
		<form action="ServletKanriLogin" method="post">
			<input type="submit" value="管理画面に戻る"  />
		</form>
	</body>
</html>