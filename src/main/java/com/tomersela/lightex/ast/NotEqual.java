package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class NotEqual extends BinOp {
    public NotEqual(Exp left, Exp right, Token token) {
        super("!=", left, right, token);
    }

    @Override
    public ExpType type() {
        return ExpType.NOT_EQUAL;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
