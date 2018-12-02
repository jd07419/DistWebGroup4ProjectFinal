

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;


@WebServlet("/FinalServlet")
public class FinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String templateDir = "/WEB-INF/templates";
	private static TemplateProcessor processor;

    public FinalServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	processor = new TemplateProcessor(templateDir, getServletContext());
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empBtn = request.getParameter("empBtn");
		String prodBtn = request.getParameter("prodBtn");
		String disBtn = request.getParameter("disBtn");
		String addProduct = request.getParameter("addProduct");
		String purBtn = request.getParameter("purBtn");
		String storeBtn = request.getParameter("storeBtn");
		String addEmp = request.getParameter("addEmployee");
		
		if(empBtn != null) {
			showEmployees(request, response);
		}
		
		if(prodBtn != null) {
			showProducts(request, response);
		}
		
		if(disBtn != null) {
			showDiscounts(request, response);
		}
		
		if(addProduct != null) {
			addProduct(request, response);
		}
		
		if(purBtn != null) {
			showPurchases(request, response);
		}
		
		if(storeBtn != null) {
			showStores(request, response);
		}
		if(addEmp != null) {
			addEmpToPurchase(request, response);
		}
		
		
	}
	
	private void addEmpToPurchase(HttpServletRequest request, HttpServletResponse response) {
		String addEmp = request.getParameter("addEmployee");
		DbAccessImpl.selectDriver(addEmp);
		
	}
	
	private void generatePurchaseReceipt(HttpServlet request, HttpServletResponse response) {
		String currentUser = request.getParameter("userInjection");
		String totalPrice = request.getParameter("priceInjection");
		DbAccessImpl.checkOut(currentUser, totalPrice);
	}

	private void showStores(HttpServletRequest request, HttpServletResponse response) {
		ResultSet rs = DbAccessImpl.retrieveStores();
		List<Store> slist = new ArrayList<>();
		try {
			while(rs.next()) {
				Store s = new Store();
				s.setId(rs.getString("stores.id"));
				s.setName(rs.getString("stores.name"));
				s.setAddress(rs.getString("stores.address"));
				slist.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String templateName = "storePage.ftl";
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
		SimpleHash root = new SimpleHash(db.build());
		root.put("stores", slist);
		processor.processTemplate(templateName, root, request, response);
	}

	private void showPurchases(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entered showPurchases");
		ResultSet rs = DbAccessImpl.retrievePurchases();
		List<PurchasesList> purList = new ArrayList<>();
		try {
			while(rs.next()) {
				PurchasesList pl = new PurchasesList();
				pl.setId(rs.getString("id"));
				pl.setFirstname(rs.getString("emp_first"));
				pl.setLastname(rs.getString("emp_last"));
				pl.setUsername(rs.getString("username"));
				pl.setTotalPrice(rs.getString("total_price"));
				pl.setTimeStamp(rs.getString("date"));
				purList.add(pl);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String templateName = "purchasesPage.ftl";
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
		SimpleHash root = new SimpleHash(db.build());
		root.put("purchases_list", purList);
		processor.processTemplate(templateName, root, request, response);
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("productName");
		String price = request.getParameter("productPrice");
		DbAccessImpl.addProduct(name, price);		
	}
	
	private void showDiscounts(HttpServletRequest request, HttpServletResponse response) {
		ResultSet rs = DbAccessImpl.retrieveDiscounts();
		List<Discount> dlist = new ArrayList<>();
		try {
			while(rs.next()) {
				Discount d = new Discount();
				d.setId(rs.getString("id"));
				d.setProductId(rs.getString("product_id"));
				d.setName(rs.getString("name"));
				d.setPercentOff(rs.getString("percent_off"));
				d.setDescription(rs.getString("description"));
				dlist.add(d);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String templateName = "discountPage.ftl";
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
		SimpleHash root = new SimpleHash(db.build());
		root.put("discounts", dlist);
		processor.processTemplate(templateName, root, request, response);
	}

	private void showProducts(HttpServletRequest request, HttpServletResponse response) {
		ResultSet rs = DbAccessImpl.retrieveProducts();
		List<Product> plist = new ArrayList<>();
		try {
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getString("price"));
				plist.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		String templateName = "prodPage.ftl";
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
		SimpleHash root = new SimpleHash(db.build());
		root.put("products", plist);
		processor.processTemplate(templateName, root, request, response);
	}

	private void showEmployees(HttpServletRequest request, HttpServletResponse response) {
		ResultSet rs = DbAccessImpl.retrieveEmployees();
		List<Employee> elist = new ArrayList<>();
		try {
			while(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getString("id"));
				e.setFirstname(rs.getString("firstname"));
				e.setLastname(rs.getString("lastname"));
				elist.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		String templateName = "empPage.ftl";
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
		SimpleHash root = new SimpleHash(db.build());
		root.put("employees", elist);
		processor.processTemplate(templateName, root, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
