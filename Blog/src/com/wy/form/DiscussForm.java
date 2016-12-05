/*    */package com.wy.form;

/*    */
/*    */public class DiscussForm {
	/* 4 */private Integer id = Integer.valueOf(-1);
	/* 5 */private String discussTitle = null;
	/* 6 */private String discussContent = null;
	/* 7 */private String discussTime = null;

	/*    */
	/*    */public DiscussForm() {
	}

	/*    */
	/* 11 */public String getDiscussContent() {
		return discussContent;
	}

	/*    */
	/*    */public void setDiscussContent(String discussContent) {
		/* 14 */this.discussContent = discussContent;
		/*    */}

	/*    */
	/* 17 */public String getDiscussTime() {
		return discussTime;
	}

	/*    */
	/*    */public void setDiscussTime(String discussTime) {
		/* 20 */this.discussTime = discussTime;
		/*    */}

	/*    */
	/* 23 */public String getDiscussTitle() {
		return discussTitle;
	}

	/*    */
	/*    */public void setDiscussTitle(String discussTitle) {
		/* 26 */this.discussTitle = discussTitle;
		/*    */}

	/*    */
	/* 29 */public Integer getId() {
		return id;
	}

	/*    */
	/*    */public void setId(Integer id) {
		/* 32 */this.id = id;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.form.DiscussForm Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */