package Entity;

import java.util.Date;

public class Seller {
	private String sellerId;
	private String Address;
	private Date date;

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

	public String getBrokerId() {
		return brokerId;
	}
	public String getSellerId() {
		return sellerId;
	}
}
