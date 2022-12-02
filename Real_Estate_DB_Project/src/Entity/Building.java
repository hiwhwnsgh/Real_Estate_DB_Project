package Entity;

public class Building {
	private String Address;
	private int CompletionTime;
	private String Shape;
	private int SellPrice;
	private String Company;
	private String BrokerId;
	private String SellerId;
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void setShape(String Shape) {
		this.Shape = Shape;
	}
	public void setCompletionTime(int CompletionTime) {
		this.CompletionTime = CompletionTime;
	}
	public void setSellPrice(int SellPrice) {
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
	public String getShape() {
		return Shape;
	}
	public String getAddress() {
		return Address;
	}
}
