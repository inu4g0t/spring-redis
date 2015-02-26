package org.inu4g0t.com.spirng_redis.dao.impl;

import java.util.List;

import org.inu4g0t.com.spirng_redis.dao.User;
import org.inu4g0t.com.spirng_redis.dao.interfaces.UserDaoInterface;
import org.inu4g0t.com.spirng_redis.dao.redis.AbstractBaseRedisDao;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

public class UserDaoRedisImpl extends AbstractBaseRedisDao<String, User> implements
		UserDaoInterface {

	public void add(User user) {
		redisTemplate.opsForValue().set(user.getName(), user);
	}

	public void add(final List<User> users) {
		redisTemplate.executePipelined(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                for (User user : users) {  
                    byte[] key  = serializer.serialize(user.getID());  
                    byte[] name = serializer.serialize(user.getName());  
                    connection.setNX(key, name);  
                }  
                return true;  
            } 
		});
	}

	public User get(String keyId) {
		return redisTemplate.opsForValue().get(keyId);
	}

	
	
}
