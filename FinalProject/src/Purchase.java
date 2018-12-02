public class Purchase{
	private String id;
	private String userId;
	private String employeeId;
	private String productId;
	private String productQuantity;
	private String date;
	private String totalPrice;
	
	public Purchase() {
		
	}
	
	public Purchase(String id, String userId, String employeeId, String productId, String productQuantity, String date, String totalPrice) {
		this.id = id;
		this.userId = userId;
		this.employeeId = employeeId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
}