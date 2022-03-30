package com.farmmart.data.model.staticdata;

public enum UserType {
    CUSTOMER("Customer"),
    VENDOR("Vendor"),
    EMPLOYEE("Employee"),
    CONTRACTOR("Contractor");

    private final String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userType='" + userType + '\'' +
                '}';
    }
}
