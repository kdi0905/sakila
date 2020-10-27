package sakila.vo;

public class Country {
	private int countryId;
	private String country;
	private String last_update;
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "country [countryId=" + countryId + ", country=" + country + ", last_update=" + last_update + "]";
	}
	
}
