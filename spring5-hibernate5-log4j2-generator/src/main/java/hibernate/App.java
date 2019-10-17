package hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

import hibernate.model.Category;
import hibernate.model.Item;
import hibernate.model.Product;
import hibernate.model.User;
import hibernate.service.CategoryService;
import hibernate.service.ItemService;
import hibernate.service.LineItemService;
import hibernate.service.OrderService;
import hibernate.service.ProductService;
import hibernate.service.SupplierService;
import hibernate.service.UserService;
import lombok.extern.log4j.Log4j2;


@ImportResource(value = { "classpath:context.xml" })
@Log4j2
public class App {
	
	@Autowired private UserService userService;
	@Autowired private CategoryService categoryService;
	@Autowired private ProductService productService;
	@Autowired private SupplierService supplierService;
	@Autowired private ItemService itemService;
	@Autowired private OrderService orderService;
	@Autowired private LineItemService lineitemService;
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(App.class).getBean(App.class).run();
	}

	private void run() {
//		userService.save(); 
//		categoryService.save();
//		productService.save();
//		supplierService.save();
//		itemService.save();
		System.out.println(userService.select(null));
		System.out.println(userService.selectCount());
//		List<Category> categories = categoryService.list();
//		List<Product> products = productService.getByCategoryId(categories.get(0));
//		List<Item> items = itemService.getByProductId(products.get(0));
//		log.info(items.get(0));
//		List<Item> items2 = itemService.getByItemname("na");
//		log.info(items2);
//		User user = userService.login("dev.fringe@gmail.com","password"); 
//		if(user != null) {
//			Item item = itemService.get(1);
//			System.out.println(item);
//			orderService.order(user.getEmail(), item, 1);
//		}
	}
}