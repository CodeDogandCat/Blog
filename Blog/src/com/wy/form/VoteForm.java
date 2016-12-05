/*    */package com.wy.form;

/*    */
/*    */public class VoteForm {
	public VoteForm() {
	}

	/* 4 */Integer id = Integer.valueOf(-1);
	/*    */
	/* 6 */String voteName = null;
	/* 7 */String voteTime = null;
	/* 8 */String voteContent = null;

	/*    */
	/*    */public Integer getId() {
		/* 11 */return id;
		/*    */}

	/*    */
	/*    */public void setId(Integer id) {
		/* 15 */this.id = id;
		/*    */}

	/*    */
	/*    */public String getVoteName() {
		/* 19 */return voteName;
		/*    */}

	/*    */
	/*    */public void setVoteName(String voteName) {
		/* 23 */this.voteName = voteName;
		/*    */}

	/*    */
	/*    */public String getVoteContent() {
		/* 27 */return voteContent;
		/*    */}

	/*    */
	/*    */public void setVoteContent(String voteContent) {
		/* 31 */this.voteContent = voteContent;
		/*    */}

	/*    */
	/*    */public String getVoteTime() {
		/* 35 */return voteTime;
		/*    */}

	/*    */
	/*    */public void setVoteTime(String voteTime) {
		/* 39 */this.voteTime = voteTime;
		/*    */}
	/*    */
}

/*
 * Location: D:\workspace\javaee\Blog\WebContent\WEB-INF\classes Qualified Name:
 * com.wy.form.VoteForm Java Class Version: 7 (51.0) JD-Core Version: 0.7.1
 */