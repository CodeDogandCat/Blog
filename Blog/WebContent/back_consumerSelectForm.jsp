<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="com.wy.form.ConsumerForm"/>
<jsp:directive.page import="java.util.List"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link type="text/css" rel="stylesheet" href="CSS/style.css">
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





<%
ConsumerForm consumerForm=(ConsumerForm)request.getAttribute("form");
%>










<body>
<jsp:include page="back_Top.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" background="images/back1.gif">
  <tr>
    <td width="227" valign="top" background="images/back1.gif"><jsp:include page="back_Left.jsp" flush="true" /></td>
    <td width="573" valign="top"><table width="227" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="images/back_noword_03.jpg" width="573" height="25"></td>
      </tr>
    </table>
      <table width="573" border="0" cellpadding="0" cellspacing="0" background="images/back_noword_05.jpg">
        <tr>
          <td valign="top" align="center">		
		  
		  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;用户详细查询</p>");%>
		  
		  
            <table width="325" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
              <tr>
                <td width="93" height="30"><div align="center">账号：</div></td>
                <td width="219" bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getAccount()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">密码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getPassword()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">姓名：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getName()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">性别：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getSex()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">QQ号码：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getQQNumber()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">主页：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getMainPage()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">兴趣爱好：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getInterest()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">电子邮箱：</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><%=consumerForm.getEMail()%></div></td>
              </tr>
            </table><br>
            <a href="#" onClick="javascript:history.go(-1);"><img src="images/back.gif"></a>		  </td>
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
