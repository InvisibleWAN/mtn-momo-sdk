package com.wit.sdk.openapi.service;

import com.wit.sdk.openapi.constants.OpenApiSdkConstants;
import com.wit.sdk.openapi.exchange.RequestToPay;

public interface CollectionSdk {

    Boolean requestToPay(OpenApiSdkConstants.Deployments deployments,String authorizationToken,String targetEnvironment, String referenceId, String subscriptionKey, String callBackUrl, RequestToPay requestToPay) throws RuntimeException;



}
