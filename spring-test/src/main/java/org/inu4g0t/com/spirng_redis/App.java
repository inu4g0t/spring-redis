package org.inu4g0t.com.spirng_redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.inu4g0t.com.spirng_redis.dao.User;
import org.inu4g0t.com.spirng_redis.service.AddUserService;

/**
 * Hello world!
 *
 */
public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// loading the definitions from the given XML file
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		AddUserService service = (AddUserService) context
				.getBean("addUserService");
		User zhangsan = (User)context.getBean("zhangsan");
		User lisi = (User)context.getBean("lisi");
		
		//service.addUser(zhangsan);
		service.getUserFromRedis(zhangsan.getName());
		
//		HelloWorldService service = (HelloWorldService) context
//				.getBean("helloWorldService");
//		String message = service.sayHello();
//		System.out.println(message);
//
//		// set a new name
//		service.setName("Spring");
//		message = service.sayHello();
//		System.out.println(message);
	}
}
