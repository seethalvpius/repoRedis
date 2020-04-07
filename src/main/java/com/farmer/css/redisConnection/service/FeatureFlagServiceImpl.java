package com.farmer.css.redisConnection.service;
import com.farmer.css.redisConnection.controller.ResponseHandler;
import com.farmer.css.redisConnection.model.FeatureFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import org.springframework.stereotype.Service;
import com.farmer.css.redisConnection.service.FeatureFlagService;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class FeatureFlagServiceImpl implements FeatureFlagService{


    private static final Logger logger = LoggerFactory.getLogger(FeatureFlagServiceImpl.class);
    private ResponseHandler responseHandler = new ResponseHandler();


    @Autowired(required = false)
    private JedisPool jedisPool;

    public void setConfigurationProperties(byte[] key, byte[] value) {
        if (jedisPool == null) {
            logger.info("CACHE: JedisPool is null");
            return;
        }
        try (Jedis jedis = jedisPool.getResource()) {
            String result = jedis.set(key, value);

            logger.info("CACHE: Key {} & Value {}", key, value);
        } catch(JedisConnectionException exception)
        {
            logger.error("CACHE: Exception {} on storing Key {} & Value {} to redis", exception.getMessage(), key, value);
            responseHandler.constructGenericExceptionResponse(exception.getMessage());
        }
        catch (JedisException exception)
        {
            logger.error("CACHE: Exception {} on storing Key {} & Value {} to redis", exception.getMessage(), key, value);
            responseHandler.constructGenericExceptionResponse(exception.getMessage());
        }catch (Exception exception) {
            logger.error("CACHE: Exception {} on storing Key {} & Value {} to redis", exception.getMessage(), key, value);
            responseHandler.constructGenericExceptionResponse(exception.getMessage());

        }
    }

    public List<FeatureFlag> getConfigurationProperties() {
        Set<String> keys = null;
        List<FeatureFlag> allfeatureFlagList = new ArrayList<>();

        if (jedisPool == null) {
            logger.info("CACHE:  JedisPool is null");
            return null;
        }
        try (Jedis jedis = jedisPool.getResource()) {
             keys = jedis.keys("*");
            if (keys != null && keys.size() > 0) {
                System.out.println(keys);
                for (String key : keys) {
                    FeatureFlag featureFlag = new FeatureFlag();
                    featureFlag.setFeatureFlagName(key);
                    featureFlag.setFeatureFlagValue(jedis.get(key));
                    allfeatureFlagList.add(featureFlag);
                }
            }
        } catch (Exception exception) {
           logger.error("CACHE: Exception  on retrieving value");
        }
        return allfeatureFlagList;
    }

    //code to retreive values

}