/*    */package com.wy.dao;

/*    */
/*    *//*    */import java.sql.ResultSet;
/*    */
import java.sql.SQLException;
/*    */
import java.util.List;

import com.wy.form.FriendForm;
/*    */
import com.wy.tool.JDBConnection;

/*    */
/*    */public class FriendDao
/*    */{
	/* 11 */private JDBConnection connection = null;

	/*    */
	/*    */public FriendDao() {
		/* 14 */connection = new JDBConnection();
		/*    */}

	/*    */
	/*    */public boolean updateFriend(FriendForm form)
	/*    */{
		/* 19 */boolean flag = false;
		/* 20 */String sql = "update tb_friend set name='" + form.getName() +
		/* 21 */"',QQNumber='" + form.getQQNumber() + "',description='" +
		/* 22 */form.getDescription() + "' where id='" + form.getId() + "'";
		/* 23 */if (connection.executeUpdate(sql)) {
			/* 24 */flag = true;
			/*    */}
		/* 26 */return flag;
		/*    */}

	/*    */
	/*    */public boolean addFriend(FriendForm form)
	/*    */{
		/* 31 */boolean flag = false;
		/* 32 */String sql = "insert into tb_friend values ('" + form.getName() + "','" +
		/* 33 */form.getQQNumber() + "','" + form.getDescription() + "')";
		/* 34 */if (connection.executeUpdate(sql)) {
			/* 35 */flag = true;
			/*    */}
		/* 37 */return flag;
		/*    */}

	/*    */
	/*    */public boolean deleteFriend(Integer id)
	/*    */{
		/* 42 */boolean flag = false;
		/* 43 */String sql = "delete from tb_friend where id='" + id + "'";
		/* 44 */if (connection.executeUpdate(sql)) {
			/* 45 */flag = true;
			/*    */}
		/* 47 */return flag;
		/*    */}

	/*    */
	/*    */public List queryFriend()
	/*    */{
		/* 52 */List list = new java.util.ArrayList();
		/* 53 */FriendForm form = null;
		/* 54 */String sql = "select * from tb_friend";
		/* 55 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 57 */while (rs.next()) {
				/* 58 */form = new FriendForm();
				/* 59 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 60 */form.setName(rs.getString(2));
				/* 61 */form.setQQNumber(rs.getString(3));
				/* 62 */form.setDescription(rs.getString(4));
				/* 63 */list.add(form);
				/*    */}
			/*    */} catch (SQLException e) {
			/* 66 */e.printStackTrace();
			/*    */}
		/*    */
		/* 69 */return list;
		/*    */}

	/*    */
	/*    */public FriendForm queryFriendForm(String id)
	/*    */{
		/* 74 */FriendForm form = null;
		/* 75 */String sql = "select * from tb_friend where id='" + id + "'";
		/* 76 */ResultSet rs = connection.executeQuery(sql);
		/*    */try {
			/* 78 */while (rs.next()) {
				/* 79 */form = new FriendForm();
				/* 80 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 81 */form.setName(rs.getString(2));
				/* 82 */form.setQQNumber(rs.getString(3));
				/* 83 */form.setDescription(rs.getString(4));
				/*    */}
			/*    */} catch (SQLException e) {
			/* 86 */e.printStackTrace();
			/*    */}
		/* 88 */return form;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.dao.FriendDao Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */