
public class Discount {
	private String id;
	private String name;
	private String productId;
	private String description;
	private String percentOff;
	
	public Discount() {
		
	}
	
	public Discount(String id, String name, String productId, String description, String percentOff) {
		this.id = id;
		this.name = name;
		this.productId = productId;
		this.description = description;
		this.percentOff = percentOff;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPercentOff() {
		return percentOff;
	}

	public void setPercentOff(String percentOff) {
		this.percentOff = percentOff;
	}

}
