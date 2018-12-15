package com.edpay.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

public enum IIErrorCodeDescription {
    
    INTERNAL_ERROR(1000,"Internal Error"),
    BAD_RESPONSE(1001,"Bad Response"),
    URL_EXPIRED(1002,"Url Expired"),
    
    //Others 5***
    NOT_FOUND_CONFIG(5001,"Config was not found"), 
    EMPTY_DATA(5002,"Post data annot be null"),
    
    // User error code 9***
    NOT_FOUND_USER(9012,"User not found"),
    INVALID_CREDENTIALS(9013,"Invalid Credentials"),
    EXIST_EMAIL(9014,"Existing Email"), 
    ENTITY_DOES_NOT_EXIST(9015,"Invalid Entity Name"), 
    USER_ROLE_REQUIRED(9017,"User Role Required"),
    PASSWORD_MISSMATCH(9018,"Password Missmatch"),
    USER_DISABLED(9019,"Inactive User"),
    ROLE_REQUIRED(9020,"Role Required"),
    ROLE_NOT_FOUND(9021,"Role not found"),
    EXCEEDED_USER_LIMIT(9022,"User limit exceeded"),
    USER_DETAILS_REQUIRED(9023,"User details required"),
    EMAIL_REQUIRED(9024,"Email is required"),
    EXISTING_USER(9025,"Existing user"),
    
    //CompanyHierarchy error codes 8***
    HIERARCHY_DOES_NOT_EXIST(8016,"Hierarchy does not exist"),
    COMPANY_DETAILS_REQUIRED(8017,"Company details required"), 
    INVALID_STRIPE_CUSTOMER(8018,"Unable to create stripe customer"), 
    PARENT_COMPANY_DOES_NOT_EXIST(8019,"Parent Company does not exist"),
    HIERARCHY_EXIST(8020,"Existing Company/Hierarchy"),
    STRIPE_KEY_REQUIRED(8021,"Stripe key cannot be null"), 
    EXISTING_INVITE_EMAIL(8022,"Existing invite email");
    
    
    private int errorCode;
    private String errorDescription;
    private static Map<Integer,IIErrorCodeDescription> errorCodes= new HashMap<>();

    private IIErrorCodeDescription(int code, String description) {
        this.errorCode = code;
        this.errorDescription = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public static IIErrorCodeDescription valueOf(int errorCode){
        return errorCodes.get(errorCode);
    }
    
    static{
        for(IIErrorCodeDescription errorCodeDescription:IIErrorCodeDescription.values()){
            errorCodes.put(errorCodeDescription.errorCode, errorCodeDescription);
        }
    }
    
}
