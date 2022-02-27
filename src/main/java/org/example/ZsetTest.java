package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class ZsetTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.136.128",6379);
        String pong = jedis.ping();
        System.out.println("连接成功："+pong);

        jedis.zadd("zset01", 100, "z3");
        jedis.zadd("zset01", 90d, "l4");//d是转double的意思 还有f l
        jedis.zadd("zset01", 80d, "w5");
        jedis.zadd("zset01", 70d, "z6");
        Set<String> zrange = jedis.zrange("zset01", 0, -1);


        for (String e : zrange) {
            System.out.println(e);
        }
        System.out.println("================");
        Set<Tuple> zset01 = jedis.zrangeWithScores("zset01", 0, -1);
        for (Tuple e : zset01) {
            System.out.println(e);
        }

        jedis.close();
    }
}
