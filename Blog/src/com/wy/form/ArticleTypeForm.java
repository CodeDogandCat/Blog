/*    */package com.wy.form;

/*    */
/*    */public class ArticleTypeForm {
	public ArticleTypeForm() {
	}

	/* 4 */private Integer id = Integer.valueOf(-1);
	/* 5 */private String typeName = "";
	/* 6 */private String description = "";

	/*    */
	/* 8 */public String getDescription() {
		return description;
	}

	/*    */
	/*    */public void setDescription(String description) {
		/* 11 */this.description = description;
		/*    */}

	/*    */
	/* 14 */public Integer getId() {
		return id;
	}

	/*    */
	/*    */public void setId(Integer id) {
		/* 17 */this.id = id;
		/*    */}

	/*    */
	/* 20 */public String getTypeName() {
		return typeName;
	}

	/*    */
	/*    */public void setTypeName(String typeName) {
		/* 23 */this.typeName = typeName;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.form.ArticleTypeForm Java Class Version: 7 (51.0) JD-Core Version:
 * 0.7.1
 */