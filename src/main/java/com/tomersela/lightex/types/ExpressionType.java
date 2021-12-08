package com.tomersela.lightex.types;

public enum ExpressionType {
    TEXT("text"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    DATE("date"),
    DATE_TIME("date_time"),
    MONEY("money"),
    ARRAY("array"),
    ANY("<any>");

    private final String type;

    ExpressionType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
