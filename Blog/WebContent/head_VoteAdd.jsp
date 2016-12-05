<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="com.wy.form.VoteForm"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" type="text/css"  rel="stylesheet">
<title>前台-留言板</title>
<%@ page language="java" import="java.util.*" %>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_01.gif);
}
.style1 {
	color: #663403;
	font-weight: bold;
}
.style2 {color: #663403}
.style3 {color: #9a6400}
.style4 {
	color: #cc7800;
	font-size: 10pt;
}
.style5 {color: #663401}
-->
</style></head>
<jsp:useBean id="voteDao" class="com.wy.dao.VoteDao" scope="page"></jsp:useBean>
<jsp:useBean id="countTime" scope="page" class="com.wy.tool.CountTime"></jsp:useBean>
<body>
<!--网页头部分-->
<jsp:include page="head_top.jsp" flush="true" />
<%@page import="com.wy.form.ConsumerForm"%>

<%
ConsumerForm consumerFormPT=(ConsumerForm)session.getAttribute("form");
%>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="74"><img src="images/head_06.jpg" width="74" height="846"></td>
    <td height="846" valign="top" background="images/head_07.jpg" width="407">

		<%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;用户进行留言</p>");%><br>
		<form name="form" method="post" action="VoteServlet?method=0" onSubmit="return voteAdd()">
        <table width="380" height="28" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="2">&nbsp;</td>
           
                <tr bgcolor="#FECE62">
	                <td width="80"><div align="center">留言人</div></td>
	                <td align="center">
							<input name="voteName" type="text" class="inputinput"   value="<%=consumerFormPT.getAccount()%>" size="30"
														readonly="readonly" onclick="alert('此文本框已设为只读，用户不能修改')">
					</td>
                </tr>
                <tr bgcolor="#FECE62">
	                <td width="80"><div align="center">留言时间</div></td>
	                <td align="center">
							<input name="voteTime" type="text" class="inputinput"  value="<%=countTime.currentlyTime()%>" size="30"
														readonly="readonly" onclick="alert('此文本框已设为只读，用户不能修改')">
					</td>
                </tr>
                <tr bgcolor="#FECE62">
                	<td width="80"><div align="center">留言内容</div></td>
                	<td align="center">
                		<textarea name="voteContent"  cols="28" rows="20" class="inputinput"></textarea>
					</td>
               </tr>
          <% %>
        </table><br>		
          <div align="center">
              <input type="image" class="inputinputinput" src="images/vote.gif" width="51" height="20">
&nbsp;&nbsp;
   <a href="#" onClick="javascript:form.reset()"><img src="images/reset.gif"></a>
          </div>
		        </form>	        
		        <% %>
	        
				</td>
    <td width="10"><img src="images/head_08.jpg" width="13" height="846"></td>
    <td width="184" valign="top">

	  	<jsp:include page="head_right.jsp" flush="true" />
  
    </td>
    <td width="122"><img src="images/head_10.jpg" width="122" height="846"></td>
  </tr>
</table>
<!--网页尾部分-->
<jsp:include page="head_down.jsp" flush="true" />




</body>
</html>
