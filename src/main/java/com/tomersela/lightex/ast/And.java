package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class And extends BinOp {
    public And(Exp left, Exp right, Token token) {
        super(ExpType.AND.getSymbol(), left, right, token);
    }

    @Override
    public ExpType type() {
        return ExpType.AND;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
