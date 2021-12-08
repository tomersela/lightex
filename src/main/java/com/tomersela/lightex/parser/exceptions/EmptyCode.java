package com.tomersela.lightex.parser.exceptions;

public class EmptyCode extends LightexParseException {

    public EmptyCode() {
        super("No code detected", 0, 0, 0, 0);
    }
}
