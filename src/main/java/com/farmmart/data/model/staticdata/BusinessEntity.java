package com.farmmart.data.model.staticdata;

public enum BusinessEntity {

    BUSINESS("Business"),
    INDIVIDUAL("Individual");

    private final String businessEntity;

    BusinessEntity(String businessEntity) {
        this.businessEntity = businessEntity;
    }

    public String getBusinessEntity() {
        return businessEntity;
    }

    @Override
    public String toString() {
        return "BusinessEntity{" +
                "businessEntity='" + businessEntity + '\'' +
                '}';
    }
}
