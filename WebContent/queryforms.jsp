 
<%@page import="java.util.Currency"%>
<%@page import="org.student.entity.Page"%>
<%@page import="java.util.List"%>
<%@page import="org.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("tr:odd").css("background-color","lightgray");
		})
	</script>
<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body >
	<%
		String error=(String)request.getAttribute("error");
		if(error!=null){
			if(error.equals("addError")){
				out.print("操作失败");
			}else if(error.equals("noaddError")){
				out.print("操作成功");
			}else{
				out.print(error);
			}
		}
	%>
	<form method="post" action="LikeQueryServlet">
		<input type="text" name="sname" id="stname"/><br/>
		<input type="submit" value="查询" /><br/>
	</form>
	<form method="post" action="QueryAllServlet">
		<input type="submit" value="查询全部" /><br/>
	</form>
	<form method="post" action="QueryStudentByPageServlet">
		<input type="submit" value="返回" /><br/>
	</form>
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
		<%
			//获取request域中数据
			List<Student> students=(List<Student>)request.getAttribute("students");
			System.out.println(students);
			for(Student student:students){
		%>
		<tr>
			<td><a href="QueryInfoBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno() %></a></td>
			<td><%=student.getSname() %></td>
			<td><%=student.getSage() %></td>
			<td><%=student.getSaddress() %></td>
			<!-- 将sno通过request方式传入DeleteStudentServlet -->
			<td><a href="DeleteServlet?sno=<%=student.getSno() %> ">删除</a></td>
		</tr>
		
		<%		
			}
		%>
	</table>
	<a href="add.jsp">新增</a><br/>
</body>
</html>