package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import static com.tomersela.lightex.ast.ExpType.LESS_EQUAL;

public class LessEqual extends BinOp {
    public LessEqual(Exp left, Exp right, Token token) {
        super("<=", left, right, token);
    }

    @Override
    public ExpType type() {
        return LESS_EQUAL;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
