/*    */package com.wy.form;

/*    */
/*    */public class ArticleForm {
	public ArticleForm() {
	}

	/* 4 */private Integer id = Integer.valueOf(-1);
	/* 5 */private Integer typeId = Integer.valueOf(-1);
	/* 6 */private String title = "";
	/* 7 */private String content = "";
	/* 8 */private String phTime = "";
	/* 9 */private Integer number = Integer.valueOf(-1);

	/*    */
	/* 11 */public String getContent() {
		return content;
	}

	/*    */
	/*    */public void setContent(String content) {
		/* 14 */this.content = content;
		/*    */}

	/*    */
	/* 17 */public Integer getId() {
		return id;
	}

	/*    */
	/*    */public void setId(Integer id) {
		/* 20 */this.id = id;
		/*    */}

	/*    */
	/* 23 */public Integer getNumber() {
		return number;
	}

	/*    */
	/*    */public void setNumber(Integer number) {
		/* 26 */this.number = number;
		/*    */}

	/*    */
	/* 29 */public String getPhTime() {
		return phTime;
	}

	/*    */
	/*    */public void setPhTime(String phTime) {
		/* 32 */this.phTime = phTime;
		/*    */}

	/*    */
	/* 35 */public String getTitle() {
		return title;
	}

	/*    */
	/*    */public void setTitle(String title) {
		/* 38 */this.title = title;
		/*    */}

	/*    */
	/* 41 */public Integer getTypeId() {
		return typeId;
	}

	/*    */
	/*    */public void setTypeId(Integer typeId) {
		/* 44 */this.typeId = typeId;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.form.ArticleForm Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */