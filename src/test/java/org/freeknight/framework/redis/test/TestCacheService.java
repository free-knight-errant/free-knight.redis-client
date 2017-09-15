
package org.freeknight.framework.redis.test;

import org.freeknight.framework.redis.CacheService;
import org.freeknight.framework.redis.CacheServiceProxy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestCacheService
{

	CacheService	cacheService	= new CacheServiceProxy ( );

	@Before
	public void setUp ( )
	{
		final JedisPoolConfig poolConfig = new JedisPoolConfig ( );
		// poolConfig.setBlockWhenExhausted ( blockWhenExhausted );
		// poolConfig.setEvictionPolicyClassName ( evictionPolicyClassName );
		// poolConfig.setFairness ( fairness );
		// poolConfig.setJmxEnabled ( jmxEnabled );
		// poolConfig.setJmxNameBase ( jmxNameBase );
		// poolConfig.setJmxNamePrefix ( jmxNamePrefix );
		// poolConfig.setLifo ( lifo );
		// poolConfig.setMaxIdle ( maxIdle );
		// poolConfig.setMaxTotal ( maxTotal );
		// poolConfig.setMaxWaitMillis ( maxWaitMillis );
		// poolConfig.setMinEvictableIdleTimeMillis ( minEvictableIdleTimeMillis );
		// poolConfig.setMinIdle ( minIdle );
		// poolConfig.setNumTestsPerEvictionRun ( numTestsPerEvictionRun );
		// poolConfig.setSoftMinEvictableIdleTimeMillis ( softMinEvictableIdleTimeMillis );
		// poolConfig.setTestOnBorrow ( testOnBorrow );
		// poolConfig.setTestOnCreate ( testOnCreate );
		// poolConfig.setTestOnReturn ( testOnReturn );
		// poolConfig.setTestWhileIdle ( testWhileIdle );
		// poolConfig.setTimeBetweenEvictionRunsMillis ( timeBetweenEvictionRunsMillis );

		final String host = "127.0.0.1";
		final int port = 6379;
		final JedisPool jedisPool = new JedisPool ( poolConfig, host, port );
		cacheService.setJedisPool ( jedisPool );
		System.out.println ( "JedisPool init ok!" );
	}

	@After
	public void setDown ( )
	{
		cacheService.destroy ( );
		System.out.println ( "JedisPool destroy ok!" );
	}

	@Test
	public void testGet ( )
	{
		cacheService.get ( "foo" );
	}
}
