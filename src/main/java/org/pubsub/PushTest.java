package org.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

public class PushTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        // 替换成你的reids地址和端口
        String redisIp = "192.168.136.128";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

        //如果在同一main方法里面 最好给subThread一个单独的线程 不然数据发不出去
//           SubThread subThread = new SubThread(jedisPool);
//           subThread.start();
//           Publisher publisher = new Publisher(jedisPool);
//           publisher.start();  //这个start是自定义的方法

        //Jedis sub = jedisPool.getResource();
        //sub.subscribe(new Subscriber(), "mychannel");
        Jedis pub = jedisPool.getResource();
        pub.publish("tb", "9999");
    }
}
