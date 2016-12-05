/*    */package com.wy.dao;

/*    */
/*    *//*    */import java.sql.ResultSet;
/*    */
import java.sql.SQLException;
/*    */
import java.util.ArrayList;
/*    */
import java.util.List;

import com.wy.form.RestoreForm;
/*    */
import com.wy.tool.JDBConnection;

/*    */
/*    */public class RestoreDao
/*    */{
	/* 12 */private JDBConnection connection = null;

	/*    */
	/*    */public RestoreDao() {
		/* 15 */connection = new JDBConnection();
		/*    */}

	/*    */
	/*    */public boolean operationRestore(String operation, RestoreForm form) {
		/* 19 */boolean flag = false;
		/* 20 */String sql = "";
		/* 21 */if (operation.equals("Ìí¼Ó"))
			/* 22 */sql =
			/*    */
			/* 24 */"insert into tb_restore values ('" + form.getArticleId() + "','" + form.getReAccount() + "','"
					+ form.getReTitle() + "','" + form.getReContent() + "')";
		/* 25 */if (operation.equals("É¾³ý"))
			/* 26 */sql = "delete from tb_restore where id='" + form.getId() + "'";
		/* 27 */if (connection.executeUpdate(sql)) {
			/* 28 */flag = true;
			/*    */}
		/* 30 */return flag;
		/*    */}

	/*    */
	/*    */public List queryRestore(Integer articleId) {
		/* 34 */List list = new ArrayList();
		/* 35 */String sql = "select * from tb_restore where articleId='" + articleId +
		/* 36 */"' order by id desc";
		/* 37 */RestoreForm form = null;
		/* 38 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 40 */while (rs.next()) {
				/* 41 */form = new RestoreForm();
				/* 42 */form.setId(Integer.valueOf(rs.getInt(1)));
				/* 43 */form.setArticleId(Integer.valueOf(rs.getInt(2)));
				/* 44 */form.setReAccount(rs.getString(3));
				/* 45 */form.setReTitle(rs.getString(4));
				/* 46 */form.setReContent(rs.getString(5));
				/* 47 */list.add(form);
				/*    */}
			/*    */}
		/*    */catch (SQLException e) {
			/* 51 */e.printStackTrace();
			/*    */}
		/* 53 */return list;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.dao.RestoreDao Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */
