package com.wit.sdk.openapi.service;

import com.wit.sdk.openapi.constants.OpenApiSdkConstants;
import com.wit.sdk.openapi.exchange.CreateApiUser;

public interface OpenApiSdk {

    Boolean createApiUser(OpenApiSdkConstants.Deployments deployments,String referenceId, String subscriptionKey, CreateApiUser createApiUser) throws RuntimeException;

    Boolean getApiUser(OpenApiSdkConstants.Deployments deployments,String referenceId,String subscriptionKey) throws RuntimeException;

}