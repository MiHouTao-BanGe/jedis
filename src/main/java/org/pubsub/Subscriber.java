package org.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.io.IOException;


public class Subscriber extends JedisPubSub {
        public Subscriber() {
        }

        public void onMessage(String channel, String message) {
            System.out.println(channel+"+++++++++++"+message);
        }

        public void onSubscribe(String channel, int subscribedChannels) {
            System.out.println(channel+"=============="+subscribedChannels);
        }

        public void onUnsubscribe(String channel, int subscribedChannels) {
            System.out.println(channel+"-----------"+subscribedChannels);

        }

    }

