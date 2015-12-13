package net.shawshank.blog.test;

import java.io.IOException;
import java.io.Reader;

import junit.framework.TestCase;
import net.shawshank.blog.entity.sys.User;
import net.shawshank.blog.service.sys.UserService;
import net.shawshank.blog.util.UuidUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser extends TestCase{
	
	
	ClassPathXmlApplicationContext ctx = null;

	public ApplicationContext getContext() {
		if (null == ctx) {
			ctx = new ClassPathXmlApplicationContext(new String[] {
					"classpath:spring/ApplicationContext.xml"});
		}
		return ctx;
	}
	
	private UserService userService;

	public void testUserForAdd(){
		userService = (UserService)new TestUser().getContext().getBean(
				"userService");
		
		try {
			User user=new User();
			//user.setUSER_ID(UuidUtil.get32UUID());
			user.setUSERNAME("linxiaosheng");
			user.setPASSWORD("2222222222");
			//userService.save(user);
			User user2=userService.getUserByNameAndPwd(user);
			System.out.println(user.getUSERNAME());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
