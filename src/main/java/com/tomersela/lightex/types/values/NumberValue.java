package com.tomersela.lightex.types.values;

import com.tomersela.lightex.types.ExpressionType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

import static com.tomersela.lightex.types.ExpressionType.NUMBER;

public class NumberValue implements LightexValue {

    public static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

    private final BigDecimal value;

    public NumberValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public ExpressionType type() {
        return NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberValue that = (NumberValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
