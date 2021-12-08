package com.tomersela.lightex.ast;

public enum ExpType {
    ADD("+"),
    AND("AND"),
    BOOL("<boolean>"),
    DIV("/"),
    EQUAL("="),
    FUNCTION_CALL("<function>"),
    GREATER(">"),
    GREATER_EQUAL(">="),
    LESS("<"),
    LESS_EQUAL("<="),
    MOD("%"),
    MUL("*"),
    NOT("!"),
    NOT_EQUAL("!="),
    NUM("<number>"),
    OR("OR"),
    PLACE_HOLDER("<place-holder>"),
    POW("^"),
    SUB("-"),
    TEXT("<text>"),
    UNARY_MINUS("-"),
    VAL("<value>"),
    ;

    private final String symbol;

    ExpType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
