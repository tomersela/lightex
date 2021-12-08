package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import static com.tomersela.lightex.ast.ExpType.SUB;

public class Sub extends BinOp {
    public Sub(Exp left, Exp right, Token token) {
        super("-", left, right, token);
    }

    @Override
    public ExpType type() {
        return SUB;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
