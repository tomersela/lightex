package com.tomersela.lightex.parser.exceptions;

public class InvalidSymbol extends LightexParseException {
    private final String symbol;

    public InvalidSymbol(String symbol, int beginLine, int beginColumn, int endLine, int endColumn) {
        super("Invalid symbol " + symbol + " at line " + beginLine + ", column " + beginColumn,
                beginLine, beginColumn, endLine, endColumn);
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
