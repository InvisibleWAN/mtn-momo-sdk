package com.wit.sdk.openapi.service;

import com.google.common.base.Preconditions;
import com.wit.sdk.openapi.constants.OpenApiSdkConstants;
import com.wit.sdk.openapi.exchange.ApiKey;
import com.wit.sdk.openapi.exchange.CreateApiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenApiSdkBean implements OpenApiSdk {

    @Autowired
    RestTemplate restTemplate;

    /**
     *
     * @param deployments
     * @param referenceId
     * @param subscriptionKey
     * @param createApiUser
     * @return
     * @throws RuntimeException
     */
    public Boolean createApiUser(OpenApiSdkConstants.Deployments deployments, String referenceId, String subscriptionKey, CreateApiUser createApiUser) throws RuntimeException {
        Preconditions.checkNotNull(deployments, "Deployment method should be SANDBOX or PRODUCTION");
        Preconditions.checkNotNull(referenceId, "Reference ID not found");
        Preconditions.checkNotNull(subscriptionKey, "Subscription Key not found");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Reference-Id", referenceId);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Ocp-Apim-Subscription-Key", subscriptionKey);

        String url = null;
        if (deployments.equals(OpenApiSdkConstants.Deployments.SANDBOX)) {
            url = OpenApiSdkConstants.Urls.SANDBOX_URL.concat("/v1_0/apiuser");
        }

        if (deployments.equals(OpenApiSdkConstants.Deployments.PRODUCTION)) {
            url = OpenApiSdkConstants.Urls.PRODUCTION_URL.concat("/v1_0/apiuser");
        }
        Preconditions.checkNotNull(url, "Url not found");

        HttpEntity httpEntity = new HttpEntity(createApiUser, httpHeaders);
        ResponseEntity<Void> responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<Void>() {
        });
        return responseEntity.getStatusCode() == HttpStatus.CREATED;
    }

    /**
     *
     * @param deployments
     * @param referenceId
     * @param subscriptionKey
     * @return
     * @throws RuntimeException
     */
    public Boolean getApiUser(OpenApiSdkConstants.Deployments deployments, String referenceId, String subscriptionKey) throws RuntimeException {
        Preconditions.checkNotNull(deployments, "Deployment method should be SANDBOX or PRODUCTION");
        Preconditions.checkNotNull(referenceId, "Reference ID not found");
        Preconditions.checkNotNull(subscriptionKey, "Subscription Key not found");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Ocp-Apim-Subscription-Key", subscriptionKey);

        String url = null;
        if (deployments.equals(OpenApiSdkConstants.Deployments.SANDBOX)) {
            url = OpenApiSdkConstants.Urls.SANDBOX_URL.concat("/v1_0/apiuser").concat("/").concat(referenceId);
        }

        if (deployments.equals(OpenApiSdkConstants.Deployments.PRODUCTION)) {
            url = OpenApiSdkConstants.Urls.PRODUCTION_URL.concat("/v1_0/apiuser").concat("/").concat(referenceId);
        }
        Preconditions.checkNotNull(url, "Url not found");

        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<Void> responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<Void>() {
        });
        return responseEntity.getStatusCode() == HttpStatus.OK;
    }

    /**
     *
     * @param deployments
     * @param referenceId
     * @param subscriptionKey
     * @return
     * @throws RuntimeException
     */
    public ApiKey createApiUserKey(OpenApiSdkConstants.Deployments deployments, String referenceId, String subscriptionKey) throws RuntimeException {
        Preconditions.checkNotNull(deployments, "Deployment method should be SANDBOX or PRODUCTION");
        Preconditions.checkNotNull(referenceId, "Reference ID not found");
        Preconditions.checkNotNull(subscriptionKey, "Subscription Key not found");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Ocp-Apim-Subscription-Key", subscriptionKey);

        String url = null;
        if (deployments.equals(OpenApiSdkConstants.Deployments.SANDBOX)) {
            url = OpenApiSdkConstants.Urls.SANDBOX_URL.concat("/v1_0/apiuser").concat("/").concat(referenceId).concat("/apikey");
        }

        if (deployments.equals(OpenApiSdkConstants.Deployments.PRODUCTION)) {
            url = OpenApiSdkConstants.Urls.PRODUCTION_URL.concat("/v1_0/apiuser").concat("/").concat(referenceId).concat("/apikey");
        }
        Preconditions.checkNotNull(url, "Url not found");

        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<ApiKey> responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<ApiKey>() {
        });
        Preconditions.checkArgument(responseEntity.getStatusCode() == HttpStatus.CREATED,"Error while fetching API keys");
        return responseEntity.getBody();
    }



}
