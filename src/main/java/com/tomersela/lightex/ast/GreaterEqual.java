package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class GreaterEqual extends BinOp {
    public GreaterEqual(Exp left, Exp right, Token token) {
        super(">=", left, right, token);
    }


    @Override
    public ExpType type() {
        return ExpType.GREATER_EQUAL;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
