<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
<script src="http://html5media.googlecode.com/svn/trunk/src/html5media.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title>无标题文档</title>
</head>

<body>
<table width="422" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="318">
    	
    	<object id="1">
               		<embed src="<%=request.getParameter("video")%>" width="1366" height="768" type=audio/mpeg loop="false" 

						autostart="true"  type="application/x-shockwave-flash"><param name="allowfullscreen" value="true"> 
						<param name="wmode" value="transparent">
       		   </object>
    	
    	
    	</td>
  </tr>
</table>
</body>
</html>
