package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public abstract class UnaryOp implements Operator {
    private final String symbol;
    private final Exp expression;
    private final Token token;

    public UnaryOp(String symbol, Exp expression, Token token) {
        this.symbol = symbol;
        this.expression = expression;
        this.token = token;
    }

    public Exp getExpression() {
        return expression;
    }

    @Override
    public Token getToken() {
        return token;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol + expression;
    }
}
