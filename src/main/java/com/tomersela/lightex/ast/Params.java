package com.tomersela.lightex.ast;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Params {
    final private Exp[] expressions;

    public Params(Exp[] expressions) {
        this.expressions = expressions;
    }

    public Exp[] getExpressions() {
        return expressions;
    }

    @Override
    public String toString() {
        return "(" + Arrays.stream(expressions)
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + ")";
    }
}
