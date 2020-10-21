package sakila.vo;

import java.sql.Blob;

public class Staff {
	//11개의 필드(속성, 멤버변수)
	private int staffId;
	private String firstName;
	private String lastName;
	private int addressId;
	private Blob picture;
	private String email;
	private int storeId;
	private int active;
	private String username;
	private String password;
	private String last_update;
	//tostring 메서드 오버라이딩
}
