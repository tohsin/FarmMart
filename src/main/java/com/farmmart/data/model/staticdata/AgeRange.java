package com.farmmart.data.model.staticdata;

public enum AgeRange {
    ZERO_TO_NINETEEN("0-19"),
    TWENTY_TO_THIRTY_NINE("20-39"),
    FORTY_TO_FIFTY_NINE("40-59"),
    SIXTY_TO_SEVENTY_NINE("60-79"),
    EIGHTY_TO_ONE_NINETY_NINE("80-99");

    private final String ageRange;

    AgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getAgeRange() {
        return ageRange;
    }

    @Override
    public String toString() {
        return "AgeRange{" +
                "ageRange='" + ageRange + '\'' +
                '}';
    }
}
