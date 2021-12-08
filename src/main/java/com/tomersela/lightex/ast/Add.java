package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class Add extends BinOp {
    public Add(Exp left, Exp right, Token token) {
        super("+", left, right, token);
    }

    @Override
    public ExpType type() {
        return ExpType.ADD;
    }

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
