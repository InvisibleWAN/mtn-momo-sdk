package com.wit.sdk.openapi.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class CreateApiUser implements Serializable{

    @JsonProperty(required = true)
    private String providerCallbackHost;

    public String getProviderCallbackHost() {
        return providerCallbackHost;
    }

    public void setProviderCallbackHost(String providerCallbackHost) {
        this.providerCallbackHost = providerCallbackHost;
    }
}
