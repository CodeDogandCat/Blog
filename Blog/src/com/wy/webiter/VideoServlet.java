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

import com.jspsmart.upload.Files;
/*     */
import com.jspsmart.upload.SmartUpload;
/*     */
import com.wy.dao.VideoDao;
/*     */
import com.wy.dao.VideoRestoreDao;
/*     */
import com.wy.form.RestoreForm;
/*     */
import com.wy.form.VideoForm;
/*     */
import com.wy.tool.Chinese;

/*     */
/*     */
/*     */
/*     */public class VideoServlet
/*     */extends HttpServlet
/*     */{
	/*     */private static final long serialVersionUID = 1L;
	/*     */private int method;
	/* 25 */private VideoRestoreDao restoreDao = null;
	/* 26 */private VideoDao videoDao = null;

	/*     */
	/*     */public VideoServlet() {
	}

	/*     */
	/*     */@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 31 */method = Integer.parseInt(request.getParameter("method"));
		/* 32 */if (method == 0) {
			/* 33 */addVideo(request, response);
			/*     */}
		/* 35 */if (method == 1) {
			/* 36 */deleteVideo(request, response);
			/*     */}
		/* 38 */if (method == 2) {
			/* 39 */HeadAddRestore(request, response);
			/*     */}
		/* 41 */if (method == 3) {
			/* 42 */deleteRestore(request, response);
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void HeadAddRestore(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 50 */response.setContentType("text/html;charset=GBK");
		/* 51 */PrintWriter out = response.getWriter();
		/* 52 */restoreDao = new VideoRestoreDao();
		/* 53 */RestoreForm restoreForm = new RestoreForm();
		/* 54 */restoreForm.setArticleId(Integer.valueOf(request
		/* 55 */.getParameter("articleId")));
		/* 56 */restoreForm.setReAccount(request.getParameter("accountId"));
		/* 57 */restoreForm.setReTitle(Chinese.toChinese(request
		/* 58 */.getParameter("reTitle")));
		/* 59 */restoreForm.setReContent(Chinese.toChinese(request
		/* 60 */.getParameter("reContent")));
		/* 61 */if (restoreDao.operationRestore("添加", restoreForm)) {
			/* 62 */out
					.print("<script language=javascript>alert('添加回复信息成功，请重新查询！');window.location.href='head_VideoForm.jsp?id="
							+
							/* 63 */request.getParameter("articleId") + "';</script>");
			/*     */} else {
			/* 65 */out.print("<script language=javascript>alert('添加回复信息失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void deleteRestore(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 73 */response.setContentType("text/html;charset=GBK");
		/* 74 */PrintWriter out = response.getWriter();
		/* 75 */restoreDao = new VideoRestoreDao();
		/* 76 */RestoreForm restoreForm = new RestoreForm();
		/* 77 */restoreForm.setId(Integer.valueOf(request.getParameter("id")));
		/*     */
		/* 79 */if (restoreDao.operationRestore("删除", restoreForm)) {
			/* 80 */out
					.print("<script language=javascript>alert('删除回复成功，请重新查询！');window.location.href='back_VideoRestoreSelect.jsp?id="
							+
							/* 81 */request.getParameter("idd") + "';</script>");
			/*     */} else {
			/* 83 */out.print("<script language=javascript>alert('删除回复失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */
	/*     */public void deleteVideo(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 92 */response.setContentType("text/html;charset=GBK");
		/* 93 */PrintWriter out = response.getWriter();
		/* 94 */videoDao = new VideoDao();
		/* 95 */Integer id = Integer.valueOf(-10);
		/*     */try {
			/* 97 */id = Integer.valueOf(request.getParameter("id"));
			/*     */} catch (Exception e) {
			/* 99 */System.out.println("id转换出错");
			/*     */}
		/*     */
		/* 102 */String photoDir = "";
		/*     */try {
			/* 104 */photoDir = request.getRealPath(videoDao.queryVideo(id)
			/* 105 */.getVideoAddress());
			/* 106 */java.io.File file = new java.io.File(photoDir);
			/* 107 */VideoForm videoForm = new VideoForm();
			/* 108 */videoForm.setId(id);
			/* 109 */if (videoDao.operationVideo("删除", videoForm)) {
				/* 110 */file.delete();
				/* 111 */out.print("<script language=javascript>alert('删除影音成功，请重新查询！');history.go(-1);</script>");
				/*     */}
			/*     */else
			/*     */{
				/* 115 */out.print("<script language=javascript>alert('删除影音失败！');history.go(-1);</script>");
				/*     */}
			/* 117 */RequestDispatcher requestDispatcher = request
			/* 118 */.getRequestDispatcher("back_VideoSelect.jsp");
			/* 119 */requestDispatcher.forward(request, response);
			/*     */}
		/*     */catch (Exception e) {
			/* 122 */java.io.File file = new java.io.File(photoDir);
			/* 123 */VideoForm videoForm = new VideoForm();
			/* 124 */videoForm.setId(id);
			/* 125 */if (videoDao.operationVideo("删除", videoForm))
			/*     */{
				/* 127 */file.delete();
				/* 128 */out.print("<script language=javascript>alert('删除影音成功，请重新查询！');history.go(-1);</script>");
				/*     */}
			/*     */else {
				/* 131 */out.print("<script language=javascript>alert('删除影音失败！');history.go(-1);</script>");
				/*     */}
			/* 133 */RequestDispatcher requestDispatcher = request
			/* 134 */.getRequestDispatcher("back_VideoSelect.jsp");
			/* 135 */requestDispatcher.forward(request, response);
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void addVideo(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 143 */videoDao = new VideoDao();
		/* 144 */VideoForm videoForm = new VideoForm();
		/*     */
		/* 146 */SmartUpload su = new SmartUpload();
		/*     */
		/* 148 */Integer maxID = Integer.valueOf(0);
		/* 149 */if (videoDao.MaxQueryID() != null) {
			/* 150 */maxID = videoDao.MaxQueryID();
			/*     */}
		/* 152 */String result = "上传的影音格式和大小有问题,上传影音失败!";
		/* 153 */String type = null;
		/*     */
		/* 155 */String[] videoType = { "ogg", "mp4" };
		/* 156 */String filedir = "file/";
		/* 157 */long maxsize = 104857600L;
		/*     */try
		/*     */{
			/* 160 */su.initialize(getServletConfig(), request, response);
			/* 161 */su.setMaxFileSize(maxsize);
			/* 162 */su.upload();
			/*     */
			/* 164 */Files files = su.getFiles();
			/*     */
			/* 166 */for (int i = 0; i < files.getCount(); i++) {
				/* 167 */com.jspsmart.upload.File singlefile = files.getFile(i);
				/* 168 */type = singlefile.getFileExt();
				/*     */
				/* 170 */for (int j = 0; j < videoType.length; j++) {
					/* 171 */if ((videoType[j].equals(type)) &&
					/* 172 */(!singlefile.isMissing())) {
						/* 173 */String videoTime = su.getRequest().getParameter(
						/* 174 */"videoTime");
						/* 175 */String videoDescription = su.getRequest()
						/* 176 */.getParameter("videoDescription");
						/*     */
						/* 178 */videoForm.setVideoTime(videoTime);
						/*     */
						/* 180 */videoForm.setVideoDescription(videoDescription);
						/* 181 */filedir = filedir + maxID + "." +
						/* 182 */singlefile.getFileExt();
						/* 183 */videoForm.setVideoAddress(filedir);
						/* 184 */if (videoDao.operationVideo("添加", videoForm)) {
							/* 185 */singlefile.saveAs(filedir, 1);
							/* 186 */result = "上传影音成功!";
							/*     */}
						/*     */}
					/*     */}
				/*     */}
			/*     */}
		/*     */catch (Exception e) {
			/* 193 */e.printStackTrace();
			/*     */}
		/*     */
		/* 196 */request.setAttribute("result", result);
		/* 197 */RequestDispatcher requestDispatcher = request
		/* 198 */.getRequestDispatcher("back_VideoInsert.jsp");
		/* 199 */requestDispatcher.forward(request, response);
		/*     */}

	/*     */
	/*     */@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 205 */doGet(request, response);
		/*     */}
	/*     */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.webiter.VideoServlet Java Class Version: 7 (51.0) JD-Core Version:
 * 0.7.1
 */