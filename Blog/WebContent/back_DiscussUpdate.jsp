<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="com.wy.form.DiscussForm"/>
<jsp:directive.page import="java.util.List"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
<title>LemonBlog-后台管理</title>
<style type="text/css">
<!--
.style1 {color: #FFCD00}
.style2 {
	color: #a54400;
	font-weight: bold;
}
body {
	background-color: #F0F0F0;
}
.style4 {color: #666666}
-->
</style>
</head>
<jsp:useBean id="countTime" scope="page" class="com.wy.tool.CountTime"></jsp:useBean>
<jsp:useBean id="discussDao" class="com.wy.dao.DiscussDao" scope="session"></jsp:useBean>
<%
DiscussForm form=discussDao.queryDiscuss(Integer.valueOf(request.getParameter("id")));
%>

<body>
<jsp:include page="back_Top.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" background="images/back1.gif">
  <tr>
    <td width="227" valign="top"><jsp:include page="back_Left.jsp" flush="true" /></td>
    <td width="573" valign="top"><table width="227" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="images/back_noword_03.jpg" width="573" height="25"></td>
      </tr>
    </table>
      <table width="573" border="0" cellpadding="0" cellspacing="0" background="images/back_noword_05.jpg">
        <tr>
          <td valign="top" align="center">		
		  
		  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;推荐添加</p>");%>
		  <form name="form" method="post" action="DiscussServlet?method=2&id=<%=form.getId()%>" onSubmit="return addDiscuss()">
		  
            <table width="340" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
              <tr>
                <td width="77" height="30"><div align="center">推荐主题：</div></td>
                <td width="250" bgcolor="#FFFFFF"><div align="center">
                  <input name="discussTitle" type="text" class="inputinput" size="30" value="<%=form.getDiscussTitle()%>">
                </div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">推荐内容：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
                  <textarea name="discussContent" cols="28" rows="20" class="inputinput"><%=form.getDiscussContent()%></textarea>
</div></td>
              </tr>
			               <tr>
                <td height="30"><div align="center">发布时间：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
                  <input name="discussTime" type="text" class="inputinput" value="<%=form.getDiscussTime()%>" size="30" readonly="readonly" onclick="alert('此文本框已设为只读，用户不能修改')">
                 </div></td>
              </tr>
			  
			  
            </table>
            <br>
 <input type="image" class="inputinputinput" src="images/save.gif">
&nbsp;&nbsp;
 <a href="#" onClick="javascript:form.reset()"><img src="images/reset.gif"></a>
            </form>
			
			</td>
        </tr>
      </table>
      <table width="227" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/back_noword_18.jpg" width="573" height="21"></td>
        </tr>
      </table></td>
  </tr>
</table>
<jsp:include page="back_Down.jsp" flush="true" />
</body>
</html>
