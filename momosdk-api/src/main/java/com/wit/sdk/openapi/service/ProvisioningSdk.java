package com.wit.sdk.openapi.service;

import com.wit.sdk.openapi.constants.OpenApiSdkConstants;
import com.wit.sdk.openapi.exchange.ApiKey;
import com.wit.sdk.openapi.exchange.CreateApiUser;

public interface ProvisioningSdk {

    Boolean createApiUser(OpenApiSdkConstants.Deployments deployments,String referenceId, String subscriptionKey, CreateApiUser createApiUser) throws RuntimeException;

    Boolean getApiUser(OpenApiSdkConstants.Deployments deployments,String referenceId,String subscriptionKey) throws RuntimeException;

    ApiKey createApiUserKey(OpenApiSdkConstants.Deployments deployments, String referenceId, String subscriptionKey) throws RuntimeException;

}