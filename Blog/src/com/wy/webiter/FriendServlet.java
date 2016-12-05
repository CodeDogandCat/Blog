/*     */package com.wy.webiter;

/*     */
/*     *//*     */import java.io.IOException;
/*     */
import java.io.PrintWriter;

/*     */
import javax.servlet.RequestDispatcher;
/*     */
import javax.servlet.ServletException;
/*     */
import javax.servlet.http.HttpServlet;
/*     */
import javax.servlet.http.HttpServletRequest;
/*     */
import javax.servlet.http.HttpServletResponse;

import com.wy.dao.FriendDao;
/*     */
import com.wy.form.FriendForm;
/*     */
import com.wy.tool.Chinese;

/*     */
/*     */
/*     */
/*     */public class FriendServlet
/*     */extends HttpServlet
/*     */{
	/* 19 */private FriendDao friendDao = null;
	/*     */private int method;

	/*     */
	/*     */public FriendServlet() {
	}

	/*     */
	/*     */@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 25 */method = Integer.parseInt(request.getParameter("method"));
		/* 26 */if (method == 0) {
			/* 27 */addFriend(request, response);
			/*     */}
		/* 29 */if (method == 1) {
			/* 30 */deleteFriend(request, response);
			/*     */}
		/* 32 */if (method == 2) {
			/* 33 */queryFriendForm(request, response);
			/*     */}
		/* 35 */if (method == 3) {
			/* 36 */updateFriend(request, response);
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void updateFriend(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 44 */response.setContentType("text/html;charset=GBK");
		/* 45 */PrintWriter out = response.getWriter();
		/* 46 */friendDao = new FriendDao();
		/* 47 */FriendForm friendForm = new FriendForm();
		/* 48 */friendForm.setId(Integer.valueOf(request.getParameter("id")));
		/* 49 */friendForm.setName(Chinese.toChinese(request.getParameter("name")));
		/* 50 */friendForm.setQQNumber(request.getParameter("QQNumber"));
		/* 51 */friendForm.setDescription(Chinese.toChinese(request
		/* 52 */.getParameter("description")));
		/* 53 */if (friendDao.updateFriend(friendForm))
		/*     */{
			/* 55 */out
					.print("<script language=javascript>alert('修改此朋友信息成功，请重新进行查询！');window.location.href='back_FriendSelect.jsp';</script>");
			/*     */}
		/*     */else {
			/* 58 */out.print("<script language=javascript>alert('修改朋友信息失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void queryFriendForm(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 66 */friendDao = new FriendDao();
		/* 67 */request.setAttribute("form", friendDao.queryFriendForm(request
		/* 68 */.getParameter("id")));
		/*     */
		/* 70 */RequestDispatcher requestDispatcher = request
		/* 71 */.getRequestDispatcher("back_FriendUpdate.jsp");
		/* 72 */requestDispatcher.forward(request, response);
		/*     */}

	/*     */
	/*     */
	/*     */public void deleteFriend(HttpServletRequest request, HttpServletResponse response)
	/*     */throws IOException, ServletException
	/*     */{
		/* 79 */response.setContentType("text/html;charset=GBK");
		/* 80 */PrintWriter out = response.getWriter();
		/* 81 */friendDao = new FriendDao();
		/* 82 */Integer id = Integer.valueOf(request.getParameter("id"));
		/*     */
		/* 84 */if (friendDao.deleteFriend(id))
		/*     */{
			/* 86 */out
					.print("<script language=javascript>alert('删除此朋友信息成功，请重新进行查询！');window.location.href='back_FriendSelect.jsp';</script>");
			/*     */}
		/*     */else {
			/* 89 */out.print("<script language=javascript>alert('删除朋友信息失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void addFriend(HttpServletRequest request, HttpServletResponse response)
	/*     */throws IOException, ServletException
	/*     */{
		/* 97 */friendDao = new FriendDao();
		/* 98 */FriendForm friendForm = new FriendForm();
		/* 99 */friendForm.setName(Chinese.toChinese(request.getParameter("name")));
		/* 100 */friendForm.setQQNumber(request.getParameter("QQNumber"));
		/* 101 */friendForm.setDescription(Chinese.toChinese(request
		/* 102 */.getParameter("description")));
		/* 103 */String result = "添加好友失败！";
		/* 104 */if (friendDao.addFriend(friendForm)) {
			/* 105 */result = "添加好友成功！";
			/*     */}
		/* 107 */request.setAttribute("result", result);
		/*     */
		/* 109 */RequestDispatcher requestDispatcher = request
		/* 110 */.getRequestDispatcher("back_FriendAdd.jsp");
		/* 111 */requestDispatcher.forward(request, response);
		/*     */}

	/*     */
	/*     */@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 117 */doGet(request, response);
		/*     */}
	/*     */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.webiter.FriendServlet Java Class Version: 7 (51.0) JD-Core Version:
 * 0.7.1
 */