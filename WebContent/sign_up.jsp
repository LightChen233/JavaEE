<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.account.entity.Account"%>
<!DOCTYPE html>
	<head>
	<script type="text/javascript">
		function reloadCheckImg(){
			//<img src="..."
			$("img").attr("src","img.jsp?t="+(new Date().getTime()));
		}
	</script> 
	<script language="javascript" type="text/javascript">
        function checkInCorrect()      //判断用户名和密码是否为空
        {
            if (document.getElementById('username').value == "") {
                alert('请输入用户名！')
                document.getElementById('username').focus();
                return false
            }
            if (document.getElementById('password').value == "") {
                alert('请输入密码！')
                document.getElementById('password').focus();
                return false
            }
            if(document.getElementById('password').value != document.getElementById('re-password')){
            	alert('两次输入密码不匹配！')
                document.getElementById('re-password').focus();
                return false
            }
            if(document.getElementById('checkcodeId').value == ""){
            	alert('请输入验证码！')
                document.getElementById('checkcodeId').focus();
                return false
            }
            else {
                saveInfo();
                return true;
            }
        }
 
        saveInfo = function () {
            try {
                var isSave = document.getElementById('remember').checked;   //保存按键是否选中
                if (isSave) {
                    var username = document.getElementById('username').value;
                    var password = document.getElementById('password').value;
                    if (username != "" && password != "") {
                        SetCookie(username, password);
                    }
                } else {
                    SetCookie("", "");
                }
            } catch (e) {
 
            }
        }
 
        function SetCookie(username, password) {
            var Then = new Date();
            Then.setTime(Then.getTime() + 1866240000000);
            document.cookie = "username=" + username + "%%" + password + ";expires=" + Then.toGMTString();
        }
 
        function GetCookie() {
            var nmpsd;
            var nm;
            var psd;
            var cookieString = new String(document.cookie);
            var cookieHeader = "username=";
            var beginPosition = cookieString.indexOf(cookieHeader);
            cookieString = cookieString.substring(beginPosition);
            var ends = cookieString.indexOf(";");
            if (ends != -1) {
                cookieString = cookieString.substring(0, ends);
            }
            if (beginPosition > -1) {
                nmpsd = cookieString.substring(cookieHeader.length);
                if (nmpsd != "") {
                    beginPosition = nmpsd.indexOf("%%");
                    nm = nmpsd.substring(0, beginPosition);
                    psd = nmpsd.substring(beginPosition + 2);
                    document.getElementById('username').value = nm;
                    document.getElementById('password').value = psd;
                    if (nm != "" && psd != "") {
                        // document.forms[0].checkbox.checked = true;
                        document.getElementById('remember').checked = true;
                    }
                }
            }
        }
    </script>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>注册</title>
	<script src="js/modernizr-2.6.2.min.js"></script>
	</head>
	<body background="images\hitview.jpg" style=" background-size:cover;">
		<%
			String error=(String)request.getAttribute("error");
			if(error!=null){
				if(error.equals("HasAccount")){
					out.print("<script> alert('该名字已被使用！'); window.location='/HITMenProject/log_sign/sign_up.jsp'; </script>");//
				}else if(error.equals("Error")){
					out.print("<script> alert('未知错误！'); window.location='/HITMenProject/log_sign/sign_up.jsp'; </script>");
				}
			}
		%>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					

					<!-- Start Sign In Form -->
					<form action="/HITMenProject/RegisterServletTest" class="fh5co-form animate-box" data-animate-effect="fadeIn" method="post">
						<h2>注册</h2>
						<div class="form-group">
							<label for="name" class="sr-only">name</label>
							<input type="text" class="form-control" id="name" name="name" placeholder="用户名" autocomplete="on">
						</div>
						<div class="form-group">
							<label for="email" class="sr-only">email</label>
							<input type="email" class="form-control" id="email" name="email" placeholder="邮箱" autocomplete="on">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">password</label>
							<input type="password" class="form-control" id="password" name="password" placeholder="密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="re-password" class="sr-only">re-password</label>
							<input type="password" class="form-control" id="re-password" placeholder="请再次输入密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember" name="remember"> 记住密码</label>
						</div>
						<div class="form-group">
							<input type="text" name="checkcode" id="checkcodeId" size="4" />
							<!-- 验证码  -->
							<a href="javascript:reloadCheckImg();"><img src="img.jsp"/></a>
						</div>
						<div class="form-group">
							<p>已有账号? <a href="login.jsp">登录</a></p>
						</div>
						<div class="form-group">
							<input type="submit" value="提交" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->

				</div>
			</div>
		</div>
	</body>
</html>

