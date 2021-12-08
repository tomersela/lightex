package com.tomersela.lightex.types.values;

import com.tomersela.lightex.types.ExpressionType;

import java.util.Objects;
import java.util.Optional;

public class TextValue implements LightexValue {

    private final String value;

    public TextValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Optional<LightexValue> unaryOp(String operator) {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public ExpressionType type() {
        return ExpressionType.TEXT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextValue textValue = (TextValue) o;
        return Objects.equals(value, textValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
