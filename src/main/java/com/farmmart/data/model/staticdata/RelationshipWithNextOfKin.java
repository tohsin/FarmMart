package com.farmmart.data.model.staticdata;

public enum RelationshipWithNextOfKin {
    SPOUSE("Spouse"),
    BROTHER("Brother"),
    SISTER("Sister"),
    MOTHER("Mother"),
    FATHER("Father"),
    COUSIN("Cousin");

    private final String relationship;

    RelationshipWithNextOfKin(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public String toString() {
        return "RelationShip{" +
                "relationship='" + relationship + '\'' +
                '}';
    }
}
