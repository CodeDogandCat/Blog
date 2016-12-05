/*    */package com.wy.dao;

/*    */
/*    *//*    */import java.sql.ResultSet;
/*    */
import java.sql.SQLException;
/*    */
import java.util.ArrayList;
/*    */
import java.util.List;

import com.wy.form.DiscussForm;
/*    */
import com.wy.tool.JDBConnection;

/*    */
/*    */
/*    */public class DiscussDao
/*    */{
	/* 13 */private JDBConnection connection = null;

	/*    */
	/*    */public DiscussDao() {
		/* 16 */connection = new JDBConnection();
		/*    */}

	/*    */
	/*    */public boolean operationDiscuss(String operation, DiscussForm disussForm) {
		/* 20 */boolean flag = false;
		/* 21 */String sql = null;
		/* 22 */if (operation.equals("É¾³ý"))
			/* 23 */sql =
			/* 24 */"delete from tb_discuss where id='" + disussForm.getId() + "'";
		/* 25 */if (operation.equals("Ìí¼Ó"))
			/* 26 */sql =
			/*    */
			/*    */
			/* 29 */"insert into tb_discuss values ('" + disussForm.getDiscussTitle() + "','"
					+ disussForm.getDiscussContent() + "','" + disussForm.getDiscussTime() + "')";
		/* 30 */if (operation.equals("ÐÞ¸Ä")) {
			/* 31 */sql =
			/*    */
			/*    */
			/* 34 */"update tb_discuss set discussTitle='" + disussForm.getDiscussTitle() + "',discussContent='"
					+ disussForm.getDiscussContent() + "' where id='" + disussForm.getId() + "'";
			/*    */}
		/*    */
		/* 37 */if (connection.executeUpdate(sql))
			/* 38 */flag = true;
		/* 39 */return flag;
		/*    */}

	/*    */
	/*    */public List queryDiscuss() {
		/* 43 */List list = new ArrayList();
		/* 44 */DiscussForm form = null;
		/* 45 */String sql = "select * from tb_discuss order by id desc";
		/*    */try {
			/* 47 */ResultSet rs = connection.executeQuery(sql);
			/* 48 */while (rs.next()) {
				/* 49 */form = new DiscussForm();
				/* 50 */form.setId(Integer.valueOf(rs.getString(1)));
				/*    */
				/*    */
				/* 53 */form.setDiscussTitle(rs.getString(2));
				/* 54 */form.setDiscussContent(rs.getString(3));
				/* 55 */form.setDiscussTime(rs.getString(4));
				/* 56 */list.add(form);
				/*    */}
			/*    */} catch (SQLException e) {
			/* 59 */e.printStackTrace();
			/*    */}
		/* 61 */return list;
		/*    */}

	/*    */
	/*    */
	/*    */
	/*    */public DiscussForm queryDiscuss(Integer id)
	/*    */{
		/* 68 */DiscussForm form = null;
		/* 69 */String sql = "select * from tb_discuss where id='" + id + "'";
		/*    */try {
			/* 71 */ResultSet rs = connection.executeQuery(sql);
			/* 72 */while (rs.next()) {
				/* 73 */form = new DiscussForm();
				/* 74 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 75 */form.setDiscussTitle(rs.getString(2));
				/* 76 */form.setDiscussContent(rs.getString(3));
				/* 77 */form.setDiscussTime(rs.getString(4));
				/*    */}
			/*    */}
		/*    */catch (SQLException e) {
			/* 81 */e.printStackTrace();
			/*    */}
		/* 83 */return form;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.dao.DiscussDao Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */
