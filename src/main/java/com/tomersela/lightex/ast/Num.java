package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import java.math.BigDecimal;

import static com.tomersela.lightex.ast.ExpType.NUM;

public class Num implements Exp {
    private final BigDecimal num;
    private final Token token;

    public Num(BigDecimal num, Token token) {
        this.num = num;
        this.token = token;
    }

    public BigDecimal getValue() {
        return num;
    }

    @Override
    public ExpType type() {
        return NUM;
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
        return "Num(" + num + ')';
    }
}
