<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>
<%@page import="com.wy.form.ConsumerForm"%>

<%
ConsumerForm consumerFormPT=(ConsumerForm)session.getAttribute("form");
%>


<body>



		<%if(consumerFormPT.getManageLevel().equals("普通")){%>


		
		  <table width="366" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#F1BD36">
          <tr bgcolor="#FFFFFF">
            <td width="171" height="20">用户名：<%=consumerFormPT.getAccount()%></td>
            <td width="195" height="20">姓名：<%=consumerFormPT.getName()%></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td height="20">性别：<%=consumerFormPT.getSex()%></td>
            <td height="20">QQ：<%=consumerFormPT.getQQNumber()%></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td height="20">主页：<%=consumerFormPT.getMainPage()%></td>
            <td height="20">兴趣：<%=consumerFormPT.getInterest()%></td>
          </tr>
		      <tr bgcolor="#FFFFFF">
            <td height="20">邮箱：<%=consumerFormPT.getEMail()%></td>
            <td height="20" bgcolor="#F1BD36"><a href="head_consumerUpdate.jsp">更改用户信息</a></td>
	        </tr>
          </table>
	<%} %>


</body>
</html>
