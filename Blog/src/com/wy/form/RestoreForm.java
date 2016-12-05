/*    */package com.wy.form;

/*    */
/*    */public class RestoreForm {
	public RestoreForm() {
	}

	/* 4 */private Integer id = Integer.valueOf(0);
	/* 5 */private Integer articleId = Integer.valueOf(0);
	/* 6 */private String reAccount = "";
	/* 7 */private String reTitle = "";
	/* 8 */private String reContent = "";

	/*    */
	/* 10 */public Integer getArticleId() {
		return articleId;
	}

	/*    */
	/*    */public void setArticleId(Integer articleId) {
		/* 13 */this.articleId = articleId;
		/*    */}

	/*    */
	/* 16 */public Integer getId() {
		return id;
	}

	/*    */
	/*    */public void setId(Integer id) {
		/* 19 */this.id = id;
		/*    */}

	/*    */
	/* 22 */public String getReAccount() {
		return reAccount;
	}

	/*    */
	/*    */public void setReAccount(String reAccount) {
		/* 25 */this.reAccount = reAccount;
		/*    */}

	/*    */
	/* 28 */public String getReContent() {
		return reContent;
	}

	/*    */
	/*    */public void setReContent(String reContent) {
		/* 31 */this.reContent = reContent;
		/*    */}

	/*    */
	/* 34 */public String getReTitle() {
		return reTitle;
	}

	/*    */
	/*    */public void setReTitle(String reTitle) {
		/* 37 */this.reTitle = reTitle;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.form.RestoreForm Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */