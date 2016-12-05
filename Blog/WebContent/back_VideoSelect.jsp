<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="com.wy.form.VideoForm"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></meta>
<link type="text/css" rel="stylesheet" href="CSS/style.css"></link>
<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
<title>LemonBlog-后台管理</title>

<style type="text/css">
<!--
body {
	background-color: #F0F0F0;
}
.style1 {
	color: #FF0000;
	font-weight: bold;
}
.style2 {
	color: #a54400;
	font-weight: bold;
}
-->
</style>
</head>

<jsp:useBean id="pagination" class="com.wy.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="videoDao" class="com.wy.dao.VideoDao" scope="session"></jsp:useBean>

<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=videoDao.queryVideo();
	int pagesize=4;      //指定每页显示的记录数
	list=pagination.getInitPage(list,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //获取指定页的数据
}
%>



<body onselectstart="return false">
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
		  
		  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;影音查询</p>");%>
     
          <table width="455" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"  bgcolor="#FEce62">
            <%for(int i=0;i<list.size();i++){
 VideoForm videoForm=(VideoForm)list.get(i);
if(i % 2 ==0 ){
%>
            <tr bgcolor="#FFFFFF">
              <td width="230"><div align="center">
                <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="150"><div align="center">
             <video src="<%=videoForm.getVideoAddress()%>" width="160" height="140" controls="controls" autobuffer></video>
               
               
              </div></td>
                    </tr>
                    <tr>
                      <td height="20"><div align="center"><%=videoForm.getVideoDescription()%></div></td>
                    </tr>
                    <tr>
                      <td height="20"><div align="center"><a href="VideoServlet?method=1&id=<%=videoForm.getId()%>">删除</a></div></td>
                    </tr>
                    <tr>
                      <td height="20"><div align="center"><a href="back_VideoRestoreSelect.jsp?id=<%=videoForm.getId()%>">管理评论</a></div></td>
                    </tr>
                              </table>
              </div></td>
              
              <%}else{%>
              <td width="212"><div align="center">
                <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                     <td height="150"><div align="center">
               
           <video src="<%=videoForm.getVideoAddress()%>" width="160" height="140" controls="controls" autobuffer></video>
               
               
               </div></td>
               </tr>
                  <tr>
                    <td height="20"><div align="center"><%=videoForm.getVideoDescription()%></div></td>
                  </tr>
                  <tr>
                    <td height="20"><div align="center"><a href="VideoServlet?method=1&id=<%=videoForm.getId()%>">删除</a></div></td>
                  </tr>
                  
                  <tr>
                      <td height="20"><div align="center"><a href="back_VideoRestoreSelect.jsp?id=<%=videoForm.getId()%>">管理评论</a></div></td>
                    </tr>
                </table>
                </div>                </td>
            </tr>
            <%}
					}%>
            <%if(list.size()%2 ==1){%>
  <td bgcolor="#FFFFFF"><div align="center">
    <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="150"><div align="center"></div></td>
      </tr>
      <tr>
        <td height="20"><div align="center"></div></td>
      </tr>
      <tr>
        <td height="20"><div align="center"></div></td>
      </tr>
    </table>
    </div></td>

  <%}%> 
   </tr>
          </table>
          <%=pagination.printCtrl(Page) %>
          
          
          
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






<div id="User" style="position:absolute;width:240px; height:139px;display:none;">
<table width="606" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td width="606" height="426"><img src="<%=request.getParameter("image")%>"></td>
  </tr>
  <tr>
    <td height="29" align="center">
	   <input name="Submit2" type="button" class="btn_grey" value="关闭" onClick="javascript:User.style.display='none';">
	
	
	</td>
  </tr>
</table>

</div>


</body>
</html>
