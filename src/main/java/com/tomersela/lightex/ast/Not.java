package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class Not extends UnaryOp {

    public Not(Exp expression, Token token) {
        super("!", expression, token);
    }

    @Override
    public ExpType type() {
        return ExpType.NOT;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
