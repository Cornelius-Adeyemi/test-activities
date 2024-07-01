package org.example;

import java.util.Arrays;
import java.util.List;

public enum TestEnum {

    ADE("i love you"),BISI("i love you"), MATTHEW("This is my praise");

    private TestEnum(String name){
        this.name =name;
    };

    private String name;

    public String getName(){
       return this.name;
    }

    public static List<TestEnum> getAll(){
        return Arrays.asList(values());
    }

}

//public enum DocumentType {
//
//    IMAGE("image"),
//    ADDRESS_PROOF("address_proof"),
//    PASSPORT("passport"),
//    DRIVING_LICENSE("driving_license"),
//    VOTER_CARD("voter_card"),
//    NATIONAL_ID("national_id"),
//    CAC_REGISTRATION_CERTIFICATE("cac_registration_certificate"),
//    DISPUTE_DECLINE_EVIDENCE("dispute_decline_evidence");
//
//    private final String prettyName;
//    DocumentType(String prettyName){
//        this.prettyName = prettyName;
//    }
//
//    @Override
//    public String toString() {
//        return prettyName;
//    }
//
//    public static List<DocumentType> getAllDocType(){
//        return Arrays.asList(values());
//    }
//
//}
