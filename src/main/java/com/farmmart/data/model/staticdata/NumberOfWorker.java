package com.farmmart.data.model.staticdata;

public enum NumberOfWorker {
    ZERO_TO_TEN("0-10"),
    ELEVEN_TO_TWENTY("11-20"),
    TWENTY_ONE_TO_THIRTY("21-30"),
    THIRTY_ONE_TO_FORTY("31-40"),
    FORTY_ONE_TO_FIFTY("41-50"),
    FIFTY_ONE_TO_SIXTY("51-60");

    private final String numberOfWorker;

    NumberOfWorker(String numberOfWorker) {
        this.numberOfWorker = numberOfWorker;
    }

    public String getNumberOfWorker() {
        return numberOfWorker;
    }

    @Override
    public String toString() {
        return "NumberOfWorker{" +
                "numberOfWorker='" + numberOfWorker + '\'' +
                '}';
    }
}
