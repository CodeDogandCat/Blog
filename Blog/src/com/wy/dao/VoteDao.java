/*    */package com.wy.dao;

/*    */
/*    *//*    */import java.sql.ResultSet;
/*    */
import java.sql.SQLException;
/*    */
import java.util.ArrayList;
/*    */
import java.util.List;

import com.wy.form.VoteForm;
/*    */
import com.wy.tool.JDBConnection;

/*    */
/*    */
/*    */public class VoteDao
/*    */{
	/* 13 */private JDBConnection connection = null;

	/*    */
	/*    */public VoteDao() {
		/* 16 */connection = new JDBConnection();
		/*    */}

	/*    */
	/*    */public boolean operationVote(String operation, VoteForm voteForm) {
		/* 20 */boolean flag = false;
		/* 21 */String sql = null;
		/* 22 */if (operation.equals("É¾³ý")) {
			/* 23 */sql = "delete from tb_vote where id='" + voteForm.getId() + "'";
			/*    */}
		/* 25 */if (operation.equals("Ìí¼Ó"))
			/* 26 */sql =
			/*    */
			/* 28 */"insert into tb_vote values('" + voteForm.getVoteName() + "','" + voteForm.getVoteTime() + "','"
					+ voteForm.getVoteContent() + "')";
		/* 29 */if (connection.executeUpdate(sql))
			/* 30 */flag = true;
		/* 31 */return flag;
		/*    */}

	/*    */
	/*    */public List<VoteForm> queryVoteList() {
		/* 35 */List<VoteForm> list = new ArrayList();
		/* 36 */String sql = "select * from tb_vote";
		/* 37 */ResultSet rs = connection.executeQuery(sql);
		/* 38 */VoteForm form = null;
		/*    */try {
			/* 40 */while (rs.next()) {
				/* 41 */form = new VoteForm();
				/* 42 */form.setId(Integer.valueOf(rs.getString(1)));
				/* 43 */form.setVoteName(rs.getString(2));
				/* 44 */form.setVoteTime(rs.getString(3));
				/* 45 */form.setVoteContent(rs.getString(4));
				/* 46 */list.add(form);
				/*    */}
			/*    */}
		/*    */catch (SQLException e) {
			/* 50 */e.printStackTrace();
			/*    */}
		/* 52 */return list;
		/*    */}
	/*    */
}
