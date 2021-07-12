<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="bean.Gakusei" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>人事学生一覧</title>
				<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<style>
			body {
				  background: #80bfff; /* fallback for old browsers */
				  background: -webkit-linear-gradient(right, #80bfff, #8DC26F);
				  background: -moz-linear-gradient(right, #80bfff, #8DC26F);
				  background: -o-linear-gradient(right, #80bfff, #8DC26F);
				  background: linear-gradient(to left, #80bfff, #8DC26F);
				  font-family: "Roboto", sans-serif;
				  -webkit-font-smoothing: antialiased;
				  -moz-osx-font-smoothing: grayscale;      
			}
			h2 {
				font-size: 20px;
				color: yellow;
			}	
			form {
				color: lime;
			}
			td, th {
				word-wrap: break-word;
				max-width: 150px;
			}
			.ss {
				width: 250px;
				valign="middle";
				align="center";
			}
			img {
				width:100%;
			}
		</style>
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
		<form action="ServletKanriLogin" method="post">
			<input type="submit" value="管理画面に戻る"  />
		</form>
		<script>
			$(document).ready(function(){
	  		  $('#myTable').dataTable();
			});
		</script>
	</body>
</html>