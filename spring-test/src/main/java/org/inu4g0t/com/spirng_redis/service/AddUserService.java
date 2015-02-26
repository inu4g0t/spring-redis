package org.inu4g0t.com.spirng_redis.service;

import org.inu4g0t.com.spirng_redis.dao.User;
import org.inu4g0t.com.spirng_redis.dao.interfaces.UserDaoInterface;
import org.springframework.stereotype.Service;

@Service("addUserService")
public class AddUserService {
	
	UserDaoInterface userDao;
	
	public void setUserDao(UserDaoInterface userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user){
		userDao.add(user);
	}
	
	public void getUserFromRedis(String key){
		System.out.println(userDao.get(key).selfIntro());
	}

}
