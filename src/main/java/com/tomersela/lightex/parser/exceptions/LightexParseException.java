package com.tomersela.lightex.parser.exceptions;

public abstract class LightexParseException extends Exception {
    private final int beginLine;
    private final int beginColumn;
    private final int endLine;
    private final int endColumn;

    protected LightexParseException(String message, int beginLine, int beginColumn, int endLine, int endColumn) {
        super(message);
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public int getBeginLine() {
        return beginLine;
    }

    public int getBeginColumn() {
        return beginColumn;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getEndColumn() {
        return endColumn;
    }
}
