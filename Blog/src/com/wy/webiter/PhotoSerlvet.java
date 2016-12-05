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
import com.wy.dao.PhotoDao;
/*     */
import com.wy.dao.PhotoRestoreDao;
/*     */
import com.wy.form.PhotoForm;
/*     */
import com.wy.form.RestoreForm;
/*     */
import com.wy.tool.Chinese;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */public class PhotoSerlvet
/*     */extends HttpServlet
/*     */{
	/*     */private static final long serialVersionUID = 1L;
	/*     */private int method;
	/* 29 */private PhotoDao photoDao = null;
	/* 30 */private PhotoRestoreDao restoreDao = null;

	/*     */
	/*     */public PhotoSerlvet() {
	}

	/*     */
	/*     */@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 35 */method = Integer.parseInt(request.getParameter("method"));
		/* 36 */if (method == 0) {
			/* 37 */addPhoto(request, response);
			/*     */}
		/* 39 */if (method == 1) {
			/* 40 */deletePhoto(request, response);
			/*     */}
		/* 42 */if (method == 2) {
			/* 43 */HeadAddRestore(request, response);
			/*     */}
		/* 45 */if (method == 3) {
			/* 46 */deleteRestore(request, response);
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */
	/*     */public void deletePhoto(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 55 */response.setContentType("text/html;charset=GBK");
		/* 56 */PrintWriter out = response.getWriter();
		/* 57 */photoDao = new PhotoDao();
		/* 58 */Integer id = Integer.valueOf(-10);
		/*     */try {
			/* 60 */id = Integer.valueOf(request.getParameter("id"));
			/*     */} catch (Exception e) {
			/* 62 */System.out.println("id转换出错");
			/*     */}
		/*     */
		/* 65 */String photoDir = "";
		/*     */try {
			/* 67 */photoDir = request.getRealPath(photoDao.queryPhoto(id)
			/* 68 */.getPhotoAddress());
			/* 69 */java.io.File file = new java.io.File(photoDir);
			/* 70 */PhotoForm photoForm = new PhotoForm();
			/* 71 */photoForm.setId(id);
			/* 72 */if (photoDao.operationPhoto("删除", photoForm)) {
				/* 73 */file.delete();
				/* 74 */out.print("<script language=javascript>alert('删除图片成功，请重新查询！');history.go(-1);</script>");
				/*     */}
			/*     */else
			/*     */{
				/* 78 */out.print("<script language=javascript>alert('修改用户信息失败！');history.go(-1);</script>");
				/*     */}
			/* 80 */RequestDispatcher requestDispatcher = request
			/* 81 */.getRequestDispatcher("back_PhotoSelect.jsp");
			/* 82 */requestDispatcher.forward(request, response);
			/*     */}
		/*     */catch (Exception e) {
			/* 85 */java.io.File file = new java.io.File(photoDir);
			/* 86 */PhotoForm photoForm = new PhotoForm();
			/* 87 */photoForm.setId(id);
			/* 88 */if (photoDao.operationPhoto("删除", photoForm))
			/*     */{
				/* 90 */file.delete();
				/* 91 */out.print("<script language=javascript>alert('删除图片成功，请重新查询！');history.go(-1);</script>");
				/*     */}
			/*     */else {
				/* 94 */out.print("<script language=javascript>alert('修改用户信息失败！');history.go(-1);</script>");
				/*     */}
			/* 96 */RequestDispatcher requestDispatcher = request
			/* 97 */.getRequestDispatcher("back_PhotoSelect.jsp");
			/* 98 */requestDispatcher.forward(request, response);
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void addPhoto(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		photoDao = new PhotoDao();
		PhotoForm photoForm = new PhotoForm();
		SmartUpload su = new SmartUpload();

		Integer maxID = Integer.valueOf(0);
		if (photoDao.MaxQueryID() != null) {
			maxID = photoDao.MaxQueryID();
		}
		String result = "上传的照片格式和大小有问题,上传照片失败!";
		String type = null;
		String[] imageType = { "JPG", "jpg", "gif", "bmp", "BMP" };
		String filedir = "file/";
		long maxsize = 5242880L;
		try {
			su.initialize(getServletConfig(), request, response);
			su.setMaxFileSize(maxsize);
			su.upload();
			Files files = su.getFiles();
			for (int i = 0; i < files.getCount(); i++) {
				com.jspsmart.upload.File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if ((imageType[ii].equals(type)) && (!singlefile.isMissing())) {
						String photoTime = su.getRequest().getParameter("phtoTime");
						String photoDescription = su.getRequest().getParameter("photoDescription");

						photoForm.setPhtoTime(photoTime);

						photoForm.setPhotoDescription(photoDescription);
						filedir = filedir + maxID + "." + singlefile.getFileExt();
						photoForm.setPhotoAddress(filedir);
						if (photoDao.operationPhoto("添加", photoForm)) {
							singlefile.saveAs(filedir, 1);
							result = "上传照片成功!";
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("back_PhotoInsert.jsp");
		requestDispatcher.forward(request, response);
	}

	/*     */
	/*     */public void HeadAddRestore(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 163 */response.setContentType("text/html;charset=GBK");
		/* 164 */PrintWriter out = response.getWriter();
		/* 165 */restoreDao = new PhotoRestoreDao();
		/* 166 */RestoreForm restoreForm = new RestoreForm();
		/* 167 */restoreForm.setArticleId(Integer.valueOf(request
		/* 168 */.getParameter("articleId")));
		/* 169 */restoreForm.setReAccount(request.getParameter("accountId"));
		/* 170 */restoreForm.setReTitle(Chinese.toChinese(request
		/* 171 */.getParameter("reTitle")));
		/* 172 */restoreForm.setReContent(Chinese.toChinese(request
		/* 173 */.getParameter("reContent")));
		/* 174 */if (restoreDao.operationRestore("添加", restoreForm)) {
			/* 175 */out
					.print("<script language=javascript>alert('添加回复信息成功，请重新查询！');window.location.href='head_PhotoForm.jsp?id="
							+
							/* 176 */request.getParameter("articleId") + "';</script>");
			/*     */} else {
			/* 178 */out.print("<script language=javascript>alert('添加回复信息失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */public void deleteRestore(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 186 */response.setContentType("text/html;charset=GBK");
		/* 187 */PrintWriter out = response.getWriter();
		/* 188 */restoreDao = new PhotoRestoreDao();
		/* 189 */RestoreForm restoreForm = new RestoreForm();
		/* 190 */restoreForm.setId(Integer.valueOf(request.getParameter("id")));
		/*     */
		/* 192 */if (restoreDao.operationRestore("删除", restoreForm)) {
			/* 193 */out
					.print("<script language=javascript>alert('删除回复成功，请重新查询！');window.location.href='back_PhotoRestoreSelect.jsp?id="
							+
							/* 194 */request.getParameter("idd") + "';</script>");
			/*     */} else {
			/* 196 */out.print("<script language=javascript>alert('删除回复失败！');history.go(-1);</script>");
			/*     */}
		/*     */}

	/*     */
	/*     */
	/*     */@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	/*     */throws ServletException, IOException
	/*     */{
		/* 204 */doGet(request, response);
		/*     */}
	/*     */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.webiter.PhotoSerlvet Java Class Version: 7 (51.0) JD-Core Version:
 * 0.7.1
 */