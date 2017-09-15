
package org.freeknight.framework.redis;

import redis.clients.jedis.JedisPool;

public interface CacheService
{

	void setJedisPool (
			JedisPool jedisPool );

	void destroy ( );

	String get (
			String key );

	boolean set (
			String key, String value );
}
