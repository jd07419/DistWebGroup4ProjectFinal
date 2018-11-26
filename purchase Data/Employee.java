
public class Employee {
	private String id;
	private String firstname;
	private String lastname;
	private String status;
	
	public Employee() {
	}
	
	public Employee(String id, String firstname, String lastname, String status) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
