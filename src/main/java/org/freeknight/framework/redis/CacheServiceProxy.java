
package org.freeknight.framework.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class CacheServiceProxy
implements CacheService
{

	private JedisPool	jedisPool;

	@Override
	public void setJedisPool (
			final JedisPool jedisPool )
	{
		this.jedisPool = jedisPool;
	}

	@Override
	public void destroy ( )
	{
		if ( jedisPool != null )
		{
			jedisPool.destroy ( );
		}
	}

	@Override
	public String get (
			final String key )
	{
		final Jedis jedis = jedisPool.getResource ( );
		final String value = jedis.get ( key );
		jedis.close ( );
		System.out.println ( value );
		return null;
	}

	@Override
	public boolean set (
			final String key, final String value )
	{
		return false;
	}

}
