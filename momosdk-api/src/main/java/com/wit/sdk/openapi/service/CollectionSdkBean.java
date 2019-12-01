package com.wit.sdk.openapi.service;

import com.google.common.base.Preconditions;
import com.wit.sdk.openapi.constants.OpenApiSdkConstants;
import com.wit.sdk.openapi.exchange.RequestToPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CollectionSdkBean implements CollectionSdk{

    @Autowired
    RestTemplate restTemplate;

    /**
     *
     * @param deployments
     * @param authorizationToken
     * @param targetEnvironment
     * @param referenceId
     * @param subscriptionKey
     * @param callBackUrl
     * @param requestToPay
     * @return
     * @throws RuntimeException
     */
    public Boolean requestToPay(OpenApiSdkConstants.Deployments deployments, String authorizationToken, String targetEnvironment, String referenceId, String subscriptionKey, String callBackUrl, RequestToPay requestToPay) throws RuntimeException {
        Preconditions.checkNotNull(deployments, "Deployment method should be SANDBOX or PRODUCTION");
        Preconditions.checkNotNull(referenceId, "Reference ID not found");
        Preconditions.checkNotNull(subscriptionKey, "Subscription Key not found");
        Preconditions.checkNotNull(targetEnvironment, "Target Environment ID not found");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Reference-Id", referenceId);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Ocp-Apim-Subscription-Key", subscriptionKey);
        if(authorizationToken != null) {
            httpHeaders.setBearerAuth(authorizationToken);
        }
        httpHeaders.set("X-Target-Environment",targetEnvironment);


        String url = null;
        if (deployments.equals(OpenApiSdkConstants.Deployments.SANDBOX)) {
            url = OpenApiSdkConstants.Urls.SANDBOX_URL.concat("/collection/v1_0/requesttopay");
        }

        if (deployments.equals(OpenApiSdkConstants.Deployments.PRODUCTION)) {
            url = OpenApiSdkConstants.Urls.PRODUCTION_URL.concat("/collection/v1_0/requesttopay");
        }
        Preconditions.checkNotNull(url, "Url not found");

        HttpEntity httpEntity = new HttpEntity(requestToPay, httpHeaders);
        ResponseEntity<Void> responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<Void>() {
        });
        return responseEntity.getStatusCode() == HttpStatus.CREATED;
    }
}
