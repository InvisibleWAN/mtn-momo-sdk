package com.wit.sdk.openapi.service;

import com.wit.sdk.openapi.constants.OpenApiSdkConstants;
import com.wit.sdk.openapi.exchange.RequestToPay;
import com.wit.sdk.openapi.exchange.RequestToPayStatus;

public interface CollectionSdk {

    Boolean requestToPay(OpenApiSdkConstants.Deployments deployments,String authorizationToken,String targetEnvironment, String referenceId, String subscriptionKey, String callBackUrl, RequestToPay requestToPay) throws RuntimeException;

    RequestToPayStatus requestToPayStatus(OpenApiSdkConstants.Deployments deployments,String authorizationToken,String targetEnvironment, String referenceId, String subscriptionKey) throws RuntimeException;

}
