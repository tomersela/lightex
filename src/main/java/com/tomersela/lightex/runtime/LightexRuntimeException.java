package com.tomersela.lightex.runtime;

import com.tomersela.lightex.parser.Token;

import java.util.Optional;

public class LightexRuntimeException extends RuntimeException {

    private final Token token;

    public LightexRuntimeException(String message, Token token) {
        super(message);
        this.token = token;
    }

    public LightexRuntimeException(String message) {
        super(message);
        token = null;
    }

    public LightexRuntimeException withToken(Token token) {
        return new LightexRuntimeException(getMessage(), token);
    }

    public Optional<Token> getToken() {
        return Optional.ofNullable(token);
    }
}
