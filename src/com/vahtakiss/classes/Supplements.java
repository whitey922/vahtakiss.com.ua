package com.vahtakiss.classes;

public enum Supplements {
    MILK("milk"),
    NUTS("nuts"),
    SYRUP_WITH_COCONUT("coconut syrup"),
    SYRUP_WITH_CHOCOLATE("chocolate syrup"),
    SYRUP_WITH_RASPBERRY("raspberry syrup"),
    SYRUP_WITH_CARAMEL("caramel syrup"),
    SYRUP_WITH_MINT("mint syrup"),
    NO_SYRUP("no syrup"),
    ZEPHYR("zephyr");

    private String description;

    Supplements(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
