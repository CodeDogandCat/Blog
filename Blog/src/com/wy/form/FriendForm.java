/*    */package com.wy.form;

/*    */
/*    */public class FriendForm {
	public FriendForm() {
	}

	/* 4 */private Integer id = Integer.valueOf(1);
	/* 5 */private String name = null;
	/* 6 */private String QQNumber = null;
	/* 7 */private String description = null;

	/*    */
	/* 9 */public String getDescription() {
		return description;
	}

	/*    */
	/*    */public void setDescription(String description) {
		/* 12 */this.description = description;
		/*    */}

	/*    */
	/* 15 */public Integer getId() {
		return id;
	}

	/*    */
	/*    */public void setId(Integer id) {
		/* 18 */this.id = id;
		/*    */}

	/*    */
	/* 21 */public String getName() {
		return name;
	}

	/*    */
	/*    */public void setName(String name) {
		/* 24 */this.name = name;
		/*    */}

	/*    */
	/* 27 */public String getQQNumber() {
		return QQNumber;
	}

	/*    */
	/*    */public void setQQNumber(String number) {
		/* 30 */QQNumber = number;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.form.FriendForm Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */