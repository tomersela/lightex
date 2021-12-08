package com.tomersela.lightex.types.values;

import com.tomersela.lightex.types.ExpressionType;

import java.util.Arrays;

import static com.tomersela.lightex.types.ExpressionType.ARRAY;

public class ArrayValue implements LightexValue {

    private final LightexValue[] values;

    public ArrayValue(LightexValue[] values) {
        this.values = values;
    }

    public LightexValue[] getValues() {
        return values;
    }

    @Override
    public ExpressionType type() {
        return ARRAY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayValue that = (ArrayValue) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
