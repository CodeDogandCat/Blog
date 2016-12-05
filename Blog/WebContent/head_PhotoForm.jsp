<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="com.wy.form.PhotoForm"/>
<jsp:directive.page import="com.wy.form.RestoreForm"/>
<jsp:directive.page import="com.wy.form.ConsumerForm"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" type="text/css"  rel="stylesheet">
<title>前台-相册详细查询</title>
<%@ page language="java" import="java.util.*" %>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_01.gif);
}
-->
</style></head>
<jsp:useBean id="pagination" class="com.wy.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="consumerDao" class="com.wy.dao.ConsumerDao" scope="request"></jsp:useBean>
<jsp:useBean id="photoRestoreDao" class="com.wy.dao.PhotoRestoreDao" scope="session"></jsp:useBean>
<jsp:useBean id="photoDao" class="com.wy.dao.PhotoDao" scope="request"></jsp:useBean>
<%
ConsumerForm consumerForm=(ConsumerForm)session.getAttribute("form");
String id=request.getParameter("id");


PhotoForm photoForm=photoDao.queryPhoto(Integer.valueOf(id));

String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=photoRestoreDao.queryRestore(photoForm.getId());
	int pagesize=3;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>
<body>
<!--网页头部分-->
<jsp:include page="head_top.jsp" flush="true" />

<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="74"><img src="images/head_06.jpg" width="74" height="846"></td>
    <td valign="top" background="images/head_07.jpg" width="407" height="846">



	
	   <table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="150"><div align="center"><img src="<%=photoForm.getPhotoAddress()%>" width="500" height="400"></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><%=photoForm.getPhotoDescription()%></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><%=photoForm.getPhtoTime()%></div></td>
              </tr>
     
            </table>
	  
	  
	  
	  
	  <%	  if(pagination.getRecordSize()>0){
for(int i=0;i<list.size();i++){
RestoreForm restoreForm=(RestoreForm)list.get(i);
 %>
	  <table width="500"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#fece62">
        <tr>
          <td width="100" bgcolor="#FFFFFF">题目：</td>
          <td width="400" bgcolor="#FFFFFF"><%=restoreForm.getReTitle() %></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF">内容：</td>
          <td bgcolor="#FFFFFF"><%=restoreForm.getReContent() %></td>
        </tr>
        <tr>
          <td colspan="2" bgcolor="#FFFFFF"><div align="right">回复人：<%=consumerDao.getConsumerForm(Integer.valueOf(restoreForm.getReAccount()))%></div></td>
        </tr>
      </table>
	  <%} 
	  

	  out.print(pagination.printCtrl(Page,id));}%>
	  
	  
	  
	  
	  
	  
	   <form name="form" method="post" action="PhotoSerlvet?method=2"  onSubmit="return addRestore()">
	  <table width="500"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
        <tr>
          <td width="100" bgcolor="#FFFFFF">回复主题：
         </td>
          <td  bgcolor="#FFFFFF"><input name="reTitle" type="text" class="inputinput" size="64"></td>
        </tr>
        <tr>
          <td height="100" bgcolor="#FFFFFF">回复内容：</td>
          <td bgcolor="#FFFFFF"><textarea name="reContent" rows="10" cols="60" class="inputinput"></textarea></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF">回&nbsp;复&nbsp;人：</td>
          <td bgcolor="#FFFFFF"><input name="articleId" type="hidden" size="26" value="<%=photoForm.getId()%>"><input name="accountId" type="hidden" size="26" value="<%=consumerForm.getId()%>"><%=consumerForm.getName()%></td>
        </tr>
      </table>
	   <table width="284"  border="0" align="center">
         <tr>
           <td>
             <div align="center">
  <input type="image" class="inputinputinput" src="images/save.gif">
&nbsp;&nbsp;
   <a href="#" onClick="javascript:form.reset()"><img src="images/reset.gif"></a></div></td>
         </tr>
       </table>
	   </form>


  </td>
    <td width="10"><img src="images/head_08.jpg" width="13" height="846"></td>
    <td width="184" valign="top"><jsp:include page="head_right.jsp" flush="true" />
	  
	  
	  
    </td>
    <td width="122"><img src="images/head_10.jpg" width="122" height="846"></td>
  </tr>
</table>
<!--网页尾部分-->
<jsp:include page="head_down.jsp" flush="true" />




</body>
</html>
