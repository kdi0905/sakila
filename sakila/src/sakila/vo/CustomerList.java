package sakila.vo;

public class CustomerList {
	private int ID;
	private String name;
	private String address;
	private String phone;
	private String city;
	private String country;
	private String notes;
	private String overdue;
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "CustomerList [ID=" + ID + ", name=" + name + ", address=" + address + ", phone=" + phone + ", city="
				+ city + ", country=" + country + ", notes=" + notes + ", overdue=" + overdue + "]";
	}
	
	
}
