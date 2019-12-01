package com.wit.sdk.openapi.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class RequestToPay implements Serializable{

    @JsonProperty(required = true)
    private String amount;
    @JsonProperty(required = true)
    private String currency;
    @JsonProperty(required = true)
    private String externalId;
    @JsonProperty(required = true)
    private String payerMessage;
    @JsonProperty(required = true)
    private String payeeNote;
    @JsonProperty(required = true)
    private Payer payer;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPayerMessage() {
        return payerMessage;
    }

    public void setPayerMessage(String payerMessage) {
        this.payerMessage = payerMessage;
    }

    public String getPayeeNote() {
        return payeeNote;
    }

    public void setPayeeNote(String payeeNote) {
        this.payeeNote = payeeNote;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    private class Payer{

        private String partyId;
        private String partyIdType;


        public String getPartyId() {
            return partyId;
        }

        public void setPartyId(String partyId) {
            this.partyId = partyId;
        }

        public String getPartyIdType() {
            return partyIdType;
        }

        public void setPartyIdType(String partyIdType) {
            this.partyIdType = partyIdType;
        }
    }

}
