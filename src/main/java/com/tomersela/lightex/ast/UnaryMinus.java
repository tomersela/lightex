package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import static com.tomersela.lightex.ast.ExpType.UNARY_MINUS;

public class UnaryMinus extends UnaryOp {

    public UnaryMinus(Exp expression, Token token) {
        super("-", expression, token);
    }

    @Override
    public ExpType type() {
        return UNARY_MINUS;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
