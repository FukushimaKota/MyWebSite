package model;

//記事
public class Thread {
	private int id;
	private String tittle;
	private String text;
	private String userId;
	private String createDate;


	//全てのデータをセットするコンストラクタ
	public Thread(int id ,String tittle ,String text ,String userId ,String createDate) {
		this.id = id;
		this.tittle = tittle;
		this.text = text;
		this.userId = userId;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
