package org.example;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class KeyTest {
    public static void main(String[] args) throws InterruptedException {
        //需要关闭linux防火墙 和修改配置文件bind和保护机制
        Jedis jedis=new Jedis("192.168.136.128",6379);
        String pong = jedis.ping();
        System.out.println("连接成功："+pong);

        jedis.set("k1", "v1");
        jedis.expire("k1", 10);
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");

        jedis.mset("str1","v1","str2","v2","str3","v3");

        Set<String> keys = jedis.keys("*");
        System.out.println(keys.size()+"条数据");
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println("-------------");
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println(jedis.ttl("k1"));
        }
        System.out.println(jedis.exists("k1"));
        System.out.println(jedis.get("k1"));

        jedis.close();
    }
}
