package com.tomersela.lightex.types.values;


import com.tomersela.lightex.types.ExpressionType;

import java.util.Objects;

import static com.tomersela.lightex.types.ExpressionType.BOOLEAN;

public class BooleanValue implements LightexValue {
    private final boolean value;

    public BooleanValue(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public ExpressionType type() {
        return BOOLEAN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooleanValue that = (BooleanValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
