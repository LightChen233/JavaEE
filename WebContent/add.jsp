<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
	<script type="text/javascript">
		function check(){//true:表单正常提交，false终止提交
			var sno=$("#stno").val();
			var sname=$("#stname").val();
			var sage=$("#stage").val();
			var saddress=$("#staddress").val();
			if(sno.length!=5){
				alert("学号为5位数，请重新输入");
				return false;
			}
			if(!(sname.length >1 & sname.length <10)){
				alert("姓名长度有误！")
				return false;
			}
			return true;
		}
	
		$(document).ready(function(){
			
		})
	</script>

<title>Insert title here</title>
</head>
<body>
	<form action="AddServlet" method="post" onsubmit="return check()">
		学号：<input type="text" name="sno" id="stno"/><br/>
		姓名：<input type="text" name="sname" id="stname"/><br/>
		年龄：<input type="text" name="sage" id="stage"/><br/>
		地址：<input type="text" name="saddress" id="staddress"/><br/>
		<input type="submit" name="新增" /><br/>
	</form>
</body>
</html>