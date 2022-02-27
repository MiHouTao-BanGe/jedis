package org.pubsub;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SubListenTest {
    public static void main(String[] args) {
        // 替换成你的reids地址和端口
        String redisIp = "192.168.136.128";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

        SubThread subThread = new SubThread(jedisPool);
        subThread.run();//在idea里面不要把发布订阅放在同一个main方法里面（订阅在main方法里面新起一个线程也可以） 发布和订阅最好工作在两个线程
    }
}
