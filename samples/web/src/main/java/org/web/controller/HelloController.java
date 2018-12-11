package org.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.web.User;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam String name,@PathVariable Integer id) {
		logger.info("用户请求....,获取用户：{} ,ID：{}.", name, id);
		User user = new User();
		user.setName("哈哈123");
		user.setNickName("坏哭了");
		user.setAge(15);
		user.setAddress("北京-朝阳区-朝来科技园");
		return user;
	}
	
	
}
