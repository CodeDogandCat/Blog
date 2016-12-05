<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>
<!--对朋友的查询-->
<%@page import="com.wy.form.FriendForm"%>
<jsp:useBean id="friendDao" scope="page" class="com.wy.dao.FriendDao"></jsp:useBean>
<%
java.util.List friendList=friendDao.queryFriend();
int friendNumber=friendList.size();
if(friendNumber>10){
friendNumber=10;
}
%>
<body>

<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/head_25.jpg" width="800" height="20"></td>
  </tr>
</table>
<table width="800" height="25" border="0" align="center" cellpadding="0" cellspacing="0" background="images/head_26.jpg">
  <tr>
    <td width="44">&nbsp;</td>
    <td width="614">
	
	        <div align="center">
	          <%for(int friendi=0;friendi<friendNumber;friendi++){
        FriendForm friendForm=(FriendForm)friendList.get(friendi);
        %>
              <a href="#" title="<%=friendForm.getQQNumber()%>&nbsp;|&nbsp;<%=friendForm.getDescription()%>"> <%=friendForm.getName()%></a>&nbsp;
              <%}%>
	
	
	
	        </div></td>
    <td width="142">&nbsp;</td>
  </tr>
</table>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/head_27.jpg" width="800" height="63"></td>
  </tr>
</table>








</body>
</html>
