package shopnoithat.Entity;

public class Users {
	private long id;
	private boolean idRoles;
	
	//@NotBlank(message = "Không được để trống!")
	private String user;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;

	public Users() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isIdRoles() {
		return idRoles;
	}

	public void setIdRoles(boolean idRoles) {
		this.idRoles = idRoles;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
