/*    */package com.wy.dao;

/*    */
/*    *//*    */import java.sql.ResultSet;
/*    */
import java.sql.SQLException;
/*    */
import java.util.ArrayList;
/*    */
import java.util.List;

import com.wy.form.VideoForm;
/*    */
import com.wy.tool.JDBConnection;

/*    */
/*    */public class VideoDao
/*    */{
	/* 12 */private JDBConnection connection = null;

	/*    */
	/*    */public VideoDao() {
		/* 15 */connection = new JDBConnection();
		/*    */}

	/*    */
	/*    */public boolean operationVideo(String operation, VideoForm videoForm) {
		/* 19 */boolean flag = false;
		/* 20 */String sql = null;
		/* 21 */if (operation.equals("É¾³ý"))
			/* 22 */sql = "delete from tb_video where id='" + videoForm.getId() + "'";
		/* 23 */if (operation.equals("Ìí¼Ó")) {
			/* 24 */sql =
			/*    */
			/*    */
			/* 27 */"insert into tb_video values ('" + videoForm.getVideoAddress() + "','"
					+ videoForm.getVideoDescription() + "','" + videoForm.getVideoTime() + "')";
			/*    */}
		/* 29 */if (connection.executeUpdate(sql))
			/* 30 */flag = true;
		/* 31 */return flag;
		/*    */}

	/*    */
	/*    */public VideoForm queryVideo(Integer id) {
		/* 35 */VideoForm form = null;
		/* 36 */String sql = "select * from tb_video where id='" + id + "'";
		/* 37 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 39 */while (rs.next()) {
				/* 40 */form = new VideoForm();
				/* 41 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 42 */form.setVideoAddress(rs.getString(2));
				/* 43 */form.setVideoDescription(rs.getString(3));
				/* 44 */form.setVideoTime(rs.getString(4));
				/*    */}
			/*    */} catch (SQLException e) {
			/* 47 */e.printStackTrace();
			/*    */}
		/* 49 */return form;
		/*    */}

	/*    */
	/*    */public List queryVideo() {
		/* 53 */List list = new ArrayList();
		/* 54 */VideoForm form = null;
		/* 55 */String sql = "select * from tb_video order by id desc";
		/* 56 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 58 */while (rs.next()) {
				/* 59 */form = new VideoForm();
				/* 60 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 61 */form.setVideoAddress(rs.getString(2));
				/* 62 */form.setVideoDescription(rs.getString(3));
				/* 63 */form.setVideoTime(rs.getString(4));
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
		/* 74 */String sql = "select max(id) as id from tb_video";
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
 * com.wy.dao.VideoDao Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */