package Entity;

public class Broker {
	private String BrokerId;
	private String Name;
	private int count;
	private String Address;
	private String PhoneNumber;
	@Override
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	public void setBrokerId(String BrokerId) {
		this.BrokerId = BrokerId;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return Name;
	}
	public String getPhoneNumber(){
		return PhoneNumber;
	}
	public String getAddress() {
		return Address;
	}
}
