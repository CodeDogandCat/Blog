/*     */package com.wy.dao;

/*     */
/*     *//*     */import java.sql.ResultSet;
/*     */
import java.sql.SQLException;
/*     */
import java.util.ArrayList;
/*     */
import java.util.List;

import com.wy.form.ConsumerForm;
/*     */
import com.wy.tool.JDBConnection;
/*     */
import com.wy.tool.StrMD5;

/*     */
/*     */public class ConsumerDao
/*     */{
	/* 13 */private JDBConnection connection = null;
	/*     */
	/* 15 */private ConsumerForm consumerForm = null;

	/*     */
	/*     */public ConsumerDao() {
		/* 18 */connection = new JDBConnection();
		/*     */}

	/*     */
	/*     */public boolean front_updateConsumerForm(ConsumerForm form)
	/*     */{
		/* 23 */boolean flag = false;
		/* 24 */String sql = "update tb_consumer set account='" + form.getAccount() +
		/* 25 */"',password='" + StrMD5.MD5(form.getPassword()) + "',name='" +
		/* 26 */form.getName() + "',sex='" + form.getSex() + "',QQNumber='" +
		/* 27 */form.getQQNumber() + "',mainPage='" + form.getMainPage() +
		/* 28 */"',interest='" + form.getInterest() + "',eMail='" +
		/* 29 */form.getEMail() + "' where id='" + form.getId() + "'";
		/* 30 */if (connection.executeUpdate(sql)) {
			/* 31 */flag = true;
			/*     */}
		/* 33 */return flag;
		/*     */}

	/*     */
	/*     */
	/*     */public boolean updateConsumerForm(ConsumerForm form)
	/*     */{
		/* 39 */boolean flag = false;
		/* 40 */String sql = "update tb_consumer set account='" + form.getAccount() +
		/* 41 */"',password='" + StrMD5.MD5(form.getPassword()) + "',name='" +
		/* 42 */form.getName() + "',sex='" + form.getSex() + "',QQNumber='" +
		/* 43 */form.getQQNumber() + "',mainPage='" + form.getMainPage() +
		/* 44 */"',interest='" + form.getInterest() + "',eMail='" +
		/* 45 */form.getEMail() + "' where manageLevel='" +
		/* 46 */form.getManageLevel() + "'";
		/* 47 */if (connection.executeUpdate(sql)) {
			/* 48 */flag = true;
			/*     */}
		/* 50 */return flag;
		/*     */}

	/*     */
	/*     */public boolean deleteConsumerForm(String account)
	/*     */{
		/* 55 */boolean flag = false;
		/* 56 */String sql = "delete from tb_consumer where account='" + account + "'";
		/* 57 */if (connection.executeUpdate(sql)) {
			/* 58 */flag = true;
			/*     */}
		/* 60 */return flag;
		/*     */}

	/*     */
	/*     */public boolean addConsumerForm(ConsumerForm form)
	/*     */{
		/* 65 */boolean flag = false;
		/* 66 */String sql = "insert into tb_consumer values ('" + form.getAccount() +
		/* 67 */"','" + StrMD5.MD5(form.getPassword()) + "','" +
		/* 68 */form.getName() + "','" + form.getSex() + "','" +
		/* 69 */form.getQQNumber() + "','" + form.getMainPage() + "','" +
		/* 70 */form.getInterest() + "','" + form.getEMail() + "','" +
		/* 71 */form.getManageLevel() + "')";
		/*     */
		/* 73 */if (connection.executeUpdate(sql)) {
			/* 74 */flag = true;
			/*     */}
		/* 76 */return flag;
		/*     */}

	/*     */
	/*     */public String getConsumerForm(Integer id) {
		/* 80 */String sql = "select * from tb_consumer where id='" + id + "'";
		/* 81 */String name = "";
		/*     */try {
			/* 83 */ResultSet rs = connection.executeQuery(sql);
			/* 84 */while (rs.next()) {
				/* 85 */name = rs.getString("name");
				/*     */}
			/*     */} catch (SQLException e) {
			/* 88 */e.printStackTrace();
			/*     */}
		/* 90 */return name;
		/*     */}

	/*     */
	/*     */public ConsumerForm getConsumerForm(String account)
	/*     */{
		/* 95 */String sql = "select * from tb_consumer where account='" + account +
		/* 96 */"'collate Chinese_PRC_CS_AI";
		/*     */try {
			/* 98 */ResultSet rs = connection.executeQuery(sql);
			/* 99 */while (rs.next()) {
				System.out.println("∑«ø’");
				/* 100 */consumerForm = new ConsumerForm();
				/* 101 */consumerForm.setId(Integer.valueOf(rs.getString(1)));
				/* 102 */consumerForm.setAccount(rs.getString(2));
				/* 103 */consumerForm.setPassword(rs.getString(3));
				/* 104 */consumerForm.setName(rs.getString(4));
				/* 105 */consumerForm.setSex(rs.getString(5));
				/* 106 */consumerForm.setQQNumber(rs.getString(6));
				/* 107 */consumerForm.setMainPage(rs.getString(7));
				/* 108 */consumerForm.setInterest(rs.getString(8));
				/* 109 */consumerForm.setEMail(rs.getString(9));
				/* 110 */consumerForm.setManageLevel(rs.getString(10));

				/*     */}
			System.out.println("≤È’“Œ™ø’");
			/*     */} catch (SQLException e) {
			/* 113 */e.printStackTrace();
			/*     */}
		/* 115 */return consumerForm;
		/*     */}

	/*     */
	/*     */public List getConsumerList(String manageLevel)
	/*     */{
		/* 120 */List list = new ArrayList();
		/* 121 */String sql = "select * from tb_consumer where manageLevel='" +
		/* 122 */manageLevel + "'";
		/*     */try {
			/* 124 */ResultSet rs = connection.executeQuery(sql);
			/* 125 */while (rs.next()) {
				/* 126 */consumerForm = new ConsumerForm();
				/* 127 */consumerForm.setId(Integer.valueOf(rs.getString(1)));
				/* 128 */consumerForm.setAccount(rs.getString(2));
				/* 129 */consumerForm.setPassword(rs.getString(3));
				/* 130 */consumerForm.setName(rs.getString(4));
				/* 131 */consumerForm.setSex(rs.getString(5));
				/* 132 */consumerForm.setQQNumber(rs.getString(6));
				/* 133 */consumerForm.setMainPage(rs.getString(7));
				/* 134 */consumerForm.setInterest(rs.getString(8));
				/* 135 */consumerForm.setEMail(rs.getString(9));
				/* 136 */consumerForm.setManageLevel(rs.getString(10));
				/* 137 */list.add(consumerForm);
				/*     */}
			/*     */} catch (SQLException e) {
			/* 140 */e.printStackTrace();
			/*     */}
		/*     */
		/* 143 */return list;
		/*     */}
	/*     */
}
