package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class Bool implements Exp {
    private final boolean bool;
    private final Token token;

    public Bool(boolean bool, Token token) {
        this.bool = bool;
        this.token = token;
    }

    public boolean getValue() {
        return bool;
    }

    @Override
    public ExpType type() {
        return ExpType.BOOL;
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
        return "Bool(" + bool + ')';
    }
}
