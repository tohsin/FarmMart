package com.farmmart.data.model.staticdata;

public enum MeansOfIdentification {
    NIN("National Identification Number"),
    DRIVERS_LICENSE("Drivers License"),
    VOTERS_CARD("Voters Card"),
    INTERNATIONAL_PASSPORT("International Passport");

    private final String meanOfIdentification;

    MeansOfIdentification(String meanOfIdentification) {
        this.meanOfIdentification = meanOfIdentification;
    }

    public String getMeanOfIdentification() {
        return meanOfIdentification;
    }

    @Override
    public String toString() {
        return "MeansOfIdentification{" +
                "meanOfIdentification='" + meanOfIdentification + '\'' +
                '}';
    }
}
