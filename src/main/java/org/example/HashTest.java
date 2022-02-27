package org.example;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashTest {
    public static void main(String[] args) {
        //需要关闭linux防火墙 和修改配置文件bind和保护机制
        Jedis jedis=new Jedis("192.168.136.128",6379);
        String pong = jedis.ping();
        System.out.println("连接成功："+pong);

        jedis.hset("hash1","userName","lisi");
        System.out.println(jedis.hget("hash1","userName"));
        Map<String,String> map = new HashMap<String,String>();
        map.put("telphone","13810169999");
        map.put("address","atguigu");
        map.put("email","abc@163.com");
        jedis.hmset("hash2",map);
        List<String> result = jedis.hmget("hash2", "telphone","email");
        for (String element : result) {
            System.out.println(element);
        }
        System.out.println("================");
        Set<String> hash2 = jedis.hkeys("hash2");
        for(String item:hash2){
           System.out.println(item);
        }

        System.out.println("================");
        List<String> hash21 = jedis.hvals("hash2");
        for(String item:hash21){
            System.out.println(item);
        }
        jedis.close();
    }
}
