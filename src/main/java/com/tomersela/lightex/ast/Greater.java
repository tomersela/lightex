package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class Greater extends BinOp {
    public Greater(Exp left, Exp right, Token token) {
        super(">", left, right, token);
    }

    @Override
    public ExpType type() {
        return ExpType.GREATER;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
