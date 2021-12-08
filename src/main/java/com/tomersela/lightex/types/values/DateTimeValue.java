package com.tomersela.lightex.types.values;

import com.tomersela.lightex.types.ExpressionType;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.tomersela.lightex.types.ExpressionType.DATE_TIME;

public class DateTimeValue implements LightexValue {
    private LocalDateTime value;

    public DateTimeValue(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public ExpressionType type() {
        return DATE_TIME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTimeValue that = (DateTimeValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
