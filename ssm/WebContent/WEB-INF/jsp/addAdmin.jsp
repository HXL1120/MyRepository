<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员添加</title>
    <script type="text/javascript">
	    function checkForm()
	    {
	    	var name = document.getElementById("name").value;
	    	var pwd = document.getElementById("pwd").value;
	    	//alert(sname);
	    	if(name == "")
	    	{
	        	alert("请输入姓名!");
	        	return false;
	        }
	    	if(pwd == "")
	    	{
	        	alert("请输入密码!");
	        	return false;
	        }
	    }
    </script>
  </head>
  <body>
  	<center>
	   		<h1>管理员添加</h1>
	   		<form action="${pageContext.request.contextPath }/insertAdmin.do" method="post" onsubmit="return checkForm()">
	   			<table width="300">
	   				<tr>
	   					<td>登录名:</td>
	   					<td>
	   						<input name="name" id="name"/>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
	   					<td>
	   						<input type="password" id="pwd" name="pwd" size="22"/>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>状&nbsp;&nbsp;&nbsp;&nbsp;态:</td>
	   					<td>
	   						<select name="state">
	   							<option value="1">普通</option>
								<option value="-1">超级</option>
								<option value="0">冻结</option>
							</select>
	   					</td>
	   				</tr>
	   				<tr align="center">
	   					<td colspan="2">
	   						<input type="submit" value="添  加"/>
	   					</td>
	   				</tr>
	   			</table>
	   		</form>
	   		<h2><a href="${pageContext.request.contextPath }/selectAll.do">返回主页</a></h2>
   	</center>
  </body>
</html>
