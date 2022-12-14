package Entity;

import java.util.Vector;

public class Building {
	private String Address;
	private int CompletionTime;
	private String Shape;
	private Long SellPrice;
	private String condition;
	private String Company;
	private String BrokerId;
	private String SellerId;
	private Seller seller = new Seller();
	private int BuildingNum;
	public void setBuildingNum(int BuildingNum) {
		this.BuildingNum = BuildingNum;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void setShape(String Shape) {
		this.Shape = Shape;
	}
	public void setCompletionTime(int CompletionTime) {
		this.CompletionTime = CompletionTime;
	}
	public void setSellPrice(Long SellPrice) {
		this.SellPrice = SellPrice;
	}
	public void setBrokerId(String BrokerId) {
		this.BrokerId = BrokerId;
	}
	public void setSellerId(String SellerId) {
		this.SellerId = SellerId;
	}
	public void setCompany(String Company) {
		this.Company = Company;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getBuildingNum() {
		return BuildingNum;
	}
	public String getCondition() {
		return condition;
	}
	public Seller getSeller() {
		return seller;
	}
	public String getShape() {
		return Shape;
	}
	public String getAddress() {
		return Address;
	}
	public Long getSellPrice() {
		return SellPrice;
	}
	public int getCompletionTime() {
		return CompletionTime;
	}
	public String getCompany() {
		return Company;
	}
}
