package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import static com.tomersela.lightex.ast.ExpType.EQUAL;

public class Equal extends BinOp {
    public Equal(Exp left, Exp right, Token token) {
        super("=", left, right, token);
    }

    @Override
    public ExpType type() {
        return EQUAL;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
