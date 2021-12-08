package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class FunctionCall implements Exp {
    public final String name;
    public final Params params;
    private final Token token;

    public FunctionCall(String name, Params params, Token token) {
        this.name = name;
        this.params = params;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public Params getParams() {
        return params;
    }

    @Override
    public ExpType type() {
        return ExpType.FUNCTION_CALL;
    }

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return name + params;
    }
}
