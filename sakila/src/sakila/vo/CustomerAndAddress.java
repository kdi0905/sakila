package sakila.vo;



public class CustomerAndAddress {
	private int customerId;
	private String FirstName;
	private String LastName;
	private int active;
	private String address;
	private String phone;
	private String check;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "CustomerAndAddress [customerId=" + customerId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", active=" + active + ", address=" + address + ", phone=" + phone + ", check=" + check + "]";
	}
	
	
}
