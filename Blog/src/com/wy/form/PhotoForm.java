/*    */package com.wy.form;

/*    */
/*    */public class PhotoForm {
	public PhotoForm() {
	}

	/* 4 */private Integer id = Integer.valueOf(-1);
	/* 5 */private String photoAddress = "";
	/* 6 */private String photoDescription = "";
	/* 7 */private String phtoTime = "";

	/*    */
	/* 9 */public Integer getId() {
		return id;
	}

	/*    */
	/*    */public void setId(Integer id) {
		/* 12 */this.id = id;
		/*    */}

	/*    */
	/* 15 */public String getPhotoAddress() {
		return photoAddress;
	}

	/*    */
	/*    */public void setPhotoAddress(String photoAddress) {
		/* 18 */this.photoAddress = photoAddress;
		/*    */}

	/*    */
	/* 21 */public String getPhotoDescription() {
		return photoDescription;
	}

	/*    */
	/*    */public void setPhotoDescription(String photoDescription) {
		/* 24 */this.photoDescription = photoDescription;
		/*    */}

	/*    */
	/* 27 */public String getPhtoTime() {
		return phtoTime;
	}

	/*    */
	/*    */public void setPhtoTime(String phtoTime) {
		/* 30 */this.phtoTime = phtoTime;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.form.PhotoForm Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */