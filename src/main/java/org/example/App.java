package org.example;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //jedis的方法名基本与redis命令类似
        //需要关闭linux防火墙 和修改配置文件bind和保护机制
        Jedis jedis=new Jedis("192.168.136.129",6379);
        //jedis.auth("a534772349");
        String pong = jedis.ping();
        System.out.println("连接成功："+pong);
        jedis.close();

    }
}
