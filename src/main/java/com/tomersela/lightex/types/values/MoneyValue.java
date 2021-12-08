package com.tomersela.lightex.types.values;

import com.tomersela.lightex.types.ExpressionType;

import java.math.BigDecimal;
import java.util.Objects;

public class MoneyValue implements LightexValue {
    private final BigDecimal amount;
    private final String code;

    public MoneyValue(BigDecimal amount, String code) {
        this.amount = amount;
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyValue that = (MoneyValue) o;
        return Objects.equals(amount, that.amount) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, code);
    }

    @Override
    public String toString() {
        return code + amount;
    }

    @Override
    public ExpressionType type() {
        return ExpressionType.MONEY;
    }
}
