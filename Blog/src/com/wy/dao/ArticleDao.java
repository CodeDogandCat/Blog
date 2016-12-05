/*    */package com.wy.dao;

/*    */
/*    *//*    */import java.sql.ResultSet;
/*    */
import java.sql.SQLException;
/*    */
import java.util.ArrayList;
/*    */
import java.util.List;

import com.wy.form.ArticleForm;
/*    */
import com.wy.tool.JDBConnection;

/*    */
/*    */public class ArticleDao
/*    */{
	/* 12 */private JDBConnection connection = null;
	/*    */
	/* 14 */private ArticleForm articleForm = null;

	/*    */
	/*    */public ArticleDao() {
		/* 17 */connection = new JDBConnection();
		/*    */}

	/*    */
	/*    */public boolean operationArticle(String operation, ArticleForm form) {
		/* 21 */boolean flag = false;
		/* 22 */String sql = null;
		/* 23 */if (operation.equals("添加"))
			/* 24 */sql =
			/*    */
			/* 26 */"insert into tb_article values ('" + form.getTypeId() + "','" + form.getTitle() + "','"
					+ form.getContent() + "','" + form.getPhTime() + "','" + form.getNumber() + "')";
		/* 27 */if (operation.equals("修改"))
			/* 28 */sql =
			/*    */
			/* 30 */"update tb_article set typeID='" + form.getTypeId() + "',title='" + form.getTitle() + "',content='"
					+ form.getContent() + "' where id='" + form.getId() + "'";
		/* 31 */if (operation.equals("删除"))
			/* 32 */sql = "delete from tb_article where id='" + form.getId() + "'";
		/* 33 */if (operation.equals("增加"))
			/* 34 */sql =
			/* 35 */"update tb_article set number=number+1 where id='" + form.getId() + "'";
		/* 36 */if (connection.executeUpdate(sql)) {
			/* 37 */flag = true;
			/*    */}
		/* 39 */return flag;
		/*    */}

	/*    */
	/*    */public List queryArticle(Integer typeId) {
		/* 43 */List list = new ArrayList();
		/* 44 */String sql = null;
		/* 45 */if (typeId == null) {
			/* 46 */sql = "select * from tb_article";
			/*    */} else
			/* 48 */sql =
			/* 49 */"select * from tb_article where typeID='" + typeId + "' order by id desc";
		/* 50 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 52 */while (rs.next()) {
				/* 53 */articleForm = new ArticleForm();
				/* 54 */articleForm.setId(Integer.valueOf(rs.getInt(1)));
				/* 55 */articleForm.setTypeId(Integer.valueOf(rs.getInt(2)));
				/* 56 */articleForm.setTitle(rs.getString(3));
				/* 57 */articleForm.setContent(rs.getString(4));
				/* 58 */articleForm.setPhTime(rs.getString(5));
				/* 59 */articleForm.setNumber(Integer.valueOf(rs.getInt(6)));
				/* 60 */list.add(articleForm);
				/*    */}
			/*    */} catch (SQLException e) {
			/* 63 */e.printStackTrace();
			/*    */}
		/* 65 */return list;
		/*    */}

	/*    */
	/*    */public ArticleForm queryArticleForm(Integer id) {
		/* 69 */String sql = "select * from tb_article where id='" + id + "'";
		/* 70 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 72 */while (rs.next()) {
				/* 73 */articleForm = new ArticleForm();
				/* 74 */articleForm.setId(Integer.valueOf(rs.getInt(1)));
				/* 75 */articleForm.setTypeId(Integer.valueOf(rs.getInt(2)));
				/* 76 */articleForm.setTitle(rs.getString(3));
				/* 77 */articleForm.setContent(rs.getString(4));
				/* 78 */articleForm.setPhTime(rs.getString(5));
				/* 79 */articleForm.setNumber(Integer.valueOf(rs.getInt(6)));
				/*    */}
			/*    */} catch (SQLException e) {
			/* 82 */e.printStackTrace();
			/*    */}
		/* 84 */operationArticle("增加", articleForm);
		/* 85 */return articleForm;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.dao.ArticleDao Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */