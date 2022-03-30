package com.farmmart.data.model.staticdata;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("INACTIVE"),
    RETIRED("Retired"),
    SUSPENDED("Suspended"),
    RESIGNED("Resigned"),
    SACKED("Sacked"),
    DELIVERED("Delivered"),
    RETURNED("Returned"),
    CANCELLED("Cancelled");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "SupplierStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}
