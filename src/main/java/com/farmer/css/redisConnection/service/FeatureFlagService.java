package com.farmer.css.redisConnection.service;
import com.farmer.css.redisConnection.model.FeatureFlag;
import com.farmer.css.redisConnection.model.TransactionNotification;
import java.util.List;

public interface FeatureFlagService {

    public void setConfigurationProperties(byte[] key, byte[] value);
    public List<FeatureFlag> getConfigurationProperties();

}

