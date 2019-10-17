

import org.springframework.web.client.RestTemplate;

import dev.fringe.intergration.ws.customer.login.LoginReq;
import dev.fringe.intergration.ws.customer.login.LoginRes;

public class LoginTest {

//	{
//		"username":"john@csticonsulting.com",
//		"password":"password"
//	}
	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		LoginReq req = new LoginReq();
		req.setUsername("111");
		req.setPassword("password");
//		System.out.println(template.postForObject("http://localhost:8080/api/v1/customer/login", req, LoginRes.class));
		System.out.println(template.postForObject("http://localhost:8080/api/v1/private/login", req, LoginRes.class));
		
		
	}
}
