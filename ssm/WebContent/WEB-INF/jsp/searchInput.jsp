<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>入库查询</title>
    <script type="text/javascript" src="js/date.js"></script>
    <script type="text/javascript">
    	
    	function checkForm()
    	{
    		var startTime = document.getElementById("startTime").value;
        	var endTime = document.getElementById("endTime").value;
        	var annt = document.getElementById("annt").value;
        	var name = document.getElementById("name").value;
        	var pname=document.getElementById("pname").value;
        	if(startTime=="" && endTime=="" && annt == "" && name=="" && pname=="0")
        	{
            	alert("请选择一种查询条件!");
            	return false;
            }
        	else if((startTime!=""&&endTime=="") || (startTime==""&&endTime!=""))
        	{
        		alert("请选择起始和结束日期!");
            	return false;
            }
        	else
        	{
            	return true;
            }
        }
        function groupByPro()
        {
        	var startTime = document.getElementById("startTime").value;
        	var endTime = document.getElementById("endTime").value;
        	var annt = document.getElementById("annt").value;
        	var name = document.getElementById("name").value;
        	var pname=document.getElementById("pname").value;
        	if((annt != "" || name != "" || pname != 0))
        	{
            	alert("目前只支持日期范围条件分组");
            }
        	else if((startTime!=""&&endTime!=""))
        	{
        		document.forms[0].action="SearchInputGroupByServlet";
                document.forms[0].submit();
        		
            }
        	else
        	{
        		alert("请选择起始和结束日期!");
            }
        }
    </script>
  </head>
  <body>
   		<center>
   		<h1>入库记录</h1>
   		<h3><a href="${pageContext.request.contextPath}/selectAll.do">返回主页</a></h3>
   			<form action="SearchInputByKeywordServlet" method="post" onsubmit="return checkForm()">
   			<table width="900" cellspacing="0" border="1">
   				<tr>
   				<td colspan="7">
	   				产品名称：<input id="name" name="name" size="10"/>
	   				起始日期：<input name="startTime" id="startTime" onclick='popUpCalendar(this,this,"yyyy-mm-dd")' readonly
	   				size="8"/>
	   				&nbsp;&nbsp;&nbsp;
	   				结束日期：<input name="endTime" id="endTime" onclick='popUpCalendar(this,this,"yyyy-mm-dd")' readonly
	   				size="8"/>
	   				&nbsp;&nbsp;&nbsp;
	   				经办人：<input id="annt" name="annt" size="6"/>
	   				供应商：
	   				<select name="pname">
	   					<option value="0">--请选择--</option>
						<c:forEach items="${proList}" var="plist">
							<option value="${plist.pname}">${plist.pname}</option>
						</c:forEach>		
	   				</select>
   				</td>
   				</tr>
   				<tr align="center">
   				<td colspan="7">
	   				<input type="submit" value="搜     索"/>
	   				<input type="button" value="按名称分组查询" onclick="groupByPro()"/>
   				</td>
   				</tr>
   			
   				<tr bgcolor="#CCCCCC">
   					<td width="200">产品名称</td>
   					<td>数量</td>
   					<td>单价</td>
   					<td>总价</td>
   					<td>经办人</td>
   					<td>供应商</td>
   					<td>入库时间</td>
   				</tr>
   				<c:forEach items="${ilist}" var="pl">
	   				<tr>
	   					<td>${pl.name}</td>
	   					<td>${pl.pcount}</td>
	   					<td>${pl.dprice}</td>
	   					<td>${pl.price}</td>
	   					<td>${pl.annt}</td>
	   					<td>${pl.pname}</td>
	   					<td><fmt:formatDate value="${pl.inputtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	   				</tr>
   				</c:forEach>
   				
   			</table>
   		</form>
   			<jsp:include page="page_list.jsp"/>
   		</center>
  </body>
</html>
