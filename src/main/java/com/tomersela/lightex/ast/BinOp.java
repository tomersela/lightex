package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public abstract class BinOp implements Operator {
    final private String symbol;
    final private Exp left;
    final private Exp right;
    final private Token token;

    public BinOp(String symbol, Exp left, Exp right, Token token) {
        this.symbol = symbol;
        this.left = left;
        this.right = right;
        this.token = token;
    }

    public String getSymbol() {
        return symbol;
    }

    public Exp getLeft() {
        return left;
    }

    public Exp getRight() {
        return right;
    }

    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "(" + left + " " + symbol + " " + right + ')';
    }
}
