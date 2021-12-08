package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class PlaceHolder implements Exp {
    private final String id;
    private final Token token;

    public PlaceHolder(String id, Token token) {
        this.id = id;
        this.token = token;
    }

    @Override
    public ExpType type() {
        return ExpType.PLACE_HOLDER;
    }

    public Token getToken() {
        return token;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public static PlaceHolder fromWrapped(String wrapped, Token token) {
        return new PlaceHolder(wrapped.substring(2, wrapped.length() - 2), token);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{{" + id + "}}";
    }
}
