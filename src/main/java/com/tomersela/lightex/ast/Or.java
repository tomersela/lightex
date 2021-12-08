package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class Or extends BinOp {
    public Or(Exp left, Exp right, Token token) {
        super(ExpType.OR.getSymbol(), left, right, token);
    }

    @Override
    public ExpType type() {
        return ExpType.OR;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
