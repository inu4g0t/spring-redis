package org.inu4g0t.com.spirng_redis.dao.interfaces;

import java.util.List;

import org.inu4g0t.com.spirng_redis.dao.User;

public interface UserDaoInterface {
	public void add(User user);

	public void add(List<User> users);
	
	User get(String keyId); 
}
