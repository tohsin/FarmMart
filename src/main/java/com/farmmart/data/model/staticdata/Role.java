package com.farmmart.data.model.staticdata;

public enum Role {
    DEFAULT("Default Role"),
    CUSTOMER("Customer Role"),
    VENDOR("Supplier Role"),
    EMPLOYEE("Employee Role"),
    ADMIN("Admin Role"),
    MANAGER("Manager Role"),
    SUPER_ADMIN("Supper Admin Role"),
    GM("GM Role"),
    INTERN("Intern Role");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}
