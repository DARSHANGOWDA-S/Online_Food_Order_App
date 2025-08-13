package com.orderapp.Online_Order_App.service;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
	
    User createUser(User user);
	
	User getUser(Integer id);
	
	List<User> getAllUsers();
	
	User updateUser(User user,Integer id);
	
	void deleteUser(Integer id);
	
	String uploadImage(MultipartFile file,Integer id) throws IOException;
	
	byte[] getImage(Integer id);

	

}
