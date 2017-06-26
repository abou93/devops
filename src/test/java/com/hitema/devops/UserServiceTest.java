package com.hitema.devops;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hitema.devops.config.Utils;
import com.hitema.devops.dto.User;
import com.hitema.devops.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Mock
	UserService userService;
	@Value("${user.id}")
	private String id;
	@Value("${user.pwd}")
	private String pwd;
	
	public void setup() throws Exception{
		User user = getUser();
		Mockito.when(userService.createUser(user)).thenReturn(1);
		Mockito.when(userService.getUserByPseudoOrMailAndPassword(user.getPseudo(), user.getPassword())).thenReturn(user);
		Mockito.when(userService.getUserByPseudoOrMailAndPassword(user.getMail(), user.getPassword())).thenReturn(user);
		
	}
	
	@Test
	public void userCrud() throws Exception{
		createUserTest();
		getUserByPseudoAndPasswordTest();
		getUserByMailAndPasswordTest();
	}
	
	public void createUserTest() throws Exception{
		int result = userService.createUser(getUser());
		assertEquals(1, result);
	}

	public void getUserByPseudoAndPasswordTest() throws Exception{
		User user = getUser();
		User result = userService.getUserByPseudoOrMailAndPassword(user.getPseudo(), user.getPassword());
		assertEquals(user.getMail(), result.getMail());
		assertEquals(user.getPseudo(), result.getPseudo());
		assertEquals(user.getPassword(), result.getPassword());
	}

	public void getUserByMailAndPasswordTest() throws Exception{
		User user = getUser();
		User result = userService.getUserByPseudoOrMailAndPassword(user.getMail(), user.getPassword());
		assertEquals(user.getMail(), result.getMail());
		assertEquals(user.getPseudo(), result.getPseudo());
		assertEquals(user.getPassword(), result.getPassword());
	}

	private User getUser() throws Exception {
		String password = Utils.encode(pwd);
		return new User("aderess.mail@example.com", "pseudo", password);
	}
}
