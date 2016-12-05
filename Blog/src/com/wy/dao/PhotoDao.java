/*    */package com.wy.dao;

/*    */
/*    *//*    */import java.sql.ResultSet;
/*    */
import java.sql.SQLException;
/*    */
import java.util.ArrayList;
/*    */
import java.util.List;

import com.wy.form.PhotoForm;
/*    */
import com.wy.tool.JDBConnection;

/*    */
/*    */public class PhotoDao
/*    */{
	/* 12 */private JDBConnection connection = null;

	/*    */
	/*    */public PhotoDao() {
		/* 15 */connection = new JDBConnection();
		/*    */}

	/*    */
	/*    */public boolean operationPhoto(String operation, PhotoForm photoForm) {
		/* 19 */boolean flag = false;
		/* 20 */String sql = null;
		/* 21 */if (operation.equals("É¾³ý"))
			/* 22 */sql = "delete from tb_photo where id='" + photoForm.getId() + "'";
		/* 23 */if (operation.equals("Ìí¼Ó")) {
			/* 24 */sql =
			/*    */
			/*    */
			/* 27 */"insert into tb_photo values ('" + photoForm.getPhotoAddress() + "','"
					+ photoForm.getPhotoDescription() + "','" + photoForm.getPhtoTime() + "')";
			/*    */}
		/* 29 */if (connection.executeUpdate(sql))
			/* 30 */flag = true;
		/* 31 */return flag;
		/*    */}

	/*    */
	/*    */public PhotoForm queryPhoto(Integer id) {
		/* 35 */PhotoForm form = null;
		/* 36 */String sql = "select * from tb_photo where id='" + id + "'";
		/* 37 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 39 */while (rs.next()) {
				/* 40 */form = new PhotoForm();
				/* 41 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 42 */form.setPhotoAddress(rs.getString(2));
				/* 43 */form.setPhotoDescription(rs.getString(3));
				/* 44 */form.setPhtoTime(rs.getString(4));
				/*    */}
			/*    */} catch (SQLException e) {
			/* 47 */e.printStackTrace();
			/*    */}
		/* 49 */return form;
		/*    */}

	/*    */
	/*    */public List queryPhoto() {
		/* 53 */List list = new ArrayList();
		/* 54 */PhotoForm form = null;
		/* 55 */String sql = "select * from tb_photo order by id desc";
		/* 56 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 58 */while (rs.next()) {
				/* 59 */form = new PhotoForm();
				/* 60 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 61 */form.setPhotoAddress(rs.getString(2));
				/* 62 */form.setPhotoDescription(rs.getString(3));
				/* 63 */form.setPhtoTime(rs.getString(4));
				/* 64 */list.add(form);
				/*    */}
			/*    */} catch (SQLException e) {
			/* 67 */e.printStackTrace();
			/*    */}
		/* 69 */return list;
		/*    */}

	/*    */
	/*    */public Integer MaxQueryID() {
		/* 73 */Integer maxID = Integer.valueOf(0);
		/* 74 */String sql = "select max(id) as id from tb_photo";
		/* 75 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 77 */while (rs.next()) {
				/* 78 */maxID = Integer.valueOf(rs.getInt("id"));
				/*    */}
			/*    */} catch (SQLException e) {
			/* 81 */e.printStackTrace();
			/*    */}
		/* 83 */return maxID;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.dao.PhotoDao Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */