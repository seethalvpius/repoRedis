package com.farmer.css.redisConnection.model;



import java.io.Serializable;

public class FeatureFlag implements Serializable {

    public String getFeatureFlagName() {
        return featureFlagName;
    }

    public void setFeatureFlagName(String featureFlagName) {
        this.featureFlagName = featureFlagName;
    }

    public String getFeatureFlagValue() {
        return featureFlagValue;
    }

    public void setFeatureFlagValue(String featureFlagValue) {
        this.featureFlagValue = featureFlagValue;
    }

    public String featureFlagName;
    public String featureFlagValue;
}