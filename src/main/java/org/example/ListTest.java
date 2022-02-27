package org.example;

import redis.clients.jedis.Jedis;

import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //需要关闭linux防火墙 和修改配置文件bind和保护机制
        Jedis jedis=new Jedis("192.168.136.128",6379);
        String pong = jedis.ping();
        System.out.println("连接成功："+pong);
        for(int i=0;i<5000;i++){
            jedis.lpush("mylist", "1", "2", "3");
        }
        List<String> list = jedis.lrange("mylist",0,-1);
        for (String element : list) {
            System.out.println(element);
        }
        System.out.println("=================");
        System.out.println(jedis.lindex("mylist",0));
        jedis.close();
    }
}
