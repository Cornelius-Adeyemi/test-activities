package org.example;

public class step4Dto {


    public step4Dto(){

    }


    private String secretKey;

    private String scheme = "";

    private String cardNumber="";

    private String expiry="";

    private String cvv="";

    private String cardHolder ="";

    private String mobile;

    private String pin="";


    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "step4Dto{" +
                "secretKey='" + secretKey + '\'' +
                ", scheme='" + scheme + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiry='" + expiry + '\'' +
                ", cvv='" + cvv + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
