package com.tomersela.lightex.types.values;

import com.tomersela.lightex.types.ExpressionType;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateValue implements LightexValue {
    private final LocalDateTime value;

    public DateValue(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public ExpressionType type() {
        return ExpressionType.DATE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateValue dateValue = (DateValue) o;
        return Objects.equals(value, dateValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
