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

import com.wy.dao.DiscussDao;
/*     */
import com.wy.form.DiscussForm;
/*     */
import com.wy.tool.Chinese;

/*     */
/*     */
/*     */
/*     */public class DiscussServlet
/*     */extends HttpServlet
/*     */{
	/*     */private int method;
	/* 20 */private DiscussDao disussDao = null;

	/*     */
	/*     */public DiscussServlet() {
	}

	/*     */
	/* 24 */@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("32131");
		/* 25 */method = Integer.parseInt(request.getParameter("method"));
		/* 26 */System.out.println("32131");
		/* 27 */if (method == 0) {
			/* 28 */addDisuss(request, response);
			/*     */}
		/* 30 */if (method == 1) {
			/* 31 */deleteDisuss(request, response);
			/*     */}
		/* 33 */if (method == 2) {
			/* 34 */updateDisuss(request, response);
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */public void updateDisuss(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 45 */response.setContentType("text/html;charset=GBK");
		/* 46 */PrintWriter out = response.getWriter();
		/* 47 */DiscussForm disussForm = new DiscussForm();
		/* 48 */disussDao = new DiscussDao();
		/* 49 */disussForm.setId(Integer.valueOf(request.getParameter("id")));
		/* 50 */disussForm.setDiscussTitle(Chinese.toChinese(request
		/* 51 */.getParameter("discussTitle")));
		/* 52 */disussForm.setDiscussContent(Chinese.toChinese(request
		/* 53 */.getParameter("discussContent")));
		/* 54 */if (disussDao.operationDiscuss("修改", disussForm))
		/*     */{
			/* 56 */out
					.print("<script language=javascript>alert('修改公告信息成功！');window.location.href='back_DiscussSelect.jsp';</script>");
			/*     */}
		/*     */else {
			/* 59 */out.print("<script language=javascript>alert('修改公告信息失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */public void deleteDisuss(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 70 */response.setContentType("text/html;charset=GBK");
		/* 71 */PrintWriter out = response.getWriter();
		/* 72 */DiscussForm disussForm = new DiscussForm();
		/* 73 */disussDao = new DiscussDao();
		/* 74 */disussForm.setId(Integer.valueOf(request.getParameter("id")));
		/* 75 */if (disussDao.operationDiscuss("删除", disussForm))
		/*     */{
			/* 77 */out
					.print("<script language=javascript>alert('删除公告信息成功！');window.location.href='back_DiscussSelect.jsp';</script>");
			/*     */}
		/*     */else {
			/* 80 */out.print("<script language=javascript>alert('删除公告信息失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void addDisuss(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 88 */DiscussForm disussForm = new DiscussForm();
		/* 89 */disussDao = new DiscussDao();
		/* 90 */disussForm.setDiscussTitle(Chinese.toChinese(request
		/* 91 */.getParameter("discussTitle")));
		/* 92 */disussForm.setDiscussContent(Chinese.toChinese(request
		/* 93 */.getParameter("discussContent")));
		/* 94 */disussForm.setDiscussTime(Chinese.toChinese(request
		/* 95 */.getParameter("discussTime")));
		/* 96 */String result = "添加公告失败！";
		/* 97 */if (disussDao.operationDiscuss("添加", disussForm)) {
			/* 98 */result = "添加公告成功！";
			/*     */}
		/* 100 */request.setAttribute("result", result);
		/* 101 */RequestDispatcher requestDispatcher = request
		/* 102 */.getRequestDispatcher("back_DiscussAdd.jsp");
		/* 103 */requestDispatcher.forward(request, response);
		/*     */}

	/*     */
	/*     */@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 109 */doGet(request, response);
		/*     */}
	/*     */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.webiter.DiscussServlet Java Class Version: 7 (51.0) JD-Core Version:
 * 0.7.1
 */