package Entity;

import java.util.Date;

public class Seller {
	private String sellerId;
	private String Address;
	private Date date;
	private String condition;
	private int Price;
	private String brokerId;
	
	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void setPrice(int Price) {
		this.Price = Price;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getBrokerId() {
		return brokerId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public String getCondition() {
		return condition;
	}
	public int getPrice() {
		return Price;
	}
}
