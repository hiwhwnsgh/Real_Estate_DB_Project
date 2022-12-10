package Entity;

public class User {
	public String uid;
	private String password;
	private String hopeCity;
	private int Price;
	private String condition;
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setHopeCity(String hopeCity){
		this.hopeCity = hopeCity;
	}
	public void setPrice(int Price) {
		this.Price = Price;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getUid() {
		return uid;
	}

}
