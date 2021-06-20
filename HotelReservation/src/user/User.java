package user;

public class User {
	private String username;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	private String address;
	private String nic;
	private String password;
	
	//Create over loaded constructor
	public User(String username, String fname, String lname, String phone, String email, String address, String nic,
			String password) {
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.nic = nic;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getNic() {
		return nic;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	
}
