package com.tomersela.lightex.types;

import com.tomersela.lightex.parser.Token;

public class TypeCheckException extends RuntimeException {

    private final Token token;

    public TypeCheckException(String message, Token token) {
        super(message);
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
