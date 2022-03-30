package com.farmmart.data.model.staticdata;

public enum Facility {
    OWN("Own"),
    LEASE("Lease");

    private final String facility;

    Facility(String facility) {
        this.facility = facility;
    }

    public String getFacility() {
        return facility;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "facility='" + facility + '\'' +
                '}';
    }
}
