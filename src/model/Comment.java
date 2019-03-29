package model;
//コメント
public class Comment {
		private int id;
		private String comment;
		private String userId;
		private String threadId;
		private String createDate;

		private String name;


		public Comment(int id ,String comment ,String userId ,String threadId,String createDate, String name) {
			this.id = id;
			this.comment = comment;
			this.userId = userId;
			this.threadId = threadId;
			this.createDate = createDate;
			this.name=name;
		}




		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getThreadId() {
			return threadId;
		}
		public void setThreadId(String threadId) {
			this.threadId = threadId;
		}
		public String getCreateDate() {
			return createDate;
		}
		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}




		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

}

//	public String getFormatDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
//		return sdf.format(createDate);
//	}