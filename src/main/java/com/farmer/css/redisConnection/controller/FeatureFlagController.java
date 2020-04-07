package com.farmer.css.redisConnection.controller;

import com.farmer.css.redisConnection.model.FeatureFlag;
import com.farmer.css.redisConnection.model.TransactionNotification;
import com.farmer.css.redisConnection.service.FeatureFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.farmer.css.redisConnection.controller.ResponseHandler;



import java.util.List;


@RestController
public class FeatureFlagController {

    @Autowired
    private FeatureFlagService featureFlagService;
    private ResponseHandler responseHandler = new ResponseHandler();


    @PostMapping
    @RequestMapping("/setFeatureFlag")
    public TransactionNotification setConfiguration (@RequestBody FeatureFlag featureFlag){
        try {
            featureFlagService.setConfigurationProperties(featureFlag.getFeatureFlagName().getBytes(), featureFlag.getFeatureFlagValue().getBytes());
            return responseHandler.constructSucessResponse();
        }catch(Exception exception){
            responseHandler.constructGenericExceptionResponse(exception.getMessage());
        }
        return null;
    }

    @GetMapping("/getAllFeatureFlags")
    public List<FeatureFlag> getConfiguration () {
        List<FeatureFlag> valueAsBytes = featureFlagService.getConfigurationProperties();
        System.out.println(valueAsBytes);
        return valueAsBytes;
    }

    @GetMapping(value = "/test")
    public TransactionNotification String test(){
            return responseHandler.constructSucessResponse();
    }

}
