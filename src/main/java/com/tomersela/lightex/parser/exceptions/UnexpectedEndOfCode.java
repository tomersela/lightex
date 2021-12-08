package com.tomersela.lightex.parser.exceptions;

public class UnexpectedEndOfCode extends LightexParseException {
    public UnexpectedEndOfCode(int beginLine, int beginColumn, int endLine, int endColumn) {
        super("Incomplete expression detected", beginLine, beginColumn, endLine, endColumn);
    }
}
