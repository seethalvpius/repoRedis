package com.farmer.css.redisConnection.config;

import com.farmer.css.redisConnection.controller.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableCaching
public class CacheConfiguration {
    @Value("${service.cache.url}")
    private String redisUrl;
    private static final Logger logger = LoggerFactory.getLogger(CacheConfiguration.class);
    private ResponseHandler responseHandler = new ResponseHandler();


    @Bean
    public JedisPool jedisPool() {
        if(redisUrl==null || redisUrl.isEmpty())
            return null;
        JedisPool jedisPool = null;
        try {
            URI redisUri = new URI(redisUrl);
            jedisPool = new JedisPool(new JedisPoolConfig(), redisUri);
        } catch (URISyntaxException error) {
            logger.error("Error creating redis pool");
            responseHandler.constructURIExceptionResponse(error.getMessage());
        }
        return jedisPool;
    }
}