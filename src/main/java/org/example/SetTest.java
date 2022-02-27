package org.example;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class SetTest {
    public static void main(String[] args) throws InterruptedException {
        //需要关闭linux防火墙 和修改配置文件bind和保护机制
        Jedis jedis=new Jedis("192.168.136.128",6379);
        String pong = jedis.ping();
        System.out.println("连接成功："+pong);

        jedis.sadd("orders", "order01","order05");
        jedis.sadd("orders", "order02");
        jedis.sadd("orders", "order03");
        jedis.sadd("orders", "order04");
        Set<String> smembers = jedis.smembers("orders");
        for (String order : smembers) {
            System.out.println(order);
        }
        jedis.srem("orders", "order02");//删除order02
        smembers = jedis.smembers("orders");
        System.out.println("==================");
        for (String order : smembers) {
            System.out.println(order);
        }
        jedis.close();
    }
}
