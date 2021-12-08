package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class Val implements Exp {
    private final String name;
    private final Token token;

    public Val(String name, Token token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    @Override
    public ExpType type() {
        return ExpType.VAL;
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
        return "Val(" + name + ')';
    }
}
