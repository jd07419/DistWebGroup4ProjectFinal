import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccessImpl {
	
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DbAccessConfiguration.url, DbAccessConfiguration.username, DbAccessConfiguration.password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static ResultSet retrieveDiscounts() {
		Connection con = connect();
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from discounts";
			rs = stmt.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet retrieveProducts() {
		Connection con = connect();
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from products";
			rs = stmt.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet retrieveEmployees() {
		Connection con = connect();
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from employees";
			rs = stmt.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int addProduct(String prodName, String prodPrice) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert in to products(name, price) values('"+prodName+"', "+prodPrice+")";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("addProduct: success");
			}else {
				System.out.println("addProduct: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;		
	}

	public static int updateProduct(String prodCol, String prodData, String productId) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = null;
			if(prodCol.equals("name")) {
				sql = "update products set "+prodCol+" = '"+prodData+"' where id = "+productId+";";
			}else {
				sql = "update products set "+prodCol+" = "+prodData+" where id ="+productId+";";
			}			
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("updateProduct: success");
			}else {
				System.out.println("updateProduct: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;		
	}

	public static int deleteProduct(String deleteProduct) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "delete from products where products.id = "+deleteProduct+";";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.print("deleteProduct: success");
			}else {
				System.out.println("deleteProduct: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;		
	}
	
	public static int addEmployee() {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into employees(firstname, lastname)";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.print("addEmployee: success");
			}else {
				System.out.println("addEmployee: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;		
	}

	
	public static int updateEmployee(String empCol, String empData, String empId) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "update employees set "+empCol+" = "+empData+" where employees.id = "+empId+";";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.print("updateEmployee: success");
			}else {
				System.out.println("updateEmployee: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;		
	}

	
	public static int deleteEmployee(String deleteEmployee) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "delete from employees where employees.id = "+deleteEmployee+";";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.print("deleteEmployee: success");
			}else {
				System.out.println("deleteEmployee: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;		
	}
	
	public static int addDiscount(String disName, String productId, String desc, String percOff) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into discounts(name, product_id, description, percent_off) values('"+disName+"', "+productId+", '"+desc+"', "+percOff+");";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("addDiscount: success");
			}else {
				System.out.println("addDiscount: failure");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 1;
	}
	
	public static int updateDiscount(String disCol, String disData, String discountId) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = null;
			if(disCol.equals("name")||disCol.equals("description")) {
				sql  = "update discount set "+disCol+" = '"+disData+"' where discount.id = "+discountId+";";
			}else {
				sql = "update discount set "+disCol+" = "+disData+" where discount.id = "+discountId+";";
			}
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("updateDiscount: success");
			}else {
				System.out.println("updateDiscount: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;		
	}
	
	public static int deleteDiscount(String discountId) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql  = "delete from discount where discount.id = "+discountId+";";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("deleteDiscount: success");
			}else {
				System.out.println("deleteDiscount: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public static ResultSet retrievePurchases() {
		Connection con = connect();
		ResultSet rs = null;
		System.out.println("retrievePurchases: connected");
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from purchases_list";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			System.out.println("retrievedPurchases, executeQuery: complete");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet retrieveStores() {
		Connection con = connect();
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from stores";
			rs = stmt.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static int selectDriver(String addEmp) {
	Connection con = connect();
	try {
		Statement stmt = con.createStatement();
		String sql = "insert into purchases_list(emp_first, emp_last)"
				+ " values((select firstname from employees where id = "+addEmp+"),"
						+ " (select lastname from employees where id = "+addEmp+"));";
		int i = stmt.executeUpdate(sql);
		if(i>0) {
			System.out.println("selectDriver: success");
		}else {
			System.out.println("selectDriver: failure");
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return 1;
	}
	
	public static int checkOut(String currentUser, String totalPrice) {
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into purchases_list(username, total_price, date) values((select username from users where username = "+currentUser+"), "+totalPrice+", (select current_timestamp))";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("checkOut: success");
			}else {
				System.out.println("checkOut: failure");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
