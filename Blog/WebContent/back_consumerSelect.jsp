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



<jsp:useBean id="pagination" class="com.wy.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="consumerDao" class="com.wy.dao.ConsumerDao" scope="session"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=consumerDao.getConsumerList("普通");
	int pagesize=15;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>




<script type="text/javascript">
function deleteForm(account){
if(confirm("确定要删除此用户信息吗？")){
window.location.href="ConsumerServlet?method=3&account="+account;
}
}
</script>

<body>
<jsp:include page="back_Top.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="227" valign="top" background="images/back1.gif"><jsp:include page="back_Left.jsp" flush="true" /></td>
    <td valign="top" background="images/back1.gif"><table width="227" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="images/back_noword_03.jpg" width="573" height="25"></td>
      </tr>
    </table>
      <table width="573" border="0" cellpadding="0" cellspacing="0" background="images/back_noword_05.jpg">
        <tr>
          <td valign="top">
		
          
              <%
if(pagination.getRecordSize()<=0){
	out.println("<p align=center><img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;没有用户进行注册！</p>");
}else{



 out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;用户注册查询</p>");
%>
		  
            <table width="524" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FDD05D">
            <tr align="center" bgcolor="#FECE62">
              <td width="91" height="20">用户名</td>
              <td width="74">姓名</td>
              <td width="65">性别</td>
              <td width="134">QQ号码</td>
              <td width="132">操作</td>
            </tr>
     <%for(int i=0;i<list.size();i++){ 
     ConsumerForm consumerForm=(ConsumerForm)list.get(i);
     %> 
            <tr align="center" bgcolor="#FFFFFF">
              <td height="25"><%=consumerForm.getAccount()%></td>
              <td><%=consumerForm.getName()%></td>
              <td><%=consumerForm.getSex()%></td>
              <td><%=consumerForm.getQQNumber()%></td>
              <td><a href="ConsumerServlet?method=2&account=<%=consumerForm.getAccount()%>">查询</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:deleteForm('<%=consumerForm.getAccount()%>')">删除</a></td>
            </tr>
      <%} %>
          </table>
	<!-- 显示分页导航栏 -->
<%=pagination.printCtrl(Page) %>
<%} %>	</td>
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
